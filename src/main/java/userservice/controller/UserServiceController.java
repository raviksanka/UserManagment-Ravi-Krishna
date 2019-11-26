package userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/userService", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin
public class UserServiceController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/createUserProfile")
	public Boolean createUserProfile(@Valid @RequestBody UserProfile userProfile) {
		return userService.createUserProfile(userProfile);
	}
  
}
