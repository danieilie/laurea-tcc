package DAO;

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
        String sql = "SELECT m.* FROM mensalidade m "
                + "INNER JOIN contrato c ON m.idcontrato = c.idcontrato "
                + "INNER JOIN aluno a ON m.idaluno = a.idaluno"
                + "INNER JOIN responsavel r ON m.idresponsavel = r.idresponsavel";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        Mensalidade m = new Mensalidade();            
        while (rs.next()) {
            Contrato c = new Contrato();
            c.setIdcontrato(rs.getInt("m.idcontrato"));
            Aluno a = new Aluno();
            a.setNome(rs.getString("a.nome"));
            c.setAluno(a);
            Responsavel r = new Responsavel();
            r.setNome(rs.getString("r.nome"));
            a.setResponsavel(r);
            m.setIdmensalidade(rs.getInt("m.idmensalidade"));
            m.setMes(rs.getString("m.mes"));
            m.setValor(rs.getDouble("m.valor"));
            m.setDatav(rs.getString("m.datav"));
            m.setDatap(rs.getString("m.datap"));
            m.setMulta(rs.getDouble("m.multa"));
            m.setDesconto(rs.getDouble("m.desconto"));
            m.setStatus(rs.getInt("m.status"));
            lista.add(m);
        }
        this.desconectar();
        return lista;
    }

    public boolean gravar(Mensalidade m) {

        try {
            String sql;
            this.conectar();
            if (m.getIdmensalidade() == 0) {
                sql = "INSERT INTO mensalidade(idcontrato, mes, valor, datav, datap, multa, desconto, status) VALUES(?,?,?,?,?,?,?,?) ";
            } else {
                sql = "UPDATE mensalidade SET idcontrato=?, mes=?, valor=?, datav=?, datap=?, multa=?, desconto=?, status=? WHERE idmensalidade=?";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            if (m.getIdmensalidade() > 0) {
                pstm.setInt(1, m.getIdmensalidade());
            }
            pstm.setInt(2, m.getContrato().getIdcontrato());
            pstm.setString(3, m.getMes());
            pstm.setDouble(4, m.getValor());
            pstm.setString(5, m.getDatav());
            pstm.setString(6, m.getDatap());
            pstm.setDouble(7, m.getMulta());
            pstm.setDouble(8, m.getDesconto());
            pstm.setInt(9, m.getStatus());
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Mensalidade getCarregaPorId(int idcontrato, int idmensalidade) throws Exception {

        Mensalidade m = new Mensalidade();
        String sql = "SELECT m.*, c.contrato, a.aluno, r.responsavel FROM mensalidade m "
                + "INNER JOIN contrato c ON m.idcontrato = c.idcontrato "
                + "INNER JOIN aluno a ON m.idaluno = a.idaluno"
                + "INNER JOIN responsavel r ON m.idresponsavel = r.idresponsavel";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idmensalidade);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            m.setIdmensalidade(rs.getInt("m.idmensalidade"));
            m.setMes(rs.getString("m.mes"));
            m.setValor(rs.getDouble("m.valor"));
            m.setDatav(rs.getString("m.datav"));
            m.setDatap(rs.getString("m.datap"));
            m.setMulta(rs.getDouble("m.multa"));
            m.setDesconto(rs.getDouble("m.desconto"));
            m.setStatus(rs.getInt("m.status"));
            ContratoDAO cDAO = new ContratoDAO();
            m.setContrato(cDAO.getCarregaPorId(rs.getInt("m.contrato")));
        }
        this.desconectar();
        return m;
    }
    
//    public Mensalidade contarRegistro(int idcontrato, int idmensalidade) throws Exception{
//    
//        Mensalidade men = new Mensalidade();
//        
//        String sql = "SELECT COUNT(mes) AS num FROM mensalidade WHERE idcontrato = ? AND idmensalidade = ?";
//        
//        this.conectar();
//        PreparedStatement pstm = conn.prepareStatement(sql);
//        pstm.setInt(1 , idcontrato);
//        pstm.setInt(2 , idmensalidade);
//        ResultSet rs = pstm.executeQuery();
//        if(rs.next()){
//            
//           men.setNum(rs.getInt("num"));
//            
//        }
//        this.desconectar();
//        return men;
//    } 
        
    public boolean atualizarMensalidade(Mensalidade men){
        try{            
            String sql = "UPDATE mensalidade SET mes=?, valor=?, datav=?, datap=?, multa=?, desconto=?, status=? WHERE idcontrato=? AND idmensalidade=?";                
            this.conectar();
            PreparedStatement pstm = conn.prepareStatement(sql);            
            pstm.setString(1, men.getMes());
            pstm.setDouble(2, men.getValor());
            pstm.setString(3, men.getDatav());
            pstm.setString(4, men.getDatap());
            pstm.setDouble(5, men.getMulta());
            pstm.setDouble(6, men.getDesconto());
            pstm.setInt(7, men.getStatus());
            pstm.setInt(8, men.getContrato().getIdcontrato());
            pstm.setInt(9, men.getIdmensalidade());            
            pstm.execute();
            this.desconectar();
            return true;            
        }catch(Exception e){
            System.out.println(e);
            return false;            
        }
    } 
}
