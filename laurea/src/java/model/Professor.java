package model;

public class Professor {

    private int idprofessor, status;
    private String nome;
    private Usuario usuario;

    public Professor() {
    }

    public Professor(int idprofessor, String nome, int status, Usuario usuario) {
        this.idprofessor = idprofessor;
        this.nome = nome;
        this.status = status;
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return getNome();
    }

    public int getIdprofessor() {
        return idprofessor;
    }

    public void setIdprofessor(int idprofessor) {
        this.idprofessor = idprofessor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
