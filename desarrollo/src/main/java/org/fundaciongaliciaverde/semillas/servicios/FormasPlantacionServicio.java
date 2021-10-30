package org.fundaciongaliciaverde.semillas.servicios;

import org.fundaciongaliciaverde.semillas.modelo.Especie;
import org.fundaciongaliciaverde.semillas.modelo.FormasPlantacion;
import org.springframework.stereotype.Service;

@Service
public interface FormasPlantacionServicio {

    /**
     * @param descripcion Descripción de la nueva forma de plantación.
     * @return, descripción o el mensaje por el que no se pudo crear.
     */
    FormasPlantacion crearNuevaFormaPlantacion(String descripcion);
}
