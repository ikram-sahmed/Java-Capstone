package com.devmountain.sleepTracker.controllers;

import com.devmountain.sleepTracker.dtos.SleepDto;
import com.devmountain.sleepTracker.services.SleepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sleep")
public class SleepController {
    @Autowired
    private SleepService sleepService;

    @GetMapping("/user/{userId}")
    public List<SleepDto> getSleepByUser(@PathVariable Long userId){
        return sleepService.getAllSleepByUserId(userId);
    }
    @PostMapping("/user/{userId}")
    public void addSleep(@RequestBody SleepDto sleepDto,@PathVariable Long userId){
        sleepService.addSleep(sleepDto, userId);
    }

}
