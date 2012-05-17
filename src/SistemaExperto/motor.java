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
   public char actual=' ';
   public float w=0;
   public int entrada1[][], cadenaint[];
   public float entradasdifusas[][], pertenece[];
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
   
   
   
   float calcular_membresia(float x, float m)//Fuzzyficacion
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
    char w(int dato)
        {
           return (char)dato;
        }
  
   int proceso_de_inferencia()//Se evaluan las reglas (de la BC)
   { 
       float media;
       pertenece=new float[4];
      
      
     
      //cadenainf=new char[9];
      File archivo1=null ;
      FileReader fr1 = null;
      BufferedReader br1;
     
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         archivo1 = new File ("BCb.txt");
         fr1 = new FileReader (archivo1);
         br1 = new BufferedReader(fr1);
         // Lectura del fichero
         String linea2;
         int cont=0, band=0;
         String lineachar2;
         int accion;
         //char c1=' ', c2=' ';
         int inferir[]=new int[6];
        
                  //compraraciones
                        for(int j=0; j<6; j++){
                            for(int i=0; i<6; i++){
                           int uno=entrada1[0][j]&entrada1[1][i];
                           
                            if(uno==1){
                               
                                 
                                        String c1= String.valueOf(j);
                                   
                                        String c2= String.valueOf(i);
                                          
                                 while((linea2=br1.readLine())!=null && band==0)
                                 {
                                     lineachar2=String.valueOf(linea2);
                                    
                                       //System.out.println("caracter1: "+lineachar2.charAt(cont));
                                       //System.out.println("Linea: "+lineachar2);
                                       //System.out.println("caracter2: "+c1.charAt(0)); 
                                      
                                      if(lineachar2.charAt(cont)==c1.charAt(0)){
                                             if(lineachar2.charAt(cont+1)=='&'){
                                               if(lineachar2.charAt(cont+2)==c2.charAt(0)){
                                                     if(lineachar2.charAt(cont+3)=='>'){
                                                            actual=lineachar2.charAt(cont+4);
                                                            System.out.println("Accion "+ actual);
                                                            
                                                            band=1;
                                                          }
                                               }  
                                           
                                      }
                                       //System.out.println("lieneachar "+lineachar.charAt(i));
                                      
                                      
                                       cont++; 
                                 }
                        }
                        }
                   }
             }
            
     
      }catch(Exception e1){
         e1.printStackTrace();
      }finally{
         // En el finally cerramos el fichero, para asegurarnos
         // que se cierra tanto si todo va bien como si salta 
         // una excepcion.
         try{                    
            if( null != fr1){   
               fr1.close();     
            }                  
         }catch (Exception e2){ 
            e2.printStackTrace();
         }
      }
   
       
      
     
         
     
      for(int i=0; i<=1;i++){ //controla el arreglo que se evaluara 
        for(int j=0; j<6; j++)
         {
             
             media=(float) 4.0;
            for(int c=1; c<5; c++)
            {
               // System.out.println("Entrada difusa a evaluar: "+entradasdifusas[i]);
                pertenece[c-1]=this.calcular_membresia(entradasdifusas[i][j], media);
                
               
              // System.out.println("La salida difusa "+i+" pertenece: "+pertenece[c-1]+" al conjunto n"+c);
                media=(float) (media+4.0);
            }
        }
      }
          //for(int c=1; c<5; c++)
             // System.out.println("Pertenencia a FAM: "+pertenece[c-1]);
          
          String s=String.valueOf(actual);    
           w=Float.parseFloat(s);
        int accion = (int) w;
           w=this.calcular_membresia(w, 12);
           
          return accion;
   }//se obtienen salidas difusas
   
   void defusificacion(){
   //Defuzzyficacion
   //Metodo del centroide
   {
       float sumatoria1=0, sumatoria2=0,salidareal;
       
       for(int i=0;i<=3; i++){//sumatorias para el metodo
          
                     sumatoria1=sumatoria1+(pertenece[i]*entradasdifusas[0][i]);
                     sumatoria2=sumatoria2+pertenece[i]; 
             
       }
       salidareal=sumatoria1/sumatoria2;
     
   }//Se obtienen salidas reales
}
}
