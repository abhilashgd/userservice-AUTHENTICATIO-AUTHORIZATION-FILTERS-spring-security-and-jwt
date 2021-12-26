package io.gateways.userservice.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.Test;

class UserTest {
    @Test
    void testCanEqual() {
        assertFalse((new User()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        User user = new User();

        User user1 = new User();
        user1.setId(123L);
        user1.setName("Name");
        user1.setPassword("iloveyou");
        user1.setRoles(new ArrayList<>());
        user1.setUsername("janedoe");
        assertTrue(user.canEqual(user1));
    }

    @Test
    void testConstructor() {
        User actualUser = new User();
        actualUser.setId(123L);
        actualUser.setName("Name");
        actualUser.setPassword("iloveyou");
        ArrayList<Role> roleList = new ArrayList<>();
        actualUser.setRoles(roleList);
        actualUser.setUsername("janedoe");
        assertEquals(123L, actualUser.getId().longValue());
        assertEquals("Name", actualUser.getName());
        assertEquals("iloveyou", actualUser.getPassword());
        assertSame(roleList, actualUser.getRoles());
        assertEquals("janedoe", actualUser.getUsername());
        assertEquals("User(id=123, name=Name, username=janedoe, password=iloveyou, roles=[])", actualUser.toString());
    }

    @Test
    void testConstructor2() {
        ArrayList<Role> roleList = new ArrayList<>();
        User actualUser = new User(123L, "Name", "janedoe", "iloveyou", roleList);
        actualUser.setId(123L);
        actualUser.setName("Name");
        actualUser.setPassword("iloveyou");
        ArrayList<Role> roleList1 = new ArrayList<>();
        actualUser.setRoles(roleList1);
        actualUser.setUsername("janedoe");
        assertEquals(123L, actualUser.getId().longValue());
        assertEquals("Name", actualUser.getName());
        assertEquals("iloveyou", actualUser.getPassword());
        Collection<Role> roles = actualUser.getRoles();
        assertSame(roleList1, roles);
        assertEquals(roleList, roles);
        assertEquals("janedoe", actualUser.getUsername());
        assertEquals("User(id=123, name=Name, username=janedoe, password=iloveyou, roles=[])", actualUser.toString());
    }

    @Test
    void testEquals() {
        User user = new User();
        user.setId(123L);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");
        assertFalse(user.equals(null));
    }

    @Test
    void testEquals2() {
        User user = new User();
        user.setId(123L);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");
        assertFalse(user.equals("Different type to User"));
    }

    @Test
    void testEquals3() {
        User user = new User();
        user.setId(123L);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");
        assertTrue(user.equals(user));
        int expectedHashCodeResult = user.hashCode();
        assertEquals(expectedHashCodeResult, user.hashCode());
    }

    @Test
    void testEquals4() {
        User user = new User();
        user.setId(123L);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setId(123L);
        user1.setName("Name");
        user1.setPassword("iloveyou");
        user1.setRoles(new ArrayList<>());
        user1.setUsername("janedoe");
        assertTrue(user.equals(user1));
        int expectedHashCodeResult = user.hashCode();
        assertEquals(expectedHashCodeResult, user1.hashCode());
    }

    @Test
    void testEquals5() {
        User user = new User();
        user.setId(0L);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setId(123L);
        user1.setName("Name");
        user1.setPassword("iloveyou");
        user1.setRoles(new ArrayList<>());
        user1.setUsername("janedoe");
        assertFalse(user.equals(user1));
    }

    @Test
    void testEquals6() {
        User user = new User();
        user.setId(null);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setId(123L);
        user1.setName("Name");
        user1.setPassword("iloveyou");
        user1.setRoles(new ArrayList<>());
        user1.setUsername("janedoe");
        assertFalse(user.equals(user1));
    }

    @Test
    void testEquals7() {
        User user = new User();
        user.setId(123L);
        user.setName("janedoe");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setId(123L);
        user1.setName("Name");
        user1.setPassword("iloveyou");
        user1.setRoles(new ArrayList<>());
        user1.setUsername("janedoe");
        assertFalse(user.equals(user1));
    }

    @Test
    void testEquals8() {
        User user = new User();
        user.setId(123L);
        user.setName(null);
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setId(123L);
        user1.setName("Name");
        user1.setPassword("iloveyou");
        user1.setRoles(new ArrayList<>());
        user1.setUsername("janedoe");
        assertFalse(user.equals(user1));
    }

    @Test
    void testEquals9() {
        User user = new User();
        user.setId(123L);
        user.setName("Name");
        user.setPassword("Name");
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setId(123L);
        user1.setName("Name");
        user1.setPassword("iloveyou");
        user1.setRoles(new ArrayList<>());
        user1.setUsername("janedoe");
        assertFalse(user.equals(user1));
    }

    @Test
    void testEquals10() {
        User user = new User();
        user.setId(123L);
        user.setName("Name");
        user.setPassword(null);
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setId(123L);
        user1.setName("Name");
        user1.setPassword("iloveyou");
        user1.setRoles(new ArrayList<>());
        user1.setUsername("janedoe");
        assertFalse(user.equals(user1));
    }

    @Test
    void testEquals11() {
        Role role = new Role();
        role.setId(123L);
        role.setName("Name");

        ArrayList<Role> roleList = new ArrayList<>();
        roleList.add(role);

        User user = new User();
        user.setId(123L);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(roleList);
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setId(123L);
        user1.setName("Name");
        user1.setPassword("iloveyou");
        user1.setRoles(new ArrayList<>());
        user1.setUsername("janedoe");
        assertFalse(user.equals(user1));
    }

    @Test
    void testEquals12() {
        User user = new User();
        user.setId(123L);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        user.setUsername("Name");

        User user1 = new User();
        user1.setId(123L);
        user1.setName("Name");
        user1.setPassword("iloveyou");
        user1.setRoles(new ArrayList<>());
        user1.setUsername("janedoe");
        assertFalse(user.equals(user1));
    }

    @Test
    void testEquals13() {
        User user = new User();
        user.setId(123L);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        user.setUsername(null);

        User user1 = new User();
        user1.setId(123L);
        user1.setName("Name");
        user1.setPassword("iloveyou");
        user1.setRoles(new ArrayList<>());
        user1.setUsername("janedoe");
        assertFalse(user.equals(user1));
    }

    @Test
    void testEquals14() {
        User user = new User();
        user.setId(null);
        user.setName("Name");
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setId(null);
        user1.setName("Name");
        user1.setPassword("iloveyou");
        user1.setRoles(new ArrayList<>());
        user1.setUsername("janedoe");
        assertTrue(user.equals(user1));
        int expectedHashCodeResult = user.hashCode();
        assertEquals(expectedHashCodeResult, user1.hashCode());
    }

    @Test
    void testEquals15() {
        User user = new User();
        user.setId(123L);
        user.setName(null);
        user.setPassword("iloveyou");
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setId(123L);
        user1.setName(null);
        user1.setPassword("iloveyou");
        user1.setRoles(new ArrayList<>());
        user1.setUsername("janedoe");
        assertTrue(user.equals(user1));
        int expectedHashCodeResult = user.hashCode();
        assertEquals(expectedHashCodeResult, user1.hashCode());
    }

    @Test
    void testEquals16() {
        User user = new User();
        user.setId(123L);
        user.setName("Name");
        user.setPassword(null);
        user.setRoles(new ArrayList<>());
        user.setUsername("janedoe");

        User user1 = new User();
        user1.setId(123L);
        user1.setName("Name");
        user1.setPassword(null);
        user1.setRoles(new ArrayList<>());
        user1.setUsername("janedoe");
        assertTrue(user.equals(user1));
        int expectedHashCodeResult = user.hashCode();
        assertEquals(expectedHashCodeResult, user1.hashCode());
    }
}

