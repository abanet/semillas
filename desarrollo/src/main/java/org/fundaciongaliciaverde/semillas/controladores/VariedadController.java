package org.fundaciongaliciaverde.semillas.controladores;

import org.fundaciongaliciaverde.semillas.beans.VariedadBean;
import org.fundaciongaliciaverde.semillas.modelo.Especie;
import org.fundaciongaliciaverde.semillas.modelo.Variedad;
import org.fundaciongaliciaverde.semillas.repositorio.VariedadRepositorio;
import org.fundaciongaliciaverde.semillas.servicios.VariedadServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/variedades")
public class VariedadController {

    @Autowired
    private VariedadServicio variedadServicio;


    @GetMapping("/listado")
    public ModelAndView listadoVariedades() {
        ModelAndView modelAndView = new ModelAndView("variedad");
        return modelAndView;
    }

    @GetMapping("/variedades")
    @ResponseBody
    public List<VariedadBean> apiListadoVariedades() {
        var resultado = variedadServicio.findAllVariedades();
        return resultado;
    }
}
