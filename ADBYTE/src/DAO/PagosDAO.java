/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import POJO.Pagos;
import POJO.Reporte;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;

/**
 *
 * @author Avril
 */
public class PagosDAO {

     
     public int insertar(Pagos rep) throws SQLException {
        Connection con = null;
        PreparedStatement st = null;
        int id = 0;
        try{
            con = Conexion.getConnection(); 
            st = con.prepareStatement("call insert_pagos(?,?,?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
            st.setString(1, rep.getTipo_pag());
            st.setString(2, rep.getMes_de_pago());
            st.setDouble(3, rep.getMonto());
            st.setDouble(4, rep.getDescuento());
            st.setInt(5, rep.getTutor_idtutor());
            st.setDouble(6, rep.getTotal());
            
            
            id = st.executeUpdate();
            ResultSet rs = st.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
        }catch(Exception e){
            System.out.println("Eror al insertar Pago ->" + e);
        }finally{
            Conexion.close(con);
            Conexion.close(st);
        }
        return id;
    }
     
     
       private static Pagos inflaPOJO(ResultSet rs){
        
        Pagos pojo = new Pagos();
        try {
            pojo.setIdPagos(rs.getInt("idPagos"));
            pojo.setTipo_pag(rs.getString("tipo"));
            pojo.setMes_de_pago(rs.getString("mes_pago"));
            pojo.setMonto(rs.getDouble("monto"));
            pojo.setDescuento(rs.getDouble("Descuento"));
            pojo.setTutor_idtutor(rs.getInt("Tutor"));
            pojo.setTotal(rs.getDouble("Total"));
            
            
            
           
            
            
        } catch (SQLException ex) {
            System.out.println("Error al inflar pojo Reporte " + ex);
        }
        return pojo;
    }

   
     


     
    
    
    
}
