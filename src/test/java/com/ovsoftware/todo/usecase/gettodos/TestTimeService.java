package com.ovsoftware.todo.usecase.gettodos;

import com.ovsoftware.todo.entity.TimeService;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class TestTimeService implements TimeService {
    private String now;

    public TestTimeService(String now) {
        this.now = now;
    }

    public static TestTimeService of(String now) {
        return new TestTimeService(now);
    }

    @Override
    public Instant now() {
        return Instant.parse(now);
    }
    

    public void plusMinutes(int minutes) {
        this.now = Instant.parse(now).plus(minutes, ChronoUnit.MINUTES).toString();
    }

    public void plusOneMinute() {
        plusMinutes(1);
    }


}
