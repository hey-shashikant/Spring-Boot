package com.example.demo.common;

import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Play baseball for 150 minutes";
    }
}
