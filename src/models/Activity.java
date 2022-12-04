package models;

import interfaces.Users;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Activity {
    private Activity(){
        this.resp = new DefaultUser();
        this.profs = new ArrayList<>();
    }
    public static Activity createActivity() {
        return new Activity();
    }

    private String ident;
    private String desc;
    private Date begin;
    private Date end;
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
