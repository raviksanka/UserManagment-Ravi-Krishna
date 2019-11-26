package userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/userService", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class UserServiceController {
	
	@Autowired private UserService userService;

	@PostMapping("/createUserProfile")
	public Boolean createUserProfile(@Valid @RequestBody UserProfile userProfile) {
		return userService.createUserProfile(userProfile);
	}
	
	@PostMapping("/updateUserProfile")
	public Boolean updateUserProfile(@Valid @RequestBody UserProfile userProfile) {
		return userService.updateUserProfile(userProfile);
	}
	
	@GetMapping("/fetchUserByEmail")
	public UserProfile fetchUserByEmail(String email) {
		return userService.fetchUserByEmail(email);
	}
	
	@GetMapping("/checkEmailExists")
	public Boolean checkEmailExists(String email) {
		return userService.fetchUserByEmail(email);
	}
	
	@PostMapping("/validateLogin")
	public Boolean validateLogin(@Valid @RequestBody UserProfile userProfile) {
		return userService.validateLogin(userProfile.getEmail(), userProfile.getPassword());
	}
  
}
