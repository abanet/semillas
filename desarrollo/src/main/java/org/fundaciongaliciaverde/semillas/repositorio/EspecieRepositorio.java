package org.fundaciongaliciaverde.semillas.repositorio;

import org.fundaciongaliciaverde.semillas.modelo.Especie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EspecieRepositorio extends JpaRepository<Especie, Integer> {

    List<Especie> findAll();
    Optional<Especie> findByNombre(String nombre);
}
