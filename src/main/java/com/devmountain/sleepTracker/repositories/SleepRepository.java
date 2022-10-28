package com.devmountain.sleepTracker.repositories;

import com.devmountain.sleepTracker.entities.Sleep;
import com.devmountain.sleepTracker.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SleepRepository extends JpaRepository <Sleep, Long>{
    List<Sleep> findAllByUserEquals(User user);
}
