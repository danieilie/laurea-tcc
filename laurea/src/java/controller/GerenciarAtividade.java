
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.AtividadeDAO;
import model.Disciplina;
import model.Atividade;

public class GerenciarAtividade extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String mensagem = "";
        int idatividade = Integer.parseInt(request.getParameter("idatividade"));
        String acao = request.getParameter("acao");

        try {
            Atividade a = new Atividade();
            AtividadeDAO aDAO = new AtividadeDAO();
            if (acao.equals("alterar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    a = aDAO.getCarregaPorId(idatividade);
                    if (a.getIdatividade() > 0) {
                        RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_atividade.jsp");
                        request.setAttribute("atividade", a);
                        disp.forward(request, response);
                    } else {
                        mensagem = "Atividade não encontrada";
                    }
                } else {
                    mensagem = "Acesso negado";
                }
            }

            if (acao.equals("desativar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    a.setIdatividade(idatividade);
                    if (aDAO.desativar(a)) {
                        mensagem = "Desativado com sucesso!";
                    } else {
                        mensagem = "Erro ao desativar!";
                    }
                } else {
                    mensagem = "Acesso negado";
                }
            }
            
            if (acao.equals("excluir")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    a.setIdatividade(idatividade);
                    if (aDAO.excluir(a)) {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String idatividade = request.getParameter("idatividade");
        String nome = request.getParameter("nome");
        String arquivo = request.getParameter("arquivo");
        String iddisciplina = request.getParameter("iddisciplina");
        String mensagem = "";

        Atividade a = new Atividade();
        if (!idatividade.isEmpty()) {
            a.setIdatividade(Integer.parseInt(idatividade));
        }
        try {
            AtividadeDAO aDAO = new AtividadeDAO();
            if (nome.equals("") || arquivo.equals("") || iddisciplina.equals("")) {
                mensagem = "Campos obrigatórios deverão ser preenchidos";
            } else {
                a.setNome(nome);
                a.setArquivo(arquivo);
                Disciplina d = new Disciplina();
                d.setIddisciplina(Integer.parseInt(iddisciplina));
                a.setDisciplina(d);
                if (aDAO.gravar(a)) {
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

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
