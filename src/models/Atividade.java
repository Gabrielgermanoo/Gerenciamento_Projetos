package models;

import interfaces.Users;

import java.util.Date;
import java.util.List;

public class Atividade {
    public Atividade(){

    }

    private String ident;
    private String desc;
    private Date inicio;
    private Date termino;
    private Users resp;
    private int id;
    private List<Users> profs;
    private String jobs;

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getTermino() {
        return termino;
    }

    public void setTermino(Date termino) {
        this.termino = termino;
    }

    public Users getResp() {
        return resp;
    }

    public void setResp(Users resp) {
        this.resp = resp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Users> getProfs() {
        return profs;
    }

    public void setProfs(List<Users> profs) {
        this.profs = profs;
    }

    public String getJobs() {
        return jobs;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

}
