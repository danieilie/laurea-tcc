<%@page import="DAO.MenuDAO"%>
<%@page import="model.Menu"%>
<%@page import="java.util.ArrayList"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

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
        <title>Listagem Menus</title>
        <script type="text/javascript">
            function confirmarExclusao(id, nome) {
                if (confirm('Deseja realmente excluir o menu "' + nome + '" ?')) {
                    location.href = 'gerenciar_menu.do?acao=excluir&idmenu=' + id;
                }
            }
        </script>    
    </head>
    <body class="body">
        <%@include file="menu.jsp" %>
         <div class="row">
            <a href="form_menu.jsp" class="" > <div class="float-left" id="btn_cadastrar"> Novo Cadastro </div></a>
         </div>
        
        <div class="row  justify-content-center" id="listagem">
       
            <div class="table-responsive">
            <table class="table table-hover table-sm" id="listaMenu">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Menu</th>
                        <th>Link</th>
                        <th>Icone</th>
                        <th>Exibir</th>
                        <th>Opções</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Menu</th>
                        <th>Link</th>
                        <th>Icone</th>
                        <th>Exibir</th>
                        <th>Opções</th>
                    </tr>
                </tfoot>

                <jsp:useBean class="DAO.MenuDAO" id="mDAO"/>
                <tbody>
                    <c:forEach var="m" items="${mDAO.lista}">
                        <tr>
                            <td>${m.idmenu}</td>
                            <td>${m.menu}</td>
                            <td>${m.link}</td>
                            <td>${m.icone}</td>
                            <td>
                                <c:if test="${m.exibir==1}">Sim</c:if>
                                <c:if test="${m.exibir==2}">Não</c:if>
                                </td>
                                <td>
                                    <a class="btn btn-primary" href="gerenciar_menu.do?acao=alterar&idmenu=${m.idmenu}">
                                    <i class="glyphicon glyphicon-pencil"></i>
                                </a>
                                <button class="btn btn-danger" onclick="confirmarExclusao(${m.idmenu}, '${m.menu}')">
                                    <i class="glyphicon glyphicon-trash"></i>
                                </button>    
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>    
        </div>

        <script type="text/javascript" src="datatables/jquery.js"></script>
        <script type="text/javascript" src="datatables/jquery.dataTables.min.js"></script>
        <script type="text/javascript">
                                    $(document).ready(function () {
                                        $("#listaMenu").dataTable({
                                            "bJQueryUI": true,
                                            "oLanguage": {
                                                "sProcessing": "Processando...",
                                                "sLengthMenu": "Mostrar _MENU_ registros",
                                                "sZeroRecords": "Não foram encontrados resultados",
                                                "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                                                "sInfoEmpty": "Mostrando de 0 até 0 de 0 registros",
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
                                        })
                                    });
        </script>            

    </body>
</html>
