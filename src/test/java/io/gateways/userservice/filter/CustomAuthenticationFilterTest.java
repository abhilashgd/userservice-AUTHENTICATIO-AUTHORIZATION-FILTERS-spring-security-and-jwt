package io.gateways.userservice.filter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.security.access.intercept.RunAsImplAuthenticationProvider;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;

class CustomAuthenticationFilterTest {
    @Test
    void testConstructor() {
        ArrayList<AuthenticationProvider> authenticationProviderList = new ArrayList<>();
        authenticationProviderList.add(new RunAsImplAuthenticationProvider());
        CustomAuthenticationFilter actualCustomAuthenticationFilter = new CustomAuthenticationFilter(
                new ProviderManager(authenticationProviderList));
        assertEquals("username", actualCustomAuthenticationFilter.getUsernameParameter());
        assertTrue(actualCustomAuthenticationFilter
                .getRememberMeServices() instanceof org.springframework.security.web.authentication.NullRememberMeServices);
        assertEquals("password", actualCustomAuthenticationFilter.getPasswordParameter());
    }

    @Test
    void testConstructor2() {
        ArrayList<AuthenticationProvider> authenticationProviderList = new ArrayList<>();
        authenticationProviderList.add(new RunAsImplAuthenticationProvider());
        CustomAuthenticationFilter actualCustomAuthenticationFilter = new CustomAuthenticationFilter(
                new ProviderManager(authenticationProviderList));
        assertEquals("username", actualCustomAuthenticationFilter.getUsernameParameter());
        assertTrue(actualCustomAuthenticationFilter
                .getRememberMeServices() instanceof org.springframework.security.web.authentication.NullRememberMeServices);
        assertEquals("password", actualCustomAuthenticationFilter.getPasswordParameter());
    }
}

