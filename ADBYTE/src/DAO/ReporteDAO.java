/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Nino;
import POJO.Reporte;
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
public class ReporteDAO {
    
     public int insertar(Reporte rep) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        int id = 0;
        try{
            con = Conexion.getConnection(); 
            st = con.prepareStatement("call insert_reporte(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, rep.getTipo());
            st.setString(2, rep.getDetalle());
            st.setString(3, rep.getRecomendacion());
            st.setInt(4, rep.getNino_idnino());
            
            id = st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        }catch(Exception e){
            System.out.println("Eror al insertar Reporte ->" + e);
        }finally{
            Conexion.close(con);
            Conexion.close(st);
        }
        return id;
    }
     
     
         public DefaultTableModel cargarModelo() throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        DefaultTableModel dt = null;
        String encabezados[] = {"ID Niño","Tipo", "Detalle", "Recomendacion","Fecha"};
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("CALL  select_all_reporte");
            dt = new DefaultTableModel();
            dt.setColumnIdentifiers(encabezados);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[5];
                Reporte pojo = inflaPOJO(rs);
                ob[0] = rs.getInt("nino_idnino");
                ob[1] = rs.getString("tipo");
                ob[2] = rs.getString("detalle");
                ob[3] = rs.getString("recomendacion");
                ob[4] = rs.getTimestamp("fecha");
                
                dt.addRow(ob);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al cargar la tabla REPORTE " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return dt;
    }
         
      private static Reporte inflaPOJO(ResultSet rs){
        
        Reporte pojo = new Reporte();
        try {
            pojo.setIdReporte(rs.getInt("idReporte"));
            pojo.setTipo(rs.getString("tipo"));
            pojo.setDetalle(rs.getString("detalle"));
            pojo.setRecomendacion(rs.getString("recomendacion"));
            pojo.setNino_idnino(rs.getInt("nino_idnino"));
            
            
            
           
            
            
        } catch (SQLException ex) {
            System.out.println("Error al inflar pojo Reporte " + ex);
        }
        return pojo;
    }

   
     
}
