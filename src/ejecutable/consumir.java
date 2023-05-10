package ejecutable;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.net.*;
import java.io.*;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import java.net.InetSocketAddress;
import java.util.ArrayList;

import javax.xml.bind.DatatypeConverter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;


import org.w3c.dom.NodeList;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Vector;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import bd.Conexion;
import entidades.Clientes;
import entidades.Facturas;
import sri.webservice;

import java.util.*;  
import javax.mail.*;  
import javax.mail.internet.*;  
import javax.activation.*; 


import org.w3c.dom.NodeList;




public class consumir {
 
 private BaseFont bfBold;
 private BaseFont bf;
 private int pageNumber = 0;
 
 
 
 public static void main(String[] args) throws SAXException, ParserConfigurationException, IOException {
 
	 
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
	ArrayList<Clientes> Clientes = ini1.SubirXml(clavedeacceso);

				
		
		
		for(int i=0;i<Clientes.size();i++){
			Clientes p = Clientes.get(i);
	   Vector registro = new Vector();

	   RucComprador = (p.getRucComprador());
	   RazonSocialComprador = (p.getRazonSocialComprador());
	   DireccionComprador = (p.getDireccionComprador());
	   TelefonoComprador = (p.getTelefonoComprador());
	   EmailComprador = (p.getEmailComprador());
	   clavedeacceso = (p.getclavedeacceso());
	   
	   
	   
	  
		System.out.println(clavedeacceso);
	  
	 
	 

		}
	}catch(Exception e){		
		System.out.println("Ocurrió un error2");
	}




	///////////////WEBSERVICE
	
	
	
	  sendPostSoap(null, null, null, null, null, clavedeacceso);
	  
	  
	
 }
 

 public static Document getDoc(String dir) throws SAXException, ParserConfigurationException, IOException{
 
	 System.out.println(dir);
    File fXmlFile = new File(dir);	
    
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
Document doc = dBuilder.parse(fXmlFile);
System.out.println(doc);
   return doc;
}




public static String convertDocumentToString(Document doc) {
TransformerFactory tf = TransformerFactory.newInstance();
Transformer transformer;
try {
    transformer = tf.newTransformer();
    // below code to remove XML declaration
    // transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
    StringWriter writer = new StringWriter();
    transformer.transform(new DOMSource(doc), new StreamResult(writer));
    String output = writer.getBuffer().toString();
    return output;
} catch (TransformerException e) {
    e.printStackTrace();
}
 
return null;
}






public static Document convertStringToDocument(String xmlStr) {
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
DocumentBuilder builder;  
try 
{  
    builder = factory.newDocumentBuilder();  
    Document doc = builder.parse( new InputSource( new StringReader( xmlStr ) ) ); 
    return doc;
} catch (Exception e) {  
    e.printStackTrace();  
} 
return null;
}










///////2


public static String converBase64(Document doc) throws SAXException, ParserConfigurationException, IOException{
  
 
 String str = convertDocumentToString(doc);
         
    String bytesEncoded = DatatypeConverter.printBase64Binary(str.getBytes("UTF-8"));
    
    System.out.println(bytesEncoded);
    
    return bytesEncoded;
  }




public static String getNodes(String rootNodo, String infoNodo, Document doc){

  String resultNodo = null;          
  Element docEle = doc.getDocumentElement();
            
    NodeList studentList = docEle.getElementsByTagName(rootNodo);
    
    if(studentList.getLength()>0){
        Node node = studentList.item(0);            
      if (node.getNodeType() == Node.ELEMENT_NODE) {
             Element e = (Element) node;
             NodeList nodeList = e.getElementsByTagName(infoNodo);
             resultNodo = nodeList.item(0).getChildNodes().item(0).getNodeValue();
        }}
        return resultNodo;
    }








public String getLastNode(String pathLevelXML, String nodo, Document doc) throws XPathExpressionException{

    //Ejemplo: //RespuestaAutorizacionComprobante/autorizaciones/autorizacion[last()]/estado
    String pathFull = pathLevelXML + nodo;
    
    XPath xpath = XPathFactory.newInstance().newXPath();
              
    return xpath.evaluate(pathFull, doc);
    
}



public java.net.Proxy setProxy(String ip, int port){

    java.net.Proxy proxy = new java.net.Proxy(java.net.Proxy.Type.HTTP, new InetSocketAddress(ip, port));

    return proxy;

}


///3

public static String formatSendPost(String bytesEncodeBase64) throws SAXException, ParserConfigurationException, IOException{
 //System.out.println(bytesEncodeBase64);
 bytesEncodeBase64 = converBase64(getDoc(bytesEncodeBase64));
 
    String xml = "<soapenv:Envelope xmlns:soapenv='http://schemas.xmlsoap.org/soap/envelope/' xmlns:ec='http://ec.gob.sri.ws.recepcion'>"+
"<soapenv:Header/>"+
"<soapenv:Body>"+
  "<ec:validarComprobante>"+
     "<xml>"+bytesEncodeBase64+"</xml>"+
  "</ec:validarComprobante>"+
"</soapenv:Body>"+
"</soapenv:Envelope>";
    
    
    System.out.println(xml);
    
    
    return xml;
}







