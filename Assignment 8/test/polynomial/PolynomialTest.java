/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package polynomial;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sjaak
 */
public class PolynomialTest {
    
    public PolynomialTest() {
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
     * Test of toString method, of class Polynomial.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Polynomial instance = new Polynomial();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of plus method, of class Polynomial.
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        Polynomial a = new Polynomial("3x^2");
        Polynomial b = new Polynomial("2x^2");
        a.plus(b);
        String testString = a.toString();
        if(!testString.contains("5x^2"))
            System.out.println("plus not working correctly");
        else
            System.out.println("plus working as intended");
    }

    /**
     * Test of minus method, of class Polynomial.
     */
    @Test
    public void testMinus() {
        System.out.println("minus");
        Polynomial a = new Polynomial("3x^2");
        Polynomial b = new Polynomial("2x^2");
        a.minus(b);
        String testString = a.toString();
        if(!testString.contains("x^2"))
            System.out.println("minus not working correctly");
        else
            System.out.println("minus working as intended");
    }

    /**
     * Test of times method, of class Polynomial.
     */
    @Test
    public void testTimes() {
        System.out.println("times");
        Polynomial a = new Polynomial("x^1");
        Polynomial b = new Polynomial("x^2");
        a.times(b);
        String testString = a.toString();
        if(!testString.contains("x^3"))
            System.out.println("times not working correctly");
        else
            System.out.println("times working as intended");
    }

    /**
     * Test of equals method, of class Polynomial.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Polynomial a = new Polynomial("3x^2");
        Polynomial b = new Polynomial("3x^2");
        if(!a.equals(b))
            System.out.println("equals not working correctly");
        else
            System.out.println("equals working as intended");
    }

    /**
     * Test of divide method, of class Polynomial.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        Polynomial a = new Polynomial("x^5");
        Polynomial b = new Polynomial("x^2");
        a.divide(b);
        String testString = a.toString();
        if(!testString.contains("x^3"))
            System.out.println("divide not working correctly");
        else
            System.out.println("divide working as intended");
    }
    
}
