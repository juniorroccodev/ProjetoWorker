package com.wolkersomar.repository;

import com.wolkersomar.models.Calc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalcRepository extends JpaRepository<Calc, Long> {}