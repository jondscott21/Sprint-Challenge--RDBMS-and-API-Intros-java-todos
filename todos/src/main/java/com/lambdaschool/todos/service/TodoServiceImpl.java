package com.lambdaschool.todos.service;

import com.lambdaschool.todos.model.Todo;
import com.lambdaschool.todos.model.User;
import com.lambdaschool.todos.repository.TodoRepository;
import com.lambdaschool.todos.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Transactional
@Service(value = "todoService")
public class TodoServiceImpl implements TodoService
{

    @Autowired
    private TodoRepository todorepos;
    private UserRepository userrepos;

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
        return todorepos.save(todo);
    }

    @Override
    public Todo update(Todo todo, long id)
    {
        Todo currentTodo = todorepos.findById(id).orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
        if (todo.getDescription() != null)
        {
            currentTodo.setDescription(todo.getDescription());
        }
        if (todo.getDatestarted() != null)
        {
            currentTodo.setDatestarted(todo.getDatestarted());
        }
        if (todo.getUser() != null)
        {
            currentTodo.setUser(todo.getUser());
        }
        if (todo.isCompleted() != currentTodo.isCompleted())
        {
            currentTodo.setCompleted(todo.isCompleted());
        }
        return todorepos.save(currentTodo);
    }
}
