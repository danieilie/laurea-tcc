package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Aluno;
import model.Contrato;

public class ContratoDAO extends DataBaseDAO {

    public ContratoDAO() throws Exception {
    }

    public ArrayList<Contrato> getLista() throws Exception {

        ArrayList<Contrato> lista = new ArrayList<Contrato>();
        String sql = "SELECT c.*, a.aluno FROM contrato c "
                + "INNER JOIN aluno a ON "
                + "a.idaluno = c.idaluno ";

        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Contrato c = new Contrato();
            c.setIdcontrato(rs.getInt("c.idcontrato"));
            c.setDatacontrato(rs.getString("c.datacontrato"));
            c.setPreco(rs.getDouble("c.preco"));
            c.setParcela(rs.getInt("c.parcela"));
            c.setStatus(rs.getInt("c.status"));
            c.setSerie(rs.getString("c.serie"));
            c.setEscola(rs.getString("c.escola"));
            Aluno a = new Aluno();
            a.setIdaluno(rs.getInt("c.idaluno"));
            a.setNome(rs.getString("a.nome"));
            a.setDatanasc(rs.getString("a.datanasc"));
            a.setCpf(rs.getString("a.cpf"));
            a.setRg(rs.getString("a.rg"));
            c.setAluno(a);
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
            pstm.setString(1, c.getDataContrato());
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
                + "INNER JOIN aluno a ON "
                + "a.idaluno = c.idaluno WHERE c.idcontrato=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idcontrato);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            c.setIdcontrato(rs.getInt("c.idcontrato"));
            c.setDatacontrato(rs.getString("c.datacontrato"));
            c.setPreco(rs.getDouble("c.preco"));
            c.setParcela(rs.getInt("c.parcela"));
            c.setStatus(rs.getInt("c.status"));
            c.setSerie(rs.getString("c.serie"));
            c.setEscola(rs.getString("c.escola"));
            Aluno a = new Aluno();
            a.setIdaluno(rs.getInt("p.idaluno"));
            a.setNome(rs.getString("a.nome"));
            a.setDatanasc(rs.getString("a.datanasc"));
            a.setCpf(rs.getString("a.cpf"));
            a.setRg(rs.getString("a.rg"));
            c.setAluno(a);
        }
        this.desconectar();
        return c;
    }

    public boolean excluir(Contrato c) {
        try {
            this.conectar();
            String sql = "UPDATE contrato WHERE idcontrato=?";
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
