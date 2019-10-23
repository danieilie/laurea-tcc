package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Aluno;
import model.Pendencia;

public class PendenciaDAO extends DataBaseDAO {

    public PendenciaDAO() throws Exception {
    }

    public ArrayList<Pendencia> getLista() throws Exception {

        ArrayList<Pendencia> lista = new ArrayList<Pendencia>();
        String sql = "SELECT p.*, a.aluno FROM pendencia p "
                + "INNER JOIN aluno a ON "
                + "a.idaluno = p.idaluno ";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Pendencia p = new Pendencia();
            p.setIdpendencia(rs.getInt("p.idpendencia"));
            p.setValor(rs.getDouble("p.valor"));
            Aluno a = new Aluno();
            a.setIdaluno(rs.getInt("p.idaluno"));
            a.setNome(rs.getString("a.nome"));
            a.setDatanasc(rs.getString("a.datanasc"));
            a.setCpf(rs.getString("a.cpf"));
            a.setRg(rs.getString("a.rg"));
            p.setAluno(a);
            lista.add(p);
        }
        this.desconectar();
        return lista;
    }

    public boolean gravar(Pendencia p) {

        try {
            String sql;
            this.conectar();
            if (p.getIdpendencia() == 0) {
                sql = "INSERT INTO pendencia(valor, idaluno) VALUES(?,?) ";
            } else {
                sql = "UPDATE pendencia SET valor=?, idaluno=? WHERE idpendencia=?";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setDouble(1, p.getValor());
            pstm.setInt(2, p.getAluno().getIdaluno());
            if (p.getIdpendencia() > 0) {
                pstm.setInt(3, p.getIdpendencia());
            }
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Pendencia getCarregaPorId(int idpendencia) throws Exception {

        Pendencia p = new Pendencia();
        String sql = "SELECT p.*, a.aluno FROM pendencia p "
                + "INNER JOIN aluno a ON "
                + "a.idaluno = p.idaluno WHERE p.idpendencia=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idpendencia);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            p.setIdpendencia(rs.getInt("p.idpendencia"));
            p.setValor(rs.getDouble("p.valor"));
            Aluno a = new Aluno();
            a.setIdaluno(rs.getInt("p.idaluno"));
            a.setNome(rs.getString("a.nome"));
            a.setDatanasc(rs.getString("a.datanasc"));
            a.setCpf(rs.getString("a.cpf"));
            p.setAluno(a);
        }
        this.desconectar();
        return p;
    }

    public boolean excluir(Pendencia p) {
        try {
            this.conectar();
            String sql = "UPDATE pendencia WHERE idpendencia=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, p.getIdpendencia());
            pstm.execute();
            this.desconectar();
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
