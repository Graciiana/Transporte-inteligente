package mvc.dao;

import mvc.model.Passageiro;
import mvc.model.Rota;
import mvc.model.Veiculo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VeiculoDao {

    Connection connec;

    public VeiculoDao(Connection connec){
        this.connec=connec;
    }

    public void carrega(Veiculo vei) throws SQLException {
        String sql="INSERT INTO passageiros VALUES(?,?,?,?,?)";
        PreparedStatement ps=connec.prepareStatement(sql);
        ps.setLong(1, vei.getIdVeiculo());
        ps.setString(2, vei.getTipoVeiculo());
        ps.setLong(3, vei.getCapacidade());
        ps.setString(4, vei.getMatricula());
        ps.close();
    }

    public List<Veiculo> lista() throws SQLException{
        List<Veiculo> veiculos = new ArrayList<>();
        String sql = "SELECT * FROM rota";
        Statement stm = connec.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()){
           Veiculo veiculo = new Veiculo(
                    rs.getLong("id"),
                    rs.getString("tipo"),
                    rs.getLong("capacidade"),
                    rs.getString("matricula")
            );
            veiculos.add(veiculo);
        }
        stm.close();
        rs.close();
        return veiculos;
    }
    public void removerVeiculo(long id)throws SQLException{
        String sql = "DELETE FROM veiculos where id = ?";
        PreparedStatement ps = connec.prepareStatement(sql);
        ps.setLong(1, id);
        ps.executeUpdate();
        ps.close();
    }
}
