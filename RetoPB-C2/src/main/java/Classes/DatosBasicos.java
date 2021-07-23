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
public class DatosBasicos {
    //Se crean los atributos de la clase
    private String nombre, direccion, telefono, correo,
            ciudad, departamento, tipoDocumento;

    private int nroDocumento;

    //Se crea el constructor de la clase
    public DatosBasicos(String nombre, String direccion, String telefono, 
            String correo, String ciudad, String departamento,
            String tipoDocumento, int nroDocumento) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
    }
    
    //Se crean los metodos
    public void crear(String nombre, String direccion, String telefono,
            String correo, String ciudad, String departamento, String tipoDocumento,
            String fechaNacimiento, int nroDocumento, int idCliente,
            int cantidadCompras, boolean fidelizacion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;
    }

    public void modificar(String nombre, String direccion, String telefono,
            String correo, String ciudad, String departamento, String tipoDocumento,
            String fechaNacimiento, int nroDocumento, int idCliente,
            int cantidadCompras, boolean fidelizacion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.tipoDocumento = tipoDocumento;
        this.nroDocumento = nroDocumento;

    }

    public void eliminar() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public int getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(int nroDocumento) {
        this.nroDocumento = nroDocumento;
    }
        
}
