package com.example.mstrabajador.repository;

import com.example.mstrabajador.entity.Trabajador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrabajadorRepository extends JpaRepository<Trabajador,Integer> {
}
