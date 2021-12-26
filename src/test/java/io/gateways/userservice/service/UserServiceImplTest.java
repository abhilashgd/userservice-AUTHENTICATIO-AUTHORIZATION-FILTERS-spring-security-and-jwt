package io.gateways.userservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.gateways.userservice.domain.Role;
import io.gateways.userservice.domain.User;
import io.gateways.userservice.repo.RoleRepo;
import io.gateways.userservice.repo.UserRepo;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {UserServiceImpl.class})
@ExtendWith(SpringExtension.class)
class UserServiceImplTest {
    @MockBean
    private PasswordEncoder passwordEncoder;

    @MockBean
    private RoleRepo roleRepo;

    @MockBean
    private UserRepo userRepo;

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Test
    void testLoadUserByUsername() throws UsernameNotFoundException {
        User user = new User();
        user.setId(123L);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");
        when(this.userRepo.findByUsername((String) any())).thenReturn(user);
        UserDetails actualLoadUserByUsernameResult = this.userServiceImpl.loadUserByUsername("janedoe");
        assertTrue(actualLoadUserByUsernameResult.getAuthorities().isEmpty());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertEquals("janedoe", actualLoadUserByUsernameResult.getUsername());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        verify(this.userRepo).findByUsername((String) any());
        assertTrue(this.userServiceImpl.getUsers().isEmpty());
    }

    @Test
    void testLoadUserByUsername2() throws UsernameNotFoundException {
        when(this.userRepo.findByUsername((String) any())).thenThrow(new UsernameNotFoundException("Msg"));
        assertThrows(UsernameNotFoundException.class, () -> this.userServiceImpl.loadUserByUsername("janedoe"));
        verify(this.userRepo).findByUsername((String) any());
    }

    @Test
    void testLoadUserByUsername3() throws UsernameNotFoundException {
        Role role = new Role();
        role.setId(123L);
        role.setName("User found in the database: {}");

        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(role);

        User user = new User();
        user.setId(123L);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(roleList);
        user.setUsername("janedoe");
        when(this.userRepo.findByUsername((String) any())).thenReturn(user);
        UserDetails actualLoadUserByUsernameResult = this.userServiceImpl.loadUserByUsername("janedoe");
        assertEquals(1, actualLoadUserByUsernameResult.getAuthorities().size());
        assertEquals(
                "org.springframework.security.core.userdetails.User [Username=janedoe, Password=[PROTECTED], Enabled=true,"
                        + " AccountNonExpired=true, credentialsNonExpired=true, AccountNonLocked=true, Granted Authorities=[User"
                        + " found in the database: {}]]",
                actualLoadUserByUsernameResult.toString());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertEquals("janedoe", actualLoadUserByUsernameResult.getUsername());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        verify(this.userRepo).findByUsername((String) any());
        assertTrue(this.userServiceImpl.getUsers().isEmpty());
    }

