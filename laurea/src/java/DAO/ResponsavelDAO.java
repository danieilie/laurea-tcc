package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Responsavel;
import model.Usuario;

public class ResponsavelDAO extends DataBaseDAO {

    public ResponsavelDAO() throws Exception {
    }

    public ArrayList<Responsavel> getLista() throws Exception {

        ArrayList<Responsavel> lista = new ArrayList<Responsavel>();
        String sql = "SELECT r.*, u.usuario FROM responsavel r "
                + "INNER JOIN usuario u ON "
                + "u.idusuario = r.idusuario ";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Responsavel r = new Responsavel();
            r.setIdresponsavel(rs.getInt("r.idresponsavel"));
            r.setNome(rs.getString("r.nome"));
            r.setCpf(rs.getString("r.cpf"));
            r.setRg(rs.getString("r.rg"));
            Usuario u = new Usuario();
            u.setIdusuario(rs.getInt("u.idusuario"));
            u.setNome(rs.getString("u.nome"));
            u.setLogin(rs.getString("u.login"));
            u.setSenha(rs.getString("u.senha"));
            u.setStatus(rs.getInt("u.status"));
            r.setUsuario(u);
            lista.add(r);
        }
        this.desconectar();
        return lista;
    }

    public boolean gravar(Responsavel r) {

        try {
            String sql;
            this.conectar();
            if (r.getIdresponsavel() == 0) {
                sql = "INSERT INTO responsavel(nome, cpf, rg, idusuario) VALUES(?,?,?,?) ";
            } else {
                sql = "UPDATE responsavel SET nome=?, cpf=?, rg=?, idusuario=? WHERE idresponsavel=?";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, r.getNome());
            pstm.setString(2, r.getCpf());
            pstm.setString(3, r.getRg());
            pstm.setInt(4, r.getUsuario().getIdusuario());
            if (r.getIdresponsavel() > 0) {
                pstm.setInt(5, r.getIdresponsavel());
            }
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Responsavel getCarregaPorId(int idresponsavel) throws Exception {

        Responsavel r = new Responsavel();
        String sql = "SELECT r.*, u.usuario FROM responsavel r "
                + "INNER JOIN usuario u ON "
                + "u.idresponsavel = r.idusuario WHERE r.idresponsavel=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idresponsavel);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            r.setIdresponsavel(rs.getInt("idresponsavel"));
            r.setNome(rs.getString("r.nome"));
            r.setCpf(rs.getString("r.cpf"));
            r.setRg(rs.getString("r.rg"));
            Usuario u = new Usuario();
            u.setIdusuario(rs.getInt("u.idusuario"));
            u.setNome(rs.getString("u.nome"));
            u.setLogin(rs.getString("u.login"));
            u.setSenha(rs.getString("u.senha"));
            u.setStatus(rs.getInt("u.status"));
            r.setUsuario(u);
        }
        this.desconectar();
        return r;
    }

    public boolean excluir(Responsavel r) {
        try {
            this.conectar();
            String sql = "UPDATE responsavel WHERE idresponsavel=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, r.getIdresponsavel());
            pstm.execute();
            this.desconectar();
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

}
