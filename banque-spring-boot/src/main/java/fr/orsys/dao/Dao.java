package fr.orsys.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface Dao<T> {
	public T save(T entity) ;	
	public T load(Serializable primaryKey);
	public List<T> LoadAll();
	public void delete(T entity) ;
	public void deleteAll(Collection<T> entities) ;
	public void update(T entity)  ;
}

