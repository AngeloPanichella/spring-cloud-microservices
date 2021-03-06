package com.company.authentication.security;

import com.company.authentication.security.exception.JwtTokenMissingException;
import com.company.authentication.security.model.JwtAuthenticationToken;
import org.apache.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {

    final static Logger logger = Logger.getLogger(JwtAuthenticationTokenFilter.class);

    public JwtAuthenticationTokenFilter() {
        super("/**");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {

        String header = request.getHeader("Authorization");

        logger.debug("token to check: " + header);
        logger.debug("request.getMethod(): " + request.getMethod());
        logger.debug("request.getRequestURL(): " + request.getRequestURL());

        if (header == null || !header.startsWith("Bearer ")) {
            throw new JwtTokenMissingException("No JWT token found in request headers");
        }

        String authToken = header.substring(7);

        JwtAuthenticationToken authRequest = new JwtAuthenticationToken(authToken);

        return getAuthenticationManager().authenticate(authRequest);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {

        logger.debug("successfulAuthentication...");

        super.successfulAuthentication(request, response, chain, authResult);

        chain.doFilter(request, response);
    }
}