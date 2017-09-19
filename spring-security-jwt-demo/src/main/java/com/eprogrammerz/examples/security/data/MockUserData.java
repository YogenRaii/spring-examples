package com.eprogrammerz.examples.security.data;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.eprogrammerz.examples.security.models.Role;
import com.eprogrammerz.examples.security.models.RoleType;
import com.eprogrammerz.examples.security.models.User;
import com.eprogrammerz.examples.security.repository.RoleRepository;
import com.eprogrammerz.examples.security.repository.UserRepository;

/**
 * @author Yogen
 *
 */
@Configuration
public class MockUserData implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		List<Role> roles = Arrays.asList(
				new Role(null, RoleType.ROLE_ADMIN),
				new Role(null, RoleType.ROLE_USER)
				);
		List<User> users = Arrays.asList(
				new User(null, "admin", "admin", "Yogen Rai", "ygn@gmail.com", Arrays.asList(roles.get(0))),
				new User(null, "user", "user", "John Dow", "john@gmail.com", Arrays.asList(roles.get(1)))
				);
		
		this.roleRepository.save(roles);
		
		this.userRepository.save(users);
	}

}
