package com.ford.fordcardetails.model;

import java.util.List;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;
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
	
	private int modelYear;
	
	private String bodyStyle;
	
	private String engine;
	
	private String drivetype;
	
	private String color;
	
	@JsonProperty("MPG")
	private String mpg;
	
	private VehicleFeatureModel vehicleFeature;
	
	private List<VehiclePriceModel> vehiclePrice;
	

}
