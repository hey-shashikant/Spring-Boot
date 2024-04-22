package com.example.demo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Play tennis for 120 minutes";
    }
}
