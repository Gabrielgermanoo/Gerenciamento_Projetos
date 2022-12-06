package operations;

import models.Activity;
import models.Coordenador;
import models.DefaultUser;
import models.Project;

import java.util.ArrayList;
import java.util.List;

public class Query extends Actions {
    public Query(ArrayList<DefaultUser> users, ArrayList<Project> projects, ArrayList<Activity> activities) {
        super(users, projects, activities);
    }

    public static void consultaAtividade(List<Activity> listActivity) {
        try {
            for (Activity activity : listActivity) {
                System.out.println(activity.getId() + " " + activity.getDesc());
            }
        } catch (IllegalArgumentException e){
            System.out.println("No Activities listed");
        }
    }

    public static void consultaProject(List<Project> listProject) {
        try {
            for (Project project : listProject) {
                System.out.println(project.getId() + " " + project.getDesc());
            }
        }catch (IllegalArgumentException e){
            System.out.println("No Projects listed");
        }
    }

    public static void consultaUser(List<DefaultUser> listUser) {
        for (DefaultUser defaultUser : listUser) {
            System.out.println(defaultUser.getName() + " - " + defaultUser.getClass().toString());
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
