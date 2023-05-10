 


package ejecutable;
import java.io.FileOutputStream;

import entidades.Clientes;
import entidades.Facturas;
import entidades.Residente;
import formularios.Frmliqui;
import sri.XAdESBESSignature;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.*;
import java.awt.BorderLayout;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.itextpdf.text.pdf.BaseFont;

import bd.Conexion;
import ejecutable.*;

import java.io.File;


/**
 *
 * @author German17
 */
public class iniciador {


	 
    public static void main(String[] args) {

    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
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
    	
    	
    	
    	
       
          
          
          
          try {
        	  
      		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
      		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
       
      		// elemento raiz
      		Document doc = docBuilder.newDocument();
      		doc.setXmlStandalone(true);
      		
      		
      		
      		
      		
      		
      		Element rootElement = doc.createElement("factura");
      		doc.appendChild(rootElement);
      		System.out.println(rootElement);
      		
      		
    		
      		
      		
      		
      		
    		
      		Attr attr2 = doc.createAttribute("version");
      		
    		attr2.setValue("1.0.0");
    		rootElement.setAttributeNode(attr2);
      		
      		
    		Attr x = doc.createAttribute("id");
    		x.setValue("comprobante");
    		rootElement.setAttributeNode(x);
      		
    		
      		
      		
       
      		// infoTributaria
      		Element infoTributaria = doc.createElement("infoTributaria");
      		rootElement.appendChild(infoTributaria);
       
      		// atributo del elemento infoTributaria
      		
      		
      		
      		
      		
       
      		// nombre
      		Element ambiente = doc.createElement("ambiente");
      		ambiente.appendChild(doc.createTextNode("2"));
      		infoTributaria.appendChild(ambiente);
       
      		// apellidos
      		Element tipoEmision = doc.createElement("tipoEmision");
      		tipoEmision.appendChild(doc.createTextNode("1"));
      		infoTributaria.appendChild(tipoEmision);
       
      		// seccion
      		
      		
      		
      		
      		 
      		
      		
      		
      		
      		
      		
      		Element razonSocial = doc.createElement("razonSocial");
      		razonSocial.appendChild(doc.createTextNode("ROBERTO ENRIQUE MATAMORO BAJANA"));
      		infoTributaria.appendChild(razonSocial);
       
      		// salario
      		Element nombreComercial = doc.createElement("nombreComercial");
      		nombreComercial.appendChild(doc.createTextNode("ROBERTO ENRIQUE MATAMORO BAJANA"));
      		infoTributaria.appendChild(nombreComercial);
      		
      		
      		
      		Element ruc = doc.createElement("ruc");
      		ruc.appendChild(doc.createTextNode("0912077864001"));
      		infoTributaria.appendChild(ruc);
      		
      		
      		Element claveAcceso = doc.createElement("claveAcceso");
      		claveAcceso.appendChild(doc.createTextNode(clavedeacceso));
      		infoTributaria.appendChild(claveAcceso);
      		
      		
      		
      		Element codDoc = doc.createElement("codDoc");
      		codDoc.appendChild(doc.createTextNode("01"));
      		infoTributaria.appendChild(codDoc);
      		
      		
      		
      		Element estab = doc.createElement("estab");
      		estab.appendChild(doc.createTextNode("001"));
      		infoTributaria.appendChild(estab);
      		
      		
      		
      		Element ptoEmi = doc.createElement("ptoEmi");
      		ptoEmi.appendChild(doc.createTextNode("001"));
      		infoTributaria.appendChild(ptoEmi);
      		
      		
      		 
      		String secuencia = clavedeacceso.substring(30, 39);
      		String a = clavedeacceso.substring(4, 8);
      		String m = clavedeacceso.substring(2, 4);
      		String d = clavedeacceso.substring(0, 2);
      		 
      		
      		 
      		
      		Element secuencial = doc.createElement("secuencial");
      		secuencial.appendChild(doc.createTextNode(secuencia));
      		infoTributaria.appendChild(secuencial);
      		
      		
      		
      		
      		
      		Element dirMatriz = doc.createElement("dirMatriz");
      		dirMatriz.appendChild(doc.createTextNode("coop santiaguito de roldos MZ1149"));
      		infoTributaria.appendChild(dirMatriz);
      		
      		
      		 
      		Element infoFactura = doc.createElement("infoFactura");
      		rootElement.appendChild(infoFactura);
      		
      		Element fechaEmision = doc.createElement("fechaEmision");
      		fechaEmision.appendChild(doc.createTextNode(d+"/"+m+"/"+a));
      		infoFactura.appendChild(fechaEmision);
      		
      		
      		Element dirEstablecimiento = doc.createElement("dirEstablecimiento");
      		dirEstablecimiento.appendChild(doc.createTextNode("coop santiaguito de roldos MZ1149"));
      		infoFactura.appendChild(dirEstablecimiento);
      		
      		
      		/*
      		Element contribuyenteEspecial = doc.createElement("contribuyenteEspecial");
      		contribuyenteEspecial.appendChild(doc.createTextNode("contribuyente"));
      		infoFactura.appendChild(contribuyenteEspecial);
      		
      		*/
      		
      		Element obligadoContabilidad = doc.createElement("obligadoContabilidad");
      		obligadoContabilidad.appendChild(doc.createTextNode("NO"));
      		infoFactura.appendChild(obligadoContabilidad);
      		
      		
      		
      		Element tipoIdentificacionComprador = doc.createElement("tipoIdentificacionComprador");
      		
      		
      		
      		int count = 0;    
            
            //Counts each character except space    
            for(int i = 0; i < RucComprador.length(); i++) {    
                if(RucComprador.charAt(i) != ' ')    
                    count++;    
            }   
      		
      		
      		if(count==13) {
      		tipoIdentificacionComprador.appendChild(doc.createTextNode("04"));
      		System.out.println("RUC");
      		}
      		if(count==10) {
      			tipoIdentificacionComprador.appendChild(doc.createTextNode("05"));
      		}
      		
      		
      		
      		
      		infoFactura.appendChild(tipoIdentificacionComprador);
      		
      		
      		
      		Element razonSocialComprador = doc.createElement("razonSocialComprador");
      		razonSocialComprador.appendChild(doc.createTextNode(RazonSocialComprador));
      		infoFactura.appendChild(razonSocialComprador);
      		
      		
      		
      		
      		
      		Element identificacionComprador = doc.createElement("identificacionComprador");
      		identificacionComprador.appendChild(doc.createTextNode(RucComprador));
      		infoFactura.appendChild(identificacionComprador);
      		
      		
      		
      		Element direccionComprador = doc.createElement("direccionComprador");
      		direccionComprador.appendChild(doc.createTextNode(DireccionComprador));
      		infoFactura.appendChild(direccionComprador);
      		
      		
      		
      		
      		
      		
      		
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

    		 
    			
    			
    			for(int i=0;i<Facturas.size();i++){
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
      		
      		
    		 
      		
      		
      		Element totalSinImpuestos = doc.createElement("totalSinImpuestos");
      		totalSinImpuestos.appendChild(doc.createTextNode(totalsinimpuestos));
      		infoFactura.appendChild(totalSinImpuestos);
      		
      		
      		
      		Element totalDescuento = doc.createElement("totalDescuento");
      		totalDescuento.appendChild(doc.createTextNode(totaldescuentos));
      		infoFactura.appendChild(totalDescuento);
      		
      		
      		/*
      		Element codDocReembolso = doc.createElement("codDocReembolso");
      		codDocReembolso.appendChild(doc.createTextNode("00"));
      		infoFactura.appendChild(codDocReembolso);
      		
      		
      		
      		Element totalComprobantesReembolso = doc.createElement("totalComprobantesReembolso");
      		totalComprobantesReembolso.appendChild(doc.createTextNode("00.00"));
      		infoFactura.appendChild(totalComprobantesReembolso);
      		
      		
      		
      		Element totalBaseImponibleReembolso = doc.createElement("totalBaseImponibleReembolso");
      		totalBaseImponibleReembolso.appendChild(doc.createTextNode("00.00"));
      		infoFactura.appendChild(totalBaseImponibleReembolso);
      		
      		
      		
      		Element totalImpuestoReembolso = doc.createElement("totalImpuestoReembolso");
      		totalImpuestoReembolso.appendChild(doc.createTextNode("0.00"));
      		infoFactura.appendChild(totalImpuestoReembolso);
      		*/
      		
      		 
      		Element totalConImpuestos = doc.createElement("totalConImpuestos");
      		infoFactura.appendChild(totalConImpuestos);
      		
      		
      		
      		
      		
      		 if( exis12=="SI") {
      		
      		Element totalImpuesto = doc.createElement("totalImpuesto");
      		totalConImpuestos.appendChild(totalImpuesto);
      		 
      		 
      		
      		
      		
      		Element codigo = doc.createElement("codigo");
      		codigo.appendChild(doc.createTextNode("2"));
      		totalImpuesto.appendChild(codigo);
      		
      		
      		Element codigoPorcentaje = doc.createElement("codigoPorcentaje");
      		codigoPorcentaje.appendChild(doc.createTextNode("2"));
      		totalImpuesto.appendChild(codigoPorcentaje);
      		
      		/*
      		Element descuentoAdicional = doc.createElement("descuentoAdicional");
      		descuentoAdicional.appendChild(doc.createTextNode("0.00"));
      		totalImpuesto.appendChild(descuentoAdicional);
      		//variable
      		 * */
      		 
      		
      		Element baseImponible3 = doc.createElement("baseImponible");
      		baseImponible3.appendChild(doc.createTextNode(base12));
      		totalImpuesto.appendChild(baseImponible3);
      		
      		 
      		
      		
      		Element tarifa = doc.createElement("tarifa");
      		tarifa.appendChild(doc.createTextNode("12"));
      		totalImpuesto.appendChild(tarifa);
      		
      		
      		Element valor = doc.createElement("valor");
      		valor.appendChild(doc.createTextNode(ivadebaseimponible));
      		totalImpuesto.appendChild(valor);
      		
      		 }
      		////////////////////////////////////////
      		
      		
      		if(exis0=="SI") {
      		
      		
      		Element totalImpuesto2 = doc.createElement("totalImpuesto");
      		totalConImpuestos.appendChild(totalImpuesto2);
      		 
      		 
      		
      		
      		
      		Element codigo2 = doc.createElement("codigo");
      		codigo2.appendChild(doc.createTextNode("2"));
      		totalImpuesto2.appendChild(codigo2);
      		
      		
      		Element codigoPorcentaje2 = doc.createElement("codigoPorcentaje");
      		codigoPorcentaje2.appendChild(doc.createTextNode("0"));
      		totalImpuesto2.appendChild(codigoPorcentaje2);
      		
      		/*
      		Element descuentoAdicional = doc.createElement("descuentoAdicional");
      		descuentoAdicional.appendChild(doc.createTextNode("0.00"));
      		totalImpuesto.appendChild(descuentoAdicional);
      		//variable
      		 * */
      		 
      		
      		Element baseImponible32 = doc.createElement("baseImponible");
      		baseImponible32.appendChild(doc.createTextNode(base0));
      		totalImpuesto2.appendChild(baseImponible32);
      		
      		 
      		
      		
      		Element tarifa2 = doc.createElement("tarifa");
      		tarifa2.appendChild(doc.createTextNode("0"));
      		totalImpuesto2.appendChild(tarifa2);
      		
      		
      		Element valor2 = doc.createElement("valor");
      		valor2.appendChild(doc.createTextNode("0.00"));
      		totalImpuesto2.appendChild(valor2);
      		
      		
      		
      		
      		
      		
      		}
      		
      		/////////////////////////////////////////////
      		
      		
      		
      		
      		
      		
      		Element propina = doc.createElement("propina");
      		propina.appendChild(doc.createTextNode("0.00"));
      		infoFactura.appendChild(propina);
      		
      		Element importeTotal = doc.createElement("importeTotal");
      		importeTotal.appendChild(doc.createTextNode(todoconimpuestosf));
      		infoFactura.appendChild(importeTotal);
      		
      		
      		
      		
      		Element moneda = doc.createElement("moneda");
      		moneda.appendChild(doc.createTextNode("DOLAR"));
      		infoFactura.appendChild(moneda);
      		
      		
      		 
      		
      		Element pagos = doc.createElement("pagos");
      		infoFactura.appendChild(pagos);
      		
      		Element pago = doc.createElement("pago");
      		pagos.appendChild(pago);
      		 
      		
      		
      		Element formaPago = doc.createElement("formaPago");
      		formaPago.appendChild(doc.createTextNode("20"));
      		pago.appendChild(formaPago);
      		
      		Element total = doc.createElement("total");
      		total.appendChild(doc.createTextNode(todoconimpuestosf));
      		pago.appendChild(total);
      		
      		
      	/*	Element plazo = doc.createElement("plazo");
      		plazo.appendChild(doc.createTextNode("1"));
      		pago.appendChild(plazo);
      		
      		
      		Element unidadTiempo = doc.createElement("unidadTiempo");
      		unidadTiempo.appendChild(doc.createTextNode("Dias"));
      		pago.appendChild(unidadTiempo);
      		
      		*/
      		
      		
      		
      		Element detalles = doc.createElement("detalles");
      		rootElement.appendChild(detalles);
      		
      		
      		
      		/*
      		Element detalle = doc.createElement("detalle");
      		detalles.appendChild(detalle);
      		
      		
      		
      		
      		
      		
      		
      		
      		
      		
      		
      		Element codigoPrincipal = doc.createElement("codigoPrincipal");
      		codigoPrincipal.appendChild(doc.createTextNode("LQD"));
      		detalle.appendChild(codigoPrincipal);
      		

      				 
      		Element codigoAuxiliar = doc.createElement("codigoAuxiliar");
      		codigoAuxiliar.appendChild(doc.createTextNode("LQE"));
      		detalle.appendChild(codigoAuxiliar);
      	 
      		
      		//VARIABLE
      		Element descripcion = doc.createElement("descripcion");
      		descripcion.appendChild(doc.createTextNode("ROUTER"));
      		detalle.appendChild(descripcion);
      		
      	///variable	
      		
      		/*
      		Element unidadMedida = doc.createElement("unidadMedida");
      		unidadMedida.appendChild(doc.createTextNode("unidadMedida"));
      		detalle.appendChild(unidadMedida);
      		 
      		
      		

      		Element cantidad = doc.createElement("cantidad");
      		cantidad.appendChild(doc.createTextNode("1"));
      		detalle.appendChild(cantidad);
      		
      		
      		

      		
      		//variable
      		
      		Element precioUnitario = doc.createElement("precioUnitario");
      		precioUnitario.appendChild(doc.createTextNode("1.00"));
      		detalle.appendChild(precioUnitario);
      		
      		
      		
      		Element descuento = doc.createElement("descuento");
      		descuento.appendChild(doc.createTextNode("0.00"));
      		detalle.appendChild(descuento);
      		
      		
      		
      		Element precioTotalSinImpuesto = doc.createElement("precioTotalSinImpuesto");
      		precioTotalSinImpuesto.appendChild(doc.createTextNode("1.00"));
      		detalle.appendChild(precioTotalSinImpuesto);
      		


      	//	Element detallesAdicionales = doc.createElement("detallesAdicionales");
      	//	detalle.appendChild(detallesAdicionales);
      		
      		
      	//	Element detallesAdicionales = doc.createElement("detallesAdicionales");
      	//	detallesAdicionales.appendChild(doc.createTextNode("0.00"));
      	//	detalle.appendChild(detallesAdicionales);
      		
      		int jiji=2;
     		Element impuestos = doc.createElement("impuestos");
          	detalle.appendChild(impuestos);
      		
          	
          	
          	
          	
          	
          	Element impuesto = doc.createElement("impuesto");
          	impuestos.appendChild(impuesto);
      		
      		
          	
          	Element codigo2 = doc.createElement("codigo");
          	codigo2.appendChild(doc.createTextNode("2"));
          	impuesto.appendChild(codigo2);
          	
          	
          	Element codigoPorcentaje2 = doc.createElement("codigoPorcentaje");
          	codigoPorcentaje2.appendChild(doc.createTextNode("0"));
          	impuesto.appendChild(codigoPorcentaje2);
          	
          	
          	Element tarifa2 = doc.createElement("tarifa");
          	tarifa2.appendChild(doc.createTextNode("0"));
          	impuesto.appendChild(tarifa2);
          	
          	
          	Element baseImponible2 = doc.createElement("baseImponible");
          	baseImponible2.appendChild(doc.createTextNode("1.00"));
          	impuesto.appendChild(baseImponible2);
          	
          	
          	Element valor2 = doc.createElement("valor");
          	valor2.appendChild(doc.createTextNode("0.00"));
          	impuesto.appendChild(valor2);
          	
          	
          	
          	
          	//////////////////////////////OTRO PRODUCTO//////////////
          	
     */
      		 

    		
    		Conexion h = new Conexion();
    		  
    		 
    	 
    		 
    		//ArrayList<Usuario> = consultarusuarios.(z, x);
    		try{ 
    			
    		
    		h.conectar(); 
    		 ArrayList<Facturas> Facturas = h.DatosFactura(clavedeacceso);

    		 
    			
    			
    			for(int i=0;i<Facturas.size();i++){
    				Facturas p = Facturas.get(i);
    	           
    				 tarifas = null;
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

    	         
    	         
    	         if(ivax==1) {
    	        	 iva="2";
    	        	  tarifas = "12";
    	         }
    	         if(ivax==6) {
    	        	 iva="0";
    	        	  tarifas = "0";
    	         }
    	         
    	         
    	         
    	         
    	         
    	         float xcantidad = Float.parseFloat(Cantidad);
    	         double dcantidad = Math.round(xcantidad * 100.0) / 100.0;
    	         
    	         float PrecioPVP = Float.parseFloat(PrecioUnitario);
    	         double dpvp = Math.round(PrecioPVP * 100.0) / 100.0;
    	         
    	         
    	         
    	         float descuentos = Float.parseFloat(Descuento);
    	         double ddescuento = Math.round(descuentos * 100.0) / 100.0;
    	         
    	         
    	         ddescuento = (dpvp - ddescuento )*dcantidad;
    	         ddescuento = Math.round(ddescuento * 100.0) / 100.0;
    	         
    	         dpvp = (dpvp*dcantidad)-ddescuento ;
    	         
    	         
    	         
    	         dpvp = Math.round(dpvp * 100.0) / 100.0;
    	         
    	         
    	         
    	         
    	         String DescuentoPorItem = Double.toString(ddescuento);
    	         String preciodescontados2 = Double.toString(dpvp);

    	        
    	       //  System.out.println(Nfactura);
    	          
    	         detalles.appendChild(createUser(doc, CodigoProducto, Detalle, Cantidad, PrecioUnitario, DescuentoPorItem, preciodescontados2, iva, tarifas));
    	          
    	      
    			
    	         
    	        
    	        
          
    			}
    		}catch(Exception e){		
    			System.out.println("Ocurrió un error");
    		}
    		
      		
      		 
      		
      		 
      		
      		
      	//	impuesto.appendChild(CreateImpuesto(doc, "2", "0", "0", "1.00", "0.00")); 
			      		
			//////////////////////////////OTRO PRODUCTO//////////////
          	 
      		
          	
          	
          	
          	
          	
      		
          	
          	
          	
          	
          	
          	
          	
          	Element infoAdicional = doc.createElement("infoAdicional");
          	rootElement.appendChild(infoAdicional);
          	
          	
          	
          	
          	
          	
          	
          	
          	
          	
          	
          	
      		Element campoAdicional = doc.createElement("campoAdicional");
      		campoAdicional.appendChild(doc.createTextNode(DireccionComprador));
      		infoAdicional.appendChild(campoAdicional);
      		
      		
      		
            
      		
      		
      		
      		
      		
      		Element campoAdicional2 = doc.createElement("campoAdicional");
      		campoAdicional2.appendChild(doc.createTextNode(TelefonoComprador));
      		infoAdicional.appendChild(campoAdicional2 );
      		
      		 

      		Element campoAdicional3 = doc.createElement("campoAdicional");
      		campoAdicional3.appendChild(doc.createTextNode(EmailComprador));
      		infoAdicional.appendChild(campoAdicional3 );
      		
      		
      		Element campoAdicional4 = doc.createElement("campoAdicional");
      		campoAdicional4.appendChild(doc.createTextNode("Contribuyente Régimen RIMPE"));
      		infoAdicional.appendChild(campoAdicional4 );
      		
      		 
      		
      		
      		
      		 
      		 
    		
    		
    		 Attr attrfx = doc.createAttribute("nombre");
       		
     		attrfx.setValue("Dirección");
     		campoAdicional.setAttributeNode(attrfx);
     		
     		////////////
     		 Attr attrfx2 = doc.createAttribute("nombre");
        		
      		attrfx2.setValue("Teléfono");
      		campoAdicional2.setAttributeNode(attrfx2);
      		///////////////
      		
      		 Attr attrfx3 = doc.createAttribute("nombre");
        		
      		attrfx3.setValue("Email");
      		campoAdicional3.setAttributeNode(attrfx3);
    		
      		
      		Attr attrfx4 = doc.createAttribute("nombre");
      		attrfx4.setValue("RIMPE");
      		campoAdicional4.setAttributeNode(attrfx4);
    		
    		
    		
    		
    		
    		
    		
    		

    		
      		
      		 
      		
      		
       
      		// escribimos el contenido en un archivo .xml
      		TransformerFactory transformerFactory = TransformerFactory.newInstance();
      		Transformer transformer = transformerFactory.newTransformer();
      		transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");

      		DOMSource source = new DOMSource(doc);
      		StreamResult result = new StreamResult(new File("C:\\xml/generadas/"+clavedeacceso+".xml"));
      		
      		
      		
      		
      		
      		
      		
      		
      		
      		//StreamResult result = new StreamResult(new File("archivo.xml"));
       
      		// Si se quiere mostrar por la consola...
      		// StreamResult result = new StreamResult(System.out);
       
      		transformer.transform(source, result);
      		
      		
      		
      //	System.out.println(clavedeacceso);
      		System.out.println("File saved!");
      		
      		 
      		

      		/////////////////////////////FIRMA
      		
      		
      		
      		
      		/*String xmlPath = "c:\\1302202001091207786400120010010000002091234567817.XML";
      	    String pathSignature = "c:\\certificado.p12";
      	    String passSignature = "constraseÃ±a";
      	    String pathOut = "c:\\";
      	    String nameFileOut = "factura_sign.xml";*/
      	/*
      	   
      	    String passSignature = args[1];
      	    String xmlPath = args[2];
      	    String pathOut = args[3];
      	    String nameFileOut = args[4];
      	    
      	    */
      	    	
      	    	 String pathSignature = "C:/xml/certificado.p12";
      	    	 String passSignature = "clavefirma";
      	    	 String pathOut = "c:\\xml";
      	    	 String xmlPath = clavedeacceso+".xml";
      	    	 String nameFileOut = clavedeacceso+".xml";
      	    	
      	    
      	    	 
      	    	 
      	    	 
      	   // String[] pathnames;

      	    	 
      	    String pathnames;
      	    	 
      	    // Creates a new File instance by converting the given pathname string
      	    // into an abstract pathname
      	    File f = new File("C:/xml/generadas");
      	    
      	    

      	    // Populates the array with names of files and directories
      	   // pathnames = f.list();
      	    
      	  pathnames = clavedeacceso+".xml";

      	    // For each pathname in the pathnames array
      	  //  for (String pathname : pathnames) {
      	        // Print the names of files and directories
      	      //  System.out.println(pathname);
      	        
      	         pathOut = "C:/xml/firmadas/";
      	         xmlPath = "C:/xml/generadas/"+clavedeacceso+".xml";
      	         nameFileOut = pathnames;
      	         
      	         
      	       System.out.println(pathnames);
        		System.out.println("File saved!------------" );
      	         
      	         System.out.println("Ruta del XML de entrada: " + xmlPath);
      	         System.out.println("Ruta Certificado: " + pathSignature);
      	         System.out.println("Clave del Certificado: " + passSignature);
      	         System.out.println("Ruta de salida del XML: " + pathOut);
      	         System.out.println("Nombre del archivo salido: " + nameFileOut);
      	         
      	         
      	         
      	       
      	         
      	         
      	         
      	       generaride.main(args); 
      	          
      	         try{
      	             XAdESBESSignature.firmar(xmlPath, pathSignature, passSignature, pathOut, nameFileOut);
      	             
      	             
      	             
      	             
      	             
      	             
      	             
      	         
      	             
      	             
      	             
      	             
      	             
      	             
      	             
      	         }catch(Exception e){
      	             System.out.println("Error: " + e);
      	         }
      	         
      	         
      	         
      	         
      	         
      	    //}
      	    
      	    
      	    
      		
      		
      		
      		
      		////////////////////////////
      		
      		
      		
      		
      		
      		Conexion tt = new Conexion();
  		  
   		  
    		try{ 
    			
    		
    		tt.conectar();
    		if(tt.xmlgenerado(clavedeacceso)) {
    			System.out.println("FACTURAS ACTUALIZADAS");
    			
    		}

    					
    			 
    		}catch(Exception e){		
    			System.out.println("Ocurrió un error");
    		}
    		
      		
      		
      		
      		
      		
      		
      		
      		
      		
      		
      		
      		
       
      		} catch (ParserConfigurationException pce) {
      			pce.printStackTrace();
      		} catch (TransformerException tfe) {
      			tfe.printStackTrace();
      		}
    
    }
    
    
    
    public static String invertirCadena(String cadena) {
        String cadenaInvertida = "";
        for (int x = cadena.length() - 1; x >= 0; x--) {
            cadenaInvertida = cadenaInvertida + cadena.charAt(x);
        }
        return cadenaInvertida;
    }
 
    public static int obtenerSumaPorDigitos(String cadena) {
        int pivote = 2;
        int longitudCadena = cadena.length();
        int cantidadTotal = 0;
        int b = 1;
        for (int i = 0; i < longitudCadena; i++) {
            if (pivote == 8) {
                pivote = 2;
            }
            int temporal = Integer.parseInt("" + cadena.substring(i, b));
            b++;
            temporal *= pivote;
            pivote++;
            cantidadTotal += temporal;
        }
        cantidadTotal = 11 - cantidadTotal % 11;
        return cantidadTotal;
    }
    
    
    
    
    
    
    
    
    
    

public static void listartodo(String Clavedeaccesos){
		
		Conexion c = new Conexion();
		  
		 
		String z="TODOS";
		String x=null;
		//ArrayList<Usuario> = consultarusuarios.(z, x);
		try{ 
			
		
		c.conectar();
		 ArrayList<Clientes> Clientes = c.DatosClientes(Clavedeaccesos);

					
			
			
			for(int i=0;i<Clientes.size();i++){
				Clientes p = Clientes.get(i);
	          Vector registro = new Vector();

	          System.out.println(p.getRucComprador());
	          System.out.println(p.getRazonSocialComprador());
	          System.out.println(p.getDireccionComprador());
	          System.out.println(p.getTelefonoComprador());
	          System.out.println(p.getEmailComprador());
	          
	          
	          
	          
	      
			
	         
	        
	        
      
			}
		}catch(Exception e){		
			System.out.println("Ocurrió un error");
		}
		
		
		
		
		
		
		
	
		
		
		int bandera = 0 ;
		
		}


    
    


private static Node createUser(Document doc, String codigoPrincipal, String descripcion, 
        String cantidad, String precioUnitario, String descuento, String precioTotalSinImpuesto, String iva, String tarifas) {
    
	Element detalle = doc.createElement("detalle");
	detalle.appendChild(createUserElement(doc, "codigoPrincipal", codigoPrincipal));
    detalle.appendChild(createUserElement(doc, "descripcion", descripcion));
    detalle.appendChild(createUserElement(doc, "cantidad", cantidad));
    detalle.appendChild(createUserElement(doc, "precioUnitario", precioUnitario));
    detalle.appendChild(createUserElement(doc, "descuento", descuento));
    detalle.appendChild(createUserElement(doc, "precioTotalSinImpuesto", precioTotalSinImpuesto));
    
    double tarifas2 = Double.valueOf(tarifas);
    double precioTotalSinImpuesto2 = Double.valueOf(precioTotalSinImpuesto);
    double pagodeiva = (tarifas2*precioTotalSinImpuesto2)/100;
    pagodeiva = Math.round(pagodeiva * 100.0) / 100.0;
    
    String pagodeivas = Double.toString(pagodeiva); 
    
    
    
    

	Element impuestos = doc.createElement("impuestos");
		detalle.appendChild(impuestos);
		
		//Element pago = doc.createElement("pago");
	//	impuestos.appendChild(impuestos);
		 
		
		
	
    
    
    
    
		impuestos.appendChild(CreateImpuesto(doc, "2", iva, tarifas, precioTotalSinImpuesto, pagodeivas));
    
  
    
    ///HERE
    
    

    return detalle;
}

private static Node createUserElement(Document doc, String name, 
        String value) {

    Element node = doc.createElement(name);
    node.appendChild(doc.createTextNode(value));
    
     
    

    return node;
}
	
	
 



private static Node CreateImpuesto(Document doc, String codigo, String codigoPorcentaje, String tarifa, String baseImponible, String valor ) {
    
	
	
	
	
	
	////aqui
	
	
	
	//impuestos.appendChild(doc.createTextNode(base12));
	//	totalImpuesto.appendChild(baseImponible3);
	
	
	
	
	
	
	
    Element impuesto = doc.createElement("impuesto");
    
    //impuestos.appendChild(impuestos);
    
  //  impuesto.appendChild(CreateImpuesto(doc, "2", "0", "0", "1.00", "0.00"));
 
   // user.setAttribute("id", id);  si quiero añadir caracteristicas
    impuesto.appendChild(createImpuestoElement(doc, "codigo", codigo));
    impuesto.appendChild(createImpuestoElement(doc, "codigoPorcentaje", codigoPorcentaje));
    impuesto.appendChild(createImpuestoElement(doc, "tarifa", tarifa));
    impuesto.appendChild(createImpuestoElement(doc, "baseImponible", baseImponible));
    impuesto.appendChild(createImpuestoElement(doc, "valor", valor));

    
    
    
    
    return impuesto;
}

private static Node createImpuestoElement(Document doc, String name, 
        String value) {

    Element node = doc.createElement(name);
    node.appendChild(doc.createTextNode(value));
    
    

     
    
    
    
    
    

    return node;
}
	



	
	
	 
    
    
    

}