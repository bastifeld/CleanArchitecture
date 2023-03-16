package com.ovsoftware.todo.usecase.gettodos;

import com.ovsoftware.todo.entity.ToDo;
import com.ovsoftware.todo.gateway.TodoItemsInMemoryStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GetAllToDosUseCaseImplTest {

    GetAllToDosUseCaseImpl useCase;
    TodoItemsInMemoryStorage storage;

    TestTimeService timeService;

    private void saveTodo(String todo) {
        storage.saveNewTodoItem(new ToDo(todo, timeService));
    }

    @BeforeEach
    void setUp() {
        timeService = TestTimeService.of("1981-01-06T15:30:10Z");
        storage = new TodoItemsInMemoryStorage();
        useCase = new GetAllToDosUseCaseImpl(storage);
    }

    @Test
    void getAll() {
        saveTodo("test1");
        assertEquals(1, useCase.exec().toDos().size());
        assertEquals("test1", useCase.exec().toDos().get(0).toDo());
        assertNotNull(useCase.exec().toDos().get(0).id());

    }

    @Test
    void testSortOrder() {
        timeService.plusOneMinute();
        saveTodo("1");

        timeService.plusOneMinute();
        saveTodo("2");

        timeService.plusOneMinute();
        saveTodo("3");


        var todos = useCase.exec().toDos().stream().map(ToDoResponse::toDo).toList();

        assertEquals(List.of("3", "2", "1"), todos);

    }

}
