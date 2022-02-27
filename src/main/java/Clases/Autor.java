
package Clases;

import java.util.Objects;

public class Autor {
    //Atributos
    private String nombre;
    private String apellidos;
    private int birthYear;
    private boolean esAndaluz;
    
    //Constructor
    public Autor(String nombre, String apellidos, int birthYear, boolean esAndaluz){
        
        if(nombre.length() < 4 || nombre.length() > 30){
            throw new IllegalArgumentException("El nombre no es válido");
        }
        
        if(apellidos.isEmpty()){
            throw new IllegalArgumentException("Los apellidos no pueden estar vacios");
        }
        
        if(birthYear < 1800){
            throw new IllegalArgumentException("El año no puede ser menor que 1800");
        }
        
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.birthYear = birthYear;
        this.esAndaluz = esAndaluz;
    }
    
    public Autor(Autor autor){
        this(autor.getNombre(), autor.getApellidos(), autor.getBirthYear(), autor.getEsAndaluz());
    }
    
    //Métodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if(!(nombre.length() >= 4) || !(nombre.length() <= 30)){
            throw new IllegalArgumentException("El nombre no es válido");
        }
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        
        if(apellidos.isEmpty()){
            throw new IllegalArgumentException("Los apellidos no pueden estar vacios");
        }
        
        this.apellidos = apellidos;
        
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        
        if(birthYear < 1800){
            throw new IllegalArgumentException("El año no puede ser menor que 1800");
        }
        
        this.birthYear = birthYear;
    }

    public boolean getEsAndaluz() {
        return esAndaluz;
    }

    public void setEsAndaluz(boolean esAndaluz) {
        this.esAndaluz = esAndaluz;
    }

    @Override
    public String toString() {
        return "Autor{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", birthYear=" + birthYear + ", esAndaluz=" + esAndaluz + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.nombre);
        hash = 23 * hash + Objects.hashCode(this.apellidos);
        hash = 23 * hash + this.birthYear;
        hash = 23 * hash + (this.esAndaluz ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Autor other = (Autor) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        return true;
    }

}
