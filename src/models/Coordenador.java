package models;

public class Coordenador extends DefaultUser {
    public Coordenador(){
        super();
    }
    @Override
    public String toString(){
        return this.getName();
    }
}
