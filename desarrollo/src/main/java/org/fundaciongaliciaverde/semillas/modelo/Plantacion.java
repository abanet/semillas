package org.fundaciongaliciaverde.semillas.modelo;

import javax.persistence.*;

@Entity
public class Plantacion {
    private Integer idPlantacion;
    private Mes mesByIdMes;
    private Luna lunaByIdLuna;
    private FormasPlantacion formasPlantacionByIdFormasPlantacion;
    private Guardian guardianByIdGuardian;
    private Variedad variedadByIdVariedad;
    private Zona zonaByIdZona;

    @Id
    @Column(name = "idPlantacion", nullable = false)
    public Integer getIdPlantacion() {
        return idPlantacion;
    }

    public void setIdPlantacion(Integer idPlantacion) {
        this.idPlantacion = idPlantacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Plantacion that = (Plantacion) o;

        if (idPlantacion != null ? !idPlantacion.equals(that.idPlantacion) : that.idPlantacion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return idPlantacion != null ? idPlantacion.hashCode() : 0;
    }

    @ManyToOne
    @JoinColumn(name = "idMes", referencedColumnName = "idMes", nullable = false)
    public Mes getMesByIdMes() {
        return mesByIdMes;
    }

    public void setMesByIdMes(Mes mesByIdMes) {
        this.mesByIdMes = mesByIdMes;
    }

    @ManyToOne
    @JoinColumn(name = "idLuna", referencedColumnName = "idLuna", nullable = false)
    public Luna getLunaByIdLuna() {
        return lunaByIdLuna;
    }

    public void setLunaByIdLuna(Luna lunaByIdLuna) {
        this.lunaByIdLuna = lunaByIdLuna;
    }

    @ManyToOne
    @JoinColumn(name = "idFormasPlantacion", referencedColumnName = "idFormasPlantacion", nullable = false)
    public FormasPlantacion getFormasPlantacionByIdFormasPlantacion() {
        return formasPlantacionByIdFormasPlantacion;
    }

    public void setFormasPlantacionByIdFormasPlantacion(FormasPlantacion formasPlantacionByIdFormasPlantacion) {
        this.formasPlantacionByIdFormasPlantacion = formasPlantacionByIdFormasPlantacion;
    }

    @ManyToOne
    @JoinColumn(name = "idGuardian", referencedColumnName = "idGuardian", nullable = false)
    public Guardian getGuardianByIdGuardian() {
        return guardianByIdGuardian;
    }

    public void setGuardianByIdGuardian(Guardian guardianByIdGuardian) {
        this.guardianByIdGuardian = guardianByIdGuardian;
    }

    @ManyToOne
    @JoinColumn(name = "idVariedad", referencedColumnName = "idVariedad", nullable = false)
    public Variedad getVariedadByIdVariedad() {
        return variedadByIdVariedad;
    }

    public void setVariedadByIdVariedad(Variedad variedadByIdVariedad) {
        this.variedadByIdVariedad = variedadByIdVariedad;
    }

    @ManyToOne
    @JoinColumn(name = "idZona", referencedColumnName = "idZona", nullable = false)
    public Zona getZonaByIdZona() {
        return zonaByIdZona;
    }

    public void setZonaByIdZona(Zona zonaByIdZona) {
        this.zonaByIdZona = zonaByIdZona;
    }
}
