/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validacion;

import BDConexion.Conexion;
import java.sql.ResultSet;

/**
 *
 * @author jag
 */
public class Usuario extends Persona {
    private int tomarMaxCodigoVendedor;
    private int agregarCodigoVendedor;
    private String fechaIngreso;
    private String nombreUsuario;
    private String contrasena;
    private int nivel;
    private int salario;

    public Usuario(String fechaIngreso, String nombreUsuario, String contrasena, 
            int nivel, int salario, int rut, char dv, String fechaNac, 
            String primerNombre, String segundoNombre, String apellPaterno,
            String apellMaterno, String eMail, int telefonoFijo, int telefonoCel,
            String nombreCalle, String numeroCalle, String NombrePoblacion, int comunaID) {
        super(rut, dv, fechaNac, primerNombre, segundoNombre, apellPaterno, 
                apellMaterno, eMail, telefonoFijo, telefonoCel, nombreCalle,
                numeroCalle, NombrePoblacion, comunaID);
        this.fechaIngreso = fechaIngreso;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;
        this.nivel = nivel;
        this.salario = salario;
    }
    
    

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena)throws DatoIncorrectoException{
        if(contrasena.length()< 8){
             lanzarException("La contraseña debe ser igual o mayor a 8 digitos");
        }else{
        this.contrasena = contrasena;
        }
    }

    public int getNivel() {
     
        return nivel;
    }

    public void setNivel(int nivel) throws DatoIncorrectoException{
           if(nivel < 1 || nivel > 3){
         lanzarException("Nivel debe ser entre 1 y 3");
        }else{
        this.nivel = nivel;
           }
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario)throws DatoIncorrectoException{
        if(validarSoloLetrasYEspacio(nombreUsuario)){
            lanzarException("Se ingresa solo letras para usuario");
        }else{
        this.nombreUsuario = nombreUsuario;
        }
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) throws DatoIncorrectoException{
    
        if(salario < 182000 ){
            lanzarException("Debe pagar como minimo el sueldo base = 182000");
          
        }else{
        this.salario = salario;
        }
    }
    
    public Usuario(){
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String dia,String mes,String anno)throws DatoIncorrectoException {
   
           String formato = dia +"/"+mes+"/"+anno;
            this.fechaIngreso   = formato;
            System.out.println("Fecha Ingreso :" + formato);
        
      
    }
    
     public int tomarMaxCodigoUsuario(){
       try{
        String maxVend = "select max(codigo_vendedor) from vendedor";
                       
                  ResultSet rs  = Conexion.exeQuery(maxVend);
        
                     while(rs.next()){
                     tomarMaxCodigoVendedor = rs.getInt(1);
                     }
                 
           if( tomarMaxCodigoVendedor == 0||String.valueOf(tomarMaxCodigoVendedor )== null){
              agregarCodigoVendedor= 10;
           }else{
                agregarCodigoVendedor = tomarMaxCodigoVendedor + 10;
           }  
       }catch(Exception ex) {
       
       }
        return agregarCodigoVendedor;
    }
    
      public String tomarCodigoComuna(String nombreComuna){
          String tomarComunaID=null;
       try{
        String comunaID = "select comuna_id from comuna where comuna_nombre = '"+ nombreComuna +"'";
                       
                  ResultSet rs  = Conexion.exeQuery(comunaID);
        
                     while(rs.next()){
                    tomarComunaID= rs.getString(1);
                     }
       }catch(Exception ex){
       
       }  
       
        return   tomarComunaID;
    }
      
       public boolean  buscarVendedor( int rut){
        
              boolean busVendedor = false;
        try   {
            String com = "select rut_vendedor from vendedor where rut_vendedor = " + rut;
          // String com = "fn_existe_cliente(" +rut+" );";
                  ResultSet rs  = Conexion.exeQuery(com);
                     while(rs.next()){
                         System.out.println(" aca    vamos " +  rs.getString(1));
                         busVendedor = true;
                     }
                      Conexion.desconectar();
          
                        } catch(Exception ex){
                       System.out.println("No se encontraron datos");
                        }   
                       return busVendedor;
                       
                       }
       
        public void insertarUsuario()throws DatoIncorrectoException{
          try{
           String insertarUsu = "insert into vendedor (codigo_vendedor,rut_vendedor,digito_verificador,"
                   + "fecha_nacimiento,prim_nombre,seg_nombre,apell_paterno,apell_materno,fecha_ingreso,"
                   + "correo_electronico,telefono_fijo,telefono_celular,dir_nombre_calle,dir_numero"
                   + ",nombre_usuario,contrasena_usuario,nivel_usuario,salario,poblacion,comuna_id) "
                + " values (Cod_Vend.NextVal,"+
                   getRut()+",'"
                   +String.valueOf(getDv()).toUpperCase()+"','"
                   +getFechaNac()+ "','"+
                   getPrimerNombre().toUpperCase()+"','"
                   +getSegundoNombre().toUpperCase()+"','"
                   +getApellPaterno().toUpperCase()+"','"+
                   getApellMaterno().toUpperCase()+"','"+
                   getFechaIngreso()+"','"+
                   geteMail().toUpperCase()+"',"+
                   getTelefonoFijo()+","+
                   getTelefonoCel()+",'"+
                   getNombreCalle().toUpperCase()+"','"+
                   getNumeroCalle()+"','"+
                   getNombreUsuario().toUpperCase()+"','"+
                   getContrasena().toUpperCase()+"',"+
                   getNivel()+","+
                   getSalario()+",'"+
                   getNombrePoblacion().toUpperCase()+"',"+
                   getComunaID()+
                   ")";
         
       
                     Conexion.query(insertarUsu);
                     
                   
          }catch(Exception ex){
                 
          }
       
       }
        
       
       
        public String toString(){
		return  + getRut() +" "+ String.valueOf(getDv()).toUpperCase() +" "+ getFechaNac() +" "+ getPrimerNombre().toUpperCase()
       +" " + getSegundoNombre().toUpperCase() +" "+ getApellPaterno().toUpperCase() +" "+ getApellMaterno().toUpperCase()+" " + getFechaIngreso()+" " +
                 geteMail().toUpperCase()+" " + getTelefonoFijo()+" " + getTelefonoCel()+" " + getNombreCalle().toUpperCase()+" " + 
                getNumeroCalle()+" " + getComunaID()+" " + getFechaIngreso()+" " + getNombreUsuario().toUpperCase() +" " + getContrasena().toUpperCase()+" " +
                        getNivel()+" " +getSalario()+" "+ getComunaID();        
                        
      }
       
}
