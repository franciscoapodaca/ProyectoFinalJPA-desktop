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
import objetosNegocio.Reactivo;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author Francisco
 */
public class ReactivoJpaController implements Serializable {

    
    public ReactivoJpaController() {
         emf = Persistence.createEntityManagerFactory("laboratorioPersistenciaJPAPU");
    }
    private EntityManagerFactory emf = null;


    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    

    public void create(Reactivo reactivo) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(reactivo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findReactivo(reactivo.getClave()) != null) {
                throw new PreexistingEntityException("Reactivo " + reactivo + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Reactivo reactivo) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            reactivo = em.merge(reactivo);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = reactivo.getClave();
                if (findReactivo(id) == null) {
                    throw new NonexistentEntityException("The reactivo with id " + id + " no longer exists.");
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
            Reactivo reactivo;
            try {
                reactivo = em.getReference(Reactivo.class, id);
                reactivo.getClave();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The reactivo with id " + id + " no longer exists.", enfe);
            }
            em.remove(reactivo);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Reactivo> findReactivoEntities() {
        return findReactivoEntities(true, -1, -1);
    }

    public List<Reactivo> findReactivoEntities(int maxResults, int firstResult) {
        return findReactivoEntities(false, maxResults, firstResult);
    }

    private List<Reactivo> findReactivoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Reactivo.class));
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

    public Reactivo findReactivo(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Reactivo.class, id);
        } finally {
            em.close();
        }
    }

    public int getReactivoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Reactivo> rt = cq.from(Reactivo.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public void insertarModelo(DefaultTableModel modelo) throws Exception {
        try {
            List<Reactivo> listaReactivos = obtenerTodosReactivos();
            if (listaReactivos != null) {
                int size = listaReactivos.size();
                for (int i = 0; i < size; i++) {
                    Object[] datos = new Object[2];
                    Reactivo reactivo = listaReactivos.get(i);
                    datos[0] = reactivo.getClave();
                    datos[1] = reactivo.getCantidad();
                    modelo.addRow(datos);
                }
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public List<Reactivo> obtenerTodosReactivos() throws Exception {

        try {

            return findReactivoEntities();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
    
}
