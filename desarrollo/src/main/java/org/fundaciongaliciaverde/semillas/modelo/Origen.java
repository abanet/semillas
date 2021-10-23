package org.fundaciongaliciaverde.semillas.modelo;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Origen {
    private Integer idOrigen;
    private String descripcion;
    private Collection<GuardianOrigen> guardianOrigensByIdOrigen;

    @Id
    @Column(name = "idOrigen", nullable = false)
    public Integer getIdOrigen() {
        return idOrigen;
    }

    public void setIdOrigen(Integer idOrigen) {
        this.idOrigen = idOrigen;
    }

    @Basic
    @Column(name = "descripcion", nullable = false, length = 45)
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

        Origen origen = (Origen) o;

        if (idOrigen != null ? !idOrigen.equals(origen.idOrigen) : origen.idOrigen != null) return false;
        if (descripcion != null ? !descripcion.equals(origen.descripcion) : origen.descripcion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idOrigen != null ? idOrigen.hashCode() : 0;
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "origenByIdOrigen")
    public Collection<GuardianOrigen> getGuardianOrigensByIdOrigen() {
        return guardianOrigensByIdOrigen;
    }

    public void setGuardianOrigensByIdOrigen(Collection<GuardianOrigen> guardianOrigensByIdOrigen) {
        this.guardianOrigensByIdOrigen = guardianOrigensByIdOrigen;
    }
}
