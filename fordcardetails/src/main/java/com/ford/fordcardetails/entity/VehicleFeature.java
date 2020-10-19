package com.ford.fordcardetails.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
public class VehicleFeature {
	
	@Id
	@GeneratedValue
	private int id;
	
	
	  @OneToOne(fetch=FetchType.EAGER,cascade= {CascadeType.PERSIST, CascadeType.MERGE,
				 CascadeType.DETACH, CascadeType.REFRESH})
	  @JoinColumn(name="vehicleid") 
	  @JsonBackReference
	  private Vehicle vehicle;
	 
	 
	@Column 
	private String exterior;
	
	@Column 
	private String interior;
	
	
	
	
	
	
	
}
