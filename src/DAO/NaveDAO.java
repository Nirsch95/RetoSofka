/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Conexion.Conectar;
import VO.NaveVO;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author felix
 */
public class NaveDAO {
    
    /*Metodo listar*/
        public ArrayList<NaveVO> Listar_NaveVO(){
        ArrayList<NaveVO> list = new ArrayList<NaveVO>();
        Conectar conec = new Conectar();
        String sql = "SELECT * FROM nave;";
        ResultSet rs = null;
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                NaveVO vo = new NaveVO();
                vo.setIdnave(rs.getInt(1));
                vo.setNombre(rs.getString(2));
                vo.setAltura(rs.getDouble(3));
                vo.setPeso(rs.getDouble(4));
                vo.setTipo(rs.getString(5));
                vo.setFini(rs.getDouble(6));
                vo.setFfin(rs.getString(7));
                vo.setFoto(rs.getBytes(8));
                list.add(vo);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                rs.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
        return list;
    }
        
/*Metodo agregar*/
    public void Agregar_NaveVO(NaveVO vo){
        Conectar conec = new Conectar();
        String sql = "INSERT INTO nave (idnave, nombre, altura, peso, tipo, fini, ffin,foto)\n" +
"VALUES (NULL,?,?,?,?,?,?,?);";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNombre());
            ps.setDouble(2, vo.getAltura());
            ps.setDouble(3, vo.getPeso());
            ps.setString(4, vo.getTipo());
            ps.setDouble(5, vo.getFini());
            ps.setString(6, vo.getFfin());
            ps.setBytes(7, vo.getFoto());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println("A "+ex.getMessage());
        }catch(Exception ex){
            System.out.println("B "+ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }
    
    /*Metodo Modificar*/
    public void Modificar_NaveVO(NaveVO vo){
        Conectar conec = new Conectar();
        String sql = "UPDATE nave SET nombre = ?, altura = ?, peso = ?, tipo = ?, fini = ?, ffin = ?, foto = ?\n" +
"WHERE idnave = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNombre());
            ps.setDouble(2, vo.getAltura());
            ps.setDouble(3, vo.getPeso());
            ps.setString(4, vo.getTipo());
            ps.setDouble(5, vo.getFini());
            ps.setString(6, vo.getFfin());
            ps.setBytes(7, vo.getFoto());
            ps.setInt(8, vo.getIdnave());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }
    
    public void Modificar_NaveVO2(NaveVO vo){
        Conectar conec = new Conectar();
        String sql = "UPDATE nave SET nombre = ?, altura = ?, peso = ?, tipo = ?, fini = ?, ffin = ?\n" +
"WHERE idnave = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setString(1, vo.getNombre());
            ps.setDouble(2, vo.getAltura());
            ps.setDouble(3, vo.getPeso());
            ps.setString(4, vo.getTipo());
            ps.setDouble(5, vo.getFini());
            ps.setString(6, vo.getFfin());
            ps.setInt(7, vo.getIdnave());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }
    
    /*Metodo Eliminar*/
    public void Eliminar_NaveVO(NaveVO vo){
        Conectar conec = new Conectar();
        String sql = "DELETE FROM nave WHERE idnave = ?;";
        PreparedStatement ps = null;
        try{
            ps = conec.getConnection().prepareStatement(sql);
            ps.setInt(1, vo.getIdnave());
            ps.executeUpdate();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }finally{
            try{
                ps.close();
                conec.desconectar();
            }catch(Exception ex){}
        }
    }
}
