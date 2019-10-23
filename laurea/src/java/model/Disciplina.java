package model;

public class Disciplina {

    private int iddisciplina;
    private String materia;

    public Disciplina() {
    }

    public Disciplina(int iddisciplina, String materia) {
        this.iddisciplina = iddisciplina;
        this.materia = materia;
    }

    @Override
    public String toString() {
        return getMateria();
    }

    public int getIddisciplina() {
        return iddisciplina;
    }

    public void setIddisciplina(int iddisciplina) {
        this.iddisciplina = iddisciplina;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

}
