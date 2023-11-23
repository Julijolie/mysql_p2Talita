package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import modelo.Historico;

public class HistoricoDAO {

    private Connection connection;

    public HistoricoDAO(Connection connection) {
        this.connection = connection;
    }

    public void criarHistorico(Historico historico) {
        try {
            String sql = "INSERT INTO historico (id, data, descricao, fk_cliente) VALUES (?, ?, ?, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setInt(1, historico.getId());
                pstm.setObject(2, historico.getData());
                pstm.setString(3, historico.getDescricao());
                pstm.setInt(4, historico.getFkCliente());

                pstm.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Historico> recuperarHistoricos() {
        ArrayList<Historico> historicos = new ArrayList<>();

        try {
            String sql = "SELECT * FROM historico";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                try (ResultSet rst = pstm.executeQuery()) {
                    while (rst.next()) {
                        int id = rst.getInt("id");
                        LocalDate data = rst.getObject("data", LocalDate.class);
                        String descricao = rst.getString("descricao");
                        int fkCliente = rst.getInt("fk_cliente");

                        Historico historico = new Historico(id, data, descricao, fkCliente);
                        historicos.add(historico);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return historicos;
    }

}
