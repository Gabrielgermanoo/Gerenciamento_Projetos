package acoes;

import models.Atividade;
import models.Coordenador;
import models.DefaultUser;
import models.Project;

import java.util.List;

public class Consulta extends Actions {
    public static void consultaAtividade(List<Atividade> listAtividade) {
        for (int i = 0; i < listAtividade.size(); i++) {
            System.out.println(listAtividade.get(i).getId() + " " + listAtividade.get(i).getDesc());
        }
    }

    public static void consultaProject(List<Project> listProject) {
        for (int i = 0; i < listProject.size(); i++) {
            System.out.println(listProject.get(i).getId() + " " + listProject.get(i).getDesc());
        }
    }

    public static void consultaUser(List<DefaultUser> listUser) {
        for (int i = 0; i < listUser.size(); i++) {
            System.out.println(listUser.get(i).getName() + " - " + listUser.get(i).getClass().toString());
        }
    }

    public static void consultaUser(List<DefaultUser> listUser, Coordenador coordenador) {
        var type = coordenador.getClass();
        for (int i = 0; i < listUser.size(); i++) {
            if(listUser.get(i).getClass().equals(type)) {
                System.out.println(i + listUser.get(i).getName() + " - " + "Coordenador");
            }
        }
    }
}
