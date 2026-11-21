/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author jposp
 */
public final class PersonaNatural extends Cliente implements Serializable{
    private String numeroTelefono;
    private String correo;

    public PersonaNatural(String numeroTelefono, String correo, String numeroIdentificacion, String nombre, String nombreCiudad) {
        super(numeroIdentificacion, nombre, nombreCiudad);
        this.numeroTelefono = numeroTelefono;
        this.correo = correo;
    }

    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "PersonaNatural{"
                + super.toString() + " ,"
                + "numeroTelefono="
                + numeroTelefono 
                + ", correoElectronico="
                + correo 
                + '}';
    }
 

    
 
    
}
