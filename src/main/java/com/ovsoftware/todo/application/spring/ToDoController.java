package com.ovsoftware.todo.application.spring;


import com.ovsoftware.todo.usecase.createtodo.CreateNewToDoInput;
import com.ovsoftware.todo.usecase.createtodo.CreateNewTodoUseCase;
import com.ovsoftware.todo.usecase.gettodos.GetAllToDosResponse;
import com.ovsoftware.todo.usecase.gettodos.GetAllToDosUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@Slf4j
public class ToDoController {
    private final CreateNewTodoUseCase createNewTodoUseCase;
    private final GetAllToDosUseCase getAllToDosUseCase;

    @Autowired
    public ToDoController(CreateNewTodoUseCase createNewTodoUseCase, GetAllToDosUseCase getAllToDosUseCase) {
        this.createNewTodoUseCase = createNewTodoUseCase;
        this.getAllToDosUseCase = getAllToDosUseCase;
    }

    @RequestMapping("/")
    public ModelAndView home() {
        return new ModelAndView(
            "home",
            Map.of("test", "test")
        );
    }


    @PostMapping("/addToDo")
    public ModelAndView addToDo(@RequestParam("todo") String todo) {

        createNewTodoUseCase.exec(new CreateNewToDoInput(todo));

        return items();
    }

    @RequestMapping("/items")
    public ModelAndView items() {
        GetAllToDosResponse todos = getAllToDosUseCase.exec();
        return new ModelAndView(
            "items",
            Map.of("toDoItems", todos.toDos(), "sddgdsfg", "1.1.1.1")
        );
    }

    @PatchMapping("/update/{id}")
    public ModelAndView update(@PathVariable("id") String id) {
        log.info("update id {}", id);
        GetAllToDosResponse todos = getAllToDosUseCase.exec();
        return new ModelAndView(
            "items",
            Map.of("toDoItems", todos.toDos(), "sddgdsfg", "1.1.1.1")
        );
    }
}
