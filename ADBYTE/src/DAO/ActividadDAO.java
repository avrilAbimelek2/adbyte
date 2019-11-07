/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Actividad;
import POJO.Tutor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Avril
 */
public class ActividadDAO {
 public boolean eliminar(int id) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("CALL eliminarA(?)");
            st.setInt(1, id);
            int num = st.executeUpdate();
            if (num == 0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar Actividad: " + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }
   public boolean modificar(Actividad pojo){
        Connection con = null;
        PreparedStatement st = null;
        Actividad alumno = pojo;
        try{
            con = Conexion.getConnection();
            st = con.prepareStatement("CALL modificarAct(?,?,?,?,?)");
            st.setInt(1, alumno.getIdActividad());
            st.setString(4, alumno.getNombre());
            st.setString(5, alumno.getDescripcion());
            st.setTime(2, alumno.getHora());
            st.setTime(3, alumno.getTiempo());
            
            int x = st.executeUpdate();
            if (x==0) {
                return false;
            }
        }catch(Exception e){
            System.out.println("Error al actualizar Actividad" + e);
        }finally{
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }
         public Actividad consultar(int id) {
        Connection con = null;
        PreparedStatement st = null;
        Actividad pojo = new Actividad();
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("CALL seleccionar_act(?)");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pojo = inflaPOJO(rs);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar Actividad " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return pojo;
    }

     public int insertar(Actividad act) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        int id = 0;
        try{
            con = Conexion.getConnection(); 
            st = con.prepareStatement("call insert_actividad(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            st.setTime(1, act.getHora());
            st.setTime(2, act.getTiempo());
            st.setString(3, act.getNombre());
            st.setString(4, act.getDescripcion());
           
            
            id = st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        }catch(Exception e){
            System.out.println("Eror al insertar ACTIVIDAD ->" + e);
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
        String encabezados[] = {"ID","Hora", "Tiempo", "Nombre","Descripcion"};
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("CALL  select_all_actividad");
            dt = new DefaultTableModel();
            dt.setColumnIdentifiers(encabezados);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[5];
                Actividad pojo = inflaPOJO(rs);
                ob[0] = rs.getInt("idActividad");
                ob[1] = rs.getTime("Hora");
                ob[2] = rs.getTime("Tiempo");
                ob[3] = rs.getString("Nombre");
                ob[4] = rs.getString("Descripcion");
                
                
                dt.addRow(ob);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al cargar la tabla Actividad " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return dt;
    }
      private static Actividad inflaPOJO(ResultSet rs){
        
        Actividad pojo = new Actividad();
        try {
            pojo.setIdActividad(rs.getInt("idActividad"));
            pojo.setHora(rs.getTime("hora"));
            pojo.setTiempo(rs.getTime("tiempo"));
            pojo.setNombre(rs.getString("nombre"));
            pojo.setDescripcion(rs.getString("descripcion"));
            
            
           
            
            
        } catch (SQLException ex) {
            System.out.println("Error al inflar pojo Actividad " + ex);
        }
        return pojo;
    }
}
