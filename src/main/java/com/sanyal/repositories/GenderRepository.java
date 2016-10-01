package com.sanyal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sanyal.models.Gender;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Integer>{

}
