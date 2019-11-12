<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css"/>
        <title>Láurea Reforço Escolar</title>
    </head>
    <body>
        <div class="container">
            <%@include file="banner.jsp" %>
            <%@include file="menu.jsp" %>
            <h3>Novo Responsável</h3>

            <form action="gerenciar_responsavel.do" method="POST">
                <input type="hidden" name="idresponsavel" id="idresponsavel" value="${responsavel.idresponsavel}"/>
                <<div class="form-group">
                    <label for="nome">Nome *</label>
                    <input type="text" class="form-control" id="nome" name="nome" placeholder="Nome" required="" maxlength="45" value="${responsavel.nome}" />
                </div>
                
                <div class="form-group">
                    <label for="nome">CPF *</label>
                    <input type="text" class="form-control" id="cpf" name="cpf" placeholder="000.000.000-00" required="" maxlength="14" value="${responsavel.cpf}" />
                </div>
                
                <div class="form-group">
                    <label for="nome">RG *</label>
                    <input type="text" class="form-control" id="rg" name="rg" placeholder="RG" required="" maxlength="13" value="${responsavel.rg}" />
                </div> 

                <div class="form-group">
                    <label for="status">Status *</label>
                    <select name="status" required="" class="form-control">
                        <c:if test="${responsavel.status==null}">
                            <option value="">Selecine a opção</option>
                            <option value="1">Ativo</option>
                            <option value="2">Inativo</option>
                        </c:if>
                        <c:if test="${responsavel.status==1}">
                            <option value="1" selected="">Ativo</option>
                            <option value="2">Inativo</option>
                        </c:if>
                        <c:if test="${responsavel.status==2}">
                            <option value="1">Ativo</option>
                            <option value="2" selected="">Inativo</option>
                        </c:if>
                    </select>    
                </div> 

                <div class="row">
                    <button class="btn btn-success">Gravar</button>
                    <a href="listar_responsavel.jsp" class="btn btn-warning">Voltar</a>    
                </div>    
            </form>    
        </div>
    </body>
</html>
