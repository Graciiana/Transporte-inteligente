package mvc.dao;

import jdk.jfr.Percentage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

        public void listarViagens()throws SQLException {
            String sql = "SELECT p.nome, ve.tipo, r.origem, r.destino " +
                    "FROM viagens AS v " +
                    "JOIN passageiros AS p ON v.id_passageiro = p.idPassageiro " +
                    "JOIN rota AS r ON v.idRota = r.id_rota " +
                    "JOIN veiculos AS ve ON v.id_veiculo = ve.id ORDER BY p.nome ASC" ;

            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            boolean achou=false;
            while (rs.next()){
                achou=true;
                String nome = rs.getString("nome");
                String tipoVeiculo= rs.getString("tipo");
                String origemRota = rs.getString("origem");
                String destinoRota = rs.getString("destino");

                System.out.println("Passageiro: "+nome+
                        "| veiculo: "+tipoVeiculo +
                        "| origem da Rota: "+origemRota+
                        "| destino da Rota: "+destinoRota);
            }
            if (!achou){
                System.out.println("Nenhum dado encontrado na lista");
            }

            ps.close();
            rs.close();
        }




    }


