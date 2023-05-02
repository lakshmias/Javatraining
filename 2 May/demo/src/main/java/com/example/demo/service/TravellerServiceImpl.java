/**
 * 
 */
package com.example.demo.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Traveller;
import com.example.demo.repo.TravellerRepository;

/**
 * @author lsampath
 *
 */
@Service
public class TravellerServiceImpl implements TravellerRepository{

	/**
	 * 
	 */
	public TravellerServiceImpl() 
	{
		// TODO Auto-generated constructor stub
	}

	@Override
	public <S extends Traveller> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends Traveller> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Traveller> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<Traveller> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Traveller> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Traveller entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAllById(Iterable<? extends Long> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll(Iterable<? extends Traveller> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Traveller addTraveller(Traveller traveller) {
		// TODO Auto-generated method stub
		return null;
	}

}
