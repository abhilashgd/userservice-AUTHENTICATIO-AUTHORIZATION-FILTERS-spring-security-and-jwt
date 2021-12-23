package io.gateways.userservice.repo;
/*
 * @author Abhilash GD
 * @Version 1.0
 * since 23/12/2021
 */
import io.gateways.userservice.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {

    Role findByName(String name);
}
