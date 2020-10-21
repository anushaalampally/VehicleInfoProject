package com.ford.fordcardetails.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleFeatureModel {
	@JsonProperty("Exterior")
	private List<String> exterior;
	@JsonProperty("Interior")
	private List<String> interior;

}
