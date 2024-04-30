package Entidades;

public class Metricas {
    private int idMetrica;
    private int compCpu;
    private double compDisco;
    private double compRam;
    private String fkEmpresa;

    public Metricas(int idMetrica, int compCpu, double compDisco, double compRam, String fkEmpresa) {
        this.idMetrica = idMetrica;
        this.compCpu = compCpu;
        this.compDisco = compDisco;
        this.compRam = compRam;
        this.fkEmpresa = fkEmpresa;
    }

    // Getters e Setters
    public int getIdMetrica() {
        return idMetrica;
    }

    public void setIdMetrica(int idMetrica) {
        this.idMetrica = idMetrica;
    }

    public int getCompCpu() {
        return compCpu;
    }

    public void setCompCpu(int compCpu) {
        this.compCpu = compCpu;
    }

    public double getCompDisco() {
        return compDisco;
    }

    public void setCompDisco(double compDisco) {
        this.compDisco = compDisco;
    }

    public double getCompRam() {
        return compRam;
    }

    public void setCompRam(double compRam) {
        this.compRam = compRam;
    }

    public String getFkEmpresa() {
        return fkEmpresa;
    }

    public void setFkEmpresa(String fkEmpresa) {
        this.fkEmpresa = fkEmpresa;
    }
}
