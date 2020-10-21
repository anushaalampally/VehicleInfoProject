package com.ford.fordcardetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ford.fordcardetails.entity.Vehicle;
import com.ford.fordcardetails.exception.InvalidFeaturesException;
import com.ford.fordcardetails.model.VehicleModel;
import com.ford.fordcardetails.repository.VehicleRepository;
import com.ford.fordcardetails.service.FordCarDetailsService;
import com.ford.fordcardetails.util.Response;

@RestController
public class FordCarDetailsController {
	@Autowired
	FordCarDetailsService fordCarDetailsService;

	@RequestMapping("/helloworld")
	public String helloworld() {
		return "welcome helloworld";
	}

	@GetMapping("/getVehicleInformation")
	public List<VehicleModel> vehicleInformation() {
	
		List<VehicleModel> vehicles = fordCarDetailsService.VehicleInformation();
		
		return vehicles;
	}
	
	@PostMapping("/vehicleinformation/submitVehicle")
	public ResponseEntity<Response> createVehicleDetails(@RequestBody VehicleModel theVehicle) {
		Response response=new Response();
		
	
		
		
		VehicleModel vehicle = fordCarDetailsService.createVehicle(theVehicle);
		int vehicleid=vehicle.getVehicleId();
		response.setMessage(vehicleid+" submitted successfully into the database");
		response.setStatus( HttpStatus.OK.name());
		response.setStatuscode(HttpStatus.OK.toString());
		

		return new ResponseEntity<Response>(response,HttpStatus.OK);

	} 
		  //Retrive vehicle(s) of matching modelName
		  
		  
		  @GetMapping("/getVehicleModelName/{model}") 
		  public ResponseEntity<List<VehicleModel>> findVehicleModelName(@PathVariable String model) {
		  
		  
			  List<VehicleModel> vehicles = fordCarDetailsService.findVehicleModelName(model);
		  
		  
		  return new ResponseEntity<List<VehicleModel>>(vehicles,HttpStatus.OK);
		  
		  }
		 
	  
	 

	
	  @GetMapping("/getVehicleprice/{from}/{to}")
	  public ResponseEntity<List<VehicleModel>> findVehiclePrice(@PathVariable String from, @PathVariable String to) throws Exception {
		  int fromInt=0;
		  int toInt=0;
		  try {
		   fromInt=Integer.valueOf(from.replaceAll(",", ""));
		   toInt=Integer.valueOf(to.replaceAll(",", ""));
		  }catch(Exception e) {
			  throw new Exception("Enter Valid number for price values",e);
		  }
		  
		  List<VehicleModel> vehicles = fordCarDetailsService.findByVehiclePrice(fromInt, toInt);
	  
	  return new ResponseEntity<List<VehicleModel>>(vehicles, HttpStatus.OK);
	  
	  }
	 
	  
	  @GetMapping("/getVehicleByFeatures/{exterior}/{interior}")
	  public ResponseEntity<List<VehicleModel>> findVehicleByFeature(@PathVariable String exterior, @PathVariable String interior) throws InvalidFeaturesException {
		  if(exterior.length()<3||interior.length()<3)
			  throw new InvalidFeaturesException("Exterior and Interior input Length should be more than 3 Charatcers");
		 
		  List<VehicleModel> vehicles = fordCarDetailsService.findVehicleByFeature(exterior, interior);
	  
	  return new ResponseEntity<List<VehicleModel>>(vehicles, HttpStatus.OK);
	  
	  }

}
