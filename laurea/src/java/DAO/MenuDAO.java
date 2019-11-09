package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Menu;

public class MenuDAO extends DataBaseDAO {

    public MenuDAO() throws Exception {
    }

    public ArrayList<Menu> getLista() throws Exception {

        ArrayList<Menu> lista = new ArrayList<Menu>();
        String sql = "SELECT * FROM menu";
        this.conectar();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            Menu m = new Menu();
            m.setIdmenu(rs.getInt("idmenu"));
            m.setMenu(rs.getString("menu"));
            m.setLink(rs.getString("link"));
            m.setIcone(rs.getString("icone"));
            m.setExibir(rs.getInt("exibir"));
            lista.add(m);
        }
        this.desconectar();
        return lista;
    }

    public boolean gravar(Menu m) {

        try {
            String sql;
            this.conectar();
            if (m.getIdmenu() == 0) {
                sql = "INSERT INTO menu(menu, link, icone, exibir) VALUES(?,?,?,?) ";
            } else {
                sql = "UPDATE menu SET menu=?, link=?, icone=?, exibir=? WHERE idmenu=?";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, m.getMenu());
            pstm.setString(2, m.getLink());
            pstm.setString(3, m.getIcone());
            pstm.setInt(4, m.getExibir());
            if (m.getIdmenu() > 0) {
                pstm.setInt(5, m.getIdmenu());
            }
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public Menu getCarregaPorId(int idmenu) throws Exception {

        Menu m = new Menu();
        String sql = "SELECT * FROM menu WHERE idmenu=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idmenu);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            m.setIdmenu(rs.getInt("idmenu"));
            m.setMenu(rs.getString("menu"));
            m.setLink(rs.getString("link"));
            m.setIcone(rs.getString("icone"));
            m.setExibir(rs.getInt("exibir"));
        }
        this.desconectar();
        return m;
    }

    public boolean desativar(Menu m) {
        try {
            this.conectar();
            String sql = "UPDATE menu WHERE idmenu=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, m.getIdmenu());
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
