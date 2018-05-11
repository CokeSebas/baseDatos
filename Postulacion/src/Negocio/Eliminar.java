/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import BDConexion.Conexion;
//import Interfaz.Principal;
import java.sql.SQLException;

/**
 *
 * @author pc
 */
public class Eliminar {
    static Conexion conec;
    
    public static void eliminarProveedor(String codigo)throws SQLException{
        try{
            conec.query("DELETE FROM PROVEEDOR WHERE CODIGO_PROVEEDOR = '"+codigo+"'");
    
        }catch(SQLException ex){
        //Principal.setMessage(1, ex.getMessage());
          
  }
 }
    
    public static void eliminarProducto(String codigo)throws SQLException{
        try{
            conec.query("DELETE FROM PRODUCTO WHERE CODIGO_PRODUCTO = '"+codigo+"'");
        
        }catch(SQLException ex){
        //Principal.setMessage(1, ex.getMessage());
    }
}
    public static void eliminarCliente(String codigo, String rut_cli)throws SQLException{
        try{
            conec.query("DELETE FROM CLIENTE WHERE RUT_CLIENTE = '"+rut_cli+"'");
            conec.query("DELETE FROM CLIENTE WHERE CODIGO_CLIENTE = '"+codigo+"'");
            
        
        }catch(SQLException ex){
        //Principal.setMessage(1, ex.getMessage());
    
    }
}
    public static void eliminarUsuario(String codigo, String rut_usu)throws SQLException{
        try{
            conec.query("DELETE FROM VENDEDOR WHERE RUT_VENDEDOR = '"+rut_usu+"' ");
            conec.query("DELETE FROM VENDEDOR WHERE CODIGO_VENDEDOR = '"+codigo+"' ");
    
   }catch(SQLException ex){
        //Principal.setMessage(1, ex.getMessage());
   }
  }
}

