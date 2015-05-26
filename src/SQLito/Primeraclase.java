/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQLito;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author sbenavidesvazquez
 */
public class Primeraclase {

    Connection con = null;
    Statement s = null;

    public Connection conectar() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/Colegio", "root", "root");
            System.out.println("CONECTADO");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return con;
    }

    public void insertar(String[] al) {
        try {
            s = con.createStatement();            
            /*
            String id = JOptionPane.showInputDialog("id");
            String nom = JOptionPane.showInputDialog("nombre");
            String ape = JOptionPane.showInputDialog("apellido");
            */
            int id = Integer.parseInt(al[0]);
            System.out.println(id);
            String nom = al[1];
            System.out.println(nom);
            String ape = al[2];
            System.out.println(ape);
            //consulta
            s.executeUpdate("insert into app.alumnos values(" + id + ",'" + nom + "','" + ape + "')");
            System.out.println("Insercion realizada");
            s.close();
        } catch (Exception e) {
            System.out.println("Error de insercion--->"+e);
        }
    }

    public void visualizar() {
        try {
            s = con.createStatement();
            ResultSet r = s.executeQuery("select * from APP.ALUMNOS");

            while (r.next()) {
                System.out.println(r.getInt("id") + ", " + r.getString("nombre") + " " + r.getString("apellido")); 
            }
            r.close();

        } catch (Exception e) {
            System.out.println("ERROR ---> " + e);
        }
    }
    
    public void borrar(){
        try {
            s = con.createStatement();
            int id=Integer.parseInt(JOptionPane.showInputDialog("ID"));
            s.execute("delete from app.alumnos where id="+id);
            
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }
    
    public void Modificar(){
        try {
            s = con.createStatement();
            int id=Integer.parseInt(JOptionPane.showInputDialog("ID que quieres modificar"));
            String nom=JOptionPane.showInputDialog("Nombre nuevo");
            String ape=JOptionPane.showInputDialog("Apellido nuevo");
            s.execute("update app.alumnos set nombre='"+nom+"',apellido='"+ape+"'where id="+id);
            
        } catch (Exception e) {
            System.out.println("Error:"+e);
        }
    }
}
