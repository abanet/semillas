package org.fundaciongaliciaverde.semillas.controladores;

import org.fundaciongaliciaverde.semillas.beans.EspecieBean;
import org.fundaciongaliciaverde.semillas.beans.PeticionDatatableBean;
import org.fundaciongaliciaverde.semillas.beans.RespuestaDatatableBean;
import org.fundaciongaliciaverde.semillas.modelo.Especie;
import org.fundaciongaliciaverde.semillas.repositorio.EspecieRepositorio;
import org.fundaciongaliciaverde.semillas.servicios.EspecieServicio;
import org.fundaciongaliciaverde.semillas.utilidades.ConversorEntityToBean;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<EspecieBean> apiListadoEspecies() {
        var especies = especieRepositorio.findAll();
        return ConversorEntityToBean.especieListEntityToBean(especies);
    }


    @PostMapping(value="/crear-especie")
    @ResponseBody
    public RespuestaDatatableBean<EspecieBean> crearNuevaEspecie(@RequestBody PeticionDatatableBean<EspecieBean> datos) {
        RespuestaDatatableBean<EspecieBean> respuesta = new RespuestaDatatableBean<>();
        var mensajeRespuesta = "";
        var nombreNuevaEspecie = "";
        Especie nuevaEspecie = new Especie();
        if(datos.getData().size()==1) {
            nombreNuevaEspecie = datos.getData().get("0").getNombre();
            nuevaEspecie = especieServicio.crearNuevaEspecie(nombreNuevaEspecie);
        }
        var arrayData  = new ArrayList<EspecieBean>();
        if (nuevaEspecie != null) {
            ModelMapper modelMapper = new ModelMapper();
            EspecieBean especieBean = modelMapper.map(nuevaEspecie, EspecieBean.class);
            arrayData.add(especieBean);
        } else {
            mensajeRespuesta = "La especie ya existe en la base de datos o el nombre introducido no es válido.";
        }

        respuesta.setData(arrayData);
        respuesta.setError(mensajeRespuesta);
        return respuesta;
    }

    @PostMapping(value="/editar-especie")
    @ResponseBody
    public RespuestaDatatableBean<EspecieBean> editarEspecie(@RequestBody PeticionDatatableBean<EspecieBean> datos) {
        RespuestaDatatableBean respuesta = new RespuestaDatatableBean();
        var mensajeRespuesta = "";
        var idEspecie = Integer.valueOf(datos.getData().entrySet().iterator().next().getKey());
        var especie = especieRepositorio.findById(idEspecie);
        var arrayData  = new ArrayList<EspecieBean>();
        if(especie.isPresent()) {
            especie.orElseThrow().setNombre(datos.getData().entrySet().iterator().next().getValue().getNombre());
            especieRepositorio.save(especie.get());
            arrayData.add(ConversorEntityToBean.especieEntityToBean(especie.get()));
        } else {
            mensajeRespuesta = "No se ha podido actualizar.";
        }
        respuesta.setData(arrayData);
        respuesta.setError(mensajeRespuesta);
        return respuesta;
    }

    @PostMapping(value="/eliminar-especie")
    @ResponseBody
    public RespuestaDatatableBean<EspecieBean> eliminarEspecie(@RequestBody PeticionDatatableBean<EspecieBean> datos) {
        RespuestaDatatableBean<EspecieBean> respuesta = new RespuestaDatatableBean<>();
        var idEspecie = Integer.valueOf(datos.getData().entrySet().iterator().next().getKey());
        var especie = especieRepositorio.findById(idEspecie);
        if(especie.isPresent()) {
           especieRepositorio.delete(especie.get());
        }
        return respuesta;
    }
}
