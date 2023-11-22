import dao.ClienteDAO;
import dao.ConnectionFactory;
import dao.FuncionarioDAO;
import modelo.Cliente;
import modelo.Funcionario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection connection = connectionFactory.recuperaConexao()) {
            // Creating instances of Cliente
            Cliente cliente1 = new Cliente("Lucas", "12345678900", "123456789", "Plano A");
            Cliente cliente2 = new Cliente("Maria", "98765432100", "987654321", "Plano B");

            // Creating instances of Funcionario
            Funcionario funcionario1 = new Funcionario("1001", "Manager", "John Doe", "45678912300", "00000000");
            Funcionario funcionario2 = new Funcionario("1002", "Trainer", "Jane Smith", "78912345600", "000001");

            // Creating ClienteDAO instance and persisting Cliente data
            ClienteDAO clienteDAO = new ClienteDAO(connection);
            clienteDAO.createCliente(cliente1);
            clienteDAO.createCliente(cliente2);

            // Creating FuncionarioDAO instance and persisting Funcionario data
            FuncionarioDAO funcionarioDAO = new FuncionarioDAO(connection);
            funcionarioDAO.createFuncionario(funcionario1);
            funcionarioDAO.createFuncionario(funcionario2);

            // Retrieving and printing Cliente data from the database
            ArrayList<Cliente> clientes = clienteDAO.retrieveAllClientes();
            System.out.println("Clientes retrieved from the database:");
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }

            // Retrieving and printing Funcionario data from the database
            ArrayList<Funcionario> funcionarios = funcionarioDAO.retrieveAllFuncionarios();
            System.out.println("\nFuncionarios retrieved from the database:");
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
