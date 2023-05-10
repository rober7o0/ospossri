package entidades;

public class Residente {

	
	
	 
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the mz
	 */
	public String getMz() {
		return mz;
	}
	/**
	 * @param mz the mz to set
	 */
	public void setMz(String mz) {
		this.mz = mz;
	}
	/**
	 * @return the villa
	 */
	public String getVilla() {
		return villa;
	}
	/**
	 * @param villa the villa to set
	 */
	public void setVilla(String villa) {
		this.villa = villa;
	}
	/**
	 * @return the familia
	 */
	public String getFamilia() {
		return familia;
	}
	/**
	 * @param familia the familia to set
	 */
	public void setFamilia(String familia) {
		this.familia = familia;
	}
	/**
	 * @return the telefono1
	 */
	public String getTelefono1() {
		return telefono1;
	}
	/**
	 * @param telefono1 the telefono1 to set
	 */
	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}
	/**
	 * @return the telefono2
	 */
	public String getTelefono2() {
		return telefono2;
	}
	/**
	 * @param telefono2 the telefono2 to set
	 */
	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the estado
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	private int id;
	private String mz;
	private String villa;
	private String familia;
	private String telefono1;
	private String telefono2;
	private String email;
	private String estado;
	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}
	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}
	private String observacion;
	
	public Residente(){}
	public Residente(int id, String mz, String villa, String familia, String telefono1, String telefono2, String email, String estado , String observacion ) {
		
		
	 
        this.id = id;
        this.mz = mz;
        this.villa = villa;
        this.familia = familia;
        this.telefono1 = telefono1;
        this.telefono2 = telefono2;
        this.email = email;
        this.estado = estado; 
        this.observacion = observacion; 
        
        
		// TODO Auto-generated constructor stub
		
	}
	
	
	
	
	
	/*
	public String getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(String id_cliente) {
		this.id_cliente = id_cliente;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
	
	*/
	
	
	
}
