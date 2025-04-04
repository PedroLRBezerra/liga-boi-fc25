package com.example.shoppinglist.service;

import com.example.shoppinglist.model.Jogador;
import com.example.shoppinglist.model.Partida;
import com.example.shoppinglist.repository.JogadorRepository;
import com.example.shoppinglist.repository.PartidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JogadorService {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private PartidaRepository partidaRepository;

    public List<String> getAllJogadorNomes() {
        return jogadorRepository.findAll().stream()
                .map(Jogador::getNome)
                .collect(Collectors.toList());
    }

    public void registrarPartida(Partida partida) {
        partidaRepository.save(partida);

        Optional<Jogador> jogador1 = Optional.ofNullable(jogadorRepository.findByNome(partida.getJogador1()));
        Optional<Jogador> jogador2 = Optional.ofNullable(jogadorRepository.findByNome(partida.getJogador2()));

        if (jogador1.isPresent() && jogador2.isPresent()) {
            int pontosJogador1 = jogador1.get().getPontos();
            int pontosJogador2 = jogador2.get().getPontos();

            if (partida.getPlacarJogador1() > partida.getPlacarJogador2()) {
                pontosJogador1 += 3;
            } else if (partida.getPlacarJogador1() < partida.getPlacarJogador2()) {
                pontosJogador2 += 3;
            } else {
                pontosJogador1 += 1;
                pontosJogador2 += 1;
            }

            jogador1.get().setPontos(pontosJogador1);
            jogador2.get().setPontos(pontosJogador2);

            jogadorRepository.save(jogador1.get());
            jogadorRepository.save(jogador2.get());
        }
    }

    public List<Jogador> findAllWithPoints() {
        return jogadorRepository.findAllWithPoints();
    }
}
