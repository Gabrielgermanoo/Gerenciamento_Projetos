import java.util.Date;

public class Atividades {
    private String ident;
    private String desc;
    private Date inicio;
    private Date termino;
    private String resp;

    private int id;

    public String getResp() {
        return resp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfs() {
        return profs;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public void setProfs(String profs) {
        this.profs = profs;
    }

    private String profs;
    private String jobs;

    public Atividades(){
    }

    public String getIdent() {
        return ident;
    }

    public void setIdent(String ident) {
        this.ident = ident;
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

    public String getJobs() {
        return jobs;
    }

    public void setJobs(String jobs) {
        this.jobs = jobs;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
