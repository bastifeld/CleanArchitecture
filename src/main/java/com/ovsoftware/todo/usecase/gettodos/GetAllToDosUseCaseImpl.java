package com.ovsoftware.todo.usecase.gettodos;

import com.ovsoftware.todo.entity.ToDo;
import com.ovsoftware.todo.usecase.storage.TodoItemsStorage;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class GetAllToDosUseCaseImpl implements GetAllToDosUseCase {

    private final TodoItemsStorage storage;

    public GetAllToDosUseCaseImpl(TodoItemsStorage storage) {
        this.storage = storage;
    }

    @Override
    public GetAllToDosResponse exec() {
        var toDos = storage
            .getAll()
            .stream()
            .sorted(ToDo.DESC_COMPARATOR)
            .map(ToDoResponse::from)
            .toList();

        log.info("found {} todos: {}", toDos.size(), toDos);
        return new GetAllToDosResponse(toDos);
    }


}
