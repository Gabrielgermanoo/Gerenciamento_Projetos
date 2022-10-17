package models;

import acoes.Add;
import acoes.Pilha;
import interfaces.Menu;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class MenuExt implements Menu {
    public void opcoesMenuE(int logged, List<DefaultUser> listUser, int identificador, Pilha redo, Pilha undo, List<Project> listProject, List<Atividade> listAtividades, MenuExt menu, MenuInt menu1) throws ParseException {
        loop: while (true) {
            Scanner input = new Scanner(System.in).useDelimiter("\n");
            menu.stringPrincipal();
            int opt = input.nextInt();
            switch (opt) {
                case 1:
                    menu.loggin(logged, listUser, identificador, listProject, redo, undo, listAtividades, menu, menu1);
                    break;
                case 2:
                    Add.addUser(input, listUser, redo);
                    break;
                case 3:
                    break loop;
                default:
                    System.out.println("Opcao invalida!");
            }
        }
    }
    public void stringPrincipal(){
        System.out.println("Selecione uma opcao:\n" +
                "1 - Login\n" +
                "2 - Cadastro de usuario\n" +
                "3 - Sair");
    }
    public int isLogged(int logged, List<DefaultUser> listUser, String login, String password, int identificador){
        for (DefaultUser defaultUser : listUser) {
            if (defaultUser.getLogin().equals(login) && defaultUser.getPassword().equals(password)) {
                logged = 1;
                System.out.println("Logado com sucesso!");
                identificador = defaultUser.getId();
                return 1;
            }
        }
        System.out.println("Senha ou Usuario incorretos!");
        return 0;
    }

    public void loggin(int logged, List<DefaultUser> listUser, int identificador, List<Project> listProject, Pilha redo, Pilha undo, List<Atividade> listAtividade, MenuExt menu, MenuInt menu1) throws ParseException {
        //System.out.println(listUser.get(0).getName());
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        System.out.println("Login:");
        String login = input.nextLine();
        System.out.println("Senha: ");
        String password = input.nextLine();
        while( menu.isLogged(logged, listUser, login, password, identificador) == 1) {
            menu1.opcoesMenuI(input, listUser, identificador, password, logged, listProject, redo, listAtividade, undo);
            break;
        }
        //System.out.println(logged);

    }

    @Override
    public void stringUsers() {

    }

    @Override
    public void stringAtividades() {

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
    public void opcoesMenuI(Scanner input, List<DefaultUser> listUser, int identificador, String password, int logged, List<Project> listProject, Pilha redo, List<Atividade> listAtividade, Pilha undo) throws ParseException {

    }

}
