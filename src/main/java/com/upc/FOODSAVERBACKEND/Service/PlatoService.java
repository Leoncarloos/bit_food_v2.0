package com.upc.FOODSAVERBACKEND.Service;

import com.upc.FOODSAVERBACKEND.Model.Entities.Plato;
import com.upc.FOODSAVERBACKEND.Repository.PlatoRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlatoService {
    @Autowired
    PlatoRepository platoRepository;

    public Plato listarPlatos(Long PlatoId){
        return platoRepository.findById(PlatoId)
                .orElseThrow(()->new OpenApiResourceNotFoundException("No existe el plato con el Id "+PlatoId));

    }

    public Plato insertarPlato (Plato platoDetalle){
        return platoRepository.save(platoDetalle);
    }

    public Plato eliminarPlato (Long platoId){
        Plato plato = platoRepository.findById(platoId)
                .orElseThrow(()->new OpenApiResourceNotFoundException("No existe el plato con Id "+platoId));
        platoRepository.deleteById(platoId);
        return plato;
    }

}
