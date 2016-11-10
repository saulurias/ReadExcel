/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.perroDesgraciado.entidades;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Entidad que posee los metodos y atributos de la entidad LectorExcel
 * En la cual se ejecután los metodos necesarios para exportar información
 * De un archivo Excel a una base de datos en MySQL
 * @author SaulUrias
 */
public class LectorExcel {
    /**
     * Declaración de variables
     * Atributos utilizados en los diferentes metodos que posee esta entidad
     */
    
    boolean antiguo = false; //Atributo que posee el estado (Verdadero/Falso) del archivo, para saber si es formato nuevo o antiguo
    List<Celda> celdas = new ArrayList<>();     //Lista que almacena la información de las columnas
    List<String> nombres = new ArrayList<>();   //Lista que almacena la información de la columna Nombre
    List<Integer> edades = new ArrayList<>();   //Lista que almacena la información de la columna Edad
    List<String> fechas = new ArrayList<>();    //Lista que almacena la información de la columna Fecha
    List<Integer> horas = new ArrayList<>();    //Lista que almacena la información de la columna Horas
    
 /**
  * Metodo utilizado para leer archivos Excel
  * @param Nombre_Archivo - Nombre de archivo Excel.
  * @param nombre
  * @param edad
  * @param fecha
  * @param horas
  */
 public void Leer_Archivo_Excel(String Nombre_Archivo, String nombre, String edad, String fecha, String horas) throws SQLException {
  /**
   * Crea una nueva instancia de Lista_Datos_Celda
   */
  List Lista_Datos_Celda = new ArrayList();
 
/**
 * Condicionales que validan el formato del archivo
 */
  if (Nombre_Archivo.contains(".xlsx")) {
   GENERAR_XLSX(Nombre_Archivo, Lista_Datos_Celda, nombre, edad, fecha, horas);
   antiguo = false;
 
    } else if (Nombre_Archivo.contains(".xls")) {
    GENERAR_XLS(Nombre_Archivo, Lista_Datos_Celda, nombre, edad, fecha, horas);
    antiguo = true;
  }
  AcomodarValores(Lista_Datos_Celda,nombre, edad, fecha, horas );
 }

 /**
  * Metodo que lee la información almacenada en el archivo Excel que posee un formato XLSX
  * @param Nombre_Archivo
  * @param Lista_Datos_Celda
  * @param nombre
  * @param edad
  * @param fecha
  * @param horas 
  */
 private void GENERAR_XLSX(String Nombre_Archivo, List Lista_Datos_Celda, String nombre, String edad, String fecha, String horas) { 
     
  try {
   /**
    * Crea una nueva instancia de la clase FileInputStream
    */
 
   FileInputStream fileInputStream = new FileInputStream(Nombre_Archivo);
   
   /**
    * Crea una nueva instancia de la clase XSSFWorkBook
    */
 
   XSSFWorkbook Libro_trabajo = new XSSFWorkbook(fileInputStream);
   XSSFSheet Hoja_hssf = Libro_trabajo.getSheetAt(0);
 
   /**
    * Iterar las filas y las celdas de la hoja de cálculo para obtener
    * toda la información.
    */
 
   Iterator Iterador_de_Fila = Hoja_hssf.rowIterator();
 
   while (Iterador_de_Fila.hasNext()) {
 
    XSSFRow Fila_hssf = (XSSFRow) Iterador_de_Fila.next();
 
    
    
    Iterator iterador = Fila_hssf.cellIterator();
 
    List Lista_celda_temporal = new ArrayList();
    
    while (iterador.hasNext()) {
 
     XSSFCell Celda_hssf = (XSSFCell) iterador.next();
 
   // System.out.println("Columna: "+Celda_hssf.getColumnIndex() + "  Fila: "+ Celda_hssf.getRowIndex());
    
        if (String.valueOf(Celda_hssf).equals(nombre)) {
            //System.out.println("Se Encontro el titulo Nombre");
            Celda celda = new Celda();
            celda.setTitulo("Nombre");
            celda.setFila(Celda_hssf.getRowIndex());
            celda.setColumna(Celda_hssf.getColumnIndex());
            celdas.add(celda);
        }
        
        if (String.valueOf(Celda_hssf).equals(edad)) {
            //System.out.println("Se Encontro el titulo Edad");
            Celda celda = new Celda();
            celda.setTitulo("Edad");
            celda.setFila(Celda_hssf.getRowIndex());
            celda.setColumna(Celda_hssf.getColumnIndex());
            celdas.add(celda);
        }
        if (String.valueOf(Celda_hssf).equals(fecha)) {
            //System.out.println("Se Encontro el titulo Fecha");
            Celda celda = new Celda();
            celda.setTitulo("Fecha");
            celda.setFila(Celda_hssf.getRowIndex());
            celda.setColumna(Celda_hssf.getColumnIndex());
            celdas.add(celda);
        }
        if (String.valueOf(Celda_hssf).equals(horas)) {
            //System.out.println("Se Encontro el titulo Fecha");
            Celda celda = new Celda();
            celda.setTitulo("Horas");
            celda.setFila(Celda_hssf.getRowIndex());
            celda.setColumna(Celda_hssf.getColumnIndex());
            celdas.add(celda);
        }
     
        //System.out.println(celdas.size());
        Lista_celda_temporal.add(Celda_hssf);
    
    }//End iterator
 
    Lista_Datos_Celda.add(Lista_celda_temporal);
 
   }//End While Iterator Fila
  } catch (Exception e) {
 
   e.printStackTrace();
 
  }
 
 }//End metodo Generar XLSX
 
