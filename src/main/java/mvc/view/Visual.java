package mvc.view;

import mvc.Conector;
import mvc.dao.PassageiroDao;
import mvc.model.Passageiro;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Visual {

    public void view(){
        Boolean carregar=true;
        Scanner teclado=new Scanner(System.in);

        try{
            Connection con=new Conector().conection();
            PassageiroDao pass=new PassageiroDao(con);
            do {
                System.out.println("[1]- Cadastro de passageiros");
                System.out.println("[2]- Cadastro de Veiculos");
                System.out.println("[3]- Cadastro de Rotas");
                System.out.println("[4]- Sair");
                System.out.print("Escolha uma opção: ");
                String opcao=teclado.nextLine();

                switch(opcao){
                    case "1":
                        System.out.println("----- Bem vindo a tela de Cadastro -----");
                        System.out.print("Bi");
                }


            }while (carregar);

        }catch (SQLException e){
            System.out.println("Erro ao conectar o banco: "+e.getMessage());
        }


    }

    //Metodo para limpar a tela

    public void limpar(){
        System.out.println("\033[H\033[2J");
        System.out.flush();
    }
}
