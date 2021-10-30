package org.fundaciongaliciaverde.semillas.controladores;

import org.fundaciongaliciaverde.semillas.beans.EspecieBean;
import org.fundaciongaliciaverde.semillas.beans.FormaPlantacionBean;
import org.fundaciongaliciaverde.semillas.beans.PeticionDatatableBean;
import org.fundaciongaliciaverde.semillas.beans.RespuestaDatatableBean;
import org.fundaciongaliciaverde.semillas.modelo.Especie;
import org.fundaciongaliciaverde.semillas.modelo.FormasPlantacion;
import org.fundaciongaliciaverde.semillas.repositorio.FormaPlantacionRepositorio;
import org.fundaciongaliciaverde.semillas.servicios.FormasPlantacionServicio;
import org.fundaciongaliciaverde.semillas.utilidades.ConversorEntityToBean;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FormasPlantacionController {

    @Autowired
    FormaPlantacionRepositorio formaPlantacionRepositorio;

    @Autowired
    FormasPlantacionServicio formasPlantacionServicio;

    @GetMapping("/listadoFormasPlantacion")
    public ModelAndView listadoEspecies() {
        ModelAndView modelAndView = new ModelAndView("formas-plantacion");
        return modelAndView;
    }

    @GetMapping("/formas-plantacion")
    @ResponseBody
    public List<FormaPlantacionBean> apiListadoFormasPlantacion() {
        var formas = formaPlantacionRepositorio.findAll();

        return ConversorEntityToBean.formaPlantacionListEntityToBean(formas);
    }

    @PostMapping(value="/crear-forma-plantacion")
    @ResponseBody
    public RespuestaDatatableBean<FormaPlantacionBean> crearNuevaEspecie(@RequestBody PeticionDatatableBean<FormaPlantacionBean> datos) {
        RespuestaDatatableBean<FormaPlantacionBean> respuesta = new RespuestaDatatableBean<>();
        var mensajeRespuesta = "";
        var nombreNuevaForma = "";
        FormasPlantacion nuevaForma = new FormasPlantacion();
        if(datos.getData().size()==1) {
            nombreNuevaForma = datos.getData().get("0").getDescripcion();
            nuevaForma = formasPlantacionServicio.crearNuevaFormaPlantacion(nombreNuevaForma);
        }
        var arrayData  = new ArrayList<FormaPlantacionBean>();
        if (nuevaForma != null) {
            ModelMapper modelMapper = new ModelMapper();
            FormaPlantacionBean formaPlantacionBean = modelMapper.map(nuevaForma, FormaPlantacionBean.class);
            arrayData.add(formaPlantacionBean);
        } else {
            mensajeRespuesta = "La forma de plantación ya existe en la base de datos o el nombre introducido no es válido.";
        }

        respuesta.setData(arrayData);
        respuesta.setError(mensajeRespuesta);
        return respuesta;
    }

    @PostMapping(value="/editar-forma-plantacion")
    @ResponseBody
    public RespuestaDatatableBean<FormaPlantacionBean> editarFormaPlantacion(@RequestBody PeticionDatatableBean<FormaPlantacionBean> datos) {
        RespuestaDatatableBean respuesta = new RespuestaDatatableBean();
        var mensajeRespuesta = "";
        var idForma = Integer.valueOf(datos.getData().entrySet().iterator().next().getKey());
        var forma = formaPlantacionRepositorio.findById(idForma);
        var arrayData  = new ArrayList<FormaPlantacionBean>();
        if(forma.isPresent()) {
            forma.orElseThrow().setDescripcion(datos.getData().entrySet().iterator().next().getValue().getDescripcion());
            formaPlantacionRepositorio.save(forma.get());
            arrayData.add(ConversorEntityToBean.formaPlantacionEntityToBean(forma.get()));
        } else {
            mensajeRespuesta = "No se ha podido actualizar.";
        }
        respuesta.setData(arrayData);
        respuesta.setError(mensajeRespuesta);
        return respuesta;
    }

    @PostMapping(value="/eliminar-forma-plantacion")
    @ResponseBody
    public RespuestaDatatableBean<FormaPlantacionBean> eliminarFormaPlantacion(@RequestBody PeticionDatatableBean<FormaPlantacionBean> datos) {
        RespuestaDatatableBean<FormaPlantacionBean> respuesta = new RespuestaDatatableBean<>();
        var idForma = Integer.valueOf(datos.getData().entrySet().iterator().next().getKey());
        var forma = formaPlantacionRepositorio.findById(idForma);
        if(forma.isPresent()) {
            formaPlantacionRepositorio.delete(forma.get());
        }
        return respuesta;
    }
}
