<%@page import="DAO.UsuarioDAO"%>
<%@page import="model.Usuario"%>
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
        <title>Láurea Reforço Escolar</title>
        <script type="text/javascript">
            function confirmarExclusao(id, nome) {
                if (confirm('Deseja realmente desativar o usuário "' + nome + '" ?')) {
                    location.href = 'gerenciar_usuario.do?acao=excluir&idusuario=' + id;
                }
            }
        </script>    
    </head>
    <body>
         <%@include file="menu.jsp" %>
         
        <div class="row  justify-content-center" id="listagem">
       
            <div class="w-100">
                 <div class="" id="btn_cadastrar"> <a href="form_perfil.jsp" class="" >Novo Usuário</a></div>
             </div>
            <table class="table table-hover table-striped table-bordered display" id="listaUsuario">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Login</th>
                        <th>Status</th>
                        <th>Perfil</th>
                        <th>Opções</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Login</th>
                        <th>Status</th>
                        <th>Perfil</th>
                        <th>Opções</th>
                    </tr>
                </tfoot>

                <jsp:useBean class="DAO.UsuarioDAO" id="uDAO"/>
                <tbody>
                    <c:forEach var="u" items="${uDAO.lista}">
                        <tr>
                            <td>${u.idusuario}</td>
                            <td>${u.nome}</td>
                            <td>${u.login}</td>

                            <td>
                                <c:if test="${u.status==1}">Ativo</c:if>
                                <c:if test="${u.status==2}">Inativo</c:if>
                                </td>
                                <td>${u.perfil}</td>
                            <td>
                                <a class="btn btn-primary" href="gerenciar_usuario.do?acao=alterar&idusuario=${u.idusuario}">
                                    <i class="glyphicon glyphicon-pencil"></i>
                                </a>
                                <button class="btn btn-danger" onclick="confirmarExclusao(${u.idusuario}, '${u.nome}')">
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
                                        $("#listaUsuario").dataTable({
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

