package operations;

import interfaces.Users;
import models.Activity;
import models.DefaultUser;
import models.Project;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Remove extends Actions {
    public Remove(List<DefaultUser> users, List<Project> projects, List<Activity> activities){
        super(users, projects, activities);

    }

    public static void delProject(Scanner input, List<Project> listProject, Pilha redo){
        Stack<Object> stack = new Stack<>();
        if (listProject.size()==0){
            System.out.println("Nao ha projetos cadastrados");
        }
        else {
            System.out.println("Qual Projeto quer deletar? selecione um id:");
            for (Project value : listProject) {
                System.out.println(value.getIdent() + " " + value.getDesc() + " " + value.getId());
            }
            int del = input.nextInt();
            Project project = listProject.get(del);
            stack.push(project);
            redo.setStkRedo(stack);
            listProject.remove(del);
        }
    }

    public static void delAtividade(Scanner input, List<Activity> listActivity, Pilha redo){
        Stack<Activity> stack = new Stack<>();
        if (listActivity.size()==0){
            System.out.println("Nao ha atividades cadastradas");
        }
        else {
            System.out.println("Qual activity quer deletar? selecione um id:");
            for (Activity value : listActivity) {
                System.out.println(value.getIdent() + " " + value.getDesc() + " " + value.getId());
            }
            int del = input.nextInt();
            Activity activity = listActivity.get(del);
            listActivity.remove(del);
            stack.push(activity);
            redo.setStkRedo(stack);
        }
    }

    public static void delUser(Scanner input, List<DefaultUser> listUser, Pilha redo){
        Stack<Users> stack = new Stack<>();
        Users user;
        if (listUser.size() <= 1){
            System.out.println("Nao ha funcionarios cadastrados");
        }
        else {
            System.out.println("Qual funcionario quer deletar? selecione um id:");
            for (DefaultUser defaultUser : listUser) {
                System.out.println(defaultUser.getName() + " " + defaultUser.getId());
            }
            int del = input.nextInt();
            input.nextLine();
            user = listUser.get(del);
            listUser.remove(del);
            stack.push(user);
            redo.setStkRedo(stack);

        }
    }
}
