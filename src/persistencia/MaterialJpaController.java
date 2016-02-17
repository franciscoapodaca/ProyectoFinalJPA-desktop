/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import objetosNegocio.Material;
import objetosNegocio.Producto;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import persistencia.exceptions.IllegalOrphanException;
import persistencia.exceptions.NonexistentEntityException;
import persistencia.exceptions.PreexistingEntityException;

/**
 *
 * @author Francisco Apodaca
 */
public class MaterialJpaController {

    public MaterialJpaController() {
        emf = Persistence.createEntityManagerFactory("laboratorioPersistenciaJPAPU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Material material) throws IllegalOrphanException, PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Producto producto = material.getProducto();
            if (producto != null) {
                producto = em.getReference(producto.getClass(), producto.getClave());
                material.setProducto(material);
            }
            em.persist(material);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMaterial(material.getClave()) != null) {
                throw new PreexistingEntityException("Material " + material + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Material material) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            material = em.merge(material);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = material.getClave();
                if (findMaterial(id) == null) {
                    throw new NonexistentEntityException("The material with id " + id + " no longer exists.");
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
            Material material;
            try {
                material = em.getReference(Material.class, id);
                material.getClave();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The material with id " + id + " no longer exists.", enfe);
            }
            em.remove(material);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Material> findMaterialEntities() {
        return findMaterialEntities(true, -1, -1);
    }

    public List<Material> findMaterialEntities(int maxResults, int firstResult) {
        return findMaterialEntities(false, maxResults, firstResult);
    }

    private List<Material> findMaterialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Material as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Material findMaterial(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Material.class, id);
        } finally {
            em.close();
        }
    }

    public int getMaterialCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Material as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public void insertarModelo(DefaultTableModel modelo) throws Exception {
        try {
            List<Material> listaMaterial = obtenerTodosMateriales();
            if (listaMaterial != null) {
                int size = listaMaterial.size();
                for (int i = 0; i < size; i++) {
                    Object[] datos = new Object[2];
                    Material material = listaMaterial.get(i);
                    datos[0] = material.getClave();
                    datos[1] = material.getCantidad();
                    modelo.addRow(datos);
                }
            }
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    public List<Material> obtenerTodosMateriales() throws Exception {

        try {

            return findMaterialEntities();
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }
}
