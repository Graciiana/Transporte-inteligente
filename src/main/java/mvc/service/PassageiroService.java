package mvc.service;

import mvc.dao.PassageiroDao;
import mvc.model.Passageiro;

public class PassageiroService {

        private final PassageiroDao passageiroDao;

        public PassageiroService(PassageiroDao passageiroDao) {
            this.passageiroDao = passageiroDao;
        }

        public void cadastrarPassageiro(Passageiro p) throws Exception {
            // --- Validações de regra ---
            if (p.getNome() == null || p.getNome().trim().isEmpty()) {
                throw new IllegalArgumentException("O nome do passageiro não pode estar vazio!");
            }

            if (p.getBilhete() == null || p.getBilhete().length() != 14) {
                throw new IllegalArgumentException("O número do BI deve ter exatamente 14 caracteres!");
            }

            if (p.getTelefone() == null || p.getTelefone().trim().isEmpty()) {
                throw new IllegalArgumentException("O telefone do passageiro não pode estar vazio!");
            }
            if (p.getSaldo() == 0 || p.getSaldo()<=150) {
                throw new IllegalArgumentException("Saldo insuficiente.");
            }

            // --- Se passou em todas as validações, salva no banco ---
            passageiroDao.cadastroPass(p);
        }
    }


