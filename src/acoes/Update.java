package acoes;

import interfaces.Users;
import models.Atividade;
import models.DefaultUser;
import models.Project;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Update extends Actions {
    public static void editUser(Scanner input, List<DefaultUser> listUser, Actions redo){
        Stack stack = new Stack<>();
        System.out.println("Selecione um usuario para atualizar");
        int cont = 0;
        for (DefaultUser defaultUser : listUser) {
            System.out.println(defaultUser.getName() + " " + " " + cont++);
        }
        int num = input.nextInt();
        input.nextLine();
        System.out.printf("Usuario selecionado: %s\n", listUser.get(num).getName());
        Users user = listUser.get(num);
        System.out.printf("Editar nome (%s)\n", listUser.get(num).getName());
        String name = input.nextLine();
        user.setName(name);
        stack.push(user);
        redo.setStkRedo(stack);
    }
    public static void editAtividade(Scanner input, List<Atividade> listAtividades, List<DefaultUser> listUsers, Actions redo) throws ParseException {
        Stack stack = new Stack();
        System.out.println("Selecione uma models.Atividade para atualizar");
        for (Atividade listAtividade : listAtividades) {
            System.out.println(listAtividade.getId() + " " + listAtividade.getDesc() + " " + listAtividade.getId());
        }
        int numm = input.nextInt();
        input.nextLine();
        Atividade atividade = listAtividades.get(numm);
        System.out.println("Digite o nome da atividade:");
        String ident = input.nextLine();
        atividade.setIdent(ident);
        System.out.println("Digite a descricao da atividade:");
        String desc = input.nextLine();
        atividade.setDesc(desc);
        DateFormat formatter = null;
        try {
            System.out.println("Digite a data de inicio da atividade: (dd/MM/yyyy hh:mm:ss)");
            String inicio = input.nextLine();
            formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date datei = formatter.parse(inicio);
            atividade.setInicio(datei);
        } catch( ParseException e){
            System.out.println("Wrong format data" + e.getMessage());
        }
        try {
            System.out.println("digite a data de termino da atividade: (dd/MM/yyyy hh:mm:ss)");
            String finall = input.nextLine();
            Date datef = formatter.parse(finall);
            atividade.setTermino(datef);
        } catch (ParseException e){
            System.out.println("Wrong format data" + e.getMessage());
        }
        System.out.println("Selecione o responsavel pela models.Atividade:");
        for (DefaultUser listUser : listUsers) {
            System.out.println(listUser.getId() + "  - " + listUser.getName() + " ( " + " )");
        }
        int num0 = input.nextInt();
        input.nextLine();
        Users nomeResp = listUsers.get(num0);
        atividade.setResp(nomeResp);
        int cont = 0;
        System.out.println("selecione os profissionais envolvidos: \n");
        for (DefaultUser listUser : listUsers) {
            System.out.println(listUser.getId() + " - " + listUser.getName() + " ");
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
    public static void editProject(Scanner input, List<Project> listProject, List<DefaultUser> listUsers, List<Atividade> listAtividades, int identificador, Actions redo) throws ParseException, NullPointerException {
        Stack stack = new Stack();
        System.out.println("Select a Project to update");
        for (Project value : listProject) {
            System.out.println(value.getId() + " " + value.getDesc() + " " + value.getId());
        }
        int numm = input.nextInt();
        input.nextLine();
        Project project = listProject.get(numm);
        System.out.println("Type the name of Project:");
        String ident = input.nextLine();
        project.setIdent(ident);
        System.out.println("Describe the Project:");
        String desc = input.nextLine();
        project.setDesc(desc);
        DateFormat formatter = null;
        Date datei = null;
        try {
            System.out.println("Digite a data de inicio do projeto: (dd/MM/yyyy hh:mm:ss)");
            String inicio = input.nextLine();
            formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            datei = formatter.parse(inicio);
            project.setInicio(datei);
        } catch (ParseException e){
            System.out.println("Wrong format data" + e.getMessage());
        }
        try{
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
        } catch (ParseException e){
            System.out.println("Wrong format data" + e.getMessage());
        }
        System.out.println("Selecione o coordenador do projeto:");
        for (int i = 0; i < listUsers.size(); i++) {
            var type = listUsers.getClass();
            if (listUsers.get(i).getClass().equals(type)) {
                System.out.println(i + ": " + listUsers.get(i).getName());
            }
        }
        int num = input.nextInt();
        input.nextLine();
        DefaultUser nomeCoord = listUsers.get(num);
        project.setCoord(nomeCoord);
        int cont = 0;
        System.out.println("selecione os profissionais envolvidos: \n");
        for (DefaultUser listUser : listUsers) {
            System.out.println(listUser.getId() + " - " + listUser.getName());
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
        try {
            System.out.println("Selecione as atividades a serem realizadas:");
            int inn = 0;
            int sizeatividade = listAtividades.size();
            List<Atividade> atividadess = new ArrayList<>();
            while (inn != sizeatividade + 1) {
                for (int i = 0; i < listAtividades.size(); i++) {
                    System.out.println(listAtividades.get(i).getId() + " " + listAtividades.get(i).getDesc());
                }
                int num1 = input.nextInt();
                Atividade atividadeaux = listAtividades.get(num1);
                atividadess.add(atividadeaux);
                if (atividadess.size() == listAtividades.size()) {
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
        } catch (IllegalArgumentException e){
            System.out.println("Empty Activity list!" + " " + e.getMessage());
        }
        System.out.println("Bolsa para cada profissional");
        for (int i = 0; i < listUsers.size(); i++) {
            System.out.println(listUserp.get(i).getName());
            double valor = input.nextDouble();
            input.nextLine();
            listUserp.get(i).setBolsa(valor);
        }
        System.out.println("Periodo de vigencia");
        int tempo = input.nextInt();
        input.nextLine();
        project.setTempo(tempo);
        LocalDate today = java.time.LocalDate.now();
        Date todayd = Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant());
        int coordopt;
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
}
