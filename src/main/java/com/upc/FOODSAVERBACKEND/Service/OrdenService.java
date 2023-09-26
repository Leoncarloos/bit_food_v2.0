package com.upc.FOODSAVERBACKEND.Service;

import com.upc.FOODSAVERBACKEND.Model.Dtos.OrdenDto;
import com.upc.FOODSAVERBACKEND.Model.Entities.Cliente;
import com.upc.FOODSAVERBACKEND.Model.Entities.Plato;
import com.upc.FOODSAVERBACKEND.Model.Entities.Restaurante;
import com.upc.FOODSAVERBACKEND.Model.Entities.Orden;
import com.upc.FOODSAVERBACKEND.Repository.ClienteRepository;
import com.upc.FOODSAVERBACKEND.Repository.RestauranteRepository;
import com.upc.FOODSAVERBACKEND.Repository.OrdenRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class OrdenService {
    @Autowired
    OrdenRepository ordenRepository;
    @Autowired
    RestauranteRepository restauranteRepository;
    @Autowired
    ClienteRepository clienteRepository;


    public List<Orden> listarOrdenes(){return ordenRepository.findAll();}
    public List<Orden> buscarOrdenPorCliente(Long clienteId){return ordenRepository.buscarOrdenPorCliente(clienteId);}
    public Orden buscarOrdenPorId(Long ordenId){
        return ordenRepository.findById(ordenId).orElseThrow(()->new OpenApiResourceNotFoundException("No existe la orden con Id "+ordenId));
    }
    public Orden insertarOrden(OrdenDto ordenDetalles){
        Orden orden =new Orden();
        Restaurante restaurante;
        Cliente cliente;
        orden.setId(ordenDetalles.getId());
        restaurante = restauranteRepository.findById(ordenDetalles.getRestauranteId())
                .orElseThrow(()-> new OpenApiResourceNotFoundException("No existe el restaurante con el Id "+ordenDetalles.getRestauranteId()));
        cliente = clienteRepository.findById(ordenDetalles.getClienteId())
                .orElseThrow(()->new OpenApiResourceNotFoundException("No existe el cliente con el Id "+ordenDetalles.getClienteId()));
        orden.setCliente(cliente);
        orden.setRestaurante(restaurante);
        orden.setFecha(restaurante.getFecha());
        return ordenRepository.save(orden);
    }

    /*public Orden actualizarOrden (Long ordenId, Orden ordenDetalle){
        Orden orden = ordenRepository.findById(ordenId).orElseThrow(()->new OpenApiResourceNotFoundException("No existe la orden con el Id "+ordenId));
        orden.setCliente(ordenDetalle.getCliente());
        orden.setFecha(ordenDetalle.getFecha());
        return ordenRepository.save(orden);
    }*/
    public Orden eliminarOrden (Long ordenId){
        Orden orden = ordenRepository.findById(ordenId).orElseThrow(()->new OpenApiResourceNotFoundException("No existe la orden con Id "+ordenId));
        ordenRepository.deleteById(ordenId);
        return orden;
    }
}
