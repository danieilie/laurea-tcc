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
        <link rel="stylesheet" type="text/css" href="assets/css/estilo_listas.css">
        <link rel="stylesheet" href="datatables/jquery.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css?family=Lato&display=swap" rel="stylesheet">
        <link rel="shortcut icon" href="assets/img/logo/logo_menu.png"/>
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
        <%@include file="menu.jsp" %>

        <div class="row  justify-content-center" id="listagem" style="padding-top: 50px;">
            <div class="table-responsive">
                <table class="table table-hover table-sm table-striped" id ="listaMensalidade" >
                    <thead>
                        <tr>
                            <th style="text-align: center;">Contrato</th>

                            <th>Aluno</th>
                            <th>Responsável</th>
                            <th>Valor</th>
                            <th>Vencimento</th>
                            <th>Pagamento</th>

                            <th>Status</th>
                            <th>Opções</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th style="text-align: center;">Nº Contrato</th>

                            <th>Aluno</th>
                            <th>Responsável</th>
                            <th>Valor</th>
                            <th>Vencimento</th>
                            <th>Pagamento</th>

                            <th>Status</th>
                            <th>Opções</th>
                        </tr>
                    </tfoot>

                    <jsp:useBean class="DAO.ContratoDAO" id="cDAO" />
                    <tbody>
                        <c:forEach var="c" items="${cDAO.mensalidaVinculadaPorContrato(idcontrato)}">
                            <tr>
                                <td style="text-align: center;">${c.contrato.idcontrato}</td>
                                <td>${c.contrato.aluno.nome}</td>
                                <td>${c.contrato.aluno.responsavel.nome}</td>
                                <td>${m.valor}</td>
                                <td>${m.datav}</td>
                                <td>${m.datap}</td>
                                <td>
                                    <c:if test="${m.status == 0}" > Pendente </c:if>
                                    <c:if test="${m.status == 1}" > Pago </c:if>
                                    </td>
                                    <td>
                                        <a class="icone_lista" href="gerenciar_mensalidade.do?acao=gravar&idmensalidade=${p.idmensalidade}">
                                        <img src="assets/img/lista/editar.png">
                                    </a>

                                </td>
                            </tr>
                        </c:forEach>                    
                    </tbody>    
                </table> 
            </div>
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
