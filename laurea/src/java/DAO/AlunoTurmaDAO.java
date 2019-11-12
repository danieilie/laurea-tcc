package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Aluno;
import model.AlunoTurma;
import model.Turma;

public class AlunoTurmaDAO extends DataBaseDAO {

    public AlunoTurmaDAO() throws Exception {
    }

    public ArrayList<AlunoTurma> getLista() throws Exception {
        
        ArrayList<AlunoTurma> lista = new ArrayList<AlunoTurma>();
        String sql = "SELECT ati.*, a.aluno FROM aluno_turma ati "
                    + "INNER JOIN aluno a ON ati.idaluno = a.idaluno ";
        this.conectar();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            Aluno a = new Aluno();
            a.setIdaluno(rs.getInt("ati.idaluno"));
            a.setNome(rs.getString("a.nome"));
            AlunoTurma at = new AlunoTurma();
            at.setData(rs.getDate("at.data"));
            at.setFrequencia(rs.getString("ati.frequencia"));
            TurmaDAO tDAO= new TurmaDAO();
            at.setTurma(tDAO.getCarregaPorId(rs.getInt("ati.idturma")));
            at.setAluno(a);
            lista.add(at);
        }
        this.desconectar();
        return lista;

    }

    public AlunoTurma getCarregaPorId(int idaluno, int idturma) throws Exception {        
        String sql = "SELECT ati.*, a.aluno, t.turma FROM aluno_turma ati "
                + "INNER JOIN aluno a ON ati.idaluno = a.idaluno "
                + "INNER JOIN turma t ON ati.idturma = t.idturma ";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idaluno);
        pstm.setInt(2, idturma);
        ResultSet rs = pstm.executeQuery();
        AlunoTurma ati = new AlunoTurma();
        if (rs.next()) {
            ati.setData(rs.getDate("ati.data"));
            ati.setFrequencia(rs.getString("ati.frequencia"));
            Aluno a = new Aluno();
            a.setIdaluno(rs.getInt("ati.idaluno"));
            a.setNome(rs.getString("a.nome"));
            Turma t = new Turma();            
            t.setIdturma(rs.getInt("ati.idturma"));
            t.setNome(rs.getString("t.nome"));
            ati.setTurma(t);
            ati.setAluno(a);
        }
        this.desconectar();
        return ati;

    }

    public boolean vincular(int idaluno, int idturma, Date data, String frequencia) {
        try {
            String sql = "INSERT INTO aluno_turma (idaluno, idturma, data, frequencia) VALUES (?,?,?,?)";
            this.conectar();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idaluno);
            pstm.setInt(2, idturma);
            pstm.setDate(3, data);
            pstm.setString(4, frequencia);
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public boolean desvincular(int idaluno, int idturma) {
        try {
            String sql = "DELETE FROM aluno_turma WHERE idaluno=? AND idturma=?";
            this.conectar();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, idaluno);
            pstm.setInt(2, idturma);
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
    public boolean fazerChamada(String data, String frequencia, int idaluno, int idturma) {
        try {
            String sql = "UPDATE aluno_turma SET data=?, frequencia=? WHERE idaluno=? AND idturma=?";
            this.conectar();
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, data);
            pstm.setString(2, frequencia);
            pstm.setInt(3, idaluno);
            pstm.setInt(4, idturma);
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
}
