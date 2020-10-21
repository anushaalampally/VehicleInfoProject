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
import com.ford.fordcardetails.model.VehiclePriceModel;
public class ConvertionUtil {
	
	
	
	
	public static VehicleModel entityToModel(Vehicle vehicleEntity) {
		VehicleModel vehicle=null;
		if(vehicleEntity!=null) {
			vehicle=new VehicleModel();
			
			vehicle.setVehicleId(vehicleEntity.getVehicleid());
			VehicleDetails vehicleDetails=new VehicleDetails();
			vehicle.setVehicleDetails(vehicleDetails);
			vehicleDetails.setBodyStyle(vehicleEntity.getBodystyle());
			vehicleDetails.setMake(vehicleEntity.getMake());
			vehicleDetails.setModel(vehicleEntity.getModel());
			vehicleDetails.setModelYear(vehicleEntity.getModelyear());
			vehicleDetails.setColor(vehicleEntity.getColor());
			vehicleDetails.setDrivetype(vehicleEntity.getDrivetype());
			vehicleDetails.setEngine(vehicleEntity.getEngine());
			vehicleDetails.setMpg(vehicleEntity.getMPG());
			List<VehiclePriceModel> vehiclePrices=new ArrayList<>();
			if(vehicleEntity.getVehiclePrice()!=null) {
				for(VehiclePrice vp:vehicleEntity.getVehiclePrice()) {
					VehiclePriceModel vpm=new VehiclePriceModel();
					vpm.setFinalPrice("$"+vp.getFinalPrice());
					vpm.setSavings("$"+vp.getSavings());
					vpm.setMsrp("$"+vp.getMSRP());
					vehiclePrices.add(vpm);
				}
			}
			
			vehicleDetails.setVehiclePrice(vehiclePrices);
			VehicleFeatureModel vehicleFeatures=new VehicleFeatureModel();
			vehicleFeatures.setExterior(Arrays.asList(vehicleEntity.getVehicleFeature().getExterior().split(",")));
			vehicleFeatures.setInterior(Arrays.asList(vehicleEntity.getVehicleFeature().getInterior().split(",")));
			vehicleDetails.setVehicleFeature(vehicleFeatures);
			
		}
		
		return vehicle;
	}

	
	public static Vehicle modelToEntity(VehicleModel vehicleModel) {
		Vehicle vehicle=null;
		if(vehicleModel!=null) {
			vehicle=new Vehicle();
			vehicle.setVehicleid(vehicleModel.getVehicleId());
			if(vehicleModel.getVehicleDetails()!=null) {
				VehicleDetails vehicleDetails=vehicleModel.getVehicleDetails();
				
				vehicle.setMake(vehicleDetails.getMake());
				vehicle.setModel(vehicleDetails.getModel());
				vehicle.setModelyear(vehicleDetails.getModelYear());
				vehicle.setDrivetype(vehicleDetails.getDrivetype());
				vehicle.setMPG(vehicleDetails.getMpg());
				vehicle.setEngine(vehicleDetails.getEngine());
				vehicle.setColor(vehicleDetails.getColor());
				vehicle.setBodystyle(vehicleDetails.getBodyStyle());
				List<VehiclePrice> vehiclePrices=new ArrayList<>();
			
				
				if(vehicleDetails.getVehiclePrice()!=null) {
					for(VehiclePriceModel vpm:vehicleDetails.getVehiclePrice()) {
						VehiclePrice vp=new VehiclePrice();
						vp.setMSRP(Double.parseDouble(vpm.getMsrp().replaceAll(",", "").replace("$", "")));
						vp.setSavings(Double.parseDouble(vpm.getSavings().replaceAll(",", "").replace("$", "")));
						vp.setFinalPrice(Double.parseDouble(vpm.getFinalPrice().replaceAll(",", "").replace("$", "")));
						vp.setVehicle(vehicle);
						vehiclePrices.add(vp);
					}
					
					
					
				}
				vehicle.setVehiclePrice(vehiclePrices);
				
				
				
				if(vehicleDetails.getVehicleFeature()!=null) {
					VehicleFeatureModel vehicleFeatureModel=vehicleDetails.getVehicleFeature();
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
	
	public static List<VehicleModel> entitiesToModels(List<Vehicle> vehicleEnteties){
		List<VehicleModel>  vehicles=new ArrayList<>();
		for(Vehicle v:vehicleEnteties) {
		VehicleModel vehicle=	entityToModel(v);
		vehicles.add(vehicle);
		}
		return vehicles;
		
	}
}
