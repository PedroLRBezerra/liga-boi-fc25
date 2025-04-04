package com.example.shoppinglist.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Objects;


@AllArgsConstructor
@NoArgsConstructor
@Table(name = "partida")
@Entity
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String jogador1;
    private String jogador2;
    private int placarJogador1;
    private int placarJogador2;
    private String timeJogador1;
    private String timeJogador2;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJogador1() {
        return jogador1;
    }

    public void setJogador1(String jogador1) {
        this.jogador1 = jogador1;
    }

    public String getJogador2() {
        return jogador2;
    }

    public void setJogador2(String jogador2) {
        this.jogador2 = jogador2;
    }

    public int getPlacarJogador1() {
        return placarJogador1;
    }

    public void setPlacarJogador1(int placarJogador1) {
        this.placarJogador1 = placarJogador1;
    }

    public int getPlacarJogador2() {
        return placarJogador2;
    }

    public void setPlacarJogador2(int placarJogador2) {
        this.placarJogador2 = placarJogador2;
    }

    public String getTimeJogador1() {
        return timeJogador1;
    }

    public void setTimeJogador1(String timeJogador1) {
        this.timeJogador1 = timeJogador1;
    }

    public String getTimeJogador2() {
        return timeJogador2;
    }

    public void setTimeJogador2(String timeJogador2) {
        this.timeJogador2 = timeJogador2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partida partida = (Partida) o;
        return Objects.equals(id, partida.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}

