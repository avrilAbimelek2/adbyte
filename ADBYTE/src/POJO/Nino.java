/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJO;

import java.sql.Date;



/**
 *
 * @author Avril
 */
public class Nino {
    
   private int idnino ;
   private String nombre;
   private String apellido;
   private String sexo;
   private Date fecha_ingreso;
   private Date fecha_nac;
   private String enfermedad;
   private int tutor_idtutor;
   private int maestra_idmaestra;


    public Nino() {
    }

    public Nino(int idnino, String nombre, String apellido, String sexo, Date fecha_ingreso, Date fecha_nac, String enfermedad, int tutor_idtutor, int maestra_idmaestra) {
        this.idnino = idnino;
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_nac = fecha_nac;
        this.enfermedad = enfermedad;
        this.tutor_idtutor = tutor_idtutor;
        this.maestra_idmaestra = maestra_idmaestra;
   
    }

    public Nino(String nombre, String apellido, String sexo, Date fecha_ingreso, Date fecha_nac, String enfermedad, int tutor_idtutor, int maestra_idmaestra) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.fecha_ingreso = fecha_ingreso;
        this.fecha_nac = fecha_nac;
        this.enfermedad = enfermedad;
        this.tutor_idtutor = tutor_idtutor;
        this.maestra_idmaestra = maestra_idmaestra;
      
    }

    public Nino(String nombre, String apellido, String sexo, java.util.Date fec, java.util.Date fecnac, String enf, int tut, int mat) {
      this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.fecha_ingreso = (Date) fec;
        this.fecha_nac = (Date) fecnac;
        this.enfermedad = enf;
        this.tutor_idtutor = tut;
        this.maestra_idmaestra = mat;
    }

  
public Nino(int id,String nombre, String apellido, String sexo, java.util.Date fec, java.util.Date fecnac, String enf, int tut, int mat) {
 this.idnino = id;
    this.nombre = nombre;
        this.apellido = apellido;
        this.sexo = sexo;
        this.fecha_ingreso = (Date) fec;
        this.fecha_nac = (Date) fecnac;
        this.enfermedad = enf;
        this.tutor_idtutor = tut;
        this.maestra_idmaestra = mat;
    }
    

   


  

    

   
   
    public int getIdnino() {
        return idnino;
    }

    public void setIdnino(int id) {
        this.idnino = id;
    }

   

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public Date getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Date fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public int getTutor_idtutor() {
        return tutor_idtutor;
    }

    public void setTutor_idtutor(int tutor_idtutor) {
        this.tutor_idtutor = tutor_idtutor;
    }

    public int getMaestra_idmaestra() {
        return maestra_idmaestra;
    }

    public void setMaestra_idmaestra(int maestra_idmaestra) {
        this.maestra_idmaestra = maestra_idmaestra;
    }

    

   

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
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
