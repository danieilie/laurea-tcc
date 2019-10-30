package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Aluno;
import model.Contrato;
import model.Responsavel;

public class ContratoDAO extends DataBaseDAO {

    public ContratoDAO() throws Exception {
    }

    public ArrayList<Contrato> getLista() throws Exception {

        ArrayList<Contrato> lista = new ArrayList<Contrato>();
        String sql = "SELECT c.* FROM contrato c ";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Contrato c = new Contrato();
            c.setIdcontrato(rs.getInt("c.idcontrato"));
            c.setDatacontrato(rs.getDate("c.datacontrato"));
            c.setPreco(rs.getDouble("c.preco"));
            c.setParcela(rs.getInt("c.parcela"));
            c.setStatus(rs.getInt("c.status"));
            c.setSerie(rs.getString("c.serie"));
            c.setEscola(rs.getString("c.escola"));
            AlunoDAO aDAO = new AlunoDAO();
            c.setAluno(aDAO.getCarregaPorId(rs.getInt("c.idaluno")));
            Aluno a = new Aluno();
            Responsavel r = new Responsavel();
            r.setNome(rs.getString("r.nome"));
            a.setResponsavel(r);
            lista.add(c);
        }
        this.desconectar();
        return lista;
    }

    public boolean gravar(Contrato c) {

        try {
            String sql;
            this.conectar();
            if (c.getIdcontrato() == 0) {
                sql = "INSERT INTO contrato(datacontrato, preco, parcela, status, serie, escola, idaluno) VALUES(?,?,?,?,?,?,?) ";
            } else {
                sql = "UPDATE contrato SET datacontrato=?, preco=?, parcela=?, status=?, serie=?, escola=?, idaluno=? WHERE idcontrato=?";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setDate(1, (Date) c.getDatacontrato());
            pstm.setDouble(2, c.getPreco());
            pstm.setInt(3, c.getParcela());
            pstm.setInt(4, c.getStatus());
            pstm.setString(5, c.getSerie());
            pstm.setString(6, c.getEscola());
            pstm.setInt(7, c.getAluno().getIdaluno());
            if (c.getIdcontrato() > 0) {
                pstm.setInt(8, c.getIdcontrato());
            }
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Contrato getCarregaPorId(int idcontrato) throws Exception {

        Contrato c = new Contrato();
        String sql = "SELECT c.*, a.aluno FROM contrato c "
                + "INNER JOIN aluno a ON c.idaluno = a.idaluno "
                + "WHERE idcontrato=? ";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idcontrato);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            c.setIdcontrato(rs.getInt("c.idcontrato"));
            c.setDatacontrato(rs.getDate("c.datacontrato"));
            c.setPreco(rs.getDouble("c.preco"));
            c.setParcela(rs.getInt("c.parcela"));
            c.setStatus(rs.getInt("c.status"));
            c.setSerie(rs.getString("c.serie"));
            c.setEscola(rs.getString("c.escola"));
            Aluno a = new Aluno();
            a.setIdaluno(rs.getInt("c.idaluno"));
            a.setNome(rs.getString("a.nome"));
            c.setAluno(a);
            Responsavel r = new Responsavel();
            r.setNome(rs.getString("r.nome"));
            a.setResponsavel(r);
        }
        this.desconectar();
        return c;
    }

    public boolean desativar(Contrato c) {
        try {
            this.conectar();
            String sql = "UPDATE contrato SET status=2 WHERE idcontrato = ? ";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, c.getIdcontrato());
            pstm.execute();
            this.desconectar();
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

}
