package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Mensalidade;

public class MensalidadeDAO extends DataBaseDAO {

    public MensalidadeDAO() throws Exception {
    }

    public ArrayList<Mensalidade> getLista() throws Exception {

        ArrayList<Mensalidade> lista = new ArrayList<Mensalidade>();
        String sql = "SELECT m.* FROM mensalidade m ";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Mensalidade m = new Mensalidade();
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
                sql = "INSERT INTO mensalidade(mes, valor, datav, datap, multa, desconto, status, idcontrato) VALUES(?,?,?,?,?,?,?,?) ";
            } else {
                sql = "UPDATE mensalidade SET mes=?, valor=?, datav=?, datap=?, multa=?, desconto=?, status=?, idcontrato=? WHERE idmensalidade=?";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, m.getMes());
            pstm.setDouble(2, m.getValor());
            pstm.setString(3, m.getDatav());
            pstm.setString(4, m.getDatap());
            pstm.setDouble(5, m.getMulta());
            pstm.setDouble(6, m.getDesconto());
            pstm.setInt(7, m.getStatus());
            pstm.setInt(8, m.getContrato().getIdcontrato());
            if (m.getIdmensalidade() > 0) {
                pstm.setInt(9, m.getIdmensalidade());
            }
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Mensalidade getCarregaPorId(int idmensalidade) throws Exception {

        Mensalidade m = new Mensalidade();
        String sql = "SELECT m.*, c.contrato FROM mensalidade m ";
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

    public boolean excluir(Mensalidade m) {
        try {
            this.conectar();
            String sql = "UPDATE mensalidade WHERE idmensalidade=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, m.getIdmensalidade());
            pstm.execute();
            this.desconectar();
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

}
