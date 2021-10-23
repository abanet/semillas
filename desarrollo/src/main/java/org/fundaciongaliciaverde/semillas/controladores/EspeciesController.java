package org.fundaciongaliciaverde.semillas.controladores;

import org.fundaciongaliciaverde.semillas.beans.PeticionEspecieBean;
import org.fundaciongaliciaverde.semillas.beans.RespuestaCreateEspecieBean;
import org.fundaciongaliciaverde.semillas.modelo.Especie;
import org.fundaciongaliciaverde.semillas.repositorio.EspecieRepositorio;
import org.fundaciongaliciaverde.semillas.servicios.EspecieServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/especies")
public class EspeciesController {

    @Autowired
    private EspecieRepositorio especieRepositorio;

    @Autowired
    private EspecieServicio especieServicio;

    @GetMapping("/listado")
    public ModelAndView listadoEspecies() {
        ModelAndView modelAndView = new ModelAndView("especies");
        return modelAndView;
    }

    @GetMapping("/especies")
    @ResponseBody
    public List<Especie> apiListadoEspecies() {
        var resultado = especieRepositorio.findAll();
        return especieRepositorio.findAll();
    }


    @PostMapping(value="/crear-especie")
    @ResponseBody
    public RespuestaCreateEspecieBean crearNuevaEspecie(@RequestBody PeticionEspecieBean datos) {
        RespuestaCreateEspecieBean respuesta = new RespuestaCreateEspecieBean();
        var mensajeRespuesta = "";
        var nombreNuevaEspecie = "";
        Especie nuevaEspecie = new Especie();
        if(datos.getData().size()==1) {
            nombreNuevaEspecie = datos.getData().get("0").getNombre();
            nuevaEspecie = especieServicio.crearNuevaEspecie(nombreNuevaEspecie);
        }
        var arrayData  = new ArrayList<Especie>();
        if (nuevaEspecie != null) {
            arrayData.add(nuevaEspecie);
        } else {
            mensajeRespuesta = "La especie ya existe en la base de datos o el nombre introducido no es válido.";
        }

        respuesta.setData(arrayData);
        respuesta.setError(mensajeRespuesta);
        return respuesta;
    }

    @PostMapping(value="/editar-especie")
    @ResponseBody
    public RespuestaCreateEspecieBean editarEspecie(@RequestBody PeticionEspecieBean datos) {
        RespuestaCreateEspecieBean respuesta = new RespuestaCreateEspecieBean();
        var mensajeRespuesta = "";
        var idEspecie = Integer.valueOf(datos.getData().entrySet().iterator().next().getKey());
        var especie = especieRepositorio.findById(idEspecie);
        var arrayData  = new ArrayList<Especie>();
        if(especie.isPresent()) {
            especie.orElseThrow().setNombre(datos.getData().entrySet().iterator().next().getValue().getNombre());
            especieRepositorio.save(especie.get());
            arrayData.add(especie.get());
        } else {
            mensajeRespuesta = "No se ha podido actualizar.";
        }

        respuesta.setData(arrayData);
        respuesta.setError(mensajeRespuesta);
        return respuesta;
    }

    @PostMapping(value="/eliminar-especie")
    @ResponseBody
    public RespuestaCreateEspecieBean eliminarEspecie(@RequestBody PeticionEspecieBean datos) {
        RespuestaCreateEspecieBean respuesta = new RespuestaCreateEspecieBean();
        var idEspecie = Integer.valueOf(datos.getData().entrySet().iterator().next().getKey());
        var especie = especieRepositorio.findById(idEspecie);
        if(especie.isPresent()) {
           especieRepositorio.delete(especie.get());
        }
        return respuesta;
    }
}
