package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Professor;
import model.Turma;
import DAO.TurmaDAO;

public class GerenciarTurma extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        int idturma = Integer.parseInt(request.getParameter("idturma"));
        String acao = request.getParameter("acao");
        String mensagem = "";
        try {
            Turma t = new Turma();
            TurmaDAO tDAO = new TurmaDAO();
            if (acao.equals("alterar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    t = tDAO.getCarregaPorId(idturma);
                    if (t.getIdturma() > 0) {
                        RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_turma.jsp");
                        request.setAttribute("turma", t);
                        disp.forward(request, response);
                    } else {
                        mensagem = "Turma não encontrado";
                    }
                } else {
                    mensagem = "Acesso negado";
                }
            }

            if (acao.equals("excluir")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    t.setIdturma(idturma);
                    if (tDAO.excluir(t)) {
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
        out.println("location.href='listar_turma.jsp';");
        out.println("</script>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String idturma = request.getParameter("idturma");
        String nome = request.getParameter("nome");
        String idprofessor = request.getParameter("idprofessor");
        String mensagem = "";

        Turma t = new Turma();
        if (!idturma.isEmpty()) {
            t.setIdturma(Integer.parseInt(idturma));
        }
        try {
            if (nome.equals("") || nome.isEmpty() || idprofessor.equals("")) {
                mensagem = "Campos obrigatórios deverão ser preenchidos";
            } else {
                t.setNome(nome);
                Professor p = new Professor();
                p.setIdprofessor(Integer.parseInt(idprofessor));
                t.setProfessor(p);
                TurmaDAO tDAO = new TurmaDAO();
                if (tDAO.gravar(t)) {
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
        out.println("location.href='listar_turma.jsp';");
        out.println("</script>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
