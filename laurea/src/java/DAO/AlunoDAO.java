package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Aluno;

public class AlunoDAO extends DataBaseDAO {

    public AlunoDAO() throws Exception {
    }

    public ArrayList<Aluno> getLista() throws Exception {

        ArrayList<Aluno> lista = new ArrayList<Aluno>();
        String sql = "SELECT a.* FROM aluno a ";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Aluno a = new Aluno();
            a.setIdaluno(rs.getInt("a.idaluno"));
            a.setNome(rs.getString("a.nome"));
            a.setDatanasc(rs.getDate("a.datanasc"));
            a.setCpf(rs.getString("a.cpf"));
            a.setRg(rs.getString("a.rg"));
            a.setStatus(rs.getInt("a.status"));
            ResponsavelDAO rDAO = new ResponsavelDAO();
            a.setResponsavel(rDAO.getCarregaPorId(rs.getInt("a.responsavel")));
            UsuarioDAO uDAO = new UsuarioDAO();
            a.setUsuario(uDAO.getCarregaPorId(rs.getInt("a.idusuario")));
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
                sql = "UPDATE aluno SET nome=?, datanasc=?, cpf=?, rg=?, status=?, idresponsavel=?, idusuario=? WHERE idaluno=?";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, a.getNome());
            pstm.setDate(2, (Date) a.getDatanasc());
            pstm.setString(3, a.getCpf());
            pstm.setString(4, a.getRg());
            pstm.setInt(5, a.getStatus());
            pstm.setInt(6, a.getResponsavel().getIdresponsavel());
            pstm.setInt(7, a.getUsuario().getIdusuario());
            if (a.getIdaluno() > 0) {
                pstm.setInt(8, a.getIdaluno());
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
        String sql = "SELECT a.* FROM aluno a WHERE a.idaluno=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idaluno);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            a.setIdaluno(rs.getInt("a.idaluno"));
            a.setNome(rs.getString("a.nome"));
            a.setDatanasc(rs.getDate("a.datanasc"));
            a.setCpf(rs.getString("a.cpf"));
            a.setRg(rs.getString("a.rg"));
            a.setStatus(rs.getInt("a.status"));
            ResponsavelDAO rDAO = new ResponsavelDAO();
            a.setResponsavel(rDAO.getCarregaPorId(rs.getInt("a.idresponsavel")));
            UsuarioDAO uDAO = new UsuarioDAO();
            a.setUsuario(uDAO.getCarregaPorId(rs.getInt("a.idusuario")));
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
