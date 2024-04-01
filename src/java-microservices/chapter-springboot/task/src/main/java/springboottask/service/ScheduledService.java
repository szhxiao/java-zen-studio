/**
 * java-zen-studio
 *
 * @author szhxiao
 * @version 1st
 */

package springboottask.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
     // "0 * * * * MON-FRI" means once per minute on weekdays
     // (at the top of the minute - the 0th second).

    // @Scheduled(cron = "0 * * * * MON-SUN")
    // @Scheduled(cron = "0,1,2,3,4 * * * * MON-SUN")
    // @Scheduled(cron = "0-4 * * * * MON-SUN")
    @Scheduled(cron = "0/5 * * * * MON-SUN")
    public void hello() {
        System.out.println("hello...");
    }
}
