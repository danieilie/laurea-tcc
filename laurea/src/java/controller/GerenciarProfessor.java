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
import model.Usuario;

public class GerenciarProfessor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String mensagem = "";
        int idprofessor = Integer.parseInt(request.getParameter("idprofessor"));
        String acao = request.getParameter("acao");

        try {
            Professor p = new Professor();
            ProfessorDAO pDAO = new ProfessorDAO();
            if (acao.equals("alterar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    p = pDAO.getCarregaPorId(idprofessor);
                    if (p.getIdprofessor() > 0) {
                        RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_professor.jsp");
                        request.setAttribute("professor", p);
                        disp.forward(request, response);
                    } else {
                        mensagem = "Professor não encontrado";
                    }
                } else {
                    mensagem = "Acesso negado";
                }
            }

            if (acao.equals("desativar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    p.setIdprofessor(idprofessor);
                    if (pDAO.desativar(p)) {
                        mensagem = "Desativado com sucesso!";
                    } else {
                        mensagem = "Erro ao desativar!";
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
        out.println("location.href='listar_professor.jsp';");
        out.println("</script>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String idprofessor = request.getParameter("idprofessor");
        String nome = request.getParameter("nome");
        String status = request.getParameter("status");
        String idusuario = request.getParameter("idusuario");
        String mensagem = "";

        Professor p = new Professor();
        if (!idprofessor.isEmpty()) {
            p.setIdprofessor(Integer.parseInt(idprofessor));
        }
        try {
            ProfessorDAO pDAO = new ProfessorDAO();
            if (nome.equals("") || status.equals("") || idusuario.equals("")) {
                mensagem = "Campos obrigatórios deverão ser preenchidos";
            } else {
                p.setNome(nome);
                p.setStatus(Integer.parseInt(status));
                Usuario u = new Usuario();
                u.setIdusuario(Integer.parseInt(idusuario));
                p.setUsuario(u);
                if (pDAO.gravar(p)) {
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
        out.println("location.href='listar_professor.jsp';");
        out.println("</script>");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
