package com.example.shoppinglist.service;

import com.example.shoppinglist.model.Jogador;
import com.example.shoppinglist.model.Partida;
import com.example.shoppinglist.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidaService {
    @Autowired
    private PartidaRepository partidaRepository;

    public List<Partida> findAll() {
        return partidaRepository.findAll();
    }

    public Partida save(Partida partida) {
        return partidaRepository.save(partida);
    }

    public Page<Partida> findAll(int page, int size) {
        return partidaRepository.findAll(PageRequest.of(page, size));
    }

    public List<Partida> findUltimosResultados() {
        return partidaRepository.findUltimosResultados();
    }
}