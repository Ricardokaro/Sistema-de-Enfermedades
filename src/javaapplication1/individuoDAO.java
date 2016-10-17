/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Ricardo
 */
public class individuoDAO {
    String msg;
    boolean lError;
    private db conexion;
    public db getConexion() {
        return conexion;
    }
    public void setConexion(db conexion) {
        this.conexion = conexion;
    }
    public individuoDAO(db conexion) {
        this.setConexion(conexion);
    }
    
    public boolean insert(Individuo i) throws SQLException {
        //Insertar en el Sistema de Base de Datos
        boolean result = false;
        String sql = "insert into individuos (error_patron,R00,R01,R02,R03,R10,R11,R12,R13,R20,R21,R22,R23,"
                    +"R30,R31,R32,R33,R40,R41,R42,R43,R50,R51,R52,R53,R60,R61,R62,R63) values (?,?,?,?,?,?,"
                + "?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
        pst.setDouble(1, i.getErrorPatron());       
            int t=2;
            for (int j = 0; j < 7; j++) {
                for (int k = 0; k < 4; k++) {
                    System.out.println(i.getMatriz()[j][k]);
                    pst.setDouble(t, i.getMatriz()[j][k]);
                    t++;                    
                }
            }
          
        if (pst.executeUpdate() > 0) {
            conexion.Commit();
            result = true;
        }
        return result;
    }

    public ArrayList<Individuo> getRecords() throws SQLException {
        ArrayList<Individuo> lst = new ArrayList<Individuo>();
        Individuo i =null;
        String sql = "select * from individuos ";
        ResultSet rs = conexion.Query(sql);
        while (rs.next()) {
            i = MapearObjeto(rs);
            lst.add(i);
        }
        rs.close();
        return lst;
    }

    public Individuo getPk(String id) throws SQLException {
        Individuo i=null;
        String sql = "select * from individuos where id=? ";
        java.sql.PreparedStatement pst = conexion.getConnection().prepareStatement(sql);
        pst.setString(1, id);
        ResultSet rs = conexion.Query(pst);
        lError = true;
        if (rs.next()) {
           i = MapearObjeto(rs);
            lError = false;
        }
        rs.close();
        return i;
    }   

    private Individuo MapearObjeto(ResultSet rs) throws SQLException {
        double vect[][] = new double[7][4];  
        Individuo i = new Individuo();
        i.setErrorPatron(rs.getDouble("error_patron"));
        
        for (int j = 0; j < 7; j++) {
            for (int k = 0; k < 4; k++) {                
                vect[j][k] = rs.getDouble("R"+String.valueOf(j)+String.valueOf(k));
            }
        }
        
        i.setMatriz(vect);
    
        return i;
    }
}
