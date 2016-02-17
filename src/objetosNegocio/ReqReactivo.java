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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Francisco Apodaca
 */
@Entity
@Table(name = "reqreactivos")
@NamedQueries({
    @NamedQuery(name = "ReqReactivo.findAll", query = "SELECT r FROM ReqReactivo r"),
    @NamedQuery(name = "ReqReactivo.findByCveReq", query = "SELECT r FROM ReqReactivo r WHERE r.cveReq = :cveReq"),
    @NamedQuery(name = "ReqReactivo.findByCantidad", query = "SELECT r FROM ReqReactivo r WHERE r.cantidad = :cantidad")})
public class ReqReactivo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cveReq")
    private String cveReq;
    @Basic(optional = false)
    @Column(name = "cantidad")
    private double cantidad;
    @JoinColumn(name = "cveAnalisis", referencedColumnName = "cveAnalisis")
    @ManyToOne(optional = false)
    private Analisis analisis;
    @JoinColumn(name = "clave", referencedColumnName = "clave")
    @ManyToOne(optional = false)
    private Producto producto;

    public ReqReactivo() {
    }

    public ReqReactivo(String cveReq) {
        this.cveReq = cveReq;
    }

    public ReqReactivo(String cveReq, double cantidad) {
        this.cveReq = cveReq;
        this.cantidad = cantidad;
    }

    public ReqReactivo(String cveReq, int cantidad, Producto clave, Analisis cveAnalisis) {
        this.cveReq = cveReq;
        this.analisis = cveAnalisis;
        this.producto = clave;
        this.cantidad = cantidad;
    }

    public String getCveReq() {
        return cveReq;
    }

    public void setCveReq(String cveReq) {
        this.cveReq = cveReq;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Analisis getAnalisis() {
        return analisis;
    }

    public void setAnalisis(Analisis analisis) {
        this.analisis = analisis;
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
        hash += (cveReq != null ? cveReq.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReqReactivo)) {
            return false;
        }
        ReqReactivo other = (ReqReactivo) object;
        if ((this.cveReq == null && other.cveReq != null) || (this.cveReq != null && !this.cveReq.equals(other.cveReq))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "objetosNegocio.ReqReactivo[cveReq=" + cveReq + "]";
    }

}
