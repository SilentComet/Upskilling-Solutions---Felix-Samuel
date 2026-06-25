package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingDemo {
    private static final Logger logger = LoggerFactory.getLogger(LoggingDemo.class);

    public void processTask() {
        logger.info("Processing task...");
        try {
            logger.warn("This is a warning message: Resource is low.");
            throw new RuntimeException("Simulated error");
        } catch (Exception e) {
            logger.error("An error occurred during processing: {}", e.getMessage(), e);
        }
    }

    public static void main(String[] args) {
        new LoggingDemo().processTask();
    }
}\n