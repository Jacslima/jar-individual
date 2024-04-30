package Models;

import Conexao.Conexao;
import com.github.britooo.looca.api.core.Looca;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class HistoricoConsumoDAO {
    private Conexao conexao = new Conexao();
    private Looca looca = new Looca();
    private Timer timer = new Timer();
    private int idVolatil;


    public void insertHistoricoCpu() {
        double consumoCpu = looca.getProcessador().getUso() * 100.0; // Multiplicar por 100 para obter a porcentagem de uso
        LocalDateTime dataHora = LocalDateTime.now();
        String insertHistoricoCpuSQL = "INSERT INTO historico_consumo_cpu (consumoCpu, dataHora) VALUES (?, ?)";
        try {
            PreparedStatement psHistoricoCpu = conexao.getConexao().prepareStatement(insertHistoricoCpuSQL);
            psHistoricoCpu.setDouble(1, consumoCpu);
            psHistoricoCpu.setTimestamp(2, Timestamp.valueOf(dataHora));
            psHistoricoCpu.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Exibir o resultado apenas uma vez
        String sistemasOperacional = looca.getSistema().getSistemaOperacional();
        String resultado = "Sistema Operacional: " + sistemasOperacional + "\n" +
                "Consumo CPU (%): " + String.format("%.2f", consumoCpu) + "\n" +
                "Data e Hora: " + dataHora + "\n";
        System.out.println(resultado);
    }




    public void insertHistoricoRam() {
        double consumoRam = (looca.getMemoria().getEmUso() / (double) looca.getMemoria().getTotal()) * 100;
        LocalDateTime dataHora = LocalDateTime.now();
        String insertHistoricoRamSQL = "INSERT INTO historico_consumo_ram (consumoRam, dataHora) VALUES (?, ?)";
        try {
            PreparedStatement psHistoricoRam = conexao.getConexao().prepareStatement(insertHistoricoRamSQL);
            psHistoricoRam.setDouble(1, consumoRam);
            psHistoricoRam.setTimestamp(2, Timestamp.valueOf(dataHora));
            psHistoricoRam.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Exibir o resultado apenas uma vez
        String resultado = "Consumo RAM (%): " + String.format("%.2f", consumoRam) + "\n" +
                "Data e Hora: " + dataHora + "\n";
        System.out.println(resultado);
    }


    public void insertHistoricoJanelas() {
        Integer janelasAbertas = looca.getGrupoDeJanelas().getTotalJanelas();
        LocalDateTime dataHora = LocalDateTime.now();
        String insertHistoricoJanelasSQL = "INSERT INTO historico_janelas (totalJanelas, dataHora) VALUES (?, ?)";
        try {
            PreparedStatement psHistoricoJanelas = conexao.getConexao().prepareStatement(insertHistoricoJanelasSQL);
            psHistoricoJanelas.setInt(1, janelasAbertas);
            psHistoricoJanelas.setTimestamp(2, Timestamp.valueOf(dataHora));
            psHistoricoJanelas.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Exibir o resultado apenas uma vez
        String resultado = "Janelas Abertas: " + janelasAbertas + "\n" +
                "Data e Hora: " + dataHora + "\n";
        System.out.println(resultado);
    }

    public void insertHistoricoGeral() {
        insertHistoricoCpu();
        insertHistoricoRam();
        insertHistoricoJanelas();
    }



    public Looca getLooca() {
        return looca;
    }

    public void setLooca(Looca looca) {
        this.looca = looca;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public int getIdVolatil() {
        return idVolatil;
    }

    public void setIdVolatil(int idVolatil) {
        this.idVolatil = idVolatil;
    }
}

