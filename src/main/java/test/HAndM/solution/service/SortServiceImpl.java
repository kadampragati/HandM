package test.HAndM.solution.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import test.HAndM.solution.DAO.SortDao;
import test.HAndM.solution.DTO.SortedDataDetails;
import test.HAndM.solution.entity.SortDetails;
import test.HAndM.solution.mapper.SortDataMapper;

@Service
public class SortServiceImpl implements SortService {

	Logger LOGGER = LoggerFactory.getLogger(SortServiceImpl.class);

	@Autowired
	SortDao sortDao;

	@Autowired
	SortDataMapper dataMapper;

	@Override
	@Transactional
	public void save(SortedDataDetails data) {
		LOGGER.debug("Inside save method to save the data.... :{}", data.toString());
		SortDetails details;
		details = dataMapper.mapToSortDetails(data);
		sortDao.save(details);

	}

	@Override
	@Transactional
	public SortedDataDetails findByCode(int code) {
		// TODO Auto-generated method stub
		LOGGER.debug("Inside findByCode method to fetch the data....with ID :{}", code);
		SortDetails details;
		SortedDataDetails dataReceived;
		dataReceived = new SortedDataDetails();

		details = new SortDetails();
		details = sortDao.findByCode(code);
		dataReceived = dataMapper.mapToSortedDataDetails(details);
		LOGGER.debug("data fetched is.... :{}", dataReceived.toString());
		return dataReceived;
	}

	@Override
	@Transactional
	public SortedDataDetails sortNumbers(String dataInput) {
		SortedDataDetails details;
		details = new SortedDataDetails();
		int placeMoves;
		int cnt;
		int arrLength;

		cnt = 0;
		arrLength = 0;
		placeMoves = 0;
		String strArray[];
		dataInput = dataInput.trim();
		strArray = dataInput.split("\\s");
		final int numArray[] = new int[strArray.length];

		for (final String num : strArray) {
			numArray[cnt] = Integer.parseInt(num);
			cnt++;
		}
		arrLength = numArray.length;
		/* below code to perform sorting */
		for (int i = 0; i < (arrLength - 1); i++) {
			// Find the minimum element in unsorted array
			int min_idx = i;
			for (int j = i + 1; j < arrLength; j++) {
				if (numArray[j] < numArray[min_idx]) {
					min_idx = j;
				}
			}

			// Swap the found minimum element with the first
			// element
			final int temp = numArray[min_idx];
			numArray[min_idx] = numArray[i];
			numArray[i] = temp;
			placeMoves++;
		}
		printArray(numArray);
		LOGGER.debug("sorted list is :{}", Arrays.toString(numArray));
		details.setSortedVal(Arrays.toString(numArray));
		details.setPlaceMoves(placeMoves);

		return details;
	}

	// Prints the array
	void printArray(int arr[]) {
		final int n = arr.length;
		for (int i = 0; i < n; ++i) {
			System.out.print(arr[i] + " ");
		}
	}

	@Override
	@Transactional
	public List<SortedDataDetails> getAllSavedEntries() {
		List<SortedDataDetails> detailsList;
		detailsList = new ArrayList<SortedDataDetails>();
		List<SortDetails> sortDetails;
		sortDetails = new ArrayList<SortDetails>();

		sortDetails = sortDao.getAllEntries();
		for (final SortDetails detail : sortDetails) {
			final SortedDataDetails data = dataMapper.mapToSortedDataDetails(detail);
			detailsList.add(data);
		}
		LOGGER.debug("all saved entries :{}", detailsList);
		return detailsList;
	}

}
