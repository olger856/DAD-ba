package com.example.msalmacen.service;

import java.util.List;
import java.util.Optional;

public interface AlmacenService {
    public List<com.example.msalmacen.entity.Almacen> listar();

    public com.example.msalmacen.entity.Almacen guardar(com.example.msalmacen.entity.Almacen almacen);

    public com.example.msalmacen.entity.Almacen actualizar(com.example.msalmacen.entity.Almacen almacen);

    public Optional<com.example.msalmacen.entity.Almacen> listarPorId(Integer id);

    public void eliminarPorId(Integer id);
}
