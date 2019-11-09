<%@page import="DAO.ResponsavelDAO"%>
<%@page import="model.Responsavel"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css"/>
        <link rel="stylesheet" href="datatables/jquery.dataTables.min.css"/>
        <title>Láurea Reforço Escolar</title>
        <script type="text/javascript">
            function confirmarExclusao(id, nome) {
                if (confirm('Deseja realmente excluir o responsavel  ' + nome + ' ?')) {
                    location.href = 'gerenciar_responsavel.do?acao=excluir&idresponsavel=' + id;
                }
            }
        </script>

    </head>
    <body class="body">
        <div class="container">
            <%@include file="banner.jsp" %>
            <%@include file="menu.jsp" %>
            <h1>Lista de Responsáveis</h1>

            <a href="form_responsavel.jsp" class="btn btn-primary">Novo Cadastro</a>
            <table class="table table-hover table-striped table-bordered display" id ="listaResponsavel" >

                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>RG</th>
                        <th>Nome de Usuário</th>
                        <th>Opções</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>CPF</th>
                        <th>RG</th>
                        <th>Nome de Usuário</th>
                        <th>Opções</th>
                    </tr>
                </tfoot>

                <jsp:useBean class="DAO.ResponsavelDAO" id="rDAO" />

                <tbody>
                    <c:forEach var="r" items="${rDAO.lista}">
                        <tr>
                            <td>${r.idresponsavel}</td>
                            <td>${r.nome}</td>
                            <td>${r.cpf}</td>
                            <td>${r.rg}</td>
                            <td>${r.usuario}</td>
                            <td>
                                <a class="btn btn-primary" href="gerenciar_responsavel.do?acao=alterar&idresponsavel=${p.idresponsavel}">
                                    <i class="glyphicon glyphicon-pencil"></i>
                                </a>
                                <button class="btn btn-danger" onclick="confirmarExclusao(${p.idresponsavel}, '${p.nome}')" >
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
                                        $("#listaResponsavel").dataTable({
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
