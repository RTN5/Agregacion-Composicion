/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package composicion_1;
import java.util.*;

/**
 *
 * @author User
 */
class Pagina{
    //ATRIBUTOS DE INSTANCIA
    private String contenido;
    private int numero;
    
    //CONSTRUCTOR CON PARAMETROS
    public Pagina(String contenido, int numero){
        this.contenido = new String(contenido);
        this.numero = numero;
    }
    
    //METODO DE INSTANCIA
    public String getContenido(){
        return this.contenido;
    }
    
    public void setContenido(String nuevo_contenido){
        this.contenido = nuevo_contenido;
    }
    
    public int getNumero(){
        return this.numero;
    }
    
    public void setNumero(int nuevo_numero){
        this.numero = nuevo_numero;
    }
}

class Libro{
    //Atributos
    private String titulo;
    private long isbn;
    private String autor;
    private int anioPublicacion;
    
    //ATRIBUTOS REPRESENTANDO LA RELACION DE COMPOSICION
    private Pagina[] paginas;
    private int numeroPaginas;
    
    //CONSTRUCTOR
    public Libro(String titulo, long isbn, String autor, int anioPublicacion){
    this.titulo = titulo;
    this.isbn = isbn;
    this.autor = autor;
    this.anioPublicacion = anioPublicacion;
    
    //RESERVAMOS ESPACIO EN MEMORIA PARA EL OBJETO "array"
    this.paginas = new Pagina[999];
  
    
    //RESERVAMOS ESPACIO EN MEMORIA PARA LAS PAGINAS
    for(int i=0; i<999; i++){
        this.paginas[i] = new Pagina("",0);
    }
    this.numeroPaginas = 0;
}
    //METODOS DE INSTANCIA
    public String getTitulo(){
        return this.titulo;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    
    public long getIsbn(){
        return this.isbn;
    }
    
    public void setIsbn(long nuevo_Isbn){
        this.isbn = nuevo_Isbn;
    }
    
    public String getAutor(){
        return this.autor;
    }
    
    public void setAutor(String nuevo_autor){
        this.autor = nuevo_autor;
    }
    
    public int getAnioPublicacion(String nuevo_anioPublicacion){
        return this.anioPublicacion;
    }
    
    public void setAnioPublicacion(int nuevo_anioPublicacion){
        this.anioPublicacion = nuevo_anioPublicacion;
    }
    
    //METODOS PARA TRABAJAR CON LA CLASE DE COMPOSICION
    public int getNumeroPaginas(){
        return this.numeroPaginas;
    }
   
    public void AnadirPagina(Pagina nueva_Pagina){
        if(this.numeroPaginas < 999){
            this.paginas[this.numeroPaginas]= nueva_Pagina;
            this.numeroPaginas++;
        }
    }
    
    public Pagina getPaginaNumero(int numero_Pagina){
        for(int i=0; i<this.numeroPaginas; i++){
            if(this.paginas[i].getNumero() == numero_Pagina){
                return this.paginas[i];
            }
        }
        
        return this.paginas[1];
    }
}
public class Composicion_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("       Universidad de las Fuerzas Armadas ESPE");
        System.out.println(" Nombre:Morales Esteban");
        System.out.println(" Ejercicio: Agregacion/Composicion \n");
        //DECLARACION Y DEFINICION DEOBJETOS
        Libro Controles_Instrumentos = new Libro("Arranque y apagado del motor" , 123 , ""
                + "Chevrolet",2020);
        Pagina pagina1= new Pagina("-Asegurese de que todos los interruptores esten en la posicion "
                + "desactivada",1);
        Pagina pagina2=new Pagina("-Gire interruptos de arranque a posicion ON verifique luces y "
                + "combustible normal", 0);
        
        //PASAMOS AL OBJETO Libro LOS OBJETOS DEL TIPO Pagina
        Controles_Instrumentos.AnadirPagina(pagina1);
        Controles_Instrumentos.AnadirPagina(pagina2);
        for(int i=1; i<=Controles_Instrumentos.getNumeroPaginas(); i++){
            System.out.println(Controles_Instrumentos.getPaginaNumero(i).getContenido());
        }
    }
    
}
