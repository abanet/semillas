package org.fundaciongaliciaverde.semillas.beans;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class VariedadBean {
    private Integer idVariedad;
    private Integer codigo;
    private String nombre;
    private EspecieBean especie;
}

