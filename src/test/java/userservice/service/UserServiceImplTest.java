package userservice.service;

import userservice.common.*;
import userservice.domain.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

  @InjectMocks private UserServiceImpl userServiceImplMock;
  @Mock private UserRepository userRepositoryMock;
  
  @Test
  @Ignore
  public void testCreateUserProfile() {
    
      userServiceImplMock.createUserProfile(getUserProfile());
      
  }

  private UserProfile getUserProfile() {
      UserProfile profile = new UserProfile();
      return profile;
  }

}
