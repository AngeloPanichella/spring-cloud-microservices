package com.company.authentication.persistence;


import com.company.authentication.security.transfer.JwtUserDto;

public interface PersistenceService {

    JwtUserDto createJwtUserSession(JwtUserDto jwtUserDto) throws Exception;

    JwtUserDto getJwtUserSessionByRefreshToken(String refreshToken) throws Exception;

}
