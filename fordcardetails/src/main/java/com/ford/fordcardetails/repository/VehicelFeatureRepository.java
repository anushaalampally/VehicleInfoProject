package com.ford.fordcardetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ford.fordcardetails.entity.Vehicle;
import com.ford.fordcardetails.entity.VehicleFeature;

public interface VehicelFeatureRepository extends JpaRepository<VehicleFeature, Integer>{
	
	//@Query("select u from VehicleFeature u where u.exterior like ?1% and u.interior like?%")
	List<VehicleFeature> findByExteriorLikeAndInteriorLike(String exterior,String interior);
	

}
