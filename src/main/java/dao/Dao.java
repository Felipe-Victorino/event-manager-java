package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class Dao<T> implements InterfaceDao<T>{

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenciaPU");

	Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public Dao() {
		this.entityClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public T insert(T t){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
		em.close();
		return t;
	};
	public T delete(T t){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(t);
		em.getTransaction().commit();
		em.close();
		return t;
	};
	public T update(T t){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();
		em.close();
		return t;
	};
	public T searchBy(long id){
		EntityManager em = emf.createEntityManager();
		try{
			return em.find(entityClass, id);
		} finally{
			em.close();
		}
	};

	@SuppressWarnings("unchecked")
	public List<T> searchAll(){
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("from " + entityClass.getSimpleName());
		return (List<T>) query.getResultList();
	};
}