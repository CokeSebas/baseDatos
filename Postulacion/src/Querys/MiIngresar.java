/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Querys;

import java.util.ArrayList;

/**
 *
 * @author jag
 */
public class MiIngresar {
    ArrayList <String>NombreTabla = new ArrayList();
    ArrayList<String>NombreColumnaTabla = new ArrayList();
    ArrayList ValoresAInsertar = new ArrayList();
     
    public String llenarArraListNombreTabla(int posicionNombreTabla){
       NombreTabla.add(" proveedor ");
       NombreTabla.add(" cliente ");
       NombreTabla.add(" vendedor ");
       NombreTabla.add(" producto ");
        
       
       return NombreTabla.get(posicionNombreTabla);
       
    }
     public void llenarArraListNombColumTabla(String nombreColumna,String value){
       NombreColumnaTabla.add(nombreColumna);
       ValoresAInsertar.add(value); 
    }
    
     public String MostrarDatosArraListNombColumTabla(String tomarNombreTabla){
      String sqlInserCli ;
      String tomarColumnas = "";
      String tomarValue = "";
         
     for(String columnas : NombreColumnaTabla){
         tomarColumnas = tomarColumnas + columnas;
         System.out.println(columnas);
     }
      for(Object value :  ValoresAInsertar){
          tomarValue = tomarValue + value;
         System.out.println(value);
     }
      sqlInserCli = "Insert into " + tomarNombreTabla +" ( " + tomarColumnas +" ) "+
              " values (" + tomarValue + ")";
         System.out.println(sqlInserCli);
         
         return sqlInserCli; 
              
}
}
