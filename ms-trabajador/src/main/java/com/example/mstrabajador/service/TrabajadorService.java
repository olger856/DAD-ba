package com.example.mstrabajador.service;

import com.example.mstrabajador.entity.Trabajador;

import java.util.List;
import java.util.Optional;

public interface TrabajadorService {
    public List<Trabajador> listar();

    public Trabajador guardar(Trabajador trabajador);

    public Trabajador actualizar(Trabajador trabajador);

    public Optional<Trabajador> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}
