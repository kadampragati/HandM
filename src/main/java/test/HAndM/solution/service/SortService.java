package test.HAndM.solution.service;

import java.util.List;

import test.HAndM.solution.DTO.SortedDataDetails;

public interface SortService {

	void save(SortedDataDetails data);

	SortedDataDetails findByCode(int Code);

	List<SortedDataDetails> getAllSavedEntries();

	SortedDataDetails sortNumbers(String datainput);

}
