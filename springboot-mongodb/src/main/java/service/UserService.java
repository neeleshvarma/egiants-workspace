package service;

import java.util.List;
import java.util.Optional;

import org.omg.PortableServer.ThreadPolicyOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import document.Users;
import repository.UserRepository;

@SpringBootApplication

public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	
	public UserService()
	{
		
	}
	
	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

//	@GetMapping("/all")
	public List<Users> getAll() throws Exception{
		List<Users> users = (List<Users>) userRepository.findAll();
		return users;
	}
	
//@GetMapping("/{userId}")
	public Optional<Users> getUser(@PathVariable String userId) throws Exception  {
		if(userRepository.existsById(userId))
		{
			return userRepository.findById(userId);
		}
		else
		{
			throw new Exception("userId doesnt exists");
		}
	}
	

//	@DeleteMapping("delete/{userId}")
	public boolean deleteUser(@PathVariable String userId) throws Exception {
		if(userRepository.existsById(userId))
		{
			userRepository.deleteById(userId);
			return true;
		}
		else
		{
			throw new Exception("userId doesnt exists");
		}
		
	}
	
	
//	@PostMapping("/post")
	public void save(@RequestBody Users users) throws Exception {
		if(!userRepository.existsById(users.getUserId()))
			{
					userRepository.save(users);
			}
			else {			
				throw new Exception("userId already exists");
			}
	
    }

//	@PutMapping("/put/{userId}")
	public void update(@RequestBody Users users, @PathVariable String userId) throws Exception {
		if(userRepository.existsById(users.getUserId()))
		{
			userRepository.save(users);
		}
		else {
			throw new Exception("userId doesnt Exist");
		}
		
	}
	
	
}