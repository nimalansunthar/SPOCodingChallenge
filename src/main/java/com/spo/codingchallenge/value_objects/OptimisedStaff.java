package com.spo.codingchallenge.value_objects;

/**
 * Value object to save related values while calculating.
 * @author ex1
 *
 */
public class OptimisedStaff {
	
	private Integer minDiff;
	private Integer seniorCount;
	private Integer juniorCount;
	private Integer jobCapacity;
	
	
	
	public OptimisedStaff(Integer minDiff, Integer seniorCount, Integer juniorCount) {
		super();
		this.minDiff = minDiff;
		this.seniorCount = seniorCount;
		this.juniorCount = juniorCount;
	}	
	
	
	public OptimisedStaff(Integer minDiff, Integer seniorCount, Integer juniorCount, Integer jobCapacity) {
		super();
		this.minDiff = minDiff;
		this.seniorCount = seniorCount;
		this.juniorCount = juniorCount;
		this.jobCapacity = jobCapacity;
	}


	public Integer getMinDiff() {
		return minDiff;
	}
	public void setMinDiff(Integer minDiff) {
		this.minDiff = minDiff;
	}
	public Integer getSeniorCount() {
		return seniorCount;
	}
	public void setSeniorCount(Integer seniorCount) {
		this.seniorCount = seniorCount;
	}
	public Integer getJuniorCount() {
		return juniorCount;
	}
	public void setJuniorCount(Integer juniorCount) {
		this.juniorCount = juniorCount;
	}

	public Integer getJobCapacity() {
		return jobCapacity;
	}

	public void setJobCapacity(Integer jobCapacity) {
		this.jobCapacity = jobCapacity;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jobCapacity == null) ? 0 : jobCapacity.hashCode());
		result = prime * result + ((juniorCount == null) ? 0 : juniorCount.hashCode());
		result = prime * result + ((minDiff == null) ? 0 : minDiff.hashCode());
		result = prime * result + ((seniorCount == null) ? 0 : seniorCount.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OptimisedStaff other = (OptimisedStaff) obj;
		if (jobCapacity == null) {
			if (other.jobCapacity != null)
				return false;
		} else if (!jobCapacity.equals(other.jobCapacity))
			return false;
		if (juniorCount == null) {
			if (other.juniorCount != null)
				return false;
		} else if (!juniorCount.equals(other.juniorCount))
			return false;
		if (minDiff == null) {
			if (other.minDiff != null)
				return false;
		} else if (!minDiff.equals(other.minDiff))
			return false;
		if (seniorCount == null) {
			if (other.seniorCount != null)
				return false;
		} else if (!seniorCount.equals(other.seniorCount))
			return false;
		return true;
	}	

}
