package model;

public class Atividade {

    private int idatividade;
    private String nome, arquivo;
    private Disciplina disciplina;

    public Atividade() {
    }

    public Atividade(int idatividade, String nome, String arquivo, Disciplina disciplina) {
        this.idatividade = idatividade;
        this.nome = nome;
        this.arquivo = arquivo;
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return getNome() + getArquivo();
    }

    public int getIdatividade() {
        return idatividade;
    }

    public void setIdatividade(int idatividade) {
        this.idatividade = idatividade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

}
