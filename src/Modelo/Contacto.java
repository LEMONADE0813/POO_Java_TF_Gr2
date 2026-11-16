package Modelo;

import java.io.Serializable;

/**
 *
 * @author Juan Carreño
 */
public class Contacto implements Serializable {

    private String nombreCompleto;
    private String cargo;
    private String telefono;
    private String correoElectronico;

    public Contacto(String nombreCompleto, String cargo, String telefono, String correoElectronico) {
        this.nombreCompleto = nombreCompleto;
        this.cargo = cargo;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    @Override
    public String toString() {
        return "Contacto{" + "nombreCompleto=" + nombreCompleto + ", cargo=" + cargo + ", telefono=" + telefono + ", correoElectronico=" + correoElectronico + '}';
    }
}