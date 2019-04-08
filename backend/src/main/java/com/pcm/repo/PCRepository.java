package com.pcm.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcm.model.PC;

public interface PCRepository extends JpaRepository<PC, Integer> {

	public List<Object[]> pcDetails();
	
}
