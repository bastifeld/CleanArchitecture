package com.ovsoftware.todo.application.spring;

import com.ovsoftware.todo.entity.TimeServiceImpl;
import com.ovsoftware.todo.entity.ToDo;
import com.ovsoftware.todo.gateway.TodoItemsInMemoryStorage;
import com.ovsoftware.todo.usecase.createtodo.CreateNewToDoUseCaseImpl;
import com.ovsoftware.todo.usecase.createtodo.CreateNewTodoUseCase;
import com.ovsoftware.todo.usecase.gettodos.GetAllToDosUseCase;
import com.ovsoftware.todo.usecase.gettodos.GetAllToDosUseCaseImpl;
import com.ovsoftware.todo.usecase.storage.TodoItemsStorage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class Config {

    @Bean
    public CreateNewTodoUseCase getAddToDoItemUseCase(TodoItemsStorage todoItemsStorage) {
        return new CreateNewToDoUseCaseImpl(todoItemsStorage, new TimeServiceImpl());
    }

    @Bean
    public GetAllToDosUseCase getGetAllToDosUseCase(TodoItemsStorage todoItemsStorage) {
        return new GetAllToDosUseCaseImpl(todoItemsStorage);
    }

    @Bean
    public TodoItemsStorage getTodoItemsStorage() {

        var storage = new TodoItemsInMemoryStorage();
        storage.saveNewTodoItem(new ToDo("test 1", new TimeServiceImpl()));
        storage.saveNewTodoItem(new ToDo("test 2", new TimeServiceImpl()));
        return storage;
    }
}
