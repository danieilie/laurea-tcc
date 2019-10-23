
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, 
              user-scalable=no" name="viewport"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css"/>
        <title>Láurea Reforço Escolar</title>
    </head>
    <body>
        <div class="container">
            <%@include file="banner.jsp" %>
            <%@include file="menu.jsp" %>
            <h3>Nova Turma</h3>

            <form action="gerenciar_turma.do" method="POST">

                <input type="hidden" name="idturma" id="idturma" value="${turma.idturma}"/>

                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="datahora"> Data e Hora </label>
                        <input type="datetime-local" class="form-control" id="datahora"
                               name="datahora" required="" maxlength="45"
                               value="${turma.datahora}"/>
                    </div>    
                </div> 

                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="diasemana">Dia da semana</label>
                        <select name="diasemana" required="" class="form-control">
                            <c:if test="${turma.diasemana==null}">
                                <option value="0">Selecine a opção</option>
                                <option value="segunda"> segunda </option>
                                <option value="terca"> terca </option>
                                <option value="quarta"> quarta </option>
                                <option value="quinta"> quinta </option>
                                <option value="sexta"> sexta </option>
                                <option value="sabado"> sabado </option>
                            </c:if>
                            <c:if test="${turma.diasemana=='segunda'}">
                                <option value="segunda" selected="" > segunda </option>
                                <option value="terca"> terca </option>
                                <option value="quarta"> quarta </option>
                                <option value="quinta"> quinta </option>
                                <option value="sexta"> sexta </option>
                                <option value="sabado"> sabado </option>
                            </c:if>
                            <c:if test="${turma.diasemana=='terca'}">
                                <option value="segunda"> segunda </option>
                                <option value="terca" selected="" > terca </option>
                                <option value="quarta"> quarta </option>
                                <option value="quinta"> quinta </option>
                                <option value="sexta"> sexta </option>
                                <option value="sabado"> sabado </option>
                            </c:if>
                            <c:if test="${turma.diasemana=='quarta'}">
                                <option value="segunda"> segunda </option>
                                <option value="terca"> terca </option>
                                <option value="quarta" selected="" > quarta </option>
                                <option value="quinta"> quinta </option>
                                <option value="sexta"> sexta </option>
                                <option value="sabado"> sabado </option>
                            </c:if>
                            <c:if test="${turma.diasemana=='quinta'}">
                                <option value="segunda"> segunda </option>
                                <option value="terca"> terca </option>
                                <option value="quarta"> quarta </option>
                                <option value="quinta" selected="" > quinta </option>
                                <option value="sexta"> sexta </option>
                                <option value="sabado"> sabado </option>
                            </c:if>
                            <c:if test="${turma.diasemana=='sexta'}">
                                <option value="segunda"> segunda </option>
                                <option value="terca"> terca </option>
                                <option value="quarta"> quarta </option>
                                <option value="quinta"> quinta </option>
                                <option value="sexta" selected="" > sexta </option>
                                <option value="sabado"> sabado </option>
                            </c:if>
                            <c:if test="${turma.diasemana=='sabado'}">
                                <option value="segunda"> segunda </option>
                                <option value="terca"> terca </option>
                                <option value="quarta"> quarta </option>
                                <option value="quinta"> quinta </option>
                                <option value="sexta"> sexta </option>
                                <option value="sabado" selected="" > sabado </option>
                            </c:if>

                        </select>    
                    </div>    
                </div> 

                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="professor"> Professor </label>
                        <select name="idprofessor" required="" class="form-control">
                            <option value="">Selecine a opção</option>
                            <jsp:useBean class="model.ProfessorDAO" id="prDAO"/>
                            <c:forEach var="pr" items="${prDAO.lista}">
                                <option value="${pr.idprofessor}"
                                        <c:if test="${pr.idprofessor==turma.professor.idprofessor}">
                                            selected=""
                                        </c:if> 
                                        >
                                    ${pr.nome}</option>
                                </c:forEach>
                        </select>    
                    </div>    
                </div>

                <div class="row">
                    <button class="btn btn-success">Gravar</button>
                    <a href="listar_turma.jsp" class="btn btn-warning">
                        Voltar
                    </a>    
                </div>    
            </form>    

        </div>

    </body>
</html>
