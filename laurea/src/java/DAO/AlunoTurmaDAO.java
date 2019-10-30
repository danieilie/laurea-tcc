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
        String sql = "SELECT at.* FROM aluno_turma at ";
        this.conectar();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            AlunoTurma at = new AlunoTurma();
            at.setFrequencia(rs.getString("at.frequencia"));
            at.setData(rs.getDate("at.data"));
            Aluno a = new Aluno();
            a.setIdaluno(rs.getInt("at.idaluno"));
            a.setNome(rs.getString("a.nome"));
            Turma t = new Turma();
            t.setIdturma(rs.getInt("at.idturma"));
            t.setNome(rs.getString("t.nome"));
            at.setAluno(a);
            at.setTurma(t);
            lista.add(at);
        }
        this.desconectar();
        return lista;

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

    public AlunoTurma getCarregaPorId(int idaluno, int idturma) throws Exception {

        String sql = "SELECT at.*, t.nome, a.nome FROM aluno_turma at" +
                    " INNER JOIN turma t ON at.idturma = tu.idturma" +
                    " INNER JOIN aluno a ON at.idaluno = a.idaluno WHERE at.idaluno = ?"+
                    " AND at.idturma = ?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idaluno);
        pstm.setInt(2, idturma);
        ResultSet rs = pstm.executeQuery();
        AlunoTurma at = new AlunoTurma();
        if (rs.next()) {
            at.setFrequencia(rs.getString("at.frequencia"));
            at.setData(rs.getDate("at.data"));
            Aluno a = new Aluno();
            a.setIdaluno(rs.getInt("at.idaluno"));
            a.setNome(rs.getString("a.nome"));
            Turma t = new Turma();
            t.setIdturma(rs.getInt("at.idturma"));
            t.setNome(rs.getString("t.nome"));
            at.setAluno(a);
            at.setTurma(t);
        }
        this.desconectar();
        return at;

    }

    public boolean vincular(int idaluno, int idturma, Date data, String frequencia) {

        try {
            String sql = "INSERT INTO aluno_turma (idaluno, idturma, data, frequencia) VALUES (?, ?, ?, ?)";
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

}
