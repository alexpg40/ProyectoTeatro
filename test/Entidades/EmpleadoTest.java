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
 * @author Alex Perez
 */
public class EmpleadoTest {
    
    public EmpleadoTest() {
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
     * Test of getId method, of class Empleado.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Empleado instance = new Empleado();
        long expResult = 0L;
        long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Empleado.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        long id = 0L;
        Empleado instance = new Empleado();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Empleado.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Empleado instance = new Empleado();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Empleado.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Empleado instance = new Empleado();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApellidos method, of class Empleado.
     */
    @Test
    public void testGetApellidos() {
        System.out.println("getApellidos");
        Empleado instance = new Empleado();
        String expResult = "";
        String result = instance.getApellidos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setApellidos method, of class Empleado.
     */
    @Test
    public void testSetApellidos() {
        System.out.println("setApellidos");
        String apellidos = "";
        Empleado instance = new Empleado();
        instance.setApellidos(apellidos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNif method, of class Empleado.
     */
    @Test
    public void testGetNif() {
        System.out.println("getNif");
        Empleado instance = new Empleado();
        String expResult = "";
        String result = instance.getNif();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNif method, of class Empleado.
     */
    @Test
    public void testSetNif() {
        System.out.println("setNif");
        String nif = "";
        Empleado instance = new Empleado();
        instance.setNif(nif);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDireccion method, of class Empleado.
     */
    @Test
    public void testGetDireccion() {
        System.out.println("getDireccion");
        Empleado instance = new Empleado();
        String expResult = "";
        String result = instance.getDireccion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDireccion method, of class Empleado.
     */
    @Test
    public void testSetDireccion() {
        System.out.println("setDireccion");
        String direccion = "";
        Empleado instance = new Empleado();
        instance.setDireccion(direccion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTelefono method, of class Empleado.
     */
    @Test
    public void testGetTelefono() {
        System.out.println("getTelefono");
        Empleado instance = new Empleado();
        String expResult = "";
        String result = instance.getTelefono();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTelefono method, of class Empleado.
     */
    @Test
    public void testSetTelefono() {
        System.out.println("setTelefono");
        String telefono = "";
        Empleado instance = new Empleado();
        instance.setTelefono(telefono);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFranquicia method, of class Empleado.
     */
    @Test
    public void testGetFranquicia() {
        System.out.println("getFranquicia");
        Empleado instance = new Empleado();
        Franquicia expResult = null;
        Franquicia result = instance.getFranquicia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFranquicia method, of class Empleado.
     */
    @Test
    public void testSetFranquicia() {
        System.out.println("setFranquicia");
        Franquicia franquicia = null;
        Empleado instance = new Empleado();
        instance.setFranquicia(franquicia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of generarId method, of class Empleado.
     */
    @Test
    public void testGenerarId() {
        System.out.println("generarId");
        ArrayList<Empleado> empleados = null;
        Empleado instance = new Empleado();
        long expResult = 0L;
        long result = instance.generarId(empleados);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarNombre method, of class Empleado.
     */
    @Test
    public void testValidarNombre() {
        System.out.println("validarNombre");
        String nombre = "";
        Empleado instance = new Empleado();
        boolean expResult = false;
        boolean result = instance.validarNombre(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarApellidos method, of class Empleado.
     */
    @Test
    public void testValidarApellidos() {
        System.out.println("validarApellidos");
        String apellidos = "";
        Empleado instance = new Empleado();
        boolean expResult = false;
        boolean result = instance.validarApellidos(apellidos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarNIF method, of class Empleado.
     */
    @Test
    public void testValidarNIF() {
        System.out.println("validarNIF");
        String nif = "";
        ArrayList<Empleado> empleados = null;
        Empleado instance = new Empleado();
        boolean expResult = false;
        //boolean result = instance.validarNIF(nif, empleados);
       // assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarDireccion method, of class Empleado.
     */
    @Test
    public void testValidarDireccion() {
        System.out.println("validarDireccion");
        String direccion = "";
        Empleado instance = new Empleado();
        boolean expResult = false;
        boolean result = instance.validarDireccion(direccion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarTelefono method, of class Empleado.
     */
    @Test
    public void testValidarTelefono() {
        System.out.println("validarTelefono");
        String telefono = "";
        Empleado instance = new Empleado();
        boolean expResult = false;
        boolean result = instance.validarTelefono(telefono);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of nuevoEmpleado method, of class Empleado.
     */
    @Test
    public void testNuevoEmpleado() {
        System.out.println("nuevoEmpleado");
        ArrayList<Empleado> empleados = null;
        Empleado expResult = null;
        Empleado result = Empleado.nuevoEmpleado(empleados);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmpleadobyID method, of class Empleado.
     */
    @Test
    public void testGetEmpleadobyID() {
        System.out.println("getEmpleadobyID");
        long id = 0L;
        ArrayList<Empleado> array = null;
        Empleado expResult = null;
        Empleado result = Empleado.getEmpleadobyID(id, array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmpleadobyNIF method, of class Empleado.
     */
    @Test
    public void testGetEmpleadobyNIF() {
        System.out.println("getEmpleadobyNIF");
        String nif = "";
        ArrayList<Empleado> array = null;
        Empleado expResult = null;
        Empleado result = Empleado.getEmpleadobyNIF(nif, array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmpleadobyNombre method, of class Empleado.
     */
    @Test
    public void testGetEmpleadobyNombre() {
        System.out.println("getEmpleadobyNombre");
        String nombre = "";
        ArrayList<Empleado> array = null;
        ArrayList<Empleado> expResult = null;
        ArrayList<Empleado> result = Empleado.getEmpleadobyNombre(nombre, array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmpleadobyTelefono method, of class Empleado.
     */
    @Test
    public void testGetEmpleadobyTelefono() {
        System.out.println("getEmpleadobyTelefono");
        String telefono = "";
        ArrayList<Empleado> array = null;
        Empleado expResult = null;
        Empleado result = Empleado.getEmpleadobyTelefono(telefono, array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmpleadobyApellidos method, of class Empleado.
     */
    @Test
    public void testGetEmpleadobyApellidos() {
        System.out.println("getEmpleadobyApellidos");
        String apellidos = "";
        ArrayList<Empleado> array = null;
        ArrayList<Empleado> expResult = null;
        ArrayList<Empleado> result = Empleado.getEmpleadobyApellidos(apellidos, array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmpleadobyDireccion method, of class Empleado.
     */
    @Test
    public void testGetEmpleadobyDireccion() {
        System.out.println("getEmpleadobyDireccion");
        String direccion = "";
        ArrayList<Empleado> array = null;
        ArrayList<Empleado> expResult = null;
        ArrayList<Empleado> result = Empleado.getEmpleadobyDireccion(direccion, array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Empleado.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Empleado instance = new Empleado();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertirEmpleado method, of class Empleado.
     */
    @Test
    public void testConvertirEmpleado() {
        System.out.println("convertirEmpleado");
        Empleado[] array = null;
        ArrayList<Empleado> expResult = null;
        ArrayList<Empleado> result = Empleado.convertirEmpleado(array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarEmpleados method, of class Empleado.
     */
    @Test
    public void testMostrarEmpleados() {
        System.out.println("mostrarEmpleados");
        ArrayList<Empleado> array = null;
        Empleado.mostrarEmpleados(array);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of trabajarEn method, of class Empleado.
     */
    @Test
    public void testTrabajarEn() {
        System.out.println("trabajarEn");
        Franquicia franquicia = null;
        Empleado instance = new Empleado();
        instance.trabajarEn(franquicia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of añadirEmpleadobyID method, of class Empleado.
     */
    @Test
    public void testAñadirEmpleadobyID() {
        System.out.println("a\u00f1adirEmpleadobyID");
        long id = 0L;
        ArrayList<EmpleadoDeTeatro> empleadosTeatro = null;
        Empleado expResult = null;
        Empleado result = Empleado.añadirEmpleadobyID(id, empleadosTeatro);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of data method, of class Empleado.
     */
    @Test
    public void testData() {
        System.out.println("data");
        Empleado instance = new Empleado();
        String expResult = "";
        String result = instance.data();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarEmpledos method, of class Empleado.
     */
    @Test
    public void testGuardarEmpledos() {
        System.out.println("guardarEmpledos");
        ArrayList<Empleado> empleados = null;
        Empleado.guardarEmpledos(empleados);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarEmpleadosBinario method, of class Empleado.
     */
    @Test
    public void testGuardarEmpleadosBinario() {
        System.out.println("guardarEmpleadosBinario");
        ArrayList<Empleado> empleados = null;
        Empleado.guardarEmpleadosBinario(empleados);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarEmpleadoBinario method, of class Empleado.
     */
    @Test
    public void testGuardarEmpleadoBinario() {
        System.out.println("guardarEmpleadoBinario");
        Empleado instance = new Empleado();
        instance.guardarEmpleadoBinario();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leerFicheroBinario method, of class Empleado.
     */
    @Test
    public void testLeerFicheroBinario() {
        System.out.println("leerFicheroBinario");
        //Empleado.leerFicheroBinario();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leerFicheroBinarios method, of class Empleado.
     */
    @Test
    public void testLeerFicheroBinarios() {
        System.out.println("leerFicheroBinarios");
        //Empleado.leerFicheroBinarios();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of guardarEmpleado method, of class Empleado.
     */
    @Test
    public void testGuardarEmpleado() {
        System.out.println("guardarEmpleado");
        Empleado instance = new Empleado();
        instance.guardarEmpleado();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
