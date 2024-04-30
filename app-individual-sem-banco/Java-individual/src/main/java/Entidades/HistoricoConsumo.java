package Entidades;

import java.time.LocalDateTime;

import java.time.LocalDateTime;

public class HistoricoConsumo {
    private int idHistorico;
    private String tipoRecurso;
    private double valor;
    private LocalDateTime dataHora;
    private int fkMaquina;

    public HistoricoConsumo(int idHistorico, String tipoRecurso, double valor, LocalDateTime dataHora, int fkMaquina) {
        this.idHistorico = idHistorico;
        this.tipoRecurso = tipoRecurso;
        this.valor = valor;
        this.dataHora = dataHora;
        this.fkMaquina = fkMaquina;
    }

    // Getters e Setters
    public int getIdHistorico() {
        return idHistorico;
    }

    public void setIdHistorico(int idHistorico) {
        this.idHistorico = idHistorico;
    }

    public String getTipoRecurso() {
        return tipoRecurso;
    }

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public int getFkMaquina() {
        return fkMaquina;
    }

    public void setFkMaquina(int fkMaquina) {
        this.fkMaquina = fkMaquina;
    }

    @Override
    public String toString() {
        return "HistoricoConsumo{" +
                "idHistorico=" + idHistorico +
                ", tipoRecurso='" + tipoRecurso + '\'' +
                ", valor=" + valor +
                ", dataHora=" + dataHora +
                ", fkMaquina=" + fkMaquina +
                '}';
    }
}
