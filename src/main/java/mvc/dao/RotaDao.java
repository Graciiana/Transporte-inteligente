package mvc.dao;
import mvc.model.Rota;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RotaDao {

    Connection connec;
    public RotaDao(Connection connec){
        this.connec=connec;
    }
    public void cadastroRota(Rota rota) throws SQLException {
        String sql="INSERT INTO rota VALUES(?,?,?)";
        PreparedStatement ps=connec.prepareStatement(sql);
        ps.setLong(1, rota.getIdRota());
        ps.setString(2,rota.getOriegem());
        ps.setString(3,rota.getDestino());
        ps.close();
    }

    public void removerRota(long id)throws SQLException{
        String sql = "DELETE FROM rota where id_rota = ?";
        PreparedStatement ps = connec.prepareStatement(sql);
        ps.setLong(1, id);
        ps.executeUpdate();
        ps.close();
    }
}
