package models;

import acoes.Actions;

import java.util.List;
import java.util.Scanner;

public class Bolsa extends Actions {
    public static void gerenciarBolsas(List<Project> listProject){
        Scanner input = new Scanner(System.in);
        for (Project project : listProject) {
            System.out.println(project.getId() + " - " + project.getIdent() + " " + project.getDesc());
        }
        int opt = input.nextInt();
        input.nextLine();
        bolsa(listProject, opt);
    }
    public static void bolsa(List<Project> listProject, int id){
        for(int i = 0; i < listProject.size(); i++) {
            System.out.println("Profissional: " + listProject.get(id).getProfs().get(i).getName() + " valor bolsa: "
                    + listProject.get(id).getProfs().get(i).getBolsa() + "(" + listProject.get(id).getProfs().get(i).getBolsa() * listProject.get(id).getTempo() + " ) ");
        }
    }
}
