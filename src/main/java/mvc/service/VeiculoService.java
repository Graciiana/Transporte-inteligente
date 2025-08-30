package mvc.service;

import mvc.dao.VeiculoDao;
import mvc.model.Veiculo;

public class VeiculoService {

    private final VeiculoDao veiculoDao;

    public VeiculoService(VeiculoDao veiculoDao) {
        this.veiculoDao = veiculoDao;
    }

    public void cadastrarVeiculo(Veiculo v) throws Exception {


        veiculoDao.carrega(v);
    }
}
