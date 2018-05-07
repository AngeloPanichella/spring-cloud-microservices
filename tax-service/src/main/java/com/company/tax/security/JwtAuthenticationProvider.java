package com.company.tax.security;

import com.company.tax.api.FeignAuthenticationInterface;
import com.company.tax.model.AuthenticatedUser;
import com.company.tax.security.model.JwtAuthenticationToken;
import com.company.tax.security.model.JwtUserDto;
import com.company.tax.security.exception.JwtTokenMalformedException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    final static Logger logger = Logger.getLogger(JwtAuthenticationProvider.class);

    @Autowired
    private FeignAuthenticationInterface feignAuthenticationInterface;

    @Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
        String token = jwtAuthenticationToken.getToken();

        logger.debug("retrieveUser - username: " + username);
        logger.debug("retrieveUser - token: " + token);

        JwtUserDto parsedUser = null;

        try {
            parsedUser = feignAuthenticationInterface.user("Bearer " + token);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }

        if (parsedUser == null) {
            throw new JwtTokenMalformedException("JWT token is not valid");
        }

        List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(parsedUser.getRole());

        return new AuthenticatedUser(parsedUser.getEmail(), authorityList);
    }

}
