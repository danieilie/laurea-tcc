package model;

public class Menu {

    private int idmenu;
    private String menu;
    private String link;
    private String icone;
    private int exibir;

    public Menu() {
    }

    public Menu(int idmenu, String menu, String link, String icone, int exibir) {
        this.idmenu = idmenu;
        this.menu = menu;
        this.link = link;
        this.icone = icone;
        this.exibir = exibir;
    }

    @Override
    public String toString() {
        return getMenu() + getLink() + getIcone();
    }

    public int getExibir() {
        return exibir;
    }

    public void setExibir(int exibir) {
        this.exibir = exibir;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public int getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(int idmenu) {
        this.idmenu = idmenu;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

}
