package com.hcl.eTraining.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.eTraining.entity.User;


/**
 * @author Dev
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{

	Optional<User> findByUserMailAndPassword(String userMail,String password);
}
