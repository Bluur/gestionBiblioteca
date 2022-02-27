
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
public class BibliotecaTest {
    
    Autor federico;
    Autor ayes;
    Autor ketty;
    Autor noAndaluz;
    
    Libro pruebaNoAndaluz;
    Libro romancero;
    Libro pez;
    Libro mirada;
    
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
        this.federico = new Autor("Federico", "García Lorca", 1898, true);
        this.ayes = new Autor ("Ayes", "Tortosa", 1956, true);
        this.ketty = new Autor ("Ketty", "Castillo Pacheco", 1956, true);
        this.noAndaluz = new Autor ("Autor", "no andaluz", 1900, false);
        
        this.pruebaNoAndaluz = new Libro("Libro hereje no andaluz", noAndaluz, 1990, "prosa");
        this.romancero = new Libro("Romancero Gitano", this.federico, 1920, "prosa");
        this.pez = new Libro("Si yo fuera un pez", this.ayes, 2021, "verso");
        this.mirada = new Libro("La mirada infinita", this.ketty, 2008, "verso");
    }
    
    @AfterEach
    public void tearDown() {
    }

    @ParameterizedTest
    @CsvSource({
        "1",
        "2",
    })
    public void testAddLibro(int iteracion) {
        switch (iteracion) {
            case 1 -> {
                Biblioteca nueva = new Biblioteca();
                assertTrue(nueva.addLibro(romancero));
            }
            case 2 -> {
                Biblioteca nueva = new Biblioteca();
                nueva.addLibro(pez);
                assertFalse(nueva.addLibro(pez));
            }
        }
    }

    @ParameterizedTest
    @CsvSource({
        "1",
        "2"
    })
    public void testDelLibro(int iteracion) {
        switch (iteracion){
            case 1 -> {
                Biblioteca nueva = new Biblioteca();
                nueva.addLibro(romancero);
                assertTrue(nueva.delLibro(romancero));
            }case 2 -> {
                Biblioteca nueva = new Biblioteca();
                nueva.addLibro(romancero);
                assertFalse(nueva.delLibro(pez));
            }
        }
    }
    
    @ParameterizedTest
    @CsvSource({
        "1",
        "2",
    })
    public void testAutoresAndaluces(int iteracion){
        if(iteracion == 1){
            Biblioteca nueva = new Biblioteca();
            nueva.addLibro(romancero);

            ArrayList <Libro> andaluces = nueva.autoresAndaluces();

            for(Libro s:andaluces){
                assertTrue(s.getAutor().getEsAndaluz());
            }  
        }else if(iteracion == 2){
            Biblioteca nueva = new Biblioteca();
            nueva.addLibro(romancero);
            nueva.addLibro(pruebaNoAndaluz);

            ArrayList <Libro> andaluces = nueva.autoresAndaluces();

            for(Libro s:andaluces){
                System.out.println(s);
                assertTrue(s.getAutor().getEsAndaluz());
            }  
        }
        
    }
    
}
