package com.upc.FOODSAVERBACKEND.Controller;

import com.upc.FOODSAVERBACKEND.Model.Entities.Plato;
import com.upc.FOODSAVERBACKEND.Service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Plato")
public class PlatoController {

    @Autowired
    private PlatoService platoService;

    @GetMapping ("/{id}")
    private ResponseEntity<Plato> listarPlatos (@PathVariable (value = "id")Long platoId){
        return new ResponseEntity<Plato>(platoService.listarPlatos(platoId), HttpStatus.OK);
    }

    @PostMapping("/Insertar")
    private ResponseEntity<Plato> insertarPlato (@RequestBody Plato platoDetalle){
        return new ResponseEntity<Plato>(platoService.insertarPlato(platoDetalle), HttpStatus.CREATED);
    }

    @DeleteMapping ("/Eliminar/{id}")
    private ResponseEntity<Plato> eliminarPlato (@PathVariable (value = "id")Long platoId){
        return new ResponseEntity<Plato>(platoService.eliminarPlato(platoId), HttpStatus.OK);
    }
}
