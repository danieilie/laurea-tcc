<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"  name="viewport"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css"/>
        <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.min.css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <%
                String mensagem = (String)request.getSession().getAttribute("mensagem");
                if(mensagem != null){
                  request.getSession().removeAttribute("mensagem");
            %>
            <div class="alert alert-info"><%=mensagem%></div>
            <%
               }  //só pra fechar a chave do if
            %>

            <h3>Login</h3>

            <form action="gerenciar_login.do" method="POST">                
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="login">Login</label>
                        <input type="text" class="form-control" id="login" name="login" required="" maxlength="45" value="${login.login}"/>
                    </div>    
                </div>    
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="senha">Senha</label>
                        <input type="password" class="form-control" id="senha" name="senha" required="" maxlength="45" value="${login.senha}"/>
                    </div>    
                </div>    
                <div class="row">
                    <button class="btn btn-success">Entrar</button>                   
                </div>    
            </form>    

        </div>        
    </body>
</html>
