<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <link rel="stylesheet" type="text/css" href="assets/css/estilo_geral.css">
        <script type="text/javascript">document.documentElement.classList.add("js");</script>
        <!-- Tipografia -->
        <link href="https://fonts.googleapis.com/css?family=Bubblegum+Sans|Pontano+Sans|Port+Lligat+Sans&display=swap" rel="stylesheet">
        <link rel="shortcut icon" href="assets/img/logo/logo_menu.png"/>
        <link rel="stylesheet" type="text/css" href="estilo/menu.css"/>
    </head>
    <body>
        <div class="container">
            <header class="" >
                <div class="">
                    <div class="logo">Láurea<img src="assets/img/logo/logo_menu.png"></div> 
                    <nav>
                        <ul>
                            <li>
                                <div class="">
                                    <div class="pull-right">Bem vindo, 
                                        <c:if test="${ulogado!=null}">${ulogado.nome}</c:if>
                                        <a href="gerenciar_login.do">Sair<img src="https://image.flaticon.com/icons/svg/126/126467.svg" width="20"></a>
                                    </div>
                                </div>
                            </li>       
                        </ul>
                    </nav>
                </div>
            </header>
            <div class="container">
                <h3>Novo Contrato</h3><br/>
                <form action="gerenciar_contrato.do" method="POST">
                    <input type="hidden" name="idcontrato" id="idcontrato" value="${contrato.idcontrato}"/>
                    <div class ="row">
                        <div class ="form-group-sm-8">
                            <h4> Informações do aluno </h4>
                        </div>
                    </div>
                    <br/>
                    <div class="row">
                        <div class="form-group col-sm-8">
                            <label for="datacontrato"> Data de Nascimento  </label>
                            <input type="date" class="form-control" id="datacontrato"
                                   name="datacontrato" required="" maxlength="45"
                                   value="${contrato.aluno.datanasc}"/>
                        </div>    
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-8">
                            <label for="escola"> Nome do aluno </label>
                            <input type="text" class="form-control" id="nomealuno"
                                   name="nomealuno" required="" maxlength="45"
                                   value="${contrato.aluno.responsavel}"/>
                        </div>    
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-8">
                            <label for="escola"> Nome da Instituição Escolar </label>
                            <input type="text" class="form-control" id="escola"
                                   name="escola" required="" maxlength="45"
                                   value="${contrato.escola}"/>
                        </div>    
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-8">
                            <label for="escola"> Formação Acadêmica </label>
                            <br/>
                            <input type="radio" class="check-ensino" id="ensino" 
                                   name="ensino" required="" value="${contrato.serie}"/> Alfabetização  
                            <input type="radio" class="check-ensino" id="ensino" 
                                   name="ensino" required="" value="${contrato.serie}"/> Ensino Fundamental
                            <input type="radio" class="check-ensino" id="ensino" 
                                   name="escola" required="" value="${contrato.serie}"/> Ensino médio
                            <br/>
                            <input type="radio" class="check-ensino" id="escola" 
                                   name="escola" required="" value="${contrato.serie}"/> Ensino superior
                            <input type="radio" class="check-ensino" id="escola" 
                                   name="escola" required="" value="${contrato.serie}"/> Ensino especifico
                        </div>    
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-8">
                            <label for="escola"> Nome do responsável </label>
                            <input type="text" class="form-control" id="escola"
                                   name="escola" required="" maxlength="45"
                                   value="${contrato.responsavel}"/>
                        </div>    
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-8">
                            <label for="telefone"> Telefone</label>
                            <input type="text" class="form-control" id="tell"
                                   name="tell" required="" maxlength="45"
                                   value="${contrato.serie}"/>
                        </div>    
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-8">
                            <label for="celular"> Celular </label>
                            <input type="text" class="form-control" id="cell"
                                   name="cell" required="" maxlength="45"
                                   value="${contrato.serie}"/>
                        </div>    
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-8">
                            <label for="cpf"> CPF </label>
                            <input type="text" class="form-control" id="cpf"
                                   name="cpf" required="" maxlength="45"
                                   value="${contrato.serie}"/>
                        </div>    
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-8">
                            <label for="rg"> RG </label>
                            <input type="text" class="form-control" id="rg"
                                   name="rg" required="" maxlength="45"
                                   value="${contrato.serie}"/>
                        </div>    
                    </div>
                    <br/>
                    <div class ="row">
                        <div class ="form-group-sm-8">
                            <h4> Informações do contrato </h4>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-8">
                            <label for="datainiciocontrato"> Data </label>
                            <input type="date" class="form-control" id="datainiciocontrato"
                                   name="datainiciocontrato" required="" maxlength="45"
                                   value="${contrato.datacontrato}"/>
                        </div>    
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-8">
                            <label for="precototal"> Preço Total </label>
                            <input type="text" class="form-control" id="precototal"
                                   name="precototal" required="" maxlength="45"
                                   value="${contrato.preco}"/>
                        </div>    
                    </div>    
                    <div class="row">
                        <div class="form-group col-sm-8">
                            <label for="parcela"> Número de Parcelas </label>
                            <input type="text" class="form-control" id="parcela"
                                   name="parcela" required="" maxlength="45"
                                   value="${contrato.parcela}"/>
                        </div>    
                    </div>
                    <div class="row">
                        <div class="form-group col-sm-8">
                            <label for="formapagamento"> Forma de Pagamento </label>
                            <select class="form-control" id="formapagamento" name="formapagamento" required="" maxlength="45">
                                <option value = "0"> Selecione a opção</option> 
                                <option value = "1"> Dinheiro</option>
                                <option value = "2"> Cartão(VISA ou MASTERCARD)</option>   
                            </select>                     
                        </div>    
                    </div>

                    <br/>  
                    <div class="row">
                        <button class="btn btn-success">Gravar</button>
                        <a href="listar_contrato.jsp" class="btn btn-warning">Voltar</a>    
                    </div>    
                </form>    
            </div>
    </body>
</html>
