package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import modelo.Aula;

public class AulaDAO {

    private Connection connection;

    public AulaDAO(Connection connection) {
        this.connection = connection;
    }

    public void createAula(Aula aula) {
        try {
            String sql = "INSERT INTO aulas (id_exercicio, modalidade, turno, funcionario_id_pessoa) VALUES (?, ?, ?, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, aula.getIdExercicio());
                pstm.setString(2, aula.getModalidade());
                pstm.setString(3, aula.getTurno());
                pstm.setString(4, aula.getFuncionarioIdPessoa());

                pstm.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Aula> retrieveAllAulas() {
        ArrayList<Aula> aulas = new ArrayList<>();

        try {
            String sql = "SELECT id_exercicio, modalidade, turno, funcionario_id_pessoa FROM aulas";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.execute();
                ResultSet rst = pstm.getResultSet();

                while (rst.next()) {
                    String idExercicio = rst.getString("id_exercicio");
                    String modalidade = rst.getString("modalidade");
                    String turno = rst.getString("turno");
                    String funcionarioIdPessoa = rst.getString("funcionario_id_pessoa");

                    Aula aula = new Aula(idExercicio, modalidade, turno, funcionarioIdPessoa);
                    aulas.add(aula);
                }
            }
            return aulas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
