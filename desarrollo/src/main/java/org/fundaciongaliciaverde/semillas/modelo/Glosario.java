package org.fundaciongaliciaverde.semillas.modelo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Glosario {
    private String termino;
    private String descripcion;

    @Id
    @Column(name = "termino", nullable = false, length = 45)
    public String getTermino() {
        return termino;
    }

    public void setTermino(String termino) {
        this.termino = termino;
    }

    @Basic
    @Column(name = "descripcion", nullable = true, length = 1024)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Glosario glosario = (Glosario) o;

        if (termino != null ? !termino.equals(glosario.termino) : glosario.termino != null) return false;
        if (descripcion != null ? !descripcion.equals(glosario.descripcion) : glosario.descripcion != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = termino != null ? termino.hashCode() : 0;
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        return result;
    }
}
