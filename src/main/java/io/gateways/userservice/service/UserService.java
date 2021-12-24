package io.gateways.userservice.service;
/*
 * @author Abhilash GD
 * @Version 1.0
 * since 23/12/2021
 */
import io.gateways.userservice.domain.Role;
import io.gateways.userservice.domain.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    User getUser(String username);
    List<User> getUsers();
}
