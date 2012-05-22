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
 
public class EscribirArchivoAleatorio extends JFrame {
   
    private RandomAccessFile salida;
 
   private JButton botonEntrar, botonAbrir;
 
   private static final int NUMERO_REGISTROS = 9;
 
   // configurar GUI
   public EscribirArchivoAleatorio()
   {
      super( "Escribir en archivo de acceso aleatorio" );
 

   }
 
 
   // permitir al usuario seleccionar el archivo a abrir
   private void abrirArchivo()
   {
      // mostrar cuadro de diálogo para que el usuario pueda seleccionar el archivo
      JFileChooser selectorArchivo = new JFileChooser();
      selectorArchivo.setFileSelectionMode( JFileChooser.FILES_ONLY );
 
      int resultado = selectorArchivo.showOpenDialog( this );
 
      // si el usuario hizo clic en el botón Cancelar del cuadro de diálogo, regresar
      if ( resultado == JFileChooser.CANCEL_OPTION )
         return;
 
      // obtener el archivo seleccionado
      File nombreArchivo = selectorArchivo.getSelectedFile();
 
      // mostrar error si el nombre de archivo es incorrecto
      if ( nombreArchivo == null || nombreArchivo.getName().equals( "" ) )
         JOptionPane.showMessageDialog( this, "Nombre de archivo incorrecto",
            "Nombre de archivo incorrecto", JOptionPane.ERROR_MESSAGE );
 
      else {
 
         // abrir el archivo
         try {
            salida = new RandomAccessFile( nombreArchivo, "rw" );
         
         }
 
         // procesar excepción que puede ocurrir al abrir el archivo
         catch ( IOException excepcionES ) {
            JOptionPane.showMessageDialog( this, "El archivo no existe",
               "Nombre de archivo incorrecto", JOptionPane.ERROR_MESSAGE );
         } 
 
      } // fin de instrucción else
 
   } // fin del método abrirArchivo
 
   // cerrar el archivo y terminar la aplicación
   private void cerrarArchivo()
   {
      // cerrar el archivo y salir
      try {
         if ( salida != null )
            salida.close();
 
         //System.exit( 0 );
      }
 
      // procesar excepción que puede ocurrir al cerrar el archivo
      catch( IOException excepcionES ) {
         JOptionPane.showMessageDialog( this, "Error al cerrar el archivo",
            "Error", JOptionPane.ERROR_MESSAGE );
 
         System.exit( 1 );
      }
 
   } // fin del método cerrarArchivo
 
   // agregar un registro al archivo
   public void agregarRegistro(double valor, RandomAccessFile archivo)
   {
      
      // asegurarse que el campo cuenta tenga un valor
     // if ( ! campos[ IUBanco.P0 ].equals( "" ) ) {
 
         // escribir valores en el archivo
         try {
           
              RegistroCuentasAccesoAleatorio registro =
              new RegistroCuentasAccesoAleatorio();
              
               registro.escribir(archivo, valor);
               
              
               salida.seek( ( (int)valor  )*RegistroCuentasAccesoAleatorio.TAMANIO );
               registro.escribir( salida, 0b0);
              // this.cerrarArchivo();
        
 
         } // fin del bloque try
 
         // procesar formato incorrecto de número de cuenta o saldo
         catch ( NumberFormatException excepcionFormato ) {
                JOptionPane.showMessageDialog( this,
                   "Número de cuenta o saldo incorrectos",
                   "Formato de número incorrecto", JOptionPane.ERROR_MESSAGE );
         }
 
         // procesar excepciones que pueden ocurrir al escribir en el archivo
         catch ( IOException excepcionES ) {
             //JOptionPane.showMessageDialog( this,
                //"Error al escribir en el archivo", "Excepción de ES",
               // JOptionPane.ERROR_MESSAGE );
            cerrarArchivo();
         }
 
     // } // fin de instrucción if
 
   } // fin del método agregarRegistro  
}
 

