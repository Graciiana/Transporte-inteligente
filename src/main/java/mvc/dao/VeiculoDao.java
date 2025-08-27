package mvc.dao;

import mvc.model.Passageiro;
import mvc.model.Veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VeiculoDao {

    Connection connec;

    public VeiculoDao(Connection connec){
        this.connec=connec;
    }

    public void carrega(Veiculo vei) throws SQLException {
        String sql="INSERT INTO passageiros VALUES(?,?,?,?)";
        PreparedStatement ps=connec.prepareStatement(sql);
        ps.setLong(1, vei.getIdVeiculo());
        ps.setString(2, vei.getTipoVeiculo());
        ps.setLong(3, vei.getCapacidade());
        ps.setString(4, vei.getMatricula());
        ps.close();
    }
}
