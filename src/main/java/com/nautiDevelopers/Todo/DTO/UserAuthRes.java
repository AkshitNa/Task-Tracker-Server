package com.nautiDevelopers.Todo.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class UserAuthRes {
    boolean success = false;
    String message;
    private String token;
}
