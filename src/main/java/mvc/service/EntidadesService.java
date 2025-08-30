package mvc.service;

import mvc.dao.ViagemDao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EntidadesService {

    private ViagemDao viagemDao;

    public EntidadesService(ViagemDao viagemDao) {
        this.viagemDao = viagemDao;
    }

    public void solicitarViagem(int idPassageiro, int idRota, int idVeiculo) throws SQLException {
        // Aqui poderia ter lógica: verificar saldo, veículo disponível, etc.
        viagemDao.inserirViagens(idPassageiro, idRota, idVeiculo);
    }

    public List<String> gerarRelatorio() throws SQLException {
     return null;
    }
}
