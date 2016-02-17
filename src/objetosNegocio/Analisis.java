/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package objetosNegocio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Francisco Apodaca
 */
@Entity
@Table(name = "analisis")
@NamedQueries({
    @NamedQuery(name = "Analisis.findAll", query = "SELECT a FROM Analisis a"),
    @NamedQuery(name = "Analisis.findByCveAnalisis", query = "SELECT a FROM Analisis a WHERE a.cveAnalisis = :cveAnalisis"),
    @NamedQuery(name = "Analisis.findByNombre", query = "SELECT a FROM Analisis a WHERE a.nombre = :nombre"),
    @NamedQuery(name = "Analisis.findByFrecuencia", query = "SELECT a FROM Analisis a WHERE a.frecuencia = :frecuencia")})
public class Analisis implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cveAnalisis")
    private String cveAnalisis;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "frecuencia")
    private double frecuencia;
    @OneToMany(mappedBy = "analisis")
    private List<ReqReactivo> listaReqReactivos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "analisis")
    private List<ReqMaterial> listaReqMateriales;

    public Analisis() {
    }

    public Analisis(String cveAnalisis) {
        this.cveAnalisis = cveAnalisis;
    }

    public Analisis(String cveAnalisis, String nombre, double frecuencia) {
        this.cveAnalisis = cveAnalisis;
        this.nombre = nombre;
        this.frecuencia = frecuencia;
    }

    public String getCveAnalisis() {
        return cveAnalisis;
    }

    public void setCveAnalisis(String cveAnalisis) {
        this.cveAnalisis = cveAnalisis;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(double frecuencia) {
        this.frecuencia = frecuencia;
    }

    public List<ReqMaterial> getListaReqMateriales() {
        return listaReqMateriales;
    }

    public void setListaReqMateriales(List<ReqMaterial> listaReqMateriales) {
        this.listaReqMateriales = listaReqMateriales;
    }

    public List<ReqReactivo> getListaReqReactivos() {
        return listaReqReactivos;
    }

    public void setListaReqReactivos(List<ReqReactivo> listaReqReactivos) {
        this.listaReqReactivos = listaReqReactivos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cveAnalisis != null ? cveAnalisis.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Analisis)) {
            return false;
        }
        Analisis other = (Analisis) object;
        if ((this.cveAnalisis == null && other.cveAnalisis != null) || (this.cveAnalisis != null && !this.cveAnalisis.equals(other.cveAnalisis))) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return cveAnalisis;
    }

}
