package org.fundaciongaliciaverde.semillas.modelo;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Zona {
    private Integer idZona;
    private Collection<Plantacion> plantacionsByIdZona;
    private Altitud altitudByIdAltitud;
    private Latitud latitudByIdLatitud;

    @Id
    @Column(name = "idZona", nullable = false)
    public Integer getIdZona() {
        return idZona;
    }

    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Zona zona = (Zona) o;

        if (idZona != null ? !idZona.equals(zona.idZona) : zona.idZona != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idZona != null ? idZona.hashCode() : 0;
    }

    @OneToMany(mappedBy = "zonaByIdZona")
    public Collection<Plantacion> getPlantacionsByIdZona() {
        return plantacionsByIdZona;
    }

    public void setPlantacionsByIdZona(Collection<Plantacion> plantacionsByIdZona) {
        this.plantacionsByIdZona = plantacionsByIdZona;
    }

    @ManyToOne
    @JoinColumn(name = "idAltitud", referencedColumnName = "idAltitud", nullable = false)
    public Altitud getAltitudByIdAltitud() {
        return altitudByIdAltitud;
    }

    public void setAltitudByIdAltitud(Altitud altitudByIdAltitud) {
        this.altitudByIdAltitud = altitudByIdAltitud;
    }

    @ManyToOne
    @JoinColumn(name = "idLatitud", referencedColumnName = "idLatitud", nullable = false)
    public Latitud getLatitudByIdLatitud() {
        return latitudByIdLatitud;
    }

    public void setLatitudByIdLatitud(Latitud latitudByIdLatitud) {
        this.latitudByIdLatitud = latitudByIdLatitud;
    }
}
