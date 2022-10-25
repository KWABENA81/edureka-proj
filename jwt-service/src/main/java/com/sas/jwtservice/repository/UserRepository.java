package com.sas.jwtservice.repository;

import com.sas.jwtservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
     User findByUserNameAndPassword(String userName, String password);
}