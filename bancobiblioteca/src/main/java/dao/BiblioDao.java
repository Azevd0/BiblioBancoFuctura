package dao;
import java.util.List;

import BibliotecaProjeto.Item;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import utils.JpaUtil;

public class BiblioDao {

	public Item saveItem(Item item) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		em.persist(item);
		em.getTransaction().commit();
		em.close();
		return item;
	}

	public List<Item> listAll() {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		String jpql = "SELECT i FROM Item i ORDER BY i.id ASC";
		TypedQuery<Item> query = em.createQuery(jpql, Item.class);
		List<Item> minhalist = query.getResultList();
		em.close();
		return minhalist;
	}

	public List<Item> listByCategory(String categoria) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		String jpql = "SELECT i FROM Item i WHERE LOWER(i.categoria) = LOWER(:categoria) ORDER BY i.id ASC";
		TypedQuery<Item> query = em.createQuery(jpql, Item.class);
		query.setParameter("categoria", categoria);
		List<Item> minhalist = query.getResultList();
		em.close();
		return minhalist;
	}

	public boolean deleteItem(String titulo) {
		EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
		em.getTransaction().begin();
		try {
			String jpql = "SELECT i FROM Item i WHERE LOWER(i.titulo) = LOWER(:titulo)"; 
			Item item = em.createQuery(jpql, Item.class).setParameter("titulo", titulo).getSingleResult();
			em.remove(item);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			return false; 
		} finally {
			em.close();
		}

	}
	public List<Item> listByAutor(String autor) {
	    EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	    String jpql = "SELECT i FROM Item i WHERE LOWER(i.autor) = LOWER(:autor) ORDER BY i.id ASC";
	    TypedQuery<Item> aut = em.createQuery(jpql, Item.class);
	    aut.setParameter("autor", autor);
	    List<Item> listaut = aut.getResultList();
	    em.close();
	    return listaut;
	}
	public Item findByName(String titulo){
	    EntityManager em = JpaUtil.getEntityManagerFactory().createEntityManager();
	    try {
	        String jpql = "SELECT i FROM Item i WHERE LOWER(i.titulo) = LOWER(:titulo) ORDER BY i.id ASC"; 
	        return em.createQuery(jpql, Item.class).setParameter("titulo", titulo).getSingleResult();
	    } catch (Exception e) {
	        return null;
	    } finally {
	        em.close();
	    }
	}
}

