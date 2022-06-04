package com.cs.rapidapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cs.rapidapi.entity.Covid19Details;

@Repository
public interface Covid19DetailsRepository extends JpaRepository<Covid19Details, Long> {

}
