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
import com.itextpdf.text.pdf.Barcode;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.Barcode39;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import bd.Conexion;
import entidades.Clientes;
import entidades.Facturas;
 
public class generaride {
 
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
	ArrayList<Clientes> Clientes = ini1.DatosClientes(clavedeacceso);

				
		
		
		for(int i=0;i<Clientes.size();i++){
			Clientes p = Clientes.get(i);
	   Vector registro = new Vector();

	   RucComprador = (p.getRucComprador());
	   RazonSocialComprador = (p.getRazonSocialComprador());
	   DireccionComprador = (p.getDireccionComprador());
	   TelefonoComprador = (p.getTelefonoComprador());
	   EmailComprador = (p.getEmailComprador());
	   clavedeacceso = (p.getclavedeacceso());
	   
	   
	   
	    pdfFilename = clavedeacceso+".pdf";

		
	  
	 
	 

		}
	}catch(Exception e){		
		System.out.println("Ocurrió un error2");
	}










	   
	   
	   
	int delimitador = 0;
	   
	   
	   
	   
	   
	   
	   Conexion ini2 = new Conexion();
		  
		double dpvpx = 0;
	double pvp12 = 0;
	double pvp0 = 0;
	double sumadescuentos = 0;

	//ArrayList<Usuario> = consultarusuarios.(z, x);

	try{ 
		
		ini2.conectar(); 
	ArrayList<Facturas> Facturas = ini2.DatosFactura(clavedeacceso);




				delimitador = Facturas.size();
	   

		
	}catch(Exception e){		
		System.out.println("Ocurrió un error3");
	}
		
	 
	 /////////////////////db
	 
	 
	 
	 
	 
	 
	 
  
  generaride generateInvoice = new generaride();
  if (args.length < 1)
  {
   System.err.println("Usage: java "+ generateInvoice.getClass().getName()+
   " PDF_Filename");
  
  }
 
 
  generateInvoice.createPDF(pdfFilename);
 
 }
 
 
 
 
 private void createPDF (String pdfFilename){
 
  Document doc = new Document();
  PdfWriter docWriter = null;
  initializeFonts();
  
  try {
   String path = "C:/xml/RIDE/" + pdfFilename;
   docWriter = PdfWriter.getInstance(doc , new FileOutputStream(path));
   doc.addAuthor("betterThanZero");
   doc.addCreationDate();
   doc.addProducer();
   doc.addCreator("MySampleCode.com");
   doc.addTitle("Invoice");
   doc.setPageSize(PageSize.LETTER);
 
   doc.open();
   PdfContentByte cb = docWriter.getDirectContent();
   
   boolean beginPage = true;
   int y = 0;
   int xy = 990;
   int saltador = 0;
   
   
   int fin = 1;
   
   
   
   
   
   
   
   ///////////////////////////////////NUMERO DE ITEMS
   
   
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
ArrayList<Clientes> Clientes = ini1.DatosClientes(clavedeacceso);

			
	
	
	for(int i=0;i<Clientes.size();i++){
		Clientes p = Clientes.get(i);
   Vector registro = new Vector();

   RucComprador = (p.getRucComprador());
   RazonSocialComprador = (p.getRazonSocialComprador());
   DireccionComprador = (p.getDireccionComprador());
   TelefonoComprador = (p.getTelefonoComprador());
   EmailComprador = (p.getEmailComprador());
   clavedeacceso = (p.getclavedeacceso());
   
   
   
   

	
  
 
 

	}
}catch(Exception e){		
	System.out.println("Ocurrió un error2");
}










   
   
   
int delimitador = 0;
   
   
   
   
   
   
   Conexion ini2 = new Conexion();
	  
	double dpvpx = 0;
double pvp12 = 0;
double pvp0 = 0;
double sumadescuentos = 0;

//ArrayList<Usuario> = consultarusuarios.(z, x);

try{ 
	
	ini2.conectar(); 
ArrayList<Facturas> Facturas = ini2.DatosFactura(clavedeacceso);




			delimitador = Facturas.size();
   

	
}catch(Exception e){		
	System.out.println("Ocurrió un error3");
}
	
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   for(int i=0; i < delimitador; i++ ){
    if(beginPage){
     beginPage = false; 
     generateLayout(doc, cb, i, delimitador); 
     
     
     
     if(i==0) {
     
     generateHeader(doc, cb);
     
     
     
    	 
     }
      
     if(i < 19){
    	 y = 315; 
    	
     }
     
     
     //espacio superior
     
    
    }
    
    //System.out.println(xy);
    
    
   
    
 
    /*
    
    */
  
    
    if(i > 17){
    	
    	if (fin == 1) {
    		//saltador= delimitador  ;
    		fin= fin-1;
    		printPageNumber(cb);
            doc.newPage();
        	
            beginPage = true;
        	xy = 720;
    	}
    	saltador = saltador + 1;
    	
          if ((saltador % 30)==0) {
          	printPageNumber(cb);
             doc.newPage();
             beginPage = true;
          	xy = 720;
          
          }
          
       /*   if (i==18) {
        	printPageNumber(cb);
            doc.newPage();
            beginPage = true;
            xy = 720;
          }  */
         
          
   	 // imprime detalles
        generateDetail2(doc, cb, i, xy);
        
        
    
        generateLayout(doc, cb, i, delimitador); 
       
        
        //xy = 990;
      //  printPageNumber(cb);
       // generateDetail2(doc, cb, i, xy);
      
        }
    
    
   
   
    if(i < 18){
    	
    	 
    generateDetail(doc, cb, i, y);
    
   
    
    
    }
    
    
    if (delimitador>3) {
    	  if (delimitador<19) {
    if (i+1==delimitador) {
    	
    	printPageNumber(cb);
        doc.newPage();
        beginPage = true;
        xy = 720;
        generateLayout(doc, cb, i, delimitador); 
    }
    	  }
    }
    
     
   
    
    
   
   // cb.rectangle(6, 6, 6, 6);
    //cb.stroke();
    
    y = y - 15;
    xy = xy - 15;
 /*   if(y < 50){
     printPageNumber(cb);
     doc.newPage();
     beginPage = true;
    }*/
    
    
  
   }
   printPageNumber(cb);
   //nueva pagina
   
   
 
  }
  catch (DocumentException dex)
  {
   dex.printStackTrace();
  }
  catch (Exception ex)
  {
   ex.printStackTrace();
  }
  finally
  {
   if (doc != null)
   {
    doc.close();
   }
   if (docWriter != null)
   {
    docWriter.close();
   }
  }
 }
 
 private void generateLayout(Document doc, PdfContentByte cb, int i, int delimitador)  {
 int lapagina =0 ;
	 
	
  try {
	  if (i<1) {
   cb.setLineWidth(1f);
 
   // Invoice Header box layout
   cb.roundRectangle(50,450,250,160,10);
   
   cb.roundRectangle(350,450,250,320,10);
   
   
   
   cb.rectangle(10,360,600,80);    //hacia la derecha   ///linea superior   ///izquiea   ///TAMAÑO ALTO VARIABLE
  // cb.moveTo(1,0);
   
   
   
   
   
   
   
   
   ///////////////db//////////////
   
   
   int escapador = 0;
   
   
   try {
  

    
    
    String price = null;
    
    
    
    
    
    
    ///////////////////////
    

    String RucComprador = "";
       String RazonSocialComprador = "";
       String DireccionComprador = "";
       String TelefonoComprador = "";
       String EmailComprador = "";
       String clavedeacceso = "";


       
       
       
       
       
       
       
       
 Conexion c = new Conexion();
   
  
 String z="TODOS";
 String xx=null;
 //ArrayList<Usuario> = consultarusuarios.(z, x);
 try{ 
 	

 c.conectar();
  ArrayList<Clientes> Clientes = c.DatosClientes(clavedeacceso);

 			
 	
 	
 	for(int r=0;r<Clientes.size();r++){
 		Clientes p = Clientes.get(r);
       Vector registro = new Vector();

       RucComprador = (p.getRucComprador());
       RazonSocialComprador = (p.getRazonSocialComprador());
       DireccionComprador = (p.getDireccionComprador());
       TelefonoComprador = (p.getTelefonoComprador());
       EmailComprador = (p.getEmailComprador());
       clavedeacceso = (p.getclavedeacceso());
       
       
       
       
   
 	
      
     
     

 	}
 }catch(Exception e){		
 	System.out.println("Ocurrió un error4");
 }






















 int bandera = 0 ;

    
    
    
    
  
    
    
    
    Conexion rx = new Conexion();
 	  
 		double dpvpx = 0;
 	double pvp12 = 0;
 	double pvp0 = 0;
 	double sumadescuentos = 0;
 	 
 	//ArrayList<Usuario> = consultarusuarios.(z, x);
 	String tarifas = null;
 	
 	String exis12 = null;
 	String exis0 = null;
 	try{ 
 		
 		rx.conectar(); 
 	 ArrayList<Facturas> Facturas = rx.DatosFactura(clavedeacceso);

 	 
 		
 		
 		for(int r=0;r<Facturas.size();r++){
 			Facturas p = Facturas.get(r);
           
 			
         String Nfactura = (p.getNfactura());
         String ClaveDeAcceso = (p.getClaveDeAcceso());
         String Cantidad = (p.getCantidad());
         String Detalle = (p.getDetalle());
         String CodigoProducto = (p.getCodigoProducto());
         String PrecioUnitario = (p.getPrecioUnitario());
         String Descuento = (p.getDescuento());
         String iva = (p.getiva());
         String xml = (p.getxml());
         
         int ivax = Integer.parseInt(iva);

         
         
         
         price = PrecioUnitario;
         
         
         
         
         double precio=Double.parseDouble(price);
         double PrecioUnitarios =Double.parseDouble(PrecioUnitario);
         
     	
     
     	   
     	   
       
         
        
         
         
         
         
         
         float xcantidad = Float.parseFloat(Cantidad);
         double dcantidad = Math.round(xcantidad * 100.0) / 100.0;
         
         float PrecioPVP = Float.parseFloat(PrecioUnitario);
         dpvpx = Math.round(PrecioPVP * 100.0) / 100.0;
         
         
         
         float descuentos = Float.parseFloat(Descuento);
         double ddescuento = Math.round(descuentos * 100.0) / 100.0;
         
         
         ddescuento = (dpvpx - ddescuento )*dcantidad;
         ddescuento = Math.round(ddescuento * 100.0) / 100.0;
         
         dpvpx = (dpvpx*dcantidad)-ddescuento ;
         
         
         
         sumadescuentos = sumadescuentos+ddescuento;
         
         
         
   if(escapador < 1) {
         	
         	escapador = escapador + 1;
         	 
         	 
        
         	 
         	 
         	 
    
         	 
         }
         
         
         
         
     	
         
         
         
         
         
         
         
         
         if(ivax==1) {
        	 iva="2";
        	  tarifas = "12";
        	  exis12 = "SI";
        	  
        	  
        	  pvp12 = pvp12+dpvpx;
        	  
        	  
        	  pvp12 = Math.round(pvp12 * 100.0) / 100.0;
        	  
        	  
         }
         if(ivax==6) {
        	 iva="0";
        	  tarifas = "0";
        	  exis0 = "SI";
        	
        	  pvp0 = pvp0+dpvpx;
        	  pvp0 = Math.round(pvp0 * 100.0) / 100.0;
        	  
        	
        	  
         }
         
          
         
         
         
         
         
         
         
         
       //  dpvp = Math.round(dpvp * 100.0) / 100.0;
         
         
         
         
       //  String DescuentoPorItem = Double.toString(ddescuento);
        // String preciodescontados2 = Double.toString(dpvp);
         
         
         

        
       //  System.out.println(Nfactura);
          
         
      
 		
         
        
        
  
 		}
 	}catch(Exception e){		
 		System.out.println("Ocurrió un error5");
 	}
 		
 		
 	double sumasinimpuestos = pvp12 + pvp0;
 	
 	
 	String totaldescuentos = Double.toString(sumadescuentos);
 	
 	double ivadebaseimponiblex = pvp12 * 0.12;
 	
 	ivadebaseimponiblex = Math.round(ivadebaseimponiblex * 100.0) / 100.0;
 	
 	
 	double todoconimpuestos = ivadebaseimponiblex + pvp12 + pvp0;
 	
 	todoconimpuestos = Math.round(todoconimpuestos * 100.0) / 100.0;
 	
 	String todoconimpuestosf = Double.toString(todoconimpuestos);
 	
 	
 	
 	
 	String base12 = Double.toString(pvp12);
 	String base0 = Double.toString(pvp0);
 	
 	
 	String totalsinimpuestos = Double.toString(sumasinimpuestos);
 	
 	String ivadebaseimponible = Double.toString(ivadebaseimponiblex);
 		
 		
    
// 	if(index < 1) {
// 	System.out.println("logre"+base12);
// 	System.out.println("logre"+base0);
 //	}
    
 	
 	
 	double valor3 = Double.parseDouble(base12) * 0.12;  
   
 	String valor = String.valueOf(valor3);
 	
 	System.out.println("df"+ valor3);
 	
 	
 	
 	
 	
 	
 	
 	   
 	   
 	   
 	   
 	  String secuencia = clavedeacceso.substring(30, 39);
		String a = clavedeacceso.substring(4, 8);
		String m = clavedeacceso.substring(2, 4);
		String d = clavedeacceso.substring(0, 2);
 	   
 	
 	   
 	   
 	   
		   // Invoice Header box Text Headings 
		   createHeadings(cb,370,743,"RUC:       0912077864001");
		   createHeadings(cb,370,723,"FACTURA");
		   createHeadings(cb,370,703,"No. 001-001-"+secuencia);
		   createHeadings(cb,370,683,"NÚMERO DE AUTORIZACIÓN:");
		   createHeadings(cb,370,663,clavedeacceso);
		  // createHeadings(cb,370,643,"FECHA Y HORA DE");
		//   createHeadings(cb,370,633,"AUTORIZACIÓN:");
		   createHeadings(cb,370,613,"AMBIENTE:                PRODUCCION");
		   createHeadings(cb,370,593,"EMISIÓN:                   NORMAL");
		   createHeadings(cb,370,573,"AUTORIZACIÓN        AUTORIZADA");
		   createHeadings(cb,370,553,"CLAVE DE ACCESO");
		   
		   
		   Barcode128 barcode128 = new Barcode128();
		   barcode128.setCode(clavedeacceso);
		   barcode128.setCodeType(Barcode.CODE128);
		   Image code128Image = barcode128.createImageWithBarcode(cb, null, null);
		  // doc.add(code128Image);
		   
		   
		   
		    
		   code128Image.setAbsolutePosition(360,500);
		   code128Image.scalePercent(90);
		   doc.add(code128Image);
			
		   
		   //createHeadingsbarcode(cb,370,553,code128Image);
		   
		   /*
		   Barcode39 barcode39 = new Barcode39();
		   barcode39.setCode("123456789");
		   Image code39Image = barcode39.createImageWithBarcode(cb, null, null);
		   doc.add(code39Image);
		   
		   */

		   
		   
		   
		   
		   
		 //  createHeadings(cb,370,500,clavedeacceso);
 	   
 	
 	
 	
 	
    
    
    
     
   }
  
   catch (Exception ex){
    ex.printStackTrace();
   }
   
   
   
   
   
   
   
   
   
   ///////////////db//////////////
   
   
   
   
   
   
   
   
   
   
  
 
 

   
   
   
   
   
   //add the images
   Image companyLogo = Image.getInstance("images/olympics_logo.jpg");
   companyLogo.setAbsolutePosition(25,700);
   companyLogo.scalePercent(100);
   doc.add(companyLogo);
	  }
   // Invoice Detail box layout 
   //DERECHA // ANCHO // 
	  
	  
	  
	  
	  
	  if(i<1) {
		  
		  int altitud = -14;
		  if(delimitador<20) {
		  altitud = altitud * delimitador;
		  }
		  if(delimitador>19) {
		  
		  altitud = altitud * 18;
		  
		  }
		  
   cb.rectangle(1,350,609,-40+altitud);    //hacia la derecha   ///linea superior   ///izquiea   ///TAMAÑO ALTO VARIABLE
   cb.moveTo(1,330);
   cb.lineTo(610,330);  //linea largo
   cb.moveTo(58,350);
   cb.lineTo(58,310+altitud);
   
   cb.moveTo(88,350);
   cb.lineTo(88,310+altitud);
   
   
   
   
   
   
   
   //   ///LARGO VARIABLE DARLE MULTIPLICA   310 SALTAS DE 15 EN 15
   cb.moveTo(120,310+altitud);
   cb.lineTo(120,350);
   
   cb.moveTo(398,310+altitud); //  ///alto
   cb.lineTo(398,350);
   
   
   cb.moveTo(435,310+altitud); //  ///alto
   cb.lineTo(435,350);  //x   //movelo vertical
   
   
   cb.moveTo(468,310+altitud); //  ///alto
   cb.lineTo(468,350);  //x   //movelo vertical
   
   cb.moveTo(540,310+altitud); //  ///alto
   cb.lineTo(540,350);  //x   //movelo vertical
   
   
   
   //
   cb.moveTo(575,310+altitud); //  ///alto
   cb.lineTo(575,350);  //x   //movelo vertical
   
   
   //// rectangulos izquierda
   
   
   if(delimitador<4) {
   
   cb.rectangle(398,310+altitud,212,-20);    //hacia la derecha   ///linea superior   ///izquiea   ///TAMAÑO ALTO VARIABLE
   cb.moveTo(20,44);
   
   cb.rectangle(398,290+altitud,212,-20);    //hacia la derecha   ///linea superior   ///izquiea   ///TAMAÑO ALTO VARIABLE
   cb.moveTo(20,44);
   
   cb.rectangle(398,270+altitud,212,-20);    //hacia la derecha   ///linea superior   ///izquiea   ///TAMAÑO ALTO VARIABLE
   cb.moveTo(20,44);
   
   cb.rectangle(398,250+altitud,212,-20);    //hacia la derecha   ///linea superior   ///izquiea   ///TAMAÑO ALTO VARIABLE
   cb.moveTo(20,44);
   
   cb.rectangle(398,230+altitud,212,-20);    //hacia la derecha   ///linea superior   ///izquiea   ///TAMAÑO ALTO VARIABLE
   cb.moveTo(20,44);
   
   cb.rectangle(398,210+altitud,212,-20);    //hacia la derecha   ///linea superior   ///izquiea   ///TAMAÑO ALTO VARIABLE
   cb.moveTo(20,44);
   
   cb.rectangle(398,190+altitud,212,-20);    //hacia la derecha   ///linea superior   ///izquiea   ///TAMAÑO ALTO VARIABLE
   cb.moveTo(20,44);
   
   
   cb.rectangle(398,170+altitud,212,-20);    //hacia la derecha   ///linea superior   ///izquiea   ///TAMAÑO ALTO VARIABLE
   cb.moveTo(20,44);
   
   
   cb.rectangle(398,150+altitud,212,-20);    //hacia la derecha   ///linea superior   ///izquiea   ///TAMAÑO ALTO VARIABLE
   cb.moveTo(20,44);
   
   
   cb.rectangle(398,130+altitud,212,-20);    //hacia la derecha   ///linea superior   ///izquiea   ///TAMAÑO ALTO VARIABLE
   cb.moveTo(20,44);
   
   
   cb.rectangle(398,110+altitud,212,-20);    //hacia la derecha   ///linea superior   ///izquiea   ///TAMAÑO ALTO VARIABLE
   cb.moveTo(20,44);
   
   
   cb.moveTo(540,90+altitud); //  ///alto
   cb.lineTo(540,350);  //x   //movelo vertical
   
	  }
   
   
   
   
   
   
   
   //System.out.println(delimitador+"ggg");
   
   
   ////////////metodo de pago //20 margen izquierdo // 150 alto 
   
   if(delimitador<4) {
   cb.rectangle(20,230+altitud,340,50);
   
   
   cb.rectangle(20,210+altitud,340,-20);  
   
   cb.rectangle(20,210+altitud,340,-40);  
   
   cb.rectangle(20,210+altitud,220,-40);  
   }
   
   
   
   cb.moveTo(499,310+altitud);
   cb.lineTo(499,350);
   cb.stroke();
	 
   // Invoice Detail box Text Headings 
   
   createHeadings(cb,22,342,"Cod.");
   createHeadings(cb,22,335,"Principal");
   createHeadings(cb,60,342,"Cod.");
   createHeadings(cb,60,335,"Auxiliar");
   createHeadings(cb,90,335,"Cantidad");
   createHeadings(cb,200,335,"Descripción");
   createHeadings(cb,400,342,"Detalle");
   createHeadings(cb,400,335,"Adicional");
   createHeadings(cb,440,342,"Precio");
   createHeadings(cb,440,335,"Unitario");
   createHeadings(cb,470,335,"Subsidio");
   createHeadings(cb,500,342,"Precio");
   createHeadings(cb,500,335,"sin Subsidio");
   createHeadings(cb,540,335,"Descuento");
   createHeadings(cb,580,342,"Precio");
   createHeadings(cb,580,335,"Total");
   
   
   
   
   
  
 
   
   
   int totalesaltitud = 15;
   totalesaltitud = totalesaltitud * delimitador;
   
   
   
   if(delimitador<4) {
	   
	   
	   
	   
	   ///////////////db//////////////
	   
	   
	   int escapador = 0;
	   
	   
	   try {
	  

	    
	    
	    String price = null;
	    
	    
	    
	    
	    
	    
	    ///////////////////////
	    

	    String RucComprador = "";
	       String RazonSocialComprador = "";
	       String DireccionComprador = "";
	       String TelefonoComprador = "";
	       String EmailComprador = "";
	       String clavedeacceso = "";


	       
	       
	       
	       
	       
	       
	       
	       
	 Conexion c = new Conexion();
	   
	  
	 String z="TODOS";
	 String xx=null;
	 //ArrayList<Usuario> = consultarusuarios.(z, x);
	 try{ 
	 	

	 c.conectar();
	  ArrayList<Clientes> Clientes = c.DatosClientes(clavedeacceso);

	 			
	 	
	 	
	 	for(int r=0;i<Clientes.size();r++){
	 		Clientes p = Clientes.get(r);
	       Vector registro = new Vector();

	       RucComprador = (p.getRucComprador());
	       RazonSocialComprador = (p.getRazonSocialComprador());
	       DireccionComprador = (p.getDireccionComprador());
	       TelefonoComprador = (p.getTelefonoComprador());
	       EmailComprador = (p.getEmailComprador());
	       clavedeacceso = (p.getclavedeacceso());
	       
	       
	       
	       
	   
	 	
	      
	     
	     

	 	}
	 }catch(Exception e){		
	 	System.out.println("Ocurrió un error6");
	 }






















	 int bandera = 0 ;

	    
	    
	    
	    
	  
	    
	    
	    
	    Conexion rx = new Conexion();
	 	  
	 		double dpvpx = 0;
	 	double pvp12 = 0;
	 	double pvp0 = 0;
	 	double sumadescuentos = 0;
	 	 
	 	//ArrayList<Usuario> = consultarusuarios.(z, x);
	 	String tarifas = null;
	 	
	 	String exis12 = null;
	 	String exis0 = null;
	 	try{ 
	 		
	 		rx.conectar(); 
	 	 ArrayList<Facturas> Facturas = rx.DatosFactura(clavedeacceso);

	 	 
	 		
	 		
	 		for(int r=0;i<Facturas.size();r++){
	 			Facturas p = Facturas.get(r);
	           
	 			
	         String Nfactura = (p.getNfactura());
	         String ClaveDeAcceso = (p.getClaveDeAcceso());
	         String Cantidad = (p.getCantidad());
	         String Detalle = (p.getDetalle());
	         String CodigoProducto = (p.getCodigoProducto());
	         String PrecioUnitario = (p.getPrecioUnitario());
	         String Descuento = (p.getDescuento());
	         String iva = (p.getiva());
	         String xml = (p.getxml());
	         
	         int ivax = Integer.parseInt(iva);

	         
	         
	         
	         price = PrecioUnitario;
	         
	         
	         
	         
	         double precio=Double.parseDouble(price);
	         double PrecioUnitarios =Double.parseDouble(PrecioUnitario);
	         
	     	
	     
	     	   
	     	   
	       
	         
	        
	         
	         
	         
	         
	         
	         float xcantidad = Float.parseFloat(Cantidad);
	         double dcantidad = Math.round(xcantidad * 100.0) / 100.0;
	         
	         float PrecioPVP = Float.parseFloat(PrecioUnitario);
	         dpvpx = Math.round(PrecioPVP * 100.0) / 100.0;
	         
	         
	         
	         float descuentos = Float.parseFloat(Descuento);
	         double ddescuento = Math.round(descuentos * 100.0) / 100.0;
	         
	         
	         ddescuento = (dpvpx - ddescuento )*dcantidad;
	         ddescuento = Math.round(ddescuento * 100.0) / 100.0;
	         
	         dpvpx = (dpvpx*dcantidad)-ddescuento ;
	         
	         
	         
	         sumadescuentos = sumadescuentos+ddescuento;
	         
	         
	         
	   if(escapador < 1) {
	         	
	         	escapador = escapador + 1;
	         	 
	         	 
	        
	         	 
	         	 
	         	 
	    
	         	 
	         }
	         
	         
	         
	         
	     	
	         
	         
	         
	         
	         
	         
	         
	         
	         if(ivax==1) {
	        	 iva="2";
	        	  tarifas = "12";
	        	  exis12 = "SI";
	        	  
	        	  
	        	  pvp12 = pvp12+dpvpx;
	        	  
	        	  
	        	  pvp12 = Math.round(pvp12 * 100.0) / 100.0;
	        	  
	        	  
	         }
	         if(ivax==6) {
	        	 iva="0";
	        	  tarifas = "0";
	        	  exis0 = "SI";
	        	
	        	  pvp0 = pvp0+dpvpx;
	        	  pvp0 = Math.round(pvp0 * 100.0) / 100.0;
	        	  
	        	
	        	  
	         }
	         
	          
	         
	         
	         
	         
	         
	         
	         
	         
	       //  dpvp = Math.round(dpvp * 100.0) / 100.0;
	         
	         
	         
	         
	       //  String DescuentoPorItem = Double.toString(ddescuento);
	        // String preciodescontados2 = Double.toString(dpvp);
	         
	         
	         

	        
	       //  System.out.println(Nfactura);
	          
	         
	      
	 		
	         
	        
	        
	  
	 		}
	 	}catch(Exception e){		
	 		System.out.println("Ocurrió un error");
	 	}
	 		
	 		
	 	double sumasinimpuestos = pvp12 + pvp0;
	 	
	 	
	 	String totaldescuentos = Double.toString(sumadescuentos);
	 	
	 	double ivadebaseimponiblex = pvp12 * 0.12;
	 	
	 	ivadebaseimponiblex = Math.round(ivadebaseimponiblex * 100.0) / 100.0;
	 	
	 	
	 	double todoconimpuestos = ivadebaseimponiblex + pvp12 + pvp0;
	 	
	 	todoconimpuestos = Math.round(todoconimpuestos * 100.0) / 100.0;
	 	
	 	String todoconimpuestosf = Double.toString(todoconimpuestos);
	 	
	 	
	 	
	 	
	 	String base12 = Double.toString(pvp12);
	 	String base0 = Double.toString(pvp0);
	 	
	 	
	 	String totalsinimpuestos = Double.toString(sumasinimpuestos);
	 	
	 	String ivadebaseimponible = Double.toString(ivadebaseimponiblex);
	 		
	 		
	    
	// 	if(index < 1) {
	// 	System.out.println("logre"+base12);
	// 	System.out.println("logre"+base0);
	 //	}
	    
	 	
	 	
	 	double valor3 = Double.parseDouble(base12) * 0.12;  
       
	 	String valor = String.valueOf(valor3);
	 	
	// 	System.out.println("df"+ valor3);
	 	
	 	  createHeadingstotales(cb,600,295+altitud,base12);
	 	   
	 	   createHeadingstotales(cb,600,275+altitud,base0);
	 	   
	 	   createHeadingstotales(cb,600,255+altitud,"00,00");
	 	   
	 	   createHeadingstotales(cb,600,235+altitud,"00,00");
	 	   
	 	   createHeadingstotales(cb,600,215+altitud,totalsinimpuestos);
	 	   
	 	   createHeadingstotales(cb,600,195+altitud,totaldescuentos);
	 	   createHeadingstotales(cb,600,175+altitud,"00,00");
	 	   
	 	   createHeadingstotales(cb,600,155+altitud,ivadebaseimponible);
	 	   createHeadingstotales(cb,600,135+altitud,"00,00");
	 	   
	 	   createHeadingstotales(cb,600,115+altitud,"00,00");
	 	   createHeadingstotales(cb,600,95+altitud,todoconimpuestosf);
	 	
	 	
	 	
	 	
	 	
	 	
	 	   
	 	   
	 	   
	 	   
	 	  String secuencia = clavedeacceso.substring(30, 39);
    		String a = clavedeacceso.substring(4, 8);
    		String m = clavedeacceso.substring(2, 4);
    		String d = clavedeacceso.substring(0, 2);
	 	   
	 	   createHeadingstotalesl(cb,140,270+altitud,"INFORMACION ADICIONAL");
	 	   
	 	   createHeadingstotalesl(cb,50,260+altitud,"Correo Cliente");
	 	   
	 	   createHeadingstotalesl(cb,100,260+altitud,EmailComprador);
	 	   
	 	   createHeadingstotalesl(cb,50,250+altitud,"fechaPago");
	 	   
	 	   createHeadingstotalesl(cb,100,250+altitud,d+"/"+m+"/"+a);
	 	   
	 	  createHeadingstotalesl(cb,50,240+altitud,"Telefono");
	 	   
	 	   createHeadingstotalesl(cb,100,240+altitud,TelefonoComprador);
	 	   
	 	   
	 	  createHeadingstotalesl(cb,50,232+altitud,"Contribuyente Régimen RIMPE");
	 	   
	 	   createHeadingstotalesl(cb,170,232+altitud,"EMPRENDEDOR");
	 	   
	 	   
	 	   createHeadingstotalesl(cb,70,195+altitud,"FORMA DE PAGO");
	 	   
	 	   createHeadingstotalesl(cb,260,195+altitud,"VALOR");
	 	   

	 	   createHeadingstotalesl(cb,24,175+altitud,"02 - OTRO CON UTILIZACION DEL SISTEMA FINANCIERO");
	 	   
	 	   createHeadingstotalesl(cb,260,175+altitud,todoconimpuestosf);
	 	   
	 	   
	 	   
	 	   
	 	   
	 	   
	 	   
	 	
	 	
	 	
	 	
	    
	    
	    
	     
	   }
	  
	   catch (Exception ex){
	    ex.printStackTrace();
	   }
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   ///////////////db//////////////
	   
	   
	   
	   
 
   
   
 

   createHeadingstotalesl(cb,420,295+altitud,"SUBTOTAL 12%");
   createHeadingstotalesl(cb,420,275+altitud,"SUBTOTAL 0%");
   createHeadingstotalesl(cb,420,255+altitud,"SUBTOTAL NO OBJETO DE IVA");
   createHeadingstotalesl(cb,420,235+altitud,"SUBTOTAL EXENTO DE IVA");
   createHeadingstotalesl(cb,420,215+altitud,"SUBTOTAL SIN IMPUESTOS");
   createHeadingstotalesl(cb,420,195+altitud,"TOTAL DESCUENTO");
   createHeadingstotalesl(cb,420,175+altitud,"ICE");
   createHeadingstotalesl(cb,420,155+altitud,"IVA 12%");
   createHeadingstotalesl(cb,420,135+altitud,"IRBPNR");
   createHeadingstotalesl(cb,420,115+altitud,"PROPINA");
   createHeadingstotalesl(cb,420,95+altitud,"VALOR TOTAL");
   
   
   
   
   
   }
   }
	  
	  
	  
	  
	  
	  if(delimitador>17) {
		  
		  delimitador = delimitador-18;
	  }
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  
	 
	  int altitud = -14;
	  altitud = altitud * delimitador;
	 
	  if (altitud<420) {
		  altitud = -420;
		  
	  }
	  
	  // imprime lineas
	 /// System.out.println("salto porque entro nueva xx"+i);
	  if(i>0) {
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		
		  
		  
		  //cb.rectangle(20,50,550,700);
		  cb.rectangle(1,750,609,-40+altitud); 
		  cb.moveTo(1,730);
		   cb.lineTo(610,730);  //linea largo
		   cb.moveTo(58,750);
		   cb.lineTo(58,710+altitud);
		   
		   cb.moveTo(88,750);
		   cb.lineTo(88,710+altitud);
		   
		    
		   
		   
		   
		   
		   
		   //   ///LARGO VARIABLE DARLE MULTIPLICA   310 SALTAS DE 15 EN 15
		   cb.moveTo(120,710+altitud);
		   cb.lineTo(120,750);
		   
		   cb.moveTo(398,710+altitud); //  ///alto
		   cb.lineTo(398,750);
		   
		   
		   cb.moveTo(435,710+altitud); //  ///alto
		   cb.lineTo(435,750);  //x   //movelo vertical
		   
		   
		   cb.moveTo(468,710+altitud); //  ///alto
		   cb.lineTo(468,750);  //x   //movelo vertical
		   
		   
		   
		   cb.moveTo(499,710+altitud); //  ///alto
		   cb.lineTo(499,750);  //x   //movelo vertical
		   
		   
		   cb.moveTo(540,710+altitud); //  ///alto
		   cb.lineTo(540,750);  //x   //movelo vertical
		   
		   
		   
		   //
		   cb.moveTo(575,710+altitud); //  ///alto
		   cb.lineTo(575,750);  //x   //movelo vertical
		   
		   //cb.lineTo(500,350);
		   cb.stroke();
		   
		   lapagina = lapagina +1 ;
		  
		   
		 //  lapagina = delimitador % 19;
		  // System.out.println(lapagina);
		   lapagina = delimitador + 18;
		   int lapagina2 = i;
		   int bad1 = 0;
		   int sale = 0;
		/*   for(int g=lapagina2; g < lapagina; g++ ){
			   bad1 = bad1 + 1;
			   if (bad1 > 28) {
			    sale = 1;
			   }
		   }*/
		   
		   
		 //  System.out.println(delimitador+18);
	//	    System.out.println(lapagina2);
		    
		    
		    
		    
		    if((delimitador+18)==(lapagina2+1)) {
		    	
		    	sale = 1;
		    }
		    
		    
		    
		    	if(delimitador>3) {
		    		if(delimitador<19) {
		    	sale = 1;
		    		}
		    }
		    
		//   System.out.println(lapagina2);
		  
		   if(sale==1) {
			//   System.out.println(sale);
			      
			   
			   cb.rectangle(398,290,212,-20);    //hacia la derecha   ///linea superior   ///izquiea   ///TAMAÑO ALTO VARIABLE
			   cb.moveTo(20,44);
			   
			   cb.rectangle(398,270,212,-20);    //hacia la derecha   ///linea superior   ///izquiea   ///TAMAÑO ALTO VARIABLE
			   cb.moveTo(20,44);
			   
			   cb.rectangle(398,250,212,-20);    //hacia la derecha   ///linea superior   ///izquiea   ///TAMAÑO ALTO VARIABLE
			   cb.moveTo(20,44);
			   
			   cb.rectangle(398,230,212,-20);    //hacia la derecha   ///linea superior   ///izquiea   ///TAMAÑO ALTO VARIABLE
			   cb.moveTo(20,44);
			   
			   cb.rectangle(398,210,212,-20);    //hacia la derecha   ///linea superior   ///izquiea   ///TAMAÑO ALTO VARIABLE
			   cb.moveTo(20,44);
			   
			   cb.rectangle(398,190,212,-20);    //hacia la derecha   ///linea superior   ///izquiea   ///TAMAÑO ALTO VARIABLE
			   cb.moveTo(20,44);
			   
			   cb.rectangle(398,170,212,-20);    //hacia la derecha   ///linea superior   ///izquiea   ///TAMAÑO ALTO VARIABLE
			   cb.moveTo(20,44);
			   
			   
			   cb.rectangle(398,150,212,-20);    //hacia la derecha   ///linea superior   ///izquiea   ///TAMAÑO ALTO VARIABLE
			   cb.moveTo(20,44);
			   
			   
			   cb.rectangle(398,130,212,-20);    //hacia la derecha   ///linea superior   ///izquiea   ///TAMAÑO ALTO VARIABLE
			   cb.moveTo(20,44);
			   
			   
			   cb.rectangle(398,110,212,-20);    //hacia la derecha   ///linea superior   ///izquiea   ///TAMAÑO ALTO VARIABLE
			   cb.moveTo(20,44);
			   
			   
			   cb.rectangle(398,90,212,-20);    //hacia la derecha   ///linea superior   ///izquiea   ///TAMAÑO ALTO VARIABLE
			   cb.moveTo(20,44);
			   
			   
			   cb.moveTo(540,90); //  ///alto
			   cb.lineTo(540,350);  //x   //movelo vertical
			   
			   
			   
			   
			   
			   
			   
		 
			   cb.rectangle(20,570+altitud,340,50);
			   
			   
			   cb.rectangle(20,550+altitud,340,-20);  
			   
			   cb.rectangle(20,550+altitud,340,-40);  
			   
			   cb.rectangle(20,550+altitud,220,-40);  
			 
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   
			   //////////////////db2///////////////////////
			   
			   
			   String RucComprador = "";
		          String RazonSocialComprador = "";
		          String DireccionComprador = "";
		          String TelefonoComprador = "";
		          String EmailComprador = "";
		          String clavedeacceso = "";


		          
		          
		          
		          
		          
		          
		          
		          
	    	Conexion c = new Conexion();
			  
			 
			String z="TODOS";
			String xx=null;
			//ArrayList<Usuario> = consultarusuarios.(z, x);
			try{ 
				
			
			c.conectar();
			 ArrayList<Clientes> Clientes = c.DatosClientes(clavedeacceso);

						
				
				
				for(int i1=0;i1<Clientes.size();i1++){
					Clientes p = Clientes.get(i1);
		          Vector registro = new Vector();

		          RucComprador = (p.getRucComprador());
		          RazonSocialComprador = (p.getRazonSocialComprador());
		          DireccionComprador = (p.getDireccionComprador());
		          TelefonoComprador = (p.getTelefonoComprador());
		          EmailComprador = (p.getEmailComprador());
		          clavedeacceso = (p.getclavedeacceso());
		          
		          
		         // System.out.println(clavedeacceso);
		          
		      
				
		         
		        
		        
	      
				}
			}catch(Exception e){		
				System.out.println("Ocurrió un error");
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			Conexion rx = new Conexion();
	  		  
      		double dpvpx = 0;
			double pvp12 = 0;
			double pvp0 = 0;
			double sumadescuentos = 0;
   		 
    		//ArrayList<Usuario> = consultarusuarios.(z, x);
			String tarifas = null;
			
			String exis12 = null;
			String exis0 = null;
    		try{ 
    			
    			rx.conectar(); 
    		 ArrayList<Facturas> Facturas = rx.DatosFactura(clavedeacceso);

    		 
    			
    			
    			for(int i1=0;i1<Facturas.size();i1++){
    				Facturas p = Facturas.get(i1);
    	           
    				
    	         String Nfactura = (p.getNfactura());
    	         String ClaveDeAcceso = (p.getClaveDeAcceso());
    	         String Cantidad = (p.getCantidad());
    	         String Detalle = (p.getDetalle());
    	         String CodigoProducto = (p.getCodigoProducto());
    	         String PrecioUnitario = (p.getPrecioUnitario());
    	         String Descuento = (p.getDescuento());
    	         String iva = (p.getiva());
    	         String xml = (p.getxml());
    	         
    	         int ivax = Integer.parseInt(iva);

    	         
    	         
    	         
    	         float xcantidad = Float.parseFloat(Cantidad);
    	         double dcantidad = Math.round(xcantidad * 100.0) / 100.0;
    	         
    	         float PrecioPVP = Float.parseFloat(PrecioUnitario);
    	         dpvpx = Math.round(PrecioPVP * 100.0) / 100.0;
    	         
    	         
    	         
    	         float descuentos = Float.parseFloat(Descuento);
    	         double ddescuento = Math.round(descuentos * 100.0) / 100.0;
    	         
    	         
    	         ddescuento = (dpvpx - ddescuento )*dcantidad;
    	         ddescuento = Math.round(ddescuento * 100.0) / 100.0;
    	         
    	         dpvpx = (dpvpx*dcantidad)-ddescuento ;
    	         
    	         
    	         
    	         sumadescuentos = sumadescuentos+ddescuento;
    	         
    	         
    	         
    	         if(ivax==1) {
    	        	 iva="2";
    	        	  tarifas = "12";
    	        	  exis12 = "SI";
    	        	  
    	        	  
    	        	  pvp12 = pvp12+dpvpx;
    	        	  
    	        	  
    	        	  pvp12 = Math.round(pvp12 * 100.0) / 100.0;
    	        	  
    	        	  
    	         }
    	         if(ivax==6) {
    	        	 iva="0";
    	        	  tarifas = "0";
    	        	  exis0 = "SI";
    	        	
    	        	  pvp0 = pvp0+dpvpx;
    	        	  pvp0 = Math.round(pvp0 * 100.0) / 100.0;
    	        	  
    	        	
    	        	  
    	         }
    			
			   
    			
			   
    		}
    			
    			
    			
    			
    			
    		 	double sumasinimpuestos = pvp12 + pvp0;
    		 	
    		 	
    		 	String totaldescuentos = Double.toString(sumadescuentos);
    		 	
    		 	double ivadebaseimponiblex = pvp12 * 0.12;
    		 	
    		 	ivadebaseimponiblex = Math.round(ivadebaseimponiblex * 100.0) / 100.0;
    		 	
    		 	
    		 	double todoconimpuestos = ivadebaseimponiblex + pvp12 + pvp0;
    		 	
    		 	todoconimpuestos = Math.round(todoconimpuestos * 100.0) / 100.0;
    		 	
    		 	String todoconimpuestosf = Double.toString(todoconimpuestos);
    		 	
    		 	
    		 	
    		 	
    		 	String base12 = Double.toString(pvp12);
    		 	String base0 = Double.toString(pvp0);
    		 	
    		 	
    		 	String totalsinimpuestos = Double.toString(sumasinimpuestos);
    		 	
    		 	String ivadebaseimponible = Double.toString(ivadebaseimponiblex);
    		 		
    		 		
    		    
    		// 	if(index < 1) {
    		// 	System.out.println("logre"+base12);
    		// 	System.out.println("logre"+base0);
    		 //	}
    		    
    		 	
    		 	
    		 	double valor3 = Double.parseDouble(base12) * 0.12;  
    	       
    		 	String valor = String.valueOf(valor3);
    		 	
    			
    			
    			  
 			   createHeadingstotales(cb,600,275,base12);
 			   
 			   createHeadingstotales(cb,600,255,base0);
 			   
 			   createHeadingstotales(cb,600,235,"00,00");
 			   
 			   createHeadingstotales(cb,600,215,"00,00");
 			   
 			   createHeadingstotales(cb,600,195,totalsinimpuestos);
 			   
 			   createHeadingstotales(cb,600,175,totaldescuentos);
 			   createHeadingstotales(cb,600,155,"00,00");
 			   
 			   createHeadingstotales(cb,600,135,ivadebaseimponible);
 			   createHeadingstotales(cb,600,115,"00,00");
 			   
 			   createHeadingstotales(cb,600,95,"00,00");
 			   createHeadingstotales(cb,600,75,todoconimpuestosf);
 			   
 			   
 			   
 			   
 			   
 			   
 			   
 			   
 			   String secuencia = clavedeacceso.substring(30, 39);
	    		String a = clavedeacceso.substring(4, 8);
	    		String m = clavedeacceso.substring(2, 4);
	    		String d = clavedeacceso.substring(0, 2);
		 	   
			   
			///   System.out.println("salto porque entro nueva iva");
			   
			   
			   createHeadingstotalesl(cb,140,190,"INFORMACION ADICIONAL");
			   
			   createHeadingstotalesl(cb,50,180,"Correo Cliente");
			   
			   createHeadingstotalesl(cb,100,180,EmailComprador);
			   
			   createHeadingstotalesl(cb,50,170,"fechaPago");
			   
			   createHeadingstotalesl(cb,100,170,d+"/"+m+"/"+a);
			   
			   
			   
			   createHeadingstotalesl(cb,50,160,"Telefono");
		 	   
		 	   createHeadingstotalesl(cb,100,160,TelefonoComprador);
			   
			   
			   createHeadingstotalesl(cb,70,115,"FORMA DE PAGO");
			   
			   createHeadingstotalesl(cb,260,115,"VALOR");
			   

			   createHeadingstotalesl(cb,24,95,"02 - OTRO CON UTILIZACION DEL SISTEMA FINANCIERO");
			   
			   createHeadingstotalesl(cb,260,95,todoconimpuestosf);
 			   
 			   
 			   
 			   
 			   
 			   
 			   
    			
    			
    			/*
    			
	 	double valor3 = Double.parseDouble(base12) * 0.12;  
       
	 	String valor = String.valueOf(valor3);
	 	
	 	System.out.println("df"+ valor3);
	 	
	 	  createHeadingstotales(cb,600,295+altitud,base12);
	 	   
	 	   createHeadingstotales(cb,600,275+altitud,base0);
	 	   
	 	   createHeadingstotales(cb,600,255+altitud,"00,00");
	 	   
	 	   createHeadingstotales(cb,600,235+altitud,"00,00");
	 	   
	 	   createHeadingstotales(cb,600,215+altitud,totalsinimpuestos);
	 	   
	 	   createHeadingstotales(cb,600,195+altitud,totaldescuentos);
	 	   createHeadingstotales(cb,600,175+altitud,"00,00");
	 	   
	 	   createHeadingstotales(cb,600,155+altitud,valor);
	 	   createHeadingstotales(cb,600,135+altitud,"00,00");
	 	   
	 	   createHeadingstotales(cb,600,115+altitud,"00,00");
	 	   createHeadingstotales(cb,600,95+altitud,todoconimpuestosf);
	 	
	 	
    			 * 
    			 */
    			
    			
    			
    			
   		}catch(Exception e){		
   			System.out.println("Ocurrió un error");
   		}
			   
			   
//////////////////db2///////////////////////
			   
			   
			   
			   
			   
			   
			   
			   
			   
			 
			   
			   
			 

			   createHeadingstotalesl(cb,420,275,"SUBTOTAL 12%");
			   createHeadingstotalesl(cb,420,255,"SUBTOTAL 0%");
			   createHeadingstotalesl(cb,420,235,"SUBTOTAL NO OBJETO DE IVA");
			   createHeadingstotalesl(cb,420,215,"SUBTOTAL EXENTO DE IVA");
			   createHeadingstotalesl(cb,420,195,"SUBTOTAL SIN IMPUESTOS");
			   createHeadingstotalesl(cb,420,175,"TOTAL DESCUENTO");
			   createHeadingstotalesl(cb,420,155,"ICE");
			   createHeadingstotalesl(cb,420,135,"IVA 12%");
			   createHeadingstotalesl(cb,420,115,"IRBPNR");
			   createHeadingstotalesl(cb,420,95,"PROPINA");
			   createHeadingstotalesl(cb,420,75,"VALOR TOTAL");
			   
			   
			   
			
			   
			   
			   
			   
			   
			   
			   
		   
		   
		   
		   cb.stroke();
		   }
		   
		   
		   
		   
			 
		   // Invoice Detail box Text Headings 
		   
		   createHeadings(cb,22,742,"Cod.");
		   createHeadings(cb,22,735,"Principal");
		   createHeadings(cb,60,742,"Cod.");
		   createHeadings(cb,60,735,"Auxiliar");
		   createHeadings(cb,90,735,"Cantidad");
		   createHeadings(cb,200,735,"Descripción");
		   createHeadings(cb,400,742,"Detalle");
		   createHeadings(cb,400,735,"Adicional");
		   createHeadings(cb,440,742,"Precio");
		   createHeadings(cb,440,735,"Unitario");
		   createHeadings(cb,470,735,"Subsidio");
		   createHeadings(cb,500,742,"Precio");
		   createHeadings(cb,500,735,"sin Subsidio");
		   createHeadings(cb,540,735,"Descuento");
		   createHeadings(cb,580,742,"Precio");
		   createHeadings(cb,580,735,"Total");
		   
		   
		   
		   
		   
 
		  
		  
	  }
  

	  
 
  }
  
  
  
 
  catch (DocumentException dex){
   dex.printStackTrace();
  }
  catch (Exception ex){
   ex.printStackTrace();
  }
	 
 }
  
 private void generateHeader(Document doc, PdfContentByte cb)  {
 
  try {
 
	  createHeadings(cb,60,580,"ROBERTO ENRIQUE MATAMORO BAJANA");
	  createHeadings(cb,60,550,"ROBERTO ENRIQUE MATAMORO BAJANA");
   createHeadings(cb,60,520,"5 DE JUNIO 420 Y 9 DE OCTUBRE");
   createHeadings(cb,60,490,"OBLIGADO A LLEVAR CONTABILIDAD:  NO");
   
   
   String RucComprador = "";
   String RazonSocialComprador = "";
   String DireccionComprador = "";
   String TelefonoComprador = "";
   String EmailComprador = "";
   String clavedeacceso = "";
   
	
   Conexion c = new Conexion();
	  
	 
	String z="TODOS";
	String xx=null;
	//ArrayList<Usuario> = consultarusuarios.(z, x);
	try{ 
		
	
	c.conectar();
	 ArrayList<Clientes> Clientes = c.DatosClientes(clavedeacceso);

				
		
		
		for(int i1=0;i1<Clientes.size();i1++){
			Clientes p = Clientes.get(i1);
         Vector registro = new Vector();

         RucComprador = (p.getRucComprador());
         RazonSocialComprador = (p.getRazonSocialComprador());
         DireccionComprador = (p.getDireccionComprador());
         TelefonoComprador = (p.getTelefonoComprador());
         EmailComprador = (p.getEmailComprador());
         clavedeacceso = (p.getclavedeacceso());
         
         
        // System.out.println(clavedeacceso);
         
     
		
        
       
       
 
		}
	}catch(Exception e){		
		System.out.println("Ocurrió un error");
	}
	
	
	createHeadings(cb,20,430,"Razón Social / Nombres");
	
	createHeadings(cb,150,430,RazonSocialComprador);
	   
	createHeadings(cb,20,415,"Identificación");
	
	createHeadings(cb,150,415,RucComprador);
	
	
	   
	createHeadings(cb,20,400,"Fecha");
	
	
	String secuencia = clavedeacceso.substring(30, 39);
	String a = clavedeacceso.substring(4, 8);
	String m = clavedeacceso.substring(2, 4);
	String d = clavedeacceso.substring(0, 2);
	
	createHeadings(cb,150,400,d+"/"+m+"/"+a);
	   
	createHeadings(cb,20,385,"Direccion:");
	
	createHeadings(cb,150,385,DireccionComprador);
    
   
   
   cb.setFontAndSize(bfBold, 8);
  // createHeadings(cb,60,705,"City, State - ZipCode");
  // createHeadings(cb,60,690,"Country");
    
  // createHeadings(cb,482,743,"ABC0001");
 //  createHeadings(cb,482,723,"123456");
  // createHeadings(cb,482,703,"09/26/2012");
 
  }
 
  catch (Exception ex){
   ex.printStackTrace();
  }
 
 }
  
 private void generateDetail(Document doc, PdfContentByte cb, int index, int y)  {
  DecimalFormat df = new DecimalFormat("0.00");
   
  int escapador = 0;
  
  
  try {
 

   
   
   String price = null;
   
   
   
   
   
   
   ///////////////////////
   

   String RucComprador = "";
      String RazonSocialComprador = "";
      String DireccionComprador = "";
      String TelefonoComprador = "";
      String EmailComprador = "";
      String clavedeacceso = "";


      
      
      
      
      
      
      
      
Conexion c = new Conexion();
  
 
String z="TODOS";
String xx=null;
//ArrayList<Usuario> = consultarusuarios.(z, x);
try{ 
	

c.conectar();
 ArrayList<Clientes> Clientes = c.DatosClientes(clavedeacceso);

			
	
	
	for(int i=0;i<Clientes.size();i++){
		Clientes p = Clientes.get(i);
      Vector registro = new Vector();

      RucComprador = (p.getRucComprador());
      RazonSocialComprador = (p.getRazonSocialComprador());
      DireccionComprador = (p.getDireccionComprador());
      TelefonoComprador = (p.getTelefonoComprador());
      EmailComprador = (p.getEmailComprador());
      clavedeacceso = (p.getclavedeacceso());
      
      
      
      
  
	
     
    
    

	}
}catch(Exception e){		
	System.out.println("Ocurrió un error");
}






















int bandera = 0 ;

   
   
   
   
 
   
   
   
   Conexion rx = new Conexion();
	  
		double dpvpx = 0;
	double pvp12 = 0;
	double pvp0 = 0;
	double sumadescuentos = 0;
	 
	//ArrayList<Usuario> = consultarusuarios.(z, x);
	String tarifas = null;
	
	String exis12 = null;
	String exis0 = null;
	try{ 
		
		rx.conectar(); 
	 ArrayList<Facturas> Facturas = rx.DatosFactura(clavedeacceso);

	 
		
		
		for(int i=index;i<Facturas.size();i++){
			Facturas p = Facturas.get(i);
          
			
        String Nfactura = (p.getNfactura());
        String ClaveDeAcceso = (p.getClaveDeAcceso());
        String Cantidad = (p.getCantidad());
        String Detalle = (p.getDetalle());
        String CodigoProducto = (p.getCodigoProducto());
        String PrecioUnitario = (p.getPrecioUnitario());
        String Descuento = (p.getDescuento());
        String iva = (p.getiva());
        String xml = (p.getxml());
        
        int ivax = Integer.parseInt(iva);

        
        
        
        price = PrecioUnitario;
        
        
        
        
        double precio=Double.parseDouble(price);
        double PrecioUnitarios =Double.parseDouble(PrecioUnitario);
        
    	
    
    	   
    	   
      
        
       
        
        
        
        
        
        float xcantidad = Float.parseFloat(Cantidad);
        double dcantidad = Math.round(xcantidad * 100.0) / 100.0;
        
        float PrecioPVP = Float.parseFloat(PrecioUnitario);
        dpvpx = Math.round(PrecioPVP * 100.0) / 100.0;
        
        
        
        float descuentos = Float.parseFloat(Descuento);
        double ddescuento = Math.round(descuentos * 100.0) / 100.0;
        
        
        ddescuento = (dpvpx - ddescuento )*dcantidad;
        ddescuento = Math.round(ddescuento * 100.0) / 100.0;
        
        dpvpx = (dpvpx*dcantidad)-ddescuento ;
        
        
        
        sumadescuentos = sumadescuentos+ddescuento;
        
        
        
  if(escapador < 1) {
        	
        	escapador = escapador + 1;
        	 
        	 
        	 createContent(cb,122,y, Detalle ,PdfContentByte.ALIGN_LEFT);
        	 
        	 
        	 
        	 double multitotal = precio * PrecioUnitarios;
       	   
       	   double extPrice = precio * (index+1) ;
       	   createContent(cb,465,y, df.format(precio),PdfContentByte.ALIGN_RIGHT);
       	   createContent(cb,495,y, "0.00",PdfContentByte.ALIGN_RIGHT);
       	   createContent(cb,535,y, "0.00",PdfContentByte.ALIGN_RIGHT);
       	   createContent(cb,570,y, df.format(ddescuento),PdfContentByte.ALIGN_RIGHT);
       	   createContent(cb,605,y, df.format(dpvpx),PdfContentByte.ALIGN_RIGHT);
       	   createContent(cb,55,y,CodigoProducto,PdfContentByte.ALIGN_RIGHT);
       	   createContent(cb,110,y, Cantidad,PdfContentByte.ALIGN_LEFT);
        	 
        	 
        }
        
        
        
        
    	
        
        
        
        
        
        
        
        
        if(ivax==1) {
       	 iva="2";
       	  tarifas = "12";
       	  exis12 = "SI";
       	  
       	  
       	  pvp12 = pvp12+dpvpx;
       	  
       	  
       	  pvp12 = Math.round(pvp12 * 100.0) / 100.0;
       	  
       	  
        }
        if(ivax==6) {
       	 iva="0";
       	  tarifas = "0";
       	  exis0 = "SI";
       	
       	  pvp0 = pvp0+dpvpx;
       	  pvp0 = Math.round(pvp0 * 100.0) / 100.0;
       	  
       	
       	  
        }
        
         
        
        
        
        
        
        
        
        
      //  dpvp = Math.round(dpvp * 100.0) / 100.0;
        
        
        
        
      //  String DescuentoPorItem = Double.toString(ddescuento);
       // String preciodescontados2 = Double.toString(dpvp);
        
        
        

       
      //  System.out.println(Nfactura);
         
        
     
		
        
       
       
 
		}
	}catch(Exception e){		
		System.out.println("Ocurrió un error");
	}
		
		
	double sumasinimpuestos = pvp12 + pvp0;
	
	
	String totaldescuentos = Double.toString(sumadescuentos);
	
	double ivadebaseimponiblex = pvp12 * 0.12;
	
	ivadebaseimponiblex = Math.round(ivadebaseimponiblex * 100.0) / 100.0;
	
	
	double todoconimpuestos = ivadebaseimponiblex + pvp12 + pvp0;
	
	todoconimpuestos = Math.round(todoconimpuestos * 100.0) / 100.0;
	
	String todoconimpuestosf = Double.toString(todoconimpuestos);
	
	
	
	
	String base12 = Double.toString(pvp12);
	String base0 = Double.toString(pvp0);
	
	
	String totalsinimpuestos = Double.toString(sumasinimpuestos);
	
	String ivadebaseimponible = Double.toString(ivadebaseimponiblex);
		
		
   
	if(index < 1) {
	System.out.println(base12);
	System.out.println(base0);
	}
   
   
   
   
    
  }
 
  catch (Exception ex){
   ex.printStackTrace();
  }
 
 }
 ///////////////////////
 
 
 private void generateDetail2(Document doc, PdfContentByte cb, int index, int xy)  {
	  DecimalFormat df = new DecimalFormat("0.00");
	   int escapador = 0;
	  try {
	 
		  
		  
		  
		  
		  
		  
		  /////////////////////////////DB2///////////////////
		  

		   
		   String price = null;
		   
		   
		   
		   
		   
		   
		   ///////////////////////
		   

		   String RucComprador = "";
		      String RazonSocialComprador = "";
		      String DireccionComprador = "";
		      String TelefonoComprador = "";
		      String EmailComprador = "";
		      String clavedeacceso = "";


		      
		      
		      
		      
		      
		      
		      
		      
		Conexion c = new Conexion();
		  
		 
		String z="TODOS";
		String xx=null;
		//ArrayList<Usuario> = consultarusuarios.(z, x);
		try{ 
			

		c.conectar();
		 ArrayList<Clientes> Clientes = c.DatosClientes(clavedeacceso);

					
			
			
			for(int i=0;i<Clientes.size();i++){
				Clientes p = Clientes.get(i);
		      Vector registro = new Vector();

		      RucComprador = (p.getRucComprador());
		      RazonSocialComprador = (p.getRazonSocialComprador());
		      DireccionComprador = (p.getDireccionComprador());
		      TelefonoComprador = (p.getTelefonoComprador());
		      EmailComprador = (p.getEmailComprador());
		      clavedeacceso = (p.getclavedeacceso());
		      
		      
		      
		      
		  
			
		     
		    
		    

			}
		}catch(Exception e){		
			System.out.println("Ocurrió un error");
		}






















		int bandera = 0 ;

		   
		   
		   
		   
		 
		   
		   
		   
		   Conexion rx = new Conexion();
			  
				double dpvpx = 0;
			double pvp12 = 0;
			double pvp0 = 0;
			double sumadescuentos = 0;
			 
			//ArrayList<Usuario> = consultarusuarios.(z, x);
			String tarifas = null;
			
			String exis12 = null;
			String exis0 = null;
			try{ 
				
				rx.conectar(); 
			 ArrayList<Facturas> Facturas = rx.DatosFactura(clavedeacceso);

			 
				
				
				for(int i=index;i<Facturas.size();i++){
					Facturas p = Facturas.get(i);
		          
					
		        String Nfactura = (p.getNfactura());
		        String ClaveDeAcceso = (p.getClaveDeAcceso());
		        String Cantidad = (p.getCantidad());
		        String Detalle = (p.getDetalle());
		        String CodigoProducto = (p.getCodigoProducto());
		        String PrecioUnitario = (p.getPrecioUnitario());
		        String Descuento = (p.getDescuento());
		        String iva = (p.getiva());
		        String xml = (p.getxml());
		        
		        int ivax = Integer.parseInt(iva);

		        
		        
		        
		        price = PrecioUnitario;
		        
		        
		        
		        
		        double precio=Double.parseDouble(price);
		        double PrecioUnitarios =Double.parseDouble(PrecioUnitario);
		        
		    	
		    
		    	   
		    	   
		      
		        
		       
		        
		        
		        
		        
		        
		        float xcantidad = Float.parseFloat(Cantidad);
		        double dcantidad = Math.round(xcantidad * 100.0) / 100.0;
		        
		        float PrecioPVP = Float.parseFloat(PrecioUnitario);
		        dpvpx = Math.round(PrecioPVP * 100.0) / 100.0;
		        
		        
		        
		        float descuentos = Float.parseFloat(Descuento);
		        double ddescuento = Math.round(descuentos * 100.0) / 100.0;
		        
		        
		        ddescuento = (dpvpx - ddescuento )*dcantidad;
		        ddescuento = Math.round(ddescuento * 100.0) / 100.0;
		        
		        dpvpx = (dpvpx*dcantidad)-ddescuento ;
		        
		        
		        
		        sumadescuentos = sumadescuentos+ddescuento;
		        
		        
		        
		  if(escapador < 1) {
		        	
		        	escapador = escapador + 1;
		        	 
		        	 
		      /*  	 createContent(cb,122,y, Detalle ,PdfContentByte.ALIGN_LEFT);
		        	 
		        	 
		        	 
		        	 double multitotal = precio * PrecioUnitarios;
		       	   
		       	   double extPrice = precio * (index+1) ;
		       	   createContent(cb,465,y, df.format(precio),PdfContentByte.ALIGN_RIGHT);
		       	   createContent(cb,495,y, "0.00",PdfContentByte.ALIGN_RIGHT);
		       	   createContent(cb,535,y, "0.00",PdfContentByte.ALIGN_RIGHT);
		       	   createContent(cb,570,y, df.format(ddescuento),PdfContentByte.ALIGN_RIGHT);
		       	   createContent(cb,605,y, df.format(dpvpx),PdfContentByte.ALIGN_RIGHT);
		       	   createContent(cb,45,y,CodigoProducto,PdfContentByte.ALIGN_RIGHT);
		       	   createContent(cb,110,y, Cantidad,PdfContentByte.ALIGN_LEFT);
		       	   
		       	  */ 
		       	   
		       	   
		       	  createContent(cb,55,xy,CodigoProducto,PdfContentByte.ALIGN_RIGHT);
		   	   createContent(cb,90,xy, Cantidad,PdfContentByte.ALIGN_LEFT);
		   	   createContent(cb,122,xy,Detalle,PdfContentByte.ALIGN_LEFT);
		   	    
		       	   
		       	   
		       	   
		       	   
				//   double extPrice = price * (index+1) ;
			   createContent(cb,465,xy, df.format(precio),PdfContentByte.ALIGN_RIGHT);
			   createContent(cb,495,xy, "0.00",PdfContentByte.ALIGN_RIGHT);
			   createContent(cb,535,xy, df.format(precio),PdfContentByte.ALIGN_RIGHT);
			   createContent(cb,570,xy, df.format(ddescuento),PdfContentByte.ALIGN_RIGHT);
			   createContent(cb,605,xy, df.format(dpvpx),PdfContentByte.ALIGN_RIGHT);
		   	   
		   	   
		   	   
		       	   
		        	 
		        	 
		        }
		        
		        
		        
		        
		    	
		        
		        
		        
		        
		        
		        
		        
		        
		        if(ivax==1) {
		       	 iva="2";
		       	  tarifas = "12";
		       	  exis12 = "SI";
		       	  
		       	  
		       	  pvp12 = pvp12+dpvpx;
		       	  
		       	  
		       	  pvp12 = Math.round(pvp12 * 100.0) / 100.0;
		       	  
		       	  
		        }
		        if(ivax==6) {
		       	 iva="0";
		       	  tarifas = "0";
		       	  exis0 = "SI";
		       	
		       	  pvp0 = pvp0+dpvpx;
		       	  pvp0 = Math.round(pvp0 * 100.0) / 100.0;
		       	  
		       	
		       	  
		        }
		        
		         
		        
		        
		        
		        
		        
		        
		        
		        
		      //  dpvp = Math.round(dpvp * 100.0) / 100.0;
		        
		        
		        
		        
		      //  String DescuentoPorItem = Double.toString(ddescuento);
		       // String preciodescontados2 = Double.toString(dpvp);
		        
		        
		        

		       
		      //  System.out.println(Nfactura);
		         
		        
		     
				
		        
		       
		       
		 
				}
			}catch(Exception e){		
				System.out.println("Ocurrió un error");
			}
				
				
			double sumasinimpuestos = pvp12 + pvp0;
			
			
			String totaldescuentos = Double.toString(sumadescuentos);
			
			double ivadebaseimponiblex = pvp12 * 0.12;
			
			ivadebaseimponiblex = Math.round(ivadebaseimponiblex * 100.0) / 100.0;
			
			
			double todoconimpuestos = ivadebaseimponiblex + pvp12 + pvp0;
			
			todoconimpuestos = Math.round(todoconimpuestos * 100.0) / 100.0;
			
			String todoconimpuestosf = Double.toString(todoconimpuestos);
			
			
			
			
			String base12 = Double.toString(pvp12);
			String base0 = Double.toString(pvp0);
			
			
			String totalsinimpuestos = Double.toString(sumasinimpuestos);
			
			String ivadebaseimponible = Double.toString(ivadebaseimponiblex);
				
				
		   
			if(index < 1) {
			System.out.println(base12);
			System.out.println(base0);
			}
		   
		   
		   
		   
		  
		  //////////////DB2/////////////////
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
		  
	 
	  // double price = 116455.66;
	
	
	   
	   
	   
	   
	   
	   
	   
	    
	  }
	 
	  catch (Exception ex){
	   ex.printStackTrace();
	  }
	 
	 }
 
 
 
 
 
 /*private void createHeadingsbarcode(PdfContentByte cb, float x, float y, image text){
	 
	 
	  cb.beginText();
	  cb.setFontAndSize(bf, 7);
	  cb.setTextMatrix(x,y);
	  cb.showText(text.trim());
	  cb.endText(); 
	 
	 }*/
	 
 
 
 
 
 
 
 
 
 private void createHeadings(PdfContentByte cb, float x, float y, String text){
 
 
  cb.beginText();
  cb.setFontAndSize(bf, 7);
  cb.setTextMatrix(x,y);
  cb.showText(text.trim());
  cb.endText(); 
 
 }
 
 
 private void createHeadingstotales(PdfContentByte cb, float x, float y, String text){
	 
	 
	  cb.beginText();
	  
	  cb.setFontAndSize(bf, 7);
	  cb.setTextMatrix(x,y);
	  
	  
	  cb.showTextAligned(cb.ALIGN_RIGHT, text, x , y, 0);
	   
	//  cb.showText(text.trim());
	  cb.endText(); 
	 
	 }
 
 
 
 private void createHeadingstotalesl(PdfContentByte cb, float x, float y, String text){
	 
	 
	  cb.beginText();
	  
	  cb.setFontAndSize(bf, 7);
	  cb.setTextMatrix(x,y);
	  
	  
	  cb.showTextAligned(cb.ALIGN_LEFT, text, x , y, 0);
	   
	//  cb.showText(text.trim());
	  cb.endText(); 
	 
	 }
 
 
  
 private void printPageNumber(PdfContentByte cb){
 
 
  cb.beginText();
  cb.setFontAndSize(bfBold, 8);
  cb.showTextAligned(PdfContentByte.ALIGN_RIGHT, "PAGINA " + (pageNumber+1), 570 , 25, 0);
  cb.endText(); 
   
  pageNumber++;
   
 }
  
 private void createContent(PdfContentByte cb, float x, float y, String text, int align){
 
 
  cb.beginText();
  cb.setFontAndSize(bf, 5);
  cb.showTextAligned(align, text.trim(), x , y, 0);
  cb.endText(); 
 
 }
 
 private void initializeFonts(){
 
 
  try {
   bfBold = BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
   bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
 
  } catch (DocumentException e) {
   e.printStackTrace();
  } catch (IOException e) {
   e.printStackTrace();
  }
 
 
 }
 
}