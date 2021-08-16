package com.lifestyle.appl.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifestyle.appl.beans.User;



public interface RegistrationRepository extends JpaRepository<User, Integer> {
public User findByEmailId(String emailId);

public User findByEmailIdAndPassword(String emailId,String password);
}
