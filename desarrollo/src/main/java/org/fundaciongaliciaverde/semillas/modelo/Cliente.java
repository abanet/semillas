package org.fundaciongaliciaverde.semillas.modelo;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cliente {
    private Integer idCliente;
    private String identificador;
    private String email;

    @Id
    @Column(name = "idCliente", nullable = false)
    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    @Basic
    @Column(name = "identificador", nullable = true, length = 45)
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (idCliente != null ? !idCliente.equals(cliente.idCliente) : cliente.idCliente != null) return false;
        if (identificador != null ? !identificador.equals(cliente.identificador) : cliente.identificador != null)
            return false;
        if (email != null ? !email.equals(cliente.email) : cliente.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCliente != null ? idCliente.hashCode() : 0;
        result = 31 * result + (identificador != null ? identificador.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
