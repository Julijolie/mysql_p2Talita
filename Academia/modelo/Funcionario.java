package modelo;

public class Funcionario {

    private String idPessoa;
    private String cargo;
    private String nome;
    private String cpf;
    private String telefone;

    public Funcionario(String idPessoa, String cargo, String nome, String cpf, String telefone) {
        this.idPessoa = idPessoa;
        this.cargo = cargo;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
    }

    // Getters and setters for attributes

    public String getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(String idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
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

    @Override
    public String toString() {
        return "{'funcionario':{'idPessoa': '" + this.idPessoa + "', 'nome': '" + this.nome + "', 'cargo': '" + this.cargo + "'}}";
    }
}
