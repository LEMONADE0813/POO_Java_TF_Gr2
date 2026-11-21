/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author jp
 */
public class Empleado implements Serializable{
    private String numeroIde;
    private String nombreComp;
    private String tituloProfesional;
    private byte aniosExperiencia;

    public Empleado(String numeroIde, String nombreComp, String tituloProfesional, byte aniosExperiencia) {
        this.numeroIde = numeroIde;
        this.nombreComp = nombreComp;
        this.tituloProfesional = tituloProfesional;
        this.aniosExperiencia = aniosExperiencia;
    }

    public String getNumeroIde() {
        return numeroIde;
    }

    public String getNombreComp() {
        return nombreComp;
    }

    public String getTituloProfesional() {
        return tituloProfesional;
    }

    public byte getAniosExperiencia() {
        return aniosExperiencia;
    }

    public void setNumeroIde(String numeroIde) {
        this.numeroIde = numeroIde;
    }

    public void setNombreComp(String nombreComp) {
        this.nombreComp = nombreComp;
    }

    public void setTituloProfesional(String tituloProfesional) {
        this.tituloProfesional = tituloProfesional;
    }

    public void setAniosExperiencia(byte aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }

    @Override
    public String toString() {
        return "Empleado{" + "numeroIdentificacion=" + numeroIde + ", nombreCompleto=" + nombreComp + ", tituloProfesional=" + tituloProfesional + ", aniosExperiencia=" + aniosExperiencia + '}';
    }
    
    
}
