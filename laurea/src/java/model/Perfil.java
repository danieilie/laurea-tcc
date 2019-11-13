package model;

import java.util.ArrayList;

public class Perfil {

    private int idperfil;
    private String perfil;
    private ArrayList<Menu> menus;
    private ArrayList<Menu> naoMenus;

    public Perfil() {
    }

    public Perfil(int idperfil, String perfil) {
        this.idperfil = idperfil;
        this.perfil = perfil;
    }

    public int getIdperfil() {
        return idperfil;
    }

    public void setIdperfil(int idperfil) {
        this.idperfil = idperfil;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return getPerfil();
    }

    public ArrayList<Menu> getMenus() {
        return menus;
    }

    public void setMenus(ArrayList<Menu> menus) {
        this.menus = menus;
    }

    public ArrayList<Menu> getNaoMenus() {
        return naoMenus;
    }

    public void setNaoMenus(ArrayList<Menu> naoMenus) {
        this.naoMenus = naoMenus;
    }

}
