package com.sanyal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.sanyal.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	User findByUsername(String u);

}
