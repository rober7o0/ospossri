package formularios;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
 

public class Printer {
	  Font fuente = new Font("Dialog", Font.PLAIN, 10);
		PrintJob pj;
		Graphics pagina;
	 
	 
		/********************************************************************
		*	A continuación el constructor de la clase. Aquí lo único que	*
		*	hago es tomar un objeto de impresion.							*
		********************************************************************/
		Printer()
		{
			pj = Toolkit.getDefaultToolkit().getPrintJob(new Frame(), "SCAT", null);
		}
	 
		/********************************************************************
		*	A continuación el método "imprimir(String)", el encargado de 	*
		*	colocar en el objeto gráfico la cadena que se le pasa como 		*
		*	parámetro y se imprime.											*
		********************************************************************/
	    public void imprimir(String Fecha, String Numero, String Cedula, String Nombre,String Detalle, String Subtotal,  String Total )
		{
			//LO COLOCO EN UN try/catch PORQUE PUEDEN CANCELAR LA IMPRESION
	    	try
			{
				pagina = pj.getGraphics();
				pagina.setFont(fuente);
				pagina.setColor(Color.black);
	 
				pagina.drawString("Fecha "+Fecha, 60, 60);
				pagina.drawString("Numero comprobante "+Numero, 60, 80);
				pagina.drawString("Cedula "+Cedula, 60, 100);
				pagina.drawString("Nombre "+Nombre, 60, 120);
				pagina.drawString("Detalle "+Detalle, 60, 140);
				pagina.drawString("Subtotal "+Subtotal, 60, 160);
				pagina.drawString("IVA 0.00", 60, 180);
				pagina.drawString("TOTAL "+Subtotal, 60, 200);
				pagina.drawString("_____________________ ", 60, 260);
				
				pagina.drawString("Recibi conforme ", 60, 275);
	 
				pagina.dispose();
				pj.end();
			}catch(Exception e)
			{
				System.out.println("LA IMPRESION HA SIDO CANCELADA...");
			}
		}//FIN DEL PROCEDIMIENTO imprimir(String...)
	 
	 
	}//FIN DE LA CLASE Impresora



