<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
            <%@include file="../banner.jsp" %>
            <%@include file="../menu.jsp" %>
            <h3>Nova Disciplina</h3>

            <form action="gerenciar_disciplina.do" method="POST">
                <input type="hidden" name="iddisciplina" id="iddisciplina" value="${disciplina.iddisciplina}"/>
                
                <div class="row">
                    <div class="form-group col-sm-8">
                        <label for="materia">Matéria</label>
                        <select name="materia" required="" class="form-control">
                            <option class="" value="" selected="">Escolha a Matéria</option>
                            <option class="" value="portugues">Português</option>
                            <option class="" value="quimica">Química</option>
                            <option class="" value="matematica">Matemática</option>
                            <option class="" value="fisica">Fisica</option>
                            <option class="" value="italiano-basico">Italiano Básico</option>                                                        
                            <option class="" value="ingles">Ingles</option>
                            <option class="" value="espanhol">Espanhol</option>
                            <option class="" value="raciocinio-logico">Raciocinio Lógico</option>
                        </select>                                
                    </div>    
                </div>       
                <div class="row">
                    <button class="btn btn-success">Gravar</button>
                    <button><a href="../listar/listar_disciplina.jsp" class="btn btn-warning">Voltar</a></button>    
                </div>   
            </form>    
        </div>
    </body>
</html>
