package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.AlunoDAO;

public class GerenciarAlunoAtividade extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String mensagem = "";
        String acao = request.getParameter("acao");
        String idaluno = request.getParameter("idaluno");

        try {
            AlunoDAO aDAO = new AlunoDAO();

            if (acao.equals("desvincular")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    String idatividade = request.getParameter("idatividade");
                    if (idatividade.equals("") || idatividade.isEmpty()) {
                        mensagem = "O menu deve ser selecinado";
                    } else {
                        if (aDAO.desativar("idaluno")) {
                            mensagem = "Desvinculado com sucesso!";
                        } else {
                            mensagem = "Erro ao desvincular!";
                        }
                    }
                } else {
                    mensagem = "Acesso Negado";
                }
            }

        } catch (Exception e) {
            out.print(e);
            mensagem = "Erro ao executar o comando";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('" + mensagem + "')");
        out.println("location.href='gerenciar_aluno_atividade.do?acao=gerenciar&idaluno=" + idaluno + "';");
        out.println("</script>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String mensagem = "";
        String idaluno = request.getParameter("idaluno");
        String idatividade = request.getParameter("idatividade");

        try {
            AlunoDAO aDAO = new AlunoDAO();
            if (idaluno.equals("") || idatividade.equals("")) {
                mensagem = "Campos obrigatórios deverão ser selecionados!";
            } else {
                if (aDAO.vincular(Integer.parseInt(idaluno), Integer.parseInt(idatividade))) {
                    mensagem = "Vinculado com sucesso!";
                } else {
                    mensagem = "Erro ao vincular!";
                }
            }

        } catch (Exception e) {
            out.print(e);
            mensagem = "Erro ao executar!";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('" + mensagem + "')");
        out.println("location.href='listar_aluno_atividade.jsp';");
        out.println("</script>");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
