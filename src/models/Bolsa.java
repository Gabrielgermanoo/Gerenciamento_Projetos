package models;

import operations.Actions;

import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Bolsa extends Actions {
    public static void bountyManager(List<Project> listProject){
        Scanner input = new Scanner(System.in);
        for (Project project : listProject) {
            System.out.println(project.getId() + " - " + project.getIdent() + " " + project.getDesc());
        }
        int opt = input.nextInt();
        input.nextLine();
        bounty(listProject, opt);
    }
    public static void bounty(List<Project> listProject, int id){
        IntStream.range(0, listProject.size()).mapToObj(i -> "Profissional: " + listProject.get(id).getProfs().get(i).getName() + " valor bolsa: "
                + listProject.get(id).getProfs().get(i).getBolsa() + "(" + listProject.get(id).getProfs().get(i).getBolsa() * listProject.get(id).getTempo() + " ) ").forEach(System.out::println);
    }
}
