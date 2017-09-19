package com.eprogrammerz.examples.security.security.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.eprogrammerz.examples.security.security.model.JwtUserDto;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Yogen
 *
 */
@Slf4j
@Component
public class JwtTokenValidator {

	@Value("${jwt.secret}")
	private String secret;

	/**
	 * 
	 * @param token the JWT token to parse
	 * @return the User object extracted from specified token or null if a token
	 *         is invalid.
	 */
	public JwtUserDto parseToken(String token) {
		JwtUserDto u = null;

		try {
			Claims body = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

			u = new JwtUserDto((String) body.get("userId"), body.getSubject(), (String) body.get("role"));
			
		} catch (JwtException e) {
			// Simply print the exception and null will be returned for the
			// userDto
			log.error("Exception while parsing token : {}", e);
		}
		return u;
	}

}
