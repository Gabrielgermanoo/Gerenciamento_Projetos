package operations;

import interfaces.Users;
import models.Activity;
import models.DefaultUser;
import models.Project;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Update extends Actions {
    public static void editUser(Scanner input, List<DefaultUser> listUser, Pilha redo){
        Stack stack = new Stack();
        System.out.println("Select a user to update");
        int cont = 0;
        for (DefaultUser defaultUser : listUser) {
            System.out.println(defaultUser.getName() + " " + " " + cont++);
        }
        int num = input.nextInt();
        input.nextLine();
        System.out.printf("Selected user: %s\n", listUser.get(num).getName());
        Users user = listUser.get(num);
        System.out.printf("Edit name (%s)\n", listUser.get(num).getName());
        String name = input.nextLine();
        user.setName(name);
        stack.push(user);
        redo.setStkRedo(stack);
    }
    public static void editAtividade(Scanner input, List<Activity> listActivities, List<DefaultUser> listUsers, Pilha redo) {
        Stack<Activity> stack = new Stack<>();
        System.out.println("Select a activity to update");
        for (Activity listActivity : listActivities) {
            System.out.println(listActivity.getId() + " " + listActivity.getDesc() + " " + listActivity.getId());
        }
        int numm = input.nextInt();
        input.nextLine();
        Activity activity = listActivities.get(numm);
        System.out.println("Write the name of activity:");
        String ident = input.nextLine();
        activity.setIdent(ident);
        System.out.println("Write the description of activity:");
        String desc = input.nextLine();
        activity.setDesc(desc);
        DateFormat formatter = null;
        try {
            System.out.println("Write the beginning date of activity: (dd/MM/yyyy hh:mm:ss)");
            String inicio = input.nextLine();
            formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date datei = formatter.parse(inicio);
            activity.setBegin(datei);
        } catch( ParseException e){
            System.out.println("Wrong format data" + e.getMessage());
        }
        try {
            System.out.println("Write the final date of activity: (dd/MM/yyyy hh:mm:ss)");
            String finall = input.nextLine();
            Date datef = formatter.parse(finall);
            activity.setEnd(datef);
        } catch (ParseException e){
            System.out.println("Wrong format data" + e.getMessage());
        }
        System.out.println("Select the responsible for activity:");
        for (DefaultUser listUser : listUsers) {
            System.out.println(listUser.getId() + "  - " + listUser.getName() + " ( " + " )");
        }
        int num0 = input.nextInt();
        input.nextLine();
        Users nomeResp = listUsers.get(num0);
        activity.setResp(nomeResp);
        int cont = 0;
        System.out.println("select the professionals involved: \n");
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
                System.out.println("Number of professionals excepted!");
                in = cont + 1;
            }
            else{
                System.out.println("""
                        Add one more?
                        1 - Add?
                        2 - Don't""");
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
        activity.setJobs(jobs);
        stack.push(activity);
        redo.setStkRedo(stack);
        listActivities.add(activity);
    }
    public static void editProject(Scanner input, List<Project> listProject, List<DefaultUser> listUsers, List<Activity> listActivities, int identificador, Pilha redo) throws NullPointerException {
        Stack<Project> stack = new Stack<>();
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
            project.setBegin(datei);
        } catch (ParseException e){
            System.out.println("Wrong format data" + e.getMessage());
        }
        try{
            System.out.println("digite a data de termino do projeto: (dd/MM/yyyy hh:mm:ss)");
            String finall = input.nextLine();
            Date datef = formatter.parse(finall);
            project.setEnd(datef);
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
            System.out.println("""
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
        try {
            System.out.println("Selecione as atividades a serem realizadas:");
            int inn = 0;
            int sizeatividade = listActivities.size();
            List<Activity> atividadesses = new ArrayList<>();
            while (inn != sizeatividade + 1) {
                for (Activity listActivity : listActivities) {
                    System.out.println(listActivity.getId() + " " + listActivity.getDesc());
                }
                int num1 = input.nextInt();
                Activity atividadeaux = listActivities.get(num1);
                atividadesses.add(atividadeaux);
                if (atividadesses.size() == listActivities.size()) {
                    inn += sizeatividade + 1;
                }
                System.out.println("""
                        Adicionar mais uma atividade?
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
