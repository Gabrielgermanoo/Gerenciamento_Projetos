package operations;

import interfaces.Users;
import models.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Add extends Actions {
    public Add(List<DefaultUser> users, List<Project> projects, List<Activity> activities) {
        super(users, projects, activities);
    }

    public static void addUser(Scanner input, List<DefaultUser> listUser, Pilha redo){
        DefaultUser user = DefaultUser.createDefaultUser();
        Stack<DefaultUser> stack = new Stack<>();
        stringExtract("""
                Usuario coordenador(Professor ou pesquisador)?
                1 - Sim:
                2 - Nao""");
        int opt = input.nextInt();
        input.nextLine();

        UserFactory.getUser(opt);

        stringExtract("Digite o nome:");
        String name = getString(input);
        //user.setName(name);

        int size = listUser.size();
        //user.setId(size);
        stringExtract("Digite o login:");
        String login = getString(input);
        //user.setLogin(login);
        stringExtract("Digite a senha:");
        String password = getString(input);
        //user.setPassword(password);

        user .addName(name)
             .addId(size)
             .addLogin(login)
             .addPassword(password);

        stack.push(user);
        redo.setStkRedo(stack);
        listUser.add(user);
    }
    public static void addAtividade(Scanner input, List<Activity> listActivities, List<DefaultUser> listUsers, Pilha redo) {
        Stack<Activity> stack = new Stack<>();
        Activity activity = Activity.createActivity();
        input.nextLine();
        stringExtract("Digite o nome da activity:");
        String ident = getString(input);
        activity.setIdent(ident);
        stringExtract("Digite a descricao da activity:");
        String desc = getString(input);
        activity.setDesc(desc);
        DateFormat formatter = null;
        try {
            stringExtract("Digite a data de inicio da activity: (dd/MM/yyyy hh:mm:ss)");
            String inicio = getString(input);
            formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date datei = formatter.parse(inicio);
            activity.setBegin(datei);
        } catch( ParseException e){
            stringExtract("Wrong format data" + e.getMessage());
        }
        try {
            stringExtract("digite a data de termino da activity: (dd/MM/yyyy hh:mm:ss)");
            String finall = getString(input);
            Date datef = formatter.parse(finall);
            activity.setEnd(datef);
        } catch (ParseException e){
            stringExtract("Wrong format data" + e.getMessage());
        }

        stringExtract("Selecione o responsavel pela Activity:");
        for (DefaultUser defaultUser : listUsers) {
            stringExtract(defaultUser.getId() + "  - " + defaultUser.getName());
        }
        int num0 = input.nextInt();
        input.nextLine();
        Users nomeResp = listUsers.get(num0);
        activity.setResp(nomeResp);
        int cont = 0;
        stringExtract("selecione os profissionais envolvidos: \n");
        for (DefaultUser listUser : listUsers) {
            stringExtract(listUser.getId() + " - " + listUser.getName() + " ");
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
                stringExtract("Tamanho maximo de profissionais selecionado!");
                in += cont + 1;
            }
            else{
                stringExtract("""
                        Adicionar mais um?
                        1 - Selecionar
                        2 - Nao selecionar""");
                int aa = input.nextInt();
                input.nextLine();
                if (aa == 2) in = cont + 1;
                else if (aa == 1) {
                    in = 0;
                }
            }
        }
        activity.setProfs(listUserp);
        stringExtract("digite as tarefas a serem realizadas:");
        String jobs = getString(input);
        activity.setJobs(jobs);
        int size = listActivities.size();
        activity.setId(size);
        stack.push(activity);
        redo.setStkRedo(stack);
        listActivities.add(activity);
    }

    private static void stringExtract(String x) {
        System.out.println(x);
    }

    public static void addProject(Scanner input, List<Project> listProject, List<DefaultUser> listUsers, List<Activity> listActivities, int identificador, Pilha redo) {
        Stack<Project> stack = new Stack<>();
        var type = Coordenador.class;
        input.nextLine();
        if(listUsers.get(identificador).getClass().equals(type)) {
            Project project = Project.createProject();
            project.setStatus("Em processo de criacao");
            stringExtract("Digite o nome do Projeto:");
            String ident = getString(input);
            project.setIdent(ident);
            stringExtract("Digite a descricao do Projeto:");
            String desc = getString(input);
            project.setDesc(desc);
            DateFormat formatter = null;
            Date datei = null;
            try {
                stringExtract("Digite a data de inicio do projeto: (dd/MM/yyyy hh:mm:ss)");
                String inicio = getString(input);
                formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                datei = formatter.parse(inicio);
                project.setBegin(datei);
            } catch (ParseException e){
                stringExtract("Wrong format data" + e.getMessage());
            }
            try{
                stringExtract("digite a data de termino do projeto: (dd/MM/yyyy hh:mm:ss)");
                String finall = getString(input);
                Date datef = formatter.parse(finall);
                project.setEnd(datef);

                Calendar m_calendar = getCalendar();
                setFormatDate(datei, m_calendar);

                int nMonth1 = 12 * m_calendar.get(Calendar.YEAR)+ m_calendar.get(Calendar.MONTH);
                setFormatDate(datef, m_calendar);
                int nMonth2 = 12*m_calendar.get(Calendar.YEAR) + m_calendar.get(Calendar.MONTH);
                int diff = Math.abs(nMonth2 - nMonth1);
                stringExtract("Tempo: " + diff + "meses)");
                project.setTempo(diff);
            } catch (ParseException e){
                stringExtract("Wrong format data" + e.getMessage());
            }

            stringExtract("Selecione o coordenador do projeto:");
            for (int i = 0; i < listUsers.size(); i++) {
                if (listUsers.get(i).getClass().equals(type)) {
                    stringExtract(i + " - " + listUsers.get(i).getName() + " " + listUsers.get(i).getClass().toString());
                }
            }
            int num = input.nextInt();
            input.nextLine();
            DefaultUser nomeCoord =  listUsers.get(num);
            project.setCoord(nomeCoord);
            int cont = 0;
            stringExtract("selecione os profissionais envolvidos: \n");
            for (DefaultUser listUser : listUsers) {
                stringExtract(listUser.getId() + " - " + listUser.getName() + " ");
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
                    stringExtract("Tamanho maximo de profissionais selecionado!");
                    in += cont + 1;
                    break;
                }
                stringExtract("""
                        Adicionar mais um?
                        1 - Selecionar
                        2 - Nao selecionar""");
                int aa = input.nextInt();
                input.nextLine();
                if (aa == 2) in = cont + 1;
                else if (aa == 1) {
                    in = 0;
                }
            }

            project.setProfs(listUserp);
            try {
                stringExtract("Selecione as atividades a serem realizadas:");
                int inn = 0;
                int sizeatividade = listActivities.size();
                List<Activity> atividadesses = new ArrayList<>();
                while (inn != sizeatividade + 1) {
                    for (Activity listActivity : listActivities) {
                        stringExtract(listActivity.getId() + " " + listActivity.getDesc());
                    }
                    int num1 = input.nextInt();
                    Activity atividadeaux = listActivities.get(num1);
                    atividadesses.add(atividadeaux);
                    if (atividadesses.size() == listActivities.size()) {
                        inn += sizeatividade + 1;
                    }
                    stringExtract("""
                            Adicionar mais uma activity?
                            1 - Selecionar
                            2 - Nao selecionar""");
                    int aa = input.nextInt();
                    input.nextLine();
                    if (aa == 2) inn = sizeatividade + 1;
                    else if (aa == 1) {
                        inn = 0;
                    }
                }
                project.setActivities(atividadesses);
            } catch (IllegalArgumentException e){
                stringExtract("Empty Activity list!" + " " + e.getMessage());
            }
            stringExtract("Bolsa para cada profissional");
            for (int i = 0; i < listUsers.size(); i++) {
                stringExtract(listUserp.get(i).getName() + " ");
                double valor = input.nextDouble();
                input.nextLine();
                listUserp.get(i).setBolsa(valor);
            }
            project.setStatus("Iniciado");
            LocalDate today = LocalDate.now();
            Date todayd = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
            int coordopt;
            stringExtract("Iniciar projeto?" +
                    "1 - SIM\n" +
                    "2 - NAO");
            coordopt = input.nextInt();
            input.nextLine();
            if(coordopt == 1) {
                if((project.getBegin().after(todayd))){
                    project.setStatus("Em andamento");
                }
            } else if (coordopt == 2) {
                project.setStatus("Iniciado");
            }
            else stringExtract("Opcao Invalida!");
            stack.push(project);
            redo.setStkRedo(stack);
            listProject.add(project);
        }
        else{
            stringExtract("Voce nao tem permissao para isso!");
        }
    }

    private static void setFormatDate(Date date, Calendar m_calendar) {
        m_calendar.setTime(date);
    }

    private static Calendar getCalendar() {
        return Calendar.getInstance();
    }

    private static String getString(Scanner input) {
        return input.nextLine();
    }

}