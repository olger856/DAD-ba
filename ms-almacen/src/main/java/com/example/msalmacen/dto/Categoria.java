package com.example.msalmacen.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Data
public class Categoria {
    private Integer id;
    private String nombre;
    private String descripcion;
}
