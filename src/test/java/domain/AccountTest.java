/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author M
 */
public class AccountTest {
    
    public AccountTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUserName method, of class Account.
     */
    @Test
    public void testGetUserName() {
        System.out.println("getUserName");
        Account instance = new Account();
        instance.setName("rick");
        String expResult = "rick";
        String result = instance.getUserName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUserEmail method, of class Account.
     */
    @Test
    public void testGetUserEmail() {
        System.out.println("getUserEmail");
        Account instance = new Account();
        instance.setUserEmail("rick@hotmail.com");
        String expResult = "rick@hotmail.com";
        String result = instance.getUserEmail();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPassword method, of class Account.
     */
    @Test
    public void testGetPassword() {
        System.out.println("getPassword");
        Account instance = new Account();
        instance.setPassword("1234");
        String expResult = "1234";
        String result = instance.getPassword();
        assertEquals(expResult, result);
    }

    /**
     * Test of getId method, of class Account.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Account instance = new Account();
        instance.setId(1L);
        Long expResult = 1L;
        Long result = instance.getId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setUserName method, of class Account.
     */
    @Test
    public void testSetUserName() {
        System.out.println("setUserName");
        String name = "rick";
        Account instance = new Account();
        instance.setUserName(name);
        assertNotNull(instance.getUserName());
    }

    /**
     * Test of setUserEmail method, of class Account.
     */
    @Test
    public void testSetUserEmail() {
        System.out.println("setUserEmail");
        String email = "rick@hotmail.com";
        Account instance = new Account();
        instance.setUserEmail(email);
        assertNotNull(instance.getUserEmail());
    }

    /**
     * Test of setPassword method, of class Account.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        String password = "1234";
        Account instance = new Account();
        instance.setPassword(password);
        assertNotNull(instance.getPassword());
    }

    /**
     * Test of getName method, of class Account.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Account instance = new Account();
        instance.setName("rick");
        String expResult = "rick";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of setName method, of class Account.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "rick";
        Account instance = new Account();
        instance.setName(name);
        assertNotNull(instance.getName());
    }

    /**
     * Test of setId method, of class Account.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = 1L;
        Account instance = new Account();
        instance.setId(id);
        assertNotNull(instance.getId());
    }
    
}
