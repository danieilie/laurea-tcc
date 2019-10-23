package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.Disciplina;
import model.Atividade;

public class AtividadeDAO extends DataBaseDAO {

    public AtividadeDAO() throws Exception {
    }

    public ArrayList<Atividade> getLista() throws Exception {

        ArrayList<Atividade> lista = new ArrayList<Atividade>();
        String sql = "SELECT a.*, d.materia FROM atividade a"
                + "INNER JOIN disciplina d ON "
                + "d.iddisciplina = a.iddisciplina";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        while (rs.next()) {
            Atividade a = new Atividade();
            a.setIdatividade(rs.getInt("a.idatividade"));
            a.setNome(rs.getString("a.nome"));
            a.setArquivo(rs.getString("a.arquvido"));
            Disciplina d = new Disciplina();
            d.setIddisciplina(rs.getInt("u.iddisciplina"));
            d.setMateria(rs.getString("d.disciplina"));
            a.setDisciplina(d);
            lista.add(a);
        }
        this.desconectar();
        return lista;
    }

    public boolean gravar(Atividade a) {

        try {
            String sql;
            this.conectar();
            if (a.getIdatividade() == 0) {
                sql = "INSERT INTO atividade(nome, arquivo, iddisciplina) VALUES(?,?,?) ";
            } else {
                sql = "UPDATE atividade SET nome=?, arquivo=?, iddisciplina=? WHERE idatividade=?";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, a.getNome());
            pstm.setString(2, a.getArquivo());
            pstm.setInt(3, a.getDisciplina().getIddisciplina());
            if (a.getIdatividade() > 0) {
                pstm.setInt(4, a.getIdatividade());
            }
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public boolean excluir(Atividade a) {
        try {
            this.conectar();
            String sql = "UPDATE atividade WHERE idatividade=?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, a.getIdatividade());
            pstm.execute();
            this.desconectar();
            return true;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Atividade getCarregaPorId(int idatividade) throws Exception {

        Atividade a = new Atividade();
        String sql = "SELECT a.*, d.materia FROM atividade a"
                + "INNER JOIN disciplina d ON "
                + "d.iddisciplina = a.iddisciplina WHERE a.idatividade=?";
        //renomeando a tabela atividade para a
        //u.* seleciona todos os campos
        //INNER JOIN pega todas as colunas especificadas das tabelas e junta através das chaves(id).
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idatividade);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            a.setIdatividade(rs.getInt("a.idatividade"));
            a.setNome(rs.getString("a.nome"));
            a.setArquivo(rs.getString("a.arquivo"));
            Disciplina d = new Disciplina();
            d.setIddisciplina(rs.getInt("a.idatividade"));
            d.setMateria(rs.getString("d.materia"));
            a.setDisciplina(d);

        }
        this.desconectar();
        return a;
    }

}
