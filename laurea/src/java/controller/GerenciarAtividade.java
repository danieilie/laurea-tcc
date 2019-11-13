package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Disciplina;
import model.Atividade;
import DAO.AtividadeDAO;
import util.Upload;

public class GerenciarAtividade extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String mensagem = "";
        int idatividade = Integer.parseInt(request.getParameter("idatividade"));
        String acao = request.getParameter("acao");
        
        try {
            Atividade atv = new Atividade();
            AtividadeDAO atvDAO = new AtividadeDAO();
            if (acao.equals("excluir")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    atv.setIdatividade(idatividade);
                    if (atvDAO.excluir(atv)) {
                        mensagem = "Excluído com sucesso!";
                    } else {
                        mensagem = "Erro ao excluir!";
                    }
                } else {
                    mensagem = "Acesso negado";
                }
            }
        } catch (Exception e) {
            out.print(e);
            mensagem = "Erro ao executar o comando";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('" + mensagem + "')");
        out.println("location.href='listar_atividade.jsp';");
        out.println("</script>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Upload up = new Upload();
        up.setFolderUpload("arquivos");
        if (up.formProcess(getServletContext(), request)) {
            PrintWriter out = response.getWriter();
            String idatividade = up.getForm().get("idatividade").toString();
            String nome = up.getForm().get("nome").toString();
            String iddisciplina = up.getForm().get("disciplina").toString();
            String mensagem = "";

            Atividade atv = new Atividade();
            if (!idatividade.isEmpty()) {
                atv.setIdatividade(Integer.parseInt(idatividade));
            }
            try {
                AtividadeDAO atvDAO = new AtividadeDAO();
                if (nome.isEmpty()) {
                    mensagem = "Campos obrigatórios deverão ser preenchidos";
                } else {
                    atv.setNome(nome);
                    if (!up.getFiles().isEmpty()) {
                        atv.setArquivo(up.getFiles().get(0));
                    }
                    Disciplina di = new Disciplina();
                    di.setIddisciplina(Integer.parseInt(iddisciplina));
                    atv.setDisciplina(di);
                    if (atvDAO.gravar(atv)) {
                        mensagem = "Gravado com sucesso";
                    } else {
                        mensagem = "Erro ao gravar no banco";
                    }
                }

            } catch (Exception e) {
                out.print(e);
                mensagem = "Erro ao executar o comando";
            }
            out.println("<script type='text/javascript'>");
            out.println("alert('" + mensagem + "')");
            out.println("location.href='listar_atividade.jsp';");
            out.println("</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
