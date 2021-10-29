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
public class RespuestaDatatableBean<T> {
    private List<T> data;
    private String error;
}
