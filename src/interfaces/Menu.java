package interfaces;

import operations.Pilha;
import models.*;

import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public interface Menu {
    void stringPrincipal();
    void optMenuE(int logged, List<DefaultUser> listUser, int identificador, Pilha redo, Pilha undo, List<Project> listProject, List<Activity> listActivities, MenuExt menu, MenuInt menu1) throws ParseException;
    int isLogged(int logged, List<DefaultUser> listUser, String login, String password, int identificador);
    void login(int logged, List<DefaultUser> listUser, int identificador, List<Project> listProject, Pilha redo, Pilha undo, List<Activity> listActivity, MenuExt menu, MenuInt menu1) throws ParseException;
    void stringUsers();
    void stringActivities();
    void stringProject();
    void stringConsulta();
    void stringRelatorio();
    void stringActions();
    void stringRefazer();
    void stringDesfazer();
    void optMenuI(Scanner input, List<DefaultUser> listUser, int identificador, String password, int logged, List<Project> listProject, Pilha redo, List<Activity> listActivity, Pilha undo) throws ParseException;
}
