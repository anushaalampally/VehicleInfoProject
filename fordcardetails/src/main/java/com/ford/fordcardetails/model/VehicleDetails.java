package com.ford.fordcardetails.model;

import java.util.List;

import javax.persistence.Column;

import com.ford.fordcardetails.entity.VehiclePrice;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDetails {
	
	private String make;
	
	private String model;
	
	private int modelyear;
	
	private String bodystyle;
	
	private String engine;
	
	private String drivetype;
	
	private String color;
	
	private int MPG;
	
	private VehicleFeatureModel vechileFeature;
	
	private List<VehiclePrice> vehiclePrice;
	

}
