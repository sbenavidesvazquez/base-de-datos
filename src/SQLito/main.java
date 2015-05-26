/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SQLito;

import java.sql.SQLException;

/**
 *
 * @author sbenavidesvazquez
 */
public class main {
    public static void main(String[] args) throws SQLException {
    Primeraclase bd = new Primeraclase();
    Inicio in=new Inicio();
    
    bd.conectar();
    bd.visualizar();
    in.setVisible(true);
    }
}