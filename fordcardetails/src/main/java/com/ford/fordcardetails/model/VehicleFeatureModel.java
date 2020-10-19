package com.ford.fordcardetails.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleFeatureModel {
	
	private List<String> exterior;
	
	private List<String> interior;

}
