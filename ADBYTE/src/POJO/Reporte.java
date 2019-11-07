/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.sql.Timestamp;

/**
 *
 * @author Avril
 */
public class Reporte {
    
    private int idReporte;
    private String tipo;
    private String detalle;
    private String recomendacion;
    private int nino_idnino;
    private Timestamp fecha;

    public Reporte() {
    }

    public Reporte(int idReporte, String tipo, String detalle, String recomendacion, int nino_idnino, Timestamp fecha) {
        this.idReporte = idReporte;
        this.tipo = tipo;
        this.detalle = detalle;
        this.recomendacion = recomendacion;
        this.nino_idnino = nino_idnino;
        this.fecha = fecha;
    }

    public Reporte(String tipo, String detalle, String recomendacion, int nino_idnino) {
        this.tipo = tipo;
        this.detalle = detalle;
        this.recomendacion = recomendacion;
        this.nino_idnino = nino_idnino;
        
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public int getIdReporte() {
        return idReporte;
    }

    public void setIdReporte(int idReporte) {
        this.idReporte = idReporte;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }

    public int getNino_idnino() {
        return nino_idnino;
    }

    public void setNino_idnino(int nino_idnino) {
        this.nino_idnino = nino_idnino;
    }
    
}
