package org.fundaciongaliciaverde.semillas.servicios;

import org.fundaciongaliciaverde.semillas.modelo.Especie;
import org.fundaciongaliciaverde.semillas.repositorio.EspecieRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EspecieServicioImpl implements  EspecieServicio{

    @Autowired
    private EspecieRepositorio especieRepositorio;

    @Override
    public Especie crearNuevaEspecie(String nombre) {
        var respuesta = "";
        if(!nombre.isBlank() && !nombre.isEmpty()) {
            if(!especieRepositorio.findByNombre(nombre).isPresent()){
                var nuevaEspecie = new Especie();
                nuevaEspecie.setNombre(nombre);
                especieRepositorio.save(nuevaEspecie);
                return nuevaEspecie;
            }
        }
        return null;
    }

}
