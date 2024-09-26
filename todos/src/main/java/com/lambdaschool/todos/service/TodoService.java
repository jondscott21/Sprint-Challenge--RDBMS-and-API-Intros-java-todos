package com.lambdaschool.todos.service;

import com.lambdaschool.todos.model.Todo;

import java.util.List;

public interface TodoService
{
    List<Todo> findAll();

    Todo findTodoByName(String name);

    Todo findTodoById(long id);

    void delete(long id);

    Todo save(Todo todo);

    Todo update(Todo todo, long id);
}
