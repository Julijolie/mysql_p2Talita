package modelo;

public class Aula {
    private String idExercicio;
    private String modalidade;
    private String turno;
    private String funcionarioIdPessoa;

    public Aula(String idExercicio, String modalidade, String turno, String funcionarioIdPessoa) {
        this.idExercicio = idExercicio;
        this.modalidade = modalidade;
        this.turno = turno;
        this.funcionarioIdPessoa = funcionarioIdPessoa;
    }

    public String getIdExercicio() {
        return idExercicio;
    }

    public void setIdExercicio(String idExercicio) {
        this.idExercicio = idExercicio;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getFuncionarioIdPessoa() {
        return funcionarioIdPessoa;
    }

    public void setFuncionarioIdPessoa(String funcionarioIdPessoa) {
        this.funcionarioIdPessoa = funcionarioIdPessoa;
    }

    @Override
    public String toString() {
        return "Aula{" +
                "idExercicio='" + idExercicio + '\'' +
                ", modalidade='" + modalidade + '\'' +
                ", turno='" + turno + '\'' +
                ", funcionarioIdPessoa='" + funcionarioIdPessoa + '\'' +
                '}';
    }
}
