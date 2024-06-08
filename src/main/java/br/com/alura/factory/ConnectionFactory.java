package br.com.alura.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection realizarConexao(){
        try{
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/comex?user=&password="
            );
            return conn;
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }
}
