package org.fundaciongaliciaverde.semillas.modelo;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Especie {
    private Integer idEspecie;
    private String nombre;
    private Collection<Variedad> variedadsByIdEspecie;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "idEspecie", nullable = false)
    public Integer getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(Integer idEspecie) {
        this.idEspecie = idEspecie;
    }

    @Basic
    @Column(name = "nombre", nullable = true, length = 45)
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

        Especie especie = (Especie) o;

        if (idEspecie != null ? !idEspecie.equals(especie.idEspecie) : especie.idEspecie != null) return false;
        if (nombre != null ? !nombre.equals(especie.nombre) : especie.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEspecie != null ? idEspecie.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "especieByIdEspecie")
    public Collection<Variedad> getVariedadsByIdEspecie() {
        return variedadsByIdEspecie;
    }

    public void setVariedadsByIdEspecie(Collection<Variedad> variedadsByIdEspecie) {
        this.variedadsByIdEspecie = variedadsByIdEspecie;
    }
}
