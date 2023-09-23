package com.upc.FOODSAVERBACKEND.Service;

import com.upc.FOODSAVERBACKEND.Model.Entities.Cliente;
import com.upc.FOODSAVERBACKEND.Repository.ClienteRepository;
import org.springdoc.api.OpenApiResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService {
    @Autowired
    ClienteRepository clienteRepository;

    public Cliente listarClientes(Long clienteId){
        return clienteRepository.findById(clienteId).orElseThrow(()->new OpenApiResourceNotFoundException("No existe el cliente con Id "+clienteId));
    }

    public Cliente buscarClientePorContrasena(String clienteContrasena){
        return clienteRepository.encontrarPorContrasena(clienteContrasena).orElseThrow(()->new OpenApiResourceNotFoundException("No existe cliente con esa contraseña "+clienteContrasena));
    }

    public Cliente insertarCliente(Cliente clienteDetalle) {
        return clienteRepository.save(clienteDetalle);
    }

    public Cliente actualizarCliente (Long clienteId, Cliente clienteDetalle){
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(()->new OpenApiResourceNotFoundException("No existe cliente con el Id "+clienteId));
            cliente.setNombre(clienteDetalle.getNombre());
            cliente.setCorreo(clienteDetalle.getCorreo());
            cliente.setContrasena(clienteDetalle.getContrasena());
            cliente.setTelefono(clienteDetalle.getTelefono());
            return clienteRepository.save(cliente);
    }

    public Cliente eliminarCliente (Long clienteId){
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(()->new OpenApiResourceNotFoundException("No existe cliente con el Id "+clienteId));
        clienteRepository.deleteById(clienteId);
        return cliente;
    }
}
