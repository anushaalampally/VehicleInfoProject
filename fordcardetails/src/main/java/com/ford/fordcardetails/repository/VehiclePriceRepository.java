package com.ford.fordcardetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ford.fordcardetails.entity.VehiclePrice;

public interface VehiclePriceRepository extends JpaRepository<VehiclePrice, Integer>{
	
	
	@Query(value = "from VehiclePrice  where finalPrice BETWEEN :from AND :to")
	List<VehiclePrice> findByFinalPriceBetween(@Param("from")Double from,@Param("to")Double to);

}