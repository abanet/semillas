package org.fundaciongaliciaverde.semillas.servicios;

import org.fundaciongaliciaverde.semillas.modelo.Especie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EspecieServicio {


    /**
     * @param nombre Nombre de la nueva especie que vamos a crear si no existe
     * @return, Nueva especie creada.
     */
    Especie crearNuevaEspecie(String nombre);

}
