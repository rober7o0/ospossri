package entidades;

public class Comprador {
	

	private String RucComprador;
	private String RazonSocialComprador;
	private String DireccionComprador;
	private String TelefonoComprador;
	private String EmailComprador;
	private String EstadoComprador;
	 
	
	//public Clientes(){}
	public Comprador(String RucComprador, String RazonSocialComprador, String DireccionComprador, String TelefonoComprador, String EmailComprador, String EstadoComprador) {
		
		
		this.RucComprador = RucComprador;
		this.RazonSocialComprador = RazonSocialComprador;
		this.DireccionComprador = DireccionComprador;
        this.TelefonoComprador = TelefonoComprador;
        this.EmailComprador = EmailComprador;
        this.EstadoComprador = EstadoComprador;
        
		// TODO Auto-generated constructor stub
		
	}
	
	
	
	
	
	
	
	public String getDireccionComprador() {
		return DireccionComprador;
	}
	public void setDireccionComprador(String DireccionComprador) {
		this.DireccionComprador = DireccionComprador;
	}
	public String getTelefonoComprador() {
		return TelefonoComprador;
	}
	public void setTelefonoComprador(String TelefonoComprador) {
		this.TelefonoComprador = TelefonoComprador;
	}
	public String getEmailComprador() {
		return EmailComprador;
	}
	public void setEmailComprador(String EmailComprador) {
		this.EmailComprador = EmailComprador;
	}
	
	
	
	public String getRucComprador() {
		return RucComprador;
	}
	public void setId(String RucComprador) {
		this.RucComprador = RucComprador;
	}
	public String getRazonSocialComprador() {
		return RazonSocialComprador;
	}
	public void setRazonSocialComprador(String RazonSocialComprador) {
		this.RazonSocialComprador = RazonSocialComprador;
	}
	public String getEstadoComprador() {
		return EstadoComprador;
	}
	public void setEstadoComprador(String EstadoComprador) {
		this.EstadoComprador = EstadoComprador;
	}
 
	
	
	      

}
