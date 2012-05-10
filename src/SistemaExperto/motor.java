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
   
   public int entrada1[][], cadenaint[];
   public float pertenencia[];
   void leer(){
      char cadena[];
      cadena=new char[9];
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
             
             for(int i=0;i<=8;i++)
             {
                 
                 String lineachar=String.valueOf(linea);
                 //System.out.println("lieneachar "+lineachar.charAt(i));
                 cadena[i]=lineachar.charAt(i);
                //System.out.println("cadena arreglo "+cadena[i]+"   "+i);
                 
                 
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
     cadenaint=new int[9];//convertir cadena de caracteres a enteros
     for(int i=0;i<=8;i++){ 
      cadenaint[i]=Integer.parseInt(""+cadena[i]);//return cadena[0];//en el arreglo "cadena" estan las entradas
         //System.out.println("Cadena de enteros "+ cadenaint[i]+ "   "+i);
     }
     
     }
   
   
   
   float calcular_membresia(int x, float m)//Fuzzyficacion
   //se calcula el grado de pertenencia a un conjunto
   {
       
       //m: media de la funcion de membresia(Gaussiana) k: constante
       float potencia, miu, k=(float) 1.5;
       float arriba=x-m;
       arriba=(float) Math.pow(arriba,2);
       k=k*-1;
       potencia=(float) arriba*k;//funcion de membresia
       //System.out.println("Potencia "+potencia);
       
       miu=(float) (double) Math.exp(potencia);
       //System.out.println("Miu "+miu);
       return miu;
   
   }//se obtienen entradas difusas
  
   void proceso_de_inferencia()//Se evaluan las reglas (de la BC)
   { 

   }//se obtienen salidas difusas
   
   void defusificacion() //Defuzzyficacion
   //Metodo del centroide
   {
   
   }//Se obtienen salidas reales
    
}
