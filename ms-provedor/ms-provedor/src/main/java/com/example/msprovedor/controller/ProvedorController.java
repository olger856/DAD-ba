package com.example.msprovedor.controller;

import com.example.msprovedor.entity.Provedor;
import com.example.msprovedor.service.provedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/provedor")
public class ProvedorController {
    @Autowired
    private ProvedorControllerService provedorControllerService;

    @GetMapping()
    public ResponseEntity<List<Provedor>> list() {
        return ResponseEntity.ok(provedorService.listar());
    }

    @PostMapping()
    public ResponseEntity<Provedor> save(@RequestBody Provedor provedor) {
        return ResponseEntity.ok(provedorService.guardar(provedor));
    }

    @PutMapping()
    public ResponseEntity<Provedor> update(@RequestBody Provedor provedor) {
        return ResponseEntity.ok(provedorService.actualizar(provedor));
    }

    @CircuitBreaker(name = "provedorListarPorIdCB", fallbackMethod = "fallBackProvedorListarPorIdCB")
    @GetMapping("/{id}")
    public ResponseEntity<Provedor> listById(@PathVariable(required = true) Integer id) {
        return ResponseEntity.ok().body(provedorService.listarPorId(id).get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<List<Provedor>> deleteById(@PathVariable(required = true) Integer id) {
        provedorService.eliminarPorId(id);
        return ResponseEntity.ok(provedorService.listar());
    }

    private ResponseEntity<Provedor> fallBackProvedorListarPorIdCB(@PathVariable(required = true) Integer id, RuntimeException e) {
        Provedor provedor = new provedor();
        provedor.setId(90000);
        Provedor provedor = new Provedor();
        provedor.setId("no se encontro ningun id coinsidente");
        provedor.setNombre("Recurso no disponible del nombre del provedor");
        return ResponseEntity.ok().body(provedor);
    }
}
