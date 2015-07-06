package co.edu.udistrital.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDAOJPAImpl<T, PK extends Serializable> 
	implements GenericDAOInterface<T, PK> 
	{

	protected Class<T> entityClass;
	
	@PersistenceContext
    protected EntityManager entityManager;
	
	 public GenericDAOJPAImpl() {
	        ParameterizedType genericSuperclass = (ParameterizedType) getClass()
	             .getGenericSuperclass();
	        this.entityClass = (Class<T>) genericSuperclass
	             .getActualTypeArguments()[0];
	    }
	
	@Override
	public T create(T newInstance) {
		 this.entityManager.persist(newInstance);
	        return newInstance;
	}

	@Override
	public T read(PK id) {
		 return this.entityManager.find(entityClass, id);
	}

	@Override
	public T update(T transientObject) {
		  return this.entityManager.merge(transientObject);		
	}

	@Override
	public void delete(T persistentObject) {
		persistentObject = this.entityManager.merge(persistentObject);
		this.entityManager.remove(persistentObject);
	}

}
