package com.ford.fordcardetails.entity;




import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Vehicle")
public class Vehicle {
	
	@Id
	private int vehicleid;
	@Column
	private String make;
	@Column(name="model")
	private String model;
	@Column
	private int modelyear;
	@Column
	private String bodystyle;
	@Column
	private String engine;
	@Column
	private String drivetype;
	@Column
	private String color;
	@Column
	private String MPG;
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="vehicle",cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JsonManagedReference
	private List<VehiclePrice> vehiclePrice;
	
	
	
	  @OneToOne(cascade=CascadeType.ALL,mappedBy="vehicle", fetch = FetchType.EAGER)
	  @JsonManagedReference
	  private VehicleFeature  vehicleFeature;
	 
	 
	
	 
	 
	

	
	
}
