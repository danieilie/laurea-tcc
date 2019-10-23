package model;

public class Turma {

    private int idturma;
    private String diasemana, datahora;
    private Professor professor;

    public Turma() {
    }

    public Turma(int idturma, String diasemana, Professor professor, String datahora) {
        this.idturma = idturma;
        this.diasemana = diasemana;
        this.professor = professor;
        this.datahora = datahora;
    }

    @Override
    public String toString() {
        return getDiasemana() + getDatahora();
    }

    public int getIdturma() {
        return idturma;
    }

    public void setIdturma(int idturma) {
        this.idturma = idturma;
    }

    public String getDiasemana() {
        return diasemana;
    }

    public void setDiasemana(String diasemana) {
        this.diasemana = diasemana;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getDatahora() {
        return datahora;
    }

    public void setDatahora(String datahora) {
        this.datahora = datahora;
    }

}
