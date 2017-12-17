package test.HAndM.solution.DAO;

import java.io.Serializable;
import java.util.List;

import test.HAndM.solution.entity.SortDetails;

public interface SortDao extends GenericDAO<SortDetails, Serializable> {

	@Override
	void save(SortDetails data);

	SortDetails findByCode(int Code);

	List<SortDetails> getAllEntries();
}
