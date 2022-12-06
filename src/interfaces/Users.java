package interfaces;

import models.DefaultUser;

import java.util.List;

public interface Users {
    String getName();
    void setName(String name);
    int getBolsa();
    void setBolsa(double bolsa);
    int getId();
    void setId(int id);
    void changePass(List<DefaultUser> listUser, int identificador, String password);
    void consultaUser();
    String getPassword();
    void setPassword(String password);
    DefaultUser addName(String name);
    DefaultUser addLogin(String login);

    void addPassword(String password);
    DefaultUser addId(int id);
}
