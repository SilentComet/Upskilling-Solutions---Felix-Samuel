package com.example.service;

import com.example.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    
    private MessageRepository repository;
    private String customMessage;

    // Constructor Injection
    @Autowired
    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    // Setter Injection
    @Autowired
    public void setCustomMessage(String customMessage) {
        this.customMessage = customMessage;
    }
    
    public void printMessage() {
        System.out.println(repository.getMessage());
    }
}\n