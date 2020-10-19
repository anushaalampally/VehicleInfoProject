package com.ford.fordcardetails.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ford.fordcardetails.entity.Vehicle;
import com.ford.fordcardetails.entity.VehicleFeature;
import com.ford.fordcardetails.entity.VehiclePrice;
import com.ford.fordcardetails.model.VehicleModel;
import com.ford.fordcardetails.repository.VehicelFeatureRepository;
import com.ford.fordcardetails.repository.VehiclePriceRepository;
import com.ford.fordcardetails.repository.VehicleRepository;
import com.ford.fordcardetails.util.ConvertionUtil;

@Service
public class FordCarDetailsService {
	@Autowired
	VehicleRepository vehicleRepository;
	@Autowired
	VehiclePriceRepository vehiclePriceRepository;
	@Autowired
	VehicelFeatureRepository vehicelFeatureRepository;
	public List<VehicleModel> VehicleInformation() {
		List<Vehicle> vehicleEntities=vehicleRepository.findAll();
		List<VehicleModel> vehicles =ConvertionUtil.entitiesToModels(vehicleEntities);
		
		return vehicles;
	}
	public VehicleModel createVehicle(VehicleModel vehicleModel) {
		Vehicle theVehicle=ConvertionUtil.modelToEntity(vehicleModel);

		Vehicle vehicle = vehicleRepository.save(theVehicle);

		return ConvertionUtil.entityToModel(vehicle);

	}
	public List<VehicleModel> findVehicleModelName(String model) {
		  
		  
		List<Vehicle> vehicleEntities = vehicleRepository.findByModel(model);
		  
		List<VehicleModel> vehicles =ConvertionUtil.entitiesToModels(vehicleEntities);
		
		return vehicles;
		  
		  }
	public List<VehicleModel> findByVehiclePrice(int from, int to) {
		// TODO Auto-generated method stub
		//vehicleRepository.findByVehiclePrice();
		List<VehiclePrice> vehiclePrices=vehiclePriceRepository.findByFinalPriceBetween(from, to);
		List<Vehicle> vehicleEntities =vehiclePrices.stream().map(v->v.getVehicle()).distinct().collect(Collectors.toList());
		List<VehicleModel> vehicles =ConvertionUtil.entitiesToModels(vehicleEntities);
		
		return vehicles;
	}
	public List<VehicleModel> findVehicleByFeature(String exterior, String interior) {
		System.out.println("vehicleFeatures*****************exterior  "+exterior);
		System.out.println("vehicleFeatures*****************interior  "+interior);
		List<VehicleFeature> vehicleFeatures=vehicelFeatureRepository.findByExteriorLikeAndInteriorLike(exterior, interior);
		System.out.println("vehicleFeatures*****************"+vehicleFeatures);
		List<Vehicle> vehicleEntities =vehicleFeatures.stream().map(v->v.getVehicle()).distinct().collect(Collectors.toList());
		List<VehicleModel> vehicles =ConvertionUtil.entitiesToModels(vehicleEntities);
		
		return vehicles;
	}
}
