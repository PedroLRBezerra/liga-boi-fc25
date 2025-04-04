package com.example.shoppinglist.repository;

import com.example.shoppinglist.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {

    <Optional>Jogador findByNome(String nome);

    @Query("SELECT j FROM Jogador j ORDER BY j.pontos DESC")
    List<Jogador> findAllWithPoints();
}
