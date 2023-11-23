package dao;

import modelo.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClienteDAO {

    private Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    public void criarCliente(Cliente cliente) {
        try {
            String sql = "INSERT INTO cliente (nome, cpf, telefone, plano) VALUES (?, ?, ?, ?)";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.setString(1, cliente.getNome());
                pstm.setString(2, cliente.getCpf());
                pstm.setString(3, cliente.getTelefone());
                pstm.setString(4, cliente.getPlano());

                pstm.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Cliente> recuperarClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();

        try {
            String sql = "SELECT id_cliente, nome, cpf, telefone, plano FROM cliente";

            try (PreparedStatement pstm = connection.prepareStatement(sql)) {
                pstm.execute();
                ResultSet rst = pstm.getResultSet();

                while (rst.next()) {
                    int idCliente = rst.getInt("id_cliente");
                    String nome = rst.getString("nome");
                    String cpf = rst.getString("cpf");
                    String telefone = rst.getString("telefone");
                    String plano = rst.getString("plano");

                    Cliente cliente = new Cliente(idCliente, nome, cpf, telefone, plano);
                    clientes.add(cliente);
                }
            }
            return clientes;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //Juliana - estou com problema pra rodas o código, teste td, por favor
   public ArrayList<Cliente> recuperaAula() {
    ArrayList<Cliente> clientes = new ArrayList<>();
    Cliente ultima = null;

    // JUNÇÃO DE TABELAS---> RELAÇÃO N:M (CLIENTE - AULA)
    try {
        String sql = "SELECT c.id_cliente, c.plano, c.nome, c.cpf, c.telefone, a.id_exercicio, a.modalidade, a.turno "
                + "FROM cliente AS c "
                + "LEFT JOIN aula_cliente AS ac ON c.id_cliente = ac.fk_cliente "
                + "LEFT JOIN aulas AS a ON a.id_exercicio = ac.fk_aula";

        try (PreparedStatement pstm = connection.prepareStatement(sql)) {
            pstm.execute();

            try (ResultSet rst = pstm.getResultSet()) {
                while (rst.next()) {
                    // para garantir que apenas novos clientes ou clientes com IDs diferentes sejam processados.
                    if (ultima == null || ultima.getIdCliente() != rst.getInt("id_cliente")) {
                        int idCliente = rst.getInt("id_cliente");
                        String plano = rst.getString("plano");
                        String nome = rst.getString("nome");
                        String cpf = rst.getString("cpf");
                        String telefone = rst.getString("telefone");
                        Cliente cliente = new Cliente(idCliente, nome, cpf, telefone, plano);
                        clientes.add(cliente);
                        ultima = cliente;
                    }
                }
            }
        }
        return clientes;
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
}
