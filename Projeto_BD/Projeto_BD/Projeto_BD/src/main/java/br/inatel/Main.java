package br.inatel;

import br.inatel.Model.*;
import br.inatel.DAO.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Estanciando variáveis de entrada e controle
        Scanner sc = new Scanner(System.in);
        Scanner Nome_empregado = new Scanner(System.in);
        Scanner Sobrenome_empregado = new Scanner(System.in);
        Scanner Funcao_empregado = new Scanner(System.in);
        Scanner Telefone_empregado = new Scanner(System.in);
        Scanner Salario_empregado = new Scanner(System.in);
        Scanner Idade_empregado = new Scanner(System.in);

        boolean flag = true;
        boolean flag_cliente;
        boolean flag_remedio;
        boolean flag_pedido;
        boolean flag_empregado;
        boolean flag_login_empregado;
        boolean flag_menu_empregado;
        int op;

        //Instanciando as classes de BD utilizadas
        ClienteDAO clienteDAO = new ClienteDAO();
        EmpregadoDAO empregadoDAO = new EmpregadoDAO();
        PedidoDAO pedidoDAO = new PedidoDAO();
        RemedioDAO remedioDAO = new RemedioDAO();
        PedidoHasRemedioDAO pedidoHasRemedioDAO = new PedidoHasRemedioDAO();
        LoginEmpregadoDAO loginempregadoDAO = new LoginEmpregadoDAO();

        //Informações do cliente
        int idCliente;
        String nome;
        String telefone;
        String endereco;
        //String dataCliente;

        //Informações do empregado
        int idEmpregado;
        String nome_empregado;
        String sobrenome;
        String funcao;
        String telefone_empregado;
        int salario;
        int idade_empregado;

        //Informações do pedido
        int idPedido;
        int clienteId;
        int empregadoId;
        int remedioId;
        int qntPedido;
        //String dataPedido;

        //Informações do remédio
        int idRemedio;
        String nomeRemedio;
        String fabricante;
        String tipoRemedio;
        int estoque;
        String validade;
        double preco;

        //Informações do login do empregado
        int idLoginEmpregado;
        String senhaLogin;
        String emailLogin;
        int IDEmpregado;

        //Instanciando a classe de adquirir a data
        Data data = new Data();

        empregadoDAO.selectInfosEmpregado(3);
        while(flag){
            System.out.println("Bem vindo ao sistema da Farmácia");
            System.out.println("Selecione uma das opções abaixo: ");
            System.out.println("1 - Gerenciamento de Clientes");
            System.out.println("2 - Gerenciamento de Remédios");
            System.out.println("3 - Gerenciamento de Pedidos");
            System.out.println("4 - Gerenciamento de Empregados");
            System.out.println("5 - Cadastro do Login do Empregado");
            System.out.println("6 - Sair");
            System.out.print("Opção: ");
            op = sc.nextInt();

            switch (op){
                case 1 -> {
                    flag_cliente = true;
                    while (flag_cliente){
                        System.out.println("Grenciamento de Clientes");
                        System.out.println("Selecione uma das opções abaixo: ");
                        System.out.println("1 - Adicionar Cliente");
                        System.out.println("2 - Ver informações de um cliente");
                        System.out.println("3 - Deletar um cliente");
                        System.out.println("4 - Voltar");
                        System.out.print("Opção: ");
                        op = sc.nextInt();
                        sc.nextLine();
                        switch (op){
                            case 1 -> {
                                System.out.println("Cadastro de Cliente");
                                System.out.println("Entre com as informações do cliente: ");
                                System.out.println("Id: ");
                                idCliente = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Nome: ");
                                nome = sc.nextLine();
                                System.out.println("Telefone: ");
                                telefone = sc.nextLine();
                                System.out.println("Endereço: ");
                                endereco = sc.nextLine();

                                Cliente cliente = new Cliente(
                                        idCliente,
                                        nome,
                                        telefone,
                                        endereco,
                                        data.getDateTime()
                                );

                                clienteDAO.insertCliente(cliente);
                            }
                            case 2 -> {
                                System.out.println("Ver infos de um Cliente");
                                System.out.print("Entre com o id do cliente: ");
                                int idTemp = sc.nextInt();
                                if(clienteDAO.selectClienteId(idTemp)){
                                    clienteDAO.selectInfosCliente(idTemp);
                                }
                            }
                            case 3 -> {
                                System.out.println("Deletar um Cliente");
                                System.out.print("Entre com o id do cliente: ");
                                int idTemp = sc.nextInt();
                                if(clienteDAO.selectClienteId(idTemp)){
                                    clienteDAO.deleteCliente(idTemp);
                                }
                            }
                            case 4 -> flag_cliente = false;
                            default -> System.out.println("Valor inválido");
                        }
                    }
                }

                case 2 -> {
                    flag_remedio = true;
                    while(flag_remedio){
                        System.out.println("Grenciamento de Remedios");
                        System.out.println("Selecione uma das opções abaixo: ");
                        System.out.println("1 - Adicionar Remédio");
                        System.out.println("2 - Ver informações de um Remédio");
                        System.out.println("3 - Deletar um Remédio");
                        System.out.println("4 - Atualizar estoque de Remédio");
                        System.out.println("5 - Voltar");
                        System.out.print("Opção: ");
                        op = sc.nextInt();
                        sc.nextLine();
                        switch (op){
                            case 1 -> {
                                System.out.println("Cadastro de Remédio");
                                System.out.println("Entre com as informações do remédio: ");
                                System.out.println("Id: ");
                                idRemedio = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Nome: ");
                                nomeRemedio = sc.nextLine();
                                System.out.println("Fabricante: ");
                                fabricante = sc.nextLine();
                                System.out.println("Tipo do remédio: ");
                                tipoRemedio = sc.nextLine();
                                System.out.println("Validade: ");
                                validade = sc.nextLine();
                                System.out.println("Estoque: ");
                                estoque = sc.nextInt();
                                System.out.println("Preço: ");
                                preco = sc.nextDouble();

                                Remedio remedio = new Remedio(
                                        idRemedio,
                                      nomeRemedio,
                                      fabricante,
                                      tipoRemedio,
                                      estoque,
                                      validade,
                                      preco
                                );

                                remedioDAO.insertRemedio(remedio);
                            }
                            case 2 -> {
                                System.out.println("Ver infos de um Remédio");
                                System.out.print("Entre com o id do remédio: ");
                                int idTemp = sc.nextInt();
                                if(remedioDAO.selectRemedioId(idTemp)){
                                    remedioDAO.selectInfosRemedio(idTemp);
                                }
                            }
                            case 3 -> {
                                System.out.println("Deletar um Remédio");
                                System.out.print("Entre com o id do remédio: ");
                                int idTemp = sc.nextInt();
                                if(remedioDAO.selectRemedioId(idTemp)){
                                    remedioDAO.deleteRemedio(idTemp);
                                }
                            }
                            case 4 -> {
                                System.out.println("Atualizar o estoque de um remédio");
                                System.out.println("Entre com o id do remédio: ");
                                int idTemp = sc.nextInt();
                                System.out.println("Entre com o novo valor do estoque: ");
                                int NovoEstoque = sc.nextInt();
                                if(remedioDAO.selectRemedioId(idTemp)){
                                    remedioDAO.updateRemedio(idTemp, NovoEstoque);
                                }
                            }
                            case 5 -> flag_remedio = false;
                            default -> System.out.println("Valor inválido");
                        }
                    }
                }

                case 3 -> {
                    flag_pedido = true;
                    while (flag_pedido){
                        System.out.println("Grenciamento de Pedidos");
                        System.out.println("Selecione uma das opções abaixo: ");
                        System.out.println("1 - Adicionar Pedido");
                        System.out.println("2 - Ver informações de um pedido");
                        System.out.println("3 - Adicionar um remédio ao pedido");
                        System.out.println("4 - Deletar um pedido");
                        System.out.println("5 - Voltar");
                        System.out.print("Opção: ");
                        op = sc.nextInt();
                        sc.nextLine();
                        switch (op){
                            case 1 -> {
                                System.out.println("Cadastro de Pedido");
                                System.out.println("Entre com as informações do pedido: ");
                                System.out.println("Id do pedido: ");
                                idPedido = sc.nextInt();
                                do{
                                    System.out.println("Id do cliente: ");
                                    clienteId = sc.nextInt();
                                    if(!clienteDAO.selectClienteId(clienteId)){
                                        System.out.println("Cliente não cadastrado");
                                    }
                                }while(!clienteDAO.selectClienteId(clienteId));
                                do{
                                    System.out.println("Id do Empregado: ");
                                    empregadoId = sc.nextInt();
                                    if(!empregadoDAO.selectEmpregadoId(empregadoId)){
                                        System.out.println("Empregado não cadastrado");
                                    }
                                }while(!empregadoDAO.selectEmpregadoId(empregadoId));
                                do{
                                    System.out.println("Id do Remedio: ");
                                    remedioId = sc.nextInt();
                                    if(!remedioDAO.selectRemedioId(remedioId)){
                                        System.out.println("Remedio não cadastrado");
                                    }
                                }while(!remedioDAO.selectRemedioId(remedioId));
                                System.out.println("Quantidade do remédio");
                                qntPedido = sc.nextInt();

                                Pedido pedido = new Pedido(
                                        idPedido,
                                        data.getDateTime(),
                                        clienteId,
                                        empregadoId
                                );

                                PedidoHasRemedio pedidoHasRemedio = new PedidoHasRemedio(
                                        idPedido,
                                        idPedido,
                                        remedioId,
                                        2, //inserir um método ou algo assim pro preço
                                        qntPedido
                                );

                                pedidoDAO.insertPedido(pedido);
                                pedidoHasRemedioDAO.insertPedidoRemedio(pedidoHasRemedio);
                            }
                            case 2 -> {
                                System.out.println("Ver infos de um Pedido");
                                System.out.print("Entre com o id do pedido: ");
                                int idPedidoTemp = sc.nextInt();
                                System.out.print("Entre com o id do cliente: ");
                                int idClienteTemp = sc.nextInt();
                                if(pedidoDAO.selectPedidoId(idPedidoTemp, idClienteTemp)){
                                    pedidoDAO.selectInfosPedidos(idPedidoTemp, idClienteTemp);
                                    pedidoHasRemedioDAO.searchPedidoRemedio(idPedidoTemp);
                                }
                            }

                            case 3 -> {
                                System.out.println("Adicionar remédios a um Pedido");
                                System.out.print("Entre com o id: ");
                                int idDoPedidoTemp = sc.nextInt();
                                System.out.print("Entre com o id do pedido: ");
                                int idPedidoTemp = sc.nextInt();
                                System.out.print("Entre com o id do cliente: ");
                                int idClienteTemp = sc.nextInt();
                                System.out.print("Entre com o id do remedio: ");
                                int idRemedioTemp = sc.nextInt();
                                System.out.println("Quantidade do remédio");
                                qntPedido = sc.nextInt();
                                if(pedidoDAO.selectPedidoId(idPedidoTemp, idClienteTemp)){
                                    PedidoHasRemedio pedidoHasRemedio = new PedidoHasRemedio(
                                            idDoPedidoTemp,
                                            idPedidoTemp,
                                            idRemedioTemp,
                                            2, //inserir um método ou algo assim pro preço
                                            qntPedido
                                    );
                                    pedidoHasRemedioDAO.insertPedidoRemedio(pedidoHasRemedio);
                                }
                            }

                            case 4 -> {
                                System.out.println("Deletar um Pedido");
                                System.out.print("Entre com o id do pedido: ");
                                int idPedidoTemp = sc.nextInt();
                                System.out.print("Entre com o id do cliente: ");
                                int idClienteTemp = sc.nextInt();
                                if(pedidoDAO.deletePedido(idPedidoTemp, idClienteTemp)){
                                    pedidoDAO.deletePedido(idPedidoTemp, idClienteTemp);
                                }
                            }
                            case 5 -> flag_pedido = false;
                            default -> System.out.println("Valor inválido");
                        }
                    }
                }
                case 4 -> {
                    flag_empregado = true;
                    while(flag_empregado){
                        System.out.println("Grenciamento de Empregados");
                        System.out.println("Selecione uma das opções abaixo: ");
                        System.out.println("1 - Adicionar um novo Empregado");
                        System.out.println("2 - Ver informações do Empregado");
                        System.out.println("3 - Atualizar alguma informação do Empregado");
                        System.out.println("4 - Deletar um empregado");
                        System.out.println("5 - Voltar");
                        System.out.print("Opção: ");
                        op = sc.nextInt();
                        sc.nextLine();
                        switch (op){
                            case 1 -> {
                                System.out.println("Cadastro de empregado");
                                System.out.println("Entre com as informações do Empregado: ");
                                System.out.println("Id: ");
                                idEmpregado = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Nome: ");
                                nome_empregado = sc.nextLine();
                                System.out.println("Sobrenome: ");
                                sobrenome = sc.nextLine();
                                System.out.println("Telefone: ");
                                telefone_empregado = sc.nextLine();
                                System.out.println("Função: ");
                                funcao = sc.nextLine();
                                System.out.println("Salário: ");
                                salario = sc.nextInt();
                                System.out.println("Idade: ");
                                idade_empregado = sc.nextInt();

                                Empregado empregado = new Empregado(
                                        idEmpregado,
                                        nome_empregado,
                                        sobrenome,
                                        funcao,
                                        salario,
                                        telefone_empregado,
                                        idade_empregado
                                );

                                empregadoDAO.insertEmpregado(empregado);
                            }
                            case 2 -> {
                                System.out.println("Ver informações de um Empregado");
                                System.out.print("Entre com o id do Empregado: ");
                                int idTemp = sc.nextInt();
                                if(empregadoDAO.selectEmpregadoId(idTemp)){
                                    empregadoDAO.selectInfosEmpregado(idTemp);
                                }
                            }
                            case 3 -> {
                                flag_menu_empregado = true;
                                while(flag_menu_empregado) {
                                    System.out.println("O que se deseja alterar do Empregado");
                                    System.out.println("1 - Nome");
                                    System.out.println("2 - Sobrenome");
                                    System.out.println("3 - Telefone");
                                    System.out.println("4 - Função");
                                    System.out.println("5 - Salário");
                                    System.out.println("6 - Idade");
                                    System.out.println("7 - Voltar");
                                    System.out.println("Opção: ");
                                    op = sc.nextInt();

                                    switch (op) {
                                        case 1 -> {
                                            System.out.println("Deseja-se alterar o nome do Empregado");
                                            System.out.println("Entre com o id do Empregado: ");
                                            int idTemp = sc.nextInt();
                                            System.out.println("Entre com o novo nome do Empregado: ");
                                            String novoNome = Nome_empregado.nextLine();
                                            if (empregadoDAO.selectEmpregadoId(idTemp)) {
                                                empregadoDAO.updateNomeEmpregado(idTemp, novoNome);
                                            }
                                        }
                                        case 2 -> {
                                            System.out.println("Deseja-se alterar o sobrenome do Empregado");
                                            System.out.println("Entre com o id do Empregado: ");
                                            int idTemp = sc.nextInt();
                                            System.out.println("Entre com o novo sobrenome do Empregado: ");
                                            String novoSobrenome = Sobrenome_empregado.nextLine();
                                            if (empregadoDAO.selectEmpregadoId(idTemp)) {
                                                empregadoDAO.updateSobrenomeEmpregado(idTemp, novoSobrenome);
                                            }
                                        }
                                        case 3 -> {
                                            System.out.println("Deseja-se alterar o telefone do Empregado");
                                            System.out.println("Entre com o id do Empregado: ");
                                            int idTemp = sc.nextInt();
                                            System.out.println("Entre com o novo telefone do Empregado: ");
                                            String novoTelefone = Telefone_empregado.nextLine();
                                            if (empregadoDAO.selectEmpregadoId(idTemp)) {
                                                empregadoDAO.updateTelefoneEmpregado(idTemp, novoTelefone);
                                            }
                                        }
                                        case 4 -> {
                                            System.out.println("Deseja-se alterar o salário do Empregado");
                                            System.out.println("Entre com o id do Empregado: ");
                                            int idTemp = sc.nextInt();
                                            System.out.println("Entre com o novo salário do Empregado: ");
                                            int novoSalario = Salario_empregado.nextInt();
                                            if (empregadoDAO.selectEmpregadoId(idTemp)) {
                                                empregadoDAO.updateSalarioEmpregado(idTemp, novoSalario);
                                            }
                                        }
                                        case 5 -> {
                                            System.out.println("Deseja-se alterar a função do Empregado");
                                            System.out.println("Entre com o id do Empregado: ");
                                            int idTemp = sc.nextInt();
                                            System.out.println("Entre com a nova função do Empregado: ");
                                            String nova_funcao = Funcao_empregado.nextLine();
                                            if (empregadoDAO.selectEmpregadoId(idTemp)) {
                                                empregadoDAO.updateFuncaoEmpregado(idTemp, nova_funcao);
                                            }
                                        }
                                        case 6 -> {
                                            System.out.println("Deseja-se alterar a idade do Empregado");
                                            System.out.println("Entre com o id do Empregado: ");
                                            int idTemp = sc.nextInt();
                                            System.out.println("Entre com a nova idade do Empregado: ");
                                            int nova_idade = Idade_empregado.nextInt();
                                            if (empregadoDAO.selectEmpregadoId(idTemp)) {
                                                empregadoDAO.updateIdadeEmpregado(idTemp, nova_idade);
                                            }
                                        }
                                        case 7 -> flag_menu_empregado = false;
                                    }
                                }
                            }
                            case 4 -> {
                                System.out.println("Deletar um Empregado");
                                System.out.print("Entre com o id do Empregado: ");
                                int idEmpregadoTemp = sc.nextInt();
                                if(empregadoDAO.selectEmpregadoId(idEmpregadoTemp)){
                                    empregadoDAO.deleteEmpregado(idEmpregadoTemp);
                                }
                            }
                            case 5 -> flag_empregado = false;
                        }
                    }
                }
                case 5 -> {
                    flag_login_empregado = true;

                    System.out.println("Entrada da senha e email do empregado para cadastro");
                    while(flag_login_empregado) {
                        System.out.println("O que se deseja realizar:");
                        System.out.println("1 - Cadastro da senha, email e id do empregado");
                        System.out.println("2 - Mostrar as informações de login");
                        System.out.println("3 - Deletar as informações de login");
                        System.out.println("4 - Sair");
                        System.out.println("Opção: ");
                        op = sc.nextInt();

                        switch(op) {
                            case 1 -> {
                                System.out.println("Cadastro do login");
                                System.out.println("Entre com as informações para o login: ");
                                System.out.println("Id: ");
                                idLoginEmpregado = sc.nextInt();
                                sc.nextLine();
                                System.out.println("Senha: ");
                                senhaLogin = sc.nextLine();
                                System.out.println("Email: ");
                                emailLogin = sc.nextLine();
                                System.out.println("Id do empregado:");
                                IDEmpregado = sc.nextInt();

                                LoginEmpregado loginEmpregado = new LoginEmpregado(
                                        idLoginEmpregado,
                                        senhaLogin,
                                        emailLogin,
                                        IDEmpregado
                                );

                                loginempregadoDAO.insertLoginEmpregado(loginEmpregado);
                            }
                            case 2 -> {
                                System.out.println("Mostrar o cadastro do login");
                                System.out.print("Entre com o id do login feito: ");
                                int idTemp = sc.nextInt();
                                if(loginempregadoDAO.selectLoginEmpregadoId(idTemp)){
                                    loginempregadoDAO.selectInfosLoginEmpregado(idTemp);
                                }
                            }
                            case 3 -> {
                                System.out.println("Deletar um login");
                                System.out.print("Entre com o id do login: ");
                                int idTemp = sc.nextInt();
                                if(loginempregadoDAO.selectLoginEmpregadoId(idTemp)){
                                    loginempregadoDAO.deleteLoginEmpregado(idTemp);
                                }
                            }
                            case 4 -> flag_login_empregado = false;
                            default -> System.out.println("Valor inválido");
                        }
                    }

                }
                case 6 -> flag = false;
                case 7 -> System.out.println("Opção inválida");
            }
        }
        sc.close();
        Nome_empregado.close();
        Sobrenome_empregado.close();
        Funcao_empregado.close();
        Telefone_empregado.close();
        Salario_empregado.close();
        Idade_empregado .close();
    }
}