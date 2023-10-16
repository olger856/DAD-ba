package com.example.msprovedor.service;

import com.example.msProvedor.entity.Provedor;

import java.util.List;
import java.util.Optional;

public interface ProvedorService {
    public List<Provedor> listar();

    public Provedor guardar(Provedor provedor);

    public Provedor actualizar(Provedor provedor);

    public Optional<Provedor> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}
