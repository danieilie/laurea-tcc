package model;

public class Responsavel {

    private int idresponsavel;
    private String nome, cpf, rg;
    private Usuario usuario;

    public Responsavel() {
    }

    public Responsavel(int idresponsavel, String nome, String cpf, String rg, Usuario usuario) {
        this.idresponsavel = idresponsavel;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return getNome() + getCpf() + getRg();
    }

    public int getIdresponsavel() {
        return idresponsavel;
    }

    public void setIdresponsavel(int idresponsavel) {
        this.idresponsavel = idresponsavel;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
