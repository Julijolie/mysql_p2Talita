import dao.AulaDAO;
import dao.ClienteDAO;
import dao.ConnectionFactory;
import dao.FuncionarioDAO;
import dao.HistoricoDAO;
import modelo.Aula;
import modelo.Cliente;
import modelo.Funcionario;
import modelo.Historico;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

public class Principal {

    public static void main(String[] args) {
        ConnectionFactory connectionFactory = new ConnectionFactory();
        try (Connection connection = connectionFactory.recuperaConexao()) {
            Cliente cliente1 = new Cliente("Lucas", "12345678000", "123456789", "Plano A");
            Cliente cliente2 = new Cliente("Maria", "12345678111", "987654321", "Plano B");
            Cliente cliente3 = new Cliente("Ana", "12345678222", "432198745", "Plano A");
            Cliente cliente4 = new Cliente("Bia", "12345678333", "432154789", "Plano B");
            Cliente cliente5 = new Cliente("Carla", "12345678444", "123456789", "Plano A");
            Cliente cliente6 = new Cliente("Rose", "12345678555", "987453162", "Plano B");

            Funcionario funcionario1 = new Funcionario("1001", "Gerente", "João", "45678912300", "00000000");
            Funcionario funcionario2 = new Funcionario("1002", "Personal", "Fernanda", "78912345600", "000001");

            Aula aula1 = new Aula("1", "Musculação", "Manhã", "1001");
            Aula aula2 = new Aula("2", "Yoga", "Tarde", "1001");

            Historico historico1 = new Historico(1, LocalDate.of(2023, 11, 10), "Historico 1", 1);
            Historico historico2 = new Historico(2, LocalDate.of(2023, 11, 15), "Historico 2", 2);

            ClienteDAO clienteDAO = new ClienteDAO(connection);
            clienteDAO.criarCliente(cliente1);
            clienteDAO.criarCliente(cliente2);

            FuncionarioDAO funcionarioDAO = new FuncionarioDAO(connection);
            funcionarioDAO.criarFuncionario(funcionario1);
            funcionarioDAO.criarFuncionario(funcionario2);

            AulaDAO aulaDAO = new AulaDAO(connection);
            aulaDAO.createAula(aula1);
            aulaDAO.createAula(aula2);

            HistoricoDAO historicoDAO = new HistoricoDAO(connection);
            historicoDAO.criarHistorico(historico1);
            historicoDAO.criarHistorico(historico2);

            ArrayList<Funcionario> funcionarios = funcionarioDAO.recuperarFuncionarios();
            System.out.println("\nFuncionários:");
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario);
            }

            String idFuncionarioADeletar = "1001"; // id do funcionário que será deletado (demitido)
            funcionarioDAO.deletarFuncionario(idFuncionarioADeletar);
            // Verifica se o funcionário foi removido
            funcionarios = funcionarioDAO.recuperarFuncionarios();
            System.out.println("\nFuncionários após deletar:");
            for (Funcionario funcionario : funcionarios) {
                System.out.println(funcionario);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
