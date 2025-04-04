package com.example.shoppinglist.repository;

import com.example.shoppinglist.model.Jogador;
import com.example.shoppinglist.model.Partida;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {
    Page<Partida> findAll(Pageable pageable);

    @Query("SELECT p FROM Partida p ORDER BY p.id DESC")
    List<Partida> findUltimosResultados();
}