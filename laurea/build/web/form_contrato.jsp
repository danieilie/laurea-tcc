<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <title> Láurea </title>
        <meta charset="utf-8"/>
        <meta name="viewport" content="width=device-width,initial-scale=1,shrink-to-fit=no">
        <link rel="stylesheet" type="text/css" href="assets/css/estilo_form.css">
        <link rel="stylesheet" href="datatables/jquery.dataTables.min.css"/>
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
        <link rel="shortcut icon" href="assets/img/logo/logo_menu.png"/>  
    </head>
    <body class="body">

        <%@include file="menu.jsp" %>

        <div class="div_formulario">
            <form action="gerenciar_contrato.do" method="POST" class="form">
                <div class="form-group ">
                    <h2 class="titulo">Novo Contrato</h2>

                </div>
                <input type="hidden" name="idcontrato" id="idcontrato" value="${contrato.idcontrato}"/>

                <div class="row">

                    <div class="col-md-6 mb-3">
                        <label for="datacontrato"> Data do Contrato  </label>
                        <input type="date" class="form-control" id="datacontrato"
                               name="datacontrato" required="" maxlength="45"
                               value="${contrato.aluno.datanasc}"/>
                    </div>

                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label for="escola"> Nome da Instituição Escolar </label>
                        <input type="text" class="form-control" id="escola"
                               name="escola" required="" maxlength="45"
                               value="${contrato.escola}"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <label> Nível de Escolaridade</label>
                        <select name="materia" required="" class="form-control">
                            <option class="" value="" selected="">Selecione</option>
                            <option class="" value="Alfabetizacao">Alfabetização</option>
                            <option class="" value="Ensino Fundamental">Ensino Fundamental</option>
                            <option class="" value="Ensino Medio">Ensino médio</option>
                            <option class="" value="Ensino Superior">Ensino superior</option>
                            <option class="" value="Ensino Especifico">Ensino especifico</option>                                                        
                        </select>   
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-3 mb-3">
                        <label for="precototal"> Preço Total </label>
                        <input type="text" class="form-control" id="precototal"
                               name="precototal" required="" maxlength="45"
                               value="${contrato.preco}"/>
                    </div>    
                    <div class="col-md-3 mb-3">
                        <label for="parcela"> Número de Parcelas </label>
                        <input type="text" class="form-control" id="parcela"
                               name="parcela" required="" maxlength="45"
                               value="${contrato.parcela}"/>
                    </div>    
                </div>
                <div class="row">
                    <div class="col-md-3 mb-3">
                        <button class="btn btn-primary">Gravar</button>
                        <a href="listar_contrato.jsp" class="btn btn-outline-dark">Voltar</a>    
                    </div>  
                </div>
            </form>  
        </div>
    </div>
</body>
</html>
