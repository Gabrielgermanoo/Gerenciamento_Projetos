package models;

public class Coordenador extends DefaultUser {
    public Coordenador(){
    }
    @Override
    public String toString(){
        return this.getName();
    }
}
