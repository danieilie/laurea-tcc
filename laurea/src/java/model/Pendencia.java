package model;

public class Pendencia {

    private int idpendencia;
    private double valor;
    private Aluno aluno;

    public Pendencia() {
    }

    public Pendencia(int idpendencia, double valor, Aluno aluno) {
        this.idpendencia = idpendencia;
        this.valor = valor;
        this.aluno = aluno;
    }

    @Override
    public String toString() {
        return "Valor a ser pago : " + getValor();
    }

    public int getIdpendencia() {
        return idpendencia;
    }

    public void setIdpendencia(int idpendencia) {
        this.idpendencia = idpendencia;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

}
