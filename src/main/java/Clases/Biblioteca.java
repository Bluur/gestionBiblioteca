
package Clases;

import java.util.ArrayList;

public class Biblioteca {
    
    private ArrayList <Libro> listaLibros;
    
    public boolean addLibro(Libro libro){
        boolean colocar = true;
        
        for(Libro presente:listaLibros){
            if(libro.getTitulo().equals(presente.getTitulo())){
                colocar = false;
            }
        }
        
        if(colocar){
            listaLibros.add(libro);
        }
        
        return colocar;
    }
    
    public boolean delLibro(Libro libro){
        boolean eliminado = false;
        
        for(Libro presente:listaLibros){
            if(libro.getTitulo().equals(presente.getTitulo())){
                listaLibros.remove(presente);
                eliminado = true;
            }
        }
        
        return eliminado;
    }
    
    public ArrayList<Libro> autoresAndaluces(){
        ArrayList <Libro> autoresAndaluces = new ArrayList<>();
        
        for(Libro temporal:listaLibros){
            if(temporal.getAutor().getEsAndaluz() == true){
                autoresAndaluces.add(temporal);
            }
        }
        
        return autoresAndaluces;
    }
}
