package test.HAndM.solution.DAO;

import java.io.Serializable;

public interface GenericDAO<T, ID extends Serializable> {

	public T findById(ID id, boolean lock);

	public void save(T obj);
}
