package com.eprogrammerz.examples.security.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.eprogrammerz.examples.security.security.exception.JwtTokenMalformedException;
import com.eprogrammerz.examples.security.security.model.AuthenticatedUser;
import com.eprogrammerz.examples.security.security.model.JwtAuthenticationToken;
import com.eprogrammerz.examples.security.security.model.JwtUserDto;
import com.eprogrammerz.examples.security.security.utils.JwtTokenValidator;


/**
 * @author Yogen
 *
 */
@Component
public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

	@Autowired
	private JwtTokenValidator jwtTokenValidator;
	
	@Autowired
	private UserDetailsService userService;
	
	@Override
    public boolean supports(Class<?> authentication) {
        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
    }

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
    	//no need implementation as no additional authentication is required
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
        String token = jwtAuthenticationToken.getToken();

        JwtUserDto parsedUser = jwtTokenValidator.parseToken(token);
        
        if (parsedUser == null) {
            throw new JwtTokenMalformedException("JWT token is not valid");
        }
        
        //validate against stored user
        /*Optional<User> userOptional = this.userService.findOne(parsedUser.getId());
        
        if(userOptional.isPresent()) {
        	User user = userOptional.get();
        	String usernameDB = user.getFirstName() + "-" + user.getLastName();
        	if(!user.getToken().equals(token) && !parsedUser.getUsername().equals(usernameDB)) {
        		throw new JwtTokenExpiredException("JWT Token expired.");
        	}
        } else {
        	throw new JwtUserNotFoundException("User with JWT token not found");
        }*/

        List<GrantedAuthority> authorityList = AuthorityUtils.commaSeparatedStringToAuthorityList(parsedUser.getRole());

        return new AuthenticatedUser(parsedUser.getId(), parsedUser.getUsername(), token, authorityList);
    }


}
