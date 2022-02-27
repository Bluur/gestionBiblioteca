
package Clases;

import java.util.ArrayList;

public class Biblioteca {
    
    ArrayList <Libro> listaLibros;
    
    public Biblioteca(){
        listaLibros = new ArrayList<>();
    }
    
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
        int index = 0;
        boolean eliminado = false;
        
        for(Libro presente:listaLibros){
            if(presente.equals(libro)){
                index = listaLibros.indexOf(presente);
                eliminado = true;
            }
        }
        
        if(eliminado){
            listaLibros.remove(index);
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
