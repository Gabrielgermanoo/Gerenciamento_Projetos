import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProjectManager {
    public static void main(String[] args) throws ParseException {
        List<Users> listUser = new ArrayList<>();
        List<Atividades> listAtividades = new ArrayList<>();
        List<Project> listProject = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        int identificador = 0;
        String login;
        String password;
        int logged = 0;
        while (true) {
            if(logged == 0)
            {
                System.out.println("Selecione uma opcao:\n" +
                        "1 - Login\n" +
                        "2 - Cadastro de usuario\n" +
                        "3 - Sair");
                int opt = input.nextInt();
                input.nextLine();
                if (opt == 1)
                {
                    login = input.nextLine();
                    password = input.nextLine();
                    for(int i = 0; i < listUser.size(); i++){
                        if(listUser.get(i).getLogin().equals(login) && listUser.get(i).getPassword().equals(password) )
                        {
                            System.out.println("Logado com sucesso!");
                            logged = 1;
                            identificador = listUser.get(i).getId();
                        }
                    }
                    if(logged == 0){
                        System.out.println("Usuario ou senha incorretos!");
                    }
                }
                else if(opt == 2){
                    addUser(input, listUser);
                } else if (opt == 3) {
                    break;
                }
                else{
                    System.out.println("Opcao invalida!");
                }
            }
            else {
                System.out.println("Selecione uma opcao: \n" +
                        "1 - Usuarios\n" +
                        "2 - Atividades\n" +
                        "3 - Projetos\n" +
                        "4 - Consultas\n" +
                        "6 - Mudar senha\n" +
                        "7 - Sair");

                int option = input.nextInt();
                input.nextLine();
                // Usuarios
                if (option == 1) {
                    System.out.println("Selecione uma opcao: \n" +
                            "1 - Cadastrar Usuario\n" +
                            "2 - Editar Usuario\n" +
                            "3 - Deletar Usuario");
                    int suboption = input.nextInt();
                    input.nextLine();
                    if (suboption == 1) {
                        addUser(input, listUser);
                    } else if (suboption == 2) {
                        editUser(input, listUser);
                    } else if (suboption == 3) {
                        delUser(input, listUser);
                    } else System.out.println("Opcao invalida!");

                // Atividades
                } else if (option == 2) {
                    System.out.println("Selecione uma opcao: \n" +
                            "1 - Cadastrar Atividade\n" +
                            "2 - Editar Atividade\n" +
                            "3 - Deletar Atividade");
                    int suboption = input.nextInt();
                    input.nextLine();
                    if (suboption == 1) {
                        addAtividade(input, listAtividades, listUser);
                    } else if (suboption == 2) {
                        editAtividade(input, listAtividades, listUser);
                    } else if (suboption == 3) {
                        delAtividade(input, listAtividades);
                    } else System.out.println("Opcao invalida!");

                // Projetos
                } else if (option == 3) {
                    System.out.println("Selecione uma opcao: \n" +
                            "1 - Cadastrar Projeto\n" +
                            "2 - Editar Projeto\n" +
                            "3 - Deletar Projeto");
                    int suboption = input.nextInt();
                    input.nextLine();
                    if (suboption == 1) {
                        addProject(input, listProject, listUser, listAtividades);
                    } else if (suboption == 2) {
                        editProject(input, listProject, listUser, listAtividades);
                    } else if (suboption == 3) {
                        delProject(input, listProject);
                    } else System.out.println("Opcao invalida!");
                //Consultas
                } else if (option == 4) {
                    System.out.println("1: Consultar usuarios");
                    System.out.println("2: Consultar Atividades");
                    System.out.println("3: Consultar Projetos");
                    int in = input.nextInt();
                    input.nextLine();
                    if (in == 1) {
                        consultaUser(listUser);
                    } else if (in == 2) {
                        consultaAtividade(listAtividades);
                    } else if (in == 3) {
                        consultaProject(listProject);
                    }
                } else if (option == 5) {
                    break;
                }else if (option == 6){
                    System.out.println("Qual a nova senha?");
                    for(int i = 0; i < listUser.size(); i++){
                        if(listUser.get(i).getId() == identificador){
                            password = input.nextLine();
                            listUser.get(i).setPassword(password);
                        }
                    }
                    System.out.println("Alterada com sucesso!");
                } else if (option == 7) {
                    logged = 0;
                } else {
                    System.out.println("Opcao invalida!");
                }
            }
        }
    }
    static void addUser(Scanner input, List<Users> listUser){
        Users user = new Users();
        System.out.println("Digite o nome:");
        String name = input.nextLine();
        user.setName(name);
        System.out.println("Digite o tipo:");
        String type = input.nextLine();
        user.setType(type);
        int size = listUser.size();
        user.setId(size);
        System.out.println("Digite o login:");
        String login = input.nextLine();
        user.setLogin(login);
        System.out.println("Digite a senha:");
        String password = input.nextLine();
        user.setPassword(password);
        listUser.add(user);
        //System.out.println(func.get(0).getName());
    }
    static void delUser(Scanner input, List<Users> listUser){
        if (listUser.size()==0){
            System.out.println("Nao ha funcionarios cadastrados");
        }
        else {
            System.out.println("Qual funcionario quer deletar? selecione um id:");
            for (int i = 0; i < listUser.size(); i++) {
                System.out.println(listUser.get(i).getName() + " " + listUser.get(i).getType() + " " + listUser.get(i).getId());
            }
            int del = input.nextInt();
            input.nextLine();
            listUser.remove(del);
        }
    }
    static void addAtividade(Scanner input, List<Atividades> listAtividades, List<Users> listUsers) throws ParseException {
        Atividades atividade = new Atividades();
        System.out.println("Digite o nome da atividade:");
        String ident = input.nextLine();
        atividade.setIdent(ident);
        System.out.println("Digite a descricao da atividade:");
        String desc = input.nextLine();
        atividade.setDesc(desc);
        System.out.println("Digite a data de inicio da atividade");
        String inicio = input.nextLine();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date datei = formatter.parse(inicio);
        atividade.setInicio(datei);
        System.out.println("digite a data de termino da atividade:");
        String finall = input.nextLine();
        Date datef = formatter.parse(finall);
        atividade.setTermino(datef);
        System.out.println("Selecione o responsavel pela Atividade:");
        for (int i = 0; i < listUsers.size(); i++) {
            System.out.println(listUsers.get(i).getId() + "  - " + listUsers.get(i).getName() +" ( " + listUsers.get(i).getType() + " )");
        }
        int num0 = input.nextInt();
        input.nextLine();
        Users nomeResp = listUsers.get(num0);
        atividade.setResp(nomeResp);
        int cont = 0;
        System.out.println("selecione os profissionais envolvidos: \n");
        for (int i = 0; i < listUsers.size(); i++) {
            System.out.println(listUsers.get(i).getId() + " - " + listUsers.get(i).getName() + " " + listUsers.get(i).getType());
            cont++;
        }
        int in = 0;
        List<Users> listUserp = new ArrayList<>();
        while(in != cont + 1) {
            in = input.nextInt();
            input.nextLine();
            Users user = listUsers.get(in);
            listUserp.add(user);
            if (listUserp.size() == listUsers.size()) {
                System.out.println("Tamanho maximo de profissionais selecionado!");
                in = cont + 1;
            }
            else{
            System.out.println("Adicionar mais um?\n" +
                    "1 - Selecionar\n" +
                    "2 - Nao selecionar");
            int aa = input.nextInt();
            input.nextLine();
            if (aa == 2) in = cont + 1;
            else if (aa == 1) {
                in = 0;
            }
            }
        }
        atividade.setProfs(listUserp);
        System.out.println("digite as tarefas a serem realizadas:");
        String jobs = input.nextLine();
        atividade.setJobs(jobs);
        int size = listAtividades.size();
        atividade.setId(size);
        listAtividades.add(atividade);
        //System.out.println(func.get(0).getName());
    }

    static void delAtividade(Scanner input, List<Atividades> listAtividade){
        if (listAtividade.size()==0){
            System.out.println("Nao ha atividades cadastradas");
        }
        else {
            System.out.println("Qual atividade quer deletar? selecione um id:");
            for (int i = 0; i < listAtividade.size(); i++) {
                System.out.println(listAtividade.get(i).getIdent() + " " + listAtividade.get(i).getDesc() + " " + listAtividade.get(i).getId());
            }
            int del = input.nextInt();
            listAtividade.remove(del);
        }
    }

    static void addProject(Scanner input, List<Project> listProject, List<Users> listUsers, List<Atividades> listAtividades) throws ParseException {
        Project project = new Project();
        System.out.println("Digite o nome do Projeto:");
        String ident = input.nextLine();
        project.setIdent(ident);
        System.out.println("Digite a descricao do Projeto:");
        String desc = input.nextLine();
        project.setDesc(desc);
        System.out.println("Digite a data de inicio da atividade");
        String inicio = input.nextLine();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date datei = formatter.parse(inicio);
        project.setInicio(datei);
        System.out.println("digite a data de termino da atividade:");
        String finall = input.nextLine();
        Date datef = formatter.parse(finall);
        project.setTermino(datef);
        System.out.println("Selecione o coordenador do projeto:");

        for (int i = 0; i < listUsers.size(); i++) {
            if (listUsers.get(i).getType().equals("Professor") || listUsers.get(i).getType().equals("Pesquisador")) {
                System.out.println(i + " - " + listUsers.get(i).getName() + " " + listUsers.get(i).getType());
            }
        }
        int num = input.nextInt();
        input.nextLine();
        Users nomeCoord = listUsers.get(num);
        project.setCoord(nomeCoord);
        int cont = 0;
        System.out.println("selecione os profissionais envolvidos: \n");
        for (int i = 0; i < listUsers.size(); i++) {
            System.out.println(listUsers.get(i).getId() + " - " + listUsers.get(i).getName() + " " + listUsers.get(i).getType());
            cont++;
        }
        int in = 0;
        List<Users> listUserp = new ArrayList<>();
        while(in != cont + 1){
            in = input.nextInt();
            input.nextLine();
            Users user = listUsers.get(in);
            listUserp.add(user);
            if(listUserp.size() == listUsers.size()){
                System.out.println("Tamanho maximo de profissionais selecionado!");
                in = cont + 1;
            }
            System.out.println("Adicionar mais um?\n" +
                    "1 - Selecionar\n" +
                    "2 - Nao selecionar");
            int aa = input.nextInt();
            input.nextLine();
            if (aa == 2) in = cont + 1;
            else if (aa == 1) {
                in = 0;
            }
        }

        project.setProfs(listUserp);
        System.out.println("Selecione a atividade a ser realizada:");
        for (int i = 0; i < listAtividades.size(); i++) {
            System.out.println(listAtividades.get(i).getId() + " " + listAtividades.get(i).getDesc());
        }
        int num1 = input.nextInt();
        Atividades atividadess = listAtividades.get(num1);
        project.setAtividades(atividadess);
        System.out.println("Bolsa para cada profissional");
        for (int i = 0; i < listUsers.size(); i++) {
            System.out.println(listUsers.get(i).getName() + " " + listUsers.get(i).getType());
            Double valor = input.nextDouble();
            input.nextLine();
            listUsers.get(i).setBolsa(valor);
        }
        System.out.println("Periodo de vigencia");
        int tempo = input.nextInt();
        input.nextLine();
        project.setTempo(tempo);
        listProject.add(project);
        //System.out.println(func.get(0).getName());
    }
    static void delProject(Scanner input, List<Project> listProject){
        if (listProject.size()==0){
            System.out.println("Nao ha projetos cadastrados");
        }
        else {
            System.out.println("Qual Projeto quer deletar? selecione um id:");
            for (int i = 0; i < listProject.size(); i++) {
                System.out.println(listProject.get(i).getIdent() + " " + listProject.get(i).getDesc() + " " + listProject.get(i).getId());
            }
            int del = input.nextInt();
            listProject.remove(del);
        }
    }

    static void editUser(Scanner input, List<Users> listUser){
        System.out.println("Selecione um usuario para atualizar");
        for(int i = 0; i < listUser.size(); i++){
            System.out.println(listUser.get(i).getName() + " " + listUser.get(i).getType() + " " + listUser.get(i).getId());
        }
        int num = input.nextInt();
        input.nextLine();
        System.out.printf("Usuario selecionado: %s", listUser.get(num).getName());
        Users user = listUser.get(num);
        System.out.printf("Editar nome (%s)", listUser.get(num).getName());
        String name = input.nextLine();
        user.setName(name);
        System.out.printf("Editar tipo (%s)", listUser.get(num).getType());
        String type = input.nextLine();
        user.setType(type);
    }

    static void editAtividade(Scanner input, List<Atividades> listAtividades, List<Users> listUsers) throws ParseException {
        System.out.println("Selecione uma Atividade para atualizar");
        for(int i = 0; i < listAtividades.size(); i++){
            System.out.println(listAtividades.get(i).getId() + " " + listAtividades.get(i).getDesc() + " " + listAtividades.get(i).getId());
        }
        int numm = input.nextInt();
        input.nextLine();
        Atividades atividade = listAtividades.get(numm);
        System.out.println("Digite o nome da atividade:");
        String ident = input.nextLine();
        atividade.setIdent(ident);
        System.out.println("Digite a descricao da atividade:");
        String desc = input.nextLine();
        atividade.setDesc(desc);
        System.out.println("Digite a data de inicio da atividade");
        String inicio = input.nextLine();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date datei = formatter.parse(inicio);
        atividade.setInicio(datei);
        System.out.println("digite a data de termino da atividade:");
        String finall = input.nextLine();
        Date datef = formatter.parse(finall);
        atividade.setTermino(datef);
        System.out.println("Selecione o responsavel pela Atividade:");
        for (int i = 0; i < listUsers.size(); i++) {
            System.out.println(listUsers.get(i).getId() + "  - " + listUsers.get(i).getName() +" ( " + listUsers.get(i).getType() + " )");
        }
        int num0 = input.nextInt();
        input.nextLine();
        Users nomeResp = listUsers.get(num0);
        atividade.setResp(nomeResp);
        int cont = 0;
        System.out.println("selecione os profissionais envolvidos: \n");
        for (int i = 0; i < listUsers.size(); i++) {
            System.out.println(listUsers.get(i).getId() + " - " + listUsers.get(i).getName() + " " + listUsers.get(i).getType());
            cont++;
        }
        int in = 0;
        List<Users> listUserp = new ArrayList<>();
        while(in != cont + 1) {
            in = input.nextInt();
            input.nextLine();
            Users user = listUsers.get(in);
            listUserp.add(user);
            if (listUserp.size() == listUsers.size()) {
                System.out.println("Tamanho maximo de profissionais selecionado!");
                in = cont + 1;
            }
            else{
                System.out.println("Adicionar mais um?\n" +
                        "1 - Selecionar\n" +
                        "2 - Nao selecionar");
                int aa = input.nextInt();
                input.nextLine();
                if (aa == 2) in = cont + 1;
                else if (aa == 1) {
                    in = 0;
                }
            }
        }
        System.out.println("digite as tarefas a serem realizadas:");
        String jobs = input.nextLine();
        atividade.setJobs(jobs);
        listAtividades.add(atividade);
    }

    static void editProject(Scanner input, List<Project> listProject, List<Users> listUsers, List<Atividades> listAtividades) throws ParseException {
        System.out.println("Selecione uma Atividade para atualizar");
        for(int i = 0; i < listProject.size(); i++){
            System.out.println(listProject.get(i).getId() + " " + listProject.get(i).getDesc() + " " + listProject.get(i).getId());
        }
        int numm = input.nextInt();
        input.nextLine();
        Project project = listProject.get(numm);
        System.out.println("Digite o nome do Projeto:");
        String ident = input.nextLine();
        project.setIdent(ident);
        System.out.println("Digite a descricao do Projeto:");
        String desc = input.nextLine();
        project.setDesc(desc);
        System.out.println("Digite a data de inicio da atividade");
        String inicio = input.nextLine();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date datei = formatter.parse(inicio);
        project.setInicio(datei);
        System.out.println("digite a data de termino da atividade:");
        String finall = input.nextLine();
        Date datef = formatter.parse(finall);
        project.setTermino(datef);
        System.out.println("Selecione o coordenador do projeto:");

        for (int i = 0; i < listUsers.size(); i++) {
            if (listUsers.get(i).getType().equals("Professor") || listUsers.get(i).getType().equals("Pesquisador")) {
                System.out.println(i + ": " + listUsers.get(i).getName() + " " + listUsers.get(i).getType());
            }
        }
        int num = input.nextInt();
        input.nextLine();
        Users nomeCoord = listUsers.get(num);
        project.setCoord(nomeCoord);
        int cont = 0;
        System.out.println("selecione os profissionais envolvidos: \n");
        for (int i = 0; i < listUsers.size(); i++) {
            System.out.println(listUsers.get(i).getId() + " - " + listUsers.get(i).getName() + " " + listUsers.get(i).getType());
            cont++;
        }
        int in = 0;
        List<Users> listUserp = new ArrayList<>();
        while(in != cont + 1){
            in = input.nextInt();
            input.nextLine();
            Users user = listUsers.get(in);
            listUserp.add(user);
            if(listUserp.size() == listUsers.size()){
                System.out.println("Tamanho maximo de profissionais selecionado!");
                in = cont + 1;
            }
            System.out.println("Adicionar mais um?\n" +
                    "1 - Selecionar\n" +
                    "2 - Nao selecionar");
            int aa = input.nextInt();
            input.nextLine();
            if (aa == 2) in = cont + 1;
            else if (aa == 1) {
                in = 0;
            }
        }
        System.out.println("Selecione a atividade a ser realizada:");
        for (int i = 0; i < listAtividades.size(); i++) {
            System.out.println(listAtividades.get(i).getId() + listAtividades.get(i).getDesc());
        }
        int num1 = input.nextInt();
        Atividades atividadess = listAtividades.get(num1);
        project.setAtividades(atividadess);
        System.out.println("Bolsa para cada profissional");
        for (int i = 0; i < listUsers.size(); i++) {
            System.out.println(listUsers.get(i).getName() + listUsers.get(i).getType());
            Double valor = input.nextDouble();
            input.nextLine();
            listUsers.get(i).setBolsa(valor);
        }
        System.out.println("Periodo de vigencia");
        int tempo = input.nextInt();
        input.nextLine();
        project.setTempo(tempo);
        listProject.add(project);
    }
    static void consultaUser(List<Users> listUser){
        for(int i = 0; i < listUser.size(); i++){
            System.out.println(listUser.get(i).getName() + " " + listUser.get(i).getType());
        }
    }
    static void consultaAtividade(List<Atividades> listAtividade){
        for(int i = 0; i < listAtividade.size(); i++){
            System.out.println(listAtividade.get(i).getId() + " " + listAtividade.get(i).getDesc());
        }
    }
    static void consultaProject(List<Project> listProject){
        for(int i = 0; i < listProject.size(); i++){
            System.out.println(listProject.get(i).getId() + " " + listProject.get(i).getDesc());
        }
    }
}

