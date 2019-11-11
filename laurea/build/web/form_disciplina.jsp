<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport"/>
        <link rel="stylesheet" type="text/css" href="assets/css/estilo_form.css">
        <link rel="stylesheet" href="datatables/jquery.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
        <link rel="shortcut icon" href="assets/img/logo/logo_menu.png"/>  
        <title>Cadastrar Disciplina</title>
    </head>
   <body class="body">
        <%@include file="menu.jsp" %>
        
        <div class="div_formulario">
            <form action="gerenciar_disciplina.do" method="POST" class="form">
                <div class="form-group ">
                     <h2 class="titulo">Novo Disciplina</h2>
                    
                </div>
                <input type="hidden" name="iddisciplina" id="iddisciplina" value="${disciplina.iddisciplina}"/>
                
               <div class="form-group">
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
                <div class="form-group">
                    <button class="btn btn-primary">Gravar</button>
                    <a href="listar_disciplina.jsp" class="btn btn-outline-dark">Voltar</a> 
                </div>   
            </form>    
        </div>
    </body>
</html>
