package com.nautiDevelopers.Todo.RESTControllers;

import com.nautiDevelopers.Todo.Entity.Todo;
import com.nautiDevelopers.Todo.Service.TodoServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/todo")
public class TodoREST {

    @Autowired
    private TodoServiceImplementation DAO;

    public TodoREST(TodoServiceImplementation x) {
        DAO = x;
    }

    //Basic Authorization Check
    @GetMapping("/basicauth")
    public String basicAuthCheck() {
        return "Success";
    }

    //To Save Data

    @PostMapping("/addTodos")
    public void addTodo(@RequestBody Todo todos)
    {
        DAO.save(todos);
        //NOTE: USE Postman and change the method to POST.
    }

    //Find All
    @GetMapping("/users/todoList")
    public List<Todo> findAll() {
        return DAO.findAll();
    }

    // To get user by ID Name
    @GetMapping("/users/todoList/{id}")
    public Optional<Todo> findById(@PathVariable int id) {
        return DAO.findById(id);
    }

    @DeleteMapping("/users/todoList/{id}")
    public void deleteTodo(@PathVariable int id) {
        DAO.deleteById(id);
    }

    @PutMapping("/users/todoList/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable int id, @RequestBody Todo updatedTodo) {
        Optional<Todo> optionalTodo = DAO.findById(id);

        if (optionalTodo.isPresent()) {
            Todo existingTodo = optionalTodo.get();
            existingTodo.setDescription(updatedTodo.getDescription());
            existingTodo.setDeadline(updatedTodo.getDeadline());
            existingTodo.setDone(updatedTodo.isDone());
            DAO.save(existingTodo);
            return ResponseEntity.ok(existingTodo);
        } else {
            return ResponseEntity.notFound().build();
        }

        //NOTE: USE Postman and change the method to PUT.
    }
}

//To get all the users

// http://localhost:8080/todo/users/todoList

// To get user by ID name

// localhost:8080/todo/users/todoList/1

//To Add Todolist [Post]

//localhost:8080/todo/addTodos

//To Delete By ID

//localhost:8080/todo/users/todoList/5
