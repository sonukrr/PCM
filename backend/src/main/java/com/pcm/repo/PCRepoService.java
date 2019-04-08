package com.pcm.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcm.model.PC;


@Service
public class PCRepoService {

	public PCRepoService() {
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private PCRepository pcRepository;
	
	public PC savePc(PC pc){
		
		return pcRepository.save(pc);
		
	}
	
	public List<Object[]> pcDetails(){
		
		
		return pcRepository.pcDetails();
	}
	
}
