package org.fundaciongaliciaverde.semillas.servicios;

import org.fundaciongaliciaverde.semillas.modelo.Especie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EspecieServicio {


    /**
     * @param nombre Nombre de la nueva especie que vamos a crear si no existe
     * @return, el nombre de la especie creada o el mensaje por el que no se pudo crear.
     */
    Especie crearNuevaEspecie(String nombre);

}
