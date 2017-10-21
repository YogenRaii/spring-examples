/**
 * 
 */
package com.eprogrammerz.examples.security.security.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * @author Yogen
 *
 */
public class JwtTokenMalformedException extends AuthenticationException {

	/**
	 * @param msg
	 */
	public JwtTokenMalformedException(String msg) {
		super(msg);
	}

}
