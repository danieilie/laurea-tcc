<%-- 
    Document   : index
    Created on : 08/08/2019, 10:22:26
    Author     : Administrador
--%>

<%@page import="model.MensalidadeDAO"%>
<%@page import="model.Mensalidade"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, 
              user-scalable=no" name="viewport"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css"/>
        <link rel="stylesheet" href="datatables/jquery.dataTables.min.css"/>
        <title>Láurea Reforço Escolar</title>

        <script type="text/javascript">

            function confirmarExclusao(id, nome) {
                if (confirm('Deseja realmente excluir o mensalidade  ' + nome + ' ?')) {
                    location.href = 'gerenciar_mensalidade.do?acao=excluir&idmensalidade=' + id;
                }
            }
        </script>

    </head>
    <body>
        <div class="container">
            <%@include file="banner.jsp" %>
            <%@include file="menu.jsp" %>
            <h1>Lista de Mensalidades</h1>

            <a href="form_mensalidade.jsp" class="btn btn-primary">
                Novo Cadastro
            </a>
            <table class="table table-hover table-striped table-bordered display" 
                   id ="listaMensalidade" >

                <thead>
                    <tr>
                        <th>Nº Contrato</th>
                        <th>Nº Mendalidade</th>
                        <th>Nome do Aluno</th>
                        <th>Nome do Responsável</th>
                        <th>Mês</th>
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
                        <th>Mês</th>
                        <th>Valor</th>
                        <th>Data de Vencimento</th>
                        <th>Data do Pagamento</th>
                        <th>Multa</th>
                        <th>Desconto</th>
                        <th>Status</th>
                        <th>Opções</th>
                    </tr>
                </tfoot>

                <jsp:useBean class="model.MensalidadeDAO" id="menDAO" />

                <tbody>
                    <c:forEach var="men" items="${menDAO.lista}">
                        <tr>
                            <td>${men.contrato.idcontrato}</td>
                            <td>${men.idmensalidade}</td>
                            <td>${men.contrato.aluno.nome}</td>
                            <td>${men.contrato.aluno.responsavel.nome}</td>
                            <td>${men.mes}</td>
                            <td>${men.valor}</td>
                            <td>${men.datav}</td>
                            <td>${men.datap}</td>
                            <td>${men.multa}</td>
                            <td>${men.desconto}</td>
                            <td>
                                <c:if test="${men.status == 2}" > Pendente </c:if>
                                <c:if test="${men.status == 1}" > Pago </c:if>
                                </td>
                                <td>
                                    <a class="btn btn-primary" href="gerenciar_mensalidade.do?acao=alterar&idmensalidade=${pr.idmensalidade}">
                                    <i class="glyphicon glyphicon-pencil"></i>
                                </a>
                                <button class="btn btn-danger" onclick="confirmarExclusao(${pr.idmensalidade}, '${pr.nome}')" >
                                    <i class="glyphicon glyphicon-trash"></i>
                                </button>    
                            </td>
                        </tr>
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
