package com.upc.FOODSAVERBACKEND.Repository;

import com.upc.FOODSAVERBACKEND.Model.Entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    @Query(value = "SELECT * FROM Cliente p WHERE p.contrasena LIKE %?1%",nativeQuery = true)
    public Optional<Cliente> encontrarPorContrasena(String clienteNombre);
}
