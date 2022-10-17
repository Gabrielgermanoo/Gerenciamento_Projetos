package models;

import interfaces.Users;

import java.util.Date;
import java.util.List;

public class Project {
    private String ident;
    private String desc;
    private Date inicio;
    private Date termino;
    private Users resp;
    private int id;
    private int tempo;
    private String status;
    private DefaultUser coord;

    private List<DefaultUser> profs;

    public List<Atividade> getAtividades() {
        return atividades;
    }

    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }

    private String jobs;

    private List<Atividade> atividades;

    public DefaultUser getCoord() {
        return coord;
    }

    public void setCoord(DefaultUser coord) {
        this.coord = coord;
    }

    public Project(){

    }
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

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DefaultUser> getProfs() {
        return profs;
    }

    public void setProfs(List<DefaultUser> profs) {
        this.profs = profs;
    }

    public String getJobs() {
        return jobs;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }
}
