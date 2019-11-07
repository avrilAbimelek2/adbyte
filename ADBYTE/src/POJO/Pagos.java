/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.sql.Timestamp;
import java.time.Year;

/**
 *
 * @author Avril
 */
public class Pagos {
    
    private int idPagos;
    private String tipo_pag;
    private String Mes_de_pago;
    private Timestamp Fehca_de_pago;
    private double monto;
    private double descuento;
    private int tutor_idtutor;
    private double total;
    

    public Pagos() {
    }

    public Pagos(int idPagos, String tipo_pag, String Mes_de_pago, Timestamp Fehca_de_pago, double monto, double descuento, int tutor_idtutor, double total) {
        this.idPagos = idPagos;
        this.tipo_pag = tipo_pag;
        this.Mes_de_pago = Mes_de_pago;
        this.Fehca_de_pago = Fehca_de_pago;
        this.monto = monto;
        this.descuento = descuento;
        this.tutor_idtutor = tutor_idtutor;
        this.total = total;
    }
    
    public Pagos(String tipo_pag, String Mes_de_pago, Timestamp Fehca_de_pago, double monto, double descuento, int tutor_idtutor, double total) {
        
        this.tipo_pag = tipo_pag;
        this.Mes_de_pago = Mes_de_pago;
        this.Fehca_de_pago = Fehca_de_pago;
        this.monto = monto;
        this.descuento = descuento;
        this.tutor_idtutor = tutor_idtutor;
        this.total = total;
    }

    
    
    
    /**
     * @return the idPagos
     */
    public int getIdPagos() {
        return idPagos;
    }

    /**
     * @param idPagos the idPagos to set
     */
    public void setIdPagos(int idPagos) {
        this.idPagos = idPagos;
    }

    /**
     * @return the tipo_pag
     */
    public String getTipo_pag() {
        return tipo_pag;
    }

    /**
     * @param tipo_pag the tipo_pag to set
     */
    public void setTipo_pag(String tipo_pag) {
        this.tipo_pag = tipo_pag;
    }

    /**
     * @return the Mes_de_pago
     */
    public String getMes_de_pago() {
        return Mes_de_pago;
    }

    /**
     * @param Mes_de_pago the Mes_de_pago to set
     */
    public void setMes_de_pago(String Mes_de_pago) {
        this.Mes_de_pago = Mes_de_pago;
    }

    /**
     * @return the Fehca_de_pago
     */
    public Timestamp getFehca_de_pago() {
        return Fehca_de_pago;
    }

    /**
     * @param Fehca_de_pago the Fehca_de_pago to set
     */
    public void setFehca_de_pago(Timestamp Fehca_de_pago) {
        this.Fehca_de_pago = Fehca_de_pago;
    }

    /**
     * @return the monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * @return the descuento
     */
    public double getDescuento() {
        return descuento;
    }

    /**
     * @param descuento the descuento to set
     */
    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    /**
     * @return the tutor_idtutor
     */
    public int getTutor_idtutor() {
        return tutor_idtutor;
    }

    /**
     * @param tutor_idtutor the tutor_idtutor to set
     */
    public void setTutor_idtutor(int tutor_idtutor) {
        this.tutor_idtutor = tutor_idtutor;
    }

    /**
     * @return the total
     */
    public double getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(double total) {
        this.total = total;
    }

    
    
    
    
}
