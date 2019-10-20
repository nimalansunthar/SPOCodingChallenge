package com.spo.codingchallenge.domain_objects;

import java.io.Serializable;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import com.spo.codingchallenge.annotations.CompareCapacity;

/**
 * Entity class definition. Here the DTO is used as entity object for simplicity.
 * @author ex1
 *
 */

@Entity
@CompareCapacity
public class JobDO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3840695361206368406L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	private Long id;	
	
	@Size(min=1, max=100, message="{rooms.size}")
	@ElementCollection
	private List<@Range(min =1, max=100, message="{rooms.range}") Integer> rooms;	
	
	@Range(min=2, message="{seniorCapacity.range}")
	@Digits(integer=3, fraction=0, message = "{seniorCapacity.digits}")
	private Integer seniorCapacity;
	
	@Range(min=1, message="{juniorCapacity.range}")
	@Digits(integer=3, fraction=0, message = "{juniorCapacity.digits}")
	private Integer juniorCapacity;	
	
	public JobDO() {
		super();
	}	

	public JobDO(
			@Size(min = 1, max = 100, message = "{rooms.size}") List<@Range(min = 1, max = 100, message = "{rooms.range}") Integer> rooms,
			@Range(min = 2, message = "{seniorCapacity.range}") @Digits(integer = 3, fraction = 0, message = "{seniorCapacity.digits}") Integer seniorCapacity,
			@Range(min = 1, message = "{juniorCapacity.range}") @Digits(integer = 3, fraction = 0, message = "{juniorCapacity.digits}") Integer juniorCapacity) {
		super();
		this.rooms = rooms;
		this.seniorCapacity = seniorCapacity;
		this.juniorCapacity = juniorCapacity;
	}
	
	public List<Integer> getRooms() {
		return rooms;
	}

	public void setRooms(List<Integer> rooms) {
		this.rooms = rooms;
	}

	public Integer getSeniorCapacity() {
		return seniorCapacity;
	}

	public void setSeniorCapacity(Integer seniorCapacity) {
		this.seniorCapacity = seniorCapacity;
	}

	public Integer getJuniorCapacity() {
		return juniorCapacity;
	}

	public void setJuniorCapacity(Integer juniorCapacity) {
		this.juniorCapacity = juniorCapacity;
	}	

}
