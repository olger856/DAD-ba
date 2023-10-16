package com.example.msTrabajador.controller;

import com.example.msTrabajador.entity.Trabajador;
import com.example.msTrabajador.service.TrabajadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Trabajador")
public class TrabajadorController {
    @Autowired
    private TrabajadorService TrabajadorService;

    @GetMapping()
    public ResponseEntity<List<Trabajador>> list() {
        return ResponseEntity.ok(trabajadorService.listar());
    }

    @PostMapping()
    public ResponseEntity<Trabajador> save(@RequestBody Trabajador trabajador) {
        return ResponseEntity.ok(trabajadorService.guardar(Trabajador));
    }

    @PutMapping()
    public ResponseEntity<Trabajador> update(@RequestBody Trabajador trabajador) {
        return ResponseEntity.ok(trabajadorService.actualizar(Trabajador));
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
