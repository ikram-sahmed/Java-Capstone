package com.devmountain.sleepTracker.repositories;

import com.devmountain.sleepTracker.entities.Sleep;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SleepRepository extends JpaRepository <Sleep, Long{

}
