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
        
    }

}
