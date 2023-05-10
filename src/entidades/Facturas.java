package entidades;

public class Facturas {
	

	private String Nfactura;
	private String ClaveDeAcceso;
	private String Cantidad;
	private String Detalle;
	private String CodigoProducto;
	private String PrecioUnitario;
	private String Descuento;
	private String iva;
	private String xml;
	 
	
	//public Clientes(){}
	public Facturas(String Nfactura, String ClaveDeAcceso, String Cantidad, String Detalle, String CodigoProducto, String PrecioUnitario, String Descuento, String xml, String iva) {
		
		
		this.Nfactura = Nfactura;
		this.ClaveDeAcceso = ClaveDeAcceso;
		this.Cantidad = Cantidad;
        this.Detalle = Detalle;
        this.CodigoProducto = CodigoProducto;
        this.PrecioUnitario = PrecioUnitario;
        this.Descuento = Descuento;
        this.xml = xml;
        this.iva = iva;
        
		// TODO Auto-generated constructor stub
		
	}
	
	
	
	
	
	
	
	public String getCantidad() {
		return Cantidad;
	}
	public void setCantidad(String Cantidad) {
		this.Cantidad = Cantidad;
	}
	public String getDetalle() {
		return Detalle;
	}
	public void setDetalle(String Detalle) {
		this.Detalle = Detalle;
	}
	public String getCodigoProducto() {
		return CodigoProducto;
	}
	public void setCodigoProducto(String CodigoProducto) {
		this.CodigoProducto = CodigoProducto;
	}
	
	
	public String getNfactura() {
		return Nfactura;
	}
	public void setId(String Nfactura) {
		this.Nfactura = Nfactura;
	}
	public String getClaveDeAcceso() {
		return ClaveDeAcceso;
	}
	public void setClaveDeAcceso(String ClaveDeAcceso) {
		this.ClaveDeAcceso = ClaveDeAcceso;
	}
	public String getPrecioUnitario() {
		return PrecioUnitario;
	}
	public void setPrecioUnitario(String PrecioUnitario) {
		this.PrecioUnitario = PrecioUnitario;
	}
 
	
	
	public String getDescuento() {
		return Descuento;
	}
	public void setDescuento(String Descuento) {
		this.Descuento = Descuento;
	}
 
	
	
	
	public String getxml() {
		return xml;
	}
	public void setxml(String xml) {
		this.xml = xml;
	}
	
	
	
	public String getiva() {
		return iva;
	}
	public void setiva(String iva) {
		this.iva = iva;
	}
 
	
	
	
	      

}
