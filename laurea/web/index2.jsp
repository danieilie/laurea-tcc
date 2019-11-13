<%@page import="DAO.UsuarioDAO"%>
<%@page import="model.Usuario"%>
<%@page import="java.util.ArrayList"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="controller.GerenciarLogin"%>


<!DOCTYPE html>
<html>
    <head>
        <title> Láurea </title>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1,shrink-to-fit=no">
        <link rel="stylesheet" type="text/css" href="assets/css/normalize.css">
        <link rel="stylesheet" type="text/css" href="assets/css/reset.css">
        <!-- Bootstrap versão 4.1 -->
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">

        <script type="text/javascript">document.documentElement.classList.add("js");</script>

        <link rel="stylesheet" type="text/css" href="estilo/menu.css"/>
        <link rel="stylesheet" type="text/css" href="assets/css/painel.css"/>
        <link rel="shortcut icon" href="assets/img/logo/logo_menu.png"/>
    </head>
    <body>

        <%@include file="menu.jsp" %>
        <div class="row ">
            <div class="painel_novo col">
                <ul class="list-group painel_novo">
                    <li class="list-group-item ativo">
                        O QUE HA DE NOVO?
                    </li>
                    <li class="list-group-item">
                        <div class="d-flex justify-content-between">
                            <i>Ultimos usuários cadastrados</i>
                            <span class="badge badge-primary badge-pill"> new </span>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="d-flex justify-content-between">
                            Marcos Felipe
                            <small>10.10.2010</small>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="d-flex justify-content-between">
                            Júlia Vaz
                            <small>10.10.2010</small>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="d-flex justify-content-between">
                            Paulo Henrique
                            <small>10.10.2010</small>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="d-flex justify-content-between">
                            Daniele Silva
                            <small>10.10.2010</small>
                        </div>
                    </li>
                </ul>
            </div>

            <div class="painel_status col">
                <ul class="list-group painel_novo">
                    <li class="list-group-item ativo">
                        STATUS DO SISTEMA
                    </li>
                    <li class="list-group-item">
                        <div class="d-flex justify-content-between">
                            <img src="assets/img/status_do_sistema/usuario.png">
                            Usuários
                            <span class="badge badge-primary badge-pill">
                                <jsp:useBean class="DAO.UsuarioDAO" id="uDAO"/>
                                <label>${fn:length(uDAO.lista)}</label>
                            </span>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="d-flex justify-content-between">
                            <img src="assets/img/status_do_sistema/usuario.png">
                            Alunos
                            <span class="badge badge-primary badge-pill">
                                <jsp:useBean class="DAO.AlunoDAO" id="aDAO" />
                                <label>${fn:length(aDAO.lista)}</label>
                            </span>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="d-flex justify-content-between">
                            <img src="assets/img/status_do_sistema/usuario.png">
                            Responsáveis
                            <span class="badge badge-primary badge-pill">
                                <jsp:useBean class="DAO.ResponsavelDAO" id="rDAO" />
                                <label>${fn:length(rDAO.lista)}</label>
                            </span>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="d-flex justify-content-between">
                            <img src="assets/img/status_do_sistema/usuario.png">
                            Professores
                            <span class="badge badge-primary badge-pill">
                                <jsp:useBean class="DAO.ProfessorDAO" id="pDAO" />                                
                                <label>${fn:length(pDAO.lista)}</label>
                            </span>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="d-flex justify-content-between">
                            <img src="assets/img/status_do_sistema/turma.png">
                            Turmas
                            <span class="badge badge-primary badge-pill">                                
                                <label>${fn:length(UsuarioDAO.lista.idusuario)}</label>
                            </span>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="d-flex justify-content-between">
                            <img src="assets/img/status_do_sistema/fatura.png">
                            Faturas
                            <span class="badge badge-primary badge-pill">                                
                                <label>${fn:length(UsuarioDAO.lista.idusuario)}</label>
                            </span>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="d-flex justify-content-between">
                            <img src="assets/img/status_do_sistema/livro.png">
                            Atividades
                            <span class="badge badge-primary badge-pill">                                
                                <label>${fn:length(UsuarioDAO.lista.idusuario)}</label>
                            </span>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="d-flex justify-content-between">
                            <img src="assets/img/status_do_sistema/livro.png">
                            Disciplinas
                            <span class="badge badge-primary badge-pill">                                
                                <label>${fn:length(UsuarioDAO.lista.idusuario)}</label>
                            </span>
                        </div>
                    </li>
                    <li class="list-group-item">
                        <div class="d-flex justify-content-between">
                            <img src="assets/img/status_do_sistema/livro.png">
                            Menus
                            <span class="badge badge-primary badge-pill">
                                <jsp:useBean class="DAO.MenuDAO" id="mDAO"/>
                                <label>${fn:length(mDAO.lista)}</label>
                            </span>
                        </div>
                    </li>
                </ul>
            </div>
        </div>
    </body>
</html>
