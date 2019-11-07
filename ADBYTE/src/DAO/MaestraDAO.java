/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Maestra;
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
public class MaestraDAO {
     public boolean eliminar(int id) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("CALL eliminarM(?)");
            st.setInt(1, id);
            int num = st.executeUpdate();
            if (num == 0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar Maestro: " + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }
    public  DefaultComboBoxModel cargarCombo() {
        Connection con = null;
        PreparedStatement st = null;
        DefaultComboBoxModel combo = null;
        try{
            con = Conexion.getConnection();
            combo = new DefaultComboBoxModel();
            st = con.prepareStatement("CALL  select_all_maestra");
            ResultSet rs = st.executeQuery();
            combo.addElement("Seleccionar Maestro");
            while(rs.next()){
                 Maestra  maestro = inflaPOJO(rs);
                 combo.addElement(maestro);
            }
        }catch(Exception e){
            System.out.println("Error al cargar combo Maestro");
        }finally{
            Conexion.close(con);
            Conexion.close(st);
        }
        return combo;
    }
    public boolean modificar(Maestra pojo){
        Connection con = null;
        PreparedStatement st = null;
        Maestra alumno = pojo;
        try{
            con = Conexion.getConnection();
            st = con.prepareStatement("CALL modificarMaestra(?,?,?)");
            st.setInt(1, alumno.getIdMestra());
            st.setString(2, alumno.getNombre());
            st.setString(3, alumno.getApellidos());

            
            int x = st.executeUpdate();
            if (x==0) {
                return false;
            }
        }catch(Exception e){
            System.out.println("Error al actualizar Maestra" + e);
        }finally{
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }
         public Maestra consultar(int id) {
        Connection con = null;
        PreparedStatement st = null;
        Maestra pojo = new Maestra();
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("CALL seleccionar_Maestra(?)");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pojo = inflaPOJO(rs);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar Maestra" + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return pojo;
    }
     public int insertar(Maestra ma) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        int id = 0;
        try{
            con = Conexion.getConnection(); 
            st = con.prepareStatement("call insert_maestra(?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, ma.getNombre());
            st.setString(2, ma.getApellidos());
            
           
           
            
            id = st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        }catch(Exception e){
            System.out.println("Eror al insertar maestra ->" + e);
        }finally{
            Conexion.close(con);
            Conexion.close(st);
        }
        return id;
    }
     
      public DefaultTableModel cargarModelo()  {
        Connection con = null;
        PreparedStatement st = null;
        DefaultTableModel dt = null;
        String encabezados[] = {"ID","Nombre", "apellido"};
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("CALL  select_all_maestra");
            dt = new DefaultTableModel();
            dt.setColumnIdentifiers(encabezados);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[3];
                Maestra pojo = inflaPOJO(rs);
                ob[0] = rs.getInt("idMestra");
                ob[1] = rs.getString("nombre");
                ob[2] = rs.getString("apellidos");
                
                dt.addRow(ob);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al cargar la tabla Maestros " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return dt;
    }
      private static Maestra inflaPOJO(ResultSet rs){
        
        Maestra pojo = new Maestra();
        try {
            pojo.setIdMestra(rs.getInt("idMestra"));
            pojo.setNombre(rs.getString("nombre"));
            pojo.setApellidos(rs.getString("apellidos"));
       
            
           
            
            
        } catch (SQLException ex) {
            System.out.println("Error al inflar pojo Maestro " + ex);
        }
        return pojo;
    }
}
