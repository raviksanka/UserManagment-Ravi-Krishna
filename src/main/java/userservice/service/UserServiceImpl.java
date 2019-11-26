package userservice.service;

import userservice.common.*;
import userservice.domain.*;

@Component
public class UserServiceImpl implements UserService {

  @Autowired private AuthenticationUtil authUtil;
  @Autowired private UserRepository userRepository;
  
  @Override
  public Boolean createUserProfile(UserProfile userProfile) {

      String salt = authenticationUtil.generateSalt(30);
      // Generate secure user password 
      String secureUserPassword = null;
      try {
          secureUserPassword = authenticationUtil.generateSecurePassword(userProfile.getUserPassword(), salt);
      } catch (InvalidKeySpecException ex) {
          Logger.getLogger(UsersServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
          return false;
      }
      User user = new User();
      user.setFirstName(userProfile.getFirstName());
      user.setLastName(userProfile.getLastName());
      user.setEmail(userProfile.getEmail());
      user.setPassword(secureUserPassword);
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
      } else {
        //throw Exception...
        //log error...
        return false;
      }
  }
  
  @Override
  public UserProfile fetchUserByEmail(String email) {
    
      User user = userRepository.findByEmail(userProfile.getEmail());
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
    User user = userRepository.findByEmail(userProfile.getEmail());
    if(null != user) {
       return true;
      } else {
        // No User yet present with the email
        return false;
      }
  }
  
}
