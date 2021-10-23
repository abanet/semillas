package org.fundaciongaliciaverde.semillas.modelo;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Altitud {
    private Integer idAltitud;
    private Integer metros;
    private String descripcion;
    private Collection<Zona> zonasByIdAltitud;

    @Id
    @Column(name = "idAltitud", nullable = false)
    public Integer getIdAltitud() {
        return idAltitud;
    }

    public void setIdAltitud(Integer idAltitud) {
        this.idAltitud = idAltitud;
    }

    @Basic
    @Column(name = "metros", nullable = false)
    public Integer getMetros() {
        return metros;
    }

    public void setMetros(Integer metros) {
        this.metros = metros;
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

        Altitud altitud = (Altitud) o;

        if (idAltitud != null ? !idAltitud.equals(altitud.idAltitud) : altitud.idAltitud != null) return false;
        if (metros != null ? !metros.equals(altitud.metros) : altitud.metros != null) return false;
        if (descripcion != null ? !descripcion.equals(altitud.descripcion) : altitud.descripcion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAltitud != null ? idAltitud.hashCode() : 0;
        result = 31 * result + (metros != null ? metros.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "altitudByIdAltitud")
    public Collection<Zona> getZonasByIdAltitud() {
        return zonasByIdAltitud;
    }

    public void setZonasByIdAltitud(Collection<Zona> zonasByIdAltitud) {
        this.zonasByIdAltitud = zonasByIdAltitud;
    }
}
