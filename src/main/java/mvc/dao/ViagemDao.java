package mvc.dao;

import jdk.jfr.Percentage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ViagemDao {
        Connection connection;
        public ViagemDao(Connection connection){
            this.connection=connection;
        }

        public void inserirViagens(long idPassageiro, long idRota, long idVeiculo)throws SQLException{
            String sql="INSERT INTO viagens (id_passageiro, id_veiculo, idRota) VALUES(?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setLong(1, idPassageiro);
            ps.setLong(2,idVeiculo);
            ps.setLong(3, idRota);
            ps.executeUpdate();
            ps.close();
        }

    public List<String> listarViagens() throws SQLException {
        String sql =
                "-- Passageiros que têm viagens\n" +
                        "SELECT p.nome, ve.tipo, r.origem, r.destino, p.preco\n" +
                        "FROM passageiros AS p\n" +
                        "LEFT JOIN viagens AS v ON v.id_passageiro = p.idPassageiro\n" +
                        "LEFT JOIN rota AS r ON v.idRota = r.id_rota\n" +
                        "LEFT JOIN veiculos AS ve ON v.id_veiculo = ve.id\n" +
                        "LEFT JOIN preco AS pr ON v.id_preco = pr.idPreco\n" +
                        "\n" +
                        "UNION\n" +
                        "\n" +
                        "-- Passageiros sem viagens\n" +
                        "SELECT p.nome, NULL AS tipo, NULL AS origem, NULL AS destino\n" +
                        "FROM passageiros AS p\n" +
                        "WHERE p.idPassageiro NOT IN (SELECT id_passageiro FROM viagens)\n" +
                        "\n" +
                        "ORDER BY nome ASC";

        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        List<String> dados = new ArrayList<>();
        while (rs.next()) {
            dados.add("Passageiro: " + rs.getString("nome") +
                    " | Veículo: " + rs.getString("tipo") +
                    " | Origem: " + rs.getString("origem") +
                    " | Destino: " + rs.getString("destino"));
        }

        rs.close();
        ps.close();
        return dados;
    }

}



