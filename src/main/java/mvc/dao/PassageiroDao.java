package mvc.dao;

import mvc.model.Passageiro;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassageiroDao {
    Connection connec;

    public PassageiroDao(Connection connec){
        this.connec=connec;
    }

    public void cadastroPass(Passageiro pass) throws SQLException {
        String sql="INSERT INTO passageiros VALUES(?,?,?,?)";
        PreparedStatement ps=connec.prepareStatement(sql);
        ps.setLong(1, pass.getId());
        ps.setString(3, pass.getNome());
        ps.setString(4, pass.getTelefone());
        ps.setFloat(5, pass.getSaldo());
        ps.executeUpdate();
        ps.close();
    }

    public void removerPass(long id)throws SQLException{
        String sql = "DELETE FROM passageiros where idPassageiro = ?";
        PreparedStatement ps = connec.prepareStatement(sql);
        ps.setLong(1, id);
        ps.executeUpdate();
        ps.close();
    }

    public List<Passageiro> lista() throws SQLException{
        List<Passageiro> passageiros = new ArrayList<>();
        String sql = "SELECT * FROM passageiros";
        Statement stm = connec.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()){
            Passageiro passageiro1 = new Passageiro(
                    rs.getLong("idPassageiro"),
                    rs.getString("nome"),
                    rs.getString("telefone"),
                    rs.getFloat("saldo"));
            passageiros.add(passageiro1);
        }
        stm.close();
        rs.close();
        return passageiros;
    }
}
