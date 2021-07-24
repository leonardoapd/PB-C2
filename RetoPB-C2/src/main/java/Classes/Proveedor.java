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
public class Proveedor extends DatosBasicos {
    
    //Se crean los atributos
    private int idProveedor;

    //Se crea el constructor
    public Proveedor(String nombre, String direccion, String telefono, String correo, String ciudad, String departamento, String tipoDocumento, int nroDocumento, int idProveedor) {
        super(nombre, direccion, telefono, correo, ciudad, departamento, tipoDocumento, nroDocumento);
        this.idProveedor = idProveedor;
    }

    //Se crean los get y los set
    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    
}
