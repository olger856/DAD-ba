package com.example.msalmacen.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "ms-provedor-service",path="/provedor")

public interface ProvedorFeign {
    @GetMapping("/{id}")
    public ResponseEntity<com.example.msalmacen.dto.Provedor> listById(@PathVariable(required = true) Integer id);
}
