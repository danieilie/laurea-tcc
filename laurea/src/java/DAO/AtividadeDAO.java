package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Atividade;

public class AtividadeDAO extends DataBaseDAO {

    public AtividadeDAO() throws Exception {
    }

    public ArrayList<Atividade> getLista() throws Exception {

        ArrayList<Atividade> lista = new ArrayList<Atividade>();
        String sql = "SELECT atv.* FROM atividade atv ";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Atividade atv = new Atividade();
            atv.setIdatividade(rs.getInt("atv.idatividade"));
            atv.setNome(rs.getString("atv.nome"));
            atv.setArquivo(rs.getString("atv.arquivo"));
            DisciplinaDAO dDAO = new DisciplinaDAO();
            atv.setDisciplina(dDAO.getCarregaPorId(rs.getInt("atv.iddisciplina")));
            lista.add(atv);
        }
        this.desconectar();
        return lista;
    }

    public boolean gravar(Atividade atv) {

        try {
            String sql;
            this.conectar();

            if (atv.getIdatividade() == 0) {
                sql = "INSERT INTO atividade (nome, arquivo, iddisciplina) VALUES (?, ?, ?)";
            } else {
                sql = "UPDATE atividade SET nome=?, arquivo=?, iddisciplina=? WHERE idatividade=?";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, atv.getNome());
            pstm.setString(2, atv.getArquivo());
            pstm.setInt(3, atv.getDisciplina().getIddisciplina());
            if (atv.getIdatividade() > 0) {
                pstm.setInt(4, atv.getIdatividade());
            }
            pstm.execute();
            this.desconectar();
            return true;

        } catch (Exception e) {

            System.out.println(e);
            return false;

        }

    }

    public boolean excluir(Atividade atv) {
        try {
            this.conectar();
            String sql = "DELETE FROM atividade WHERE atividade.idatividade=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, atv.getIdatividade());
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Atividade getCarregaPorId(int idatividade) throws Exception {

        Atividade atv= new Atividade();
        String sql = "SELECT a.* FROM atividade at WHERE at.idatividade=?";
        //renomeando a tabela atividade para a
        //u.* seleciona todos os campos
        //INNER JOIN pega todas as colunas especificadas das tabelas e junta através das chaves(id).
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idatividade);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            atv.setIdatividade(rs.getInt("atv.idatividade"));
            atv.setNome(rs.getString("atv.nome"));
            atv.setArquivo(rs.getString("atv.arquivo"));
            DisciplinaDAO dDAO = new DisciplinaDAO();
            atv.setDisciplina(dDAO.getCarregaPorId(rs.getInt("atv.idatividade")));
        }
        this.desconectar();
        return atv;
    }

}
