package com.eprogrammerz.activiti.hiring.config;

import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class BeanConfiguration {
    @Bean
    CommandLineRunner init(final RuntimeService runtimeService,
                           final TaskService taskService) {
        return (strings) -> {
            Map<String, Object> variables = new HashMap<>();
            variables.put("applicantName", "Yogen Rai");
            variables.put("phoneNumber", "+1-641-980-8602");
            variables.put("email", "yogen.rai@eprogarmmerz.com");
            runtimeService.startProcessInstanceByKey("hireProcess", variables);
        };
    }

    @Bean
    InitializingBean usersAndGroupsInitializer(final IdentityService identityService) {
        return () -> {
            Group group = identityService.newGroup("user");
            group.setName("users");
            group.setType("security-role");
            identityService.saveGroup(group);

            User admin = identityService.newUser("admin");
            admin.setPassword("admin");
            identityService.saveUser(admin);
        };
    }
}
