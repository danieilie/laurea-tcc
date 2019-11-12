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
        <title>Vincular Disciplinas</title>
        <script type="text/javascript">
            function confirmarExclusao(iddisciplina, idprofessor, nome) {
                if (confirm('Deseja realmente desvincular o Professor "' + nome + '" ?')) {
                    location.href = 'gerenciar_professor_disciplina.do?acao=excluir&iddisciplina=' + iddisciplina + '&idprofessor=' + idprofessor;
                }
            }
        </script>    
    </head>
    <body class="body">
        <%@include file="menu.jsp" %>

        <div class="div_formulario">

            <form action="gerenciar_professor_disciplina.do" method="POST" class="form">
                <div class="form-group ">
                    <h2 class="titulo">Vincular disciplina ao professor</h2>

                </div>
                <input type="hidden" name="idprofessor" id="idprofessor" value="${professorv.idprofessor}"/>
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="professor">Professor: ${professorv.professor}</label>                        
                    </div>    
                </div>    
                <div class="form-group">
                    <select name="iddisciplina" class="form-control" required="">
                        <option value="">Selecione a disciplina</option>
                        <c:forEach var="d" items="${professorv.disNaoVinculada}">
                            <option value="${d.iddisciplina}">${d.materia}</option>
                        </c:forEach>                            
                    </select>                      

                </div>    
                <div class="form-group">
                    <button class="btn btn-primary">Gravar</button>
                    <a href="listar_professor.jsp" class="btn btn-outline-dark">Voltar</a>    
                </div>    
            </form>    

        </div>
        <hr>
        <div class="row  justify-content-center" id="listagem">
            <div class="table-responsive">
                <table class="table table-hover table-sm table-striped" id="listaDisciplina">
                    <thead>
                        <tr>
                            <th style="text-align: center;">ID</th>
                            <th>Professor</th>
                            <th>Disciplina</th>
                            <th style="text-align: center;">Desvicular</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th style="text-align: center;">ID</th>
                            <th>Professor</th>
                            <th>Disciplina</th>
                            <th style="text-align: center;">Desvicular</th>
                        </tr>
                    </tfoot>
                    <tbody>
                        <c:forEach var="d" items="${professorv.disciplina}">
                            <tr>
                                <td style="text-align: center;">${d.iddisciplina}</td>
                                <td>${d.nome}</td>
                                <td>${d.materia}</td>                            
                                <td style="text-align: center;">
                                    <button class="icone_lista deletar" onclick="confirmarExclusao(${d.iddisciplina},${professorv.idprofessor}, '${d.materia}')">
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
                                            $("#listaProfessorDisciplina").dataTable({
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
