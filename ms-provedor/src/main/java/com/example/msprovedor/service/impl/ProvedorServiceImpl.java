package com.example.msprovedor.service.impl;

import com.example.msprovedor.entity.Provedor;
import com.example.msprovedor.repository.ProvedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProvedorServiceImpl {
    @Autowired
    private ProvedorRepository provedorRepository;

    @Override
    public List<Provedor> listar() {
        return provedorRepository.findAll();
    }

    @Override
    public Provedor guardar(Provedor provedor) {
        return provedorRepository.save(provedor);
    }

    @Override
    public Provedor actualizar(Provedor provedor) {
        return provedorRepository.save(provedor);
    }

    @Override
    public Optional<Provedor> listarPorId(Integer id) {
        return provedorRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        provedorRepository.deleteById(id);
    }
}
