package test.HAndM.solution.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sort_details")
public class SortDetails implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 9163750726010843278L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int detailsId;

	@Column(name = "input_data")
	private String inputVal;

	@Column(name = "sorted_data")
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

}
