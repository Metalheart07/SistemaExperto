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
import javax.swing.*;
 
public class CrearArchivoAleatorio {
 
    private static final int NUMERO_REGISTROS = 9;
 
   // permitir al usuario seleccionar el archivo a abrir
   public void crearArchivo()
   {
      // mostrar cuadro de diálogo para que el usuario pueda seleccionar el archivo
      JFileChooser selectorArchivo = new JFileChooser();
      selectorArchivo.setFileSelectionMode( JFileChooser.FILES_ONLY );
 
      int resultado = selectorArchivo.showSaveDialog( null );
 
      // si el usuario hizo clic en el botón Cancelar del cuadro de diálogo, <span id="IL_AD5" class="IL_AD">regresar</span>
      if ( resultado == JFileChooser.CANCEL_OPTION )
         return;
 
      // obtener el archivo seleccionado
      File nombreArchivo = selectorArchivo.getSelectedFile(); 
 
      // mostrar error si el nombre del archivo es inválido
      if ( nombreArchivo == null || nombreArchivo.getName().equals( "" ) )
         JOptionPane.showMessageDialog( null, "Nombre de archivo incorrecto",
            "Nombre de archivo incorrecto", JOptionPane.ERROR_MESSAGE );
 
      else {
 
         // abrir el archivo
         try {
            RandomAccessFile archivo =
               new RandomAccessFile( nombreArchivo, "rw" );
 
            RegistroCuentasAccesoAleatorio registroEnBlanco =
               new RegistroCuentasAccesoAleatorio();
 
            // escribir 100 registros en blanco
            for ( int cuenta = 0; cuenta < NUMERO_REGISTROS; cuenta++ )
               registroEnBlanco.escribir( archivo, 0 );
 
            archivo.close(); // cerrar el archivo
 
            // mostrar mensaje indicando que el archivo se creó
            JOptionPane.showMessageDialog( null, "Se creó el archivo " +
               nombreArchivo, "Estado", JOptionPane.INFORMATION_MESSAGE );
              
            //JFrame.setDefaultLookAndFeelDecorated(true);
             //JDialog.setDefaultLookAndFeelDecorated(true);
            // new EscribirArchivoAleatorio();
 
              // terminar el programa
 
         } // fin del bloque try
 
         // procesar excepciones durante operaciones de apertura, escritura o cierre del archivo
         catch ( IOException excepcionES ) {
            JOptionPane.showMessageDialog( null, "Error al procesar el archivo",
               "Error al procesar el archivo", JOptionPane.ERROR_MESSAGE );
 
            System.exit( 1 );
         }
 
      } // fin de instrucción else
 
   } // fin del método crearArchivo
 
  // public static void main( String args[] )
   //{
      //JDialog.setDefaultLookAndFeelDecorated(true);
      //CrearArchivoAleatorio aplicacion= new CrearArchivoAleatorio();
     // aplicacion.crearArchivo();
      
    
   //}   

} 