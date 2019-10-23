package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Aluno;
import model.Usuario;
import model.Responsavel;

public class AlunoDAO extends DataBaseDAO {

    public AlunoDAO() throws Exception {
    }

    public ArrayList<Aluno> getLista() throws Exception {

        ArrayList<Aluno> lista = new ArrayList<Aluno>();
        String sql = "SELECT a.*, r.responsavel, u.usuario FROM aluno a "
                + "INNER JOIN responsavel r ON "
                + "r.idresponsavel = a.idresponsavel "
                + "INNER JOIN usuario u ON "
                + "u.idusuario = a.idusuario ";
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
            Responsavel r = new Responsavel();
            r.setIdresponsavel(rs.getInt("a.idresponsavel"));
            r.setNome(rs.getString("r.nome"));
            r.setCpf(rs.getString("r.cpf"));
            r.setRg(rs.getString("r.rg"));
            Usuario u = new Usuario();
            u.setIdusuario(rs.getInt("a.idusuario"));
            u.setNome(rs.getString("u.nome"));
            u.setLogin(rs.getString("u.login"));
            u.setSenha(rs.getString("u.senha"));
            u.setStatus(rs.getInt("u.status"));
            a.setResponsavel(r);
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
                sql = "INSERT INTO aluno(nome, datanasc, cpf, rg, idresponsavel, idusuario) VALUES(?,?,?,?,?,?) ";
            } else {
                sql = "UPDATE aluno SET nome=?, datanasc=?, cpf=?, rg=?, idresponsavel=?, idusuario=? WHERE idaluno=?";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, a.getNome());
            pstm.setString(2, a.getDatanasc());
            pstm.setString(3, a.getCpf());
            pstm.setString(4, a.getRg());
            pstm.setInt(5, a.getResponsavel().getIdresponsavel());
            pstm.setInt(6, a.getUsuario().getIdusuario());
            if (a.getIdaluno() > 0) {
                pstm.setInt(7, a.getIdaluno());
            }
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
        String sql = "SELECT a.*, r.responsavel, u.usuario FROM aluno a "
                + "INNER JOIN responsavel r ON "
                + "r.idresponsavel = a.idresponsavel WHERE a.idaluno=?";
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
            Responsavel r = new Responsavel();
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
        return a;
    }

    public boolean excluir(Aluno a) {
        try {
            this.conectar();
            String sql = "UPDATE aluno WHERE idaluno=?";
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
