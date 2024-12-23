package com.nautiDevelopers.Todo.Service;

import java.util.List;
import java.util.Optional;

import com.nautiDevelopers.Todo.Entity.Todo;
import com.nautiDevelopers.Todo.Repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoServiceImplementation implements TodoService {

    @Autowired
    TodoRepository todoRepository;
    TodoServiceImplementation(TodoRepository todoRepository)
    {
        this.todoRepository = todoRepository;
    }

    public void deleteById(int id) {
        todoRepository.deleteById(id);
    }

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @Override
    public Optional<Todo> findById(Integer id) {
        return todoRepository.findById(id);
    }

    public void save(Todo todos) {
        todoRepository.save(todos);
    }
}
