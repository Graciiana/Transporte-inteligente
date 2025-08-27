package mvc.view;

import mvc.Conector;
import mvc.dao.PassageiroDao;
import mvc.dao.RotaDao;
import mvc.dao.VeiculoDao;
import mvc.model.Passageiro;
import mvc.model.Rota;
import mvc.model.Veiculo;

import java.nio.channels.FileLock;
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
            VeiculoDao veiculoDao = new VeiculoDao(con);
            RotaDao rotas = new RotaDao(con);

            do {
                System.out.println("[1]- Cadastro de passageiros");
                System.out.println("[2]- Cadastro de Veiculos");
                System.out.println("[3]- Cadastro de Rotas");
                System.out.println("[4]- Relotório de pedidos");
                System.out.println("[5]- Sair");
                System.out.println("[6]- Remover passageiros");
                System.out.print("Escolha uma opção: ");
                String opcao=teclado.nextLine();

                switch(opcao){
                    case "1":
                        System.out.println("----- Bem vindo a tela de Cadastro de passageiros -----");
                        System.out.println("==========================================");
                        System.out.print("Bi: ");
                        String bi= teclado.nextLine();
                        System.out.print("Nome: ");
                        String nome=teclado.nextLine();
                        System.out.print("Telefone: ");
                        String telefone=teclado.nextLine();
                        System.out.print("Saldo do cartão: ");
                        float saldo=teclado.nextFloat();
                        Passageiro passageiro = new Passageiro(0, bi, nome, telefone, saldo );
                        pass.cadastroPass(passageiro);
                        teclado.nextLine();
                        System.out.println("Dados cadastrados com sucesso");
                        limpar();
                        break;

                    case "2":
                        System.out.println("----- Bem vindo a tela de Cadastro de veiculos -----");
                        System.out.println("==========================================");
                        System.out.print("Tipo: ");
                        String tipo= teclado.nextLine();
                        System.out.print("Capacidade: ");
                        long capacidade=teclado.nextLong();
                        teclado.nextLine();
                        System.out.print("Matricula: ");
                        String matricula=teclado.nextLine();
                        Veiculo veiculo = new Veiculo( 0, tipo, capacidade, matricula );
                        veiculoDao.carrega(veiculo);
                        System.out.println("Dados cadastrados com sucesso");
                        limpar();
                        break;

                        case "3":
                        System.out.println("----- Bem vindo a tela de Cadastro de Rotas -----");
                        System.out.println("==========================================");
                        System.out.print("Origem: ");
                        String origem= teclado.nextLine();
                        System.out.print("Capacidade: ");
                        String destino = teclado.nextLine();
                        Rota rota= new Rota( 0, origem, destino );
                        rotas.cadastroRota(rota);
                        System.out.println("Dados cadastrados com sucesso");
                        limpar();
                        break;

                        case "6":
                        System.out.println("Escolha um dado para eliminar");
                        long id = teclado.nextInt();
                        pass.removerPass(id);
                        System.out.println("Dados removidos com sucesso!");
                        break;


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
