package entidades;

public class Clientes {
	

	private String RucComprador;
	private String RazonSocialComprador;
	private String DireccionComprador;
	private String TelefonoComprador;
	private String EmailComprador;
	private String clavedeacceso;
	 
	
	//public Clientes(){}
	public Clientes(String RucComprador, String RazonSocialComprador, String DireccionComprador, String TelefonoComprador, String EmailComprador, String clavedeacceso) {
		
		
		this.RucComprador = RucComprador;
		this.RazonSocialComprador = RazonSocialComprador;
		this.DireccionComprador = DireccionComprador;
        this.TelefonoComprador = TelefonoComprador;
        this.EmailComprador = EmailComprador;
        this.clavedeacceso = clavedeacceso;
        
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
	public String getclavedeacceso() {
		return clavedeacceso;
	}
	public void setclavedeacceso(String clavedeacceso) {
		this.clavedeacceso = clavedeacceso;
	}
 
	
	
	      

}
