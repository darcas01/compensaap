package com.darwuich.compensapp.compensapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Compensapp {
    public static void main(String[] args) {
        String usuario = "root";
        String password = "";
        String url = "jdbc:mysql://localhost:3306/citas_medicas"; // Cambié la URL para usar jdbc:mysql
        Connection conexion;
        Statement statement;
        ResultSet rs;

        try {
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement(); // Cambié "Statement" a "statement"
            rs = statement.executeQuery("SELECT * FROM paciente");
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
            
            //insercion de datos
            statement.execute("INSERT INTO `paciente` (`idPaciente`, `nombre`, `direccion`, `telefono`, `email`) VALUES (NULL, 'MQuesada', NULL, NULL, NULL);");
            System.out.println("");
             rs = statement.executeQuery("SELECT * FROM paciente");
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
            
            //Actualizacion de datos
             statement.execute("UPDATE `paciente` SET `nombre` = 'Jmakanaki' WHERE `paciente`.`idPaciente` = 1;");
            System.out.println("");
             rs = statement.executeQuery("SELECT * FROM paciente");
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
            
            //Borrado o Eliminacion de datos
             statement.execute("DELETE FROM paciente WHERE `paciente`.`idPaciente` = 2");
            System.out.println("");
             rs = statement.executeQuery("SELECT * FROM paciente");
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Compensapp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}