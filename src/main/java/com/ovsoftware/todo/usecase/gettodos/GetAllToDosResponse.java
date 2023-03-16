package com.ovsoftware.todo.usecase.gettodos;

import java.util.List;

public record GetAllToDosResponse(List<ToDoResponse> toDos) {
}
