package com.javapoint.apachederbyexample.repository;

import org.springframework.data.repository.CrudRepository;

import com.javapoint.apachederbyexample.model.UserRecord;  
   
public interface UserRepository extends CrudRepository<UserRecord , Integer>   
{    
} 
