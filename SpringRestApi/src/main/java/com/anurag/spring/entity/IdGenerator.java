package com.anurag.spring.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * @author anurag
 */
@Entity
@Table(name="ID_GENERATOR")
public class IdGenerator implements Serializable {

	 
	private static final long serialVersionUID = 1L;
	
	@Id
	Integer id;

	@Column(name="number")
	Integer number;
	
	@Version
	private Long version;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public IdGenerator() {
		 
	}
	
	
	public IdGenerator(Integer id) {
		super();
		this.id = id;
	}
	
	

}
