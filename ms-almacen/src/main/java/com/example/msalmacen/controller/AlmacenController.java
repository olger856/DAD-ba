package com.example.msalmacen.controller;

import com.example.msalmacen.dto.Producto;
import com.example.msalmacen.entity.Almacen;
import com.example.msalmacen.service.AlmacenService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/almacen")
public class AlmacenController {
    @Autowired
    private AlmacenService almacenService;

    @GetMapping()
    public ResponseEntity<List<Almacen>> list() {
        return ResponseEntity.ok(almacenService.listar());
    }

    @PostMapping()
    public ResponseEntity<Almacen> save(@RequestBody Almacen almacen) {
        return ResponseEntity.ok(almacenService.guardar(almacen));
    }

    @PutMapping()
    public ResponseEntity<Almacen> update(@RequestBody Almacen almacen) {
        return ResponseEntity.ok(almacenService.actualizar(almacen));
    }
    @CircuitBreaker(name = "almacenListarPorIdCB", fallbackMethod = "fallBackAlmacenListarPorIdCB")
    @GetMapping("/{id}")
    public ResponseEntity<Almacen> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(almacenService.listarPorId(id).get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Almacen>> deleteById(@PathVariable(required = true) Integer id) {
        almacenService.eliminarPorId(id);
        return ResponseEntity.ok(almacenService.listar());
    }
    private ResponseEntity<Almacen> fallBackAlmacenListarPorIdCB(@PathVariable(required = true) Integer id, RuntimeException e) {
        Almacen almacen = new Almacen();
        almacen.setId(90000);
        Producto producto = new com.example.msalmacen.dto.Producto();
        producto.setNombre("Recurso no disponible del nombre del producto");
        producto.setCategoria("no se encontro la categoria");
        almacen.setProducto(producto);
        return ResponseEntity.ok().body(almacen);
    }

}
