package com.ovsoftware.todo.entity;

import java.time.Instant;
import java.util.Comparator;
import java.util.UUID;

public class ToDo {

    public static final Comparator<ToDo> ASC_COMPARATOR = Comparator.comparing(t -> t.creationTimestamp);
    public static final Comparator<ToDo> DESC_COMPARATOR = ASC_COMPARATOR.reversed();

    private final UUID id;
    private final Instant creationTimestamp;

    private String todoText;

    public ToDo(UUID id, String todo, TimeService timeService) {
        this.id = id;
        this.todoText = todo;
        this.creationTimestamp = timeService.now();
    }

    public ToDo(String todo, TimeService timeService) {
        this.id = UUID.randomUUID();
        this.todoText = todo;
        this.creationTimestamp = timeService.now();

    }

    public String getTodoText() {
        return todoText;
    }

    public void setTodoText(String todoText) {
        this.todoText = todoText;
    }

    public UUID getId() {
        return this.id;
    }
}
