package com.ovsoftware.todo.usecase.gettodos;

import com.ovsoftware.todo.entity.ToDo;

import java.util.UUID;

public record ToDoResponse(UUID id, String toDo) {

    public static ToDoResponse from(ToDo toDo) {
        return new ToDoResponse(toDo.getId(), toDo.getTodoText());
    }


}
