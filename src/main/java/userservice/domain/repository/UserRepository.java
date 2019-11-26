package userservice.domain.repository;

import org.springframework.data.jpa.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import userservice.domain.entity.User;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long> {
     User findByEmail(String email);
}
