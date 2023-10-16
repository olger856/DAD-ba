package com.example.msalmacen.dto;

import lombok.Data;

import java.util.Date;


@Data
public class Producto {
    private String nombre;
    private String descripcion;
    private Double precio;
    private String talla;
    private String color;
    private Integer cantidadEnStock;
    private Date fechaCreacion;
    private Date fechaModificacion;
    private Categoria categoria;
}
