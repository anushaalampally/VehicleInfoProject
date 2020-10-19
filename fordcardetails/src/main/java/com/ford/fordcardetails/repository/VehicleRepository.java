package com.ford.fordcardetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ford.fordcardetails.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
	
	List<Vehicle> findByModel(String model);
	
	

	
	/*
	 * //Vehicle findByVehiclePrice(String from, String to);
	 * 
	 * @Query("SELECT e FROM Employee e WHERE e.age = :age") public List
	 * findByAge(@Param("age") int age);
	 */
	
	/*
	 * @Query("SELECT e FROM Vehicle e WHERE e. = :age") List<Vehicle>
	 * findByVehiclePrice(String from, String to);
	 */
	
}
