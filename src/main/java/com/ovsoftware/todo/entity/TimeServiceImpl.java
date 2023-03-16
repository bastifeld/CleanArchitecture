package com.ovsoftware.todo.entity;

import java.time.Instant;

public class TimeServiceImpl implements TimeService{
    @Override
    public Instant now() {
        return Instant.now();
    }
}
