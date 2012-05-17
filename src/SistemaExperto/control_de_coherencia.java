/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaExperto;

/**
 *
 * @author Megadeth
 */
public class control_de_coherencia {
    motor mt=new motor();  
    
      
     float validar_de_entradas()//se evaluan las entradas reales
    {
       mt.leer();
       int  x1,x2,x3,x4,x5,x6;
       float media, miu;
       mt.entradasdifusas=new float[2][6];
       mt.entrada1=new int[2][6];
    
       //Calcular entradas de TDH-L
       x1=mt.cadenaint[0]&mt.cadenaint[1];
       x2=mt.cadenaint[0]&mt.cadenaint[2];     
       x3=mt.cadenaint[1]&mt.cadenaint[2];      
       x4=mt.cadenaint[0]&mt.cadenaint[3];      
       x5=mt.cadenaint[1]&mt.cadenaint[3];      
       x6=mt.cadenaint[2]&mt.cadenaint[3];
  
       mt.entrada1[0][0]=x1|x2|x3|x4|x5|x6;
       System.out.println("Entrada TDH-L: "+ mt.entrada1[0][0]);
       //Calcular entradas de TDH-B
       x1=mt.cadenaint[0]&mt.cadenaint[4];
       x2=mt.cadenaint[1]&mt.cadenaint[4];     
       x3=mt.cadenaint[2]&mt.cadenaint[4];      
       x4=mt.cadenaint[3]&mt.cadenaint[4];      
       x5=mt.cadenaint[0]&mt.cadenaint[5];      
       x6=mt.cadenaint[1]&mt.cadenaint[5];
       
       mt.entrada1[0][1]=x1|x2|x3|x4|x5|x6;
       System.out.println("Entrada TDH-B: "+ mt.entrada1[0][1]);
       
       //Calcular entradas de TDH-M
       x1=mt.cadenaint[2]&mt.cadenaint[5];
       x2=mt.cadenaint[3]&mt.cadenaint[5];     
       x3=mt.cadenaint[4]&mt.cadenaint[5];      
       x4=mt.cadenaint[0]&mt.cadenaint[6];      
       x5=mt.cadenaint[1]&mt.cadenaint[6];      
       x6=mt.cadenaint[2]&mt.cadenaint[6];
       
       mt.entrada1[0][2]=x1|x2|x3|x4|x5|x6;
       System.out.println("Entrada TDH-M: "+ mt.entrada1[0][2]);
       
       //Calcular entradas de TDH-A
       x1=mt.cadenaint[3]&mt.cadenaint[6];
       x2=mt.cadenaint[4]&mt.cadenaint[6];     
       x3=mt.cadenaint[5]&mt.cadenaint[6];      
       x4=mt.cadenaint[0]&mt.cadenaint[7];      
       x5=mt.cadenaint[1]&mt.cadenaint[7];      
       x6=mt.cadenaint[2]&mt.cadenaint[7];
       
       mt.entrada1[0][3]=x1|x2|x3|x4|x5|x6;
       System.out.println("Entrada TDH-A: "+ mt.entrada1[0][3]);
       
       //Calcular entradas de TDH-P
       x1=mt.cadenaint[3]&mt.cadenaint[7];
       x2=mt.cadenaint[4]&mt.cadenaint[7];     
       x3=mt.cadenaint[5]&mt.cadenaint[7];      
       x4=mt.cadenaint[0]&mt.cadenaint[8];      
       x5=mt.cadenaint[1]&mt.cadenaint[8];      
       x6=mt.cadenaint[2]&mt.cadenaint[8];
       
       mt.entrada1[0][4]=x1|x2|x3|x4|x5|x6;
       System.out.println("Entrada TDH-P: "+ mt.entrada1[0][4]);
       
       //Calcular entradas de TDH-C
       x1=mt.cadenaint[2]&mt.cadenaint[8];
       x2=mt.cadenaint[3]&mt.cadenaint[8];     
       x3=mt.cadenaint[4]&mt.cadenaint[8];      
       x4=mt.cadenaint[5]&mt.cadenaint[8];      
       x5=mt.cadenaint[6]&mt.cadenaint[8];      
       x6=mt.cadenaint[7]&mt.cadenaint[8];
       
       mt.entrada1[0][5]=x1|x2|x3|x4|x5|x6;
       System.out.println("Entrada TDH-C: "+ mt.entrada1[0][5]);
       
       
       //Calcular entradas de TDA-L
       x1=mt.cadenaint[2]&mt.cadenaint[6];
       x2=mt.cadenaint[2]&mt.cadenaint[3];     
       x3=mt.cadenaint[2]&mt.cadenaint[7];      
       x4=mt.cadenaint[1]&mt.cadenaint[5];      
       x5=mt.cadenaint[1]&mt.cadenaint[8];      
       x6=mt.cadenaint[7]&mt.cadenaint[8];
  
       mt.entrada1[1][0]=x1|x2|x3|x4|x5|x6;
       System.out.println("Entrada TDA-L: "+ mt.entrada1[1][0]);
       
       //Calcular entradas de TDA-B
       x1=mt.cadenaint[1]&mt.cadenaint[6];
       x2=mt.cadenaint[1]&mt.cadenaint[7];     
       x3=mt.cadenaint[0]&mt.cadenaint[8];      
       x4=mt.cadenaint[1]&mt.cadenaint[3];      
       x5=mt.cadenaint[0]&mt.cadenaint[5];      
       x6=mt.cadenaint[6]&mt.cadenaint[8];
       
       mt.entrada1[1][1]=x1|x2|x3|x4|x5|x6;
       System.out.println("Entrada TDA-B: "+ mt.entrada1[1][1]);
       
       //Calcular entradas de TDA-M
       x1=mt.cadenaint[3]&mt.cadenaint[4];
       x2=mt.cadenaint[0]&mt.cadenaint[3];     
       x3=mt.cadenaint[0]&mt.cadenaint[6];      
       x4=mt.cadenaint[0]&mt.cadenaint[7];      
       x5=mt.cadenaint[6]&mt.cadenaint[7];      
       x6=mt.cadenaint[5]&mt.cadenaint[8];
       
       mt.entrada1[1][2]=x1|x2|x3|x4|x5|x6;
       System.out.println("Entrada TDA-M: "+ mt.entrada1[1][2]);
       
       //Calcular entradas de TDA-A
       x1=mt.cadenaint[1]&mt.cadenaint[2];
       x2=mt.cadenaint[4]&mt.cadenaint[8];     
       x3=mt.cadenaint[5]&mt.cadenaint[6];      
       x4=mt.cadenaint[4]&mt.cadenaint[5];      
       x5=mt.cadenaint[5]&mt.cadenaint[7];      
       x6=mt.cadenaint[2]&mt.cadenaint[4];
       
       mt.entrada1[1][3]=x1|x2|x3|x4|x5|x6;
       System.out.println("Entrada TDA-A: "+ mt.entrada1[1][3]);
       
       //Calcular entradas de TDA-P
       x1=mt.cadenaint[0]&mt.cadenaint[3];
       x2=mt.cadenaint[4]&mt.cadenaint[6];     
       x3=mt.cadenaint[4]&mt.cadenaint[7];      
       x4=mt.cadenaint[3]&mt.cadenaint[8];      
       x5=mt.cadenaint[3]&mt.cadenaint[5];      
       x6=mt.cadenaint[1]&mt.cadenaint[4];
       
       mt.entrada1[1][4]=x1|x2|x3|x4|x5|x6;
       System.out.println("Entrada TDA-P: "+ mt.entrada1[1][4]);
       
       //Calcular entradas de TDA-C
       x1=mt.cadenaint[0]&mt.cadenaint[1];
       x2=mt.cadenaint[2]&mt.cadenaint[5];     
       x3=mt.cadenaint[0]&mt.cadenaint[4];      
       x4=mt.cadenaint[3]&mt.cadenaint[6];      
       x5=mt.cadenaint[3]&mt.cadenaint[7];      
       x6=mt.cadenaint[2]&mt.cadenaint[8];
       
       mt.entrada1[1][5]=x1|x2|x3|x4|x5|x6;
       System.out.println("Entrada TDA-C: "+ mt.entrada1[1][5]);
       
       
           
       
            
         for(int i=0; i<=1;i++){ //controla el arreglo que se evaluara
             
           for(int j=0; j<=5;j++){// controla el elemento que se evaluara
               media=(float) 4.0;
               for(int c=0; c<=5;c++){  //controla los conjuntos 
                miu=mt.calcular_membresia(mt.entrada1[i][j], media);
                int numerodeconjunto=j+1;
                //System.out.println("La entrada es "+miu+" perteneciente al conjunto "+ numerodeconjunto);
                mt.entradasdifusas[i][j]=miu;
                //System.out.println("Pertenencia "+numerodeconjunto+"  "+miu);
                //System.out.println("Media: "+media);
                media=(float) (media+4.0); 
                
           } 
         }
        }
        int accion=mt.proceso_de_inferencia();
        mt.defusificacion();
        
       return accion;
    }
    
}
