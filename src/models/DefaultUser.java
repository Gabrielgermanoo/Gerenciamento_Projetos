package models;

import interfaces.Users;

import java.util.List;
import java.util.Scanner;

public class DefaultUser implements Users {
    protected String name, login, password;
    protected int id;
    DefaultUser() {

    }

    public static DefaultUser createDefaultUser() {
        return new DefaultUser();
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
        System.out.println(this.name + login);
    }

    public DefaultUser addName(String name){
        this.name = name;
        return this;
    }

    public DefaultUser addLogin(String login){
        this.login = login;
        return this;
    }

    public void addPassword(String password){
        this.password = password;
    }

    public DefaultUser addId(int id){
        this.id = id;
        return this;
    }

    public void changePass(List<DefaultUser> listUser, int identificador, String password){
        Scanner input = new Scanner(System.in);
        try{
            System.out.println("Qual a nova senha?");
            for (DefaultUser defaultUser : listUser) {
                if (defaultUser.getId() == identificador) {
                    password = input.nextLine();
                    defaultUser.setPassword(password);
                }
            }
            System.out.println("Alterada com sucesso!");
        } catch (IllegalArgumentException e){
            System.out.println("Empty list of users!");
        }
    }
}
