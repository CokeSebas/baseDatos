/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validacion;
import BDConexion.Conexion;
import java.sql.ResultSet;
public class Cliente extends Persona {
    private int tomarMaxCodigoCliente;
    private int agregarCodigoCliente;

    public Cliente(int rut, char dv, String fechaNac, String primerNombre, String segundoNombre, String apellPaterno, String apellMaterno, String eMail, int telefonoFijo, int telefonoCel, String nombreCalle, String numeroCalle, String NombrePoblacion, int comunaID) {
        super(rut, dv, fechaNac, primerNombre, segundoNombre, apellPaterno, apellMaterno, eMail, telefonoFijo, telefonoCel, nombreCalle, numeroCalle, NombrePoblacion, comunaID);
    }


    public Cliente() {
    }
    
    private String string;

    /**
     * Get the value of string
     *
     * @return the value of string
     */
    public String getString() {
        return string;
    }

    /**
     * Set the value of string
     *
     * @param string new value of string
     */
    public void setString(String string) {
        this.string = string;
    }

    public int tomarMaxCodigoCliente(){
       try{
        String maxCli = "select max(codigo_cliente) from cliente";
                       
                  ResultSet rs  = Conexion.exeQuery(maxCli);
        
                     while(rs.next()){
                     tomarMaxCodigoCliente= rs.getInt(1);
                     }
                 
           if( tomarMaxCodigoCliente == 0|| String.valueOf(tomarMaxCodigoCliente) == null){
              agregarCodigoCliente= 10;
           }else{
                agregarCodigoCliente = tomarMaxCodigoCliente + 10;
           }  
       }catch(Exception ex) {
       
       }
        return agregarCodigoCliente;
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
      
       public boolean  buscarCliente( int rut){
        
              boolean busCliente = false;
        try   {
            String com = "select rut_cliente from cliente where rut_cliente = " + rut;
          // String com = "fn_existe_cliente(" +rut+" );";
                  ResultSet rs  = Conexion.exeQuery(com);
                     while(rs.next()){
                         System.out.println(" aca    vamos " +  rs.getString(1));
                         busCliente = true;
                     }
                      Conexion.desconectar();
          
                        } catch(Exception ex){
                       System.out.println("No se encontraron datos");
                        }   
                       return busCliente;
                       
                       }
       
       public void insertarCliente()throws DatoIncorrectoException{
          try{
           String insertarCliente = "insert into cliente(CODIGO_CLIENTE, "  +
    "RUT_CLIENTE,DIGITO_VERIFICADOR,FECHA_NACIMIENTO,PRIMER_NOMBRE, SEGUNDO_NOMBRE, APELL_PATERNO ,"+
   " APELL_MATERNO, CORREO_ELECTRONICO ,TELEFONO_FIJO,TELE_CELULAR,DIR_NOMBRE_CALLE, DIR_NUMERO,"+
   " POBLACION,COMUNA_ID) values (Cod_Cli.NextVal,"+getRut()+",'"+ String.valueOf(getDv()).toUpperCase()+"','"+getFechaNac()+
                "','"+getPrimerNombre().toUpperCase()+"','"+getSegundoNombre().toUpperCase()+"','"
                +getApellPaterno().toUpperCase()+"','"+getApellMaterno().toUpperCase()+"','"+
               geteMail().toUpperCase()+"',"+getTelefonoFijo()+
                        ","+getTelefonoCel()+",'"+getNombreCalle().toUpperCase()
                +"','"+getNumeroCalle()+"','"+getNombrePoblacion().toUpperCase()+"',"+getComunaID()+")";
         
       
                    Conexion.query(insertarCliente);
          }catch(Exception ex){
             
          }
       
       }
      public String toString(){
		return  getRut() +" "+ String.valueOf(getDv()).toUpperCase() +" "+ getFechaNac() +" "+ getPrimerNombre().toUpperCase()
       +" " + getSegundoNombre().toUpperCase() +" "+ getApellPaterno().toUpperCase() +" "+ getApellMaterno().toUpperCase()+" " + 
                 geteMail().toUpperCase()+" " + getTelefonoFijo()+" " + getTelefonoCel()+" " + getNombreCalle().toUpperCase()+" " + 
                getNumeroCalle()+" " + getNombreCalle().toUpperCase() +" "+ getComunaID();        
                        
      }
}
