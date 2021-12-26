package io.gateways.userservice.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RoleTest {
    @Test
    void testCanEqual() {
        assertFalse((new Role()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        Role role = new Role();

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");
        assertTrue(role.canEqual(role1));
    }

    @Test
    void testConstructor() {
        Role actualRole = new Role();
        actualRole.setId(123L);
        actualRole.setName("Name");
        assertEquals(123L, actualRole.getId().longValue());
        assertEquals("Name", actualRole.getName());
        assertEquals("Role(id=123, name=Name)", actualRole.toString());
    }

    @Test
    void testConstructor2() {
        Role actualRole = new Role(123L, "Name");
        actualRole.setId(123L);
        actualRole.setName("Name");
        assertEquals(123L, actualRole.getId().longValue());
        assertEquals("Name", actualRole.getName());
        assertEquals("Role(id=123, name=Name)", actualRole.toString());
    }

    @Test
    void testEquals() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        assertFalse(role.equals(null));
    }

    @Test
    void testEquals2() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        assertFalse(role.equals("Different type to Role"));
    }

    @Test
    void testEquals3() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");
        assertTrue(role.equals(role));
        int expectedHashCodeResult = role.hashCode();
        assertEquals(expectedHashCodeResult, role.hashCode());
    }

    @Test
    void testEquals4() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");
        assertTrue(role.equals(role1));
        int expectedHashCodeResult = role.hashCode();
        assertEquals(expectedHashCodeResult, role1.hashCode());
    }

    @Test
    void testEquals5() {
        Role role = new Role();
        role.setId(0L);
        role.setName("Name");

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");
        assertFalse(role.equals(role1));
    }

    @Test
    void testEquals6() {
        Role role = new Role();
        role.setId(null);
        role.setName("Name");

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");
        assertFalse(role.equals(role1));
    }

    @Test
    void testEquals7() {
        Role role = new Role();
        role.setId(123L);
        role.setName(null);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");
        assertFalse(role.equals(role1));
    }

    @Test
    void testEquals8() {
        Role role = new Role();
        role.setId(123L);
        role.setName("io.gateways.userservice.domain.Role");

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName("Name");
        assertFalse(role.equals(role1));
    }

    @Test
    void testEquals9() {
        Role role = new Role();
        role.setId(null);
        role.setName("Name");

        Role role1 = new Role();
        role1.setId(null);
        role1.setName("Name");
        assertTrue(role.equals(role1));
        int expectedHashCodeResult = role.hashCode();
        assertEquals(expectedHashCodeResult, role1.hashCode());
    }

    @Test
    void testEquals10() {
        Role role = new Role();
        role.setId(123L);
        role.setName(null);

        Role role1 = new Role();
        role1.setId(123L);
        role1.setName(null);
        assertTrue(role.equals(role1));
        int expectedHashCodeResult = role.hashCode();
        assertEquals(expectedHashCodeResult, role1.hashCode());
    }
}

