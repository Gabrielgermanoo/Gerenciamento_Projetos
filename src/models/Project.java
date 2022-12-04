package models;

import interfaces.Users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Project {
    protected String ident;
    protected String desc;
    protected Date begin;
    protected Date end;
    protected DefaultUser resp;
    protected int id;
    protected int tempo;
    protected String status;
    protected DefaultUser coord;
    private String jobs;
    private List<Activity> activities;
    private List<DefaultUser> profs;

    private Project(){
        this.resp = new DefaultUser();
        this.coord = new Coordenador();
        this.activities = new ArrayList<>();
        this.profs = new ArrayList<>();
    }

    public static Project createProject() {
        return new Project();
    }


    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }


    public DefaultUser getCoord() {
        return coord;
    }

    public void setCoord(DefaultUser coord) {
        this.coord = coord;
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

    public Date getBegin() {
        return begin;
    }

    public void setBegin(Date begin) {
        this.begin = begin;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Users getResp() {
        return resp;
    }

    public void setResp(DefaultUser resp) {
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
