package com.ovsoftware.todo.usecase.storage;

import com.ovsoftware.todo.entity.ToDo;

import java.util.List;

public interface TodoItemsStorage {

    void saveNewTodoItem(ToDo toDo);

    List<ToDo> getAll();
}
