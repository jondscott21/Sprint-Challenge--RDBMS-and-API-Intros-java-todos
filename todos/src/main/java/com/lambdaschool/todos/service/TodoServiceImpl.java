package com.lambdaschool.todos.service;

import com.lambdaschool.todos.model.Todo;
import com.lambdaschool.todos.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service(value = "todoService")
public class TodoServiceImpl implements TodoService
{
    @Autowired
    private TodoRepository todorepos;

    @Override
    public List<Todo> findAll()
    {
       List<Todo> list = new ArrayList<>();
       todorepos.findAll().iterator().forEachRemaining(list::add);
       return list;
    }

    @Override
    public Todo findTodoByName(String name)
    {
        return null;
    }

    @Override
    public Todo findTodoById(long id)
    {
        return null;
    }

    @Override
    public void delete(long id)
    {

    }

    @Transactional
    @Override
    public Todo save(Todo todo)
    {
        Todo newTodo = new Todo();
        newTodo.setDescription(todo.getDescription());
        newTodo.setDatestarted(todo.getDatestarted());
        newTodo.setUser(todo.getUser());
        return todorepos.save(newTodo);
    }

    @Override
    public Todo update(Todo todo, long id)
    {
        Todo currentTodo = todorepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
        if (todo.getDescription() != null)
        {
            currentTodo.setDescription(todo.getDescription());
        }
        if (todo.getDescription() != null)
        {
            currentTodo.setDatestarted(todo.getDatestarted());
        }
        if (todo.getDescription() != null)
        {
            currentTodo.setUser(todo.getUser());
        }
        return todorepos.save(currentTodo);
    }
}
