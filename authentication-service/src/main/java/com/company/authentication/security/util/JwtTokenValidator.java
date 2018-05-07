package com.company.authentication.security.util;

import com.company.authentication.security.transfer.JwtUserDto;
import io.jsonwebtoken.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class JwtTokenValidator {

    final static Logger logger = Logger.getLogger(JwtTokenValidator.class);

    @Value("${jwt.secret}")
    private String secret;

    public JwtUserDto parseToken(String token) {

        Claims body = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        JwtUserDto u = new JwtUserDto();

        u.setEmail(body.getSubject());
        u.setRole((String) body.get("role"));

        return u;
    }
}
