package com.ovsoftware.todo.gateway;

import com.ovsoftware.todo.entity.ToDo;
import com.ovsoftware.todo.usecase.storage.TodoItemsStorage;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Slf4j
public class TodoItemsInMemoryStorage implements TodoItemsStorage {
    List<ToDo> toDos = new ArrayList<>();

    @Override
    public void saveNewTodoItem(ToDo toDo) {
        toDos.add(toDo);
    }

    @Override
    public List<ToDo> getAll() {
        log.info("todos {}", toDos);
        return Collections.unmodifiableList(toDos);
    }
}
