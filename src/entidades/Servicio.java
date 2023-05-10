package entidades;

public class Servicio {

	
	
	
	private String nombre;
	private String medio;
	private String descripcion;
	private float precio;
	private String id_servicio;
	
	
	public Servicio(){}
	public Servicio(String id_servicio, String nombre, String medio, String descripcion, float precio) {
		
		
		this.id_servicio = id_servicio;
        this.nombre = nombre;
        this.medio = medio;
        this.descripcion = descripcion;
        this.precio = precio;
        this.id_servicio = id_servicio;
		// TODO Auto-generated constructor stub
		
	}
	
	
	
	
	
	public String getId_servicio() {
		return id_servicio;
	}
	public void setId_servicio(String id_servicio) {
		this.id_servicio = id_servicio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMedio() {
		return medio;
	}
	public void setMedio(String medio) {
		this.medio = medio;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	
	
}
