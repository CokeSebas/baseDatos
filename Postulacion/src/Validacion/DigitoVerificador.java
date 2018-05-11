/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validacion;

import Validacion.DatoIncorrectoException;

/**
 *
 * @author jag
 */
public class DigitoVerificador {
     private int rut;
     private String digVeriFinal;
     private boolean  rutIncorrecto = false;

    public boolean isRutIncorrecto() {
        return rutIncorrecto;
    }

   

    public String getDigVeriFinal() {
        return digVeriFinal;
    }

    public void setDigVeriFinal(String digVeriFinal) {
        this.digVeriFinal = digVeriFinal;
    }

    
     
  
  public DigitoVerificador(){
      
    }

    public DigitoVerificador(int rut, String digVeriFinal) {
        setRut(rut);
        setDigVeriFinal(digVeriFinal);
        
    }
  
   
  public void setRut(int rut){
        this.rut = rut;
  }
  
  public void digitoVeri(){
        String tranfRutStr = String.valueOf(rut);
        int tomarLargo =  tranfRutStr.length();
        int modulo11 = 11;
        int tomarDigiRut = rut;
        int cortarRut =  rut;
        int DigParaMultip = 2;
        int resultado = 0;
        int sumarCuocientes = 0 ;
      while(tomarLargo > 0){
         tomarDigiRut = cortarRut  % 10;
         resultado = tomarDigiRut * DigParaMultip;
         sumarCuocientes =   sumarCuocientes + resultado;
         cortarRut = cortarRut / 10;
         tomarLargo = tomarLargo - 1;
         System.out.println( tomarDigiRut + " * " + DigParaMultip + " = " +  resultado);
         if (DigParaMultip <= 6){
         DigParaMultip = DigParaMultip + 1;
        }else{
        DigParaMultip = 2;
        }
     }
     System.out.println(sumarCuocientes);
     int sacarModulaSumaTotal = sumarCuocientes % modulo11;
     System.out.println(sacarModulaSumaTotal);
     int obtenerDigito = modulo11 - sacarModulaSumaTotal;
     System.out.println(obtenerDigito);
     if(obtenerDigito == 10){
         System.out.println("Su digito verificador =  K "  );
         digVeriFinal = "k";
        }else if (obtenerDigito == 11){
        System.out.println("Su digito verificador =  0 "  );
        digVeriFinal = "0";
        }else{
         System.out.println("Su digito verificador = " +  obtenerDigito );
         digVeriFinal = String.valueOf(obtenerDigito);
        }
}
  
 public void validarRut(String validaDig)throws DatoIncorrectoException{
     
      if(digVeriFinal.equals(validaDig)){
          System.out.println("Su rut es correcto");
      
      }else{
           String mensaje = " Su digito verificador no es correcto";
            throw new DatoIncorrectoException(mensaje);
      
          
           
      }
      }
}
