package modelo;

import java.time.LocalDate;

public class Historico {

    private int id;
    private LocalDate data;
    private String descricao;
    private int fkCliente;

    public Historico(int id, LocalDate data, String descricao, int fkCliente) {
        this.id = id;
        this.data = data;
        this.descricao = descricao;
        this.fkCliente = fkCliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(int fkCliente) {
        this.fkCliente = fkCliente;
    }

    @Override
    public String toString() {
        return "Historico{" +
                "id=" + id +
                ", data=" + data +
                ", descricao='" + descricao + '\'' +
                ", fkCliente=" + fkCliente +
                '}';
    }
}
