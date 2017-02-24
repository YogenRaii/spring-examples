package com.eprogrammerz.examples.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by 542596 on 2/12/2017.
 *
 * Best way to initialize application context.
 */
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ApplicationConfiguration.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}

/**
 * can also be done this way

 public class ApplicationInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext container) throws ServletException {

        AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
        ctx.register(ApplicationConfiguration.class);
        ctx.setServletContext(container);

        ServletRegistration.Dynamic servlet = container.addServlet(
                "dispatcher", new DispatcherServlet(ctx));

        servlet.setLoadOnStartup(1);
        servlet.addMapping("/");
    }*/
