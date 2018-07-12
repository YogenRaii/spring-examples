package com.eprogrammerz.examples.spring.filterCustomFields;

import org.springframework.http.MediaType;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Modifier;
import java.util.List;

@RestController
public class UserController {
    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User getString(@RequestParam List<String> fields) {
        User user = new User("Yogen", 26, 3000.00f, "male");
        filterFields(user, fields);
        return user;
    }

    private void filterFields(User user, List<String> fields) {
        ReflectionUtils.doWithFields(User.class, field -> {
                    if (!fields.contains(field.getName())) {
                        field.setAccessible(true);
                        field.set(user, null);
                    }
                },
                field -> {
                    final int modifiers = field.getModifiers();
                    // no static fields please
                    return !Modifier.isStatic(modifiers);
                });
    }
}
