<%@page import="DAO.AlunoDAO"%>
<%@page import="model.Aluno"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"/>
        <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="../bootstrap/css/bootstrap-theme.min.css"/>
        <link rel="stylesheet" href="../datatables/jquery.dataTables.min.css"/>
        <title>Láurea Reforço Escolar</title>

        <script type="text/javascript">

            function confirmarExclusao(id, nome) {
                if (confirm('Deseja realmente excluir o aluno  ' + nome + ' ?')) {
                    location.href = 'gerenciar_aluno.do?acao=excluir&idaluno=' + id;
                }
            }
        </script>

    </head>
    <body>
        <div class="container">
            <%@include file="../banner.jsp" %>
            <%@include file="../menu.jsp" %>
            <h1>Lista de Alunos</h1>

            <a href="../form/form_aluno.jsp" class="btn btn-primary">Novo Cadastro</a>
            <table class="table table-hover table-striped table-bordered display" id ="listaAluno" >
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Data de Nascimento</th>
                        <th>CPF</th>
                        <th>RG</th>
                        <th>Nome do Responsável</th>
                        <th>Nome de Usuário</th>
                        <th>Opções</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Data de Nascimento</th>
                        <th>CPF</th>
                        <th>RG</th>
                        <th>Nome do Responsável</th>
                        <th>Nome de Usuário</th>
                        <th>Opções</th>
                    </tr>
                </tfoot>

                <jsp:useBean class="DAO.AlunoDAO" id="aDAO" />
                <tbody>
                    <c:forEach var="a" items="${aDAO.lista}">
                        <tr>
                            <td>${a.idaluno}</td>
                            <td>${a.nome}</td>
                            <td>${a.datanasc}</td>
                            <td>${a.cpf}</td>
                            <td>${a.rg}</td>
                            <td>${a.responsavel}</td>
                            <td>${a.usuario}</td>
                            <td>
                                <a class="btn btn-primary" href="gerenciar_aluno.do?acao=alterar&idaluno=${pr.idaluno}">
                                    <i class="glyphicon glyphicon-pencil"></i>
                                </a>
                                <button class="btn btn-danger" onclick="confirmarExclusao(${pr.idaluno}, '${pr.nome}')" >
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
        <script type="text/javascript" >
                                    $(document).ready(function () {
                                        $("#listaAluno").dataTable({
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
