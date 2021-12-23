package io.gateways.userservice.repo;
/*
 * @author Abhilash GD
 * @Version 1.0
 * since 23/12/2021
 */
import io.gateways.userservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {

    User findByUsername(String username);
}
