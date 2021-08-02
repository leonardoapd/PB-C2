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
public class Vendedor extends DatosBasicos {

    //Se crean los atributos de la clase
    private int cantidadVentas, idVendedor;
    private double totalVenta;
    private Venta venta;

    //Se crea el constructor de la clase
    public Vendedor(String nombre, String direccion, String telefono, String correo,
            String ciudad, String departamento, String tipoDocumento, int nroDocumento,
            int idVendedor) {
        super(nombre, direccion, telefono, correo, ciudad, departamento, tipoDocumento, nroDocumento);
        this.cantidadVentas = 0;
        this.idVendedor = idVendedor;
        this.totalVenta = 0;
    }

    
    public void crear(String nombre, String direccion, String telefono, String correo, 
            String ciudad, String departamento, String tipoDocumento, int nroDocumento, int idVendedor) {
        this.crear(nombre, direccion, telefono, correo, ciudad, departamento,
                tipoDocumento, nroDocumento);
        this.idVendedor = idVendedor;
    }

    
    public void actualizar(String nombre, String direccion, String telefono, String correo,
            String ciudad, String departamento, String tipoDocumento, int nroDocumento, int idVendedor) {
        this.actualizar(nombre, direccion, telefono, correo, ciudad, departamento, 
                tipoDocumento, nroDocumento);
        this.idVendedor = idVendedor;
    }
    
    @Override
    public void eliminar() {
    }

    //Se crean los metodos de la clase
    public void darBonificacion() {
        /*
        Bonificacion que brinda un 5% del valor total de sus ventas
        realizadas en el mes.
         */
        this.venta = new Venta();

        this.totalVenta = ((venta.getValorTotal() * getCantidadVentas()) * 0.05);
        System.out.printf("Se ha dado una bonificacion de %f a %s", (totalVenta * 0.05), getNombre());
    }

    public void registrarVenta() {
        this.cantidadVentas += 1;
    }

    @Override
    public void cambiarMes() {
        this.totalVenta = 0;
    }

    @Override
    public String toString() {
        return "Nombre: " + getNombre() + " - "
                + "Direccion: " + getDireccion() + " - "
                + "Telefono: " + getTelefono() + " - "
                + "Correo: " + getCorreo() + " - "
                + "Ciudad: " + getCiudad() + " - "
                + "Departamento: " + getDepartamento() + " - "
                + "Id: " + getIdVendedor()+ " - "
                + "Documento: " + getNroDocumento();
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
