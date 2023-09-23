package com.upc.FOODSAVERBACKEND.Repository;

import com.upc.FOODSAVERBACKEND.Model.Entities.Restaurante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauranteRepository extends JpaRepository<Restaurante,Long> {
}
