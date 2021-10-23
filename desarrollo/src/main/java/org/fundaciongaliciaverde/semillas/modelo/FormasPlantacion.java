package org.fundaciongaliciaverde.semillas.modelo;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class FormasPlantacion {
    private Integer idFormasPlantacion;
    private String descripcion;
    private Collection<Plantacion> plantacionsByIdFormasPlantacion;

    @Id
    @Column(name = "idFormasPlantacion", nullable = false)
    public Integer getIdFormasPlantacion() {
        return idFormasPlantacion;
    }

    public void setIdFormasPlantacion(Integer idFormasPlantacion) {
        this.idFormasPlantacion = idFormasPlantacion;
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

        FormasPlantacion that = (FormasPlantacion) o;

        if (idFormasPlantacion != null ? !idFormasPlantacion.equals(that.idFormasPlantacion) : that.idFormasPlantacion != null)
            return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idFormasPlantacion != null ? idFormasPlantacion.hashCode() : 0;
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "formasPlantacionByIdFormasPlantacion")
    public Collection<Plantacion> getPlantacionsByIdFormasPlantacion() {
        return plantacionsByIdFormasPlantacion;
    }

    public void setPlantacionsByIdFormasPlantacion(Collection<Plantacion> plantacionsByIdFormasPlantacion) {
        this.plantacionsByIdFormasPlantacion = plantacionsByIdFormasPlantacion;
    }
}
