/**
 * 
 */
package com.eprogrammerz.examples.security.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Yogen
 *
 */
public class JwtTokenMissingException extends AuthenticationException {

	/**
	 * @param msg
	 */
	public JwtTokenMissingException(String msg) {
		super(msg);
	}

}
