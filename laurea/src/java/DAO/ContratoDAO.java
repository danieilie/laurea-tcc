package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import model.Aluno;
import model.Contrato;
import model.Mensalidade;
import model.Responsavel;

public class ContratoDAO extends DataBaseDAO {

    public ContratoDAO() throws Exception {
    }

    public ArrayList<Contrato> getLista() throws Exception {

        ArrayList<Contrato> lista = new ArrayList<Contrato>();
        String sql = "SELECT c.*, a.nome, r.nome FROM contrato c "
                + "INNER JOIN aluno a ON c.idaluno = a.idaluno "
                + "INNER JOIN responsavel r ON c.idcontrato = r.idresponsavel ";
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
            c.setMensalidade(mensalidaVinculadaPorContrato(Integer.parseInt("idcontrato")));
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

    public boolean gravar(Contrato c) throws Exception {
        try {
            String sql = "INSERT INTO contrato (idcontrato, datacontrato, preco, primeirovencimento, parcela, status, serie, escola, idaluno) VALUES (?,now(),?,?,?,?,?,?,?)";
            PreparedStatement pstm = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, c.getIdcontrato());
            pstm.setDate(2, new Date(c.getDatacontrato().getTime()));
            pstm.setDouble(3, c.getPreco());
            pstm.setDate(4, new Date(c.getPrimeirovencimento().getTime()));
            pstm.setInt(5, c.getParcela());
            pstm.setInt(6, c.getStatus());
            pstm.setString(7, c.getSerie());
            pstm.setString(8, c.getEscola());
            pstm.setInt(9, c.getStatus());
            pstm.execute();
            ResultSet rs = pstm.getGeneratedKeys();
            if (rs.next()) {
                c.setIdcontrato(rs.getInt(1));
            }

            Calendar ca = Calendar.getInstance();
            ca.setTime(c.getPrimeirovencimento());

            for (int i = 0; i < c.getParcela(); i++) {
                String sql_item = "INSERT INTO mensalidade (idmensalidade, idcontrato, valor, datav, datap, multa, desconto, status) VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement pstm_item = conn.prepareStatement(sql_item);
                pstm_item.setInt(1, i + 1); //add o numero no id da parcela
                pstm_item.setInt(2, c.getIdcontrato());
                pstm_item.setDouble(3, c.getPreco() / c.getParcela());
                pstm_item.setDate(4, (Date) ca.getTime());
                ca.add(Calendar.MONTH, 1);
                pstm_item.setDate(5, null);
                pstm_item.setDouble(6, 0);
                pstm_item.setDouble(7, 0);
                pstm_item.setInt(8, 1);
                pstm_item.execute();
            }
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Contrato getCarregaPorId(int idcontrato) throws Exception {

        Contrato c = new Contrato();
        String sql = "SELECT c.*, a.nome, r.nome FROM contrato c "
                + "INNER JOIN aluno a ON c.idaluno = a.idaluno "
                + "INNER JOIN responsavel r ON c.idcontrato = r.idresponsavel ";
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
            String sql = "UPDATE contrato SET status=2 WHERE idcontrato=? ";
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

    public ArrayList<Mensalidade> mensalidaVinculadaPorContrato(int idcontrato) throws Exception {

        ArrayList<Mensalidade> lista = new ArrayList<Mensalidade>();
        String sql = "SELECT m.* FROM mensalidade WHERE idcontrato = ? ";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idcontrato);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Mensalidade m = new Mensalidade();
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
            c.setMensalidade(lista);
            lista.add(m);
        }
        this.desconectar();
        return lista;
    }

}
