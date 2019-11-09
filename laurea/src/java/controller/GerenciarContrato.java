
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import model.Contrato;
import DAO.ContratoDAO;
import java.text.SimpleDateFormat;

public class GerenciarContrato extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String mensagem = "";
        int idcontrato = Integer.parseInt(request.getParameter("idcontrato"));
        String acao = request.getParameter("acao");

        try {
            Contrato c = new Contrato();
            ContratoDAO cDAO = new ContratoDAO();
            if (acao.equals("alterar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    c = cDAO.getCarregaPorId(idcontrato);
                    if (c.getIdcontrato() > 0) {
                        RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_contrato.jsp");
                        request.setAttribute("contrato", c);
                        disp.forward(request, response);
                    } else {
                        mensagem = "Contrato não encontrado";
                    }
                } else {
                    mensagem = "Acesso negado";
                }
            }

            if (acao.equals("excluir")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    c.setIdcontrato(idcontrato);
                    if (cDAO.excluir(c)) {
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
        out.println("location.href='listar_contrato.jsp';");
        out.println("</script>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String idcontrato = request.getParameter("idcontrato");
        String datacontrato = request.getParameter("datacontrato");
        String preco = request.getParameter("preco");
        String parcela = request.getParameter("parcela");
        String status = request.getParameter("status");
        String serie = request.getParameter("serie");
        String escola = request.getParameter("escola");
        String idaluno = request.getParameter("idaluno");

        String mensagem = "";

        Contrato c = new Contrato();
        if (!idcontrato.isEmpty()) {
            c.setIdcontrato(Integer.parseInt(idcontrato));
        }
        try {            
            ContratoDAO cDAO = new ContratoDAO();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            if (datacontrato.equals("") || preco.equals("") || parcela.equals("") || status.equals("") || serie.equals("") || idaluno.equals("")) {
                mensagem = "Campos obrigatórios deverão ser preenchidos";
            } else {
                c.setDatacontrato(df.parse(datacontrato));
                c.setPreco(Double.parseDouble(preco));                
            double novopreco = 0;
            if(!preco.isEmpty())
                novopreco = Double.parseDouble(preco.replace(".","").replace(",","."));
            c.setPreco(novopreco);            
                c.setParcela(Integer.parseInt(parcela));
                c.setStatus(Integer.parseInt(status));
                c.setSerie(serie);
                c.setEscola(escola);
                Aluno a = new Aluno();
                a.setIdaluno(Integer.parseInt(idaluno));
                c.setAluno(a);
                if(cDAO.gravar(c)){
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
        out.println("location.href='listar_contrato.jsp';");
        out.println("</script>");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
