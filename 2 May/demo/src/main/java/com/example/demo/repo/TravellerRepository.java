/**
 * 
 */
package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Traveller;

/**
 * @author lsampath
 *
 */
@Repository
public interface TravellerRepository extends CrudRepository <Traveller,Long>{
	
	public Traveller addTraveller(Traveller traveller);
}
