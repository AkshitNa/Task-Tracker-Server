package com.nautiDevelopers.Todo.RESTControllers;

import com.nautiDevelopers.Todo.authentication.AuthService;
import com.nautiDevelopers.Todo.DTO.RegisterReq;
import com.nautiDevelopers.Todo.DTO.UserAuthReq;
import com.nautiDevelopers.Todo.DTO.UserAuthRes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class JWTAuthenticationController {
    private final AuthService service;

    public JWTAuthenticationController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public ResponseEntity<UserAuthRes> register(@RequestBody RegisterReq req) {
        return ResponseEntity.ok(service.register(req));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<UserAuthRes> authenticate(@RequestBody UserAuthReq req) {
        return ResponseEntity.ok(service.authenticate(req));
    }
}

// http://localhost:8080/api/auth/register
// http://localhost:8080/api/auth/authenticate




