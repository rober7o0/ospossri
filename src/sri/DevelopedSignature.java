/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sri;

import java.io.File;

/**
 *
 * @author ccarreno
 */
public class DevelopedSignature {
    //private static Object XAdESBESSignature;
     
    public static void main(String[] args) throws Exception {
               
    /*String xmlPath = "c:\\1302202001095001212000120010010000002091234567817.XML";
    String pathSignature = "c:\\certificado.p12";
    String passSignature = "constraseña";
    String pathOut = "c:\\";
    String nameFileOut = "factura_sign.xml";*/
/*
   
    String passSignature = args[1];
    String xmlPath = args[2];
    String pathOut = args[3];
    String nameFileOut = args[4];
    
    */
    	
    	 String pathSignature = "C:/xml/roberto_enrique_matamoro_delgado.p12";
    	 String passSignature = "Celula0000";
    	 String pathOut = "";
    	 String xmlPath = "";
    	 String nameFileOut = "";
    	
    
    String[] pathnames;

    // Creates a new File instance by converting the given pathname string
    // into an abstract pathname
    File f = new File("C:/xml/generadas");
    
    

    // Populates the array with names of files and directories
    pathnames = f.list();

    // For each pathname in the pathnames array
    for (String pathname : pathnames) {
        // Print the names of files and directories
        System.out.println(pathname);
        
         pathOut = "C:/xml/firmadas/";
         xmlPath = "C:/xml/generadas/"+pathname;
         nameFileOut = pathname;
         
         
         
         
         System.out.println("Ruta del XML de entrada: " + xmlPath);
         System.out.println("Ruta Certificado: " + pathSignature);
         System.out.println("Clave del Certificado: " + passSignature);
         System.out.println("Ruta de salida del XML: " + pathOut);
         System.out.println("Nombre del archivo salido: " + nameFileOut);
          
         try{
             XAdESBESSignature.firmar(xmlPath, pathSignature, passSignature, pathOut, nameFileOut);
         }catch(Exception e){
             System.out.println("Error: " + e);
         }
         
         
         
         
         
    }
    
    
    
    
    
}
 
   
}