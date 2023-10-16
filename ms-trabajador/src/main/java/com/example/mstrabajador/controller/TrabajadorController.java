package com.example.msTrabajador.controller;


import com.example.mstrabajador.entity.Trabajador;
import com.example.mstrabajador.service.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Trabajador")
public class TrabajadorController {
    @Autowired
    private TrabajadorService trabajadorService;

    @GetMapping()
    public ResponseEntity<List<Trabajador>> list() {
        return ResponseEntity.ok(trabajadorService.listar());
    }

    @PostMapping()
    public ResponseEntity<Trabajador> save(@RequestBody Trabajador trabajador) {
        return ResponseEntity.ok(trabajadorService.guardar(trabajador));
    }

    @PutMapping()
    public ResponseEntity<Trabajador> update(@RequestBody Trabajador trabajador) {
        return ResponseEntity.ok(trabajadorService.actualizar(trabajador));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trabajador> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(trabajadorService.listarPorId(id).get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Trabajador>> deleteById(@PathVariable(required = true) Integer id) {
        trabajadorService.eliminarPorId(id);
        return ResponseEntity.ok(trabajadorService.listar());
    }
}
