package com.example.mspedido.dto;

import lombok.Data;

import java.util.Date;


@Data
public class Producto {
    private Integer id;
    private String nombre;

    private String descripcion;
    private double precio;
    private String talla;
    private String color;
    private Integer cantidadEnStock;
    private Date fechaCreacion;
    private Date fechaModificacion;

    private Categoria categoria;
}
