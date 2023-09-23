package com.upc.FOODSAVERBACKEND.Controller;

import com.upc.FOODSAVERBACKEND.Model.Entities.Cliente;
import com.upc.FOODSAVERBACKEND.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Cliente")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;
    @GetMapping ("/{id}")
    public ResponseEntity<Cliente> listarClientes(@PathVariable(value = "id") Long clienteId){
        return new ResponseEntity<Cliente>(clienteService.listarClientes(clienteId),HttpStatus.OK);
    }
    @GetMapping("/Buscar/{contrasena}")
    public ResponseEntity<Cliente> buscarClientePorContrasena(@PathVariable (value="contrasena")String clienteContrasena){
        return new ResponseEntity<Cliente>(clienteService.buscarClientePorContrasena(clienteContrasena),HttpStatus.OK);
    }
    @PostMapping("/Insertar")
    public ResponseEntity<Cliente> insertarCliente(@RequestBody Cliente cliente){
        return new ResponseEntity<Cliente>(clienteService.insertarCliente(cliente),HttpStatus.CREATED);
    }
    @PutMapping ("/Actualizar/{id}")
    public ResponseEntity<Cliente> actualizarCliente (@PathVariable(value = "id") Long clienteId, @RequestBody Cliente cliente){
        return new ResponseEntity<Cliente>(clienteService.actualizarCliente(clienteId, cliente),HttpStatus.OK);
    }
    @DeleteMapping("/Eliminar/{id}")
    public ResponseEntity<Cliente> eliminarCliente (@PathVariable(value = "id") Long clienteId){
        return new ResponseEntity<Cliente>(clienteService.eliminarCliente(clienteId),HttpStatus.OK);
    }
}
