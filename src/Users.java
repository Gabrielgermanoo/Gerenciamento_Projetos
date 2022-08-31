public class Users {
    private String name;
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
