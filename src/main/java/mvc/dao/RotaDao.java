package mvc.dao;
import mvc.model.Rota;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public List<Rota> lista() throws SQLException{
        List<Rota> rotas = new ArrayList<>();
        String sql = "SELECT * FROM rota";
        Statement stm = connec.createStatement();
        ResultSet rs = stm.executeQuery(sql);

        while (rs.next()){
            Rota rt = new Rota(
                    rs.getLong("id_rota"),
                    rs.getString("origem"),
                    rs.getString("destino")
            );
            rotas.add(rt);
        }
        stm.close();
        rs.close();
        return rotas;
    }

    public void removerRota(long id)throws SQLException{
        String sql = "DELETE FROM rota where id_rota = ?";
        PreparedStatement ps = connec.prepareStatement(sql);
        ps.setLong(1, id);
        ps.executeUpdate();
        ps.close();
    }
}
