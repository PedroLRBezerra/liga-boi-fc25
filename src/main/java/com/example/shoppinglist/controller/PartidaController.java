package com.example.shoppinglist.controller;

import com.example.shoppinglist.model.Partida;
import com.example.shoppinglist.service.JogadorService;
import com.example.shoppinglist.service.PartidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/partidas")
public class PartidaController {


    @Autowired
    private PartidaService partidaService;

    @Autowired
    private JogadorService jogadorService;



    @GetMapping
    public List<Partida> getAllPartidas() {
        return partidaService.findAll();
    }

    @PostMapping("/registrar")
    public void registrarPartida(@RequestBody Partida partida) {
        jogadorService.registrarPartida(partida);
    }

    @GetMapping("/resultados")
    public Page<Partida> getPartidasPaginadas(@RequestParam int page, @RequestParam int size) {
        return partidaService.findAll(page, size);
    }

    @GetMapping("/ultimos")
    public List<Partida> getUltimosResultados() {
        return partidaService.findUltimosResultados();
    }
}