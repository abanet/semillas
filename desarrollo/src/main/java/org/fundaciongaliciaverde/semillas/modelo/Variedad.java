package org.fundaciongaliciaverde.semillas.modelo;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Entity
public class Variedad {
    private Integer idVariedad;
    private Integer codigo;
    private String variedad;
    private String nombre;
    private String url;
    private Integer profundidad;
    private Integer germina;
    private Integer sizetransplante;
    private Integer distancia;
    private Integer distinciafilas;
    private Integer recoleccion;
    private Integer tiemposemillas;
    private Integer temperaturaideal;
    private Integer temperaturaminima;
    private Integer temperaturamaxima;
    private Timestamp fechacontrolgerminacion;
    private Integer porcentajegerminacion;
    private String phoptimo;
    private Collection<Plantacion> plantacionsByIdVariedad;
    private Especie especieByIdEspecie;

    @Id
    @Column(name = "idVariedad", nullable = false)
    public Integer getIdVariedad() {
        return idVariedad;
    }

    public void setIdVariedad(Integer idVariedad) {
        this.idVariedad = idVariedad;
    }

    @Basic
    @Column(name = "codigo", nullable = true)
    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "variedad", nullable = false, length = 255)
    public String getVariedad() {
        return variedad;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    @Basic
    @Column(name = "nombre", nullable = false, length = 255)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "url", nullable = true, length = 255)
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "profundidad", nullable = true)
    public Integer getProfundidad() {
        return profundidad;
    }

    public void setProfundidad(Integer profundidad) {
        this.profundidad = profundidad;
    }

    @Basic
    @Column(name = "germina", nullable = true)
    public Integer getGermina() {
        return germina;
    }

    public void setGermina(Integer germina) {
        this.germina = germina;
    }

    @Basic
    @Column(name = "sizetransplante", nullable = true)
    public Integer getSizetransplante() {
        return sizetransplante;
    }

    public void setSizetransplante(Integer sizetransplante) {
        this.sizetransplante = sizetransplante;
    }

    @Basic
    @Column(name = "distancia", nullable = true)
    public Integer getDistancia() {
        return distancia;
    }

    public void setDistancia(Integer distancia) {
        this.distancia = distancia;
    }

    @Basic
    @Column(name = "distinciafilas", nullable = true)
    public Integer getDistinciafilas() {
        return distinciafilas;
    }

    public void setDistinciafilas(Integer distinciafilas) {
        this.distinciafilas = distinciafilas;
    }

    @Basic
    @Column(name = "recoleccion", nullable = true)
    public Integer getRecoleccion() {
        return recoleccion;
    }

    public void setRecoleccion(Integer recoleccion) {
        this.recoleccion = recoleccion;
    }

    @Basic
    @Column(name = "tiemposemillas", nullable = true)
    public Integer getTiemposemillas() {
        return tiemposemillas;
    }

    public void setTiemposemillas(Integer tiemposemillas) {
        this.tiemposemillas = tiemposemillas;
    }

    @Basic
    @Column(name = "temperaturaideal", nullable = true)
    public Integer getTemperaturaideal() {
        return temperaturaideal;
    }

    public void setTemperaturaideal(Integer temperaturaideal) {
        this.temperaturaideal = temperaturaideal;
    }

    @Basic
    @Column(name = "temperaturaminima", nullable = true)
    public Integer getTemperaturaminima() {
        return temperaturaminima;
    }

    public void setTemperaturaminima(Integer temperaturaminima) {
        this.temperaturaminima = temperaturaminima;
    }

    @Basic
    @Column(name = "temperaturamaxima", nullable = true)
    public Integer getTemperaturamaxima() {
        return temperaturamaxima;
    }

    public void setTemperaturamaxima(Integer temperaturamaxima) {
        this.temperaturamaxima = temperaturamaxima;
    }

    @Basic
    @Column(name = "fechacontrolgerminacion", nullable = false)
    public Timestamp getFechacontrolgerminacion() {
        return fechacontrolgerminacion;
    }

    public void setFechacontrolgerminacion(Timestamp fechacontrolgerminacion) {
        this.fechacontrolgerminacion = fechacontrolgerminacion;
    }

    @Basic
    @Column(name = "porcentajegerminacion", nullable = false)
    public Integer getPorcentajegerminacion() {
        return porcentajegerminacion;
    }

    public void setPorcentajegerminacion(Integer porcentajegerminacion) {
        this.porcentajegerminacion = porcentajegerminacion;
    }

    @Basic
    @Column(name = "phoptimo", nullable = true, length = 45)
    public String getPhoptimo() {
        return phoptimo;
    }

    public void setPhoptimo(String phoptimo) {
        this.phoptimo = phoptimo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Variedad variedad1 = (Variedad) o;

        if (idVariedad != null ? !idVariedad.equals(variedad1.idVariedad) : variedad1.idVariedad != null) return false;
        if (codigo != null ? !codigo.equals(variedad1.codigo) : variedad1.codigo != null) return false;
        if (variedad != null ? !variedad.equals(variedad1.variedad) : variedad1.variedad != null) return false;
        if (nombre != null ? !nombre.equals(variedad1.nombre) : variedad1.nombre != null) return false;
        if (url != null ? !url.equals(variedad1.url) : variedad1.url != null) return false;
        if (profundidad != null ? !profundidad.equals(variedad1.profundidad) : variedad1.profundidad != null)
            return false;
        if (germina != null ? !germina.equals(variedad1.germina) : variedad1.germina != null) return false;
        if (sizetransplante != null ? !sizetransplante.equals(variedad1.sizetransplante) : variedad1.sizetransplante != null)
            return false;
        if (distancia != null ? !distancia.equals(variedad1.distancia) : variedad1.distancia != null) return false;
        if (distinciafilas != null ? !distinciafilas.equals(variedad1.distinciafilas) : variedad1.distinciafilas != null)
            return false;
        if (recoleccion != null ? !recoleccion.equals(variedad1.recoleccion) : variedad1.recoleccion != null)
            return false;
        if (tiemposemillas != null ? !tiemposemillas.equals(variedad1.tiemposemillas) : variedad1.tiemposemillas != null)
            return false;
        if (temperaturaideal != null ? !temperaturaideal.equals(variedad1.temperaturaideal) : variedad1.temperaturaideal != null)
            return false;
        if (temperaturaminima != null ? !temperaturaminima.equals(variedad1.temperaturaminima) : variedad1.temperaturaminima != null)
            return false;
        if (temperaturamaxima != null ? !temperaturamaxima.equals(variedad1.temperaturamaxima) : variedad1.temperaturamaxima != null)
            return false;
        if (fechacontrolgerminacion != null ? !fechacontrolgerminacion.equals(variedad1.fechacontrolgerminacion) : variedad1.fechacontrolgerminacion != null)
            return false;
        if (porcentajegerminacion != null ? !porcentajegerminacion.equals(variedad1.porcentajegerminacion) : variedad1.porcentajegerminacion != null)
            return false;
        if (phoptimo != null ? !phoptimo.equals(variedad1.phoptimo) : variedad1.phoptimo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idVariedad != null ? idVariedad.hashCode() : 0;
        result = 31 * result + (codigo != null ? codigo.hashCode() : 0);
        result = 31 * result + (variedad != null ? variedad.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (profundidad != null ? profundidad.hashCode() : 0);
        result = 31 * result + (germina != null ? germina.hashCode() : 0);
        result = 31 * result + (sizetransplante != null ? sizetransplante.hashCode() : 0);
        result = 31 * result + (distancia != null ? distancia.hashCode() : 0);
        result = 31 * result + (distinciafilas != null ? distinciafilas.hashCode() : 0);
        result = 31 * result + (recoleccion != null ? recoleccion.hashCode() : 0);
        result = 31 * result + (tiemposemillas != null ? tiemposemillas.hashCode() : 0);
        result = 31 * result + (temperaturaideal != null ? temperaturaideal.hashCode() : 0);
        result = 31 * result + (temperaturaminima != null ? temperaturaminima.hashCode() : 0);
        result = 31 * result + (temperaturamaxima != null ? temperaturamaxima.hashCode() : 0);
        result = 31 * result + (fechacontrolgerminacion != null ? fechacontrolgerminacion.hashCode() : 0);
        result = 31 * result + (porcentajegerminacion != null ? porcentajegerminacion.hashCode() : 0);
        result = 31 * result + (phoptimo != null ? phoptimo.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "variedadByIdVariedad")
    public Collection<Plantacion> getPlantacionsByIdVariedad() {
        return plantacionsByIdVariedad;
    }

    public void setPlantacionsByIdVariedad(Collection<Plantacion> plantacionsByIdVariedad) {
        this.plantacionsByIdVariedad = plantacionsByIdVariedad;
    }

    @ManyToOne
    @JoinColumn(name = "idEspecie", referencedColumnName = "idEspecie", nullable = false)
    public Especie getEspecieByIdEspecie() {
        return especieByIdEspecie;
    }

    public void setEspecieByIdEspecie(Especie especieByIdEspecie) {
        this.especieByIdEspecie = especieByIdEspecie;
    }
}
