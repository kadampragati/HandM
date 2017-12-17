package test.HAndM.solution.DAO;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import test.HAndM.solution.entity.SortDetails;

@Repository("sortDaoImpl")
public class SortDaoImpl extends GenericDAOImpl<SortDetails, Serializable> implements SortDao {

	Logger LOGGER = LoggerFactory.getLogger(SortDaoImpl.class);

	@Autowired
	protected SessionFactory sessionFactory;

	@Override
	public void save(SortDetails sortData) {
		save(sortData);
		LOGGER.debug("data saved :{}", sortData);
	}

	@Override
	public SortDetails findByCode(int code) {
		SortDetails sortData;
		sortData = new SortDetails();
		sortData = findById(code, false);
		LOGGER.debug("data fetched :{}", sortData);
		return sortData;
	}

	@Override
	public List<SortDetails> getAllEntries() {
		// TODO Auto-generated method stub
		List<SortDetails> detailsList;
		detailsList = new ArrayList<>();

		final Query query = sessionFactory.getCurrentSession().createQuery(" FROM DocsTemplate ");

		detailsList = query.list();
		// if (detailsList!=null && (detailsList.size() > 0)) {
		// for (final Object[] item : queryList) {
		// }
		return detailsList;
	}

}
