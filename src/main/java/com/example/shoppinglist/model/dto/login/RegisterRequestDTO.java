package com.example.shoppinglist.model.dto.login;

import com.example.shoppinglist.model.enums.Perfil;

public record RegisterRequestDTO (String name, String email, String senha, Perfil perfil) {
}
