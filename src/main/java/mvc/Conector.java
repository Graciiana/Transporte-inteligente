package mvc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
    Connection conn=null;
    public Connection conection() throws SQLException {

        String url="jdbc:mysql://localhost:3306/transporte_inteligente";
        String user="graciana";
        String pass="Graciana#2025a";

        try {
            conn = DriverManager.getConnection(url, user, pass);
            if (conn!=null){
                System.out.println("Conexao feita com sucesso!");
            }
            else {
                System.out.println("Falha ao conectar.");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return conn;

    }
}
