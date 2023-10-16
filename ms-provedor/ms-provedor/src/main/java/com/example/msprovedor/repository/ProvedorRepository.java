package com.example.msprovedor.repository;

import com.example.mscliente.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvedorRepository extends JpaRepository<Provedor,Integer> {
}
