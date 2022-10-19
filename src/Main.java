import acoes.Pilha;
import acoes.Process;
import interfaces.Menu;
import models.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MenuExt menu = new MenuExt();
        MenuInt menu1 = new MenuInt();
        List<DefaultUser> listUser = new ArrayList<>();
        List<Atividade> listAtividade = new ArrayList<>();
        List<Project> listProject = new ArrayList<>();
        Pilha redo = new Pilha(), undo = new Pilha();
        int logged = 0, identificador = 0;
        while(true){
            Process.processMenuExt(menu, logged, listUser, identificador,redo, undo, listProject, listAtividade, menu1);
            break;
        }
    }
}
