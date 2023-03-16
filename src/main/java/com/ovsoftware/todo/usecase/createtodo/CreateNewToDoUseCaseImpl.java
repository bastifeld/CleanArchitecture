package com.ovsoftware.todo.usecase.createtodo;

import com.ovsoftware.todo.entity.TimeService;
import com.ovsoftware.todo.entity.ToDo;
import com.ovsoftware.todo.usecase.storage.TodoItemsStorage;
import lombok.extern.slf4j.Slf4j;

import java.util.UUID;

@Slf4j
public class CreateNewToDoUseCaseImpl implements CreateNewTodoUseCase {
    private final TodoItemsStorage storage;
    private final TimeService timeService;

    public CreateNewToDoUseCaseImpl(TodoItemsStorage storage, TimeService timeService) {
        this.storage = storage;
        this.timeService = timeService;
    }

    @Override
    public void exec(CreateNewToDoInput input) {
        log.info("add todo {}", input);
        storage.saveNewTodoItem(map(input));
    }

    private ToDo map(CreateNewToDoInput input) {
        return new ToDo(UUID.randomUUID(), input.input(), timeService);
    }
}
