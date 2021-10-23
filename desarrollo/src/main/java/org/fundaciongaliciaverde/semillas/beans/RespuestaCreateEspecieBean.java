package org.fundaciongaliciaverde.semillas.beans;

import lombok.*;
import org.fundaciongaliciaverde.semillas.modelo.Especie;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class RespuestaCreateEspecieBean {
    private List<Especie> data;
    private String error;
}