/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaExperto;

/**
 *
 * @author Megadeth
 */

import java.io.*;
public class RegistroCuentasAccesoAleatorio extends RegistroCuentas {
 
    public static final int TAMANIO = 72;
 
   // el constructor sin argumentos llama al otro constructor con los valores predeterminados
   public RegistroCuentasAccesoAleatorio()
   {
      this( 0 );
   }
 
   // inicializar un objeto RegistroCuentasAccesoAleatorio
   public RegistroCuentasAccesoAleatorio( int valor )
   {
      super( valor );
   }
 
   // leer un registro del objeto RandomAccecssFile especificado
   public double leer( RandomAccessFile archivo ) throws IOException
   {
      valor= archivo.readDouble();
      return valor;
   }
 
   // asegurarse que el nombre sea de la longitud apropiada

 
   // escribir un registro en el objeto RandomAccessFile especificado
   public void escribir( RandomAccessFile archivo, double valor ) throws IOException
   {
      archivo.writeDouble( valor );
   }
 
   // escribir un nombre en el archivo; máximo 15 caracteres

 
} // fin de la clase RegistroCuentasAccesoAleatorio
