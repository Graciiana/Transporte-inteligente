package mvc.dao;

import mvc.model.Preco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PrecoDao {
    private Connection connection;

    public PrecoDao(Connection connection){
        this.connection = connection;
    }

    public List<Preco> listarPreco() throws SQLException {
        String sql = "SELECT * FROM preco";
        Statement stm = connection.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        List<Preco> preco = new ArrayList<>();

        while (rs.next()){
            Preco pr = new Preco(rs.getLong("idPreco"), rs.getLong("preco"));
            preco.add(pr);
        }
        stm.close();
        rs.close();
        return preco;
    }
}
