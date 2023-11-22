package modelo;

public class Cliente {

    private int idCliente;
    private String nome;
    private String cpf;
    private String telefone;
    private String plano;

    public Cliente(int idCliente, String nome, String cpf, String telefone, String plano) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.plano = plano;
    }

    public Cliente(String nome, String cpf, String telefone, String plano) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.plano = plano;
    }

    // Getters and setters for attributes

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPlano() {
        return plano;
    }

    public void setPlano(String plano) {
        this.plano = plano;
    }

    @Override
    public String toString() {
        return "{'cliente':{'idCliente': " + this.idCliente + ", 'nome': '" + this.nome + "', 'plano': '" + this.plano + "'}}";
    }
}
