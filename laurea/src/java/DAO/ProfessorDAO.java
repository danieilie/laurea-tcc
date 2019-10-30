package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Professor;
import model.Usuario;

public class ProfessorDAO extends DataBaseDAO {

    public ProfessorDAO() throws Exception {
    }

    public ArrayList<Professor> getLista() throws Exception {

        ArrayList<Professor> lista = new ArrayList<Professor>();
        String sql = "SELECT p.* FROM professor p";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Professor p = new Professor();
            p.setIdprofessor(rs.getInt("p.idprofessor"));
            p.setNome(rs.getString("p.nome"));
            p.setStatus(rs.getInt("p.status"));
            UsuarioDAO uDAO = new UsuarioDAO();
            p.setUsuario(uDAO.getCarregaPorId(rs.getInt("p.idusuario")));
            lista.add(p);
        }
        this.desconectar();
        return lista;
    }

    public boolean gravar(Professor p) {

        try {
            String sql;
            this.conectar();
            if (p.getIdprofessor() == 0) {
                sql = "INSERT INTO professor(nome, status, idusuario) VALUES(?,?,?) ";
            } else {
                sql = "UPDATE professor SET nome=?, status=?, idusuario=? WHERE idprofessor=?";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, p.getNome());
            pstm.setInt(2, p.getStatus());
            pstm.setInt(3, p.getUsuario().getIdusuario());
            if (p.getIdprofessor() > 0) {
                pstm.setInt(4, p.getIdprofessor());
            }
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public Professor getCarregaPorId(int idprofessor) throws Exception {

        Professor p = new Professor();
        String sql = "SELECT p.*, u.usuario FROM professor p "
                + "INNER JOIN usuario u ON u.idusuario = p.idusuario ";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idprofessor);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            p.setIdprofessor(rs.getInt("p.idprofessor"));
            p.setNome(rs.getString("p.nome"));
            p.setStatus(rs.getInt("p.status"));
            Usuario u = new Usuario();
            u.setIdusuario(rs.getInt("p.idusuario"));
            u.setNome(rs.getString("u.nome"));
            u.setLogin(rs.getString("u.login"));
            u.setSenha(rs.getString("u.senha"));
            u.setStatus(rs.getInt("u.status"));
            p.setUsuario(u);
        }
        this.desconectar();
        return p;
    }

    public boolean excluir(Professor p) {
        try {
            this.conectar();
            String sql = "UPDATE professor WHERE idprofessor=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, p.getIdprofessor());
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

}
