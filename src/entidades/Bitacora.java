package entidades;



public class Bitacora {
	
	
	public Bitacora (int id, int usuario, String mz, String villa, String nvisita, String familia, String cedula,
			String placa, String autorizado, byte[] foto) {
		 
		this.id = id;
		this.usuario = usuario;
		this.mz = mz;
		this.villa = villa;
		this.nvisita = nvisita;
		this.familia = familia;
		this.cedula = cedula;
		this.placa = placa;
		this.autorizado = autorizado;
		this.foto = foto;
	
	 
	
}
	
	
	
	
	
	





	public Bitacora() {
		// TODO Auto-generated constructor stub
	}











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
	 * @return the usuario
	 */
	public int getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(int usuario) {
		this.usuario = usuario;
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
	 * @return the nvisita
	 */
	public String getNvisita() {
		return nvisita;
	}
	/**
	 * @param nvisita the nvisita to set
	 */
	public void setNvisita(String nvisita) {
		this.nvisita = nvisita;
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
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}
	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	/**
	 * @return the placa
	 */
	public String getPlaca() {
		return placa;
	}
	/**
	 * @param placa the placa to set
	 */
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	/**
	 * @return the autorizado
	 */
	public String getAutorizado() {
		return autorizado;
	}
	/**
	 * @param autorizado the autorizado to set
	 */
	public void setAutorizado(String autorizado) {
		this.autorizado = autorizado;
	}
	/**
	 * @return the foto
	 */
	public byte[] getFoto() {
		return foto;
	}
	/**
	 * @param foto the foto to set
	 */
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	
	private int id; 
	


 
 


	private int usuario;
	private String mz;
	private String villa;
	private String nvisita; 
	private String familia;
	private String cedula;
	private String placa;
	private String autorizado;
	private  byte[] foto;
	
	 
	 
	 
	
	
}