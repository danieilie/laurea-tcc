<%@page import="DAO.ContratoDAO"%>
<%@page import="model.Contrato"%>
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
        <title>Lista Contrato</title>
        <script type="text/javascript">
            function confirmarExclusao(id, nome) {
                if (confirm('Deseja realmente excluir o contrato  ' + nome + ' ?')) {
                    location.href = 'gerenciar_contrato.do?acao=excluir&idcontrato=' + id;
                }
            }
        </script>
        <script type="text/javascript">
            function redirect(id, nome) {
                if (confirm('Deseja realmente ver as mensalidades ' + nome + ' ?')) {
                    location.href = 'gerenciar_mensalidade.do?acao=mensalidaVinculadaPorContrato&idcontrato=' + id;
                }
            }
        </script>

    </head>
    <body class="body">
        <%@include file="menu.jsp" %>
        <div class="row">
            <a href="form_contrato.jsp" class="" > <div class="float-left" id="btn_cadastrar"> Cadastrar Contrato</div></a>
        </div>

        <div class="row  justify-content-center" id="listagem">
            <div class="table-responsive">
                <table class="table table-hover table-sm table-striped" id ="listaContrato">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Aluno</th>
                            <th>Escola</th>
                            <th>Responsável</th>
                            <th>Data</th>
                            <th>Valor Total</th>
                            <th>Qtd. Parcelas</th>
                            <th>Status</th>
                            <th>Opções</th>
                            <th>Excluir</th>
                        </tr>
                    </thead>
                    <tfoot>
                        <tr>
                            <th>ID</th>
                            <th>Aluno</th>
                            <th>Escola</th>
                            <th>Responsável</th>
                            <th>Data</th>
                            <th>Valor Total</th>
                            <th>Qtd. Parcelas</th>
                            <th>Status</th>
                            <th>Opções</th>
                            <th>Excluir</th>
                        </tr>
                    </tfoot>

                    <jsp:useBean class="DAO.ContratoDAO" id="cDAO" />
                    <tbody>
                        <c:forEach var="c" items="${cDAO.lista}">
                            <c:if test="${c.aluno.responsavel.usuario.idusuario==ulogado.idusuario || c.aluno.usuario.idusuario==ulogado.idusuario || ulogado.perfil.idperfil==1 || ulogado.perfil.idperfil==2}">
                                <tr>
                                    <td>${c.idcontrato}</td>
                                    <td>${c.aluno.nome}</td>
                                    <td>${c.escola}</td>
                                    <td>${c.aluno.responsavel.nome}</td>
                                    <td>${c.datacontrato}</td>
                                    <td>${c.preco}</td>
                                    <td>${c.parcela}</td>
                                    <td>
                                        <c:if test="${c.status == 1}" > Pendente </c:if>
                                        <c:if test="${c.status == 0}" > Pago </c:if>
                                        </td>

                                        <td>
                                            <a class="btn btn-primary" href="listar_mensalidade.jsp">
                                                <i class="glyphicon glyphicon-eye-open"></i>
                                            </a>
                                        </td>
                                        <td>
                                            <button class="deletar icone_lista" onclick="confirmarExclusao(${p.idcontrato}, '${p.nome}')" >
                                            <img src="assets/img/lista/deletar.png">
                                        </button>    
                                    </td>
                                </tr>
                            </c:if>  
                        </c:forEach>                    
                    </tbody>    
                </table>    
            </div>

            <script type="text/javascript" src="datatables/jquery.js"></script>
            <script type="text/javascript" src="datatables/jquery.dataTables.min.js" ></script>
            <script type="text/javascript" >

                                                $(document).ready(function () {
                                                    $("#listaContrato").dataTable({
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
