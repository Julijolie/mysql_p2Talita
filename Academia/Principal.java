import dao.AulaDAO;
import dao.ClienteDAO;
import dao.ConnectionFactory;
import dao.FuncionarioDAO;
import modelo.Aula;
import modelo.Cliente;
import modelo.Funcionario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection connection = connectionFactory.recuperaConexao()) {
            Cliente cliente1 = new Cliente("Lucas", "12345678900", "123456789", "Plano A");
            Cliente cliente2 = new Cliente("Maria", "98765432100", "987654321", "Plano B");

            Funcionario funcionario1 = new Funcionario("1001", "Gerente", "João", "45678912300", "00000000");
            Funcionario funcionario2 = new Funcionario("1002", "Personal", "Fernanda", "78912345600", "000001");

            Aula aula1 = new Aula("1", "Musculação", "Manhã", "1001");
            Aula aula2 = new Aula("2", "Yoga", "Tarde", "1001");


            ClienteDAO clienteDAO = new ClienteDAO(connection);
            clienteDAO.createCliente(cliente1);
            clienteDAO.createCliente(cliente2);

            FuncionarioDAO funcionarioDAO = new FuncionarioDAO(connection);
            funcionarioDAO.createFuncionario(funcionario1);
            funcionarioDAO.createFuncionario(funcionario2);

            AulaDAO aulaDAO = new AulaDAO(connection);

            aulaDAO.createAula(aula1);
            aulaDAO.createAula(aula2);



            ArrayList<Cliente> clientes = clienteDAO.retrieveAllClientes();
            System.out.println("Clientes:");
            for (Cliente cliente : clientes) {
                System.out.println(cliente);
            }

            ArrayList<Funcionario> funcionarios = funcionarioDAO.retrieveAllFuncionarios();
            System.out.println("\nFuncionários:");
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario);
            }

            ArrayList<Aula> aulas = aulaDAO.retrieveAllAulas();

            System.out.println("Aulas:");
            for (Aula aula : aulas) {
                System.out.println(aula);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
