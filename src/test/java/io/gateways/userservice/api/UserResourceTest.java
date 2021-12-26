package io.gateways.userservice.api;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.gateways.userservice.domain.Role;
import io.gateways.userservice.domain.User;
import io.gateways.userservice.service.UserService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {UserResource.class})
@ExtendWith(SpringExtension.class)
class UserResourceTest {
    @Autowired
    private UserResource userResource;

    @MockBean
    private UserService userService;

    @Test
    void testGetUsers() throws Exception {
        when(this.userService.getUsers()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/users");
        MockMvcBuilders.standaloneSetup(this.userResource)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testSaveUser2() throws Exception {
        User user = new User();
        user.setId(123L);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");
        when(this.userService.saveUser((User) any())).thenReturn(user);

        User user1 = new User();
        user1.setId(123L);
        user1.setName("Name");
        user1.setPassword("iloveyou");
        user1.setRoles(new ArrayList<>());
        user1.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(user1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/user/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userResource)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string("{\"id\":123,\"name\":\"Name\",\"username\":\"janedoe\",\"password\":\"iloveyou\",\"roles\":[]}"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/api/user/save"));
    }

    @Test
    void testAddRoleToUser() throws Exception {
        doNothing().when(this.userService).addRoleToUser((String) any(), (String) any());

        RoleToUserForm roleToUserForm = new RoleToUserForm();
        roleToUserForm.setRoleName("Role Name");
        roleToUserForm.setUsername("janedoe");
        String content = (new ObjectMapper()).writeValueAsString(roleToUserForm);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/role/addtouser")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.userResource)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void testRefreshToken() throws Exception {
        SecurityMockMvcRequestBuilders.FormLoginRequestBuilder requestBuilder = SecurityMockMvcRequestBuilders.formLogin();
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userResource)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isNotFound());
    }

    @Test
    void testSaveUser() throws Exception {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        when(this.userService.saveRole((Role) any())).thenReturn(role);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");
        String content = (new ObjectMapper()).writeValueAsString(role1);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/role/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(this.userResource)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("{\"id\":123,\"name\":\"Name\"}"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/api/role/save"));
    }
}

