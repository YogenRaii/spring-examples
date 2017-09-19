/**
 * 
 */
package com.eprogrammerz.examples.security.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Yogen
 *
 */
public class JwtTokenExpiredException extends AuthenticationException {

	/**
	 * @param msg
	 */
	public JwtTokenExpiredException(String msg) {
		super(msg);
	}

}
