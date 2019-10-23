package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import model.Pendencia;
import DAO.PendenciaDAO;

public class GerenciarPendencia extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String mensagem = "";
        int idpendencia = Integer.parseInt(request.getParameter("idpendencia"));
        String acao = request.getParameter("acao");

        try {
            Pendencia p = new Pendencia();
            PendenciaDAO pDAO = new PendenciaDAO();
            if (acao.equals("alterar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    p = pDAO.getCarregaPorId(idpendencia);
                    if (p.getIdpendencia() > 0) {
                        RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_pendencia.jsp");
                        request.setAttribute("pendencia", p);
                        disp.forward(request, response);
                    } else {
                        mensagem = "Pendencia não encontrado";
                    }
                } else {
                    mensagem = "Acesso negado";
                }
            }

            /*  if(acao.equals("excluir")){
              if(GerenciarLogin.verificarPermissao(request, response)){    
                pen.setIdpendencia(idpendencia);
                if(penDAO.excluir(pen)){
                    mensagem = "Excluído com sucesso!";
                }else{
                    mensagem = "Erro ao excluir!";
                }
              }else{
                  mensagem ="Acesso negado";
              }  
            
            } */
        } catch (Exception e) {
            out.print(e);
            mensagem = "Erro ao executar o comando";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('" + mensagem + "')");
        out.println("location.href='listar_pendencia.jsp';");
        out.println("</script>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String idpendencia = request.getParameter("idpendencia");
        String valor = request.getParameter("nome");
        String idaluno = request.getParameter("iddisciplina");
        String mensagem = "";

        Pendencia p = new Pendencia();
        if (!idpendencia.isEmpty()) {
            p.setIdpendencia(Integer.parseInt(idpendencia));
        }
        try {
            PendenciaDAO pDAO = new PendenciaDAO();
            if (valor.equals("") || idaluno.equals("")) {
                mensagem = "Campos obrigatórios deverão ser preenchidos";
            } else {
                p.setValor(Double.parseDouble(valor));
                Aluno a = new Aluno();
                a.setIdaluno(Integer.parseInt(idaluno));
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
        out.println("location.href='listar_pendencia.jsp';");
        out.println("</script>");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
