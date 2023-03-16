package com.ovsoftware.todo.usecase.createtodo;

import com.ovsoftware.todo.entity.TimeService;
import com.ovsoftware.todo.gateway.TodoItemsInMemoryStorage;
import com.ovsoftware.todo.usecase.gettodos.TestTimeService;
import com.ovsoftware.todo.usecase.storage.TodoItemsStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class CreateNewToDoUseCaseImplTest {

    CreateNewToDoUseCaseImpl useCase;
    TodoItemsStorage storage;

    TimeService timeService;

    @BeforeEach
    void setUp() {
        timeService = TestTimeService.of("1981-01-06T15:30:10Z");
        storage = new TodoItemsInMemoryStorage();
        useCase = new CreateNewToDoUseCaseImpl(storage, timeService);
    }

    @Test
    void addTodo() {

        useCase.exec(new CreateNewToDoInput("test todo"));

        var todo = storage.getAll().get(0);

        assertEquals("test todo", todo.getTodoText());
        assertNotNull(todo.getId());
    }

}
