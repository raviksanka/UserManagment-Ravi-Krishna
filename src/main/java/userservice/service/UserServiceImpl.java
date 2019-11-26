package userservice.service;

import userservice.common.*;
import userservice.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

  @Autowired private AuthenticationUtil authUtil;
  @Autowired private UserRepository userRepository;
  @Autowired private BCryptPasswordEncoder bCryptPasswordEncoder;
  
  @Override
  public Boolean createUserProfile(UserProfile userProfile) {

      User user = new User();
      user.setFirstName(userProfile.getFirstName());
      user.setLastName(userProfile.getLastName());
      user.setEmail(userProfile.getEmail());
      user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
      userRepository.save(user);
      return true;
  }
  
  @Override
  public Boolean updateUserProfile(UserProfile userProfile) {

      User user = userRepository.findByEmail(userProfile.getEmail());
      if(null != user) {
        user.setFirstName(userProfile.getFirstName());
        user.setLastName(userProfile.getLastName());
        userRepository.save(user);
        return true;
      }
      //throw Exception user not found to update...
      //log error...
      return false;
  }
  
  @Override
  public UserProfile fetchUserByEmail(String email) {
    
      User user = userRepository.findByEmail(email);
      if(null != user) {
        UserProfile userProfile = new UserProfile();
        userProfile.setFirstName(user.getFirstName());
        userProfile.setLastName(user.getLastName());
        userProfile.setEmail(user.getEmail());
        return userProfile;
      } else {
        // User with email not found
        return null;
      }
  }
  
  @Override
  public Boolean checkEmailExists(String email) {
    User user = userRepository.findByEmail(email);
    if(null != user) {
       return true;
     }
    // No User yet present with the email
    return false;
  }
  
  @Override
  public Boolean validateLogin(String email, String password) {
    User user = userRepository.findByEmail(email);
    if(null != user) {
        boolean passwordMatches = bCryptPasswordEncoder.matches(password, user.getPassword());
        if(passwordMatches) {
          return true;
        } else {
          //Throw error - Invalid email password combo
          return false;
        }
      }
      // Return user not found error
      return false;
  }
  
}
