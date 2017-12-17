package test.HAndM.solution.DTO;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class SortedDataDetails {

	private int detailsId;

	private int placeMoves;

	public int getPlaceMoves() {
		return placeMoves;
	}

	public void setPlaceMoves(int placeMoves) {
		this.placeMoves = placeMoves;
	}

	private String inputVal;

	private String sortedVal;

	public int getDetailsId() {
		return detailsId;
	}

	public void setDetailsId(int detailsId) {
		this.detailsId = detailsId;
	}

	public String getInputVal() {
		return inputVal;
	}

	public void setInputVal(String inputVal) {
		this.inputVal = inputVal;
	}

	public String getSortedVal() {
		return sortedVal;
	}

	public void setSortedVal(String sortedVal) {
		this.sortedVal = sortedVal;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
	}

}
