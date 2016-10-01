package com.sanyal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sanyal.models.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Integer>{

}
