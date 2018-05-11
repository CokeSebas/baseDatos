/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Validacion;

import BDConexion.Conexion;

/**
 *
 * @author jag
 */
public class Producto  extends Validator {
    private String nombreProducto;
    private int precioCosto;
    private int porcGanancia;
    private int precioVenta;
    private int precio1;  
    private int precio2;
    private int stock;
    private int cantidadMinima;
    private int codigoProveedor;
    private String Descripcion;
    
     public Producto(){
     }

    public Producto(String nombreProducto, int precioCosto, int porcGanancia, 
            int precioVenta, int precio1, int precio2, int stock, int cantidadMinima,
            int codigoProveedor, String Descripcion) {
        this.nombreProducto = nombreProducto;
        this.precioCosto = precioCosto;
        this.porcGanancia = porcGanancia;
        this.precioVenta = precioVenta;
        this.precio1 = precio1;
        this.precio2 = precio2;
        this.stock = stock;
        this.cantidadMinima = cantidadMinima;
        this.codigoProveedor = codigoProveedor;
        this.Descripcion = Descripcion;
    }

    @Override
    public String toString() {
        return "Producto{" + "nombreProducto=" + nombreProducto + ", precioCosto=" +
                precioCosto + ", porcGanancia=" + porcGanancia + ", precioVenta=" + 
                precioVenta + ", precio1=" + precio1 + ", precio2=" + precio2 +
                ", stock=" + stock + ", cantidadMinima=" + cantidadMinima + 
                ", codigoProveedor=" + codigoProveedor + ", Descripcion=" + Descripcion + '}';
    }


    
    

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion)throws DatoIncorrectoException{
        
         if(validarLargoPalabraObligatoria(Descripcion,10)){
             lanzarException("Debe ingresar 10 caracteres como minimo");
        }else{
        this.Descripcion = Descripcion;
        }
       
    }

    public int getCantidadMinima() {
        
        return cantidadMinima;
    }

    public void setCantidadMinima(int cantidadMinima)throws DatoIncorrectoException{
        
        if((cantidadMinima > stock) || NumerosMayorACero(cantidadMinima) ){
            lanzarException("Cantidad minima debe ser mayor a 0 y  menor a Stock");
        }else{
        this.cantidadMinima = cantidadMinima;
        }
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto)throws DatoIncorrectoException{
        
        if(validarLargoPalabraObligatoria(nombreProducto,3)){
             lanzarException("Debe ingresar 3 caracteres como minimo");
        }else{
        this.nombreProducto = nombreProducto;
        }
    }

    public int getPorcGanancia() {
        return porcGanancia;
    }

    public void setPorcGanancia(int porcGanancia) {
        this.porcGanancia = porcGanancia;
    }

    public int getPrecio1() {
        return precio1;
    }

    public void setPrecio1(int precio1)throws DatoIncorrectoException{
          
           
           if((precio1 < precioVenta ) && !NumerosMayorACero(precio1) ){
            this.precio1 = precio1;
        }
         else{
        lanzarException("Precio2 debe ser mayor a 0 \n menor a Precio Venta  \n y No se aceptan Letras");
    
         }
    }

    public int getPrecio2() {
        return precio2;
    }

    public void setPrecio2(int precio2) throws DatoIncorrectoException{
       
           
           if((precio2 < precioVenta ) && !NumerosMayorACero(precio2) ){
            this.precio2 = precio2;
        }
         else{
        lanzarException("Precio2 debe ser mayor a 0 \n menor a Precio Venta  \n y No se aceptan Letras");
    
         }
    }
    

    public int getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(int precioCosto)throws DatoIncorrectoException{
         if( NumerosMayorACero(precioCosto) ){
            lanzarException("PrecioCosto debe ser mayor a 0 \n No se aceptan numeros");
         }
        this.precioCosto = precioCosto;
    }

    public int getPrecioVenta() {
        return precioVenta;
    }

   public void setPrecioVenta(){
     this.precioVenta = precioCosto + (precioCosto * porcGanancia / 100);
   }
    public int getStock() {
        return stock;
    }

    public void setStock(int stock)throws DatoIncorrectoException{
          if( NumerosMayorACero(stock) ){
            lanzarException("Stock debe ser mayor a 0 ");
         }else{
        this.stock = stock;
          }
    }

    public int getCodigoProveedor() {
        return codigoProveedor;
    }

    public void setCodigoProveedor(int codigoProveedor) {
        this.codigoProveedor = codigoProveedor;
    }
    
   
     public void insertarProveedor()throws DatoIncorrectoException{
        
           try{
              
           String insertarProducto = "Insert into producto(codigo_producto,nombre_producto,descripcion_producto"
                   + ",precio_costo,precio_venta,precio1,precio2,"
                   + "cant_en_stock,cantidad_minima,codigo_proveedor) "
                + " values ( Cod_Prod.NextVal,'"+
                   getNombreProducto().toUpperCase()+"','"+getDescripcion().toUpperCase()+"',"+getPrecioCosto()+
                ","+getPrecioVenta()+","+getPrecio1()+","+getPrecio2() +","+
                   getStock()+","+getCantidadMinima()+","+getCodigoProveedor()+")";
         
       
                    Conexion.query(insertarProducto);
          }catch(Exception ex){
             
          }
       
       }
}
