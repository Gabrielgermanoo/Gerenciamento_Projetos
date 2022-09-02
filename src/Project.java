import java.util.Date;
import java.util.List;

public class Project {
    private String ident;
    private String desc;
    private Date inicio;
    private Date termino;
    private Users coord;
    private List<Users> profs;
    private Atividades atividades;
    private int id;
    private int tempo;

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

    public Users getCoord() {
        return coord;
    }

    public void setCoord(Users coord) {
        this.coord = coord;
    }

    public Atividades getAtividades() {
        return atividades;
    }

    public void setAtividades(Atividades atividades) {
        this.atividades = atividades;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    public List<Users> getProfs() {
        return profs;
    }

    public void setProfs(List<Users> profs) {
        this.profs = profs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }





}


