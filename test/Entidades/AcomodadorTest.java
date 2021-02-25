/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sandr
 */
public class AcomodadorTest {
    
    public AcomodadorTest() {
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
     * Test of toString method, of class Acomodador.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Acomodador instance = new Acomodador();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCostes method, of class Acomodador.
     */
    @Test
    public void testGetCostes() {
        System.out.println("getCostes");
        Acomodador instance = new Acomodador();
        ArrayList<Coste> expResult = null;
        ArrayList<Coste> result = instance.getCostes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBeneficios method, of class Acomodador.
     */
    @Test
    public void testSetBeneficios() {
        System.out.println("setBeneficios");
        ArrayList<Coste> costes = null;
        Acomodador instance = new Acomodador();
        instance.setBeneficios(costes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nuevoAcomodador method, of class Acomodador.
     */
    @Test
    public void testNuevoAcomodador() {
        System.out.println("nuevoAcomodador");
        ArrayList<Empleado> empleados = null;
        Acomodador expResult = null;
        Acomodador result = Acomodador.nuevoAcomodador(empleados);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
