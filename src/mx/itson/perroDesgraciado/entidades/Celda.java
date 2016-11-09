/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.perroDesgraciado.entidades;

import java.util.List;

/**
 *
 * @author SaulUrias
 */
public class Celda {

    public String getLectura() {
        return lectura;
    }

    public void setLectura(String lectura) {
        this.lectura = lectura;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public List getDatos() {
        return datos;
    }

    public void setDatos(List datos) {
        this.datos = datos;
    }

    private String lectura;
    private int columna;
    private int fila;
    private List datos;

            
}
