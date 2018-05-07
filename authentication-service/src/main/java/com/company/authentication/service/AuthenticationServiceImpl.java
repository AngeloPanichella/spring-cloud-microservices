package com.company.authentication.service;

import com.company.authentication.api.FeignCustomerInterface;
import com.company.authentication.exception.GenericException;
import com.company.authentication.persistence.PersistenceService;
import com.company.authentication.security.exception.JwtAccountExpiredException;
import com.company.authentication.security.exception.JwtBadCredentialsException;
import com.company.authentication.security.model.Customer;
import com.company.authentication.security.transfer.JwtUserDto;
import com.company.authentication.security.util.JwtTokenGenerator;
import com.company.authentication.security.util.JwtTokenValidator;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.SignatureException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    final static Logger logger = Logger.getLogger(AuthenticationServiceImpl.class);

    @Autowired
    private FeignCustomerInterface feignCustomerInterface;

    @Autowired
    private JwtTokenValidator jwtTokenValidator;

    @Autowired
    private PersistenceService persistenceService;

    @Override
    public JwtUserDto login(Customer customer) throws Exception {
        JwtTokenGenerator jwtTokenGenerator = new JwtTokenGenerator();

        JwtUserDto jwtUserDto = null;

        try {
            jwtUserDto = new JwtUserDto();
            jwtUserDto.setRole("temporaryRole");
            jwtUserDto.setEmail(customer.getEmail());

            String tokenToCheckCustomer = "Bearer " + jwtTokenGenerator.generateToken(jwtUserDto, "company-secret-key", 2);
            jwtUserDto = feignCustomerInterface.getCustomerByUsernameAndPassword(tokenToCheckCustomer, customer.getEmail(), customer.getPassword());

//            jwtUserDto.setUsername(username);
            jwtUserDto.setRole("company_user");

            String access_token = jwtTokenGenerator.generateToken(jwtUserDto, "company-secret-key", 2);
            String refresh_token = jwtTokenGenerator.generateToken(jwtUserDto, "company-secret-key", 10);

            jwtUserDto.setAccess_token(access_token);
            jwtUserDto.setRefresh_token(refresh_token);

            persistenceService.createJwtUserSession(jwtUserDto);

            return jwtUserDto;
        } catch (Exception e) {
            logger.error("Auth exception", e);
            throw new GenericException(e.getMessage());
        }
    }

    @Override
    public JwtUserDto checkToken(String token) throws Exception {
        try {
            return jwtTokenValidator.parseToken(token);
        } catch (SignatureException sigEx) {
            logger.error(sigEx.getMessage());
            throw new JwtBadCredentialsException(sigEx.getMessage());
        } catch (ExpiredJwtException expEx) {
            logger.error(expEx);
            throw new JwtAccountExpiredException(expEx.getMessage());
        } catch (JwtException e) {
            logger.error(e.getMessage(), e);
            throw e;
        }
    }

    @Override
    public JwtUserDto refreshToken(String email, String refreshToken) throws Exception {

        try {
            logger.info("refresh token: " + refreshToken);

            JwtUserDto jwtUserDto = persistenceService.getJwtUserSessionByRefreshToken(refreshToken.replace("Bearer ", ""));

//            if (jwtUserDto == null) {
//                throw new RefreshTokenNotExistsException("Refresh token not exists exception");
//            }

            JwtTokenGenerator jwtTokenGenerator = new JwtTokenGenerator();

            jwtUserDto = new JwtUserDto();
            jwtUserDto.setEmail(email);
            jwtUserDto.setRole("company_user");

            String access_token = jwtTokenGenerator.generateToken(jwtUserDto, "company-secret-key", 2);
            String refresh_token = jwtTokenGenerator.generateToken(jwtUserDto, "company-secret-key", 10);

            jwtUserDto.setAccess_token(access_token);
            jwtUserDto.setRefresh_token(refresh_token);

            persistenceService.createJwtUserSession(jwtUserDto);

            return jwtUserDto;
        } catch (Exception e) {
            throw e;
        }
    }
}
