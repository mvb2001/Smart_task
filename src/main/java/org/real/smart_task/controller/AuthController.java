package org.real.smart_task.controller;

import org.real.smart_task.Services.AuthService;
import org.real.smart_task.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user) {
        String token = authService.signup(user);
        return ResponseEntity.ok().body("JWT Token: " + token);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        String token = authService.login(user.getEmail(), user.getPassword());
        return ResponseEntity.ok().body("JWT Token: " + token);
    }
}
