package model;

public class Turma {

    private int idturma;
    private String nome;
    private Professor professor;

    public Turma() {
    }

    public Turma(int idturma, String nome, Professor professor) {
        this.idturma = idturma;
        this.nome = nome;
        this.professor = professor;
    }

    @Override
    public String toString() {
        return getNome();
    }

    public int getIdturma() {
        return idturma;
    }

    public void setIdturma(int idturma) {
        this.idturma = idturma;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    
}
