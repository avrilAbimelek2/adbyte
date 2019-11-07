/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Horario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Avril
 */
public class HorarioDAO {
     public int insertar(Horario hora) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        int id = 0;
        try{
            con = Conexion.getConnection(); 
            st = con.prepareStatement("call insert_horario(?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, hora.getTurno());
            st.setTime(2, hora.getEntrada());
            st.setTime(3, hora.getSalida());
           
           
            
            id = st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        }catch(Exception e){
            System.out.println("Eror al insertar horario ->" + e);
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
        String encabezados[] = {"ID", "Turno", "Entrada","Salida"};
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("CALL  select_all_horarios");
            dt = new DefaultTableModel();
            dt.setColumnIdentifiers(encabezados);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[4];
                Horario pojo = inflaPOJO(rs);
                ob[0] = rs.getInt("idHorario");
                ob[1] = rs.getString("turno");
                ob[2] = rs.getInt("entrada");
                ob[3] = rs.getInt("salida");
                dt.addRow(ob);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al cargar la tabla Horarios " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return dt;
    }
      private static Horario inflaPOJO(ResultSet rs){
        
        Horario pojo = new Horario();
        try {
            pojo.setIdHorario(rs.getInt("idHorario"));
            pojo.setTurno(rs.getString("turno"));
            pojo.setEntrada(rs.getTime("entrada"));
            pojo.setSalida(rs.getTime("salida"));
            
           
            
            
        } catch (SQLException ex) {
            System.out.println("Error al inflar pojo Horario " + ex);
        }
        return pojo;
    }
    
}