 /**
  * Metodo que lee la información de los archivos con extensión XLS
  * @param Nombre_Archivo
  * @param Lista_Datos_Celda 
  */
 private void GENERAR_XLS(String Nombre_Archivo, List Lista_Datos_Celda, String nombre, String edad, String fecha, String horas) {
 
  try {
 
   /**
     * Crea una nueva instancia de la clase FileInputStream
    */
 
   FileInputStream fileInputStream = new FileInputStream(Nombre_Archivo);
 
   /**
    * Crea una nueva instancia de la clase POIFSFileSystem
    */
 
   POIFSFileSystem fsFileSystem = new POIFSFileSystem(fileInputStream);
 
   /**
    * Crea una nueva instancia de la clase HSSFWorkBook
    */
 
   HSSFWorkbook Libro_trabajo = new HSSFWorkbook(fsFileSystem);
   HSSFSheet Hoja_hssf = Libro_trabajo.getSheetAt(0);
 
   /**
    * Iterar las filas y las celdas de la hoja de cálculo para obtener
    * toda la data.
    */
 
   Iterator Iterador_de_Fila = Hoja_hssf.rowIterator();
 
   while (Iterador_de_Fila.hasNext()) {
    HSSFRow Fila_hssf = (HSSFRow) Iterador_de_Fila.next();
    Iterator iterador = Fila_hssf.cellIterator();
    List Lista_celda_temporal = new ArrayList();
 
    while (iterador.hasNext()) {
     HSSFCell Celda_hssf = (HSSFCell) iterador.next();
     Lista_celda_temporal.add(Celda_hssf);
     
      if (String.valueOf(Celda_hssf).equals(nombre)) {
            //System.out.println("Se Encontro el titulo Nombre");
            Celda celda = new Celda();
            celda.setTitulo("Nombre");
            celda.setFila(Celda_hssf.getRowIndex());
            celda.setColumna(Celda_hssf.getColumnIndex());
            celdas.add(celda);
        }
        
        if (String.valueOf(Celda_hssf).equals(edad)) {
            //System.out.println("Se Encontro el titulo Edad");
            Celda celda = new Celda();
            celda.setTitulo("Edad");
            celda.setFila(Celda_hssf.getRowIndex());
            celda.setColumna(Celda_hssf.getColumnIndex());
            celdas.add(celda);
        }
        if (String.valueOf(Celda_hssf).equals(fecha)) {
            //System.out.println("Se Encontro el titulo Fecha");
            Celda celda = new Celda();
            celda.setTitulo("Fecha");
            celda.setFila(Celda_hssf.getRowIndex());
            celda.setColumna(Celda_hssf.getColumnIndex());
            celdas.add(celda);
        }
        if (String.valueOf(Celda_hssf).equals(horas)) {
            //System.out.println("Se Encontro el titulo Fecha");
            Celda celda = new Celda();
            celda.setTitulo("Horas");
            celda.setFila(Celda_hssf.getRowIndex());
            celda.setColumna(Celda_hssf.getColumnIndex());
            celdas.add(celda);
        }
    }//End iterator
    
    Lista_Datos_Celda.add(Lista_celda_temporal);
   }//End While Iterator Fila
   
 
  } catch (Exception e) {
   e.printStackTrace(); 
  }
 
 }//End metodo Generar XLS
 
 /**
  * Este método se utiliza para imprimir los datos de la celda a la consola.
  *
  * @param Datos_celdas
  *            - Listado de los datos que hay en la hoja de cálculo.
  */
 
