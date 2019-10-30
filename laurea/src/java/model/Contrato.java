package model;

import java.util.Date;

public class Contrato {

    private int idcontrato, parcela, status;
    private String serie, escola;
    private Date datacontrato;
    private double preco;
    private Aluno aluno;

    public Contrato() {
    }

    public Contrato(int idcontrato, int parcela, int status, Date datacontrato, String serie, String escola, double preco, Aluno aluno) {
        this.idcontrato = idcontrato;
        this.parcela = parcela;
        this.status = status;
        this.datacontrato = datacontrato;
        this.serie = serie;
        this.escola = escola;
        this.preco = preco;
        this.aluno = aluno;
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

}
