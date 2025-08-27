package mvc.dao;

import mvc.model.Passageiro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PassageiroDao {
    Connection connec;

    public PassageiroDao(Connection connec){
        this.connec=connec;
    }

    public void cadastroPass(Passageiro pass) throws SQLException {
        String sql="INSERT INTO passageiros VALUES(?,?,?,?,?)";
        PreparedStatement ps=connec.prepareStatement(sql);
        ps.setLong(1, pass.getId());
        ps.setString(2, pass.getBilhete());
        ps.setString(3, pass.getNome());
        ps.setString(4, pass.getTelefone());
        ps.setFloat(5, pass.getSaldo());
        ps.close();
    }
}
