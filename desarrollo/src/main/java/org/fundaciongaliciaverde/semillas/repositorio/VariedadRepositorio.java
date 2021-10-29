package org.fundaciongaliciaverde.semillas.repositorio;

import org.fundaciongaliciaverde.semillas.modelo.Especie;
import org.fundaciongaliciaverde.semillas.modelo.Variedad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VariedadRepositorio extends JpaRepository<Variedad, Integer> {
    List<Variedad> findAll();
    Optional<Variedad> findByNombre(String nombre);
}
