package org.fundaciongaliciaverde.semillas.repositorio;

import org.fundaciongaliciaverde.semillas.modelo.FormasPlantacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FormaPlantacionRepositorio extends JpaRepository<FormasPlantacion, Integer> {
    List<FormasPlantacion> findAll();
    Optional<FormasPlantacion> findFormasPlantacionByDescripcion(String descripcion);
}
