package com.tricol;

import com.tricol.service.FournisseurService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args ){

        //here to load the spring config
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        //asking spring to give us the FournisseurService
        FournisseurService service = context.getBean(FournisseurService.class);

        //here we're using the service
        String message = service.getMessage();
        System.out.println(message);
    }
}
