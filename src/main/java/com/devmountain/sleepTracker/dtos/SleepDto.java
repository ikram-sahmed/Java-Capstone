package com.devmountain.sleepTracker.dtos;

import com.devmountain.sleepTracker.entities.Sleep;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SleepDto implements Serializable {
    private Long sleepId;
    private Long hoursOfSleep;
    private Timestamp sleepTime;
    private Timestamp wakeUpTime;
    private UserDto userDto;

    public SleepDto(Sleep sleep){
        if (sleep.getSleepId() != null){
            this.sleepId = sleep.getSleepId();
        }
        if (sleep.getHoursOfSleep() != null){
            this.hoursOfSleep = sleep.getHoursOfSleep();
        }

       if (sleep.getSleepTime() != null) {
            this.sleepTime = sleep.getSleepTime();
     }
       if (sleep.getWakeUpTime() != null) {
          this.wakeUpTime = sleep.getWakeUpTime();
       }
   }
}
