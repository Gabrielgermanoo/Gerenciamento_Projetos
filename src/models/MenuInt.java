package models;

import operations.*;
import interfaces.Menu;

import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuInt implements Menu {
    public void stringPrincipal(){
        System.out.println("""
                Selecione uma opcao:\s
                1 - Usuarios
                2 - Atividades
                3 - Projetos
                4 - Consultas
                5 - Mudar senha
                6 - Relatorios
                7 - Gerenciar bolsas (Projetos)\s
                8 - Acoes\s
                9 - Sair""");
    }
    @Override
    public void stringUsers(){
        System.out.println("""
                Selecione uma opcao:\s
                1 - Cadastrar Usuario
                2 - Editar Usuario
                3 - Deletar Usuario""");
    }
    @Override
    public void stringActivities(){
        System.out.println("""
                Selecione uma opcao:\s
                1 - Cadastrar Atividade
                2 - Editar Atividade
                3 - Deletar Atividade""");
    }
    @Override
    public void stringProject(){
        System.out.println("""
                Selecione uma opcao:\s
                1 - Cadastrar Projeto
                2 - Editar Projeto
                3 - Deletar Projeto""");
    }
    @Override
    public void stringRelatorio(){
        System.out.println("""
                Relatorios:
                1 - Relatorio de projeto
                2 - Relatorio de activity""");
    }
    @Override
    public void stringConsulta(){
        System.out.println("1: Consultar usuarios");
        System.out.println("2: Consultar Atividades");
        System.out.println("3: Consultar Projetos");
    }
    @Override
    public void stringActions(){
        System.out.println("""
                Selecione uma opcao:\s
                1 - Desfazer
                2 - Refazer""");
    }
    public void stringRefazer(){
        System.out.println("""
                REFAZER:
                1 - User
                2 - Atividade
                3 - Projeto""");
    }
    @Override
    public void stringDesfazer(){
        System.out.println("""
                DESFAZER:
                1 - User
                2 - Atividade
                3 - Projeto""");
    }


    public MenuInt() {

    }

    public void optMenuI(Scanner input, List<DefaultUser> listUser, int identificador, String password, int logged, List<Project> listProject, Pilha redo, List<Activity> listActivity, Pilha undo) throws ParseException, NumberFormatException, NullPointerException, InputMismatchException {
        MenuInt menu = new MenuInt();
        Coordenador coordenador = new Coordenador();
        DefaultUser user = DefaultUser.createDefaultUser();
        loop: while(true) {
            menu.stringPrincipal();
            int opt = input.nextInt();
            switch (opt) {
                case 1:
                    stringUsers();
                    int option = input.nextInt();
                    switch (option) {
                        case 1 -> Add.addUser(input, listUser, redo);
                        case 2 -> Update.editUser(input, listUser, redo);
                        case 3 -> Remove.delUser(input, listUser, redo);
                        default -> System.out.println("Opcao invalida!");
                    }
                    break;
                case 2:
                    stringActivities();
                    option = input.nextInt();
                    switch (option) {
                        case 1 -> Add.addAtividade(input, listActivity, listUser, redo);
                        case 2 -> Update.editAtividade(input, listActivity, listUser, redo);
                        case 3 -> Remove.delAtividade(input, listActivity, redo);
                        default -> System.out.println("Opcao invalida!");
                    }
                    break;
                case 3:
                    stringProject();
                    option = input.nextInt();
                    switch (option) {
                        case 1 -> Add.addProject(input,listProject, listUser, listActivity, identificador, redo);
                        case 2 -> Update.editProject(input, listProject, listUser, listActivity, identificador, redo);
                        case 3 -> Remove.delProject(input, listProject, redo);
                        default -> System.out.println("Opcao invalida!");
                    }
                    break;
                case 4:
                    stringConsulta();
                    option = input.nextInt();
                    switch (option) {
                        case 1:
                            System.out.println("""
                                    Qual tipo de usuario você quer verificar?
                                    1 - Coordenadores
                                    2 - Todos os usuarios
                                    """);
                            opt = input.nextInt();
                            switch (opt){
                                case 1 -> Query.consultaUser(listUser, coordenador);
                                case 2 -> Query.consultaUser(listUser);
                                default -> System.out.println("Opcao invalida!");
                            }
                        case 2:
                            Query.consultaAtividade(listActivity);
                            break;
                        case 3:
                            Query.consultaProject(listProject);
                            break;
                        default:
                            System.out.println("Opcao invalida!");
                    }
                    break;
                case 5:
                    user.changePass(listUser, identificador, password);
                    break;
                case 6:
                    stringRelatorio();
                    option = input.nextInt();
                    switch (option) {
                        case 1 -> Reports.projetoRelatorio(listProject);
                        case 2 -> Reports.atividadeRelatorio(listActivity);
                        default -> System.out.println("Opcao invalida!");
                    }
                    break;
                case 7:
                    Bolsa.bountyManager(listProject);
                    break;
                case 8:
                    stringActions();
                    option = input.nextInt();
                    switch (option) {
                        case 1:
                            stringDesfazer();
                            opt = input.nextInt();
                            switch (opt) {
                                case 1 -> Pilha.desfazer(redo, undo, listUser);
                                case 2 -> Pilha.desfazer(redo, undo, listActivity);
                                case 3 -> Pilha.desfazer(redo, undo, listProject);
                                default -> System.out.println("Opcao invalida!");
                            }
                            break;
                        case 2:
                            stringRefazer();
                            opt = input.nextInt();
                            switch (opt) {
                                case 1 -> Pilha.refazer(redo, undo, listUser);
                                case 2 -> Pilha.refazer(redo, undo, listActivity);
                                case 3 -> Pilha.refazer(redo, undo, listProject);
                                default -> System.out.println("Opcao invalida!");
                            }
                            break;
                        default:
                            System.out.println("Opcao invalida!");
                    }
                    break;
                case 9:
                    break loop;
                default:
                    System.out.println("Opcao invalida!");
                    break;
            }
        }
    }
    @Override
    public void optMenuE(int logged, List<DefaultUser> listUser, int identificador, Pilha redo, Pilha undo, List<Project> listProject, List<Activity> listActivities, MenuExt menu, MenuInt menu1) {

    }

    @Override
    public int isLogged(int logged, List<DefaultUser> listUser, String login, String password, int identificador) {
        return 0;
    }

    @Override
    public void login(int logged, List<DefaultUser> listUser, int identificador, List<Project> listProject, Pilha redo, Pilha undo, List<Activity> listActivity, MenuExt menu, MenuInt menu1) {

    }
}
