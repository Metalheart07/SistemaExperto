/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package SistemaExperto;

/**
 *
 * @author Megadeth
 */
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.text.DecimalFormat;
import javax.swing.*;
public class LeerArchivoAleatorio extends JFrame {
 
   private RandomAccessFile entrada;
   private JButton botonSiguiente, botonAbrir;
 
   private static DecimalFormat dosDigitos = new DecimalFormat( "0.00" );
 
   // configurar GUI
   public LeerArchivoAleatorio()
   {
      super( "Leer archivo del cliente" );
 
 
   } // fin del constructor
 
   // permitir al usuario seleccionar el archivo a abrir
   public RandomAccessFile abrirArchivo()
   {
      // mostrar cuadro de diálogo para que el usuario pueda seleccionar el archivo
      /**JFileChooser selectorArchivo = new JFileChooser();
      selectorArchivo.setFileSelectionMode( JFileChooser.FILES_ONLY );
 
      int resultado = selectorArchivo.showOpenDialog( this );
 
      // si el usuario hizo clic en el botón Cancelar del cuadro de diálogo, regresar
      if ( resultado == JFileChooser.CANCEL_OPTION )
         return null;
 */
      // obtener el archivo seleccionado
      File nombreArchivo = null;
      nombreArchivo= new File ("sintomas");
      
      // mostrar error si el nombre de archivo es incorrecto
      if ( nombreArchivo == null || nombreArchivo.getName().equals( "" ) )
         JOptionPane.showMessageDialog( this, "Nombre de archivo incorrecto",
            "Nombre de archivo incorrecto", JOptionPane.ERROR_MESSAGE );
 
      else {
 
         // abrir el archivo
         try {
            entrada = new RandomAccessFile( nombreArchivo, "r" );
       
         }
 
         // atrapar excepción que puede ocurrir al abrir el archivo
         catch ( IOException ioException ) {
            JOptionPane.showMessageDialog( this, "El archivo no existe",
               "Nombre de archivo incorrecto", JOptionPane.ERROR_MESSAGE );
         }   
 
      } // fin de instrucción else
  return entrada;
   } // fin del método abrirArchivo
 
   // leer un registro
   public double leerRegistro(RandomAccessFile entrada)
   {
       double valor=0.0;
      RegistroCuentasAccesoAleatorio registro = new RegistroCuentasAccesoAleatorio();
 
      // leer un registro y mostrarlo
      try {
 
         do {
            registro.leer( entrada );
            } while ( registro.obtenervalor(entrada) == 0 );
       
              valor = registro.obtenervalor(entrada);
       
          }
 
      // cerrar el archivo al llegar a su fin
      catch ( EOFException excepcionEOF ) {
         JOptionPane.showMessageDialog( this, "No hay más registros",
            "Se llegó al fin del archivo", JOptionPane.INFORMATION_MESSAGE );
         cerrarArchivo();
      }
 
      // procesar excepciones que pueden ocurrir por algún problema con el archivo
      catch ( IOException excepcionES ) {
         JOptionPane.showMessageDialog( this, "Error al leer el archivo",
            "Error", JOptionPane.ERROR_MESSAGE );
 
         System.exit( 1 );
      }
       return valor;
   } // fin del método leerRegistro
   // cerrar el archivo y terminar la aplicación
   private void cerrarArchivo()
   {
      // cerrar el archivo y salir
      try {
         if ( entrada != null )
            entrada.close();
 
         //System.exit( 0 );
      }
      // procesar excepción que puede ocurrir al cerrar el archivo
      catch( IOException excepcionES ) {
         JOptionPane.showMessageDialog( this, "Error al cerrar el archivo",
            "Error", JOptionPane.ERROR_MESSAGE );
 
         System.exit( 1 );
      }
 
   } // fin del método cerrarArchivo   
}
