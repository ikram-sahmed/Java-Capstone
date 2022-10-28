package com.devmountain.sleepTracker.services;

import com.devmountain.sleepTracker.dtos.SleepDto;
import com.devmountain.sleepTracker.entities.Sleep;
import com.devmountain.sleepTracker.entities.User;
import com.devmountain.sleepTracker.repositories.SleepRepository;
import com.devmountain.sleepTracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SleepServiceImpl implements SleepService {
    @Autowired
    private SleepRepository sleepRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public void addSleep(SleepDto sleepDto, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        Sleep sleep = new Sleep(sleepDto);
        userOptional.ifPresent(sleep::setUser);
        sleepRepository.saveAndFlush(sleep);
    }
    @Override
    public List<SleepDto> getAllSleepByUserId(Long userId) {
            Optional<User> userOptional =userRepository.findById(userId);
            if (userOptional.isPresent()) {
                List<Sleep> sleepList = sleepRepository.findAllByUserEquals(userOptional.get());
                return sleepList.stream().map(sleep -> new SleepDto(sleep)).collect(Collectors.toList());
            }
            return Collections.emptyList();
}}

