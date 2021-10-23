package org.fundaciongaliciaverde.semillas.modelo;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Luna {
    private Integer idLuna;
    private String fase;
    private Collection<Plantacion> plantacionsByIdLuna;

    @Id
    @Column(name = "idLuna", nullable = false)
    public Integer getIdLuna() {
        return idLuna;
    }

    public void setIdLuna(Integer idLuna) {
        this.idLuna = idLuna;
    }

    @Basic
    @Column(name = "fase", nullable = false, length = 45)
    public String getFase() {
        return fase;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Luna luna = (Luna) o;

        if (idLuna != null ? !idLuna.equals(luna.idLuna) : luna.idLuna != null) return false;
        if (fase != null ? !fase.equals(luna.fase) : luna.fase != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idLuna != null ? idLuna.hashCode() : 0;
        result = 31 * result + (fase != null ? fase.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "lunaByIdLuna")
    public Collection<Plantacion> getPlantacionsByIdLuna() {
        return plantacionsByIdLuna;
    }

    public void setPlantacionsByIdLuna(Collection<Plantacion> plantacionsByIdLuna) {
        this.plantacionsByIdLuna = plantacionsByIdLuna;
    }
}
