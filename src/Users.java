import java.util.List;
import java.util.Stack;

public class Users {
    private String name;
    private String login;
    private String password;
    private List<Project> listUserProjects;
    private List<Atividades> listUserAtividades;
    private Acoes stackUsers;

    public Acoes getStackUsers() {
        return stackUsers;
    }

    public void setStackUsers(Acoes stackUsers) {
        this.stackUsers = stackUsers;
    }

    public List<Atividades> getListUserAtividades() {
        return listUserAtividades;
    }

    public void setListUserAtividades(List<Atividades> listUserAtividades) {
        this.listUserAtividades = listUserAtividades;
    }

    public List<Project> getListUserProjects() {
        return listUserProjects;
    }

    public void setListUserProjects(List<Project> listUserProjects) {
        this.listUserProjects = listUserProjects;
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

    private String type;
    private int id;
    private double bolsa;
    public Users(){

    }
    public void setName(String name){
        this.name = name;
    }
    public void setType(String type){
        this.type = type;
    }

    public double getBolsa() {
        return bolsa;
    }

    public void setBolsa(double bolsa) {
        this.bolsa = bolsa;
    }

    public void setId(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public String getType(){
        return type;
    }
    public int getId(){
        return id;
    }
}
