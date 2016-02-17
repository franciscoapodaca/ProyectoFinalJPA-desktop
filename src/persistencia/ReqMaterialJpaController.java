/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.swing.table.DefaultTableModel;
import objetosNegocio.Analisis;
import objetosNegocio.Material;
import objetosNegocio.Producto;
import objetosNegocio.ReqMaterial;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author Francisco Apodaca
 */
public class ReqMaterialJpaController {

    public ReqMaterialJpaController() {
        emf = Persistence.createEntityManagerFactory("laboratorioPersistenciaJPAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ReqMaterial reqMaterial) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Analisis analisis = reqMaterial.getAnalisis();
            if (analisis != null) {
                analisis = em.getReference(analisis.getClass(), analisis.getCveAnalisis());
                reqMaterial.setAnalisis(analisis);
            }
            Producto producto = reqMaterial.getProducto();
            if (producto != null) {
                producto = em.getReference(producto.getClass(), producto.getClave());
                reqMaterial.setProducto(producto);
            }
            em.persist(reqMaterial);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findReqMaterial(reqMaterial.getCveReq()) != null) {
                throw new PreexistingEntityException("ReqMaterial " + reqMaterial + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ReqMaterial reqMaterial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Analisis analisisNew = reqMaterial.getAnalisis();
            Producto productoNew = reqMaterial.getProducto();
            if (analisisNew != null) {
                analisisNew = em.getReference(analisisNew.getClass(), analisisNew.getCveAnalisis());
                reqMaterial.setAnalisis(analisisNew);
            }
            if (productoNew != null) {
                productoNew = em.getReference(productoNew.getClass(), productoNew.getClave());
                reqMaterial.setProducto(productoNew);
            }
            reqMaterial = em.merge(reqMaterial);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = reqMaterial.getCveReq();
                if (findReqMaterial(id) == null) {
                    throw new NonexistentEntityException("The reqMaterial with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ReqMaterial reqMaterial;
            try {
                reqMaterial = em.getReference(ReqMaterial.class, id);
                reqMaterial.getCveReq();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reqMaterial with id " + id + " no longer exists.", enfe);
            }
            em.remove(reqMaterial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ReqMaterial> findReqMaterialEntities() {
        return findReqMaterialEntities(true, -1, -1);
    }

    public List<ReqMaterial> findReqMaterialEntities(int maxResults, int firstResult) {
        return findReqMaterialEntities(false, maxResults, firstResult);
    }

    private List<ReqMaterial> findReqMaterialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from ReqMaterial as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ReqMaterial findReqMaterial(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ReqMaterial.class, id);
        } finally {
            em.close();
        }
    }

    public int getReqMaterialCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from ReqMaterial as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public List<Analisis> obtenListaReqMaterialPorMaterial(Material material) {
        // Lista a devolver
        List<Analisis> lista = new ArrayList<Analisis>();

        EntityManager em = getEntityManager();
        String query = "SELECT Analisis(a) FROM Analisis as a";
        Query q = em.createQuery(query);
        List<Analisis> listaAnalisisTodos = q.getResultList();

        for (Analisis a : listaAnalisisTodos) {
            for (ReqMaterial r : a.getListaReqMateriales()) {
                if (r.getProducto().getClave().equals(material.getClave())) {
                    lista.add(a);
                }
            }
        }
        return lista;
    }

    public void insertarModelo(DefaultTableModel modelo) throws Exception {
        try {
            List<ReqMaterial> listaReqMaterial = obtenerTodosReqMaterial();
            if (listaReqMaterial != null) {
                int size = listaReqMaterial.size();
                for (int i = 0; i < size; i++) {
                    Object[] datos = new Object[4];
                    ReqMaterial reqMaterial = listaReqMaterial.get(i);
                    datos[0] = reqMaterial.getCveReq();
                    datos[1] = reqMaterial.getCantidad();
                    datos[2] = reqMaterial.getProducto();
                    datos[3] = reqMaterial.getAnalisis();
                    modelo.addRow(datos);
                }
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public List<ReqMaterial> obtenerTodosReqMaterial() throws Exception {

        try {

            return findReqMaterialEntities();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

}
