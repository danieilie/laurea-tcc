package model;

import java.util.ArrayList;
import java.util.Date;

public class Contrato {

    private int idcontrato, parcela, status;
    private String serie, escola;
    private Date datacontrato, primeirovencimento;
    private double preco;
    private Aluno aluno;
    private ArrayList<Mensalidade> mensalidade;

    public Contrato() {
    }

    public Contrato(int idcontrato, int parcela, int status, String serie, String escola, Date datacontrato, Date primeirovencimento, double preco, Aluno aluno, ArrayList<Mensalidade> mensalidade) {
        this.idcontrato = idcontrato;
        this.parcela = parcela;
        this.status = status;
        this.serie = serie;
        this.escola = escola;
        this.datacontrato = datacontrato;
        this.primeirovencimento = primeirovencimento;
        this.preco = preco;
        this.aluno = aluno;
        this.mensalidade = mensalidade;
    }

    @Override
    public String toString() {
        return getSerie() + getEscola();
    }

    public int getIdcontrato() {
        return idcontrato;
    }

    public void setIdcontrato(int idcontrato) {
        this.idcontrato = idcontrato;
    }

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDatacontrato() {
        return datacontrato;
    }

    public void setDatacontrato(Date datacontrato) {
        this.datacontrato = datacontrato;
    }

    public Date getPrimeirovencimento() {
        return primeirovencimento;
    }

    public void setPrimeirovencimento(Date primeirovencimento) {
        this.primeirovencimento = primeirovencimento;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getEscola() {
        return escola;
    }

    public void setEscola(String escola) {
        this.escola = escola;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public ArrayList<Mensalidade> getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(ArrayList<Mensalidade> mensalidade) {
        this.mensalidade = mensalidade;
    }

}
