package mvc.view;

import mvc.Conector;
import mvc.dao.*;
import mvc.dao.ViagemDao;
import mvc.model.Passageiro;
import mvc.model.Preco;
import mvc.model.Rota;
import mvc.model.Veiculo;
import mvc.service.PassageiroService;

import java.nio.channels.FileLock;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Visual {

    public void view(){
        Boolean carregar=true;
        Scanner teclado=new Scanner(System.in);

        try{
            Connection con=new Conector().conection();
            PassageiroDao passDao=new PassageiroDao(con);
            VeiculoDao veiculoDao = new VeiculoDao(con);
            RotaDao rotasDao = new RotaDao(con);
            ViagemDao viagemDao = new ViagemDao(con);
            PrecoDao precoDao = new PrecoDao(con);
            PassageiroService passageiroService = new PassageiroService(passDao);


            while (carregar){
                System.out.println("================== Menu ==================");
                System.out.println("[1]- Cadastro de passageiros");
                System.out.println("[2]- Cadastro de Veiculos");
                System.out.println("[3]- Cadastro de Rotas");
                System.out.println("[4]- Pedido de viagens");
                System.out.println("[5]- Remover Dados");
                System.out.println("[6]- Lista de dados cadastrados");
                System.out.println("[7]- Relotório de pedidos");
                System.out.println("[8]- Sair");
                System.out.print("Escolha uma opção: ");
                String opcao=teclado.nextLine();
                System.out.println("======================================================");

                switch(opcao){
                    case "1":
                        System.out.println("----- Bem vindo a tela de Cadastro de passageiros -----");
                        System.out.println("==========================================");
                        System.out.print("Nome: ");
                        String nome=teclado.nextLine();
                        System.out.print("Telefone: ");
                        String telefone=teclado.nextLine();
                        System.out.print("Saldo do cartão: ");
                        float saldo=teclado.nextFloat();
                        Passageiro passageiro = new Passageiro(0, nome, telefone, saldo );

                        passageiroService.cadastrarPassageiro(passageiro);
                        teclado.nextLine();
                        System.out.println("Dados cadastrados com sucesso");
                        limpar();
                        break;

                        case "2":
                            System.out.println("----- Bem vindo ao menu para pedido de viagens -----");

                        System.out.println("----- Bem vindo a tela de Cadastro de veiculos -----");
                        System.out.println("==========================================");
                        System.out.print("Tipo: ");
                        String tipo= teclado.nextLine();
                        System.out.print("Capacidade: ");
                        long capacidade=teclado.nextLong();
                        teclado.nextLine();
                        System.out.print("Matricula: ");
                        String matricula=teclado.nextLine();
                        Veiculo veiculo = new Veiculo( 0, tipo, capacidade, matricula);
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
                        rotasDao.cadastroRota(rota);
                        System.out.println("Dados cadastrados com sucesso");
                        limpar();
                        break;

                    case "4":
                        System.out.println("------- Faça a solicitação de uma viagem -------");
                        System.out.println("=================================================");

                        case "5":
                        System.out.println("Escolha uma opcao para remover (passageiro/rota/veiculo))");
                        String dadoRem=teclado.nextLine();

                        if (dadoRem.equalsIgnoreCase("passage")){
                            System.out.print("Escolha o id do passageiro: ");
                            long id=teclado.nextInt();
                            passDao.removerPass(id);
                            System.out.println("Dados removidos com sucesso!");
                            teclado.nextLine();

                        } else if (dadoRem.equalsIgnoreCase("rota") ) {
                            System.out.print("Escolha o id da rota: ");
                            long idRota=teclado.nextInt();
                            rotasDao.removerRota(idRota);
                            System.out.println("Dados removidos com sucesso!");
                            teclado.nextLine();
                        }
                        else if(dadoRem.equalsIgnoreCase("veiculo")){
                            System.out.print("Escolha o id do veiculo: ");
                            long idVeiculo = teclado.nextInt();
                            veiculoDao.removerVeiculo(idVeiculo);
                            System.out.println("Dados removidos com sucesso!");
                            teclado.nextLine();
                        }
                        else {
                            System.out.println("Nenhum dado encontrado.");
                            teclado.nextLine();
                        }
                        break;

                    case "6":
                        System.out.println("=======================================");
                        System.out.print("Escolha os dados que queres listar: (Passageiro/Rotas/veiculos, viagens): ");
                        String opc = teclado.nextLine();

                        if (opc.equalsIgnoreCase("passageiro")){
                            passDao.lista();
                        } else if (opc.equalsIgnoreCase("rotas")) {
                            rotasDao.lista();
                        } else if (opc.equalsIgnoreCase("veiculos")) {
                            veiculoDao.lista();
                        }
                        else {
                            System.out.println("Opcao invalida! ");
                        }
                        break;

                    case "7":
                        System.out.println("---- Relatorio de viagens ----");
                        viagemDao.listarViagens();
                        break;

                    case "8":
                        carregar=false;
                        break;
                    default:
                        System.out.println("Opcao invalida.");
                }
            }

                }catch (SQLException e){
                    System.out.println("Erro ao conectar o banco: "+e.getMessage());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                }



                //Metodo para limpar a tela

                public void limpar(){
                System.out.println("\033[H\033[2J");
                System.out.flush();
                }
                }
