package resource;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import document.Users;
import repository.UserRepository;
import service.UserService;


@RestController
@RequestMapping("/rest/users")
public class UsersResource {
	
	@Autowired
	UserService userService;
	
	public UsersResource() {
		
	}
	
	public UsersResource(UserService userService) {
		super();
		this.userService = userService;
	}


	@GetMapping("/all")
	public List<Users> getAll() throws Exception{
		List<Users> users = (List<Users>) userService.getAll();
		return users;
	}
	
	@GetMapping("/{userId}")
	public Optional<Users> getUser(@PathVariable String userId) throws Exception  {
		return userService.getUser(userId);
	}
	

	@DeleteMapping("delete/{userId}")
	public boolean deleteUser(@PathVariable String userId) throws Exception {
		userService.deleteUser(userId);
		return true;
	}
	
	
	@PostMapping("/post")
	public void save(@RequestBody Users users) throws Exception {
	
			userService.save(users);
	}
	
	@PutMapping("/put/{userId}")
	public void update(@RequestBody Users users, @PathVariable String userId) throws Exception {
		userService.update(users, userId);
	}
	

}
