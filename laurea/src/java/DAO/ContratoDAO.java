package DAO;

//import java.sql.Date;
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
        String sql = "SELECT c.*, a.aluno, r.responsavel FROM contrato c "
                + "INNER JOIN aluno a ON c.idaluno = a.idaluno "
                + "INNER JOIN responsavel r ON c.idresponsavel = r.idresponsavel ";
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
            c.setAluno(a);
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
                sql = "UPDATE contrato SET datacontrato=?, preco=?, parcela=?, status=?, serie=?, escola=?, idaluno=? WHERE idcontrato=? ";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            if (c.getIdcontrato() > 0) {
                pstm.setInt(1, c.getIdcontrato());
            }
            pstm.setString(2, c.getDatacontrato());
            pstm.setDouble(3, c.getPreco());
            pstm.setInt(4, c.getParcela());
            pstm.setInt(5, c.getStatus());
            pstm.setString(6, c.getSerie());
            pstm.setString(7, c.getEscola());
            pstm.setInt(8, c.getAluno().getIdaluno());
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
                + "INNER JOIN aluno a ON c.idaluno = a.idaluno WHERE idcontrato=? ";
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

    public boolean excluir(Contrato c) {
        try {
            this.conectar();
            String sql = "DELETE FROM contrato WHERE idcontrato=? ";
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
