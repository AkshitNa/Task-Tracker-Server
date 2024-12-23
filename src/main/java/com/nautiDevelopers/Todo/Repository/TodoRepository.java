package com.nautiDevelopers.Todo.Repository;

import com.nautiDevelopers.Todo.Entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

//    Todo Repository
}
