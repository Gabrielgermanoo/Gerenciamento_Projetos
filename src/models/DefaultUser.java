package models;

import interfaces.Users;

import java.util.List;
import java.util.Scanner;

public class DefaultUser implements Users {
    private String name;
    private static String login;
    private static String password;


    public DefaultUser() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int getBolsa() {
        return 1;
    }

    @Override
    public void setBolsa(double bolsa) {

    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }

    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }


    public void consultaUser(){
        System.out.println(this.name + this.login);
    }



    public void changePass(List<DefaultUser> listUser, int identificador, String password){
        Scanner input = new Scanner(System.in);
        System.out.println("Qual a nova senha?");
        for(int i = 0; i < listUser.size(); i++){
            if(listUser.get(i).getId() == identificador){
                password = input.nextLine();
                listUser.get(i).setPassword(password);
            }
        }
        System.out.println("Alterada com sucesso!");
    }
}
