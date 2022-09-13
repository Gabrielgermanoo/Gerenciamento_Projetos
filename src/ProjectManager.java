import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class ProjectManager {
    public static void main(String[] args) throws ParseException {
        List<Users> listUser = new ArrayList<>();
        List<Atividades> listAtividades = new ArrayList<>();
        List<Project> listProject = new ArrayList<>();
        Acoes acoes = new Acoes();
        Acoes undo = new Acoes();
        Scanner input = new Scanner(System.in);
        int identificador = 0;
        String login;
        String password = "";
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
                    System.out.println("Login:");
                    login = input.nextLine();
                    System.out.println("Senha: ");
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
                    addUser(input, listUser, acoes);
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
                        "7 - Relatorios\n" +
                        "8 - Gerenciar bolsas (Projetos) \n" +
                        "9 - Acoes \n" +
                        "10 - Sair");

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
                        addUser(input, listUser, acoes);
                    } else if (suboption == 2) {
                        editUser(input, listUser, acoes);
                    } else if (suboption == 3) {
                        delUser(input, listUser, acoes);
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
                        addAtividade(input, listAtividades, listUser, acoes);
                    } else if (suboption == 2) {
                        editAtividade(input, listAtividades, listUser, acoes);
                    } else if (suboption == 3) {
                        delAtividade(input, listAtividades, acoes);
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
                        addProject(input, listProject, listUser, listAtividades, identificador, acoes);
                    } else if (suboption == 2) {
                        editProject(input, listProject, listUser, listAtividades, identificador, acoes);
                    } else if (suboption == 3) {
                        delProject(input, listProject, acoes);
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
                    changePass(listUser, identificador, password);
                } else if (option == 7) {
                    System.out.println("Relatorios:\n" +
                            "1 - Relatorio de projeto\n" +
                            "2 - Relatorio de atividade");
                    int suboption = input.nextInt();
                    input.nextLine();
                    if (suboption == 1) projetoRelatorio(listProject);
                    else if (suboption == 2) {
                        atividadeRelatorio(listAtividades);
                    }
                }else if (option == 8) {
                    gerenciarBolsas(listProject);
                } else if (option == 9) {
                    int opt;
                    System.out.println("Selecione uma opcao: \n" +
                            "1 - Desfazer\n" +
                            "2 - Refazer");
                    opt = input.nextInt();
                    input.nextLine();
                    if(opt == 1) {
                        System.out.println("DESFAZER:\n" +
                                "1 - User\n" +
                                "2 - Atividade\n" +
                                "3 - Projeto");
                        int subopt = input.nextInt();
                        input.nextLine();
                        if(subopt == 1){
                            desfazer(acoes, undo, listUser);
                        } else if (subopt == 2) {
                            desfazer(acoes, undo, listAtividades);
                        } else if (subopt == 3) {
                            desfazer(acoes, undo, listProject);
                        }
                        else System.out.println("Opcao invalida!");
                    } else if (opt == 2) {
                        System.out.println("REFAZER:\n" +
                                "1 - User\n" +
                                "2 - Atividade\n" +
                                "3 - Projeto");
                        int subopt = input.nextInt();
                        input.nextLine();
                        if (subopt == 1){
                            refazer(acoes, undo, listUser);
                        } else if (subopt == 2) {
                            refazer(acoes, undo, listAtividades);
                        } else if (subopt == 3) {
                            refazer(acoes, undo, listProject);
                        }
                    }else System.out.println("Opcao invalida!");
                } else if (option == 10) {
                    logged = 0;
                } else {
                    System.out.println("Opcao invalida!");
                }
            }
        }
    }
    static void addUser(Scanner input, List<Users> listUser, Acoes redo){
        Users user = new Users();
        Stack stack = new Stack();
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
        stack.push(user);
        redo.setStkRedo(stack);
        listUser.add(user);
        //System.out.println(func.get(0).getName());
    }
    static void delUser(Scanner input, List<Users> listUser, Acoes redo){
        Stack stack = new Stack();
        Users user;
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
            user = listUser.get(del);
            listUser.remove(del);
            stack.push(user);
            redo.setStkRedo(stack);

        }
    }
    static void addAtividade(Scanner input, List<Atividades> listAtividades, List<Users> listUsers, Acoes redo) throws ParseException {
        Stack stack = new Stack();
        Atividades atividade = new Atividades();
        System.out.println("Digite o nome da atividade:");
        String ident = input.nextLine();
        atividade.setIdent(ident);
        System.out.println("Digite a descricao da atividade:");
        String desc = input.nextLine();
        atividade.setDesc(desc);
        System.out.println("Digite a data de inicio da atividade");
        String inicio = input.nextLine();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
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
                in += cont + 1;
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
        stack.push(atividade);
        redo.setStkRedo(stack);
        listAtividades.add(atividade);
        //System.out.println(func.get(0).getName());
    }

    static void delAtividade(Scanner input, List<Atividades> listAtividade, Acoes redo){
        Stack stack = new Stack();
        if (listAtividade.size()==0){
            System.out.println("Nao ha atividades cadastradas");
        }
        else {
            System.out.println("Qual atividade quer deletar? selecione um id:");
            for (int i = 0; i < listAtividade.size(); i++) {
                System.out.println(listAtividade.get(i).getIdent() + " " + listAtividade.get(i).getDesc() + " " + listAtividade.get(i).getId());
            }
            int del = input.nextInt();
            Atividades atividade = listAtividade.get(del);
            listAtividade.remove(del);
            stack.push(atividade);
            redo.setStkRedo(stack);
        }
    }

    static void addProject(Scanner input, List<Project> listProject, List<Users> listUsers, List<Atividades> listAtividades, int identificador, Acoes redo) throws ParseException {
        Stack stack = new Stack();
        if(listUsers.get(identificador).getType().equals("Professor") || listUsers.get(identificador).getType().equals("Pesquisador")) {
            Project project = new Project();
            project.setStatus("Em processo de criacao");
            System.out.println("Digite o nome do Projeto:");
            String ident = input.nextLine();
            project.setIdent(ident);
            System.out.println("Digite a descricao do Projeto:");
            String desc = input.nextLine();
            project.setDesc(desc);
            System.out.println("Digite a data de inicio da atividade");
            String inicio = input.nextLine();
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date datei = formatter.parse(inicio);
            project.setInicio(datei);
            System.out.println("digite a data de termino da atividade:");
            String finall = input.nextLine();
            Date datef = formatter.parse(finall);
            project.setTermino(datef);
            Calendar m_calendar = Calendar.getInstance();
            m_calendar.setTime(datei);
            int nMonth1 = 12 * m_calendar.get(Calendar.YEAR)+ m_calendar.get(Calendar.MONTH);
            m_calendar.setTime(datef);
            int nMonth2 = 12*m_calendar.get(Calendar.YEAR) + m_calendar.get(Calendar.MONTH);
            int diff = Math.abs(nMonth2 - nMonth1);
            System.out.println("Tempo: " + diff + "meses)");
            project.setTempo(diff);
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
            while (in != cont + 1) {
                in = input.nextInt();
                input.nextLine();
                Users user = listUsers.get(in);
                listUserp.add(user);
                if (listUserp.size() == listUsers.size()) {
                    System.out.println("Tamanho maximo de profissionais selecionado!");
                    in += cont + 1;
                    break;
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

            System.out.println("Selecione as atividades a serem realizadas:");
            int inn = 0;
            int sizeatividade = listAtividades.size();
            List<Atividades> atividadess = new ArrayList<>();
            while(inn != sizeatividade + 1) {
                for (int i = 0; i < listAtividades.size(); i++) {
                    System.out.println(listAtividades.get(i).getId() + " " + listAtividades.get(i).getDesc());
                }
                int num1 = input.nextInt();
                Atividades atividadeaux = listAtividades.get(num1);
                atividadess.add(atividadeaux);
                if(atividadess.size() == listAtividades.size()){
                    inn += sizeatividade + 1;
                }
                System.out.println("Adicionar mais uma atividade?\n" +
                        "1 - Selecionar\n" +
                        "2 - Nao selecionar");
                int aa = input.nextInt();
                input.nextLine();
                if (aa == 2) inn = sizeatividade + 1;
                else if (aa == 1) {
                    inn = 0;
                }
            }
            project.setAtividades(atividadess);
            System.out.println("Bolsa para cada profissional");
            for (int i = 0; i < listUsers.size(); i++) {
                System.out.println(listUserp.get(i).getName() + " " + listUserp.get(i).getType());
                Double valor = input.nextDouble();
                input.nextLine();
                listUserp.get(i).setBolsa(valor);
            }
            project.setStatus("Iniciado");
            LocalDate today = java.time.LocalDate.now();
            Date todayd = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
            int coordopt = 0;
            System.out.println("Iniciar projeto?" +
                    "1 - SIM\n" +
                    "2 - NAO");
            coordopt = input.nextInt();
            input.nextLine();
            if(coordopt == 1) {
                if((project.getInicio().after(todayd))){
                    project.setStatus("Em andamento");
                }
            } else if (coordopt == 2) {
                project.setStatus("Iniciado");
            }
            else System.out.println("Opcao Invalida!");
            stack.push(project);
            redo.setStkRedo(stack);
            listProject.add(project);
        }
        else{
            System.out.println("Voce nao tem permissao para isso!");
        }
        //System.out.println(func.get(0).getName());
    }
    static void delProject(Scanner input, List<Project> listProject, Acoes redo){
        Stack stack = new Stack<>();
        if (listProject.size()==0){
            System.out.println("Nao ha projetos cadastrados");
        }
        else {
            System.out.println("Qual Projeto quer deletar? selecione um id:");
            for (int i = 0; i < listProject.size(); i++) {
                System.out.println(listProject.get(i).getIdent() + " " + listProject.get(i).getDesc() + " " + listProject.get(i).getId());
            }
            int del = input.nextInt();
            Project project = listProject.get(del);
            stack.push(project);
            redo.setStkRedo(stack);
            listProject.remove(del);
        }
    }

    static void editUser(Scanner input, List<Users> listUser, Acoes redo){
        Stack stack = new Stack<>();
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
        stack.push(user);
        redo.setStkRedo(stack);
    }

    static void editAtividade(Scanner input, List<Atividades> listAtividades, List<Users> listUsers, Acoes redo) throws ParseException {
        Stack stack = new Stack();
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
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
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
        stack.push(atividade);
        redo.setStkRedo(stack);
        listAtividades.add(atividade);
    }

    static void editProject(Scanner input, List<Project> listProject, List<Users> listUsers, List<Atividades> listAtividades, int identificador, Acoes redo) throws ParseException {
        Stack stack = new Stack();
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
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
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
        System.out.println("Selecione as atividades a serem realizadas:");
        int inn = 0;
        int sizeatividade = listAtividades.size();
        List<Atividades> atividadess = new ArrayList<>();
        while(inn != sizeatividade + 1) {
            for (int i = 0; i < listAtividades.size(); i++) {
                System.out.println(listAtividades.get(i).getId() + " " + listAtividades.get(i).getDesc());
            }
            int num1 = input.nextInt();
            Atividades atividadeaux = listAtividades.get(num1);
            atividadess.add(atividadeaux);
            if(atividadess.size() == listAtividades.size()){
                inn += sizeatividade + 1;
            }
            System.out.println("Adicionar mais uma atividade?\n" +
                    "1 - Selecionar\n" +
                    "2 - Nao selecionar");
            int aa = input.nextInt();
            input.nextLine();
            if (aa == 2) inn = sizeatividade + 1;
            else if (aa == 1) {
                inn = 0;
            }
        }
        project.setAtividades(atividadess);
        System.out.println("Bolsa para cada profissional");
        for (int i = 0; i < listUsers.size(); i++) {
            System.out.println(listUserp.get(i).getName() + listUserp.get(i).getType());
            Double valor = input.nextDouble();
            input.nextLine();
            listUserp.get(i).setBolsa(valor);
        }
        System.out.println("Periodo de vigencia");
        int tempo = input.nextInt();
        input.nextLine();
        project.setTempo(tempo);
        LocalDate today = java.time.LocalDate.now();
        Date todayd = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
        int coordopt = 0;
        if (listUsers.get(identificador).equals(listProject.get(identificador).getCoord())) {
            System.out.println("Concluir projeto?" +
                    "1 - SIM\n" +
                    "2 - NAO");
            coordopt = input.nextInt();
            input.nextLine();
            if (coordopt == 1) {
                project.setStatus("Concluido");
                System.out.println("Concluido");
            } else if ( coordopt == 2) {
                System.out.println("Sem alteracoes!");
            }
            else System.out.println("Opcao invalida!");
        }
        stack.push(project);
        redo.setStkRedo(stack);
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
    static void changePass(List<Users> listUser, int identificador, String password){
        Scanner input = new Scanner(System.in);
        System.out.println("Qual a nova senha?");
        for(int i = 0; i < listUser.size(); i++){
            if(listUser.get(i).getId() == identificador){
                password = input.nextLine();
                listUser.get(i).setPassword(password);
            }
        }
        System.out.println("Alterada com sucesso!");
    }
    static void projetoRelatorio(List<Project> listProject){
        Scanner input = new Scanner(System.in);
        System.out.println("Selecionar um projeto:\n");
        for(int i = 0; i < listProject.size();  i++){
            System.out.println(listProject.get(i).getId() + " -  " + listProject.get(i).getIdent() + " ( " + listProject.get(i).getIdent() + " )");
        }
        int opt = input.nextInt();
        input.nextLine();
        gerarRelatorioProject(listProject, opt);
    }
    static void gerarRelatorioProject(List<Project> listProject, int ident){
        System.out.println("Nome do Projeto: ");
        System.out.println(listProject.get(ident).getIdent());
        System.out.println("Descricao: \n" + listProject.get(ident).getDesc());
        System.out.println("Status atual: ");
        System.out.println(listProject.get(ident).getStatus());
        System.out.println("Coordenador: " +
                listProject.get(ident).getCoord().getName());
        System.out.println("Profissionais envolvidos: ");
        for (int i = 0; i < listProject.get(ident).getProfs().size(); i++){
            System.out.println(listProject.get(ident).getProfs().get(i).getName());
        }
        System.out.println("Atividades envolvidas no Projeto:\n");
        for (int i = 0; i < listProject.get(ident).getAtividades().size(); i++){
            System.out.println(listProject.get(ident).getAtividades().get(i).getIdent() + " "  + listProject.get(ident).getAtividades().get(i).getDesc());
        }
        System.out.println("Inicio: " + listProject.get(ident).getInicio() + " \n" + "Termino: " + listProject.get(ident).getTermino());
        System.out.println("Tempo: " + listProject.get(ident).getTempo());
    }
    static void atividadeRelatorio(List<Atividades> listAtividade){
        Scanner input = new Scanner(System.in);
        System.out.println("Selecionar uma Atividade:\n");
        for(int i = 0; i < listAtividade.size();  i++){
            System.out.println(listAtividade.get(i).getId() + " -  " + listAtividade.get(i).getIdent() + " ( " + listAtividade.get(i).getIdent() + " )");
        }
        int opt = input.nextInt();
        input.nextLine();
        gerarRelatorioAtividade(listAtividade, opt);
    }
    static void gerarRelatorioAtividade(List<Atividades> listAtividade, int ident){
        System.out.println("Nome do Projeto: ");
        System.out.println(listAtividade.get(ident).getIdent());
        System.out.println("Descricao: \n" + listAtividade.get(ident).getDesc());
        System.out.println("Inicio: " + listAtividade.get(ident).getInicio() + " \n" + "Termino: " + listAtividade.get(ident).getTermino());
        System.out.println("Responsavel pela Atividade: \n" +
                listAtividade.get(ident).getResp().getName());
        System.out.println("Profissionais envolvidos: ");
        for (int i = 0; i < listAtividade.get(ident).getProfs().size(); i++){
            System.out.println(listAtividade.get(ident).getProfs().get(i).getName());
        }
    }
    static void gerenciarBolsas(List<Project> listProject){
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < listProject.size(); i++){
            System.out.println(listProject.get(i).getId() + " - " + listProject.get(i).getIdent() + " " + listProject.get(i).getDesc());
        }
        int opt = input.nextInt();
        input.nextLine();
        bolsa(listProject, opt);
    }
    static void bolsa(List<Project> listProject, int id){
        for(int i = 0; i < listProject.size(); i++) {
            System.out.println("Profissional: " + listProject.get(id).getProfs().get(i).getName() + " valor bolsa: "
                    + listProject.get(id).getProfs().get(i).getBolsa() + "(" + listProject.get(id).getProfs().get(i).getBolsa() * listProject.get(id).getTempo() + " ) ");
        }
    }
    static void desfazer(Acoes undo, Acoes redo, List padrao){
        Stack stk;
        stk = undo.getStkRedo();
        redo.setStkUndo(undo.getStkRedo());
        var popped = stk.peek();
        stk.pop();
        undo.setStkRedo(stk);
        if(padrao.contains(popped)){
            padrao.remove(popped);
        }
        else{
            padrao.add(popped);
        }
    }
    static void refazer(Acoes undo, Acoes redo, List padrao){
        Stack stk;
        stk = undo.getStkRedo();
        stk.push(redo.getStkUndo());
        undo.setStkRedo(stk);
        var peeked = stk.peek();

        if(padrao.contains(peeked)){
            padrao.remove(peeked);
        }
        else{
            padrao.add(peeked);
        }

    }
}