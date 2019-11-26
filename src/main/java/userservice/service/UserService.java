package userservice.service;

public interface UserService {
    Boolean createUserProfile(UserProfile userProfile);
    Boolean updateUserProfile(UserProfile userProfile);
    UserProfile fetchUserByEmail(String email);
    Boolean checkEmailExists(String email);
    Boolean validateLogin(String email, String password);
}
