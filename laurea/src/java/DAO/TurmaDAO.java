package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Professor;
import model.Turma;

public class TurmaDAO extends DataBaseDAO {

    public TurmaDAO() throws Exception {
    }

    public ArrayList<Turma> getLista() throws Exception {

        ArrayList<Turma> lista = new ArrayList<Turma>();
        String sql = "SELECT t.*, p.professor FROM turma t "
                + "INNER JOIN professor p ON p.idprofessor = t.idprofessor ";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Turma t = new Turma();
            t.setIdturma(rs.getInt("t.idturma"));
            t.setNome(rs.getString("t.nome"));
            ProfessorDAO pDAO = new ProfessorDAO();
            t.setProfessor(pDAO.getCarregaPorId(rs.getInt("r.idusuario")));
            lista.add(t);
        }
        this.desconectar();
        return lista;
    }

    public boolean gravar(Turma t) {

        try {
            String sql;
            this.conectar();
            if (t.getIdturma() == 0) {
                sql = "INSERT INTO turma(nome, idprofessor) VALUES(?,?) ";
            } else {
                sql = "UPDATE turma SET nome=?, idprofessor=? WHERE idturma=?";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, t.getNome());
            pstm.setInt(2, t.getProfessor().getIdprofessor());
            if (t.getIdturma() > 0) {
                pstm.setInt(3, t.getIdturma());
            }
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Turma getCarregaPorId(int idturma) throws Exception {

        Turma t = new Turma();
        String sql = "SELECT t.*, p.professor FROM turma t "
                + "INNER JOIN professor p ON p.idprofessor = t.idprofessor WHERE t.idturma=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idturma);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            t.setIdturma(rs.getInt("idturma"));
            t.setNome(rs.getString("t.nome"));
            Professor p = new Professor();
            p.setIdprofessor(rs.getInt("p.idprofessor"));
            p.setNome(rs.getString("p.nome"));
            p.setStatus(rs.getInt("p.status"));
            t.setProfessor(p);
        }
        this.desconectar();
        return t;
    }

    public boolean excluir(Turma t) {
        try {
            this.conectar();
            String sql = "UPDATE turma WHERE idturma=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, t.getIdturma());
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

}
