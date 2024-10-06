package code.microsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import code.microsystem.encoder.BCryptPasswordEncoder;
import code.microsystem.entity.User;
import code.microsystem.exception.UsernameNotFoundException;
import code.microsystem.repository.UserRepository;
import jakarta.validation.Valid;

@Service
public class UserService {
	
	@Autowired
	public UserRepository userRepository ;

	public User registerUser(@Valid User user) {
		return userRepository.save(user);
	}

	public User login(String username, String password) {
		User user = userRepository.findByUsername(username);
		if(user !=null && user.getPassword().equals(password)) {
			return user;
		}
		return null;
		
}

	
	public User getUserById(int id) throws UsernameNotFoundException {
		return userRepository.findById(id)
				.orElseThrow(()-> new UsernameNotFoundException("User Not found with id " +id));
		
	}

	public User updateUser(int id, User updatedUser) throws UsernameNotFoundException {
        User user = getUserById(id);
        user.setEmail(updatedUser.getEmail());
        user.setUsername(updatedUser.getUsername());
        user.setAddress(updatedUser.getAddress());
        user.setPassword(updatedUser.getPassword());
        // Handle other fields
        return userRepository.save(user);
    }

	public void deleteUser(int id) {
		userRepository.deleteById(id);
		
	}

	public List<User> saveUsers(List<User> users) {
		return userRepository.saveAll(users);
	}

	public List<User> getAllUsers() {
		        return userRepository.findAll();
		    }
	}


