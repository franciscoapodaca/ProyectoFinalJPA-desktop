/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.table.DefaultTableModel;
import objetosNegocio.Analisis;
import objetosNegocio.ReqReactivo;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author Francisco
 */
public class ReqReactivoJpaController implements Serializable {

    public ReqReactivoJpaController() {
        emf = Persistence.createEntityManagerFactory("laboratorioPersistenciaJPAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ReqReactivo reqReactivo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Analisis analisis = reqReactivo.getAnalisis();
            if (analisis != null) {
                analisis = em.getReference(analisis.getClass(), analisis.getCveAnalisis());
                reqReactivo.setAnalisis(analisis);
            }
            em.persist(reqReactivo);
            if (analisis != null) {
                analisis.getListaReqReactivos().add(reqReactivo);
                analisis = em.merge(analisis);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findReqReactivo(reqReactivo.getCveReq()) != null) {
                throw new PreexistingEntityException("ReqReactivo " + reqReactivo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ReqReactivo reqReactivo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            ReqReactivo persistentReqReactivo = em.find(ReqReactivo.class, reqReactivo.getCveReq());
            Analisis analisisOld = persistentReqReactivo.getAnalisis();
            Analisis analisisNew = reqReactivo.getAnalisis();
            if (analisisNew != null) {
                analisisNew = em.getReference(analisisNew.getClass(), analisisNew.getCveAnalisis());
                reqReactivo.setAnalisis(analisisNew);
            }
            reqReactivo = em.merge(reqReactivo);
            if (analisisOld != null && !analisisOld.equals(analisisNew)) {
                analisisOld.getListaReqReactivos().remove(reqReactivo);
                analisisOld = em.merge(analisisOld);
            }
            if (analisisNew != null && !analisisNew.equals(analisisOld)) {
                analisisNew.getListaReqReactivos().add(reqReactivo);
                analisisNew = em.merge(analisisNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = reqReactivo.getCveReq();
                if (findReqReactivo(id) == null) {
                    throw new NonexistentEntityException("The reqReactivo with id " + id + " no longer exists.");
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
            ReqReactivo reqReactivo;
            try {
                reqReactivo = em.getReference(ReqReactivo.class, id);
                reqReactivo.getCveReq();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reqReactivo with id " + id + " no longer exists.", enfe);
            }
            Analisis analisis = reqReactivo.getAnalisis();
            if (analisis != null) {
                analisis.getListaReqReactivos().remove(reqReactivo);
                analisis = em.merge(analisis);
            }
            em.remove(reqReactivo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ReqReactivo> findReqReactivoEntities() {
        return findReqReactivoEntities(true, -1, -1);
    }

    public List<ReqReactivo> findReqReactivoEntities(int maxResults, int firstResult) {
        return findReqReactivoEntities(false, maxResults, firstResult);
    }

    private List<ReqReactivo> findReqReactivoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ReqReactivo.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public ReqReactivo findReqReactivo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ReqReactivo.class, id);
        } finally {
            em.close();
        }
    }

    public int getReqReactivoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ReqReactivo> rt = cq.from(ReqReactivo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public void insertarModelo(DefaultTableModel modelo) throws Exception {
        try {
            List<ReqReactivo> listaReqReactivo = obtenerTodosReqReactivo();
            if (listaReqReactivo != null) {
                int size = listaReqReactivo.size();
                for (int i = 0; i < size; i++) {
                    Object[] datos = new Object[4];
                    ReqReactivo reqReactivo = listaReqReactivo.get(i);
                    datos[0] = reqReactivo.getCveReq();
                    datos[1] = reqReactivo.getCantidad();
                    datos[2] = reqReactivo.getProducto();
                    datos[3] = reqReactivo.getAnalisis();
                    modelo.addRow(datos);
                }
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public List<ReqReactivo> obtenerTodosReqReactivo() throws Exception {

        try {

            return findReqReactivoEntities();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

}
