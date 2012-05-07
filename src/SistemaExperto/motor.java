/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaExperto;

import java.io.*;

/**
 *
 * @author Megadeth
 */
public class motor {
    
   char leer(){
      char cadena[];
      cadena=new char[14];
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo = new File ("entradas.txt");
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);
         // Lectura del fichero
         String linea;
         while((linea=br.readLine())!=null)
             
             for(int i=0;i<=14;i++)
             {
                 
                 String lineachar=String.valueOf(linea);
                 //System.out.println("lieneachar "+lineachar.charAt(i));
                 cadena[i]=lineachar.charAt(i);
                 System.out.println("cadena arreglo "+cadena[i]+"   "+i);
                 
                 
             }
            
      }
      catch(Exception e1){
         e1.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
       return cadena[0];//en el arreglo "cadena" estan las entradas
   }
    
}
