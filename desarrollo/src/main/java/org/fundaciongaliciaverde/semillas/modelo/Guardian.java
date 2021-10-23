package org.fundaciongaliciaverde.semillas.modelo;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Guardian {
    private Integer idGuardian;
    private String nombre;
    private String telefono;
    private String mail;
    private Collection<GuardianOrigen> guardianOrigensByIdGuardian;
    private Collection<Plantacion> plantacionsByIdGuardian;

    @Id
    @Column(name = "idGuardian", nullable = false)
    public Integer getIdGuardian() {
        return idGuardian;
    }

    public void setIdGuardian(Integer idGuardian) {
        this.idGuardian = idGuardian;
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
    @Column(name = "telefono", nullable = false, length = 45)
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Basic
    @Column(name = "mail", nullable = false, length = 45)
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Guardian guardian = (Guardian) o;

        if (idGuardian != null ? !idGuardian.equals(guardian.idGuardian) : guardian.idGuardian != null) return false;
        if (nombre != null ? !nombre.equals(guardian.nombre) : guardian.nombre != null) return false;
        if (telefono != null ? !telefono.equals(guardian.telefono) : guardian.telefono != null) return false;
        if (mail != null ? !mail.equals(guardian.mail) : guardian.mail != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idGuardian != null ? idGuardian.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (mail != null ? mail.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "guardianByIdGuardian")
    public Collection<GuardianOrigen> getGuardianOrigensByIdGuardian() {
        return guardianOrigensByIdGuardian;
    }

    public void setGuardianOrigensByIdGuardian(Collection<GuardianOrigen> guardianOrigensByIdGuardian) {
        this.guardianOrigensByIdGuardian = guardianOrigensByIdGuardian;
    }

    @OneToMany(mappedBy = "guardianByIdGuardian")
    public Collection<Plantacion> getPlantacionsByIdGuardian() {
        return plantacionsByIdGuardian;
    }

    public void setPlantacionsByIdGuardian(Collection<Plantacion> plantacionsByIdGuardian) {
        this.plantacionsByIdGuardian = plantacionsByIdGuardian;
    }
}
