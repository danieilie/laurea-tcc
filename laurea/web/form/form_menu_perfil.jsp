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
        <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="../bootstrap/css/bootstrap-theme.min.css"/>
        <title>Láurea Reforço Escolar</title>  
        <script type="text/javascript">
            function confirmarExclusao(idmenu, idperfil, nome) {
                if (confirm('Deseja realmente desvincular o menu "' + nome + '" ?')) {
                    location.href = 'gerenciar_menu_perfil.do?acao=desvincular&idmenu=' + idmenu + '&idperfil=' + idperfil;
                }
            }
        </script>    
    </head>
    <body>
        <div class="container">
            <%@include file="../banner.jsp" %>
            <%@include file="../menu.jsp" %>
            <h3>Gerenciar Acessos</h3>

            <form action="gerenciar_menu_perfil.do" method="POST">
                <input type="hidden" name="idperfil" id="idperfil" value="${perfilv.idperfil}"/>
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="perfil">Perfil: ${perfilv.perfil}</label>                        
                    </div>    
                </div>    
                <div class="row">
                    <div class="form-group col-sm-8">
                        <select name="idmenu" class="form-control" required="">
                            <option value="">Selecione o menu</option>
                            <c:forEach var="m" items="${perfilv.naoMenus}">
                                <option value="${m.idmenu}">${m.menu}</option>
                            </c:forEach>                            
                        </select>                      
                    </div>    
                </div>    
                <div class="row">
                    <button class="btn btn-success">Gravar</button>
                    <a href="../listar/listar_perfil.jsp" class="btn btn-warning">Voltar</a>    
                </div>    
            </form>    

            <h1>Lista de Menus Vinculados</h1>
            <table class="table table-hover table-striped table-bordered display" id="listaMenu">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Menu</th>
                        <th>Link</th>
                        <th>Desvicular</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Menu</th>
                        <th>Link</th>
                        <th>Desvicular</th>
                    </tr>
                </tfoot>
                <tbody>
                    <c:forEach var="m" items="${perfilv.menus}">
                        <tr>
                            <td>${m.idmenu}</td>
                            <td>${m.menu}</td>
                            <td>${m.link}</td>
                            <td>
                                <button class="btn btn-danger" onclick="confirmarExclusao(${m.idmenu},${perfilv.idperfil}, '${m.menu}')">
                                    <i class="glyphicon glyphicon-trash"></i>
                                </button>    
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>    
        </div>

        <script type="text/javascript" src="../datatables/jquery.js"></script>
        <script type="text/javascript" src="../datatables/jquery.dataTables.min.js"></script>
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
