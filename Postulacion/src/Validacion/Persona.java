/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validacion;

/**
 *
 * @author jag
 */
public class Persona extends Validator {
    
    private int codigo;
    private int rut;
    private char dv;
    private String fechaNac;
    private String primerNombre;
    private String segundoNombre;
    private String apellPaterno;
    private String apellMaterno;
    private String eMail;
    private int telefonoFijo;
    private int telefonoCel;
    private String nombreCalle;
    private String numeroCalle;
    private String NombrePoblacion;
    private int comunaID;

    public Persona( int rut, char dv, String fechaNac, String primerNombre, String segundoNombre, String apellPaterno, String apellMaterno, String eMail, int telefonoFijo, int telefonoCel, String nombreCalle, String numeroCalle, String NombrePoblacion, int comunaID) {
     
        this.rut = rut;
        this.dv = dv;
        this.fechaNac = fechaNac;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.apellPaterno = apellPaterno;
        this.apellMaterno = apellMaterno;
        this.eMail = eMail;
        this.telefonoFijo = telefonoFijo;
        this.telefonoCel = telefonoCel;
        this.nombreCalle = nombreCalle;
        this.numeroCalle = numeroCalle;
        this.NombrePoblacion = NombrePoblacion;
        this.comunaID = comunaID;
    }

    public Persona(int rut, char dv, String eMail, int telefonoFijo, int telefonoCel, String nombreCalle, String numeroCalle, String NombrePoblacion, int comunaID) {
        this.rut = rut;
        this.dv = dv;
        this.eMail = eMail;
        this.telefonoFijo = telefonoFijo;
        this.telefonoCel = telefonoCel;
        this.nombreCalle = nombreCalle;
        this.numeroCalle = numeroCalle;
        this.NombrePoblacion = NombrePoblacion;
        this.comunaID = comunaID;
    }

   
    
  
    public Persona(){
    }

    public String getNombreCalle() {
        return nombreCalle;
    }

    public void setNombreCalle(String nombreCalle) throws DatoIncorrectoException{
             int tomarPoscEsp;
            if(nombreCalle.trim().contains(" ")){
                // toma posicion de " "
                tomarPoscEsp = nombreCalle.indexOf(" ");
                // Se obtiene la primera palabra
                String primPalabra = nombreCalle.substring(0,tomarPoscEsp);
                // Se obtiene la segunda palabra
                String segPalabra = nombreCalle.substring(tomarPoscEsp);
                
                
            if(validarPriPalabra(primPalabra)||validarSoloLetrasYEspacio(segPalabra)){
               lanzarException( " No se acepta Numeros en la segunda palabra");
            }
         
           
           }else if(validarLargoPalabraObligatoria(nombreCalle,3)){
               lanzarException( "Debe ingresar tres letras como minimo");
           }else{
                 this.nombreCalle = nombreCalle;
           }
       
    }

    public String getNombrePoblacion() {
        return NombrePoblacion;
    }

    public void setNombrePoblacion(String nombrePoblacion)throws DatoIncorrectoException{
        if(nombrePoblacion.length() > 0){
        if( validarSoloLetrasYEspacio(nombrePoblacion)||validarLargoPalabraObligatoria(nombrePoblacion,3)){
            lanzarException("Se aceptan solo letras"+"\n Debe ingresar al menos tres letras");
        }else{
               this.NombrePoblacion = NombrePoblacion;
        }
        }
        
    }

    public String getApellMaterno() {
        return apellMaterno;
    }

    public void setApellMaterno(String apellMaterno) throws DatoIncorrectoException{
        
         if(validarLargoPalabraOpcional(apellMaterno)||validarSoloLetrasYEspacio(apellMaterno)){
               lanzarException("Como minimo tres letras para el nombre  \n NO ACEPTAN NUMEROS NI ESPACIOS");
            
       }else{
            this.apellMaterno = apellMaterno;
         }
      
    }

    public String getApellPaterno() {
        return apellPaterno;
    }

    public void setApellPaterno(String apellPaterno) throws DatoIncorrectoException{
        
          if(validarLargoPalabraObligatoria(apellPaterno,3)|| validarSoloLetrasYEspacio(apellPaterno)){
               lanzarException("Como minimo tres letras para el apellido \n NO ACEPTAN NUMEROS NI ESPACIOS");
            
       }else{
           this.apellPaterno = apellPaterno;
          }
     
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        
        this.codigo = codigo;
    }

    public int getComunaID() {
        return comunaID;
    }

    public void setComunaID(int comunaID) {
        this.comunaID = comunaID;
    }

    public char getDv() {
        return dv;
    }

    public void setDv(char dv){
       
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String dia,String mes,String anno)throws DatoIncorrectoException{
   
           String formato = dia +"/"+mes+"/"+anno;
            this.fechaNac = formato;
            System.out.println(formato);
        
        
    }

    public String getNumeroCalle() {
        return numeroCalle;
    }

    public void setNumeroCalle(String numeroCalle) throws DatoIncorrectoException{
      if(numeroCalle.length()==0 || numeroCalle.equals(null)){
        lanzarException("debe ingresar un numero o sino 0" );
      }else{
         this.numeroCalle = numeroCalle;
      }
    }

    public String getPrimerNombre() {
        
        
        return primerNombre;
    }

    public void setPrimerNombre(String priNombre)throws DatoIncorrectoException{
              if(validarLargoPalabraObligatoria(priNombre,3)|| validarSoloLetrasYEspacio(priNombre)){
               lanzarException("Como minimo tres letras para el nombre \n NO SE ACEPTAN NUMEROS NI ESPACIOS" );
              }else{
               this.primerNombre = priNombre;
        }
    }

    public int getRut() {
        return rut;
    }
    
 public void setRut(int rut) throws DatoIncorrectoException {
        String contarDig = String.valueOf(rut);
    if (contarDig.length()==7 || contarDig.length()== 8) {
            this.rut = rut;
        } else {

          lanzarException( " Debe ingresar 8 digitos para rut");

        }

    }
    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre)throws DatoIncorrectoException{
           if(validarLargoPalabraOpcional(segundoNombre)||validarSoloLetrasYEspacio(segundoNombre)){
               lanzarException("Como minimo tres letras para el nombre  \n NO SE ACEPTAN NUMEROS NI ESPACIOS");
            
           }else{
                 this.segundoNombre = segundoNombre;
        }
    }

    public int getTelefonoCel() {
        return telefonoCel;
    }

    public void setTelefonoCel(int telefonoCel)throws DatoIncorrectoException{
        
           String validarTelCelu = String.valueOf(telefonoCel);
        if(validarTelCelu.length() == 8){
           
            this.telefonoCel = telefonoCel;
        } else{
          lanzarException(" Debe ingresar solo 8 numeros al campo telefono celular");
        }
       
    }

    public int getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(int telefonoFijo)throws DatoIncorrectoException{
        String validaTelFijo = String.valueOf(telefonoFijo);
        if(validaTelFijo.length() ==7){
          this.telefonoFijo = telefonoFijo;
        } else{
              lanzarException("Debe ingresar solo 7 numeros al campo telefono fijo");
        }
    }

   
    
      
  
   
   
    
}
