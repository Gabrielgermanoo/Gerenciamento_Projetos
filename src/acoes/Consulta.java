package acoes;

import models.Atividade;
import models.Coordenador;
import models.DefaultUser;
import models.Project;

import java.util.List;

public class Consulta extends Actions {
    public static void consultaAtividade(List<Atividade> listAtividade) {
        try {
            for (int i = 0; i < listAtividade.size(); i++) {
                System.out.println(listAtividade.get(i).getId() + " " + listAtividade.get(i).getDesc());
            }
        } catch (IllegalArgumentException e){
            System.out.println("No Activities listed");
        }
    }

    public static void consultaProject(List<Project> listProject) {
        try {
            for (int i = 0; i < listProject.size(); i++) {
                System.out.println(listProject.get(i).getId() + " " + listProject.get(i).getDesc());
            }
        }catch (IllegalArgumentException e){
            System.out.println("No Projects listed");
        }
    }

    public static void consultaUser(List<DefaultUser> listUser) {
        for (int i = 0; i < listUser.size(); i++) {
            System.out.println(listUser.get(i).getName() + " - " + listUser.get(i).getClass().toString());
        }
    }

    public static void consultaUser(List<DefaultUser> listUser, Coordenador coordenador) {
        try {

            var type = coordenador.getClass();
            for (int i = 0; i < listUser.size(); i++) {
                if (listUser.get(i).getClass().equals(type)) {
                    System.out.println(i + listUser.get(i).getName() + " - " + "Coordenador");
                }
            }
        } catch (IllegalArgumentException e){
            System.out.println("Empty list Coordenador Users!");
        }
    }
}
