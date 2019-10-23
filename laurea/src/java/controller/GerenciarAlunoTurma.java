package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Aluno;
import DAO.AlunoDAO;

public class GerenciarAlunoTurma extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String mensagem = "";
        int idaluno = Integer.parseInt(request.getParameter("idaluno"));
        String acao = request.getParameter("acao");

        try {
            Aluno a = new Aluno();
            AlunoDAO aDAO = new AlunoDAO();
            if (acao.equals("alterar")) {
                if (GerenciarLogin.verificarPermissao(request, response)) {
                    a = aDAO.getCarregaPorId(idaluno);
                    if (a.getIdaluno() > 0) {
                        RequestDispatcher disp = getServletContext().getRequestDispatcher("/form_aluno_turma.jsp");
                        request.setAttribute("alunoturma", a);
                        disp.forward(request, response);
                    } else {
                        mensagem = "AlunoTurma não encontrado";
                    }
                } else {
                    mensagem = "Acesso negado";
                }
            }

            /**
             * if(acao.equals("excluir")){
             * if(GerenciarLogin.verificarPermissao(request, response)){
             * pr.setIdalunoturma(idalunoturma); if(prDAO.excluir(pr)){ mensagem
             * = "Excluído com sucesso!"; }else{ mensagem = "Erro ao excluir!";
             * } }else{ mensagem ="Acesso negado"; } * }
             */
        } catch (Exception e) {
            out.print(e);
            mensagem = "Erro ao executar o comando";
        }
        out.println("<script type='text/javascript'>");
        out.println("alert('" + mensagem + "')");
        out.println("location.href='listar_aluno_turma.jsp';");
        out.println("</script>");

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String mensagem = "";
        String idaluno = request.getParameter("idaluno");
        String idturma = request.getParameter("idturma");
        String frequencia = request.getParameter("frequencia");

        try {
            AlunoDAO aDAO = new AlunoDAO();
            if (frequencia.equals("--") || idaluno.equals("") || idturma.equals("")) {
                if (idaluno.equals("") || idturma.equals("") || frequencia.equals("")) {
                    mensagem = "Campos obrigatórios deverão ser selecionados!";
                } else {
                    if (aDAO.criarTurma(Integer.parseInt(idaluno), Integer.parseInt(idturma), frequencia)) {
                        mensagem = "Vinculado com sucesso!";
                    } else {
                        mensagem = "Erro ao vincular!";
                    }
                }
            } else {
                if (idaluno.equals("") || idturma.equals("") || frequencia.equals("")) {
                    mensagem = "Campos obrigatórios deverão ser selecionados!";
                } else {
                    if (aDAO.fazerChamada(Integer.parseInt(idaluno), Integer.parseInt(idturma), frequencia)) {
                        mensagem = "Vinculado com sucesso!";
                    } else {
                        mensagem = "Erro ao vincular!";
                    }
                }
            }

        } catch (Exception e) {
            out.print(e);
            mensagem = "Erro ao executar!";
        }

        out.println("<script type='text/javascript'>");
        out.println("alert('" + mensagem + "')");
        out.println("location.href='listar_aluno_turma.jsp';");
        out.println("</script>");

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
