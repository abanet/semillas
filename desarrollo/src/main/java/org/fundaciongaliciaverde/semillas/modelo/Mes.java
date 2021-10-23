package org.fundaciongaliciaverde.semillas.modelo;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Mes {
    private Integer idMes;
    private String nombre;
    private Collection<Plantacion> plantacionsByIdMes;

    @Id
    @Column(name = "idMes", nullable = false)
    public Integer getIdMes() {
        return idMes;
    }

    public void setIdMes(Integer idMes) {
        this.idMes = idMes;
    }

    @Basic
    @Column(name = "nombre", nullable = false, length = 45)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mes mes = (Mes) o;

        if (idMes != null ? !idMes.equals(mes.idMes) : mes.idMes != null) return false;
        if (nombre != null ? !nombre.equals(mes.nombre) : mes.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMes != null ? idMes.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "mesByIdMes")
    public Collection<Plantacion> getPlantacionsByIdMes() {
        return plantacionsByIdMes;
    }

    public void setPlantacionsByIdMes(Collection<Plantacion> plantacionsByIdMes) {
        this.plantacionsByIdMes = plantacionsByIdMes;
    }
}
