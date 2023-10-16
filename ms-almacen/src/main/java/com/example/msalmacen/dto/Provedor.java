package com.example.msalmacen.dto;

import lombok.Data;


@Data
public class Provedor {
    private Integer id;
    private String nombre;
    private String apellido;
    private String dni;
    private String direccion;
    private Integer telefono;
    private String email;
}
