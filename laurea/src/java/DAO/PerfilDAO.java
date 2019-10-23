package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Menu;
import model.Perfil;

public class PerfilDAO extends DataBaseDAO {

    public PerfilDAO() throws Exception {
    }

    public ArrayList<Perfil> getLista() throws Exception {

        ArrayList<Perfil> lista = new ArrayList<Perfil>();
        String sql = "SELECT * FROM perfil";
        this.conectar();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            Perfil p = new Perfil();
            p.setIdperfil(rs.getInt("idperfil"));
            p.setPerfil(rs.getString("perfil"));
            lista.add(p);
        }
        this.desconectar();
        return lista;
    }

    public boolean gravar(Perfil p) {

        try {
            String sql;
            this.conectar();
            if (p.getIdperfil() == 0) {
                sql = "INSERT INTO perfil(perfil) VALUES(?) ";
            } else {
                sql = "UPDATE perfil SET perfil=? WHERE idperfil=?";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, p.getPerfil());
            if (p.getIdperfil() > 0) {
                pstm.setInt(2, p.getIdperfil());
            }
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public Perfil getCarregaPorId(int idperfil) throws Exception {

        Perfil p = new Perfil();
        String sql = "SELECT * FROM perfil WHERE idperfil=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idperfil);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            p.setIdperfil(rs.getInt("idperfil"));
            p.setPerfil(rs.getString("perfil"));
            p.setMenus(menusVinculadosPorPerfil(idperfil));
            p.setNaoMenus(menusNaoVinculadosPorPerfil(idperfil));
        }
        this.desconectar();
        return p;
    }

    public boolean excluir(Perfil p) {
        try {
            this.conectar();
            String sql = "DELETE FROM perfil WHERE idperfil=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, p.getIdperfil());
            pstm.execute();
            this.desconectar();
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public ArrayList<Menu> menusVinculadosPorPerfil(int idperfil) throws Exception {

        ArrayList<Menu> lista = new ArrayList<Menu>();
        String sql = "SELECT m.* FROM menu_perfil as mp, menu as m "
                + "WHERE mp.idmenu=m.idmenu AND mp.idperfil=?";

        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idperfil);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Menu m = new Menu();
            m.setIdmenu(rs.getInt("m.idmenu"));
            m.setMenu(rs.getString("m.menu"));
            m.setLink(rs.getString("m.link"));
            m.setIcone(rs.getString("icone"));
            m.setExibir(rs.getInt("m.exibir"));
            lista.add(m);
        }
        this.desconectar();
        return lista;
    }

    public ArrayList<Menu> menusNaoVinculadosPorPerfil(int idperfil) throws Exception {

        ArrayList<Menu> lista = new ArrayList<Menu>();
        String sql = "SELECT m.* FROM menu as m WHERE m.idmenu "
                + "NOT IN (SELECT mp.idmenu FROM menu_perfil as mp "
                + "         WHERE mp.idperfil=?)";

        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idperfil);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Menu m = new Menu();
            m.setIdmenu(rs.getInt("m.idmenu"));
            m.setMenu(rs.getString("m.menu"));
            m.setLink(rs.getString("m.link"));
            m.setIcone(rs.getString("icone"));
            m.setExibir(rs.getInt("m.exibir"));
            lista.add(m);
        }
        this.desconectar();
        return lista;
    }

    public boolean vincular(int idmenu, int idperfil) {

        try {
            String sql = "INSERT INTO menu_perfil (idmenu, idperfil) "
                    + "VALUES (?,?)";
            this.conectar();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idmenu);
            pstm.setInt(2, idperfil);
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean desvincular(int idmenu, int idperfil) {

        try {
            String sql = "DELETE FROM menu_perfil  WHERE idmenu=? AND idperfil=? ";
            this.conectar();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idmenu);
            pstm.setInt(2, idperfil);
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

}
