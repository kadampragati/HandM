package test.HAndM.solution.DAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.HibernateException;
import org.hibernate.LockOptions;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {

	@Autowired
	protected SessionFactory sessionFactory;

	private final Class<T> persistentClass;

	public GenericDAOImpl() {

		this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
	}

	public Class<T> getPersistentClass() {

		return persistentClass;
	}

	@Override
	@SuppressWarnings("unchecked")
	public T findById(final ID id, final boolean lock) {

		T entity;
		LockOptions lockMode;
		if (lock) {
			lockMode = LockOptions.UPGRADE;
		} else {
			lockMode = LockOptions.NONE;
		}

		try {
			entity = (T) sessionFactory.getCurrentSession().load(getPersistentClass(), id, lockMode);
		} catch (final org.hibernate.ObjectNotFoundException e) {
			entity = null;

		} catch (final HibernateException e) {

			throw e;
		}

		return entity;
	}

	@Override
	public void save(final T entity) {

		try {
			sessionFactory.getCurrentSession().save(entity);

		} catch (final HibernateException e) {
			throw e;
		}

	}

}
