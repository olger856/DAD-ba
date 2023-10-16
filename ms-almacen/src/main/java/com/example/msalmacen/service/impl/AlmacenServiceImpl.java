package com.example.msalmacen.service.impl;

import com.example.msalmacen.dto.Producto;
import com.example.msalmacen.feign.ProductoFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlmacenServiceImpl implements com.example.msalmacen.service.AlmacenService {
    @Autowired
    private com.example.msalmacen.repository.AlmacenRepository almacenRepository;
    @Autowired
    private com.example.msalmacen.feign.ProvedorFeign provedorFeign;
    @Autowired
    private ProductoFeign productoFeign;

    @Override
    public List<com.example.msalmacen.entity.Almacen> listar() {
        return almacenRepository.findAll();
    }

    @Override
    public com.example.msalmacen.entity.Almacen guardar(com.example.msalmacen.entity.Almacen almacen) {
        return almacenRepository.save(almacen);
    }

    @Override
    public com.example.msalmacen.entity.Almacen actualizar(com.example.msalmacen.entity.Almacen almacen) {
        return almacenRepository.save(almacen);
    }

    @Override
    public Optional<com.example.msalmacen.entity.Almacen> listarPorId(Integer id) {
        com.example.msalmacen.entity.Almacen almacen = almacenRepository.findById(id).get();
        com.example.msalmacen.dto.Provedor provedor = provedorFeign.listById(almacen.getProvedorId()).getBody();
        List<com.example.msalmacen.entity.AlmacenDetalle> almacenDetalles = almacen.getAlmacenDetalles().stream().map(almacenDetalle -> {
            Producto producto = productoFeign.listById(almacenDetalle.getProductoId()).getBody();
            almacenDetalle.setProducto(producto);
            return almacenDetalle;
        }).collect(Collectors.toList());
        almacen.setAlmacenDetalles(almacenDetalles);
        almacen.setProvedor(provedor);
        return Optional.of(almacen);
    }

    @Override
    public void eliminarPorId(Integer id) {
        almacenRepository.deleteById(id);
    }
}
