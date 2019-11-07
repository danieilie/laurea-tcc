package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Aluno;
import model.Contrato;
import model.Mensalidade;
import model.Responsavel;

public class ContratoDAO extends DataBaseDAO {

    public ContratoDAO() throws Exception {
    }
    
    public void registrar(Contrato c) throws Exception{
        this.conectar();
        String sql = "INSERT INTO contrato (idcontrato, parcela, status, datacontrato, serie, escola, preco, idaluno, idmensalidade) VALUES (?,?,?,now()?,?,?,?,?)";
        PreparedStatement pstm = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
        pstm.setInt(1, c.getIdcontrato());
        pstm.setInt(2, c.getMensalidade().getIdmensalidade());
        pstm.execute();
        ResultSet rs = pstm.getGeneratedKeys();
        if(rs.next()){
            c.setIdcontrato(rs.getInt(1));
        }
//        for(int i = 0; i <= 9; i++){
        for(Mensalidade i:c.getMensalidade()){
            String sql_item = "INSERT INTO mensalidade (idmensalidade, status, mes, valor, multa, desconto, datav, datap) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pstm_item = conn.prepareStatement(sql_item);
            pstm_item.setInt(1, i.getIdcontrato());
            pstm_item.setInt(2, i.getMensalidade().getIdmensalidade());
            pstm_item.setInt(3, c.getStatus());
            pstm_item.setString(4, i.getMes());
            pstm_item.setDouble(5, i.getValor());
            pstm_item.setDouble(6, i.getMulta());
            pstm_item.setDouble(7, i.getDesconto());
            pstm_item.setString(8, i.getDatav());
            pstm_item.setString(9, i.getDatap());
            pstm_item.setDouble(10, i.getValor());
            pstm_item.execute();
        }
        this.desconectar();
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
