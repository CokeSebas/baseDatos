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
public class Proveedor extends Persona {
    private int tomarMaxCodigoProveedor;
    private int agregarCodigoProveedor;
    private String nombreEjecutivo;
    private String nombreEmpresa;

    public Proveedor(String nombreEmpresa, int rut, char dv, String eMail, int telefonoFijo, int telefonoCel, String nombreCalle, String numeroCalle, String NombrePoblacion, int comunaID) {
        super(rut, dv, eMail, telefonoFijo, telefonoCel, nombreCalle, numeroCalle, NombrePoblacion, comunaID);
        this.nombreEmpresa = nombreEmpresa;
    }

    

    
    
    public Proveedor() {
    }

    public String getNombreEjecutivo() {
        return nombreEjecutivo;
    }

    public void setNombreEjecutivo(String nombreEjecutivo)throws DatoIncorrectoException{
      if(validarLargoPalabraObligatoria(nombreEjecutivo,3)|| validarSoloLetras(nombreEjecutivo)){
           lanzarException("Largo de palabra: minimo 3 caracteres \n No puede ingresar numeros");
      }else{
        this.nombreEjecutivo = nombreEjecutivo;
      }
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa)throws DatoIncorrectoException{
         if(validarLargoPalabraObligatoria(nombreEmpresa,3)|| validarSoloLetras(nombreEmpresa)){
           lanzarException("Largo de palabra: minimo 3 caracteres \n No puede ingresar numeros");
      }else{
        this.nombreEmpresa = nombreEmpresa;
         }
    }
    
     public boolean validarSoloLetras(String letras){
           boolean verdad = false;
        for(int i = 0;i < 10;i++){
        if(letras.trim().contains(String.valueOf(i))){
            verdad = true;
        
        }
    
    }
           return verdad;
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
       public boolean  buscarProveedor( int rut){
        
              boolean buscProveedor = false;
        try   {
            String com = "select rut_empresa from proveedor where rut_empresa = " + rut;
          // String com = "fn_existe_cliente(" +rut+" );";
                  ResultSet rs  = Conexion.exeQuery(com);
                     while(rs.next()){
                         System.out.println(" aca    vamos " +  rs.getString(1));
                         buscProveedor = true;
                     }
                      Conexion.desconectar();
          
                        } catch(Exception ex){
                       System.out.println("No se encontraron datos");
                        }   
                       return buscProveedor;
                       
                       }
         
       public void insertarProveedor()throws DatoIncorrectoException{
        
           /*  try{
              
         String insertarCliente = "Insert into proveedor(codigo_proveedor,nomb_empresa,rut_empresa"
                   + ",dig_verificador_emp,telefono_fijo,telefono_celular,correo_electronico,"
                   + "dir_nomb_calle,dir_numero,comuna_id)"
                + "                values (Cod_Prov.NextVal,'"+
                   getNombreEmpresa().toUpperCase()+"',"+getRut()+",'"+String.valueOf(getDv()).toUpperCase()+
                "',"+getTelefonoFijo()+","+getTelefonoCel()+",'"+geteMail().toUpperCase() +"','"+
                   getNombreCalle().toUpperCase()+"','"+getNumeroCalle()+"',"+getComunaID()+")";
         
      
                    Conexion.query(insertarCliente);
          }catch(Exception ex){
             
          } */
       
       }
       
       
         public String toString(){
		return  getRut() +" "+ getDv() +" "+  
                 geteMail()+" " + getTelefonoFijo()+" " + getTelefonoCel()+" " + getNombreCalle()+" " + 
                getNumeroCalle()+" " + getComunaID()+" " +getNombreEmpresa();        
                        
                       
      }
       
}

