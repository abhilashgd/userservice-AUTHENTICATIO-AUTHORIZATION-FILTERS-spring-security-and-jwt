package io.gateways.userservice.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RoleToUserFormTest {
    @Test
    void testCanEqual() {
        assertFalse((new RoleToUserForm()).canEqual("Other"));
    }

    @Test
    void testCanEqual2() {
        RoleToUserForm roleToUserForm = new RoleToUserForm();

        RoleToUserForm roleToUserForm1 = new RoleToUserForm();
        roleToUserForm1.setRoleName("Role Name");
        roleToUserForm1.setUsername("janedoe");
        assertTrue(roleToUserForm.canEqual(roleToUserForm1));
    }

    @Test
    void testConstructor() {
        RoleToUserForm actualRoleToUserForm = new RoleToUserForm();
        actualRoleToUserForm.setRoleName("Role Name");
        actualRoleToUserForm.setUsername("janedoe");
        assertEquals("Role Name", actualRoleToUserForm.getRoleName());
        assertEquals("janedoe", actualRoleToUserForm.getUsername());
        assertEquals("RoleToUserForm(username=janedoe, roleName=Role Name)", actualRoleToUserForm.toString());
    }

    @Test
    void testEquals() {
        RoleToUserForm roleToUserForm = new RoleToUserForm();
        roleToUserForm.setRoleName("Role Name");
        roleToUserForm.setUsername("janedoe");
        assertFalse(roleToUserForm.equals(null));
    }

    @Test
    void testEquals2() {
        RoleToUserForm roleToUserForm = new RoleToUserForm();
        roleToUserForm.setRoleName("Role Name");
        roleToUserForm.setUsername("janedoe");
        assertFalse(roleToUserForm.equals("Different type to RoleToUserForm"));
    }

    @Test
    void testEquals3() {
        RoleToUserForm roleToUserForm = new RoleToUserForm();
        roleToUserForm.setRoleName("Role Name");
        roleToUserForm.setUsername("janedoe");
        assertTrue(roleToUserForm.equals(roleToUserForm));
        int expectedHashCodeResult = roleToUserForm.hashCode();
        assertEquals(expectedHashCodeResult, roleToUserForm.hashCode());
    }

    @Test
    void testEquals4() {
        RoleToUserForm roleToUserForm = new RoleToUserForm();
        roleToUserForm.setRoleName("Role Name");
        roleToUserForm.setUsername("janedoe");

        RoleToUserForm roleToUserForm1 = new RoleToUserForm();
        roleToUserForm1.setRoleName("Role Name");
        roleToUserForm1.setUsername("janedoe");
        assertTrue(roleToUserForm.equals(roleToUserForm1));
        int expectedHashCodeResult = roleToUserForm.hashCode();
        assertEquals(expectedHashCodeResult, roleToUserForm1.hashCode());
    }

    @Test
    void testEquals5() {
        RoleToUserForm roleToUserForm = new RoleToUserForm();
        roleToUserForm.setRoleName("janedoe");
        roleToUserForm.setUsername("janedoe");

        RoleToUserForm roleToUserForm1 = new RoleToUserForm();
        roleToUserForm1.setRoleName("Role Name");
        roleToUserForm1.setUsername("janedoe");
        assertFalse(roleToUserForm.equals(roleToUserForm1));
    }

    @Test
    void testEquals6() {
        RoleToUserForm roleToUserForm = new RoleToUserForm();
        roleToUserForm.setRoleName(null);
        roleToUserForm.setUsername("janedoe");

        RoleToUserForm roleToUserForm1 = new RoleToUserForm();
        roleToUserForm1.setRoleName("Role Name");
        roleToUserForm1.setUsername("janedoe");
        assertFalse(roleToUserForm.equals(roleToUserForm1));
    }

    @Test
    void testEquals7() {
        RoleToUserForm roleToUserForm = new RoleToUserForm();
        roleToUserForm.setRoleName("Role Name");
        roleToUserForm.setUsername("Role Name");

        RoleToUserForm roleToUserForm1 = new RoleToUserForm();
        roleToUserForm1.setRoleName("Role Name");
        roleToUserForm1.setUsername("janedoe");
        assertFalse(roleToUserForm.equals(roleToUserForm1));
    }

    @Test
    void testEquals8() {
        RoleToUserForm roleToUserForm = new RoleToUserForm();
        roleToUserForm.setRoleName("Role Name");
        roleToUserForm.setUsername(null);

        RoleToUserForm roleToUserForm1 = new RoleToUserForm();
        roleToUserForm1.setRoleName("Role Name");
        roleToUserForm1.setUsername("janedoe");
        assertFalse(roleToUserForm.equals(roleToUserForm1));
    }

    @Test
    void testEquals9() {
        RoleToUserForm roleToUserForm = new RoleToUserForm();
        roleToUserForm.setRoleName(null);
        roleToUserForm.setUsername("janedoe");

        RoleToUserForm roleToUserForm1 = new RoleToUserForm();
        roleToUserForm1.setRoleName(null);
        roleToUserForm1.setUsername("janedoe");
        assertTrue(roleToUserForm.equals(roleToUserForm1));
        int expectedHashCodeResult = roleToUserForm.hashCode();
        assertEquals(expectedHashCodeResult, roleToUserForm1.hashCode());
    }

    @Test
    void testEquals10() {
        RoleToUserForm roleToUserForm = new RoleToUserForm();
        roleToUserForm.setRoleName("Role Name");
        roleToUserForm.setUsername(null);

        RoleToUserForm roleToUserForm1 = new RoleToUserForm();
        roleToUserForm1.setRoleName("Role Name");
        roleToUserForm1.setUsername(null);
        assertTrue(roleToUserForm.equals(roleToUserForm1));
        int expectedHashCodeResult = roleToUserForm.hashCode();
        assertEquals(expectedHashCodeResult, roleToUserForm1.hashCode());
    }
}

