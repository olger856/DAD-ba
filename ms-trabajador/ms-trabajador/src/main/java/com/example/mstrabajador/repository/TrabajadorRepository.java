package com.example.mstrabajador.repository;

import com.example.msTrabajador.entity.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabajadorRepository extends JpaRepository<Trabajador,Integer> {
}
