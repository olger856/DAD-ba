package com.example.msTrabajador.service.impl;

import com.example.msTrabajador.entity.Trabajador;
import com.example.msTrabajador.repository.TrabajadorRepository;
import com.example.msTrabajador.service.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrabajadorServiceImpl implements trabajadorService {
    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Override
    public List<Trabajador> listar() {
        return TrabajadorRepository.findAll();
    }

    @Override
    public Trabajador guardar(Trabajador trabajador) {
        return trabajadorRepository.save(Trabajador);
    }

    @Override
    public Trabajador actualizar(Trabajador trabajador) {
        return trabajadorRepository.save(Trabajador);
    }

    @Override
    public Optional<Trabajador> listarPorId(Integer id) {
        return trabajadorRepository.findById(id);
    }

    @Override
    public void eliminarPorId(Integer id) {
        trabajadorRepository.deleteById(id);
    }
}
