package com.company.authentication.security.util;

import com.company.authentication.security.transfer.JwtUserDto;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Calendar;
import java.util.Date;


public class JwtTokenGenerator {

    public static String generateToken(JwtUserDto u, String secret, int minutes) {

        Claims claims = Jwts.claims().setSubject(u.getEmail());
        claims.put("email", u.getEmail());
        claims.put("role", u.getRole());


        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.MINUTE, minutes);

        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, secret).setExpiration(cal.getTime())
                .compact();
    }
}
