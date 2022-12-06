package operations;

import models.Activity;
import models.DefaultUser;
import models.Project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reports extends Actions {
    public Reports(ArrayList<DefaultUser> users, ArrayList<Project> projects, ArrayList<Activity> activities) {
        super(users, projects, activities);
    }

    public static void projetoRelatorio(List<Project> listProject){
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Selecionar um projeto:\n");
            for (Project project : listProject) {
                System.out.println(project.getId() + " -  " + project.getIdent() + " ( " + project.getIdent() + " )");
            }
            int opt = input.nextInt();
            input.nextLine();
            gerarRelatorioProject(listProject, opt);
        } catch ( IllegalArgumentException e){
            System.out.println("Empty Activities list" + e.getMessage());
        }
    }
    static void gerarRelatorioProject(List<Project> listProject, int ident){

            System.out.println("Nome do Projeto: ");
            System.out.println(listProject.get(ident).getIdent());
            System.out.println("Descricao: \n" + listProject.get(ident).getDesc());
            System.out.println("Status atual: ");
            System.out.println(listProject.get(ident).getStatus());
            System.out.println("models.Coordenador: " +
                    listProject.get(ident).getCoord().getName());
            System.out.println("Profissionais envolvidos: ");
            for (int i = 0; i < listProject.get(ident).getProfs().size(); i++) {
                System.out.println(listProject.get(ident).getProfs().get(i).getName());
            }
            System.out.println("Atividades envolvidas no Projeto:\n");
            for (int i = 0; i < listProject.get(ident).getActivities().size(); i++) {
                System.out.println(listProject.get(ident).getActivities().get(i).getIdent() + " " + listProject.get(ident).getActivities().get(i).getDesc());
            }
            System.out.println("Inicio: " + listProject.get(ident).getBegin() + " \n" + "Termino: " + listProject.get(ident).getEnd());
            System.out.println("Tempo: " + listProject.get(ident).getTempo());
    }
    public static void atividadeRelatorio(List<Activity> listActivity){
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("Selecionar uma models.Activity:\n");
            for (Activity activity : listActivity) {
                System.out.println(activity.getId() + " -  " + activity.getIdent() + " ( " + activity.getIdent() + " )");
            }
            int opt = input.nextInt();
            input.nextLine();
            gerarRelatorioAtividade(listActivity, opt);
        } catch ( IllegalArgumentException e){
        System.out.println("Empty Activities list" + e.getMessage());
     }
    }
    static void gerarRelatorioAtividade(List<Activity> listActivity, int ident){
        System.out.println("Nome do Projeto: ");
        System.out.println(listActivity.get(ident).getIdent());
        System.out.println("Descricao: \n" + listActivity.get(ident).getDesc());
        System.out.println("Inicio: " + listActivity.get(ident).getBegin() + " \n" + "Termino: " + listActivity.get(ident).getEnd());
        System.out.println("Responsavel pela models.Activity: \n" +
                listActivity.get(ident).getResp().getName());
        System.out.println("Profissionais envolvidos: ");
        for (int i = 0; i < listActivity.get(ident).getProfs().size(); i++){
            System.out.println(listActivity.get(ident).getProfs().get(i).getName());
        }
    }
}
