package com.upc.FOODSAVERBACKEND.Model.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrdenDto implements Serializable {
    private Long Id;
    private Long restauranteId;
    private Long clienteId;

}
