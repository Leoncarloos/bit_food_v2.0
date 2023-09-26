package com.upc.FOODSAVERBACKEND.Service;

import com.upc.FOODSAVERBACKEND.Model.Dtos.RestauranteDto;
import com.upc.FOODSAVERBACKEND.Model.Entities.Cliente;
import com.upc.FOODSAVERBACKEND.Model.Entities.Plato;
import com.upc.FOODSAVERBACKEND.Model.Entities.Restaurante;
import com.upc.FOODSAVERBACKEND.Repository.PlatoRepository;
import com.upc.FOODSAVERBACKEND.Repository.RestauranteRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {
    @Autowired
    RestauranteRepository restauranteRepository;
    @Autowired
    PlatoRepository platoRepository;

    public List<Restaurante> listarRestaurantes(){
        return restauranteRepository.findAll();
    }

    public Restaurante listarRestaurantePorId(Long restauranteId){return restauranteRepository.findById(restauranteId).orElseThrow(()->new OpenApiResourceNotFoundException("No existe el restaurante con el Id "+restauranteId));}

    public Restaurante insertarRestaurante(RestauranteDto restauranteDetalles){
        Restaurante restaurante =new Restaurante();
        Plato plato;
        restaurante.setNombre(restauranteDetalles.getNombre());
        restaurante.setDescripcion(restauranteDetalles.getDescripcion());
        restaurante.setCantidad(restauranteDetalles.getCantidad());
        restaurante.setEstrellas(restauranteDetalles.getEstrellas());
        restaurante.setFecha(restauranteDetalles.getFecha());
        plato = platoRepository.findById(restauranteDetalles.getPlatoId()).orElseThrow(()->new OpenApiResourceNotFoundException("No se encontró el plato con el Id "+restauranteDetalles.getPlatoId()));
        restaurante.setPlato(plato);
        return restauranteRepository.save(restaurante);
    }

    public Restaurante actualizarRestaurante (Long restauranteId, Restaurante restauranteDetalle){
        Restaurante restaurante = restauranteRepository.findById(restauranteId).orElseThrow(()->new OpenApiResourceNotFoundException("No existe restaurante con el Id "+restauranteId));
        restaurante.setNombre(restauranteDetalle.getNombre());
        restaurante.setDescripcion(restauranteDetalle.getDescripcion());
        restaurante.setCantidad(restauranteDetalle.getCantidad());
        restaurante.setEstrellas(restauranteDetalle.getEstrellas());
        restaurante.setFecha(restauranteDetalle.getFecha());
        return restauranteRepository.save(restaurante);
    }
    public Restaurante eliminarRestaurante (Long restauranteId){
        Restaurante restaurante = restauranteRepository.findById(restauranteId).orElseThrow(()->new OpenApiResourceNotFoundException("No existe el restaurante con el Id "+restauranteId));
        restauranteRepository.deleteById(restauranteId);
        return restaurante;
    }

}
