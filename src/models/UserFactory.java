package models;

public class UserFactory {
    public static void getUser(int opt){
        switch (opt) {
            case 1 -> new DefaultUser();
            case 2 -> new Coordenador();
            default -> System.out.println("Wrong type of user, please select a valid user");
        }
    }
}
