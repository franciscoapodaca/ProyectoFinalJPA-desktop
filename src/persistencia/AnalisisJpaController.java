/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import objetosNegocio.Analisis;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import persistencia.exceptions.IllegalOrphanException;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author Francisco Apodaca
 */
public class AnalisisJpaController {

    public AnalisisJpaController() {
        emf = Persistence.createEntityManagerFactory("laboratorioPersistenciaJPAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Analisis analisis) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(analisis);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findAnalisis(analisis.getCveAnalisis()) != null) {
                JOptionPane.showMessageDialog(null, "El Analisis Ya Existe");
                throw new PreexistingEntityException("Analisis " + analisis + " ya existe ", ex);
                
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Analisis analisis) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            analisis = em.merge(analisis);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = analisis.getCveAnalisis();
                if (findAnalisis(id) == null) {
                    throw new NonexistentEntityException("The analisis with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Analisis analisis;
            try {
                analisis = em.getReference(Analisis.class, id);
                analisis.getCveAnalisis();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The analisis with id " + id + " no longer exists.", enfe);
            }
            em.remove(analisis);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Analisis> findAnalisisEntities() {
        return findAnalisisEntities(true, -1, -1);
    }

    public List<Analisis> findAnalisisEntities(int maxResults, int firstResult) {
        return findAnalisisEntities(false, maxResults, firstResult);
    }

    private List<Analisis> findAnalisisEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Analisis as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Analisis findAnalisis(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Analisis.class, id);
        } finally {
            em.close();
        }
    }

    public int getAnalisisCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Analisis as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

    public void insertarModelo(DefaultTableModel modelo) throws Exception {
        try {
            List<Analisis> listaAnalisis = obtenerTodosAnalisis();
            if (listaAnalisis != null) {
                int size = listaAnalisis.size();
                for (int i = 0; i < size; i++) {
                    Object[] datos = new Object[3];
                    Analisis analisis = listaAnalisis.get(i);
                    datos[0] = analisis.getCveAnalisis();
                    datos[1] = analisis.getNombre();
                    datos[2] = analisis.getFrecuencia();
                    modelo.addRow(datos);
                }
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public List<Analisis> obtenerTodosAnalisis() throws Exception {

        try {

            return findAnalisisEntities();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
