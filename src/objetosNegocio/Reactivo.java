/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetosNegocio;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Francisco Apodaca
 */
@Entity
@Table(name = "reactivos")
@NamedQueries({
    @NamedQuery(name = "Reactivo.findAll", query = "SELECT r FROM Reactivo r"),
    @NamedQuery(name = "Reactivo.findByClave", query = "SELECT r FROM Reactivo r WHERE r.clave = :clave"),
    @NamedQuery(name = "Reactivo.findByCantidad", query = "SELECT r FROM Reactivo r WHERE r.cantidad = :cantidad")})
public class Reactivo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "clave")
    private String clave;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private double cantidad;
    @JoinColumn(name = "clave", referencedColumnName = "clave", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Producto producto;

    public Reactivo() {
    }

    public Reactivo(String clave) {
        this.clave = clave;
    }

    public Reactivo(String clave, double cantidad) {
        this.clave = clave;
        this.cantidad = cantidad;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clave != null ? clave.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Reactivo)) {
            return false;
        }
        Reactivo other = (Reactivo) object;
        if ((this.clave == null && other.clave != null) || (this.clave != null && !this.clave.equals(other.clave))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return clave;
    }

}
