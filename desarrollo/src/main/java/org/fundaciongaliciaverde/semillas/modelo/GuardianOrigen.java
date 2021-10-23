package org.fundaciongaliciaverde.semillas.modelo;

import javax.persistence.*;

@Entity
public class GuardianOrigen {
    private Integer id;
    private Guardian guardianByIdGuardian;
    private Origen origenByIdOrigen;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GuardianOrigen that = (GuardianOrigen) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @ManyToOne
    @JoinColumn(name = "idGuardian", referencedColumnName = "idGuardian")
    public Guardian getGuardianByIdGuardian() {
        return guardianByIdGuardian;
    }

    public void setGuardianByIdGuardian(Guardian guardianByIdGuardian) {
        this.guardianByIdGuardian = guardianByIdGuardian;
    }

    @ManyToOne
    @JoinColumn(name = "idOrigen", referencedColumnName = "idOrigen")
    public Origen getOrigenByIdOrigen() {
        return origenByIdOrigen;
    }

    public void setOrigenByIdOrigen(Origen origenByIdOrigen) {
        this.origenByIdOrigen = origenByIdOrigen;
    }
}
