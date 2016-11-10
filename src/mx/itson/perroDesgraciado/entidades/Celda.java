/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.perroDesgraciado.entidades;


/**
 *  Entidad que posee los metodos y atributos del objeto Celda
 * @author SaulUrias
 */
public class Celda {
/**
 * Atributos que posee el objeto Celda
 */
    private String titulo;
    private int columna;
    private int fila;
    
   /**
    * Metodo que obtiene el atributo titulo de la entidad Celda
    * @return 
    */ 
   public String getTitulo() {
        return titulo;
    }

   /**
    * Metodo que asigna el atributo titulo de la entidad Celda
    * @param titulo 
    */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
    * Metodo que obtiene el atributo columna de la entidad Celda
    * @return 
    */ 
    public int getColumna() {
        return columna;
    }

    /**
     * Metodo que asigna el atributo columna en la entidad Celda
     * @param columna 
     */
    public void setColumna(int columna) {
        this.columna = columna;
    }

    /**
    * Metodo que obtiene el atributo fila de la entidad Celda
    * @return 
    */ 
    public int getFila() {
        return fila;
    }

    /**
     * Metodo que asigna el atributo fila en la entidad Celda
     * @param fila 
     */
    public void setFila(int fila) {
        this.fila = fila;
    }
           
}
