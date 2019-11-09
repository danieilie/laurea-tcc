package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Aluno;
import model.Contrato;
import model.Mensalidade;
import model.Responsavel;

public class MensalidadeDAO extends DataBaseDAO {

    public MensalidadeDAO() throws Exception {
    }

    public ArrayList<Mensalidade> getLista() throws Exception {

        ArrayList<Mensalidade> lista = new ArrayList<Mensalidade>();
        String sql = "SELECT m.*, a.nome, r.nome FROM mensalidade m "
                + "INNER JOIN contrato c ON m.idcontrato = c.idcontrato "
                + "INNER JOIN aluno a ON m.idcontrato = a.idaluno "
                + "INNER JOIN responsavel r ON m.idcontrato = r.idresponsavel ";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        Mensalidade m = new Mensalidade();            
        while (rs.next()) {
            m.setIdmensalidade(rs.getInt("m.idmensalidade"));
            m.setValor(rs.getDouble("m.valor"));
            m.setDatav(rs.getDate("m.datav"));
            m.setDatap(rs.getDate("m.datap"));
            m.setMulta(rs.getDouble("m.multa"));
            m.setDesconto(rs.getDouble("m.desconto"));
            m.setStatus(rs.getInt("m.status"));
            Contrato c = new Contrato();
            c.setIdcontrato(rs.getInt("m.idcontrato"));
            Aluno a = new Aluno();
            a.setNome(rs.getString("a.nome"));
            c.setAluno(a);
            Responsavel r = new Responsavel();
            r.setNome(rs.getString("r.nome"));
            a.setResponsavel(r);
            lista.add(m);
        }
        this.desconectar();
        return lista;
    }

    public Mensalidade getCarregaPorId(int idcontrato, int idmensalidade) throws Exception {

        Mensalidade m = new Mensalidade();
        String sql = "SELECT m.*, c.idcontrato, a.nome, r.nome FROM mensalidade m "
                + "INNER JOIN contrato c ON m.idcontrato = c.idcontrato "
                + "INNER JOIN aluno a ON m.idaluno = a.idaluno"
                + "INNER JOIN responsavel r ON m.idresponsavel = r.idresponsavel WHERE idmensalidade = ? AND idcontrato = ? ";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idmensalidade);
        pstm.setInt(2, idcontrato);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            m.setIdmensalidade(rs.getInt("m.idmensalidade"));
            m.setValor(rs.getDouble("m.valor"));
            m.setDatav(rs.getDate("m.datav"));
            m.setDatap(rs.getDate("m.datap"));
            m.setMulta(rs.getDouble("m.multa"));
            m.setDesconto(rs.getDouble("m.desconto"));
            m.setStatus(rs.getInt("m.status"));            
        }
        this.desconectar();
        return m;
    }
        
    public boolean gravar(Mensalidade m){
        try{            
            String sql = "UPDATE mensalidade SET  valor=?, datav=?, datap=?, multa=?, desconto=?, status=? WHERE idcontrato=? AND idmensalidade=?";                
            this.conectar();
            PreparedStatement pstm = conn.prepareStatement(sql);  
            pstm.setDouble(1, m.getValor());
            pstm.setDate(2, new Date(m.getDatav().getTime()));
            pstm.setDate(3, new Date(m.getDatap().getTime()));
            pstm.setDouble(4, m.getMulta());
            pstm.setDouble(5, m.getDesconto());
            pstm.setInt(6, m.getStatus());         
            pstm.setInt(7, m.getIdmensalidade());            
            pstm.execute();
            this.desconectar();
            return true;            
        }catch(Exception e){
            System.out.println(e);
            return false;            
        }
    } 
    
    public boolean desativar(Mensalidade m){
        try{
            String sql = "UPDATE mensalidade SET status=2 WHERE idmensalidade=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, m.getIdmensalidade());
            this.desconectar();
            return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }        
    }
    
}
