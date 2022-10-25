package acoes;

import interfaces.Users;
import acoes.Actions;
import models.Atividade;
import models.DefaultUser;
import models.Project;

import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Remove extends Actions {
    public Remove(){

    }

    public static void delProject(Scanner input, List<Project> listProject, Actions redo){
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

    public static void delAtividade(Scanner input, List<Atividade> listAtividade, Actions redo){
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
            Atividade atividade = listAtividade.get(del);
            listAtividade.remove(del);
            stack.push(atividade);
            redo.setStkRedo(stack);
        }
    }

    public static void delUser(Scanner input, List<DefaultUser> listUser, Actions redo){
        Stack stack = new Stack();
        Users user;
        if (listUser.size() <= 1){
            System.out.println("Nao ha funcionarios cadastrados");
        }
        else {
            System.out.println("Qual funcionario quer deletar? selecione um id:");
            for (int i = 0; i < listUser.size(); i++) {
                System.out.println(listUser.get(i).getName() + " " + listUser.get(i).getId());
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
