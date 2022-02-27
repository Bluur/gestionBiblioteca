
package Clases;

public class Libro {
    //Atributos
    private String titulo;
    private Autor autor;
    private int publishingYear;
    private String tipo;
    
    //Constructor
    public Libro(String titulo, Autor autor, int publishingYear, String tipo){
        if(titulo.length() < 3 || titulo.length() > 50){
            throw new IllegalArgumentException("El titulo no cumple la longitud");
        }
        
        if(publishingYear < 1800){
            throw new IllegalArgumentException("El año debe ser mayor que 1800");
        }
        
        if(!tipo.equals("prosa") && !tipo.equals("verso")){
            throw new IllegalArgumentException("El tipo no puede ser diferente de prosa/verso");
        }
        
        this.titulo = titulo;
        this.autor = new Autor(autor.getNombre(), autor.getApellidos(), autor.getBirthYear(), autor.getEsAndaluz());
        this.publishingYear = publishingYear;
        this.tipo = tipo;
    }
    
    public Libro(Libro copiar){
        this.autor = new Autor(copiar.getAutor());
        this.titulo = copiar.getTitulo();
        this.publishingYear = copiar.getPublishingYear();
    }
    
    //Métodos
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        
        if(titulo.length() < 3 || titulo.length() > 50){
            throw new IllegalArgumentException("El titulo no cumple la longitud");
        }
        
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = new Autor(autor.getNombre(), autor.getApellidos(), autor.getBirthYear(), autor.getEsAndaluz());
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int publishingYear) {
        if(publishingYear < 1800){
            throw new IllegalArgumentException("El año debe ser mayor que 1800");
        }
        
        this.publishingYear = publishingYear;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        
        if(!tipo.equals("prosa") || !tipo.equals("verso")){
            throw new IllegalArgumentException("El tipo no puede ser diferente de prosa/verso");
        }
        
        this.tipo = tipo;
        
    }
    
    
}
