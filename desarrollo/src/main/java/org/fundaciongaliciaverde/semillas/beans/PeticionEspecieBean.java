package org.fundaciongaliciaverde.semillas.beans;

import lombok.*;
import java.util.Map;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PeticionEspecieBean {
    private Map<String, EspecieBean> data;
    private String action;
}

