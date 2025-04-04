package com.example.shoppinglist.controller;


import com.example.shoppinglist.model.Usuario;
import com.example.shoppinglist.model.dto.login.LoginRequestDTO;
import com.example.shoppinglist.model.dto.login.RegisterRequestDTO;
import com.example.shoppinglist.model.dto.login.ResponseDTO;
import com.example.shoppinglist.repository.UsuarioRepository;
import com.example.shoppinglist.security.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    @Autowired
    private  UsuarioRepository repository;

    @Autowired
    private  PasswordEncoder passwordEncoder;

    @Autowired
    private  JwtTokenProvider tokenService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO body) {
        try {
            Usuario user = repository.findByEmail(body.email())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            if (passwordEncoder.matches(body.senha(), user.getPassword())) {
                String token = this.tokenService.generateToken(user);
                return ResponseEntity.ok(new ResponseDTO(user.getNome(), token));
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred");
        }
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterRequestDTO body){
        Optional<Usuario> user = this.repository.findByEmail(body.email());

        if(user.isEmpty()) {
            Usuario newUser = new Usuario();
            newUser.setSenha(passwordEncoder.encode(body.senha()));
            newUser.setEmail(body.email());
            newUser.setNome(body.name());
            newUser.setPerfil(body.perfil());
            this.repository.save(newUser);

            String token = this.tokenService.generateToken(newUser);
            return ResponseEntity.ok(new ResponseDTO(newUser.getNome(), token));
        }
        return ResponseEntity.badRequest().build();
    }
}
