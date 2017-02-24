package com.eprogrammerz.examples.controllers;

import com.eprogrammerz.examples.configuration.ApplicationConfiguration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by 542596 on 2/12/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = ApplicationConfiguration.class)
public class HomeControllerTest {
    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testIndexPage() throws Exception {
        HomeController homeController = new HomeController();
        MockMvc mockMvc = standaloneSetup(homeController).build();

        mockMvc.perform(get("/")).andExpect(view().name("index"));
    }

}