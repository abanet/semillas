package org.fundaciongaliciaverde.semillas.servicios;

import org.fundaciongaliciaverde.semillas.beans.VariedadBean;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VariedadServicio {
    List<VariedadBean> findAllVariedades();
}
