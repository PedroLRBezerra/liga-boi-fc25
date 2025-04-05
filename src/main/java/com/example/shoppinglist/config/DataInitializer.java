package com.example.shoppinglist.config;

import com.example.shoppinglist.model.Role;
import com.example.shoppinglist.model.Usuario;
import com.example.shoppinglist.model.enums.Perfil;
import com.example.shoppinglist.repository.RoleRepository;
import com.example.shoppinglist.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class DataInitializer {

    /*@Bean
    public CommandLineRunner run(UsuarioRepository usuarioRepository, RoleRepository roleRepository) {
        return args -> {

            // Criação das roles baseadas no enum
            Role adminRole = new Role(Perfil.ADMIN);
            Role clienteRole = new Role(Perfil.CLIENTE);

            // Salvar as roles no banco (se ainda não existirem)
            roleRepository.save(adminRole);
            roleRepository.save(clienteRole);

            // Criação de um usuário admin com perfil de ADMIN
            Usuario admin = new Usuario("Admin", "admin@ligaboi.com.br", passwordEncoder().encode("admin"), Perfil.ADMIN);
            usuarioRepository.save(admin);

            // Criação de um usuário cliente com perfil de CLIENTE
            Usuario cliente = new Usuario("Usuario", "usuario@ligaboi.com.br", passwordEncoder().encode("usuario"), Perfil.CLIENTE);
            usuarioRepository.save(cliente);

        };
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/
}
