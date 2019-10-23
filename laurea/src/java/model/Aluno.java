package model;

//import java.util.ArrayList;
public class Aluno {

    private int idaluno;
    private String nome, cpf, rg, datanasc;
    private Responsavel responsavel;
    private Usuario usuario;
    //private ArrayList<Usuario> alunos;
    //private ArrayList<Usuario> naoAlunos;

    public Aluno() {
    }

    public Aluno(int idaluno, String datanasc, String nome, String cpf, String rg, Responsavel responsavel /*, Usuario usuario, ArrayList<Usuario> alunos, ArrayList<Usuario> naoAlunos  */) {
        this.idaluno = idaluno;
        this.datanasc = datanasc;
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
        this.responsavel = responsavel;
        this.usuario = usuario;
        //this.alunos = alunos;
        //this.naoAlunos = naoAlunos;
    }

    @Override
    public String toString() {
        return getNome() + getCpf() + getRg();
    }

    public int getIdaluno() {
        return idaluno;
    }

    public void setIdaluno(int idaluno) {
        this.idaluno = idaluno;
    }

    public String getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(String datanasc) {
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

    /**
     * public ArrayList<Usuario> getAlunos() { return alunos; }
     *
     * public void setAlunos(ArrayList<Usuario> alunos) { this.alunos = alunos;
     * }
     *
     * public ArrayList<Usuario> getNaoAlunos() { return naoAlunos; }
     *
     * public void setNaoAlunos(ArrayList<Usuario> naoAlunos) { this.naoAlunos =
     * naoAlunos; }
     *
     */
}
