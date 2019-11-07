<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean class="DAO.TurmaDAO" id="tDAO"/>
<jsp:useBean class="DAO.AlunoDAO" id="aDAO"/>
<%@include file="banner.jsp" %>
<%@include file="menu.jsp" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"/>
        <link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="../bootstrap/css/bootstrap-theme.min.css"/>
        <title>Láurea Reforço Escolar</title>
    </head>
    <body>
        <div class="container">
            <h3>Novo AlunoTurma</h3>
            
            <form action="gerenciar_aluno_turma.do" method="POST">                
                <c:if test="${alunoturma.turma.idturma != null}">
                    <input type="hidden" id="idturma" name="idturma" value="${alunoturma.turma.idturma}"/>
                    <input type="hidden" id="idaluno" name="idaluno" value="${alunoturma.aluno.idaluno}"/>
                    
                    <div class="row">
                        <div class="form-group col-sm-8">
                            <label> Nome da Turma </label><br/>${alunoturma.turma.nome}                        
                        </div>
                    </div> 
                    <br/>
                    <div class="row">
                        <div class="form-group col-sm-8">
                            <label> Nome do Aluno </label><br/>${alunoturma.aluno.nome}                        
                        </div>
                    </div>
                    <br/>
                    <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="frequencia"> Frequência </label>
                        <select name="frequencia" required="" class="form-control">
                            <c:if test="${alunoturma.frequencia=='--'}">
                                <option value="--" selected="" > -- </option>
                                <option value="P"> P </option>
                                <option value="F"> F </option>
                                <option value="FJ"> FJ </option>
                            </c:if>
                            <c:if test="${alunoturma.frequencia=='P'}">
                                <option value="P" selected="" > P </option>
                                <option value="F"> F </option>
                                <option value="FJ"> FJ </option>
                            </c:if>
                            <c:if test="${alunoturma.frequencia=='F'}">
                                <option value="P"> P </option>
                                <option value="F" selected="" > F </option>
                                <option value="FJ"> FJ </option>
                            </c:if>
                            <c:if test="${alunoturma.frequencia=='FJ'}">
                                <option value="P"> P </option>
                                <option value="F"> F </option>
                                <option value="FJ" selected="" > FJ </option>
                            </c:if>                                
                        </select>    
                    </div>    
                    </div>                    
                    <div class="row">
                        <div class="form-group col-sm-8">
                            <label for="data"> Data </label>
                            <input type="date" class="form-control" id="data" name="data" required="" maxlength="45" value="${alunoturma.data}"/>
                        </div>    
                    </div>
                </c:if>
                <c:if test="${alunoturma.turma.idturma == null}">                    
                    <div class="row">
                        <div class="form-group col-sm-8">
                            <label for="idaluno"> Nome do Aluno </label>
                            <select name="idaluno" required="" class="form-control">
                                  <option value="">Selecine a opção</option>
                                  <c:forEach var="a" items="${aDAO.lista}">
                                      <option value="${a.idaluno}" > ${a.nome} </option>
                                  </c:forEach>
                            </select>    
                        </div>    
                    </div>                    
                    <div class="row">
                        <div class="form-group col-sm-8">
                            <label for="idturma"> Nome da Turma </label>
                            <select name="idturma" required="" class="form-control">
                                  <option value=""> Selecine a opção </option>
                                  <c:forEach var="t" items="${tDAO.lista}">
                                      <option value="${t.idturma}"> ${t.nome} </option>
                                  </c:forEach>
                            </select>    
                        </div>    
                    </div>                 
                    <br/>                
                    <input type="hidden" id="data" name="data" value="2020-01-01"/>                    
                    <div class="row">
                            <div class="form-group col-sm-8">
                                <label> Data </label><br/>    01-01-2020
                            </div>
                    </div>
                    <input type="hidden" id="frequencia" name="frequencia" value="--"/>                
                    <div class="row">
                            <div class="form-group col-sm-8">
                                <label> Frequência </label><br/>    --
                            </div>
                    </div>                    
                </c:if>
                <div class="row">
                    <button class="btn btn-success">Gravar</button>
                    <a href="../listar/listar_aluno_turma.jsp" class="btn btn-warning">Voltar</a>    
                </div>    
            </form>                
        </div>        
    </body>
</html>
