package com.upc.FOODSAVERBACKEND.Repository;

import com.upc.FOODSAVERBACKEND.Model.Entities.Orden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrdenRepository extends JpaRepository<Orden,Long> {
    @Query(value = "SELECT o.* FROM orden o JOIN Cliente c ON c.id=o.cliente_id WHERE c.id=:clienteId",nativeQuery = true)
    public List<Orden> buscarOrdenPorCliente(Long clienteId);
}
