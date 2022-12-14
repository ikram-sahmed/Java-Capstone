package com.devmountain.sleepTracker.entities;


import com.devmountain.sleepTracker.dtos.SleepDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table (name = "Sleep")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Sleep {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sleepId;

    public Long getHoursOfSleep() {
        return hoursOfSleep;
    }

    public Long getSleepId() {
        return sleepId;
    }

    public void setSleepId(Long sleepId) {
        this.sleepId = sleepId;
    }

    public void setHoursOfSleep(Long hoursOfSleep) {
        this.hoursOfSleep = hoursOfSleep;
    }


    public Timestamp getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(Timestamp sleepTime) {
        this.sleepTime = sleepTime;
    }

    public Timestamp getWakeUpTime() {
        return wakeUpTime;
    }

    public void setWakeUpTime(Timestamp wakeUpTime) {
        this.wakeUpTime = wakeUpTime;
    }

    public Sleep(Long sleepId, Long hoursOfSleep, Timestamp sleepTime, Timestamp wakeUpTime) {
        this.sleepId = sleepId;
        this.hoursOfSleep = hoursOfSleep;
        this.sleepTime = sleepTime;
        this.wakeUpTime = wakeUpTime;
    }


    @Column
    private Long hoursOfSleep;


    @Column
    private Timestamp sleepTime;

    @Column
    private Timestamp wakeUpTime;


    @ManyToOne
    @JsonBackReference
    private User user;

    public Sleep(SleepDto sleepDto) {
        if (sleepDto.getSleepId() != null) {
            this.sleepId = sleepDto.getSleepId();
        }
        if (sleepDto.getHoursOfSleep() != null) {
            this.hoursOfSleep = sleepDto.getHoursOfSleep();
        }
        if (sleepDto.getSleepTime() != null) {
          this.sleepTime = sleepDto.getSleepTime();
       }
       if (sleepDto.getWakeUpTime() != null) {
          this.wakeUpTime = sleepDto.getWakeUpTime();
      }
    }
}

