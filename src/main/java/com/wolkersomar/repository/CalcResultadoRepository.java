package com.wolkersomar.repository;

import com.wolkersomar.models.CalcResultado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CalcResultadoRepository extends JpaRepository<CalcResultado, Long> {

    @Query("select r from CalcResultado r where r.resultado = ?1")
    public Optional<CalcResultado> getResultado(Integer resultado);
}