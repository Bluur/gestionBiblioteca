
package Clases;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author Migue
 */
public class AutorTest {
    
    Autor federico;
    Autor pedro;
    
    public AutorTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        federico = new Autor("Federico",  "García Lorca", 1898, true);
        pedro = new Autor("Pedro Antonio", "de Alarcón", 1833, true);
    }
    
    @AfterEach
    public void tearDown() {
    }
    
    @ParameterizedTest
    @CsvSource({
        "Fed, García Lorca, 1898, true, El nombre no es válido",
        "Pedro Antonio, de Alarcón, 1733, true, El año no puede ser menor que 1800",
    })
    public void testConstructor(String nombre, String apellido, int year, boolean esAndaluz, String expRes){
        Exception excepcion = assertThrows(IllegalArgumentException.class, () ->{
            Autor temporal = new Autor(nombre, apellido, year, esAndaluz);
        });
        
        assertEquals(expRes, excepcion.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
        "Federico, García Lorca, 1898, true, Federico",
        "Pedro Antonio, de Alarcón, 1833, true, Pedro Antonio"
    })
    public void testGetNombre(String nombre, String apellidos, int year, boolean esAndaluz, String expRes) {
        Autor temporal = new Autor(nombre, apellidos, year, esAndaluz);
        assertEquals(expRes, temporal.getNombre());
    }

    @ParameterizedTest
    @CsvSource({
        "Federico, García Lorca, 1898, true, Federico",
        "Pedro Antonio, de Alarcón, 1833, true, Pedro Antonio"
    })
    public void testSetNombre(String nombre, String apellidos, int year, boolean esAndaluz, String expRes) {
        Autor temporal = new Autor(nombre, apellidos, year, esAndaluz);
        
        Exception excepcion = assertThrows(IllegalArgumentException.class, () ->{
            temporal.setNombre("");
        });
        
        assertEquals("El nombre no es válido", excepcion.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
        "Federico, García Lorca, 1898, true, García Lorca",
        "Pedro Antonio, de Alarcón, 1833, true, de Alarcón"
    })
    public void testGetApellidos(String nombre, String apellidos, int year, boolean esAndaluz, String expRes) {
        Autor temporal = new Autor(nombre, apellidos, year, esAndaluz);
        assertEquals(expRes, temporal.getApellidos());
    }

    @ParameterizedTest
    @CsvSource({
        "Federico, García Lorca, 1898, true, Los apellidos no pueden estar vacios",
        "Pedro Antonio, de Alarcón, 1833, true, Los apellidos no pueden estar vacios"
    })
    public void testSetApellidos(String nombre, String apellidos, int year, boolean esAndaluz, String expRes) {
        Autor temporal = new Autor(nombre, apellidos, year, esAndaluz);
        
        Exception excepcion = assertThrows(IllegalArgumentException.class, () -> {
            temporal.setApellidos("");
        });
        
        assertEquals(expRes, excepcion.getMessage());
    }

    
    @ParameterizedTest
    @CsvSource({
        "Federico, García Lorca, 1898, true, 1898",
        "Pedro Antonio, de Alarcón, 1833, true, 1833"
    })
    public void testGetBirthYear(String nombre, String apellidos, int year, boolean esAndaluz, int expRes) {
        Autor temporal = new Autor(nombre, apellidos, year, esAndaluz);
        assertEquals(expRes, temporal.getBirthYear());
    }

    @ParameterizedTest
    @CsvSource({
        "Federico, García Lorca, 1898, true, 1799, El año no puede ser menor que 1800",
        "Pedro Antonio, de Alarcón, 1833, true, 1500, El año no puede ser menor que 1800"
    })
    public void testSetBirthYear(String nombre, String apellidos, int year, boolean esAndaluz, int prueba, String expRes) {
        Autor temporal = new Autor(nombre, apellidos, year, esAndaluz);
        
        Exception excepcion = assertThrows(IllegalArgumentException.class, () -> {
            temporal.setBirthYear(prueba);
        });
        
        assertEquals(expRes, excepcion.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
        "Federico, García Lorca, 1898, true, true",
        "Pedro Antonio, de Alarcón, 1833, true, true",
        "Perico, Los palotes, 1990, false, false"
    })
    public void testGetEsAndaluz(String nombre, String apellidos, int year, boolean esAndaluz, boolean expRes) {
        Autor temporal = new Autor(nombre, apellidos, year, esAndaluz);
        assertEquals(expRes, temporal.getEsAndaluz());
    }

}
