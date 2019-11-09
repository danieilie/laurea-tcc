<%@page import="DAO.TurmaDAO"%>
<%@page import="model.Turma"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <title>Láurea Reforço Escolar</title>

        <script type="text/javascript">
            function confirmarExclusao(id, nome) {
                if (confirm('Deseja realmente excluir a turma  ' + nome + ' ?')) {
                    location.href = 'gerenciar_turma.do?acao=excluir&idturma=' + id;
                }
            }
        </script>

    </head>
     <body class="body">
       <%@include file="menu.jsp" %>
         <div class="row">
            <a href="form_turma.jsp" class="" > <div class="float-left" id="btn_cadastrar"> Novo Cadastro </div></a>
         </div>
        
        <div class="row  justify-content-center" id="listagem">
       
            <div class="table-responsive">
            <table class="table table-hover table-sm" id="listaTurma">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Data e Hora</th>
                        <th>Dia da Semana</th>
                        <th>Professor</th>
                        <th>Opções</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Data e Hora</th>
                        <th>Dia da Semana</th>
                        <th>Professor</th>
                        <th>Opções</th>
                    </tr>
                </tfoot>

                <jsp:useBean class="DAO.TurmaDAO" id="tDAO" />
                <tbody>
                    <c:forEach var="t" items="${tDAO.lista}">
                        <tr>
                            <td>${t.idturma}</td>
                            <td>${t.nome}</td>
                            <td>${t.professor}</td>
                            <td>
                                <a class="btn btn-primary" href="gerenciar_turma.do?acao=alterar&idturma=${t.idturma}">
                                    <i class="glyphicon glyphicon-pencil"></i>
                                </a>
                                <button class="btn btn-danger" onclick="confirmarExclusao(${t.idturma}, '${t.nome}')" >
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
                                        $("#listaTurma").dataTable({
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
