/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fachadas;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetosNegocio.Analisis;
import objetosNegocio.Material;
import objetosNegocio.Producto;
import objetosNegocio.Reactivo;
import objetosNegocio.ReqMaterial;
import objetosNegocio.ReqReactivo;
import persistencia.AnalisisJpaController;
import persistencia.MaterialJpaController;
import persistencia.ProductoJpaController;
import persistencia.ReactivoJpaController;
import persistencia.ReqMaterialJpaController;
import persistencia.ReqReactivoJpaController;
import persistencia.exceptions.IllegalOrphanException;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author Francisco Apodaca
 */
public class FachadaJPA {

    private ProductoJpaController catalogoProductos = new ProductoJpaController();
    private AnalisisJpaController catalogoAnalisis = new AnalisisJpaController();
    private MaterialJpaController inventarioMateriales = new MaterialJpaController();
    private ReqMaterialJpaController reqMateriales = new ReqMaterialJpaController();
    private ReactivoJpaController inventarioReactivos = new ReactivoJpaController();
    private ReqReactivoJpaController reqReactivos = new ReqReactivoJpaController();

    public FachadaJPA() {
    }

    public Producto obten(Producto producto) {
        Producto productoEncontrado = new Producto();
        productoEncontrado = catalogoProductos.findProducto(producto.getClave());
        return productoEncontrado;
    }

    public Analisis obten(Analisis analisis) {
        Analisis analisisEncontrado = new Analisis();
        analisisEncontrado = catalogoAnalisis.findAnalisis(analisis.getCveAnalisis());
        return analisisEncontrado;
    }

    public ReqMaterial obten(ReqMaterial reqmaterial) {
        ReqMaterial reqMaterialEncontrado = new ReqMaterial();
        reqMaterialEncontrado = reqMateriales.findReqMaterial(reqmaterial.getCveReq());
        return reqMaterialEncontrado;
    }
    
    public ReqReactivo obten(ReqReactivo reqreactivo) {
        ReqReactivo reqReactivoEncontrado = new ReqReactivo();
        reqReactivoEncontrado = reqReactivos.findReqReactivo(reqreactivo.getCveReq());
        return reqReactivoEncontrado;
    }

    public void agregar(Producto producto) {
        try {
            catalogoProductos.create(producto);
        } catch (PreexistingEntityException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void agregar(Analisis analisis)  {
        try {
            catalogoAnalisis.create(analisis);
        } catch (PreexistingEntityException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void agregar(ReqMaterial reqmaterial) {
        try {
            reqMateriales.create(reqmaterial);
        } catch (PreexistingEntityException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void agregar(ReqReactivo reqreactivo) {
        try {
            reqReactivos.create(reqreactivo);
        } catch (PreexistingEntityException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizar(Producto producto) {
        try {
            catalogoProductos.edit(producto);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizar(Analisis analisis) {
        try {
            catalogoAnalisis.edit(analisis);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizar(ReqMaterial reqmaterial) {
        try {
            reqMateriales.edit(reqmaterial);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizar(ReqReactivo reqreactivo) {
        try {
            reqReactivos.edit(reqreactivo);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(Producto producto) {
        try {
            catalogoProductos.destroy(producto.getClave());
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(Analisis analisis) {
        try {
            catalogoAnalisis.destroy(analisis.getCveAnalisis());
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(ReqMaterial reqmaterial) {
        try {
            reqMateriales.destroy(reqmaterial.getCveReq());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminar(ReqReactivo reqreactivo) {
        try {
            reqReactivos.destroy(reqreactivo.getCveReq());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inventariar(Material material) {
        try {
            inventarioMateriales.create(material);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PreexistingEntityException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarInventario(Material material) {
        try {
            inventarioMateriales.edit(material);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desinventariar(Material material) {
        try {
            inventarioMateriales.destroy(material.getClave());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inventariar(Reactivo reactivo) {
        try {
            inventarioReactivos.create(reactivo);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PreexistingEntityException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void actualizarInventario(Reactivo reactivo) {
        try {
            inventarioReactivos.edit(reactivo);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void desinventariar(Reactivo reactivo) {
        try {
            inventarioReactivos.destroy(reactivo.getClave());
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(FachadaJPA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Producto> consultarProductos() {
        List<Producto> listaProductos = catalogoProductos.findProductoEntities();
        return listaProductos;
    }

    public List<Analisis> consultarAnalisis() {
        List<Analisis> listaAnalisis = catalogoAnalisis.findAnalisisEntities();
        return listaAnalisis;
    }

    public List<Material> consultarInventarioMateriales() {
        List<Material> listaMateriales = inventarioMateriales.findMaterialEntities();
        return listaMateriales;
    }

    public List<Reactivo> consultarInventarioReactivos() {
        List<Reactivo> listaReactivos = inventarioReactivos.findReactivoEntities();
        return listaReactivos;
    }

    public List<ReqMaterial> consultarReqMateriales() {
        List<ReqMaterial> listaReqMateriales = reqMateriales.findReqMaterialEntities();
        return listaReqMateriales;
    }

    public List<Analisis> consultarReqMateriales(Material material) {
        List<Analisis> analisisEncontrados = new ArrayList<Analisis>();
        return analisisEncontrados;
    }

    public List<Material> consultarReqMateriales(Analisis analisis) {
        List<Material> materialesEncontrados = new ArrayList<Material>();
        return materialesEncontrados;
    }

    public List<ReqReactivo> consultarReqReactivos() {
        List<ReqReactivo> listaReqReactivos = reqReactivos.findReqReactivoEntities();
        return listaReqReactivos;
    }

    public List<Analisis> consultarReqReactivos(Reactivo reactivo) {
        List<Analisis> analisisEncontrados = new ArrayList<Analisis>();
        return analisisEncontrados;
    }

    public List<Reactivo> consultarReqReactivos(Analisis analisis) {
        List<Reactivo> reactivosEncontrados = new ArrayList<Reactivo>();
        return reactivosEncontrados;
    }

}
