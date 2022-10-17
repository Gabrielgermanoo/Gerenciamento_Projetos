package acoes;

import models.Atividade;
import models.DefaultUser;
import models.Project;

import java.text.ParseException;
import java.util.*;

public abstract class Actions {


    private Stack setStkUndo;
    private Stack setStkRedo;

    /*
    Acoes para add os tipos de objetos
     */
    public static void addUser(Scanner input, List listUser, Actions redo){}
    public static void addProject(Scanner input, List<Project> listProject, List<DefaultUser> listUsers, List<Atividade> listAtividades, int identificador, Actions redo) throws ParseException {}
    public static void addAtividade(Scanner input, List<Atividade> listAtividades, List<DefaultUser> listUsers, Actions redo) throws ParseException {}

    /*
    Acoes para deletar os tipos de objetos
     */
    public static void editUser(Scanner input, List<DefaultUser> listUser, Actions redo){}
    public static void editAtividade(Scanner input, List<Atividade> listAtividades, List<DefaultUser> listUsers, Actions redo) throws ParseException {}
    public static void editProject(Scanner input, List<Project> listProject, List<DefaultUser> listUsers, List<Atividade> listAtividades, int identificador, Actions redo) throws ParseException {}

    /*
    Acoes para deletar os tipos de objetos
     */
    static void delProject(Scanner input, List<Project> listProject, Actions redo){}
    static void delAtividade(Scanner input, List<Atividade> listAtividade, Actions redo){}
    static void delUser(Scanner input, List<DefaultUser> listUser, Actions redo){}
    public Stack getStkUndo() { return setStkUndo; }

    public void setStkUndo(Stack setStkUndo) { this.setStkUndo = setStkUndo; }

    public Stack getStkRedo() { return setStkRedo; }

    public void setStkRedo(Stack setStkRedo) { this.setStkRedo = setStkRedo; }


    public static void gerenciarBolsas(List<Project> listProject){
        Scanner input = new Scanner(System.in);
        for(int i = 0; i < listProject.size(); i++){
            System.out.println(listProject.get(i).getId() + " - " + listProject.get(i).getIdent() + " " + listProject.get(i).getDesc());
        }
        int opt = input.nextInt();
        input.nextLine();
        bolsa(listProject, opt);
    }
    public static void bolsa(List<Project> listProject, int id){
        for(int i = 0; i < listProject.size(); i++) {
            System.out.println("Profissional: " + listProject.get(id).getProfs().get(i).getName() + " valor bolsa: "
                    + listProject.get(id).getProfs().get(i).getBolsa() + "(" + listProject.get(id).getProfs().get(i).getBolsa() * listProject.get(i).getTempo() + " ) ");
        }
    }


}
