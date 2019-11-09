
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Responsavel;
import DAO.ResponsavelDAO;
import model.Usuario;

public class GerenciarResponsavel extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String mensagem = "";
        int idresponsavel = Integer.parseInt(request.getParameter("idresponsavel"));
        String acao = request.getParameter("acao");

        try {
            Responsavel r = new Responsavel();
            ResponsavelDAO rDAO = new ResponsavelDAO();
            if (acao.equals("alterar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    r = rDAO.getCarregaPorId(idresponsavel);
                    if (r.getIdresponsavel() > 0) {
                        RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_responsavel.jsp");
                        request.setAttribute("responsavel", r);
                        disp.forward(request, response);
                    } else {
                        mensagem = "Responsavel não encontrado";
                    }
                } else {
                    mensagem = "Acesso negado";
                }
            }
            
            if (acao.equals("alterar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    r.setIdresponsavel(idresponsavel);
                    if (rDAO.alterar(r)) {
                        mensagem = "Desativado com sucesso!";
                    } else {
                        mensagem = "Erro ao desativar!";
                    }
                } else {
                    mensagem = "Acesso negado";
                }

            }

            if(acao.equals("excluir")){
              if(GerenciarLogin.verificarPermissao(request, response)){    
                r.setIdresponsavel(idresponsavel);
                if(rDAO.excluir(r)){
                    mensagem = "Excluído com sucesso!";
                }else{
                    mensagem = "Erro ao excluir!";
                }
              }else{
                  mensagem ="Acesso negado";
              }  
            
            }
            
        } catch (Exception e) {
            out.print(e);
            mensagem = "Erro ao executar o comando";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('" + mensagem + "')");
        out.println("location.href='listar_responsavel.jsp';");
        out.println("</script>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String idresponsavel = request.getParameter("idresponsavel");
        String nome = request.getParameter("nome");
        String cpf = request.getParameter("cpf");
        String rg = request.getParameter("rg");
        String status = request.getParameter("status");
        String idusuario = request.getParameter("idusuario");
        String mensagem = "";

        Responsavel r = new Responsavel();
        if (!idresponsavel.isEmpty()) {
            r.setIdresponsavel(Integer.parseInt(idresponsavel));
        }
        try {
            ResponsavelDAO rDAO = new ResponsavelDAO();
            if (nome.equals("") || cpf.equals("") || status.equals("") ||idusuario.equals("")) {
                mensagem = "Campos obrigatórios deverão ser preenchidos";
            } else {
                r.setNome(nome);
                r.setCpf(cpf);
                r.setRg(rg);
                r.setStatus(Integer.parseInt(status));
                Usuario u = new Usuario();
                u.setIdusuario(Integer.parseInt(idusuario));
                r.setUsuario(u);
                if (rDAO.gravar(r)) {
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
        out.println("location.href='listar_responsavel.jsp';");
        out.println("</script>");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
