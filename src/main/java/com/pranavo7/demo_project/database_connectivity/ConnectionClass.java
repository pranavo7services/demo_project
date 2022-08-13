/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pranavo7.demo_project.database_connectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author macbookpro2014
 */
public class ConnectionClass {
    private static ConnectionClass single_instance = null;
    public Connection connection;

    private ConnectionClass() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/demoproject", "root", "");
            if (connection != null) {
                System.out.println("connected");

                String statement = "CREATE TABLE IF NOT EXISTS users(id INT NOT NULL AUTO_INCREMENT, "
                        + "name VARCHAR(255),"
                        + "email VARCHAR(255), "
                        + "password VARCHAR(255), "
                        + "address VARCHAR(255), "
                        + "role INT, "
                        + "PRIMARY KEY(id))";
                PreparedStatement preparedStatement = connection.prepareStatement(statement);
                preparedStatement.execute();
            }

        } catch (SQLException ex) {
            Logger.getLogger(ConnectionClass.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ConnectionClass getInstance() {
        if (single_instance == null) {
            single_instance = new ConnectionClass();
        }
        return single_instance;
    }
}
