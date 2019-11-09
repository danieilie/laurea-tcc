
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.ProfessorDAO;
import model.Professor;

public class GerenciarProfessorDisciplina extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String mensagem = "";
        String idprofessor = request.getParameter("idprofessor");
        String acao = request.getParameter("acao");

        try {
            ProfessorDAO proDAO = new ProfessorDAO();
            Professor pro = new Professor();
            if (acao.equals("gerenciar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    pro = proDAO.getCarregaPorId(Integer.parseInt(idprofessor));
                    if (pro.getIdprofessor() > 0) {
                        RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_professor_disciplina.jsp");
                        request.setAttribute("professorv", pro);
                        disp.forward(request, response);
                    } else {
                        mensagem = "Professor não encontrado!";
                    }
                } else {
                    mensagem = "Acesso Negado";
                }

            }
            if (acao.equals("desvincular")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    String iddisciplina = request.getParameter("iddisciplina");
                    if (iddisciplina.equals("") || iddisciplina.isEmpty()) {
                        mensagem = "A disciplina deve ser selecionada";
                    } else {
                        if (proDAO.desvincular(Integer.parseInt(iddisciplina), Integer.parseInt(idprofessor))) {
                            mensagem = "Desvinculado com sucesso";
                        } else {
                            mensagem = "Erro ao desvincular";
                        }
                    }
                } else {
                    mensagem = "Acesso Negado";
                }
            }
        } catch (Exception e) {
            out.print(e);
            mensagem = "Erro ao executar";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('" + mensagem + "')");
        out.println("location.href='gerenciar_menu_perfil.do?acao=gerenciar&idprofessor=" + idprofessor + "';");
        out.println("</script>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String mensagem = "";
        String idprofessor = request.getParameter("idprofessor");
        String iddisciplina = request.getParameter("iddisciplina");

        try {
            ProfessorDAO proDAO = new ProfessorDAO();
            if (idprofessor.equals("") || iddisciplina.equals("")) {
                mensagem = "Campos obrigatórios deverão ser selecionados";
            } else {
                if (proDAO.vincular(Integer.parseInt(idprofessor), Integer.parseInt(iddisciplina))) {
                    mensagem = "Vinculado com sucesso";
                } else {
                    mensagem = "Erro ao Vincular";
                }
            }
        } catch (Exception e) {
            out.print(e);
            mensagem = "Erro ao executar";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('" + mensagem + "')");
        out.println("location.href='gerenciar_professor_disciplina.do?acao=gerenciar&idprofessor=" + idprofessor + "';");
        out.println("</script>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
