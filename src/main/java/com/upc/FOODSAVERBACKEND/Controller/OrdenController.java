package com.upc.FOODSAVERBACKEND.Controller;

import com.upc.FOODSAVERBACKEND.Model.Dtos.OrdenDto;
import com.upc.FOODSAVERBACKEND.Model.Entities.Cliente;
import com.upc.FOODSAVERBACKEND.Model.Entities.Orden;
import com.upc.FOODSAVERBACKEND.Model.Entities.Plato;
import com.upc.FOODSAVERBACKEND.Service.OrdenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Orden")
public class OrdenController {
    @Autowired
    private OrdenService ordenService;
    @GetMapping("/Listar")
    public ResponseEntity<List<Orden>> listarOrdenes(){
        return new ResponseEntity<List<Orden>>(ordenService.listarOrdenes(), HttpStatus.OK);
    }
    @GetMapping ("/BuscarPorCliente/{clienteId}")
    public ResponseEntity<List<Orden>> buscarOrdenPorCliente(@PathVariable (value = "clienteId") Long clienteId){
        return new ResponseEntity<List<Orden>>(ordenService.buscarOrdenPorCliente(clienteId),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Orden> buscarOrdenPorId(@PathVariable(value = "id")Long ordenId){
        return new ResponseEntity<Orden>(ordenService.buscarOrdenPorId(ordenId),HttpStatus.OK);
    }

    @PostMapping("/Insertar")
    public ResponseEntity<Orden> insertarOrden(@RequestBody OrdenDto ordenDetalles){
        return new ResponseEntity<Orden>(ordenService.insertarOrden(ordenDetalles),HttpStatus.CREATED);
    }
    /*@PutMapping("/Actualizar/{id}")
    public ResponseEntity<Orden> actualizarOrden (@PathVariable(value = "id") Long ordenId, @RequestBody Orden orden){
        return new ResponseEntity<Orden>(ordenService.actualizarOrden(ordenId, orden),HttpStatus.OK);
    }*/
    @DeleteMapping("/Eliminar/{id}")
    public ResponseEntity<Orden> eliminarOrden (@PathVariable(value = "id") Long ordenId){
        return new ResponseEntity<Orden>(ordenService.eliminarOrden(ordenId),HttpStatus.OK);
    }
}
