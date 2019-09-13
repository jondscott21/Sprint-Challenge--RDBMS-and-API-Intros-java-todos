package com.lambdaschool.todos.controller;

import com.lambdaschool.todos.model.Todo;

import com.lambdaschool.todos.service.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/todos")
public class TodoController
{
    private TodoService todoService;

    @PutMapping(value = "/todo/{userid}")
    public ResponseEntity<?> updateTodo(@RequestBody
                                                Todo updateTodo, @PathVariable
                                                long userid)
    {
        todoService.update(updateTodo, userid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
