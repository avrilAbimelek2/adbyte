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
public class Horario {
    private int idHorario;
    private String turno;
    private Time entrada;
    private Time salida;

    public Horario() {
    }

    public Horario(int idHorario, String turno, Time entrada, Time salida) {
        this.idHorario = idHorario;
        this.turno = turno;
        this.entrada = entrada;
        this.salida = salida;
    }

    public Horario(String turno, Time entrada, Time salida) {
        this.turno = turno;
        this.entrada = entrada;
        this.salida = salida;
    }

    public Time getSalida() {
        return salida;
    }

    public void setSalida(Time salida) {
        this.salida = salida;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Time getEntrada() {
        return entrada;
    }

    public void setEntrada(Time entrada) {
        this.entrada = entrada;
    }
    
    
}
