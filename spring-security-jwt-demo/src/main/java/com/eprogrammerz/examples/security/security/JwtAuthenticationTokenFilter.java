package com.eprogrammerz.examples.security.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;

import com.eprogrammerz.examples.security.security.exception.JwtTokenMissingException;
import com.eprogrammerz.examples.security.security.model.JwtAuthenticationToken;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Yogen
 *
 */
@Slf4j
public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter {
	private static final String URL_PATTERN = "/api/([a-z0-9.]+)/(?!users)([a-zA-Z0-9]+)(/([a-z0-9-]+))*(\\?([a-zA-Z0-9]+)=(.+)(&([a-zA-Z0-9]+)=([a-z0-9]+))*)*";
	
	@Value("${jwt.header}")
	private String tokenHeader;
	
	public JwtAuthenticationTokenFilter() {
		super(new RegexRequestMatcher(URL_PATTERN, null, false));
	}
	

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		String header = request.getHeader(this.tokenHeader);
		
		String authKey = request.getParameter("key");
		
		String authToken = null;
		
		if (header != null && header.startsWith("Bearer ")) {
			authToken = header.substring(7);
        } else if( authKey != null) {
        	authToken = authKey;
        } else {
            throw new JwtTokenMissingException("No JWT token found in request headers");
        }
		
        JwtAuthenticationToken authRequest = new JwtAuthenticationToken(authToken);

        return getAuthenticationManager().authenticate(authRequest);

	}
	
	/**
     * Make sure the rest of the filterchain is satisfied
     *
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
            throws IOException, ServletException {
        super.successfulAuthentication(request, response, chain, authResult);

        log.info("Authenticated User: {}", authResult.getPrincipal());
        // As this authentication is in HTTP header, after success we need to continue the request normally
        // and return the response as if the resource was not secured at all
        chain.doFilter(request, response);
    }


}
