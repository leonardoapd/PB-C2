/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author lperd
 */
public class ClienteTest {

    public ClienteTest() {
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
     * Test of aplicarFidelizacion method, of class Cliente.
     */
    @Test
    public void testAplicarFidelizacion() {
        System.out.println("Se realiza el test para aplicar fidelización");
        Cliente instance = new Cliente();
        instance.setFechaNacimiento("01-agosto-1997");
        instance.setCantidadCompras(200);
        instance.aplicarFidelizacion();
        assertEquals(true, instance.isFidelizacion());
    }

}
