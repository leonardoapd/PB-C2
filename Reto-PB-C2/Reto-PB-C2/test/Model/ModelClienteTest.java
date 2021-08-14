/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Classes.Cliente;
import Classes.GeneradorDeClientes;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


/**
 *
 * @author Leonardo Perdomo
 */
@RunWith(MockitoJUnitRunner.class)
public class ModelClienteTest {

    public ModelClienteTest() {
    }
    
    @InjectMocks
    ModelCliente modeloCliente;
    
    @Mock
    GeneradorDeClientes clientes;

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
     * Test of buscar method, of class ModelCliente.
     */
    @Test
    public void testBuscar() {
        System.out.println("Se realizo el test de buscar cliente");
        ModelCliente modelInstance = new ModelCliente();
        int clienteAEncontrar = 7;
        Cliente clienteInstance = modelInstance.buscar(clienteAEncontrar);
        assertNotNull(clienteInstance);
    }
    
    @Test
    public void testCrear() {
        Mockito.when(clientes.retornarClientes()).thenReturn(new Cliente("Rafael Garcia", "Calle 56 No 9 30", "570354657890", "rgarcia@correo.com", 
                "Cartagena", "Bolivar", "C.C", 90456782, "12/08/1990", 7));
        assertEquals(true, modeloCliente.crear(clientes.retornarClientes()));
    }

}
