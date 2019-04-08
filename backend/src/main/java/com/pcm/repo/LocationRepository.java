package com.pcm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pcm.model.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
