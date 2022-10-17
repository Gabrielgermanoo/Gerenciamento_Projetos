package models;

import acoes.*;
import interfaces.Menu;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class MenuInt implements Menu {
    public void stringPrincipal(){
        System.out.println("Selecione uma opcao: \n" +
                "1 - Usuarios\n" +
                "2 - Atividades\n" +
                "3 - Projetos\n" +
                "4 - Consultas\n" +
                "5 - Mudar senha\n" +
                "6 - Relatorios\n" +
                "7 - Gerenciar bolsas (Projetos) \n" +
                "8 - Acoes \n" +
                "9 - Sair");
    }
    @Override
    public void stringUsers(){
        System.out.println("Selecione uma opcao: \n" +
                "1 - Cadastrar Usuario\n" +
                "2 - Editar Usuario\n" +
                "3 - Deletar Usuario");
    }
    @Override
    public void stringAtividades(){
        System.out.println("Selecione uma opcao: \n" +
                "1 - Cadastrar Atividade\n" +
                "2 - Editar Atividade\n" +
                "3 - Deletar Atividade");
    }
    @Override
    public void stringProject(){
        System.out.println("Selecione uma opcao: \n" +
                "1 - Cadastrar Projeto\n" +
                "2 - Editar Projeto\n" +
                "3 - Deletar Projeto");
    }
    @Override
    public void stringRelatorio(){
        System.out.println("Relatorios:\n" +
                "1 - Relatorio de projeto\n" +
                "2 - Relatorio de atividade");
    }
    @Override
    public void stringConsulta(){
        System.out.println("1: Consultar usuarios");
        System.out.println("2: Consultar Atividades");
        System.out.println("3: Consultar Projetos");
    }
    @Override
    public void stringActions(){
        System.out.println("Selecione uma opcao: \n" +
                "1 - Desfazer\n" +
                "2 - Refazer");
    }
    public void stringRefazer(){
        System.out.println("REFAZER:\n" +
                "1 - User\n" +
                "2 - Atividade\n" +
                "3 - Projeto");
    }
    @Override
    public void stringDesfazer(){
        System.out.println("DESFAZER:\n" +
                "1 - User\n" +
                "2 - Atividade\n" +
                "3 - Projeto");
    }


    public MenuInt() {

    }

    public void opcoesMenuI(Scanner input, List<DefaultUser> listUser, int identificador, String password, int logged, List<Project> listProject, Pilha redo, List<Atividade> listAtividade, Pilha undo) throws ParseException {
        MenuInt menu = new MenuInt();
        Coordenador coordenador = new Coordenador();
        DefaultUser user = new DefaultUser();
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
                    stringAtividades();
                    option = input.nextInt();
                    switch (option) {
                        case 1 -> Add.addAtividade(input, listAtividade, listUser, redo);
                        case 2 -> Update.editAtividade(input, listAtividade, listUser, redo);
                        case 3 -> Remove.delAtividade(input, listAtividade, redo);
                        default -> System.out.println("Opcao invalida!");
                    }
                    break;
                case 3:
                    stringProject();
                    option = input.nextInt();
                    switch (option) {
                        case 1 -> Add.addProject(input, listProject, listUser, listAtividade, identificador, redo);
                        case 2 -> Update.editProject(input, listProject, listUser, listAtividade, identificador, redo);
                        case 3 -> Remove.delProject(input, listProject, redo);
                        default -> System.out.println("Opcao invalida!");
                    }
                    break;
                case 4:
                    stringConsulta();
                    option = input.nextInt();
                    switch (option) {
                        case 1:
                            System.out.println("Qual tipo de usuario você quer verificar?\n" +
                                    "1 - Coordenadores\n" +
                                    "2 - Todos os usuarios\n");
                            opt = input.nextInt();
                            switch (opt){
                                case 1 -> Consulta.consultaUser(listUser, coordenador);
                                case 2 -> Consulta.consultaUser(listUser);
                                default -> System.out.println("Opcao invalida!");
                            }
                        case 2:
                            Consulta.consultaAtividade(listAtividade);
                            break;
                        case 3:
                            Consulta.consultaProject(listProject);
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
                        case 1 -> Relatorio.projetoRelatorio(listProject);
                        case 2 -> Relatorio.atividadeRelatorio(listAtividade);
                        default -> System.out.println("Opcao invalida!");
                    }
                    break;
                case 7:
                    Bolsa.gerenciarBolsas(listProject);
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
                                case 2 -> Pilha.desfazer(redo, undo, listAtividade);
                                case 3 -> Pilha.desfazer(redo, undo, listProject);
                                default -> System.out.println("Opcao invalida!");
                            }
                        case 2:
                            stringRefazer();
                            opt = input.nextInt();
                            switch (opt) {
                                case 1 -> Pilha.refazer(redo, undo, listUser);
                                case 2 -> Pilha.refazer(redo, undo, listAtividade);
                                case 3 -> Pilha.refazer(redo, undo, listProject);
                                default -> System.out.println("Opcao invalida!");
                            }
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
    public void opcoesMenuE(int logged, List<DefaultUser> listUser, int identificador, Pilha redo, Pilha undo, List<Project> listProject, List<Atividade> listAtividades, MenuExt menu, MenuInt menu1) {

    }

    @Override
    public int isLogged(int logged, List<DefaultUser> listUser, String login, String password, int identificador) {
        return 0;
    }

    @Override
    public void loggin(int logged, List<DefaultUser> listUser, int identificador, List<Project> listProject, Pilha redo, Pilha undo, List<Atividade> listAtividade, MenuExt menu, MenuInt menu1) throws ParseException {

    }
}
