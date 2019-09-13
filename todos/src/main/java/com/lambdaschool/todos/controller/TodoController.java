package com.lambdaschool.todos.controller;

import com.lambdaschool.todos.model.Todo;

import com.lambdaschool.todos.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/todos")
public class TodoController
{
    @Autowired
    private TodoService todoService;

    @PutMapping(value = "/todoid/{todoid}")
    public ResponseEntity<?> updateTodo(@RequestBody
                                                Todo updateTodo, @PathVariable
                                                long todoid)
    {
        todoService.update(updateTodo, todoid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
