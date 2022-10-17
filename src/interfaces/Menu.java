package interfaces;

import acoes.Pilha;
import models.*;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public interface Menu {
    void stringPrincipal();
    void opcoesMenuE(int logged, List<DefaultUser> listUser, int identificador, Pilha redo, Pilha undo, List<Project> listProject, List<Atividade> listAtividades, MenuExt menu, MenuInt menu1) throws ParseException;
    int isLogged(int logged, List<DefaultUser> listUser, String login, String password, int identificador);
    void loggin(int logged, List<DefaultUser> listUser, int identificador, List<Project> listProject, Pilha redo, Pilha undo, List<Atividade> listAtividade, MenuExt menu, MenuInt menu1) throws ParseException;
    void stringUsers();
    void stringAtividades();
    void stringProject();
    void stringConsulta();
    void stringRelatorio();
    void stringActions();
    void stringRefazer();
    void stringDesfazer();
    void opcoesMenuI(Scanner input, List<DefaultUser> listUser, int identificador, String password, int logged, List<Project> listProject, Pilha redo, List<Atividade> listAtividade, Pilha undo) throws ParseException;
}
