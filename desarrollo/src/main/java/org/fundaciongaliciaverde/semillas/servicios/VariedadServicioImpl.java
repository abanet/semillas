package org.fundaciongaliciaverde.semillas.servicios;

import org.fundaciongaliciaverde.semillas.beans.EspecieBean;
import org.fundaciongaliciaverde.semillas.beans.VariedadBean;
import org.fundaciongaliciaverde.semillas.modelo.Variedad;
import org.fundaciongaliciaverde.semillas.repositorio.VariedadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VariedadServicioImpl implements VariedadServicio {

    @Autowired
    VariedadRepositorio variedadRepositorio;

    @Override
    public List<VariedadBean> findAllVariedades() {
        List<Variedad> variedadList = variedadRepositorio.findAll();

        // TODO: esto hay que pasarlo a una clase de  utilidades. Lo convierto aquí para probar datatables lo antes posible
        List<VariedadBean> variedadBeanList = new ArrayList<>();
        for (Variedad variedad: variedadList){
            var variedadBean = new VariedadBean();
            variedadBean.setIdVariedad(variedad.getIdVariedad());
            variedadBean.setNombre(variedad.getNombre());
            variedadBean.setCodigo(variedad.getCodigo());
            var especieBean = new EspecieBean();
            especieBean.setIdEspecie(variedad.getEspecieByIdEspecie().getIdEspecie());
            especieBean.setNombre(variedad.getEspecieByIdEspecie().getNombre());
            variedadBean.setEspecie(especieBean);
            variedadBeanList.add(variedadBean);
        }
        return variedadBeanList;
    }
}
