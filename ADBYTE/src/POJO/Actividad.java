/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.sql.Time;

/**
 *
 * @author Avril
 */
public class Actividad {
    
    private int idActividad;
    private Time hora;
    private Time tiempo;
    private String nombre;
    private String descripcion;

    public Actividad() {
    }

    public Actividad(int idActividad, Time hora, Time tiempo, String nombre, String descripcion) {
        this.idActividad = idActividad;
        this.hora = hora;
        this.tiempo = tiempo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Actividad(Time hora, Time tiempo, String nombre, String descripcion) {
        this.hora = hora;
        this.tiempo = tiempo;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

   
    
   
    
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public int getIdActividad() {
        return idActividad;
    }

    public void setIdActividad(int idActividad) {
        this.idActividad = idActividad;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Time getTiempo() {
        return tiempo;
    }

    public void setTiempo(Time tiempo) {
        this.tiempo = tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
