package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Aluno;
import model.Responsavel;
import model.Usuario;

public class AlunoDAO extends DataBaseDAO {

    public AlunoDAO() throws Exception {
    }

    public ArrayList<Aluno> getLista() throws Exception {

        ArrayList<Aluno> lista = new ArrayList<Aluno>();
        String sql = "SELECT a.*,r.responsavel, u.usuario FROM aluno a "
                + "INNER JOIN r.idresponsavel ON a.idresponsavel = r.idresponsavel "
                + "INNER JOIN u.idusuario ON a.idusuario = u.idusuario ";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Aluno a = new Aluno();
            a.setIdaluno(rs.getInt("a.idaluno"));
            a.setNome(rs.getString("a.nome"));
            a.setDatanasc(rs.getString("a.datanasc"));
            a.setCpf(rs.getString("a.cpf"));
            a.setRg(rs.getString("a.rg"));
            a.setStatus(rs.getInt("a.status"));
            Responsavel r = new Responsavel();
            r.setIdresponsavel(rs.getInt("a.idresponsavel"));
            r.setNome(rs.getString("r.nome"));
            a.setResponsavel(r);
            Usuario u = new Usuario();
            u.setIdusuario(rs.getInt("a.idusuario"));
            u.setNome(rs.getString("u.nome"));
            a.setUsuario(u);
            lista.add(a);
        }
        this.desconectar();
        return lista;
    }

    public boolean gravar(Aluno a) {

        try {
            String sql;
            this.conectar();
            if (a.getIdaluno() == 0) {
                sql = "INSERT INTO aluno(nome, datanasc, cpf, rg, status, idresponsavel, idusuario) VALUES(?,?,?,?,?,?,?) ";
            } else {
                sql = "UPDATE aluno SET nome=?, datanasc=?, cpf=?, rg=?, status=?, idresponsavel=?, idusuario=? WHERE idaluno=? ";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            if (a.getIdaluno() > 0) {
                pstm.setInt(1, a.getIdaluno());
            }
            pstm.setString(2, a.getNome());
            pstm.setString(3, a.getDatanasc());
            pstm.setString(4, a.getCpf());
            pstm.setString(5, a.getRg());
            pstm.setInt(6, a.getStatus());
            pstm.setInt(7, a.getResponsavel().getIdresponsavel());
            pstm.setInt(8, a.getUsuario().getIdusuario());
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Aluno getCarregaPorId(int idaluno) throws Exception {

        Aluno a = new Aluno();
        String sql = "SELECT a.*,r.responsavel, u.usuario FROM aluno a "
                + "INNER JOIN r.idresponsavel ON a.idresponsavel = r.idresponsavel "
                + "INNER JOIN u.idusuario ON a.idusuario = u.idusuario ";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idaluno);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            a.setIdaluno(rs.getInt("a.idaluno"));
            a.setNome(rs.getString("a.nome"));
            a.setDatanasc(rs.getString("a.datanasc"));
            a.setCpf(rs.getString("a.cpf"));
            a.setRg(rs.getString("a.rg"));
            a.setStatus(rs.getInt("a.status"));
            Responsavel r = new Responsavel();
            r.setIdresponsavel(rs.getInt("a.idresponsavel"));
            r.setNome(rs.getString("r.nome"));
            a.setResponsavel(r);
            Usuario u = new Usuario();
            u.setIdusuario(rs.getInt("a.idusuario"));
            u.setNome(rs.getString("u.nome"));
            a.setUsuario(u);
        }
        this.desconectar();
        return a;
    }

    public boolean desativar(Aluno a) {
        try {
            this.conectar();
            String sql = "UPDATE aluno SET status=2 WHERE idaluno=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, a.getIdaluno());
            pstm.execute();
            this.desconectar();
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
    
}
