package org.fundaciongaliciaverde.semillas.modelo;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Latitud {
    private Integer idLatitud;
    private String descripcion;
    private Collection<Zona> zonasByIdLatitud;

    @Id
    @Column(name = "idLatitud", nullable = false)
    public Integer getIdLatitud() {
        return idLatitud;
    }

    public void setIdLatitud(Integer idLatitud) {
        this.idLatitud = idLatitud;
    }

    @Basic
    @Column(name = "descripcion", nullable = true, length = 45)
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

        Latitud latitud = (Latitud) o;

        if (idLatitud != null ? !idLatitud.equals(latitud.idLatitud) : latitud.idLatitud != null) return false;
        if (descripcion != null ? !descripcion.equals(latitud.descripcion) : latitud.descripcion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLatitud != null ? idLatitud.hashCode() : 0;
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "latitudByIdLatitud")
    public Collection<Zona> getZonasByIdLatitud() {
        return zonasByIdLatitud;
    }

    public void setZonasByIdLatitud(Collection<Zona> zonasByIdLatitud) {
        this.zonasByIdLatitud = zonasByIdLatitud;
    }
}
