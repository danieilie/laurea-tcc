<%@page import="DAO.PerfilDAO"%>
<%@page import="model.Perfil"%>
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
        <title>Listagem Perfil</title>

        <script type="text/javascript">
            function confirmarExclusao(id, nome) {
                if (confirm('Deseja realmente excluir o perfil "' + nome + '" ?')) {
                    location.href = 'gerenciar_perfil.do?acao=excluir&idperfil=' + id;
                }
            }
        </script>    
    </head>
    <body>
         <%@include file="menu.jsp" %>
         
        <div class="row  justify-content-center" id="listagem">
       
            <div class="w-100">
                 <div class="" id="btn_cadastrar"> <a href="form_perfil.jsp" class="" >Novo Cadastro</a></div>
             </div>
   
            
            <table class="table table-hover table-striped table-bordered display " id="listaPerfil">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Perfil</th>
                        <th>Acessos</th>
                        <th>Editar</th>
                        <th>Deletar</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Perfil</th>
                        <th>Acessos</th>
                        <th>Editar</th>
                        <th>Deletar</th>
                        
                    </tr>
                </tfoot>

                <jsp:useBean class="DAO.PerfilDAO" id="pDAO"/>
                <tbody>
                    <c:forEach var="p" items="${pDAO.lista}">
                        <tr>
                            <td>${p.idperfil}</td>
                            <td>${p.perfil}</td>
                            <td>
                                <a class="btn btn-default" href="gerenciar_menu_perfil.do?acao=gerenciar&idperfil=${p.idperfil}">
                                    <i class="glyphicon">Acessos</i>
                                </a>
                               
                            </td>
                             <td>
                                  <a class="btn btn-primary" href="gerenciar_perfil.do?acao=alterar&idperfil=${p.idperfil}">
                                    <i class="glyphicon glyphicon-pencil"></i>
                                </a>
                                
                            </td>
                            <td>
                                <button class="btn btn-danger" onclick="confirmarExclusao(${p.idperfil}, '${p.perfil}')">
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
        <script type="text/javascript">
                                    $(document).ready(function () {
                                        $("#listaPerfil").dataTable({
                                            "bJQueryUI": true,
                                            "oLanguage": {
                                                "sProcessing": "Processando...",
                                                "sLengthMenu": "MOSTRAR _MENU_",
                                                "sZeroRecords": "Não foram encontrados resultados",
                                                "sInfo": "Mostrando de _START_ até _END_ de _TOTAL_ registros",
                                                "sInfoEmpty": "Mostrando de 0 até 0 de 0 registros",
                                                "sInfoFiltered": "",
                                                "sInfoPostFix": "",
                                                "sSearch": "PESQUISAR",
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
