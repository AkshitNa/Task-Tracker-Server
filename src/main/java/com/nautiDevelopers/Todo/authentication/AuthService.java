package com.nautiDevelopers.Todo.authentication;

import com.nautiDevelopers.Todo.DTO.RegisterReq;
import com.nautiDevelopers.Todo.DTO.UserAuthReq;
import com.nautiDevelopers.Todo.DTO.UserAuthRes;
import com.nautiDevelopers.Todo.Entity.User;
import com.nautiDevelopers.Todo.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    public UserAuthRes register(RegisterReq req) {
        var user = User.builder()
                .username(req.getUsername())
                .password(passwordEncoder.encode(req.getPassword()))
                .build();

        try {
            User temp = repository.save(user);
            var jwtToken = jwtUtil.generateToken(user);
            return UserAuthRes.builder()
                    .success(true)
                    .message("New project added successfully")
                    .token(jwtToken)
                    .build();
        } catch (Exception e) {
            return UserAuthRes.builder()
                    .success(false)
                    .message("Project not added")
                    .token(null)
                    .build();
        }
    }

    public UserAuthRes authenticate(UserAuthReq req) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        req.getUsername(),
                        req.getPassword()
                )
        );
        try {
        var user = repository.findByUsername(req.getUsername()).orElseThrow();
        var jwtToken = jwtUtil.generateToken(user);
        return UserAuthRes.builder()
                .message("Valid User")
                .success(true)
                .token(jwtToken)
                .build();
        } catch (Exception e) {
            return UserAuthRes.builder()
                    .message("Invalid User")
                    .success(false)
                    .token(null)
                    .build();
        }
    }
}

