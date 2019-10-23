package model;

public class Usuario {

    private int idusuario;
    private String nome;
    private String login;
    private String senha;
    private int status;
    private Perfil perfil;

    public Usuario() {
    }

    public Usuario(int idusuario, String nome, String login, String senha, int status, Perfil perfil) {
        this.idusuario = idusuario;
        this.nome = nome;
        this.login = login;
        this.senha = senha;
        this.status = status;
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return getNome() + getLogin() + getSenha();
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getCpf() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}
