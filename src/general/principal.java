 


package general;

import ec.gob.sri.comprobantes.modelo.DocumentoAutorizado;
import ec.gob.sri.comprobantes.modelo.factura.Factura;
import ec.gob.sri.comprobantes.util.xml.LectorComprobante;
 
import formularios.Frmliqui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.*;
import java.awt.BorderLayout;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;



/**
 *
 * @author German17
 */
public class principal {

    
    public static void main(String[] args) {

    	
    	Frmliqui frm = new Frmliqui();
		frm.setVisible(true);
         // System.out.println(principal.obtenerSumaPorDigitos(principal.invertirCadena("3001202003091122781700120010010000000071234567818")));

          
          /*
          
          try {
        	  
      		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
      		DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
       
      		// elemento raiz
      		Document doc = docBuilder.newDocument();
      		
      		
      		Element rootElement = doc.createElement("liquidacionCompra");
      		doc.appendChild(rootElement);
      		System.out.println(rootElement);
      		
      		
    		
      		
      		
      		
      		
    		
      		Attr attr2 = doc.createAttribute("version");
    		attr2.setValue("1.1.0");
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
      		razonSocial.appendChild(doc.createTextNode("FERNANDEZ ESPINOZA ANITA DEL ROCIO"));
      		infoTributaria.appendChild(razonSocial);
       
      		// salario
      		Element nombreComercial = doc.createElement("nombreComercial");
      		nombreComercial.appendChild(doc.createTextNode("FERNANDEZ ESPINOZA ANITA DEL ROCIO"));
      		infoTributaria.appendChild(nombreComercial);
      		
      		
      		
      		Element ruc = doc.createElement("ruc");
      		ruc.appendChild(doc.createTextNode("0911227817001"));
      		infoTributaria.appendChild(ruc);
      		
      		
      		Element claveAcceso = doc.createElement("claveAcceso");
      		claveAcceso.appendChild(doc.createTextNode("3001202003091122781700120010010000000071234567818"));
      		infoTributaria.appendChild(claveAcceso);
      		
      		
      		
      		Element codDoc = doc.createElement("codDoc");
      		codDoc.appendChild(doc.createTextNode("03"));
      		infoTributaria.appendChild(codDoc);
      		
      		
      		
      		Element estab = doc.createElement("estab");
      		estab.appendChild(doc.createTextNode("001"));
      		infoTributaria.appendChild(estab);
      		
      		
      		
      		Element ptoEmi = doc.createElement("ptoEmi");
      		ptoEmi.appendChild(doc.createTextNode("001"));
      		infoTributaria.appendChild(ptoEmi);
      		
      		
      		
      		Element secuencial = doc.createElement("secuencial");
      		secuencial.appendChild(doc.createTextNode("000000007"));
      		infoTributaria.appendChild(secuencial);
      		
      		
      		
      		Element dirMatriz = doc.createElement("dirMatriz");
      		dirMatriz.appendChild(doc.createTextNode("CDLA ALAMOS III SOLAR 1 MZ 17"));
      		infoTributaria.appendChild(dirMatriz);
      		
      		
      		 
      		Element infoLiquidacionCompra = doc.createElement("infoLiquidacionCompra");
      		rootElement.appendChild(infoLiquidacionCompra);
      		
      		Element fechaEmision = doc.createElement("fechaEmision");
      		fechaEmision.appendChild(doc.createTextNode("30/01/2020"));
      		infoLiquidacionCompra.appendChild(fechaEmision);
      		
      		
      		Element dirEstablecimiento = doc.createElement("dirEstablecimiento");
      		dirEstablecimiento.appendChild(doc.createTextNode("CDLA ALAMOS III SOLAR 1 MZ 17"));
      		infoLiquidacionCompra.appendChild(dirEstablecimiento);
      		
      		
      		
      		Element contribuyenteEspecial = doc.createElement("contribuyenteEspecial");
      		contribuyenteEspecial.appendChild(doc.createTextNode("contribuyente"));
      		infoLiquidacionCompra.appendChild(contribuyenteEspecial);
      		
      		
      		
      		Element obligadoContabilidad = doc.createElement("obligadoContabilidad");
      		obligadoContabilidad.appendChild(doc.createTextNode("SI"));
      		infoLiquidacionCompra.appendChild(obligadoContabilidad);
      		
      		
      		
      		Element tipoIdentificacionProveedor = doc.createElement("tipoIdentificacionProveedor");
      		tipoIdentificacionProveedor.appendChild(doc.createTextNode("05"));
      		infoLiquidacionCompra.appendChild(tipoIdentificacionProveedor);
      		
      		
      		
      		Element razonSocialProveedor = doc.createElement("razonSocialProveedor");
      		razonSocialProveedor.appendChild(doc.createTextNode("Roberto Matamoro"));
      		infoLiquidacionCompra.appendChild(razonSocialProveedor);
      		
      		
      		
      		
      		
      		Element identificacionProveedor = doc.createElement("identificacionProveedor");
      		identificacionProveedor.appendChild(doc.createTextNode("0950012120"));
      		infoLiquidacionCompra.appendChild(identificacionProveedor);
      		
      		
      		
      		Element direccionProveedor = doc.createElement("direccionProveedor");
      		direccionProveedor.appendChild(doc.createTextNode("Alborada 12va"));
      		infoLiquidacionCompra.appendChild(direccionProveedor);
      		
      		
      		
      		Element totalSinImpuestos = doc.createElement("totalSinImpuestos");
      		totalSinImpuestos.appendChild(doc.createTextNode("1.00"));
      		infoLiquidacionCompra.appendChild(totalSinImpuestos);
      		
      		
      		
      		Element totalDescuento = doc.createElement("totalDescuento");
      		totalDescuento.appendChild(doc.createTextNode("0.00"));
      		infoLiquidacionCompra.appendChild(totalDescuento);
      		
      		
      		
      		Element codDocReembolso = doc.createElement("codDocReembolso");
      		codDocReembolso.appendChild(doc.createTextNode("00"));
      		infoLiquidacionCompra.appendChild(codDocReembolso);
      		
      		
      		
      		Element totalComprobantesReembolso = doc.createElement("totalComprobantesReembolso");
      		totalComprobantesReembolso.appendChild(doc.createTextNode("00.00"));
      		infoLiquidacionCompra.appendChild(totalComprobantesReembolso);
      		
      		
      		
      		Element totalBaseImponibleReembolso = doc.createElement("totalBaseImponibleReembolso");
      		totalBaseImponibleReembolso.appendChild(doc.createTextNode("00.00"));
      		infoLiquidacionCompra.appendChild(totalBaseImponibleReembolso);
      		
      		
      		
      		Element totalImpuestoReembolso = doc.createElement("totalImpuestoReembolso");
      		totalImpuestoReembolso.appendChild(doc.createTextNode("0.00"));
      		infoLiquidacionCompra.appendChild(totalImpuestoReembolso);
      		
      		
      		 
      		Element totalConImpuestos = doc.createElement("totalConImpuestos");
      		infoLiquidacionCompra.appendChild(totalConImpuestos);
      		
      		
      		
      		Element totalImpuesto = doc.createElement("totalImpuesto");
      		totalConImpuestos.appendChild(totalImpuesto);
      		 
      		 
      		
      		Element codigo = doc.createElement("codigo");
      		codigo.appendChild(doc.createTextNode("2"));
      		totalImpuesto.appendChild(codigo);
      		
      		
      		Element codigoPorcentaje = doc.createElement("codigoPorcentaje");
      		codigoPorcentaje.appendChild(doc.createTextNode("0"));
      		totalImpuesto.appendChild(codigoPorcentaje);
      		
      		
      		Element descuentoAdicional = doc.createElement("descuentoAdicional");
      		descuentoAdicional.appendChild(doc.createTextNode("0.00"));
      		totalImpuesto.appendChild(descuentoAdicional);
      		//variable
      		
      		Element baseImponible3 = doc.createElement("baseImponible");
      		baseImponible3.appendChild(doc.createTextNode("1.00"));
      		totalImpuesto.appendChild(baseImponible3);
      		
      		 
      		
      		
      		Element tarifa = doc.createElement("tarifa");
      		tarifa.appendChild(doc.createTextNode("0"));
      		totalImpuesto.appendChild(tarifa);
      		
      		
      		Element valor = doc.createElement("valor");
      		valor.appendChild(doc.createTextNode("0.00"));
      		totalImpuesto.appendChild(valor);
      		
      		
      		 
      		
      		Element importeTotal = doc.createElement("importeTotal");
      		importeTotal.appendChild(doc.createTextNode("1.00"));
      		infoLiquidacionCompra.appendChild(importeTotal);
      		
      		
      		Element moneda = doc.createElement("moneda");
      		moneda.appendChild(doc.createTextNode("USD"));
      		infoLiquidacionCompra.appendChild(moneda);
      		
      		
      		 
      		
      		Element pagos = doc.createElement("pagos");
      		infoLiquidacionCompra.appendChild(pagos);
      		
      		Element pago = doc.createElement("pago");
      		pagos.appendChild(pago);
      		 
      		
      		
      		Element formaPago = doc.createElement("formaPago");
      		formaPago.appendChild(doc.createTextNode("01"));
      		pago.appendChild(formaPago);
      		
      		Element total = doc.createElement("total");
      		total.appendChild(doc.createTextNode("1.00"));
      		pago.appendChild(total);
      		
      		
      		Element plazo = doc.createElement("plazo");
      		plazo.appendChild(doc.createTextNode("30"));
      		pago.appendChild(plazo);
      		
      		
      		Element unidadTiempo = doc.createElement("unidadTiempo");
      		unidadTiempo.appendChild(doc.createTextNode("Dias"));
      		pago.appendChild(unidadTiempo);
      		
      		
      		
      		
      		
      		Element detalles = doc.createElement("detalles");
      		rootElement.appendChild(detalles);
      		
      		
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
      		descripcion.appendChild(doc.createTextNode("RAZON PAGO"));
      		detalle.appendChild(descripcion);
      		
      	///variable	
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
          	
          	
          	
          	Element maquinaFiscal = doc.createElement("maquinaFiscal");
          	rootElement.appendChild(maquinaFiscal);
          	
          	
          	
          	
      		Element marca = doc.createElement("marca");
      		marca.appendChild(doc.createTextNode("AA"));
      		maquinaFiscal.appendChild(marca);
      		
      		Element modelo = doc.createElement("modelo");
      		modelo.appendChild(doc.createTextNode("AA"));
      		maquinaFiscal.appendChild(modelo);
      		
      		
      		Element serie = doc.createElement("serie");
      		serie.appendChild(doc.createTextNode("AA"));
      		maquinaFiscal.appendChild(serie);
      		
      		
       
      		// escribimos el contenido en un archivo .xml
      		TransformerFactory transformerFactory = TransformerFactory.newInstance();
      		Transformer transformer = transformerFactory.newTransformer();
      		DOMSource source = new DOMSource(doc);
      		StreamResult result = new StreamResult(new File("C:\\xml/archivo.xml"));
      		//StreamResult result = new StreamResult(new File("archivo.xml"));
       
      		// Si se quiere mostrar por la consola...
      		// StreamResult result = new StreamResult(System.out);
       
      		transformer.transform(source, result);
       
      		System.out.println("File saved!");
       
      		} catch (ParserConfigurationException pce) {
      			pce.printStackTrace();
      		} catch (TransformerException tfe) {
      			tfe.printStackTrace();
      		}
 */
          
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
    
    
    

 
   
    
    
    
    
    

}