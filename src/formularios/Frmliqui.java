 

package formularios;

import java.awt.BorderLayout;
import javax.swing.JOptionPane;
import ec.gob.sri.comprobantes.modelo.DocumentoAutorizado;
import ec.gob.sri.comprobantes.modelo.factura.Factura;
import ec.gob.sri.comprobantes.util.xml.LectorComprobante;
import ejecutable.generaride;
import entidades.Clientes;
import general.principal;
import sri.XAdESBESSignature;
import formularios.Printer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.*;
import java.awt.BorderLayout;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.Proxy;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.DatatypeConverter;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.sun.prism.Graphics;
import com.sun.prism.Image;

import bd.Conexion;

import java.awt.EventQueue;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import java.awt.Component;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.swing.Box;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;




public class Frmliqui extends JFrame  {

	private static final int PAGE_EXISTS = 0;
	private static final int NO_SUCH_PAGE = 0;
	private JPanel contentPane;
	private static JTextField txtCedulaCliente;
	private static JTextField txtNombreCliente;
	private JTextField txtDireccion;
	private static JTextField txtDetalle;
	private static JTextField txtSubtotal;
	private JTextField txtIva;
	private static JTextField txtTotal;
	private static JTextField txtNumero;
	private static  JTextField txtFecha;
	

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public Frmliqui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 425, 445);
		contentPane  = new JPanel () ;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Label label = new Label("Cedula:");
		label.setBounds(10, 58, 40, 22);
		contentPane.add(label);
		
		Label label_1 = new Label("Nombres:");
		label_1.setBounds(10, 86, 49, 22);
		contentPane.add(label_1);
		
		Label label_2 = new Label("Direccion");
		label_2.setBounds(10, 114, 49, 22);
		contentPane.add(label_2);
		
		Label label_3 = new Label("Liquidacion #:");
		label_3.setBounds(133, 10, 77, 22);
		contentPane.add(label_3);
		
		Label label_6 = new Label("Descripcion:");
		label_6.setBounds(10, 142, 59, 22);
		contentPane.add(label_6);
		
		
		
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setBounds(10, 32, 210, 20);
		contentPane.add(txtFecha);
		txtFecha.setColumns(10);
		
		
		LocalDateTime ldt = LocalDateTime.now();
  		String fechas = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH).format(ldt);
  		 
  		String fechasx = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH).format(ldt);
  		System.out.println(fechas);
  		
  		String fechascx = DateTimeFormatter.ofPattern("ddMMyyyy", Locale.ENGLISH).format(ldt);
  		
  		
  		txtFecha.setText(fechasx);
  		
  		
  		
  		
  		
		
		 
		
		
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		
		
		
		
		
		
		txtCedulaCliente = new JTextField();
		txtCedulaCliente.setBounds(65, 58, 125, 20);
		contentPane.add(txtCedulaCliente);
		txtCedulaCliente.setColumns(10);
		
		txtNombreCliente = new JTextField();
		txtNombreCliente.setBounds(65, 88, 125, 20);
		txtNombreCliente.setColumns(10);
		contentPane.add(txtNombreCliente);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(65, 116, 125, 20);
		txtDireccion.setColumns(10);
		contentPane.add(txtDireccion);
		
		txtDetalle = new JTextField();
		txtDetalle.setBounds(10, 170, 365, 56);
		txtDetalle.setColumns(10);
		contentPane.add(txtDetalle);
		
		JButton btnAutocompletar = new JButton("Autocompletar");
		btnAutocompletar.setEnabled(false);
		btnAutocompletar.setBounds(201, 57, 103, 23);
		contentPane.add(btnAutocompletar);
		
		JButton btnIngresarContrato = new JButton("Ingresar");
		btnIngresarContrato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnIngresarContrato.setBounds(101, 420, 89, 23);
		contentPane.add(btnIngresarContrato);
		
		JButton btnLimpiar = new JButton("Imprimir");
		btnLimpiar.setBounds(233, 420, 89, 23);
		contentPane.add(btnLimpiar);
		
		JLabel lblNewLabel = new JLabel("Subtotal:");
		lblNewLabel.setBounds(232, 286, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("IVA:");
		lblNewLabel_1.setBounds(257, 323, 21, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Total:");
		lblNewLabel_2.setBounds(244, 356, 31, 34);
		contentPane.add(lblNewLabel_2);
		
		txtSubtotal = new JTextField();
		txtSubtotal.setBounds(288, 283, 86, 20);
		txtSubtotal.setText("0.00");
		contentPane.add(txtSubtotal);
		txtSubtotal.setColumns(10);
		
		txtIva = new JTextField();
		txtIva.setBounds(289, 320, 86, 20);
		txtIva.setText("0.00");
		txtIva.setEditable(false);
		txtIva.setColumns(10);
		contentPane.add(txtIva);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(288, 363, 86, 20);
		txtTotal.setText("0.00");
		txtTotal.setEditable(false);
		txtTotal.setColumns(10);
		contentPane.add(txtTotal);
		
		JLabel lbContratoId = new JLabel("");
		lbContratoId.setBounds(264, 18, 46, 14);
		contentPane.add(lbContratoId);
		
		DecimalFormat UK_DF = (DecimalFormat)DecimalFormat.getNumberInstance(Locale.ENGLISH);

		
		JCheckBox chckbxAplicarIva = new JCheckBox("Aplicar IVA");
		chckbxAplicarIva.setEnabled(false);
		chckbxAplicarIva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String subtotal = txtSubtotal.getText();
				
				String finales = txtSubtotal.getText();
				
				float finales2 = Float.parseFloat(finales);

				float subtotal8 = Float.parseFloat(subtotal);
				 
	          	
	          	float porcentaje = 0;
	          	if (chckbxAplicarIva.isSelected()) {
	          		 
	          		 
	          		porcentaje = 0.12f;
	          		
	          		 

	          	 
	          	} else {
	          	 
	          		porcentaje = 0;
	          	 
	          		

	          	}
	          	 
	          	float iva = subtotal8*porcentaje;
	          	

	          	DecimalFormat df = new DecimalFormat("#########.##",simbolos);
	          	df.setMaximumFractionDigits(2);
	        	String iva2 = (df.format(iva));
	          	 
               
	          	float finalizatotal = subtotal8+iva;

 
	          	
	          	 
	          	txtIva.setText(iva2);
	          	String finalizatotal2 = String.valueOf(finalizatotal);  
	          	txtTotal.setText(finalizatotal2);
	          	 System.out.println("SALIO " +finalizatotal2 );
				
				
			}
		});
		chckbxAplicarIva.setBounds(284, 253, 77, 23);
		contentPane.add(chckbxAplicarIva);
		
		txtNumero = new JTextField();
		txtNumero.setEditable(false);
		txtNumero.setBounds(216, 10, 145, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		
		try{
			
	         DataInputStream dis = 
		    new DataInputStream (
		    	 new FileInputStream ("c:\\xml/liquidaciones/id.txt"));
		       
		 byte[] datainBytes = new byte[dis.available()];
		 dis.readFully(datainBytes);
		 dis.close();
		       
		 String id2 = new String(datainBytes, 0, datainBytes.length);
		 
		 int id = Integer.parseInt(id2); 
		 
		 id = id+1;
		 
		 String id3 = Integer.toString(id); 
		 txtNumero.setText(id3);

		 
		 /*
		 
		 PrintWriter writer = new PrintWriter("c:\\\\liquidaciones/id.txt", "UTF-8");
		 writer.println(id);
		 writer.close();

		 */

		 
		 
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		
		
		JButton btnguardar = new JButton("GUARDAR");
		btnguardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
					

				 
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
			      		
			      		
			      		

			      		LocalDateTime ldt = LocalDateTime.now();
			      		String fechas = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.ENGLISH).format(ldt);
			      		 
			      		String fechasx = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss", Locale.ENGLISH).format(ldt);
			      		System.out.println(fechas);
			      		
			      		String fechascx = DateTimeFormatter.ofPattern("ddMMyyyy", Locale.ENGLISH).format(ldt);
			      		
			      		
			      		txtFecha.setText(fechasx);


			      		
			      		String fechasc = DateTimeFormatter.ofPattern("ddMMyyyy", Locale.ENGLISH).format(ldt);
			      		 
			      		String id = txtNumero.getText();
			      		
			      		
			      		
			      		int idint = Integer.parseInt(id);
			      		String laclave = (fechasc+"030911227817001200100100000000"+id+"123456781");
			      		
			      		if(idint<10) {
			      			
			      			 laclave = (fechasc+"030911227817001200100100000000"+id+"123456781");
			      		}

			      		if(idint<100  & idint>9) {
			      			
			      			 laclave = (fechasc+"03091122781700120010010000000"+id+"123456781");
			      		}
			      		

			      		if(idint<1000  & idint>99) { 
			      			
			      			 laclave = (fechasc+"0309112278170012001001000000"+id+"123456781");
			      		}
			      		
			      		

			      		if(idint<10000  & idint>999) { 
			      			
			      			 laclave = (fechasc+"030911227817001200100100000"+id+"123456781");
			      		}
			      		
			      		

			      		if(idint<100000  & idint>9999) { 
			      			
			      			 laclave = (fechasc+"03091122781700120010010000"+id+"123456781");
			      		}
			      		
			      		System.out.println("laclave"+laclave);
			      		
			      		
			      		
			      		 
			      		
			      		
			      		
			      		
			      		
			      			System.out.println(laclave);
						 int laclavef = (principal.obtenerSumaPorDigitos(principal.invertirCadena(laclave)));

			      		
						 if(laclavef==10) {
							 
							 laclavef = 1;
						 }
						 if(laclavef==11) {
							 
							 laclavef = 0;
						 }
						 
						String nombrexml = (laclave+laclavef);
						 
			      		
						 Element claveAcceso = doc.createElement("claveAcceso");
				      		claveAcceso.appendChild(doc.createTextNode(laclave+laclavef));
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
			      		
			      		
String idsec2 = "";
			      		
			      		if(idint<10) {
			      			
			      			idsec2 = ("00000000"+id);
			      		}

			      		if(idint<100  & idint>9) {
			      			
			      			idsec2 = ("0000000"+id);
			      		}
			      		

			      		if(idint<1000  & idint>99) { 
			      			
			      			idsec2 = ("000000"+id);
			      		}
			      		
			      		

			      		if(idint<10000  & idint>999) { 
			      			
			      			idsec2 = ("00000"+id);
			      		}
			      		
			      		

			      		if(idint<100000  & idint>9999) { 
			      			
			      			idsec2 = ("0000"+id);
			      		}
			      		
			      		 
			      		
			      		
			      		
			      		secuencial.appendChild(doc.createTextNode(idsec2));
			      		infoTributaria.appendChild(secuencial);
			      		
			      		
			      		
			      		Element dirMatriz = doc.createElement("dirMatriz");
			      		dirMatriz.appendChild(doc.createTextNode("AV 9 DE OCTUBRE 100 Y MALECON PISO 30 OF01"));
			      		infoTributaria.appendChild(dirMatriz);
			      		
			      		
			      		 
			      		Element infoLiquidacionCompra = doc.createElement("infoLiquidacionCompra");
			      		rootElement.appendChild(infoLiquidacionCompra);
			      		
			      		
			      		
			      		
			      		
			      		
			      		
			      		
			      		
			      		
			      		
			      		
			      		
			      		
			      		
			      		
			      		Element fechaEmision = doc.createElement("fechaEmision");
			      		fechaEmision.appendChild(doc.createTextNode(fechas));
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
			      		
			      		
			      		String RazonSocial1 = txtNombreCliente.getText();
			      		
			      		Element razonSocialProveedor = doc.createElement("razonSocialProveedor");
			      		razonSocialProveedor.appendChild(doc.createTextNode(RazonSocial1));
			      		infoLiquidacionCompra.appendChild(razonSocialProveedor);
			      		
			      		
			      		
			      		String lacedula = txtCedulaCliente.getText();
			      		
			      		
			      		
			      		
			      		Element identificacionProveedor = doc.createElement("identificacionProveedor");
			      		identificacionProveedor.appendChild(doc.createTextNode(lacedula));
			      		infoLiquidacionCompra.appendChild(identificacionProveedor);
			      		
			      		
			      		
			      		String Ladreccion = txtDireccion.getText();
			      		
			      		
			      		Element direccionProveedor = doc.createElement("direccionProveedor");
			      		direccionProveedor.appendChild(doc.createTextNode(Ladreccion));
			      		infoLiquidacionCompra.appendChild(direccionProveedor);
			      		
			      		
			      		
			      		String subtotal1 = txtSubtotal.getText();
			      		
			      		
			      		
			      		
			      		//subtotal1 = UK_DF.format(subtotal1);
			      		
			      		
			      		Element totalSinImpuestos = doc.createElement("totalSinImpuestos");
			      		totalSinImpuestos.appendChild(doc.createTextNode(subtotal1));
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
			      		
			      		
			      		
			      		
			      		 
			      		
			      		String tarifax = "";
			      		String eliva = "";
			      		String elporcen = "";
			      		
			      		if (chckbxAplicarIva.isSelected()) {
			          		 
			          		 
			      			tarifax = "12";
			      			
			      			
			      			elporcen = "2";
			      			
			      			
			      			

				      		
				      		float porcentaje = 0;
				          	if (chckbxAplicarIva.isSelected()) {
				          		 
				          		 
				          		 
				          		porcentaje = 1.12f;
				          		

				          	 
				          	} else {
				          	 
				          		
				          	 
				          		 porcentaje = 1;

				          	}
				          	float subint = Float.parseFloat(subtotal1);
				          	float totales = subint*porcentaje;
				          	
				          	DecimalFormat df = new DecimalFormat("#######.##", simbolos);
				          	df.setMaximumFractionDigits(2);
				          	eliva = (df.format(totales));

				          
				          	  
			      			
			      			
			      			
			      			
			      			
			          		
			          		 

			          	 
			          	} else {
			          	 
			          		tarifax = "0";
			          		
			          		elporcen = "0";
			          	 
			          		

			          	}
			      		
			      		Element codigoPorcentaje = doc.createElement("codigoPorcentaje");
			      		codigoPorcentaje.appendChild(doc.createTextNode(elporcen));
			      		totalImpuesto.appendChild(codigoPorcentaje);
			      		

			      		Element descuentoAdicional = doc.createElement("descuentoAdicional");
			      		descuentoAdicional.appendChild(doc.createTextNode("0.00"));
			      		totalImpuesto.appendChild(descuentoAdicional);
			      		//variable
			      		
			      		
			      		Element baseImponible3 = doc.createElement("baseImponible");
			      		baseImponible3.appendChild(doc.createTextNode(subtotal1));
			      		totalImpuesto.appendChild(baseImponible3);
			      		
			      		
			      		
			      		
			      		
			      		
			      		
			      		Element tarifa = doc.createElement("tarifa");
			      		tarifa.appendChild(doc.createTextNode(tarifax));
			      		totalImpuesto.appendChild(tarifa);
			      		
			      		
			      		
			      		
			      		
			      		
			      		
			      		
			      		
			      		if (chckbxAplicarIva.isSelected()) {
			          		 
			          		 
			      			tarifax = "12";
			      			
			      			
			      			elporcen = "2";
			      			
			      			
			      			

				      		
				      		float porcentaje = 0;
				          	if (chckbxAplicarIva.isSelected()) {
				          		 
				          		 
				          		elporcen = "0";
				          		porcentaje = 0.12f;
				          		

				          	 
				          	} else {
				          	 
				          		
				          	 
				          		 porcentaje = 0;

				          	}
				          	float subint = Float.parseFloat(subtotal1);
				          	float totales = subint*porcentaje;
				          	
				          	DecimalFormat df = new DecimalFormat("#######.##", simbolos);
				          	df.setMaximumFractionDigits(2);
				          	eliva = (df.format(totales));

				          
				          	  
			      			
			      			
			      			
			      			
			      			
			          		
			          		 

			          	 
			          	} else {
			          	 
			          		 
			          	 
			          		

			          	}
			      		
			      		
			      		
			      		
			      		
			      		
			      		
			      		if (chckbxAplicarIva.isSelected()) {
			          		 
			      			Element valor = doc.createElement("valor");
				      		valor.appendChild(doc.createTextNode(eliva));
				      		totalImpuesto.appendChild(valor);
			          	 
			          	} else {
			          	 
			          		
			          	 
			          		 

			      		
			      		
			      		Element valor = doc.createElement("valor");
			      		valor.appendChild(doc.createTextNode("0.00"));
			      		totalImpuesto.appendChild(valor);
			          	}
			      		
			      		
			      		
			      		Element importeTotal = doc.createElement("importeTotal");
			      		importeTotal.appendChild(doc.createTextNode(subtotal1));
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
			      		
			      		float porcentaje = 0;
			      		
			      		
			      		
			      		float subint = Float.parseFloat(subtotal1);
			          
			      		
			      		
			      		
			          	if (chckbxAplicarIva.isSelected()) {
			          		 
			          		 
			          		
			          		porcentaje = 1.12f;
			          		float totales = subint*porcentaje;
			          		

				          	DecimalFormat df = new DecimalFormat("########.##",simbolos);
				          	df.setMaximumFractionDigits(2);
				          	String totales7 = (df.format(totales));

			          		
				          	total.appendChild(doc.createTextNode(totales7));
				      		pago.appendChild(total);
			          	 
			          	} else {
			          		porcentaje = 1;
			          		float totales = subint*porcentaje;
			          	 
			          		 
			          		 
			          		 
			          		total.appendChild(doc.createTextNode(subtotal1));
				      		pago.appendChild(total);

			          	}
			          	
			          	
			          
			          	 
			           
			      		
			          
			      		
			          	DecimalFormat df = new DecimalFormat("########.##",simbolos);
			          	df.setMaximumFractionDigits(2);
			      		
			      		
			      		
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
			      		
			      		String razon = txtDetalle.getText();
			      		
			      		Element descripcion = doc.createElement("descripcion");
			      		descripcion.appendChild(doc.createTextNode(razon));
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
			      		precioUnitario.appendChild(doc.createTextNode(subtotal1));
			      		detalle.appendChild(precioUnitario);
			      		
			      		
			      		
			      		Element descuento = doc.createElement("descuento");
			      		descuento.appendChild(doc.createTextNode("0.00"));
			      		detalle.appendChild(descuento);
			      		
			      		
			      		
			      		Element precioTotalSinImpuesto = doc.createElement("precioTotalSinImpuesto");
			      		precioTotalSinImpuesto.appendChild(doc.createTextNode(subtotal1));
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
			          	//if (chckbxAplicarIva.isSelected()) {			          		 
			          		//codigoPorcentaje2.appendChild(doc.createTextNode("2"));
			          	//} else {
			          	 
			          	codigoPorcentaje2.appendChild(doc.createTextNode("0"));
			          	 
			          	 

			          	//}
			          	impuesto.appendChild(codigoPorcentaje2);
			          	
			          	
			          	Element tarifa2 = doc.createElement("tarifa");
			          	tarifa2.appendChild(doc.createTextNode(tarifax));
			          	impuesto.appendChild(tarifa2);
			          	
			          	
			          	Element baseImponible2 = doc.createElement("baseImponible");
			          	baseImponible2.appendChild(doc.createTextNode(subtotal1));
			          	impuesto.appendChild(baseImponible2);
			          	
			          	
			          	porcentaje = 0;
			          	
			           
			          	if (chckbxAplicarIva.isSelected()) {
			          		 
			          		 
			          		
			          		porcentaje = 0.12f;
			          		float iva = subint*porcentaje;
			          		Element valor2 = doc.createElement("valor");
			          		String ivas = (df.format(iva));
				          	valor2.appendChild(doc.createTextNode(ivas));
				          	impuesto.appendChild(valor2);
			          	 
			          	} else {
			          	 
			          	 
			          	 
			          		Element valor2 = doc.createElement("valor");
				          	valor2.appendChild(doc.createTextNode("0.00"));
				          	impuesto.appendChild(valor2);

			          	}
			          	 
			          	
			          	
			          	
			          	
			          	
			          	
			          	
			          	 
			          	 

			        
			          	
			          	
			          	
			          	
			          	
			        /*  	Element maquinaFiscal = doc.createElement("maquinaFiscal");
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
			      		
			      		*/
			      		String errador = "0";
			      		
			      		
			      		
			      		// escribimos el contenido en un archivo .xml
			      		TransformerFactory transformerFactory = TransformerFactory.newInstance();
			      		Transformer transformer = transformerFactory.newTransformer();
			      		DOMSource source = new DOMSource(doc);
			      		StreamResult result = new StreamResult(new File("C:\\xml/"+(nombrexml+".xml")));
			      		//StreamResult result = new StreamResult(new File("archivo.xml"));
			       
			      		// Si se quiere mostrar por la consola...
			      		// StreamResult result = new StreamResult(System.out);
			       
			      		transformer.transform(source, result);
			       
			      		System.out.println("File saved!");
			      		
			      		
			      		
			      		
			      		
			      		
			      		
			      		


						 String pathSignature = "C:/xml/certificado.p12";
		      	    	 String passSignature = "Cielos1968";
		      	    	 String pathOut = "c:\\xml";
		      	    	 String xmlPath = nombrexml+".xml";
		      	    	 String nameFileOut = nombrexml+".xml";
		      	    	
		      	    
		      	    	 
		      	    	 
		      	    	 
		      	   // String[] pathnames;

		      	    	 
		      	    String pathnames;
		      	    	 
		      	    // Creates a new File instance by converting the given pathname string
		      	    // into an abstract pathname
		      	    File f = new File("C:/xml/generadas");
		      	    
		      	    

		      	    // Populates the array with names of files and directories
		      	   // pathnames = f.list();
		      	    
		      	  pathnames = nombrexml+".xml";

		      	    // For each pathname in the pathnames array
		      	  //  for (String pathname : pathnames) {
		      	        // Print the names of files and directories
		      	      //  System.out.println(pathname);
		      	        
		      	         pathOut = "C:/xml/firmadas/";
		      	         xmlPath = "C:/xml/"+nombrexml+".xml";
		      	         nameFileOut = pathnames;
		      	         
		      	         
		      	       System.out.println(pathnames);
		        		System.out.println("File saved!------------" );
		      	         
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
		      	         
			      		
			      		
			      		
			      		


		      	         

							String urlWebServices;
							String method;
							String host;
							String getEncodeXML;
							Proxy proxy;
							String clavedeacceso;
		      	    	 
		      	    	 
		      	    	 urlWebServices = "https://cel.sri.gob.ec/comprobantes-electronicos-ws/RecepcionComprobantesOffline?wsdl";
		      	    	 method = "POST";
		      	    	 host = "celcer.sri.gob.ec";
		      	    	 getEncodeXML = formatSendPost("C:/xml/firmadas/"+nombrexml+".XML");
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
		      	    	      
		      	    	   

		      	    	    }catch (Exception ex) {
		      	    	      System.out.println(ex.getMessage());
		      	    	}
		      	    	    
		      	         
		      	         
		      	         
		      	         
		      	         
			      		
			      		
			      		
			      		
			      		
			      		
			      		
			      		if(errador=="0") {
			      			
			      			try{
			      				
			      		       
			      			 
			      			
			      			 
			      			 PrintWriter writer = new PrintWriter("c:\\\\xml/liquidaciones/id.txt", "UTF-8");
			      			
			      			
			      			 String idc = "";

					      		if(idint<10) {
					      			
					      			 idc = ("00000000"+id);
					      		}

					      		if(idint<100  & idint>9) {
					      			
					      			idc = ("0000000"+id);
					      		}
					      		

					      		if(idint<1000  & idint>99) { 
					      			
					      			idc = ("000000"+id);
					      		}
					      		
					      		

					      		if(idint<10000  & idint>999) { 
					      			
					      			idc = ("00000"+id);
					      		}
					      		
					      		

					      		if(idint<100000  & idint>9999) { 
					      			
					      			idc = ("0000"+id);
					      		}
					      		
					      		
					      		 writer.print(idc);
					      		 
					      		JOptionPane.showMessageDialog(null, "Liquidacion guardada");
					      		 
					      		 
			      			 writer.close();


			      			 
			      			 
			      			}catch(Exception ex){
			      				ex.printStackTrace();
			      			}
			      			
			      			
			      			
			      		}
			      		
			      		
			      		
			       
			      		} catch (ParserConfigurationException pce) {
			      			pce.printStackTrace();
			      		} catch (TransformerException tfe) {
			      			tfe.printStackTrace();
			      		} catch (SAXException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				     
				 
				 
				 
				 

      	         
      	         
				
				
				
				
				
				
				
				
		 
				
				
				
				
				
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
		});
		btnguardar.setBounds(33, 277, 89, 23);
		contentPane.add(btnguardar);
		
		JButton btnNewButton_1 = new JButton("IMPRIMIR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				
String subtotal = txtSubtotal.getText();
					
String iva = txtIva.getText();				
				
float subtotal8 = Float.parseFloat(subtotal);
float ival8 = Float.parseFloat(iva);
				 float porcentaje2 = 0;
	          	
	          	float porcentaje = 0;
	          	if (chckbxAplicarIva.isSelected()) {
	          		 
	          		 
	          		porcentaje = 0.12f;
	          		
	          		porcentaje2 = 1.12f;

	          	 
	          	} else {
	          	 
	          		porcentaje = 1;
	          	 
	          		porcentaje2 = 0;

	          	}
	          	 
	          	float totalesdt = subtotal8*porcentaje;
	          	
	          	float paraiva = subtotal8*porcentaje2;
	          	

	          	DecimalFormat df = new DecimalFormat("########.##",simbolos);
	          	df.setMaximumFractionDigits(2);
	        	String paraiva2 = (df.format(paraiva));
	        	
	        	String totalesdt2 = (df.format(totalesdt));
	          	 

	        	txtIva.setText(paraiva2);
	        	txtTotal.setText(totalesdt2);

	          	
	         
				
	        	print();
	        	
				
				
				
			}
		});
		btnNewButton_1.setBounds(33, 329, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
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
    
    
    
    
    
    
    public static void print()  {

    	
    	
    	String cadena;
    	JTextField campo;
    	JButton imprimir;
    	JLabel info;
    	Printer imp;
    	 
    	cadena = "";
		
    	
    	
    	cadena = "FECHA:   "+String.valueOf(txtFecha.getText())+"\n CEDULA "+String.valueOf(txtCedulaCliente.getText());
		
		if (!cadena.equals(""))
		{
			imp = new Printer();
			imp.imprimir(String.valueOf(txtFecha.getText()), String.valueOf(txtNumero.getText()), String.valueOf(txtCedulaCliente.getText()), String.valueOf(txtNombreCliente.getText()), String.valueOf(txtDetalle.getText()), String.valueOf(txtSubtotal.getText()), String.valueOf(txtTotal.getText()) );
			 }
		else System.out.println("NO SE IMPRIME NADA EN BLANCO...");
 
    	
    	
    	
    	
    	
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
 
    
    public static Document getDoc(String dir) throws SAXException, ParserConfigurationException, IOException{
    	 
   	 System.out.println(dir);
       File fXmlFile = new File(dir);	
       
       DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
   DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
   Document doc = dBuilder.parse(fXmlFile);
   System.out.println(doc);
      return doc;
   }
    
    
    
    public static String converBase64(Document doc) throws SAXException, ParserConfigurationException, IOException{
    	  
    	 
    	 String str = convertDocumentToString(doc);
    	         
    	    String bytesEncoded = DatatypeConverter.printBase64Binary(str.getBytes("UTF-8"));
    	    
    	    System.out.println(bytesEncoded);
    	    
    	    return bytesEncoded;
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

    
    
    
    
    
    
    
    
    
    public static void getEstadoPostSoap(Document doc, String nodoRaiz, String nodoElemento){
        
        String estado = getNodes(nodoRaiz, nodoElemento, doc );
        
        if(estado.equals("DEVUELTA")){
                     
        
           
           System.out.println("NORECIBIDA");
          
        }else if(estado.equals("RECIBIDA")){
        	
        	
        	
        	 
     		 
     	  
     	 
     	 

     		}
     
     	
        	
            System.out.println("RECIBIDA");
            
                     
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

    
    
    
    
    
    
}
