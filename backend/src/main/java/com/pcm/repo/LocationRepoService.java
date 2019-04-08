package com.pcm.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcm.model.Location;


@Service
public class LocationRepoService {

	public LocationRepoService() {
		// TODO Auto-generated constructor stub
	}
	
	
	@Autowired
	private LocationRepository locationRepository;
	
	public List<Location >fetchallLocation(){
		return locationRepository.findAll();
	}
	

}
