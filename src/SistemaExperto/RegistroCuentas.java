/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaExperto;

/**
 *
 * @author Megadeth
 */
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
public class RegistroCuentas implements Serializable
{
   public double valor;
 ;
 
   // el constructor sin argumentos llama al otro constructor con valores predeterminados
   public RegistroCuentas()
   {
      this( 0 );
   }
 
   // inicializar un registro
   public RegistroCuentas( int val )
   {
      establecervalor( val );
    
      
   }
 
   // establecer número de cuenta
   public void establecervalor( double val )
   {
      valor = val;
   }
 
   // obtener número de cuenta
   public double obtenervalor(RandomAccessFile archivo) throws IOException
   {
      
      return valor;
   }
 
  
   
} // fin de la clase RegistroCuentas
