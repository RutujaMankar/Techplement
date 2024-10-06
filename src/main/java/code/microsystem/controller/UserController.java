package code.microsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import code.microsystem.dto.LoginRequest;
import code.microsystem.entity.User;
import code.microsystem.exception.UsernameNotFoundException;
import code.microsystem.service.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//Register User
	@PostMapping("/register")
	public ResponseEntity<User>register(@Valid @RequestBody User user){
		User registeredUser = userService.registerUser(user);
		return new ResponseEntity<>(registeredUser,HttpStatus.CREATED);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<String>loginUser( @Valid @RequestBody LoginRequest loginRequest){
		User user = userService.login(loginRequest.getUsername(),loginRequest.getPassword());
		return new ResponseEntity<>("Login Successful..!",HttpStatus.OK);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User>getUser(@PathVariable int id) throws UsernameNotFoundException{
		User user = userService.getUserById(id);
		return new ResponseEntity<>(user,HttpStatus.OK);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User user) throws UsernameNotFoundException {
        User updatedUser = userService.updateUser(id, user);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String>deleteUser(@PathVariable int id){
		userService.deleteUser(id);
		return new ResponseEntity<>("User Deleted " ,HttpStatus.OK);
		
	}
	
	@PostMapping("/addUserList")
    public ResponseEntity<List<User>> addUserList(@RequestBody List<User> users) {
        List<User> savedUsers = userService.saveUsers(users);
        return new ResponseEntity<>(savedUsers, HttpStatus.CREATED);
    }
	
	 @GetMapping("/getAllUsers")
	    public ResponseEntity<List<User>> getAllUsers() {
	        List<User> users = userService.getAllUsers();
	        return ResponseEntity.ok(users);
	    }
	
	
	

}
