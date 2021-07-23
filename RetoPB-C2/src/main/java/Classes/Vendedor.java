/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author Leonardo Perdomo
 */
public class Vendedor extends DatosBasicos{
    
    //Se crean los atributos de la clase
    private int cantidadVentas, idVendedor;
    //private Venta venta = new Venta();
    
    //Se crea el constructor de la clase
    public Vendedor(String nombre, String direccion, String telefono, String correo,
            String ciudad, String departamento, String tipoDocumento, int nroDocumento,
            int cantidadVentas, int idVendedor) {
        super(nombre, direccion, telefono, correo, ciudad, departamento, tipoDocumento, nroDocumento);
        this.cantidadVentas = cantidadVentas;
        this.idVendedor = idVendedor;
    }
    
    //Se crean los metodos de la clase
    public void darBonificacion() {
        /*
        Bonificacion que brinda un 5% del valor total de sus ventas
        realizadas en el mes.
        */
        //TODO
        
    }
    
    public void registrarVenta() {
        this.cantidadVentas += 1;
    }

    //Se crean los get y los set
    public int getCantidadVentas() {
        return cantidadVentas;
    }

    public void setCantidadVentas(int cantidadVentas) {
        this.cantidadVentas = cantidadVentas;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }
   
}
