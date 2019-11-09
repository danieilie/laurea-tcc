
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Perfil;
import DAO.PerfilDAO;

public class GerenciarPerfil extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        int idperfil = Integer.parseInt(request.getParameter("idperfil"));
        String acao = request.getParameter("acao");
        String mensagem = "";
        Perfil p = new Perfil();
        try {
            PerfilDAO pDAO = new PerfilDAO();
            if (acao.equals("alterar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    p = pDAO.getCarregaPorId(idperfil);
                    if (p.getIdperfil() > 0) {
                        RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_perfil.jsp");
                        request.setAttribute("perfil", p);
                        disp.forward(request, response);
                    } else {
                        mensagem = "Perfil não encontrado";
                    }
                } else {
                    mensagem = "Acesso negado";
                }
            }
            if (acao.equals("desativar")) {
                p.setIdperfil(idperfil);
                if (pDAO.desativar(1, idperfil)) {
                    mensagem = "Excluído com sucesso!";
                } else {
                    mensagem = "Erro ao excluir!";
                }

            }

        } catch (Exception e) {
            out.print(e);
            mensagem = "Erro ao executar o comando";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('" + mensagem + "')");
        out.println("location.href='listar_perfil.jsp';");
        out.println("</script>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String idperfil = request.getParameter("idperfil");
        String perfil = request.getParameter("perfil");
        String mensagem = "";

        Perfil p = new Perfil();
        if (!idperfil.isEmpty()) {
            p.setIdperfil(Integer.parseInt(idperfil));
        }
        try {
            PerfilDAO pDAO = new PerfilDAO();
            if (perfil.equals("") || perfil.isEmpty()) {
                mensagem = "Campos obrigatórios deverão ser preenchidos";
            } else {
                p.setPerfil(perfil);
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
        out.println("location.href='listar_perfil.jsp';");
        out.println("</script>");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
