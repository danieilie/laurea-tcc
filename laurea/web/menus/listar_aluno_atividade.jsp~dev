<%-- 
    Document   : index
    Created on : 08/08/2019, 10:22:26
    Author     : Administrador
--%>

<%@page import="model.AlunoAtividadeDAO"%>
<%@page import="model.AlunoAtividade"%>
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
            
            function confirmarExclusao(idaluno, idatividade , nomealuno, nomeatividade){
                if(confirm('Deseja realmente desvincular o(a) aluno(a) '+nomealuno+' da atividade '+nomeatividade+'?')){
                    location.href='gerenciar_aluno_atividade.do?' +
                    'acao=desvincular&idaluno='+idaluno+'&idatividade='+idatividade;
                }                
            }            
        </script>

    </head>
    <body>
        <div class="container">
            <%@include file="banner.jsp" %>
            <%@include file="menu.jsp" %>
            <h1>Lista de AlunoAtividades</h1>

            <a href="form_aluno_atividade.jsp" class="btn btn-primary">
                Novo Cadastro
            </a>
            <table class="table table-hover table-striped table-bordered display" 
                   id ="listaAlunoAtividade" >

                <thead>
                    <tr>
                        <th>Nome do Aluno</th>
                        <th>Atividade</th>
                        <th>Opções</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>Nome do Aluno</th>
                        <th>Atividade</th>
                        <th>Opções</th>
                    </tr>
                </tfoot>

                <jsp:useBean class="model.AlunoAtividadeDAO" id="aatiDAO" />

                <tbody>
                    <c:forEach var="aati" items="${aatiDAO.lista}">
                        <tr>
                            <td>${aati.aluno.nome}</td>
                            <td>${aati.atividade.nome}</td>
                            <td>
                                <button class="btn btn-danger" onclick="confirmarExclusao(${aati.aluno.idaluno}, ${aati.atividade.idatividade}, '${aati.aluno.nome}', '${aati.atividade.nome}')" >
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
                
            $(document).ready(function(){
                $("#listaAlunoAtividade").dataTable({
                    "bJQueryUI":  true,
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
                            "sFirst" : "Primeiro",
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
