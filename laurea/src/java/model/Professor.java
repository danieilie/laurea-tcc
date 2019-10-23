package model;

public class Professor {

    private int idprofessor;
    private String nome;
    private Disciplina disciplina;
    private Usuario usuario;

    public Professor() {
    }

    public Professor(int idprofessor, String nome, Disciplina disciplina, Usuario usuario) {
        this.idprofessor = idprofessor;
        this.nome = nome;
        this.disciplina = disciplina;
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

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
