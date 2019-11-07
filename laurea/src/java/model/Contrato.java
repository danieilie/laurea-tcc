package model;

import java.util.Date;

public class Contrato {

    private int idcontrato, parcela, status;
    private String serie, escola, datacontrato;
//    private Date datacontrato;
    private double preco;
    private Aluno aluno;
    private Mensalidade mensalidade;

    public Contrato() {
    }

    public Contrato(int idcontrato, int parcela, int status, String datacontrato, String serie, String escola, double preco, Aluno aluno, Mensalidade mensalidade) {
        this.idcontrato = idcontrato;
        this.parcela = parcela;
        this.status = status;
        this.datacontrato = datacontrato;
        this.serie = serie;
        this.escola = escola;
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

    public String getDatacontrato() {
        return datacontrato;
    }

    public void setDatacontrato(String datacontrato) {
        this.datacontrato = datacontrato;
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

    public Mensalidade getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(Mensalidade mensalidade) {
        this.mensalidade = mensalidade;
    }

}
