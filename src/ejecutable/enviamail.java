package ejecutable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import bd.Conexion;
import entidades.Clientes;
import entidades.Facturas;
 
import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*; 







public class enviamail {
 
 private BaseFont bfBold;
 private BaseFont bf;
 private int pageNumber = 0;
 
 
 
 public static void main(String[] args) {
 
	 
	 String pdfFilename = "";
	 
	 //////////////////////db
	 
	 
	 String RucComprador = "";
	   String RazonSocialComprador = "";
	   String DireccionComprador = "";
	   String TelefonoComprador = "";
	   String EmailComprador = "";
	   String clavedeacceso = "";


	   
	   
	   
	   
	   
	   
	   
	   
	Conexion ini1 = new Conexion();


	String z="TODOS";
	String xx=null;
	//ArrayList<Usuario> = consultarusuarios.(z, x);
	try{ 
		

	ini1.conectar();
	ArrayList<Clientes> Clientes = ini1.EnviarMail(clavedeacceso);

				
		
		
		for(int i=0;i<Clientes.size();i++){
			Clientes p = Clientes.get(i);
	   Vector registro = new Vector();

	   RucComprador = (p.getRucComprador());
	   RazonSocialComprador = (p.getRazonSocialComprador());
	   DireccionComprador = (p.getDireccionComprador());
	   TelefonoComprador = (p.getTelefonoComprador());
	   EmailComprador = (p.getEmailComprador());
	   clavedeacceso = (p.getclavedeacceso());
	   
	   
	   
	  
	//	System.out.println(clavedeacceso);
	  
	 
	 

		}
	}catch(Exception e){		
		System.out.println("Ocurrió un error2");
	}




	///////////////smtp
	
	
	final String username = "nathalycalzado@gmail.com";
    final String password = "contraseñaaqiof";
    Properties props = new Properties();
    props.put("mail.smtp.ssl.protocols", "TLSv1.2");
    props.put("mail.smtp.auth", true);
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");

    System.out.println(EmailComprador);
    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

    
   
    try {

    	 Message msg = new MimeMessage(session);
    
        
        
        msg.setFrom(new InternetAddress("nathalycalzado@gmail.com"));
        msg.setRecipient(Message.RecipientType.TO, new InternetAddress(EmailComprador));
        msg.setSubject("Nathaly Tienda de calzado brasilero - NUEVA FACTURA ELECTRONICA GENERADA");

        
        
        
        
        Multipart multipart = new MimeMultipart();

        MimeBodyPart textBodyPart = new MimeBodyPart();
        textBodyPart.setContent("<h1>Se ha generado una nueva factura electronica</h1>"
        		+ ""
        		+ "<p>Clave de Acceso: </p>"+clavedeacceso ,
                "text/html");
      

        MimeBodyPart attachmentBodyPart= new MimeBodyPart();
        DataSource source = new FileDataSource("C:/xml/RIDE/"+clavedeacceso+".pdf"); // ex : "C:\\test.pdf"
        attachmentBodyPart.setDataHandler(new DataHandler(source));
        attachmentBodyPart.setFileName(clavedeacceso+".pdf"); // ex : "test.pdf"

        multipart.addBodyPart(textBodyPart);  // add the text part
        multipart.addBodyPart(attachmentBodyPart); // add the attachement part

        msg.setContent(multipart);


        Transport.send(msg);

        System.out.println("Done");
        
        
         
        
        
        
        Conexion tt = new Conexion();
		  
 		  
		try{ 
			
		
		tt.conectar();
		if(tt.RideEnviado(clavedeacceso)) {
			System.out.println("FACTURAS ACTUALIZADAS");
			
		}

					
			 
		}catch(Exception e){		
			System.out.println("Ocurrió un error");
		}
		
  		
        
        
        
        
        

    } catch (MessagingException e) {
        e.printStackTrace();
    }
  }
	
	
	//////////////smtp
	
	
	
	
	
	
	
	
 
 
 
 
}