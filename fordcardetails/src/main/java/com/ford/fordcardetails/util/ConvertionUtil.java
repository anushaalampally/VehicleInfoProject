package com.ford.fordcardetails.util;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;

import com.ford.fordcardetails.entity.Vehicle;
import com.ford.fordcardetails.entity.VehicleFeature;
import com.ford.fordcardetails.entity.VehiclePrice;
import com.ford.fordcardetails.model.VehicleDetails;
import com.ford.fordcardetails.model.VehicleFeatureModel;
import com.ford.fordcardetails.model.VehicleModel;
public class ConvertionUtil {
	
	
	public static List<VehicleModel> entitiesToModels(List<Vehicle> vehicleEnteties){
		List<VehicleModel>  vehicles=new ArrayList<>();
		for(Vehicle v:vehicleEnteties) {
		VehicleModel vehicle=	entityToModel(v);
		vehicles.add(vehicle);
		}
		return vehicles;
		
	}
	
	public static VehicleModel entityToModel(Vehicle vehicleEntity) {
		VehicleModel vehicle=null;
		if(vehicleEntity!=null) {
			vehicle=new VehicleModel();
			vehicle.setVehicleid(vehicleEntity.getVehicleid());
			VehicleDetails vehicleDetails=new VehicleDetails();
			vehicle.setVehicleDetails(vehicleDetails);
			vehicleDetails.setBodystyle(vehicleEntity.getBodystyle());
			vehicleDetails.setMake(vehicleEntity.getMake());
			vehicleDetails.setModel(vehicleEntity.getModel());
			vehicleDetails.setModelyear(vehicleEntity.getModelyear());
			vehicleDetails.setColor(vehicleEntity.getColor());
			vehicleDetails.setDrivetype(vehicleEntity.getDrivetype());
			vehicleDetails.setEngine(vehicleEntity.getEngine());
			vehicleDetails.setMPG(vehicleEntity.getMPG());
			vehicleDetails.setVehiclePrice(vehicleEntity.getVehiclePrice());
			VehicleFeatureModel vehicleFeatures=new VehicleFeatureModel();
			vehicleFeatures.setExterior(Arrays.asList(vehicleEntity.getVehicleFeature().getExterior().split(",")));
			vehicleFeatures.setInterior(Arrays.asList(vehicleEntity.getVehicleFeature().getInterior().split(",")));
			vehicleDetails.setVechileFeature(vehicleFeatures);
			
		}
		
		return vehicle;
	}

	
	public static Vehicle modelToEntity(VehicleModel vehicleModel) {
		Vehicle vehicle=null;
		if(vehicleModel!=null) {
			vehicle=new Vehicle();
			vehicle.setVehicleid(vehicleModel.getVehicleid());
			if(vehicleModel.getVehicleDetails()!=null) {
				VehicleDetails vehicleDetails=vehicleModel.getVehicleDetails();
				
				vehicle.setMake(vehicleDetails.getMake());
				vehicle.setModel(vehicleDetails.getModel());
				vehicle.setModelyear(vehicleDetails.getModelyear());
				vehicle.setDrivetype(vehicleDetails.getDrivetype());
				vehicle.setMPG(vehicleDetails.getMPG());
				vehicle.setEngine(vehicleDetails.getEngine());
				vehicle.setColor(vehicleDetails.getColor());
				vehicle.setBodystyle(vehicleDetails.getBodystyle());
				vehicle.setVehiclePrice(vehicleDetails.getVehiclePrice());
				for(VehiclePrice vp:vehicleDetails.getVehiclePrice()) {
					vp.setVehicle(vehicle);
					
				}
				
				
				if(vehicleDetails.getVechileFeature()!=null) {
					VehicleFeatureModel vehicleFeatureModel=vehicleDetails.getVechileFeature();
					VehicleFeature vehicleFeature=new VehicleFeature();
					vehicleFeature.setExterior(String.join(",", vehicleFeatureModel.getExterior()));
					vehicleFeature.setInterior(String.join(",", vehicleFeatureModel.getInterior()));
					vehicleFeature.setVehicle(vehicle);
					vehicle.setVehicleFeature(vehicleFeature);
					
					
				}
				
				
				
			}
			
			
		}
			
		
		
		
		return vehicle;
	}
}