 private void AcomodarValores(List Datos_celdas, String tituloNombre, String tituloEdad, String tituloFecha, String tituloHoras) throws SQLException {
 
  String Valor_de_celda;

  for (int i = 0; i < Datos_celdas.size(); i++) {
   List Lista_celda_temporal = (List) Datos_celdas.get(i);
   
   
        for (int j = 0; j < Lista_celda_temporal.size(); j++) {
            
      /**
      * Código a ejecutarse si el archivo es viejo (formato xls)
      */
    if (antiguo) {
     HSSFCell hssfCell = (HSSFCell) Lista_celda_temporal.get(j);
     Valor_de_celda = hssfCell.toString();
     
     
     for (int k = 0; k < celdas.size(); k++) {
            
            if (hssfCell.getColumnIndex() == celdas.get(k).getColumna() 
                && Valor_de_celda != "" 
                && celdas.get(k).getTitulo() == "Nombre") {
            //System.out.println(Valor_de_celda);
            if (!Valor_de_celda.equals(tituloNombre)) {
                nombres.add(Valor_de_celda);
                k = celdas.size();
            }
            
        } else if (hssfCell.getColumnIndex() == celdas.get(k).getColumna() 
                   && Valor_de_celda != "" 
                   && celdas.get(k).getTitulo() == "Edad") {
            //System.out.println(Valor_de_celda);
            if (!Valor_de_celda.equals(tituloEdad)) {
                edades.add(Integer.parseInt(Valor_de_celda));
                k = celdas.size();
            }
            
        } else if (hssfCell.getColumnIndex() == celdas.get(k).getColumna() 
                   && Valor_de_celda != "" 
                   && celdas.get(k).getTitulo() == "Fecha") {
            //System.out.println(Valor_de_celda);
            if (!Valor_de_celda.equals(tituloFecha)) {
                
                fechas.add(Valor_de_celda);
                k = celdas.size();
            } 
        
          } else if (hssfCell.getColumnIndex() == celdas.get(k).getColumna() 
                     && Valor_de_celda != "" 
                     && celdas.get(k).getTitulo() == "Horas") {
            //System.out.println(Valor_de_celda);
            if (!Valor_de_celda.equals(tituloHoras)) {
                horas.add(Integer.parseInt(Valor_de_celda));
                k = celdas.size();
               
            }
          } 
        } 

     /**
      * Código a ejecutarse si el archivo es nuevo (formato xlsx)
      */
    } else {
        

     XSSFCell hssfCell = (XSSFCell) Lista_celda_temporal.get(j);
     Valor_de_celda = hssfCell.toString();
     
        for (int k = 0; k < celdas.size(); k++) {
            
            if (hssfCell.getColumnIndex() == celdas.get(k).getColumna() 
                && Valor_de_celda != "" 
                && celdas.get(k).getTitulo() == "Nombre") {
            //System.out.println(Valor_de_celda);
            if (!Valor_de_celda.equals(tituloNombre)) {
                nombres.add(Valor_de_celda);
                k = celdas.size();
            }
            
        } else if (hssfCell.getColumnIndex() == celdas.get(k).getColumna() 
            && Valor_de_celda != "" 
            && celdas.get(k).getTitulo() == "Edad") {
            //System.out.println(Valor_de_celda);
            if (!Valor_de_celda.equals(tituloEdad)) {
                edades.add(Integer.parseInt(Valor_de_celda));
                k = celdas.size();
            }
            
        } else if (hssfCell.getColumnIndex() == celdas.get(k).getColumna() 
            && Valor_de_celda != "" 
            && celdas.get(k).getTitulo() == "Fecha") {
            //System.out.println(Valor_de_celda);
            if (!Valor_de_celda.equals(tituloFecha)) {
                
                fechas.add(Valor_de_celda);
                k = celdas.size();
            } 
        
          } else if (hssfCell.getColumnIndex() == celdas.get(k).getColumna() 
            && Valor_de_celda != "" 
            && celdas.get(k).getTitulo() == "Horas") {
            //System.out.println(Valor_de_celda);
            if (!Valor_de_celda.equals(tituloHoras)) {
                horas.add(Integer.parseInt(Valor_de_celda));
                k = celdas.size();
              } 
            }//End else if Horas
          }//End for  
        } //End else formato xlsx
     }//End for "List_celda_temporal"
   }//End for "Datos_celdas"
   EjecutarQuery();
 }//End metodo AcomodarValores
 
 /**
  * Metodo que ejecuta el Query correspondiente para exportar los datos en la base de datoss
  * @throws SQLException 
  */
 public void EjecutarQuery() throws SQLException{
       Conexion c = new Conexion();
       Connection conn = c.conectarDB();

        try {
            for (int i = 0; i < nombres.size(); i++) {
                String nombre = "'"+nombres.get(i)+"'";
                int edad = edades.get(i);
                String fecha = "'"+fechas.get(i)+"'";
                int hora = horas.get(i);
                
                
                CallableStatement storedProcedure = conn.prepareCall("CALL sp_insertarRegisto("+nombre+",+"+edad+","+fecha+","+hora+")");
                storedProcedure.executeQuery();
            }
            JOptionPane.showMessageDialog(null, "Se han exportado"+ (nombres.size()*4) +" datos correctamente");
            
           
        }catch(Exception e){
        e.printStackTrace();
        }finally{
            conn.close();
        }
        
        
    }
 /*
 public static void main(String[] args) throws SQLException {
 
// RUTA: /Users/SaulUrias/Documents/documento.xlsx     
     
  String fileName = "/Users" + File.separator + "SaulUrias" + File.separator
 
    + "Documents" + File.separator + "documento.xlsx";
 
  System.out.println(fileName);
 
  new LectorExcel().Leer_Archivo_Excel(fileName, "Nombreasd", "Edadasd", "Fechaasd", "Horasasd");
 
 }
*/
}