    @Test
    void testLoadUserByUsername4() throws UsernameNotFoundException {
        Role role = new Role();
        role.setId(123L);
        role.setName("User found in the database: {}");

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("User found in the database: {}");

        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(role1);
        roleList.add(role);

        User user = new User();
        user.setId(123L);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(roleList);
        user.setUsername("janedoe");
        when(this.userRepo.findByUsername((String) any())).thenReturn(user);
        UserDetails actualLoadUserByUsernameResult = this.userServiceImpl.loadUserByUsername("janedoe");
        assertEquals(1, actualLoadUserByUsernameResult.getAuthorities().size());
        assertEquals(
                "org.springframework.security.core.userdetails.User [Username=janedoe, Password=[PROTECTED], Enabled=true,"
                        + " AccountNonExpired=true, credentialsNonExpired=true, AccountNonLocked=true, Granted Authorities=[User"
                        + " found in the database: {}]]",
                actualLoadUserByUsernameResult.toString());
        assertTrue(actualLoadUserByUsernameResult.isEnabled());
        assertTrue(actualLoadUserByUsernameResult.isCredentialsNonExpired());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonLocked());
        assertTrue(actualLoadUserByUsernameResult.isAccountNonExpired());
        assertEquals("janedoe", actualLoadUserByUsernameResult.getUsername());
        assertEquals("iloveyou", actualLoadUserByUsernameResult.getPassword());
        verify(this.userRepo).findByUsername((String) any());
        assertTrue(this.userServiceImpl.getUsers().isEmpty());
    }

    @Test
    void testSaveUser() {
        User user = new User();
        user.setId(123L);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");
        when(this.userRepo.save((User) any())).thenReturn(user);
        when(this.passwordEncoder.encode((CharSequence) any())).thenReturn("secret");

        User user1 = new User();
        user1.setId(123L);
        user1.setName("Name");
        user1.setPassword("iloveyou");
        user1.setRoles(new ArrayList<>());
        user1.setUsername("janedoe");
        assertSame(user, this.userServiceImpl.saveUser(user1));
        verify(this.userRepo).save((User) any());
        verify(this.passwordEncoder).encode((CharSequence) any());
        assertEquals("secret", user1.getPassword());
        assertTrue(this.userServiceImpl.getUsers().isEmpty());
    }

    @Test
    void testSaveUser2() {
        when(this.userRepo.save((User) any()))
                .thenThrow(new UsernameNotFoundException("saving new user {} to the database"));
        when(this.passwordEncoder.encode((CharSequence) any())).thenReturn("secret");

        User user = new User();
        user.setId(123L);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");
        assertThrows(UsernameNotFoundException.class, () -> this.userServiceImpl.saveUser(user));
        verify(this.userRepo).save((User) any());
        verify(this.passwordEncoder).encode((CharSequence) any());
    }

    @Test
    void testSaveRole() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        when(this.roleRepo.save((Role) any())).thenReturn(role);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");
        assertSame(role, this.userServiceImpl.saveRole(role1));
        verify(this.roleRepo).save((Role) any());
        assertTrue(this.userServiceImpl.getUsers().isEmpty());
    }

    @Test
    void testSaveRole2() {
        when(this.roleRepo.save((Role) any()))
                .thenThrow(new UsernameNotFoundException("saving new role {} to the database"));

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        assertThrows(UsernameNotFoundException.class, () -> this.userServiceImpl.saveRole(role));
        verify(this.roleRepo).save((Role) any());
    }

    @Test
    void testAddRoleToUser() {
        User user = new User();
        user.setId(123L);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");
        when(this.userRepo.findByUsername((String) any())).thenReturn(user);

        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        when(this.roleRepo.findByName((String) any())).thenReturn(role);
        this.userServiceImpl.addRoleToUser("janedoe", "Role Name");
        verify(this.userRepo).findByUsername((String) any());
        verify(this.roleRepo).findByName((String) any());
        assertTrue(this.userServiceImpl.getUsers().isEmpty());
    }

    @Test
    void testAddRoleToUser2() {
        User user = new User();
        user.setId(123L);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");
        when(this.userRepo.findByUsername((String) any())).thenReturn(user);
        when(this.roleRepo.findByName((String) any()))
                .thenThrow(new UsernameNotFoundException("Adding role {} to user {}"));
        assertThrows(UsernameNotFoundException.class, () -> this.userServiceImpl.addRoleToUser("janedoe", "Role Name"));
        verify(this.userRepo).findByUsername((String) any());
        verify(this.roleRepo).findByName((String) any());
    }

    @Test
    void testGetUser() {
        User user = new User();
        user.setId(123L);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");
        when(this.userRepo.findByUsername((String) any())).thenReturn(user);
        assertSame(user, this.userServiceImpl.getUser("janedoe"));
        verify(this.userRepo).findByUsername((String) any());
        assertTrue(this.userServiceImpl.getUsers().isEmpty());
    }

    @Test
    void testGetUser2() {
        when(this.userRepo.findByUsername((String) any())).thenThrow(new UsernameNotFoundException("Fetching user{}"));
        assertThrows(UsernameNotFoundException.class, () -> this.userServiceImpl.getUser("janedoe"));
        verify(this.userRepo).findByUsername((String) any());
    }

    @Test
    void testGetUsers() {
        ArrayList<User> userList = new ArrayList<>();
        when(this.userRepo.findAll()).thenReturn(userList);
        List<User> actualUsers = this.userServiceImpl.getUsers();
        assertSame(userList, actualUsers);
        assertTrue(actualUsers.isEmpty());
        verify(this.userRepo).findAll();
    }

    @Test
    void testGetUsers2() {
        when(this.userRepo.findAll()).thenThrow(new UsernameNotFoundException("Fetching all users"));
        assertThrows(UsernameNotFoundException.class, () -> this.userServiceImpl.getUsers());
        verify(this.userRepo).findAll();
    }
}

