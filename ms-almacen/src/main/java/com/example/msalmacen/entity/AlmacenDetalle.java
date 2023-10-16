package com.example.msalmacen.entity;

import com.example.mspedido.dto.Producto;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AlmacenDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descripcion;
    private Double cantidad;
    private Double precio;
    private Integer productoId;
    @Transient
    private Producto producto;

    public AlmacenDetalle() {
        this.cantidad = (double) 0;
        this.precio = (double) 0;

    }
}
