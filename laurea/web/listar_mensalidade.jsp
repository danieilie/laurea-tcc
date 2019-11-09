<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="DAO.MensalidadeDAO"%>
<%@page import="model.Mensalidade"%>
<%@page import="model.Contrato"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css"/>
        <link rel="stylesheet" href="datatables/jquery.dataTables.min.css"/>
        <title>Listar Mensalidade</title>
        <script type="text/javascript">
            function confirmarExclusao(id, nome) {
                if (confirm('Deseja realmente excluir o mensalidade  "' + nome + '" ?')) {
                    location.href = 'gerenciar_mensalidade.do?acao=excluir&idmensalidade=' + id;
                }
            }
        </script>

    </head>
     <body class="body">
        <div class="container">
            <%@include file="banner.jsp" %>
            <%@include file="menu.jsp" %>
            <h1>Lista de Mensalidades</h1>

            <a href="form_mensalidade.jsp" class="btn btn-primary">Novo Cadastro</a>
            <table class="table table-hover table-striped table-bordered display" id ="listaMensalidade" >
                <thead>
                    <tr>
                        <th>Nº Contrato</th>
                        <th>Nº Mendalidade</th>
                        <th>Nome do Aluno</th>
                        <th>Nome do Responsável</th>
                        <th>Valor</th>
                        <th>Data de Vencimento</th>
                        <th>Data do Pagamento</th>
                        <th>Multa</th>
                        <th>Desconto</th>
                        <th>Status</th>
                        <th>Opções</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>Nº Contrato</th>
                        <th>Nº Mendalidade</th>
                        <th>Nome do Aluno</th>
                        <th>Nome do Responsável</th>
                        <th>Valor</th>
                        <th>Data de Vencimento</th>
                        <th>Data do Pagamento</th>
                        <th>Multa</th>
                        <th>Desconto</th>
                        <th>Status</th>
                        <th>Opções</th>
                    </tr>
                </tfoot>

                <jsp:useBean class="DAO.MensalidadeDAO" id="mDAO" />
                <tbody>
                    <c:forEach var="m" items="${mDAO.lista}">
                        <%--<c:if test="${m.contrato.aluno.responsavel.nome }">--%>
                            <tr>
                                <td>${c.contrato.idcontrato}</td>
                                <td>${m.idmensalidade}</td>
                                <td>${c.contrato.aluno.nome}</td>
                                <td>${c.contrato.aluno.responsavel.nome}</td>
                                <td>${m.valor}</td>
                                <td>${m.datav}</td>
                                <td>${m.datap}</td>
                                <td>${m.multa}</td>
                                <td>${m.desconto}</td>
                                <td>
                                    <c:if test="${m.status == 2}" > Pendente </c:if>
                                    <c:if test="${m.status == 1}" > Pago </c:if>
                                    </td>
                                    <td>
                                        <a class="btn btn-primary" href="gerenciar_mensalidade.do?acao=gravar&idmensalidade=${p.idmensalidade}">
                                        <i class="glyphicon glyphicon-pencil"></i>
                                    </a>
                                    <button class="btn btn-danger" onclick="confirmarExclusao(${p.idmensalidade}, '${p.nome}')" >
                                        <i class="glyphicon glyphicon-trash"></i>
                                    </button>    
                                </td>
                            </tr>
                        <%--</c:if>--%>    
                    </c:forEach>                    
                </tbody>    
            </table>    
        </div>

        <script type="text/javascript" src="datatables/jquery.js"></script>
        <script type="text/javascript" src="datatables/jquery.dataTables.min.js" ></script>
        <script type="text/javascript" >

                                    $(document).ready(function () {
                                        $("#listaMensalidade").dataTable({
                                            "bJQueryUI": true,
                                            "oLanguage": {
                                                "sProcessing": "Processando ...",
                                                "sLengthMenu": "Mostrar _MENU_ registros",
                                                "sZeroRecords": "Não foram encontrados resultados",
                                                "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                                                "sInfoEmpty": "Mostrando de 0 até 0 de 0 resgistros",
                                                "sInfoFiltered": "",
                                                "sInfoPostFix": "",
                                                "sSearch": "Pesquisar",
                                                "sUrl": "",
                                                "oPaginate": {
                                                    "sFirst": "Primeiro",
                                                    "sPrevious": "Anterior",
                                                    "sNext": "Próximo",
                                                    "sLast": "Último"
                                                }
                                            }
                                        });
                                    });
        </script>
    </body>
</html>
