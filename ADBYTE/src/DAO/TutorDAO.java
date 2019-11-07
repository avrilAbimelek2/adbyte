/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


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
public class TutorDAO {
     
 public boolean eliminar(int id) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("CALL eliminarT(?)");
            st.setInt(1, id);
            int num = st.executeUpdate();
            if (num == 0) {
                return false;
            }
        } catch (Exception e) {
            System.out.println("Error al eliminar Tutor: " + e);
            return false;
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }
public boolean modificar(Tutor pojo){
        Connection con = null;
        PreparedStatement st = null;
        Tutor alumno = pojo;
        try{
            con = Conexion.getConnection();
            st = con.prepareStatement("CALL modificarTutor(?,?,?,?,?)");
            st.setInt(1, alumno.getIdTutor());
            st.setString(2, alumno.getNombre());
            st.setString(3, alumno.getApellidos());
            st.setString(5, alumno.getTelefono());
            st.setString(4, alumno.getDireccion());
            
            int x = st.executeUpdate();
            if (x==0) {
                return false;
            }
        }catch(Exception e){
            System.out.println("Error al actualizar Tutor" + e);
        }finally{
            Conexion.close(con);
            Conexion.close(st);
        }
        return true;
    }
         public Tutor consultar(int id) {
        Connection con = null;
        PreparedStatement st = null;
        Tutor pojo = new Tutor();
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("CALL seleccionar_tutor(?)");
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                pojo = inflaPOJO(rs);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar Tutor " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return pojo;
    }

    public DefaultComboBoxModel loadCombo() throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        DefaultComboBoxModel dt = null;
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("CALL  select_all_tutor");
            dt = new DefaultComboBoxModel();
            ResultSet rs = st.executeQuery();
            dt.addElement("Seleccione a su Tutor");
            while (rs.next()) {
                Tutor pojo = inflaPOJO(rs);
                dt.addElement(pojo);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al cargar el modelo Tutor" + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return dt;
    }
     public int insertar(Tutor tutor) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        int id = 0;
        try{
            con = Conexion.getConnection(); 
            st = con.prepareStatement("call insert_tutor(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, tutor.getNombre());
            st.setString(2, tutor.getApellidos());
            st.setString(3, tutor.getDireccion());
            st.setString(4, tutor.getTelefono());
            
            
            id = st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        }catch(Exception e){
            System.out.println("Eror al insertar Tutor ->" + e);
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
        String encabezados[] = {"ID","Nombre", "Apellido", "Dirección","Telefono"};
        try {
            con = Conexion.getConnection();
            st = con.prepareStatement("CALL  select_all_tutor");
            dt = new DefaultTableModel();
            dt.setColumnIdentifiers(encabezados);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object ob[] = new Object[5];
                Tutor pojo = inflaPOJO(rs);
                ob[0] = rs.getInt("idTutor");
                ob[1] = rs.getString("nombre");
                ob[2] = rs.getString("apellidos");
                ob[3] = rs.getString("direccion");
                ob[4] = rs.getString("telefono");
                
                dt.addRow(ob);
            }
            rs.close();
        } catch (Exception e) {
            System.out.println("Error al cargar la tabla Tutor " + e);
        } finally {
            Conexion.close(con);
            Conexion.close(st);
        }
        return dt;
    }
      private static Tutor inflaPOJO(ResultSet rs){
        
        Tutor pojo = new Tutor();
        try {
            pojo.setIdTutor(rs.getInt("idTutor"));
            pojo.setNombre(rs.getString("nombre"));
            pojo.setApellidos(rs.getString("apellidos"));
            pojo.setDireccion(rs.getString("direccion"));
            pojo.setTelefono(rs.getString("telefono"));
            
            
           
            
            
        } catch (SQLException ex) {
            System.out.println("Error al inflar pojo Tutor " + ex);
        }
        return pojo;
    }
}
