package com.upc.FOODSAVERBACKEND.Controller;

        import com.upc.FOODSAVERBACKEND.Model.Dtos.RestauranteDto;
        import com.upc.FOODSAVERBACKEND.Model.Entities.Restaurante;
        import com.upc.FOODSAVERBACKEND.Service.RestauranteService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;
        import java.util.List;


@RestController
@RequestMapping("/Restaurante")
public class RestauranteController {

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping("/Listar")
    public ResponseEntity<List<Restaurante>> listarRestaurantes(){
        return new ResponseEntity<List<Restaurante>>(restauranteService.listarRestaurantes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurante> listarRestaurantePorId(@PathVariable (value = "id")Long restauranteId){
        return new ResponseEntity<Restaurante>(restauranteService.listarRestaurantePorId(restauranteId),HttpStatus.OK);
    }

    @PostMapping("/Insertar")
    public ResponseEntity<Restaurante> insertarRestaurante(@RequestBody RestauranteDto restauranteDetalles){
        return new ResponseEntity<Restaurante>(restauranteService.insertarRestaurante(restauranteDetalles),HttpStatus.CREATED);
    }

}
