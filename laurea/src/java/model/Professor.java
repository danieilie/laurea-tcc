package model;

public class Professor {

    private int idprofessor, status;
    private String nome;
    private Usuario usuario;
    private Disciplina disciplina;

    public Professor() {
    }

    public Professor(int idprofessor, int status, String nome, Usuario usuario, Disciplina disciplina) {
        this.idprofessor = idprofessor;
        this.status = status;
        this.nome = nome;
        this.usuario = usuario;
        this.disciplina = disciplina;
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

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

}
