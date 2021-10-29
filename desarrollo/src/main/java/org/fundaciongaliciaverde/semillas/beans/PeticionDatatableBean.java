package org.fundaciongaliciaverde.semillas.beans;


import lombok.*;

import java.util.Map;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class PeticionDatatableBean<T> {
    private Map<String, T> data;
    private String action;
}
