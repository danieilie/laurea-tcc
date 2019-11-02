package model;

import java.util.ArrayList;

public class Professor {

    private int idprofessor, status;
    private String nome;
    private Usuario usuario;
    private Disciplina disciplina;
    private ArrayList<Professor> professoresVinculadosPorAtividades;
    private ArrayList<Professor> professoresNaoVinculadosPorAtividades;

    public Professor() {
    }

    public Professor(int idprofessor, int status, String nome, Usuario usuario, Disciplina disciplina, ArrayList<Professor> professoresVinculadosPorAtividades, ArrayList<Professor> professoresNaoVinculadosPorAtividades) {
        this.idprofessor = idprofessor;
        this.status = status;
        this.nome = nome;
        this.usuario = usuario;
        this.disciplina = disciplina;
        this.professoresVinculadosPorAtividades = professoresVinculadosPorAtividades;
        this.professoresNaoVinculadosPorAtividades = professoresNaoVinculadosPorAtividades;
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

    public ArrayList<Professor> getProfessoresVinculadosPorAtividades() {
        return professoresVinculadosPorAtividades;
    }

    public void setProfessoresVinculadosPorAtividades(ArrayList<Professor> professoresVinculadosPorAtividades) {
        this.professoresVinculadosPorAtividades = professoresVinculadosPorAtividades;
    }

    public ArrayList<Professor> getProfessoresNaoVinculadosPorAtividades() {
        return professoresNaoVinculadosPorAtividades;
    }

    public void setProfessoresNaoVinculadosPorAtividades(ArrayList<Professor> professoresNaoVinculadosPorAtividades) {
        this.professoresNaoVinculadosPorAtividades = professoresNaoVinculadosPorAtividades;
    }

}
