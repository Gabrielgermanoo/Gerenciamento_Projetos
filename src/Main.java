import acoes.Pilha;
import interfaces.Menu;
import models.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Scanner input = new Scanner(System.in).useDelimiter("\n");
        MenuExt menu = new MenuExt();
        MenuInt menu1 = new MenuInt();
        List<DefaultUser> listUser = new ArrayList<>();
        List<Atividade> listAtividade = new ArrayList<>();
        List<Project> listProject = new ArrayList<>();
        Pilha redo = new Pilha(), undo = new Pilha();
        String password = "", login = "";
        int opt = 0;
        int logged = 0, identificador = 0;
        while(true){
            menu.opcoesMenuE(logged, listUser, identificador, redo, undo, listProject, listAtividade, menu, menu1);
            break;
        }
    }
}
