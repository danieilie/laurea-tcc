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
        <link rel="stylesheet" type="text/css" href="assets/css/estilo_listas.css">
        <link rel="stylesheet" href="datatables/jquery.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
        <link href="https://fonts.googleapis.com/css?family=Lato&display=swap" rel="stylesheet">
        <link rel="shortcut icon" href="assets/img/logo/logo_menu.png"/> 
        <title>Listar Alunos</title>
        <script type="text/javascript">
            function confirmarExclusao(id, nome) {
                if (confirm('Deseja realmente excluir o aluno  ' + nome + ' ?')) {
                    location.href = 'gerenciar_aluno.do?acao=excluir&idaluno=' + id;
                }
            }
        </script>

    </head>
     <body class="body">
  <%@include file="menu.jsp" %>
         <div class="row">
            <a href="form_aluno.jsp" class="" > <div class="float-left" id="btn_cadastrar"> Cadastrar Aluno </div></a>
         </div>
        
        <div class="row  justify-content-center" id="listagem">
       
            <div class="table-responsive">
            <table class="table table-hover table-sm table-striped" id="listaAluno">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Data de Nascimento</th>
                        <th>CPF</th>
                        <th>RG</th>
                        <th>Status</th>
                        <th>Nome do Responsável</th>
                        <th>Nome de Usuário</th>
                        <th>Editar</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Nome</th>
                        <th>Data de Nascimento</th>
                        <th>CPF</th>
                        <th>RG</th>
                        <th>Status</th>
                        <th>Nome do Responsável</th>
                        <th>Nome de Usuário</th>
                        <th>Editar</th>
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
                            <td>${a.status}</td>
                            <td>${a.responsavel.nome}</td>
                            <td>${a.usuario.nome}</td>
                            <td>
                                <a class="icone_lista" href="gerenciar_aluno.do?acao=alterar&idaluno=${p.idaluno}">
                                    <img src="assets/img/lista/editar.png">
                            </td>
                        </tr>
                    </c:forEach>                    
                </tbody>    
            </table>    
        </div>
        </div>

        <script type="text/javascript" src="datatables/jquery.js"></script>
        <script type="text/javascript" src="datatables/jquery.dataTables.min.js"></script>
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
