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
        <link rel="stylesheet" type="text/css" href="assets/css/estilo_form.css">
        <link rel="stylesheet" type="text/css" href="assets/css/estilo_listas.css">
        <link rel="stylesheet" href="datatables/jquery.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
        <link rel="shortcut icon" href="assets/img/logo/logo_menu.png"/>  
        <title>Vincular Menus</title>
        <script type="text/javascript">
            function confirmarExclusao(idmenu, idperfil, nome) {
                if (confirm('Deseja realmente desvincular o menu "' + nome + '" ?')) {
                    location.href = 'gerenciar_menu_perfil.do?acao=desvincular&idmenu=' + idmenu + '&idperfil=' + idperfil;
                }
            }
        </script>    
    </head>
     <body class="body">
        <%@include file="menu.jsp" %>
        
        <div class="div_formulario">

            <form action="gerenciar_menu_perfil.do" method="POST" class="form">
                <div class="form-group ">
                     <h2 class="titulo">Vincular menu ao perfil</h2>
              
                </div>
                <input type="hidden" name="idperfil" id="idperfil" value="${perfilv.idperfil}"/>
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="perfil">Perfil: ${perfilv.perfil}</label>                        
                    </div>    
                </div>    
                <div class="form-group">
                        <select name="idmenu" class="form-control" required="">
                            <option value="">Selecione o menu</option>
                            <c:forEach var="m" items="${perfilv.naoMenus}">
                                <option value="${m.idmenu}">${m.menu}</option>
                            </c:forEach>                            
                        </select>                      
                    
                </div>    
                <div class="form-group">
                    <button class="btn btn-primary">Gravar</button>
                    <a href="listar_perfil.jsp" class="btn btn-outline-dark">Voltar</a>    
                </div>    
            </form>    
                    
        </div>
        <hr>
           <div class="row  justify-content-center" id="listagem">
                <div class="table-responsive">
                <table class="table table-hover table-sm table-striped" id="listaMenu">
                <thead>
                    <tr>
                         <th style="text-align: center;">ID</th>
                        <th>Menu</th>
                        <th>Link</th>
                        <th style="text-align: center;">Desvicular</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                         <th style="text-align: center;">ID</th>
                        <th>Menu</th>
                        <th>Link</th>
                        <th style="text-align: center;">Desvicular</th>
                    </tr>
                </tfoot>
                <tbody>
                    <c:forEach var="m" items="${perfilv.menus}">
                        <tr>
                            <td style="text-align: center;">${m.idmenu}</td>
                            <td>${m.menu}</td>
                            <td>${m.link}</td>
                            <td style="text-align: center;">
                                <button class="icone_lista deletar" onclick="confirmarExclusao(${m.idmenu},${perfilv.idperfil}, '${m.menu}')">
                                    <img src="assets/img/lista/desvincular.png">
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
