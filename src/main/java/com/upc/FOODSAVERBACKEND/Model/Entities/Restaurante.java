package com.upc.FOODSAVERBACKEND.Model.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "restaurante")
public class Restaurante {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne()
    @JoinColumn(name="idPlato")
    private Plato plato;
    private String nombre;
    private String descripcion;
    private Long cantidad;
    private Long estrellas;
    private String fecha;
}
