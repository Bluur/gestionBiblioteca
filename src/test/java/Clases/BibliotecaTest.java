
package Clases;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Migue
 */
public class BibliotecaTest {
    
    public BibliotecaTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of addLibro method, of class Biblioteca.
     */
    @Test
    public void testAddLibro() {
        System.out.println("addLibro");
        Libro libro = null;
        Biblioteca instance = new Biblioteca();
        boolean expResult = false;
        boolean result = instance.addLibro(libro);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delLibro method, of class Biblioteca.
     */
    @Test
    public void testDelLibro() {
        System.out.println("delLibro");
        Libro libro = null;
        Biblioteca instance = new Biblioteca();
        boolean expResult = false;
        boolean result = instance.delLibro(libro);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
