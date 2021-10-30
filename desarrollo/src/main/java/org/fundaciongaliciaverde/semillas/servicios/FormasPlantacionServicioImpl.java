package org.fundaciongaliciaverde.semillas.servicios;

import org.fundaciongaliciaverde.semillas.modelo.Especie;
import org.fundaciongaliciaverde.semillas.modelo.FormasPlantacion;
import org.fundaciongaliciaverde.semillas.repositorio.FormaPlantacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormasPlantacionServicioImpl implements FormasPlantacionServicio {

    @Autowired
    FormaPlantacionRepositorio formaPlantacionRepositorio;


    @Override
    public FormasPlantacion crearNuevaFormaPlantacion(String descripcion) {
        if(!descripcion.isBlank() && !descripcion.isEmpty()) {
            if(!formaPlantacionRepositorio.findFormasPlantacionByDescripcion(descripcion).isPresent()){
                var nuevaForma = new FormasPlantacion();
                nuevaForma.setDescripcion(descripcion);
                formaPlantacionRepositorio.save(nuevaForma);
                return nuevaForma;
            }
        }
        return null;
    }
}

