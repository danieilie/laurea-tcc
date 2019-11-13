package controller;

import DAO.DisciplinaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Disciplina;

public class GerenciarDisciplina extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int iddisciplina = Integer.parseInt(request.getParameter("iddisciplina"));
        String acao = request.getParameter("acao");
        Disciplina d = new Disciplina();
        String mensagem = "";

        try {

            DisciplinaDAO dDAO = new DisciplinaDAO();
            if (acao.equals("alterar")) {
                d = dDAO.getCarregaPorId(iddisciplina);
                if (d.getIddisciplina() > 0) {
                    RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_disciplina.jsp");
                    request.setAttribute("disciplina", d);
                    disp.forward(request, response);
                } else {
                    mensagem = "Disciplina não encontrada.";
                }
            }

            if (acao.equals("excluir")) {
                d.setIddisciplina(iddisciplina);
                if (dDAO.excluir(d)) {
                    mensagem = "Excluido com sucesso!";
                } else {
                    mensagem = "Erro ao excluir!";
                }
            }

        } catch (Exception e) {
            out.print(e);
            mensagem = "Erro ao executar o comando.";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('" + mensagem + "')");
        out.println("location.href='listar_disciplina.jsp';");
        out.println("</script>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String iddisciplina = request.getParameter("iddisciplina");
        String materia = request.getParameter("materia");
        String mensagem = "";

        Disciplina d = new Disciplina();
        if (!iddisciplina.isEmpty()) {
            d.setIddisciplina(Integer.parseInt(iddisciplina));
        }
        try {
            DisciplinaDAO dDAO = new DisciplinaDAO();
            if (materia.equals("") || materia.isEmpty()) {
                mensagem = "Campos Obrigatórios Precisam Ser Preenchidos!";
            } else {
                d.setMateria(materia);
                if (dDAO.gravar(d)) {
                    mensagem = "Gravado com Sucesso!";
                } else {
                    mensagem = "Erro ao gravar no banco.";
                }
            }
        } catch (Exception e) {
            out.print(e);
            mensagem = "Erro ao executar o comando.";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('" + mensagem + "')");
        out.println("location.href='listar_disciplina.jsp';");
        out.println("</script>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
