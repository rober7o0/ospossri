package bd;

import entidades.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Conexion {
    
       private Connection con;
       private static final String DRIVER = "com.mysql.jdbc.Driver";
       private static final String DBMS = "mysql";
       private static final String HOST = "127.0.0.1";
       private static final String PORT = "3306";
       private static final String DATABASE = "ospos";
       private static final String USER = "root";
       private static final String PASSWORD = "";

    void Conexion(){}
    
    /*METODO CONECTAR*/
   
    public void conectar ()throws Exception{
        try {
            Class.forName(DRIVER);
        }catch(ClassNotFoundException ce){
        }
        
            try{
                this.con = DriverManager.getConnection("jdbc:" + DBMS + "://" + HOST + ":" + PORT + "/" + DATABASE, USER, PASSWORD);                
            }catch(SQLException exception){
                System.out.println("ERROR: NO SE PUDO CONECTAR CON LA BASE DE DATOS: "+exception);
            } 
      //  System.out.println("CONEXION EXITOSA CON LA BASE DE DATOS");
    }
    
    public boolean desconectar()
    {
        try
        {
            this.con.close();
            return(true);
        }
        catch(Exception e)
        {
            return(false);
        }    
    }
    
    public boolean ingresarUsuario(Usuario c)
    {
        try
        {
                PreparedStatement st = null;
                ResultSet rs = null;   
                st = con.prepareStatement("INSERT INTO usuario(id,clave,cedula,nombres,apellidos,rol,estado) VALUES(?,?,?,?,?,?,?) ");            
                st.setString(1,c.getId());
                st.setString(2,c.getClave());
                st.setString(3,c.getCedula());
                st.setString(4,c.getNombres());
                st.setString(5,c.getApellidos());
                
                String roles;
                String estado;
                estado=Character.toString(c.getEstado());
                roles=Character.toString(c.getRol());
                st.setString(6,roles);
                st.setString(7,estado);
                
                
                st.executeUpdate();
                st.close();                        
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }        
    }
     
    
    
    
    
    
    
    
    
    
    public boolean ingresarResidente(Residente c)
    {
        try
        {
                PreparedStatement st = null;
                ResultSet rs = null;   
                 
                st = con.prepareStatement("INSERT INTO residentes(`mz`, `villa`, `familia`, `telefono1`, `telefono2`, `email`, `estado`) VALUES(?,?,?,?,?,?,?) ");
                 
                st.setString(1,c.getMz());
                st.setString(2,c.getVilla());
                st.setString(3,c.getFamilia());
                st.setString(4,c.getTelefono1());
                st.setString(5,c.getTelefono2());
                st.setString(6,c.getEmail());
                st.setString(7,c.getEstado());
                
                                
                
                st.executeUpdate();
                st.close();                        
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public Usuario consultarDatosUsuario(Usuario u)
    {
        Usuario resultado = null;
        ResultSet rs = null;                       
        PreparedStatement st = null;
        try
        {
            st = con.prepareStatement("SELECT * FROM usuario WHERE id = ?");            
            st.setString(1,u.getId());         
            rs = st.executeQuery();            
            if(rs.next()){
                String id   = rs.getString("id");
                String nombres      = rs.getString("nombres");
                String apellidos    = rs.getString("apellidos");
                char rol           = rs.getString("rol").charAt(0);
                char estado         = rs.getString("estado").charAt(0);
                resultado           = new Usuario(id, nombres, apellidos, rol, estado);
                
                
                u.setNombres(nombres);
                u.setApellidos(apellidos);
                u.setRol(rol);
                u.setEstado(estado);
            }
            rs.close();
            st.close();                                                 
        }
        
        catch(Exception e){System.out.println(e);}
     return resultado;
    }    
    
    
    
    

    public ArrayList<Clientes> DatosClientes(String clavedeaccesos)
    {
        ArrayList<Clientes> resultados = new ArrayList<Clientes>();
       

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = null;  
            
            
             
            	
            	
            	rs = st.executeQuery("SELECT ospos_electronic.nfactura, ospos_electronic.clavedeacceso, ospos_electronic.ruc_cliente, ospos_people.first_name, ospos_people.last_name, ospos_people.phone_number, ospos_people.address_1, ospos_people.email  FROM `ospos_electronic`, `ospos_people`  WHERE  `ospos_electronic`.ruc_cliente=`ospos_people`.ruc_cliente AND `ospos_electronic`.xml = 'N'  GROUP BY clavedeacceso LIMIT 1;;");
           
            
            
            while(rs.next())
            {
            	
            	 
                
                
                String RucComprador = rs.getString("ruc_cliente");
            	String RazonSocialComprador = rs.getString("first_name")+" "+rs.getString("last_name"); 
            	String DireccionComprador = rs.getString("address_1");
            	String TelefonoComprador = rs.getString("phone_number");
            	String EmailComprador = rs.getString("email");
            	String clavedeacceso = rs.getString("clavedeacceso");  
                
             
            	
                
                
                Clientes c = new Clientes( RucComprador, RazonSocialComprador, DireccionComprador, TelefonoComprador, EmailComprador, clavedeacceso);               
               

                resultados.add(c);
                
                 
               
                

                
            }
        }
        catch(Exception e){System.out.println(e);}
        
        
      

       

     return(resultados);
     
 

    }     

    
    
    
    
    
    
    
    
    
    
    
    
    public ArrayList<Clientes> EnviarMail(String clavedeaccesos)
    {
        ArrayList<Clientes> resultados = new ArrayList<Clientes>();
       

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = null;  
            
            
             
            	
            	
            	rs = st.executeQuery("SELECT ospos_electronic.nfactura, ospos_electronic.clavedeacceso, ospos_electronic.ruc_cliente, ospos_people.first_name, ospos_people.last_name, ospos_people.phone_number, ospos_people.address_1, ospos_people.email  FROM `ospos_electronic`, `ospos_people`  WHERE  `ospos_electronic`.ruc_cliente=`ospos_people`.ruc_cliente AND `ospos_electronic`.xml = 'AUT'  GROUP BY clavedeacceso LIMIT 1;;");
           
            
            
            while(rs.next())
            {
            	
            	 
                
                
                String RucComprador = rs.getString("ruc_cliente");
            	String RazonSocialComprador = rs.getString("first_name")+" "+rs.getString("last_name"); 
            	String DireccionComprador = rs.getString("address_1");
            	String TelefonoComprador = rs.getString("phone_number");
            	String EmailComprador = rs.getString("email");
            	String clavedeacceso = rs.getString("clavedeacceso");  
                
             
            	
                
                
                Clientes c = new Clientes( RucComprador, RazonSocialComprador, DireccionComprador, TelefonoComprador, EmailComprador, clavedeacceso);               
               

                resultados.add(c);
                
                 
               
                

                
            }
        }
        catch(Exception e){System.out.println(e);}
        
        
      

       

     return(resultados);
     
 

    }     
    
    
    
    
    
    
    
    
    
    
    
    
    

    
    public ArrayList<Clientes> SubirXml(String clavedeaccesos)
    {
        ArrayList<Clientes> resultados = new ArrayList<Clientes>();
       

        try
        {
            Statement st = con.createStatement();
            ResultSet rs = null;  
            
            
             
            	
            	
            	rs = st.executeQuery("SELECT ospos_electronic.nfactura, ospos_electronic.clavedeacceso, ospos_electronic.ruc_cliente, ospos_people.first_name, ospos_people.last_name, ospos_people.phone_number, ospos_people.address_1, ospos_people.email  FROM `ospos_electronic`, `ospos_people`  WHERE  `ospos_electronic`.ruc_cliente=`ospos_people`.ruc_cliente AND `ospos_electronic`.xml = 'G'  GROUP BY clavedeacceso LIMIT 1;;");
           
            
            
            while(rs.next())
            {
            	
            	 
                
                
                String RucComprador = rs.getString("ruc_cliente");
            	String RazonSocialComprador = rs.getString("first_name")+" "+rs.getString("last_name"); 
            	String DireccionComprador = rs.getString("address_1");
            	String TelefonoComprador = rs.getString("phone_number");
            	String EmailComprador = rs.getString("email");
            	String clavedeacceso = rs.getString("clavedeacceso");  
                
             
            	
                
                
                Clientes c = new Clientes( RucComprador, RazonSocialComprador, DireccionComprador, TelefonoComprador, EmailComprador, clavedeacceso);               
               

                resultados.add(c);
                
                 
               
                

                
            }
        }
        catch(Exception e){System.out.println(e);}
        
        
      

       

     return(resultados);
     
 

    }     
    
    
    
    
   
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    public ArrayList<Facturas> DatosFactura(String codigodeacceso)
    {
    	
    	 
        ArrayList<Facturas> resultados = new ArrayList<Facturas>();
       
         
        try
        {
        	 Usuario resultado = null;
             ResultSet rs = null;                       
             PreparedStatement st = null; 
            
            
             
            
            	
            st = con.prepareStatement("SELECT ospos_electronic.nfactura, ospos_electronic.clavedeacceso, ospos_electronic.cantidad, ospos_electronic.detalle, ospos_electronic.codigo_producto, ospos_electronic.precio_unitario, ospos_electronic.descuento, ospos_electronic.xml, ospos_items.tax_category_id FROM ospos_electronic, ospos_items WHERE ospos_items.item_number = ospos_electronic.codigo_producto and ospos_electronic.clavedeacceso = ?;");
             
            st.setString(1,codigodeacceso);  
            rs = st.executeQuery();      
            while(rs.next())
            {
            	
            	
                
                
                String NumeroFactura = rs.getString("nfactura");
            	String ClaveDeAcceso = rs.getString("clavedeacceso"); 
            	String Cantidad = rs.getString("cantidad");
            	String Detalle = rs.getString("detalle");
            	String CodigoProducto = rs.getString("codigo_producto");
            	String PrecioUnitario = rs.getString("precio_unitario");
            	String descuento = rs.getString("descuento");
            	String xml = rs.getString("xml");
            	String iva = rs.getString("tax_category_id");
            	
            	
            	
            	 
            	
               
                
            	Facturas c = new Facturas( NumeroFactura, ClaveDeAcceso, Cantidad, Detalle, CodigoProducto, PrecioUnitario, descuento, xml, iva);               
               

                resultados.add(c);
                
                 
               
                

                
            }
        }
        catch(Exception e){System.out.println(e);}
        
        
      

       

     return(resultados);
     
 

    }     
    
    
    
    
    
    
    
    
    
    
    public boolean xmlgenerado(String clavedeacceso)
    {
        try
        {
            PreparedStatement st = null;
            st = con.prepareStatement("UPDATE ospos_electronic SET xml = 'G' WHERE clavedeacceso = ?");                        
            st.setString(1,clavedeacceso);
            
                    
            st.executeUpdate();
            st.close();                        
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
        
    }
    
    
    
    
    
    
    
    
    public boolean RideEnviado(String clavedeacceso)
    {
        try
        {
            PreparedStatement st = null;
            st = con.prepareStatement("UPDATE ospos_electronic SET xml = 'enviado' WHERE clavedeacceso = ?");                        
            st.setString(1,clavedeacceso);
            
                    
            st.executeUpdate();
            st.close();                        
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
        
    }
    
    
    
    
    
    
    

    public boolean xmlAutorizado(String clavedeacceso)
    {
        try
        {
            PreparedStatement st = null;
            st = con.prepareStatement("UPDATE ospos_electronic SET xml = 'AUT' WHERE clavedeacceso = ?");                        
            st.setString(1,clavedeacceso);
            
                    
            st.executeUpdate();
            st.close();                        
            return true;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return false;
        }
        
    }
    
    
    
    
    
    
    
    
}