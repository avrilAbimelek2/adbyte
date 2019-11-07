
package DAO;

import POJO.Maestra;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;


public class GrupoDAO {
  
    public int crearGrupo(String nombreGrupo, int[] nino) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        String consulta = "CREATE VIEW "+nombreGrupo+" AS SELECT idNino, nombre FROM nino WHERE idNino IN (";
        try{
            if (nino.length > 1) {
                for (int i = 0; i < nino.length; i++) {
                    if (i == nino.length-1) {
                        consulta = consulta + nino[i];
                    } else {
                        consulta = consulta + nino[i] +",";
                    }
                }
                consulta = consulta + ")";
            } else {
                consulta = consulta + nino[0] +")";
            }
            System.out.println(consulta);
            con = Conexion.getConnection();
            st = con.prepareStatement(consulta);
            if (st.execute() == true) {
                System.out.println("Grupo creado con éxito");
            }
            return 1;
            } catch (Exception e) {
                System.out.println("Error al crear grupo " + e);
                    return 0;
                } finally {
                        Conexion.close(con);
                        Conexion.close(st);
                }
            }
        
    
    private static final String SQL_SELECT=" SHOW FULL TABLES  WHERE TABLE TYPE = 'VIEW'";
    
    public DefaultTableModel cargarModelo() throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        DefaultTableModel dt = null;
        String encabezados[]={"Nombre"};
        try{
            con = Conexion.getConnection();
            st = con.prepareStatement(SQL_SELECT);
            dt = new DefaultTableModel();
            dt.setColumnIdentifiers(encabezados);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                 Object ob[] = new Object[1];
                 ob[0] = rs.getString(1);
                 dt.addRow(ob);
            }
            rs.close();
        }catch(Exception e){
            System.out.println("Eror al cargar la tabla Grupos "+e);
        }finally{
            Conexion.close(con);
            Conexion.close(st);
        }
        return dt;
    }
    
    public DefaultTableModel cargarModeloNino(String grupo) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        DefaultTableModel dt = null;
        String encabezados[]={"ID", "Nombre"};
        try{
            con = Conexion.getConnection();
            st = con.prepareStatement("SELECT * FROM " +grupo);
            dt = new DefaultTableModel();
            dt.setColumnIdentifiers(encabezados);
            ResultSet rs = st.executeQuery();
            while(rs.next()){
                 Object ob[] = new Object[2];
                 ob[0] = rs.getString(1);
                 ob[1] = rs.getString(2);
                 dt.addRow(ob);
            }
            rs.close();
        }catch(Exception e){
            System.out.println("Eror al cargar los niños del grupo "+e);
        }finally{
            Conexion.close(con);
            Conexion.close(st);
        }
        return dt;
    }
    
     public  DefaultComboBoxModel cargarCombo() {
        Connection con = null;
        PreparedStatement st = null;
        DefaultComboBoxModel combo = null;
        try{
            con = Conexion.getConnection();
            combo = new DefaultComboBoxModel();
            st = con.prepareStatement("SHOW FULL TABLES  WHERE TABLE_TYPE = 'VIEW'");
            ResultSet rs = st.executeQuery();
            combo.addElement("Seleccione a su grupo");
            while(rs.next()){
                 combo.addElement(rs.getString(1));
            }
            rs.close();
        }catch(Exception e){
            System.out.println("Error al cargar combo Grupos"+e);
        }finally{
            Conexion.close(con);
            Conexion.close(st);
        }
        return combo;
    }
}
