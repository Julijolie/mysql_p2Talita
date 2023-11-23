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
}
