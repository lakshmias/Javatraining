package com.dal.firstsprboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dal.firstsprboot.entity.LocalTour;


@Repository
public interface LocalTourRepository extends CrudRepository<LocalTour, Long>{

}