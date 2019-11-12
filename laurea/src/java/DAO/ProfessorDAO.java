package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Disciplina;
import model.Professor;
import model.Usuario;

public class ProfessorDAO extends DataBaseDAO {

    public ProfessorDAO() throws Exception {
    }

    public ArrayList<Professor> getLista() throws Exception {

        ArrayList<Professor> lista = new ArrayList<Professor>();
        String sql = "SELECT p.*, u.nome FROM professor p "
                + "INNER JOIN usuario u ON p.idusuario = u.idusuario";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Professor p = new Professor();
            p.setIdprofessor(rs.getInt("p.idprofessor"));
            p.setNome(rs.getString("p.nome"));
            p.setStatus(rs.getInt("p.status"));
            Usuario u = new Usuario();
            u.setIdusuario(rs.getInt("p.idusuario"));
            u.setNome(rs.getString("u.nome"));
            p.setUsuario(u);
            DisciplinaDAO dDAO = new DisciplinaDAO();
            p.setDisciplina(dDAO.getCarregaPorId(rs.getInt("p.iddisciplina")));
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
//                sql = "INSERT INTO professor(nome, status, idusuario, iddisciplina) VALUES(?,?,?) ";
                sql = "INSERT INTO professor(nome, status, idusuario) VALUES(?,?,?) ";
            } else {
//                sql = "UPDATE professor SET nome=?, status=?, idusuario=?, iddisciplina=? WHERE idprofessor=? ";
                sql = "UPDATE professor SET nome=?, status=?, idusuario=? WHERE idprofessor=? ";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, p.getNome());
            pstm.setInt(2, p.getStatus());
            pstm.setInt(3, p.getUsuario().getIdusuario());
//            pstm.setInt(4, p.getDisciplina().getIddisciplina());
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
        String sql = "SELECT p.*, u.idusuario FROM professor p "
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
//            DisciplinaDAO dDAO = new DisciplinaDAO();
//            p.setDisciplina(dDAO.getCarregaPorId(rs.getInt("p.iddisciplina")));
            p.setUsuario(u);
        }
        this.desconectar();
        return p;
    }

//    public Professor getCarregaPorIdProfessor(int idprofessor) throws Exception {
//
//        Professor p = new Professor();
//        String sql = "SELECT p.* WHERE p.idusuario == u.logado";
//        this.conectar();
//        PreparedStatement pstm = conn.prepareStatement(sql);
//        pstm.setInt(1, idprofessor);
//        ResultSet rs = pstm.executeQuery();
//        if (rs.next()) {
//            p.setIdprofessor(rs.getInt("p.idprofessor"));
//            p.setNome(rs.getString("p.nome"));
//            p.setStatus(rs.getInt("p.status")); 
//        }
//        this.desconectar();
//        return p;
//    }
    public boolean desativar(Professor p) {
        try {
            this.conectar();
            String sql = "UPDATE professor SET status=2 WHERE idprofessor=?";
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

    public boolean vincular(int idprofessor, int iddisciplina) {
        try {
            String sql = "INSERT INTO professor_disciplina (idprofessor, iddisciplina) VALUES (?,?)";
            this.conectar();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idprofessor);
            pstm.setInt(2, iddisciplina);
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean desvincular(int idprofessor, int iddisciplina) {
        try {
            String sql = "DELETE FROM professor_disciplina WHERE iddisciplina=? AND idprofessor=? ";
            this.conectar();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idprofessor);
            pstm.setInt(2, iddisciplina);
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public ArrayList<Disciplina> disciplinaVinculadaPorProfessor(int idprofessor) throws Exception {
        ArrayList<Disciplina> lista = new ArrayList<Disciplina>();
        String sql = "SELECT p.* FROM professor_disciplina as pd, professor as p "
                + "WHERE pd.idprofessor = p.idprofessor AND pd.iddisciplina=? ";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idprofessor);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Disciplina d = new Disciplina();
            d.setIddisciplina(rs.getInt("d.iddisciplina"));
            d.setMateria(rs.getString("d.materia"));
            lista.add(d);
        }
        this.desconectar();
        return lista;
    }

    public ArrayList<Disciplina> disciplinaNaoVinculadaPorProfessor(int idprofessor) throws Exception {
        ArrayList<Disciplina> lista = new ArrayList<Disciplina>();
        String sql = "SELECT p.* FROM professor as p WHERE p.idprofessor "
                + "NOT IN (SELECT pd.idprofessor FROM professor_disciplina as pd WHERE pd.iddisciplina=? ) ";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idprofessor);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Disciplina d = new Disciplina();
            d.setIddisciplina(rs.getInt("d.iddisciplina"));
            d.setMateria(rs.getString("d.materia"));
            lista.add(d);
        }
        this.desconectar();
        return lista;
    }
}
