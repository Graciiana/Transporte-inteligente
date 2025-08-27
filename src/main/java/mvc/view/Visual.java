package mvc.view;

import mvc.Conector;

import java.sql.Connection;
import java.sql.SQLException;

public class Veiculo {

    public void view(){
        Boolean carregar=true;
        try{
            Connection con=new Conector().conection();
            do {
                System.out.println("[1]- Cadastro de passageiros");
                System.out.println("[2]- Cadastro de Veiculos");
                System.out.println("[3]- Cadastro de Rotas");
                System.out.println("[4]- Sair");
                System.out.print("Escolha uma opção:");


            }while (carregar);

        }catch (SQLException e){
            System.out.println("Erro ao conectar o banco: "+e.getMessage());
        }
    }
}
