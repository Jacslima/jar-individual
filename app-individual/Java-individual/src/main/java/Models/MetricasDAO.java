package Models;

import Conexao.Conexao;
import Entidades.Metricas;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MetricasDAO {
    public static Metricas obterMetricasPorEmpresa(String cnpj) {
        String sql = "SELECT * FROM Metricas WHERE fkEmpresa = ?";
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ps.setString(1, cnpj);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int idMetrica = rs.getInt("idMetrica");
                int compCpu = rs.getInt("CompCpu");
                double compDisco = rs.getDouble("CompDisco");
                double compRam = rs.getDouble("CompRam");
                return new Metricas(idMetrica, compCpu, compDisco, compRam, cnpj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao obter métricas.");
        }
        return null;
    }
}
