package models;

import operations.Add;
import operations.Pilha;
import operations.Process;
import interfaces.Menu;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class MenuExt implements Menu {

    public void optMenuE(int logged, List<DefaultUser> listUser, int identificador, Pilha redo, Pilha undo, List<Project> listProject, List<Activity> listActivities, MenuExt menu, MenuInt menu1) throws ParseException, NumberFormatException, NullPointerException {
        loop: while (true) {
            Scanner input = new Scanner(System.in).useDelimiter("\n");
            menu.stringPrincipal();
            int opt = input.nextInt();
            switch (opt) {
                case 1:
                    menu.login(logged, listUser, identificador, listProject, redo, undo, listActivities, menu, menu1);
                    break;
                case 2:
                    Add.addUser(input, listUser, redo);
                    break;
                case 3:
                    System.out.println("You logged out! See you next time.");
                    break loop;
                default:
                    System.out.println("Opcao invalida!");
            }
        }
    }
    public void stringPrincipal(){
        System.out.println("""
                Selecione uma opcao:
                1 - Login
                2 - Cadastro de usuario
                3 - Sair""");
    }
    public int isLogged(int logged, List<DefaultUser> listUser, String login, String password, int identificador){
        for (DefaultUser defaultUser : listUser) {
            if (defaultUser.getLogin().equals(login) && defaultUser.getPassword().equals(password)) {
                System.out.println("Logado com sucesso!");
                identificador = defaultUser.getId();
                return 1;
            }
        }
        System.out.println("Senha ou Usuario incorretos!");
        return 0;
    }

    public void login(int logged, List<DefaultUser> listUser, int identificador, List<Project> listProject, Pilha redo, Pilha undo, List<Activity> listActivity, MenuExt menu, MenuInt menu1) {
        //System.out.println(listUser.get(0).getName());
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Login:");
        String login = input.nextLine();
        System.out.println("Senha: ");
        String password = input.nextLine();
        while( menu.isLogged(logged, listUser, login, password, identificador) == 1) {
            Process.processMenuInt(menu1, input, listUser, identificador, password, logged, listProject, redo, listActivity, undo);
            break;
        }
        //System.out.println(logged);

    }

    @Override
    public void stringUsers() {

    }

    @Override
    public void stringActivities() {

    }

    @Override
    public void stringProject() {

    }

    @Override
    public void stringConsulta() {

    }

    @Override
    public void stringRelatorio() {

    }

    @Override
    public void stringActions() {

    }

    @Override
    public void stringRefazer() {

    }

    @Override
    public void stringDesfazer() {

    }

    @Override
    public void optMenuI(Scanner input, List<DefaultUser> listUser, int identificador, String password, int logged, List<Project> listProject, Pilha redo, List<Activity> listActivity, Pilha undo) {

    }

}
