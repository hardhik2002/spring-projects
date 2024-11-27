package com.javatpoint.server.main.user;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.RequestBody;  
import org.springframework.web.bind.annotation.RestController;  
@RestController  
public class UserResource   
{  
@Autowired  
private UserDaoService service;  
@GetMapping("/users")  
public List<user> retriveAllUsers()  
{  
return service.findAll();  
}  
//retrieves a specific user detail  
@GetMapping("/users/{id}")  
public User retriveUser(@PathVariable int id)  
{  
return service.findOne(id);  
}  
//method that posts a new user detail   
@PostMapping("/users")  
public void createUser(@RequestBody User user)  
{  
User sevedUser=service.save(user);    
}  
}  
