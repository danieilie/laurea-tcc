package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import model.Disciplina;

public class DisciplinaDAO extends DataBaseDAO {

    public DisciplinaDAO() throws Exception {
    }

    public ArrayList<Disciplina> getLista() throws Exception {
        ArrayList<Disciplina> lista = new ArrayList<Disciplina>();
        String sql = "SELECT * FROM disciplina";
        this.conectar();
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(sql);
        while (rs.next()) {
            Disciplina d = new Disciplina();
            d.setIddisciplina(rs.getInt("iddisciplina"));
            d.setMateria(rs.getString("materia"));
            lista.add(d);
        }
        this.desconectar();
        return lista;
    }

    public boolean gravar(Disciplina d) {
        try {
            String sql;
            this.conectar();
            if (d.getIddisciplina() == 0) {
                sql = "INSERT INTO disciplina (materia) VALUES (?)";
            } else {
                sql = "UPDATE disciplina SET materia=? WHERE iddisciplina=?";
            }
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, d.getMateria());

            if (d.getIddisciplina() > 0) {
                pstm.setInt(2, d.getIddisciplina());
            }
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public Disciplina getCarregaPorId(int iddisciplina) throws Exception {
        Disciplina d = new Disciplina();
        String sql = "SELECT * FROM disciplina WHERE iddisciplina=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, iddisciplina);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            d.setIddisciplina(rs.getInt("iddisciplina"));
            d.setMateria(rs.getString("materia"));
        }
        this.desconectar();
        return d;
    }

    public boolean excluir(Disciplina d) {
        try {
            this.conectar();
            String sql = "DELETE FROM disciplina WHERE iddisciplina = ?";
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setInt(1, d.getIddisciplina());
            pstm.execute();
            this.desconectar();
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }
}
