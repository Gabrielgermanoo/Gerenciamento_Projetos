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
        Users user = new Users();
        Atividades atividade = new Atividades();
        Project project = new Project();
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("Selecione uma opcao: \n" +
                    "1 - Cadastrar usuario\n" +
                    "2 - Deletar usuario\n" +
                    "3 - Cadastrar Atividade\n" +
                    "4 - Deletar Atividade\n" +
                    "5 - Cadastrar Projeto\n" +
                    "6 - Deletar Projeto\n" +
                    "7 - Editar Usuario\n" +
                    "8- Editar Projeto\n" +
                    "9 - Editar Atividade\n" +
                    "10 - Consultas\n" +
                    "10 - Sair");

            int option = input.nextInt();
            input.nextLine();

            if (option == 1) {
                //int suboption = input.nextInt();
                //input.nextLine();

                addUser(input, user, listUser);

            } else if (option == 2) {

                delUser(input, listUser);

            }
            else if (option == 3) {

                addAtividade(input, atividade, listAtividades);

            }else if (option == 4) {

                delAtividade(input,listAtividades);

            }else if (option == 5) {

                addProject(input, project, listProject, listUser, listAtividades);

            }else if (option == 6) {

                delProject(input, listProject);

            }else if (option == 7 ) {
                editUser(input, listUser);
            } else if (option == 8 ) {
                editAtividade(input, atividade,listAtividades);
            } else if (option == 9 ) {
                editProject(input, project, listProject, listUser, listAtividades);
            }else if (option == 10 ) {
                System.out.println("1: Consultar usuarios");
                System.out.println("2: Consultar Atividades");
                System.out.println("3: Consultar Projetos");
                int in = input.nextInt();
                input.nextLine();
                if (in == 1){
                    consultaUser(listUser);
                }
                else if(in == 2){
                    consultaAtividade(listAtividades);
                }
                else if(in == 3){
                    consultaProject(listProject);
                }
            }
            else if (option == 11 ) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
    }
    static void addUser(Scanner input, Users user, List<Users> listUser){
        System.out.println("Digite o nome:");
        String name = input.nextLine();
        user.setName(name);
        System.out.println("Digite o tipo:");
        String type = input.nextLine();
        user.setType(type);
        int size = listUser.size();
        user.setId(size);
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
    static void addAtividade(Scanner input, Atividades atividade, List<Atividades> listAtividades) throws ParseException {
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
        System.out.println("digite o responsavel pelo projeto:");
        String resp = input.nextLine();
        atividade.setResp(resp);
        System.out.println("digite a quantidade de profissionais envolvidos:");
        int num = input.nextInt();
        input.nextLine();
        int i = 0;
        while(i < num){
            System.out.printf("Profissional %d:", i);
            String name = input.nextLine();
            atividade.setProfs(name);
            i++;
        }
        System.out.println("digite as tarefas a serem realizadas:");
        String jobs = input.nextLine();
        atividade.setJobs(jobs);
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

    static void addProject(Scanner input, Project project, List<Project> listProject, List<Users> listUsers, List<Atividades> listAtividades) throws ParseException {
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
        System.out.println("selecione o profissional envolvido:");
        for (int i = 0; i < listUsers.size(); i++) {
            System.out.println(listUsers.get(i).getName() + listUsers.get(i).getType());
        }
        int num2 = input.nextInt();
        input.nextLine();
        Users pros = listUsers.get(num2);
        project.setProfs(pros);
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

    static void editAtividade(Scanner input, Atividades atividade, List<Atividades> listAtividades) throws ParseException {
        System.out.println("Selecione uma Atividade para atualizar");
        for(int i = 0; i < listAtividades.size(); i++){
            System.out.println(listAtividades.get(i).getId() + " " + listAtividades.get(i).getDesc() + " " + listAtividades.get(i).getId());
        }
        int numm = input.nextInt();
        input.nextLine();
        atividade = listAtividades.get(numm);
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
        System.out.println("digite o responsavel pelo projeto:");
        String resp = input.nextLine();
        atividade.setResp(resp);
        System.out.println("digite a quantidade de profissionais envolvidos:");
        int num = input.nextInt();
        input.nextLine();
        int i = 0;
        while(i < num){
            System.out.printf("Profissional %d:", i);
            String name = input.nextLine();
            atividade.setProfs(name);
            i++;
        }
        System.out.println("digite as tarefas a serem realizadas:");
        String jobs = input.nextLine();
        atividade.setJobs(jobs);
        listAtividades.add(atividade);
    }

    static void editProject(Scanner input, Project project, List<Project> listProject, List<Users> listUsers, List<Atividades> listAtividades) throws ParseException {
        System.out.println("Selecione uma Atividade para atualizar");
        for(int i = 0; i < listProject.size(); i++){
            System.out.println(listProject.get(i).getId() + " " + listProject.get(i).getDesc() + " " + listProject.get(i).getId());
        }
        int numm = input.nextInt();
        input.nextLine();
        project = listProject.get(numm);
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
        System.out.println("selecione o profissional envolvido:");
        for (int i = 0; i < listUsers.size(); i++) {
            System.out.println(listUsers.get(i).getName() + listUsers.get(i).getType());
        }
        int num2 = input.nextInt();
        input.nextLine();
        Users pros = listUsers.get(num2);
        project.setProfs(pros);
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

