package acoes;

import interfaces.Users;
import models.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Add extends Actions {
    public static void addUser(Scanner input, List listUser, Actions redo){
        DefaultUser user = new DefaultUser();
        Stack stack = new Stack();
        System.out.println("Usuario coordenador(Professor ou pesquisador)?\n" +
                "1 - Sim:\n" +
                "2 - Nao");
        int opt = input.nextInt();
        input.nextLine();
        if(opt == 1){
            user = new Coordenador();
        } else if (opt == 2) {
            System.out.println("selecionado usuario padrao");
        }
        else{
            System.out.println("Opcao invalida! Usuario padrao selecionado!");
        }
        System.out.println("Digite o nome:");
        String name = input.nextLine();
        user.setName(name);

        int size = listUser.size();
        user.setId(size);
        System.out.println(size);
        System.out.println("Digite o login:");
        String login = input.nextLine();
        user.setLogin(login);
        System.out.println("Digite a senha:");
        String password = input.nextLine();
        user.setPassword(password);
        stack.push(user);
        redo.setStkRedo(stack);
        listUser.add(user);
    }
    public static void addAtividade(Scanner input, List<Atividade> listAtividades, List<DefaultUser> listUsers, Actions redo) throws ParseException {
        Stack stack = new Stack();
        Atividade atividade = new Atividade();
        input.nextLine();
        System.out.println("Digite o nome da atividade:");
        String ident = input.nextLine();
        atividade.setIdent(ident);
        System.out.println("Digite a descricao da atividade:");
        String desc = input.nextLine();
        atividade.setDesc(desc);
        System.out.println("Digite a data de inicio da atividade: (dd/MM/yyyy hh:mm:ss)");
        String inicio = input.nextLine();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date datei = formatter.parse(inicio);
        atividade.setInicio(datei);
        System.out.println("digite a data de termino da atividade: (dd/MM/yyyy hh:mm:ss)");
        String finall = input.nextLine();
        Date datef = formatter.parse(finall);
        atividade.setTermino(datef);
        System.out.println("Selecione o responsavel pela Atividade:");
        for (int i = 0; i < listUsers.size(); i++) {
            System.out.println(listUsers.get(i).getId() + "  - " + listUsers.get(i).getName());
        }
        int num0 = input.nextInt();
        input.nextLine();
        Users nomeResp = listUsers.get(num0);
        atividade.setResp(nomeResp);
        int cont = 0;
        System.out.println("selecione os profissionais envolvidos: \n");
        for (int i = 0; i < listUsers.size(); i++) {
            System.out.println(listUsers.get(i).getId() + " - " + listUsers.get(i).getName() + " " );
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
    public static void addProject(Scanner input, List<Project> listProject, List<DefaultUser> listUsers, List<Atividade> listAtividades, int identificador, Actions redo) throws ParseException {
        Stack stack = new Stack();
        var type = Coordenador.class;
        input.nextLine();
        if(listUsers.get(identificador).getClass().equals(type)) {
            Project project = new Project();
            project.setStatus("Em processo de criacao");
            System.out.println("Digite o nome do Projeto:");
            String ident = input.nextLine();
            project.setIdent(ident);
            System.out.println("Digite a descricao do Projeto:");
            String desc = input.nextLine();
            project.setDesc(desc);
            System.out.println("Digite a data de inicio do projeto: (dd/MM/yyyy hh:mm:ss)");
            String inicio = input.nextLine();
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date datei = formatter.parse(inicio);
            project.setInicio(datei);
            System.out.println("digite a data de termino do projeto: (dd/MM/yyyy hh:mm:ss)");
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
                if (listUsers.get(i).getClass().equals(type)) {
                    System.out.println(i + " - " + listUsers.get(i).getName() + " " + listUsers.get(i).getClass().toString());
                }
            }
            int num = input.nextInt();
            input.nextLine();
            DefaultUser nomeCoord =  listUsers.get(num);
            project.setCoord(nomeCoord);
            int cont = 0;
            System.out.println("selecione os profissionais envolvidos: \n");
            for (int i = 0; i < listUsers.size(); i++) {
                System.out.println(listUsers.get(i).getId() + " - " + listUsers.get(i).getName() + " " );
                cont++;
            }
            int in = 0;
            List<DefaultUser> listUserp = new ArrayList<>();
            while (in != cont + 1) {
                in = input.nextInt();
                input.nextLine();
                DefaultUser user = listUsers.get(in);
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
            List<Atividade> atividadess = new ArrayList<>();
            while(inn != sizeatividade + 1) {
                for (int i = 0; i < listAtividades.size(); i++) {
                    System.out.println(listAtividades.get(i).getId() + " " + listAtividades.get(i).getDesc());
                }
                int num1 = input.nextInt();
                Atividade atividadeaux = listAtividades.get(num1);
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
            System.out.println("models.Bolsa para cada profissional");
            for (int i = 0; i < listUsers.size(); i++) {
                System.out.println(listUserp.get(i).getName() + " " );
                Double valor = input.nextDouble();
                input.nextLine();
                listUserp.get(i).setBolsa(valor);
            }
            project.setStatus("Iniciado");
            LocalDate today = LocalDate.now();
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
    }
}