
package controller;

import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Menu;
import model.Usuario;

public class GerenciarLogin extends HttpServlet {

    private static HttpServletResponse response;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //redirecionamento do usuario após sair da sessão
        request.getSession().removeAttribute("ulogado"); //removendo o usuario logado da sessao
        response.sendRedirect("form_login.jsp"); //redirecionamento de logoff        

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        GerenciarLogin.response = response;
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        ArrayList<String> erros = new ArrayList<String>();
        if (login == null || login.trim().isEmpty()) { //trim é pra remover os espaços
            erros.add("\nLogin");
        }
        if (senha == null || senha.trim().isEmpty()) { //trim é pra remover os espaços
            erros.add("\nSenha");
        }
        if (erros.size() > 0) { //size pra pegar o tamanho da lista de erro
            String campos = "";
            for (String erro : erros) {
                campos += "\\n" + erro;
            }
            exibirMensagem("Preencha todos os campos " + campos);
        } else { //se achar o usuario
            try {
                Usuario u = new Usuario();
                UsuarioDAO uDAO = new UsuarioDAO();
                u = uDAO.getRecuperarUsuario(login);
                if (u.getIdusuario() > 0 && u.getSenha().equals(senha)) {//validar o usuario e conferindo se as senhas sao iguais
                    HttpSession sessao = request.getSession(); //
                    sessao.setAttribute("ulogado", u);
                    response.sendRedirect("index2.jsp"); //redirecionar para index2                                       
                } else {
                    exibirMensagem("Usuário ou senha inválidos!");
                }
            } catch (Exception e) {
                exibirMensagem("Usuário ou Perfil não encontrado!");
            }
        }
    }

    public static Usuario verificarAcesso(HttpServletRequest request, HttpServletResponse response) {

        Usuario u = null;
        GerenciarLogin.response = response;
        try {
            HttpSession sessao = request.getSession();
            if (sessao.getAttribute("ulogado") == null) {
                response.sendRedirect("form_login.jsp");
            } else {
                String uri = request.getRequestURI();
                String queryString = request.getQueryString();
                if (queryString != null) {
                    uri += "?" + queryString;
                }
                u = (Usuario) request.getSession().getAttribute("ulogado");
                if (u == null) {
                    sessao.setAttribute("mensagem", "Você não está autenticado");
                    response.sendRedirect("form_login.jsp");
                } else {
                    boolean possuiAcesso = false;
                    for (Menu m : u.getPerfil().getMenus()) {
                        if (uri.contains(m.getLink())) {
                            possuiAcesso = true;
                            break;
                        }
                    }
                    if (!possuiAcesso) {
                        exibirMensagem("Acesso Negado");
                    }

                }
            }
        } catch (Exception e) {
            exibirMensagem(e.getMessage());
        }
        return u;
    }

    public static boolean verificarPermissao(HttpServletRequest request, HttpServletResponse response) {

        Usuario u = null;
        GerenciarLogin.response = response;
        boolean possuiAcesso = false;
        try {
            HttpSession sessao = request.getSession();
            if (sessao.getAttribute("ulogado") == null) {
                response.sendRedirect("form_login.jsp");
            } else {
                String uri = request.getRequestURI();
                String queryString = request.getQueryString();
                if (queryString != null) {
                    uri += "?" + queryString;
                }
                u = (Usuario) request.getSession().getAttribute("ulogado");
                if (u == null) {
                    sessao.setAttribute("mensagem", "Você não está autenticado");
                    response.sendRedirect("form_login.jsp");
                } else {
                    for (Menu m : u.getPerfil().getMenus()) {
                        if (uri.contains(m.getLink())) {
                            possuiAcesso = true;
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            exibirMensagem(e.getMessage());
        }
        return possuiAcesso;
    }

    private static void exibirMensagem(String mensagem) {
        try {
            PrintWriter out = response.getWriter();
            out.print("<script>");
            out.print("alert('" + mensagem + "');");
            out.print("history.back();");
            out.print("</script>");
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
