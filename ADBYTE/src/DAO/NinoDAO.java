/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import POJO.Nino;
import POJO.Tutor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Avril
 */
public class NinoDAO {
    
    public static DefaultComboBoxModel cargarCombo() {
        Connection con = null;
        PreparedStatement st = null;
        DefaultComboBoxModel combo = null;
        try{
            con = Conexion.getConnection();
            combo = new DefaultComboBoxModel();
            st = con.prepareStatement("Select * from Nino");
            ResultSet rs = st.executeQuery();
            combo.addElement("Seleccionar Niño");
            while(rs.next()){
                 Nino  nino = inflaPOJO(rs);
                 combo.addElement(nino);
            }
        }catch(Exception e){
            System.out.println("Error al cargar combo niño");
        }finally{
            Conexion.close(con);
            Conexion.close(st);
        }
        return combo;
    }
     public DefaultComboBoxModel loadCombo() throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        DefaultComboBoxModel dt = null;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("CALL  select_all_nino");
            dt = new DefaultComboBoxModel();
            ResultSet rs = st.executeQuery();
            dt.addElement("Niño");
            while (rs.next()) {
                Nino pojo = inflaPOJO(rs);
                dt.addElement(pojo);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al cargar el modelo Niño" + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return dt;
    }
      public boolean eliminar(int id) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("CALL eliminarN(?)");
            st.setInt(1, id);
            int num = st.executeUpdate();
            if (num == 0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar Niño: " + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }
     public int insertar(Nino nino) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        int id = 0;
        try{
            con = Conexion.getConnection(); 
            st = con.prepareStatement("call insert_nino(?,?,?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, nino.getNombre());
            st.setString(2, nino.getApellido());
            st.setString(3, nino.getSexo());
            st.setDate(4, nino.getFecha_ingreso());
            st.setDate(5, nino.getFecha_nac());
            st.setString(6, nino.getEnfermedad());
            st.setInt(7, nino.getTutor_idtutor());
            st.setInt(8, nino.getMaestra_idmaestra());
           
            
            id = st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        }catch(Exception e){
            System.out.println("Eror al insertar Niño ->" + e);
        }finally{
            Conexion.close(con);
            Conexion.close(st);
        }
        return id;
    }
     
    public DefaultTableModel cargarModelo() {
        Connection con = null;
        PreparedStatement st = null;
        DefaultTableModel dt = null;
        String encabezados[] = {"ID","Nombre","Apellido", "Sexo", "Ingreso","Nacimiento","Enfermedad"};
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("CALL  select_all_nino");
            dt = new DefaultTableModel();
            dt.setColumnIdentifiers(encabezados);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[7];
                Nino pojo = inflaPOJO(rs);
                ob[0] = rs.getInt("idNino");
                ob[1] = rs.getString("nombre");
                ob[2] = rs.getString("apellido");
                ob[3] = rs.getString("sexo");
                ob[4] = rs.getDate("fecha_ingreso");
                ob[5] = rs.getDate("fecha_nac");
                ob[6] = rs.getString("enfermedad");
                dt.addRow(ob);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al cargar la tabla Niños " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return dt;
    }
     public DefaultTableModel cargarModelo2()  {
        Connection con = null;
        PreparedStatement st = null;
        DefaultTableModel dt = null;
        String encabezados[] = {"ID","Nombre"};
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("CALL  select_all_nino");
            dt = new DefaultTableModel();
            dt.setColumnIdentifiers(encabezados);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[2];
                Nino pojo = inflaPOJO(rs);
                ob[0] = rs.getInt("idNino");
                ob[1] = rs.getString("nombre");
                
                dt.addRow(ob);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al cargar la tabla Niños " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return dt;
    }
    
        public boolean modificar(Nino pojo){
        Connection con = null;
        PreparedStatement st = null;
        Nino alumno = pojo;
        try{
            con = Conexion.getConnection();
            st = con.prepareStatement("CALL modificarNino(?,?,?,?,?,?,?,?,?)");
            st.setInt(1, alumno.getIdnino());
            st.setString(2, alumno.getNombre());
            st.setString(3, alumno.getApellido());
            st.setString(4, alumno.getSexo());
            st.setDate(5, alumno.getFecha_ingreso());
            st.setDate(6, alumno.getFecha_nac());
            st.setString(7, alumno.getEnfermedad());
            st.setInt(8, alumno.getTutor_idtutor());
            st.setInt(9, alumno.getMaestra_idmaestra());
            int x = st.executeUpdate();
            if (x==0) {
                return false;
            }
        }catch(Exception e){
            System.out.println("Error al actualizar Nino" + e);
        }finally{
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }
         public Nino consultar(int id) {
        Connection con = null;
        PreparedStatement st = null;
        Nino pojo = new Nino();
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("CALL seleccionar_nino(?)");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pojo = inflaPOJO(rs);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar Niño " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return pojo;
    }
      private static Nino inflaPOJO(ResultSet rs){
        
        Nino pojo = new Nino();
        try {
            pojo.setIdnino(rs.getInt("idNino"));
            pojo.setNombre(rs.getString("nombre"));
            pojo.setApellido(rs.getString("apellido"));
            pojo.setSexo(rs.getString("sexo"));
            pojo.setFecha_ingreso(rs.getDate("fecha_ingreso"));
            pojo.setFecha_nac(rs.getDate("fecha_nac"));
            pojo.setEnfermedad(rs.getString("enfermedad"));
            pojo.setTutor_idtutor(rs.getInt("tutor_idtutor"));
            pojo.setMaestra_idmaestra(rs.getInt("maestra_idmaestra"));
           
            
           
            
            
        } catch (SQLException ex) {
            System.out.println("Error al inflar pojo Niño " + ex);
        }
        return pojo;
    }
    
}
