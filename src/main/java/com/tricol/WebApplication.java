package com.tricol;

import com.tricol.config.JpaConfig;
import com.tricol.config.WebConfig;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebApplication {

    public static void main(String[] args) throws LifecycleException {

        // Create Tomcat instance
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);
        tomcat.getConnector(); // Initialize connector

        // Set base directory
        String docBase = System.getProperty("java.io.tmpdir");

        // Create context with empty path
        Context context = tomcat.addContext("", docBase);

        // Create Spring context
        AnnotationConfigWebApplicationContext springContext =
                new AnnotationConfigWebApplicationContext();
        springContext.register(WebConfig.class, JpaConfig.class);

        // Create and configure DispatcherServlet
        DispatcherServlet dispatcherServlet = new DispatcherServlet(springContext);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);

        // Add servlet to Tomcat
        Tomcat.addServlet(context, "dispatcher", dispatcherServlet);
        context.addServletMappingDecoded("/*", "dispatcher"); // Map all URLs to dispatcher

        // Start server
        tomcat.start();

        System.out.println("========================================");
        System.out.println("✓ Server started successfully!");
        System.out.println("✓ URL: http://localhost:8080");
        System.out.println("✓ API Endpoints:");
        System.out.println("  - GET    http://localhost:8080/api/v1/fournisseurs");
        System.out.println("  - POST   http://localhost:8080/api/v1/fournisseurs");
        System.out.println("  - GET    http://localhost:8080/api/v1/fournisseurs/{id}");
        System.out.println("  - PUT    http://localhost:8080/api/v1/fournisseurs/{id}");
        System.out.println("  - DELETE http://localhost:8080/api/v1/fournisseurs/{id}");
        System.out.println("========================================");

        tomcat.getServer().await();
    }
}