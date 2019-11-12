package model;

import java.util.Date;

public class Aluno {

    private int idaluno, status;
    private String nome, cpf, rg;
    private Date datanasc;
    private Responsavel responsavel;
    private Usuario usuario;

    public Aluno() {
    }

    public Aluno(int idaluno, int status, String nome, String cpf, String rg, Date datanasc, Responsavel responsavel, Usuario usuario) {
        this.idaluno = idaluno;
        this.status = status;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.datanasc = datanasc;
        this.responsavel = responsavel;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return getNome() + getCpf() + getRg();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIdaluno() {
        return idaluno;
    }

    public void setIdaluno(int idaluno) {
        this.idaluno = idaluno;
    }

    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
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

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Responsavel getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Responsavel responsavel) {
        this.responsavel = responsavel;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
