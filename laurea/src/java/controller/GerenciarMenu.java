package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Menu;
import DAO.MenuDAO;

public class GerenciarMenu extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        int idmenu = Integer.parseInt(request.getParameter("idmenu"));
        String acao = request.getParameter("acao");
        String mensagem = "";
        Menu m = new Menu();
        try {
            MenuDAO mDAO = new MenuDAO();
            if (acao.equals("alterar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    m = mDAO.getCarregaPorId(idmenu);
                    if (m.getIdmenu() > 0) {
                        RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_menu.jsp");
                        request.setAttribute("menu", m);
                        disp.forward(request, response);
                    } else {
                        mensagem = "Menu não encontrado";
                    }
                } else {
                    mensagem = "Acesso Negado";
                }
            }
            if (acao.equals("desativar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    m.setIdmenu(idmenu);
                    if (mDAO.desativar(m)) {
                        mensagem = "Desativado com sucesso!";
                    } else {
                        mensagem = "Erro ao desativar!";
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
        out.println("location.href='listar_menu.jsp';");
        out.println("</script>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String idmenu = request.getParameter("idmenu");
        String menu = request.getParameter("menu");
        String link = request.getParameter("link");
        String icone = request.getParameter("icone");
        String exibir = request.getParameter("exibir");
        String mensagem = "";

        Menu m = new Menu();
        if (!idmenu.isEmpty()) {
            m.setIdmenu(Integer.parseInt(idmenu));
        }
        try {
            MenuDAO mDAO = new MenuDAO();
            if (menu.equals("") || menu.isEmpty() || link.equals("") || link.isEmpty() || exibir.equals("0")) {
                mensagem = "Campos obrigatórios deverão ser preenchidos";
            } else {
                m.setMenu(menu);
                m.setLink(link);
                m.setIcone(icone);
                m.setExibir(Integer.parseInt(exibir));
                if (mDAO.gravar(m)) {
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
        out.println("location.href='listar_menu.jsp';");
        out.println("</script>");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
