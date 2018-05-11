/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validacion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Validator {
    
    private boolean verdadEmail;
    private boolean verdadFecha;

        private String correo;
        private String fecha ;

    public boolean isVerdadEmail() {
        return verdadEmail;
    }

    public boolean isVerdadFecha() {
        return verdadFecha;
    }

    //metodo para validar si la fecha es correcta
    public void isDate(String fechax) {
       verdadFecha= true;
        try {
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
            Date fecha1 = formatoFecha.parse(fechax);
        } catch (Exception e) {
            verdadFecha = false;
        }
        
      
    }

    //metodo para validar correo electronio
    public void isEmail(String correo)throws DatoIncorrectoException{
       
      
        Pattern pat = null;
        Matcher mat = null;        
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]"
                + "*[0-9a-zA-Z])+(.[a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
     
        mat = pat.matcher(correo);
        if (mat.find()) {
            System.out.println("[" + mat.group() + "]");
            verdadEmail = true;
        }else{
          String mensaje = "el correo no es correcto";
          throw new DatoIncorrectoException(mensaje);
           //verdadEmail = false;
    }
      }
    
     public boolean validarSoloLetrasYEspacio(String letras){
           boolean verdad = false;
        for(int i = 0;i < 10;i++){
        if(letras.trim().contains(String.valueOf(i))||letras.trim().contains(" ")){
            verdad = true;
        
        }
    
    }
           return verdad;
    }
   
    public boolean validarSoloNumero(String letras){
           boolean verdad = false;
        for(int i = 0;i < 10;i++){
        if(letras.trim().contains(String.valueOf(i))){
            verdad = true;
        
        }
    
    }
           return verdad;
    }
   
   
   public boolean validarLargoPalabraObligatoria(String palabra,int largoValida){
       boolean verdad = false;
   
       if( palabra.trim().length() < largoValida){
           //  lanzarException("Debe tener mas de dos selabas");
          verdad = true;
   }
      
       return verdad;
   }
    
      public boolean validarLargoPalabraOpcional(String palabra){
       boolean verdad = false;
         if( palabra.trim().length() >= 1 && palabra.trim().length() < 3){
          verdad = true;
   }
       return verdad;
   }
      
   public boolean validarPriPalabra(String primPalabra)throws DatoIncorrectoException{
       boolean verdad = false;    
       if( primPalabra.length()== 1){
                  if ( !validarSoloNumero(primPalabra)){
                     lanzarException("Si la primera palabra tiene una silaba,SE ACEPTA SOLO NUMEROS");
                     verdad = true; 
                 }
                 }else if(primPalabra.length()==2){
                     System.out.println("--------------"+primPalabra);
                            String  primCarac = primPalabra.substring(0,1);
                              System.out.println("--------------"+primCarac);
                             String  segCarac  = primPalabra.substring(1);
                                System.out.println("--------------"+segCarac);
               
                              if(!( validarSoloNumero(primCarac))||!(validarSoloNumero(segCarac))){
                                      lanzarException("Si la primera palabra tiene dos silabas,SE ACEPTA SOLO NUMEROS");
                                      verdad = true; 
                                }
           }else if(primPalabra.length() >= 3){
               if(validarSoloLetrasYEspacio(primPalabra)){
                lanzarException("La palabra tiene tres silabas, YA NO ACEPTA NUMEROS");
                  verdad = true;
               }
           }
       return verdad;
   
   }
   

   
   public void lanzarException(String mensaje)throws DatoIncorrectoException{
        
            throw new DatoIncorrectoException(mensaje);
   }
        
   public boolean NumerosMayorACero(int numero){
           
           boolean verdad = false;
           if(numero < 0){
            verdad = true;
           }
           return verdad;
       }
                
    }
    
    
   
       


    


