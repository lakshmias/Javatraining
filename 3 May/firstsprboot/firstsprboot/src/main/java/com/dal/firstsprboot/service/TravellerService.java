package com.dal.firstsprboot.service;

import java.util.List;
import java.util.Optional;

import com.dal.firstsprboot.entity.ForeignTour;
import com.dal.firstsprboot.entity.LocalTour;
import com.dal.firstsprboot.entity.Traveller;

public interface TravellerService {
	public Traveller addTraveller(Traveller traveller);
	public LocalTour saveLocalTourRequest(LocalTour localTour);
	public ForeignTour saveForeignTourRequest(ForeignTour foreignTour);
	public List<Traveller> getTravellerList();
	public Optional<Traveller> getTravellerByID(long tid);
}
