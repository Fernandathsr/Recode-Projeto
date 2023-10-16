package com.travel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import com.dao.ClienteDAO;
import com.dao.PassageDAO;
import com.dao.PedidoDAO;
import com.model.Cliente;
import com.model.Passagem;
import com.model.Pedido;


public class Main {

    private Connection connection;

    public static void main(String[] args) throws SQLException {

        Connection con = null;

        //CRIAÇÃO DE OBJETOS DAO
        ClienteDAO clienteDAO = new ClienteDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();
        PassageDAO passageDAO = new PassageDAO();

        //CRIANDO BOOLEANS PARA CONDIÇÕES DE SAÍDA DOS LOOPS
        boolean opcaoSaida1 = true;
        boolean opcaoSaida2 = true;

        //INICIALIZANDO O MENU

        do {
            System.out.println("""
                    Qual tabela deseja modificar?\n
                    1-Cliente\n
                    2-Passagem\n
                    3-Pedido                
                    """);

            Scanner scan = new Scanner(System.in);
            System.out.printf("\nR:");
            int opcao = scan.nextInt();
            switch (opcao) {        //INICIANDO O PODER DA ESCOLHA
                case 1: {
                    do {
                        System.out.println("Criar Cliente");
                        System.out.println("Listar Cliente");
                        System.out.println("Atualizar Cliente");
                        System.out.println("Deletar Cliente");
                        System.out.println("Digite 5 para voltar ao menu inicial!!!");
                        int opcao2 = scan.nextInt();
                        switch (opcao2) {
                            case 1: {   //CREATE
                                Cliente criarCliente = new Cliente();
                                scan.nextLine();
                                System.out.printf("\nDigite o Nome: ");
                                String nomeCliente = scan.nextLine();
                                System.out.printf("\nDigite o CPF: ");
                                String cpfCliente = scan.nextLine();
                                System.out.printf("\nDigite o E-mail: ");
                                String emailCliente = scan.nextLine();
                                System.out.printf("\nDigite o Endereço:");
                                String enderecoCliente = scan.nextLine();
                                System.out.printf("\nDigite o Telefone: ");
                                String telefone = scan.nextLine();

                                criarCliente.setNomeCliente(nomeCliente);
                                criarCliente.setCpfCliente(cpfCliente);
                                criarCliente.setEmailCliente(emailCliente);
                                criarCliente.setEnderecoCliente(enderecoCliente);
                                criarCliente.setTelefone(telefone);

                                if (clienteDAO.createCliente(criarCliente)) {
                                    System.out.println("Cliente cadastrado! =)");
                                } else {
                                    System.out.println("Erro no cadastro, tente novamente dentro de alguns minutos. =( ");
                                }
                                break;
                            }
                            case 2: {  //READ
                                for (Cliente c : clienteDAO.findAll()) {
                                    System.out.println("\nNome: " + c.getNomeCliente() + "\nCPF: " + c.getCpfCliente() + "\nE-mail: " + c.getEmailCliente() + "\nEndereço: " + c.getEnderecoCliente() + "\nTelefone: " + c.getTelefone());

                                }
                                System.out.println("");
                                break;
                            }
                            case 3: { // UPDATE
                                scan.nextLine();
                                Cliente atualizarCliente = new Cliente();
                                System.out.printf("\nDigite o ID do cliente para atualização: ");
                                String idCliente = scan.next();
                                for (Cliente c : clienteDAO.findAll()) {
                                    if (idCliente.equals(c.getIdCliente())) { //SE ESSE ID FOR = AO ID EXISTENTE
                                        atualizarCliente.setCpfCliente(c.getCpfCliente());

                                    }
                                }
                                System.out.println("\nDigite o novo Nome: ");
                                String nomeCliente = scan.next();
                                System.out.println("\nDigite o novo E-mail: ");
                                String emailCliente = scan.next();
                                System.out.println("\nDigite o novo Endereço: ");
                                String enderecoCliente = scan.next();
                                System.out.println("\nDigite o novo Telefone: ");
                                String telefone = scan.next();
                                if (clienteDAO.updateCliente(atualizarCliente)) {
                                    System.out.println("\nAtualização realizada!");
                                } else {
                                    System.out.println("\nErro ao atualizar, tente novamente dentro de alguns minutos.");
                                }
                                break;

                            }
                            case 4: { //DELETANDO
                                scan.nextLine();
                                System.out.println("Deletando");
                                System.out.println("");
                                Cliente deletandoCliente = new Cliente();
                                System.out.println("Digite o ID que queira deletar: ");
                                int idCLiente = scan.nextInt();
                                deletandoCliente.setIdCliente(idCLiente);
                                if (clienteDAO.deleteCliente(deletandoCliente)) {
                                    System.out.println("\nCliente deletado");
                                } else {
                                    System.out.println("\nErro ao deletar");
                                }
                                break;
                            }
                            case 5: { //?????
                                opcaoSaida2 = false;
                                break;
                            }
                            default: {
                                System.out.println("Digite uma opção válida.");
                            }
                        }
                        if (!opcaoSaida2) {
                            opcaoSaida2 = false;
                        }
                    } while (opcaoSaida2);
                    opcaoSaida2 = true;
                    break;
                }
                //TABELA PASSAGEM
                case 2: {
                    do {
                        System.out.println("Criar Destino");
                        System.out.println("Listar Destinos");
                        System.out.println("Atualizar Destino");
                        System.out.println("Deletar Destino");
                        System.out.println("Digite 5 para voltar ao menu inicial!!!");
                        int opcao2 = scan.nextInt();
                        switch (opcao2) {
                            case 1: { //CREATE
                                scan.nextLine();
                                Passagem criarDestino = new Passagem();
                                System.out.print("\nDigite o destino desejado:");
                                String destinoViagem = scan.nextLine();
                                criarDestino.setDestinoViagem(destinoViagem);

                                if (passageDAO.createPasssagem(criarDestino)) {
                                    System.out.println("Destino cadastrado! =)");
                                } else {
                                    System.out.println("Erro no cadastro do destino, tente novamente dentro de alguns minutos. =( ");
                                }
                                break;
                            }
                            //MOSTRANDO TUDO

                            case 2: { //READ
                                for (Passagem p : passageDAO.findAll()) {
                                    System.out.println("\n Destinos: " + p.getDestinoViagem());

                                }
                                System.out.println("");
                                break;
                            }
                            case 3: { //UPDATE
                                scan.nextLine();
                                Passagem atualizarPassagem = new Passagem();
                                System.out.printf("\nDigite o DESTINO para atualização: ");
                                String idPassagem = scan.next();
                                for (Passagem p : passageDAO.findAll()) {
                                    if (idPassagem.equals(p.getIdPassagem())) { //SE ESSE ID FOR = AO ID EXISTENTE
                                        atualizarPassagem.setIdPassagem(p.getIdPassagem());

                                    }
                                }
                                System.out.println("\nDigite o novo Destino: ");
                                String nomeCliente = scan.next();
                                if (passageDAO.updatePassagem(atualizarPassagem)) {
                                    System.out.println("\nAtualização realizada!");
                                } else {
                                    System.out.println("\nErro ao atualizar, tente novamente dentro de alguns minutos.");
                                }
                                break;

                            }
                            case 4: { //DELETANDO
                                scan.nextLine();
                                System.out.println("Deletando");
                                System.out.println("");
                                Passagem deletandoPassagem = new Passagem();
                                System.out.println("Digite o ID que queira deletar: ");
                                int idPassagem = scan.nextInt();
                                deletandoPassagem.setIdPassagem(idPassagem);
                                if (passageDAO.deletePassagem(deletandoPassagem)) {
                                    System.out.println("\nPassagem deletada");
                                } else {
                                    System.out.println("\nErro ao deletar");
                                }
                                break;
                            }
                            case 5: {
                                opcaoSaida2 = false;
                                break;
                            }
                            default: {
                                System.out.println("Digite uma opção válida.");
                            }
                        }
                        if (!opcaoSaida2) {
                            opcaoSaida2 = false;
                        }
                    } while (opcaoSaida2);
                    opcaoSaida2 = true;
                    break;
                }
                // TABELA PEDIDO

                //REVER AQUI O QUE TEM QUE AJUSTAR
                case 3: {
                    do {
                        System.out.println("Criar Pedido");
                        System.out.println("Listar Pedido");
                        System.out.println("Atualizar Pedido");
                        System.out.println("Deletar Pedido");
                        System.out.println("Digite 5 para voltar ao menu inicial!!!");
                        int opcao2 = scan.nextInt();
                        switch (opcao2) {
                            case 1: {
                                Pedido criarPedido = new Pedido();
                                scan.nextLine();
                                Cliente cliente = new Cliente();
                                Passagem passagem = new Passagem();
                                System.out.printf("\nDigite o valor do pedido: ");
                                int valorPedido = scan.nextInt();
                                scan.nextLine();
                                System.out.print("\nDigite a data do pedido: ");
                                String dataPedido = scan.nextLine();
                                System.out.printf("\nDigite o ID do cliente: ");
                                int clienteId = scan.nextInt();
                                cliente.setIdCliente(clienteId);
                                System.out.printf("\nDigite o ID da passagem: ");
                                int passagemId = scan.nextInt();
                                passagem.setIdPassagem(passagemId);

//                                scan.nextLine();
                                criarPedido.setValorPedido(valorPedido);
                                criarPedido.setDataPedido(dataPedido);
                                criarPedido.setCliente(cliente);
                                criarPedido.setPassagem(passagem);

                                if (pedidoDAO.createPedido(criarPedido)) {
                                    System.out.println("Pedido cadastrado! =)");
                                } else {
                                    System.out.println("Erro no cadastro do pedido, tente novamente dentro de alguns minutos. =( ");
                                }
                                break;
                            }
                            //MOSTRANDO TUDO

                            case 2: {
                                for (Pedido p : pedidoDAO.findAll()) {
                                    System.out.println("\nID do Pedido: " + p.getIdPedido() + "\nValor do pedido: " + p.getValorPedido() + "\nData do pedido: " + p.getDataPedido() +
                                            "\nID do CLiente: " + p.getCliente().getIdCliente() + "\nID da passagem: " + p.getPassagem().getIdPassagem());

                                }
                                System.out.println("");
                                break;
                            }

                            //UPTADE PEDIDO

                            case 3: {
                                scan.nextLine();
                                Pedido atualizarPedido = new Pedido();
                                System.out.printf("\nDigite o PEDIDO para atualização: ");
                                String idPedido = scan.next();
                                for (Pedido p : pedidoDAO.findAll()) {
                                    if (idPedido.equals(p.getIdPedido())) { //SE ESSE ID FOR = AO ID EXISTENTE
                                        atualizarPedido.setIdPedido(p.getIdPedido());

                                    }
                                }
                                System.out.println("\nDigite o novo PEDIDO: ");
                                String nomeCliente = scan.next();
                                if (pedidoDAO.uptadePedido(atualizarPedido)) {
                                    System.out.println("\nAtualização realizada!");
                                } else {
                                    System.out.println("\nErro ao atualizar, tente novamente dentro de alguns minutos.");
                                }
                                break;

                            }

                            //DELETE PEDIDO

                            case 4: {
                                scan.nextLine();
                                System.out.println("Deletando...");
                                System.out.println("");
                                Pedido deletandoPedido = new Pedido();
                                System.out.println("Digite o ID que queira deletar: ");
                                int idPedido = scan.nextInt();
                                deletandoPedido.setIdPedido(idPedido);
                                if (pedidoDAO.deletePedido(deletandoPedido)) {
                                    System.out.println("\nPedido deletado");
                                } else {
                                    System.out.println("\nErro ao deletar");
                                }
                                break;
                            }
                            case 5: {
                                opcaoSaida2 = false;
                                break;
                            }
                            default: {
                                System.out.println("Digite uma opção válida.");
                            }
                        }
                        if (!opcaoSaida2) {
                            opcaoSaida2 = false;
                        }
                    } while (opcaoSaida2);
                    opcaoSaida2 = true;
                    break;
                }
            }

        } while (opcaoSaida1);
    }


}






