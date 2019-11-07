/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

/**
 *
 * @author Avril
 */
public class Maestra {
    private int idMestra;
    private String nombre;
    private String apellidos;

    public Maestra() {
    }

    public Maestra(int idMestra, String nombre, String apellidos) {
        this.idMestra = idMestra;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Maestra(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getIdMestra() {
        return idMestra;
    }

    public void setIdMestra(int idMestra) {
        this.idMestra = idMestra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     @Override
    public String toString() {
        return getNombre();
    }
}
