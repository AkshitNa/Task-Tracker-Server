package com.nautiDevelopers.Todo.Service;
import com.nautiDevelopers.Todo.Entity.Todo;

import java.util.List;
import java.util.Optional;

public interface TodoService {

        void deleteById(int id);
        List<Todo> findAll();
        Optional<Todo> findById(Integer id);
}
