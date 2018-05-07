package com.company.authentication.persistence;

import com.company.authentication.security.transfer.JwtUserDto;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Service
public class PersistenceServiceImpl implements PersistenceService {

    private Logger logger = Logger.getLogger(PersistenceServiceImpl.class.getName());

    @Override
    public JwtUserDto createJwtUserSession(JwtUserDto jwtUserDto) throws Exception {
        // todo: implemetare logica creazione jwt session
        // todo: una possibilita' e' integrarsi con mongodb cloud
        return jwtUserDto;
    }

    @Override
    public JwtUserDto getJwtUserSessionByRefreshToken(String refreshToken) throws Exception {
        // todo: implementare logica recupero jwtuser dal refresh_token
        return null;
    }

}
