package arraylist;

public class Partido {
    private String local;
    private String visitante;
    private int golesL;
    private int golesV;

    public Partido(String data){
        String[] p = data.split("::");
        this.local = p[0];
        this.visitante = p[1];
        this.golesL = Integer.parseInt(p[2]);
        this.golesV = Integer.parseInt(p[3]);
    }

    public String getLocal() {
        return local;
    }

    public String getVisitante() {
        return visitante;
    }

    public int getGolesL() {
        return golesL;
    }

    public int getGolesV() {
        return golesV;
    }
    public boolean esEmpate() {
        return golesL == golesV;
    }
    public boolean ganoLocal() {
        return golesL > golesV;
    }
    public boolean ganoVisitante() {
        return golesV > golesL;
    }

    @Override
    public String toString() {
        return String.format("%-15s %d - %d %-15s", local, golesL, golesV, visitante);
    }

    
    

}