public static void getEstadoPostSoap(Document doc, String nodoRaiz, String nodoElemento){
    
    String estado = getNodes(nodoRaiz, nodoElemento, doc );
    
    if(estado.equals("DEVUELTA")){
                 
       System.out.println("Clave de Accceso: " + getNodes("comprobante","claveAcceso", doc));
       System.out.println("Identificador Error: " + getNodes("mensaje","identificador", doc));
       System.out.println("Descripción Error: " + getNodes("mensaje","mensaje", doc));
       System.out.println("Descripción Adicional Error: " + getNodes("mensaje","informacionAdicional", doc));
       System.out.println("Tipo mensaje: " + getNodes("mensaje","tipo", doc));
     
       
       System.out.println("NORECIBIDA");
      
    }else if(estado.equals("RECIBIDA")){
    	
    	
    	
    	
    	
    	
    	String RucComprador = "";
 	   String RazonSocialComprador = "";
 	   String DireccionComprador = "";
 	   String TelefonoComprador = "";
 	   String EmailComprador = "";
 	   String clavedeacceso = "";


 	   
 	   
 	   
 	   
 	   
 	   
 	   
 	   
 	Conexion ini2 = new Conexion();


 	String z="TODOS";
 	String xx=null;
 	//ArrayList<Usuario> = consultarusuarios.(z, x);
 	try{ 
 		

 	ini2.conectar();
 	ArrayList<Clientes> Clientes = ini2.SubirXml(clavedeacceso);

 				
 		
 		
 		for(int i=0;i<Clientes.size();i++){
 			Clientes p = Clientes.get(i);
 	   Vector registro = new Vector();

 	   RucComprador = (p.getRucComprador());
 	   RazonSocialComprador = (p.getRazonSocialComprador());
 	   DireccionComprador = (p.getDireccionComprador());
 	   TelefonoComprador = (p.getTelefonoComprador());
 	   EmailComprador = (p.getEmailComprador());
 	   clavedeacceso = (p.getclavedeacceso());
 	   
 	   
 	   
 	  
 		System.out.println(clavedeacceso);
 	  
 	 
 	 

 		}
 	}catch(Exception e){		
 		System.out.println("Ocurrió un error2");
 	}
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	

    
    Conexion tt = new Conexion();
	  
		  
	try{ 
		
	
	tt.conectar();
	if(tt.xmlAutorizado(clavedeacceso)) {
		System.out.println("FACTURAS ACTUALIZADAS");
		
	}

				
		 
	}catch(Exception e){		
		System.out.println("Ocurrió un error");
	}
	
		


    	
    	
    	
    	
    	
        System.out.println("RECIBIDA");
        
                 
      }
    
}









public static boolean sendPostSoap(String urlWebServices, String method, String host, String getEncodeXML, Proxy proxy, String clavedeacceso) throws SAXException, ParserConfigurationException, IOException{
 
 
 urlWebServices = "https://cel.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantesOffline?wsdl";
 method = "POST";
 host = "celcer.sri.gob.ec";
 getEncodeXML = formatSendPost("C:/xml/firmadas/"+clavedeacceso+".XML");
 proxy = null;
 
   try {
        
    URL oURL = new URL(urlWebServices);
    
    HttpURLConnection con = (HttpURLConnection) oURL.openConnection(Proxy.NO_PROXY);
    con.setDoOutput(true);
    
    con.setRequestMethod(method);
    
    
    
    con.setRequestProperty("Content-type", "text/xml; charset=utf-8");
    con.setRequestProperty("SOAPAction", "");
    con.setRequestProperty("Host", host);    
    
   
    
    OutputStream reqStreamOut = con.getOutputStream();
    
    System.out.println(con);
    
    reqStreamOut.write(getEncodeXML.getBytes());
    
    System.out.println("----------");
                                   
   
     java.io.BufferedReader rd = new java.io.BufferedReader(new java.io.InputStreamReader(con.getInputStream(), "UTF8"));
            
            String line = "";
	StringBuilder sb = new StringBuilder();
          
      while ((line = rd.readLine()) != null) 
            sb.append(line);
       
      getEstadoPostSoap(convertStringToDocument(sb.toString()),
                        "RespuestaRecepcionComprobante",
                        "estado");//está extrae la data de los nodos en un archivo XML

    con.disconnect();
      
    return true;

    }catch (Exception ex) {
      System.out.println(ex.getMessage());
}
    return false;
} 









}