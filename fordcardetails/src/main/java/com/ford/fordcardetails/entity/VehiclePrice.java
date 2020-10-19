package com.ford.fordcardetails.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Component
@Getter
@Setter
@Entity
@Table(name="VEHICLE_PRICE")
public class VehiclePrice {
	
	@Id 
	@GeneratedValue
	@JsonIgnore
	private int vehiclepriceid;
	 
	@Column
	private String MSRP;
	@Column
	private String Savings;
	@Column
	private String	finalprice;
	
	@ManyToOne(fetch=FetchType.LAZY,cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JsonBackReference
	@JoinColumn(name = "vehicleid")
	private Vehicle vehicle;

}
