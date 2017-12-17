package test.HAndM.solution.mapper;

import org.springframework.stereotype.Component;

import test.HAndM.solution.DTO.SortedDataDetails;
import test.HAndM.solution.entity.SortDetails;

@Component
public class SortDataMapper {
	public SortedDataDetails mapToSortedDataDetails(final SortDetails data) {

		final SortedDataDetails details = new SortedDataDetails();
		details.setDetailsId(data.getDetailsId());
		if (data.getInputVal() != null) {
			details.setInputVal(data.getInputVal());
		}

		if (data.getSortedVal() != null) {
			details.setSortedVal(data.getSortedVal());
		}

		return details;

	}

	public SortDetails mapToSortDetails(final SortedDataDetails data) {

		final SortDetails details = new SortDetails();
		// details.setDetailsId(data.getDetailsId());
		if (data.getInputVal() != null) {
			details.setInputVal(data.getInputVal());
		}

		if (data.getSortedVal() != null) {
			details.setSortedVal(data.getSortedVal());
		}

		return details;

	}
}
