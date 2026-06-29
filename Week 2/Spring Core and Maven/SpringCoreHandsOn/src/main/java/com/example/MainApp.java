package com.example;

import com.example.config.AppConfig;
import com.example.service.MessageService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MessageService service = context.getBean(MessageService.class);
        service.printMessage();
    }
}\n