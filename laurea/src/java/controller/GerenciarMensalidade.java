package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contrato;
import model.Mensalidade;
import DAO.MensalidadeDAO;
import java.text.SimpleDateFormat;

public class GerenciarMensalidade extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String mensagem = "";
        int idcontrato = Integer.parseInt(request.getParameter("idcontrato"));
        int idmensalidade = Integer.parseInt(request.getParameter("idmensalidade"));
        String acao = request.getParameter("acao");

        try {
            Mensalidade m = new Mensalidade();
            MensalidadeDAO mDAO = new MensalidadeDAO();
            if (acao.equals("alterar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    m = mDAO.getCarregaPorId(idcontrato, idmensalidade);
                    if (m.getIdmensalidade() > 0) {
                        RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_mensalidade.jsp");
                        request.setAttribute("mensalidade", m);
                        disp.forward(request, response);
                    } else {
                        mensagem = "Mensalidade não encontrada";
                    }
                } else {
                    mensagem = "Acesso negado";
                }
            }

            if (acao.equals("gravar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    m.setIdmensalidade(idmensalidade);
                    if (mDAO.gravar(m)) {
                        mensagem = "Atualizada com sucesso!";
                    } else {
                        mensagem = "Erro ao atualizar";
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
        out.println("location.href='listar_mensalidade.jsp';");
        out.println("</script>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String idmensalidade = request.getParameter("idmensalidade");
        String idcontrato = request.getParameter("idcontrato");
        String valor = request.getParameter("valor");
        String datav = request.getParameter("datav");
        String datap = request.getParameter("datap");
        String multa = request.getParameter("multa");
        String desconto = request.getParameter("desconto");
        String status = request.getParameter("status");
        String mensagem = "";

        Mensalidade m = new Mensalidade();
        if (!idmensalidade.isEmpty()) {
            m.setIdmensalidade(Integer.parseInt(idmensalidade));
        }
        try {
            MensalidadeDAO mDAO = new MensalidadeDAO();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Contrato c = new Contrato();
            c.setIdcontrato(Integer.parseInt(idcontrato));
            m.setValor(Double.parseDouble(valor));
            m.setMulta(Double.parseDouble(multa));
            m.setDesconto(Double.parseDouble(desconto));
            m.setStatus(Integer.parseInt(status));
            if (!idmensalidade.isEmpty()) {
                m.setIdmensalidade(Integer.parseInt(idmensalidade));
            }
            m.setDatav(df.parse(datav));
            m.setDatap(df.parse(datap));

            double novovalor = 0;
            if (!valor.isEmpty()) {
                novovalor = Double.parseDouble(valor.replace(".", "").replace(",", "."));
                m.setValor(novovalor);
            }
            double novamulta = 0;
            if (!multa.isEmpty()) {
                novamulta = Double.parseDouble(multa.replace(".", "").replace(",", "."));
                m.setMulta(novamulta);
            }

            double novodesconto = 0;
            if (!desconto.isEmpty()) {
                novodesconto = Double.parseDouble(desconto.replace(".", "").replace(",", "."));
                m.setDesconto(novodesconto);
            }

            if (valor.equals("") || valor.isEmpty() || datap.equals("") || datap.isEmpty()) {
                mensagem = "Campos obrigatórios devem ser preenchidos";
            } else {
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
        out.println("location.href='listar_mensalidade.jsp';");
        out.println("</script>");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
