package org.fundaciongaliciaverde.semillas.utilidades;

import org.fundaciongaliciaverde.semillas.SemillasGeneralException;
import org.fundaciongaliciaverde.semillas.beans.EspecieBean;
import org.fundaciongaliciaverde.semillas.beans.FormaPlantacionBean;
import org.fundaciongaliciaverde.semillas.modelo.Especie;
import org.fundaciongaliciaverde.semillas.modelo.FormasPlantacion;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


public final class ConversorEntityToBean {


    private ConversorEntityToBean() {
        throw new SemillasGeneralException("ConversorEntityToBean no se puede instanciar");
    }

    public static List<EspecieBean> especieListEntityToBean(List<Especie> especies) {
        ModelMapper modelMapper = new ModelMapper();
        return especies
                .stream()
                .map(e->modelMapper.map(e, EspecieBean.class))
                .collect(Collectors.toList());
    }

    public static EspecieBean especieEntityToBean(Especie especie) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(especie, EspecieBean.class);
    }

    public static List<FormaPlantacionBean> formaPlantacionListEntityToBean(List<FormasPlantacion> formas) {
        ModelMapper modelMapper = new ModelMapper();
        return formas
                .stream()
                .map(e->modelMapper.map(e, FormaPlantacionBean.class))
                .collect(Collectors.toList());
    }

    public static FormaPlantacionBean formaPlantacionEntityToBean(FormasPlantacion formasPlantacion) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(formasPlantacion, FormaPlantacionBean.class);
    }
}