package com.example.shoppinglist.controller;

import com.example.shoppinglist.model.Jogador;
import com.example.shoppinglist.model.Partida;
import com.example.shoppinglist.service.JogadorService;
import com.example.shoppinglist.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/jogadores")
public class JogadorController {

    @Autowired
    private JogadorService jogadorService;

    @Autowired
    private PartidaService partidaService;

    @GetMapping("/nomes")
    public List<String> getAllJogadorNomes() {
        return jogadorService.getAllJogadorNomes();
    }

    @GetMapping("/pontos")
    public List<Jogador> getJogadoresPontos() {
        return jogadorService.findAllWithPoints();
    }


}
