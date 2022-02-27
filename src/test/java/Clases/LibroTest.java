
package Clases;

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
public class LibroTest {
    
    Autor federico;
    Autor ayes = new Autor("Ayes", "Tortosa", 1956, true);
    
    Libro prueba;
    
    public LibroTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        this.federico = new Autor("Federico", "García Lorca", 1898, true);
        this.prueba = new Libro("Romancero Gitano", this.federico, 1920, "prosa");
    }
    
    @AfterEach
    public void tearDown() {
        this.prueba = null;
        this.federico = null;
    }
    
    @ParameterizedTest
    @CsvSource({
        "ro, 1900, prosa, El titulo no cumple la longitud",
        "Romancero, 1799, prosa, El año debe ser mayor que 1800",
        "Romancero, 1800, rap, El tipo no puede ser diferente de prosa/verso"
    })
    public void testConstructor(String titulo, int publishingYear, String tipo, String expRes){
        Exception excepcion = assertThrows(IllegalArgumentException.class, ()->{
            Libro prueba = new Libro(titulo, this.federico, publishingYear, tipo);
        });
        
        assertEquals(expRes, excepcion.getMessage());
    }
    @ParameterizedTest
    @CsvSource({
        "Romancero Gitano",
        "Hola que tal",
        "Adios muy buenas"
    })
    public void testGetTitulo(String titulo) {
        Libro luna = new Libro(titulo, this.federico, 1928, "prosa");
        String obtenido = luna.getTitulo();
        assertEquals(titulo, obtenido);
    }

    @ParameterizedTest
    @CsvSource({
        "do, El titulo no cumple la longitud",
        "S, El titulo no cumple la longitud"
    })
    public void testSetTitulo(String titulo, String expRes) {
        Exception excepcion = assertThrows(IllegalArgumentException.class, ()->{
            this.prueba.setTitulo(titulo);
        });
        
        assertEquals(expRes, excepcion.getMessage());
    }

    //Para que no compare las referencias, he insertado el método equals en
    //Autor, así también podemos comprobar que de false cuando tenga que darlo
    //He utilizado una String pasada por parámetro para probar ambos casos T/F
    @ParameterizedTest
    @CsvSource({
        "false",
        "true"
    })
    public void testGetAutor(String iteracion) {
        if(iteracion.equals("true")){
            Libro luna = new Libro("Romancero Gitano", this.federico, 1928, "prosa");
            assertTrue(luna.getAutor().equals(this.federico));

        }else{
            Libro pez = new Libro("Si yo fuera un pez", this.ayes, 2021, "verso");
            assertFalse(pez.getAutor().equals(this.federico));

        }
    }

    @ParameterizedTest
    @CsvSource({
        "F, García Lorca, 1928, true, El nombre no es válido",
        "Federico, García Lorca, 1799, true, El año no puede ser menor que 1800"
    })
    public void testSetAutor(String nombre, String apellidos, int year, boolean andaluz, String expRes) {        
        Exception excepcion = assertThrows(IllegalArgumentException.class, ()->{
            this.prueba.setAutor(new Autor(nombre, apellidos, year, andaluz));
        });
        
        assertEquals(expRes, excepcion.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
        "Romancero Gitano, 1928, prosa, 1928",
        "Romancero Gitano, 1890, prosa, 1890"
    })
    public void testGetPublishingYear(String titulo, int year, String tipo, int expRes) {
        Libro prueba1 = new Libro(titulo, this.federico, year, tipo);
        
        assertEquals(expRes, prueba1.getPublishingYear());
    }

    
    @ParameterizedTest
    @CsvSource({
        "1799, El año debe ser mayor que 1800",
        "1700, El año debe ser mayor que 1800",
        "1000, El año debe ser mayor que 1800"
    })
    public void testSetPublishingYear(int year, String expRes) {
        Exception excepcion = assertThrows(IllegalArgumentException.class, () ->{
            this.prueba.setPublishingYear(year);
        });
        
        assertEquals(expRes, excepcion.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
        "Romancero Gitano, 1928, prosa, prosa",
        "Romancero Gitano, 1928, verso, verso",

    })
    public void testGetTipo(String titulo, int year, String tipo, String expRes) {
        Libro prueba1 = new Libro(titulo, this.federico, year, tipo);
        assertEquals(expRes, prueba1.getTipo());
    }

    @ParameterizedTest
    @CsvSource({
        "rap, El tipo no puede ser diferente de prosa/verso",
        "hipHop, El tipo no puede ser diferente de prosa/verso"
    })
    public void testSetTipo(String tipo, String expRes) {
        Exception excepcion = assertThrows(IllegalArgumentException.class, ()->{
           this.prueba.setTipo(tipo);
        });
        assertEquals(expRes, excepcion.getMessage());
    }
    
}
