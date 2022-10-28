package com.devmountain.sleepTracker.services;

import com.devmountain.sleepTracker.dtos.SleepDto;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SleepService {
    @Transactional
    void addSleep(SleepDto sleepDto, Long userId);

    List<SleepDto> getAllSleepByUserId(Long userId);
}
