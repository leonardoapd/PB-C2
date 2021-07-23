/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

//Librerias para obtener la fecha actual
import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

/**
 *
 * @author Leonardo Perdomo
 */
public class Cliente extends DatosBasicos{
    
    //Se crean los atributos de la clase
    private String fechaNacimiento;
    private int idCliente, cantidadCompras;
    private boolean fidelizacion, estadoCliente;
    
    //Se crea el constructor de la clase
    public Cliente(String fechaNacimiento, int idCliente, int cantidadCompras, 
            String nombre, String direccion, String telefono, String correo,
            String ciudad, String departamento, String tipoDocumento, int nroDocumento) {
        super(nombre, direccion, telefono, correo, ciudad, departamento, tipoDocumento, nroDocumento);
        this.fechaNacimiento = fechaNacimiento;
        this.idCliente = idCliente;
        this.cantidadCompras = cantidadCompras;
    }
    
    //Se crean los metodos de la clase
    public void aplicarFidelizacion() {
        //Se obtiene el mes actual
        Month mes = LocalDate.now().getMonth();

        //Se obtiene el nombre del mes
        String nombre = mes.getDisplayName(TextStyle.FULL, new Locale("es", "ES")).toLowerCase();
        
        /*Si la cantidad de compras ha alcanzado las 100 unidades y el cliente cumple años se aplica la
        fidelizacion.
        */
        if ((this.cantidadCompras >= 100) && (this.fechaNacimiento.toLowerCase().contains(nombre))) {
            this.fidelizacion = true;
        }
    }

    public void registrarCompra() {
        this.cantidadCompras++;
    }
    
    @Override
    public void eliminar() {
        this.estadoCliente = false;
    }

    //Se crean los get y set de los atributos
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getCantidadCompras() {
        return cantidadCompras;
    }

    public void setCantidadCompras(int cantidadCompras) {
        this.cantidadCompras = cantidadCompras;
    }

    public boolean isFidelizacion() {
        return fidelizacion;
    }

    public void setFidelizacion(boolean fidelizacion) {
        this.fidelizacion = fidelizacion;
    }

    public boolean isEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(boolean estadoCliente) {
        this.estadoCliente = estadoCliente;
    }
    
}
