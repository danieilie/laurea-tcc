package model;

import java.util.Date;

public class AlunoTurma {

    private Aluno aluno;
    private Turma turma;
    private String frequencia;
    private Date data;

    public AlunoTurma() {
    }

    public AlunoTurma(Aluno aluno, Turma turma, Date data, String frequencia) {
        this.aluno = aluno;
        this.turma = turma;
        this.data = data;
        this.frequencia = frequencia;
    }

    @Override
    public String toString() {
        return getFrequencia() + getData();
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }

    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public String getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(String frequencia) {
        this.frequencia = frequencia;
    }

}
