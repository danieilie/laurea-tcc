<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
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
    </head>
    <body>
        <%
            String mensagem = (String)request.getSession().getAttribute("mensagem");
            if(mensagem != null){
              request.getSession().removeAttribute("mensagem");
        %>
        <div class="alert alert-info"><%=mensagem%></div>
        <%
           }  //só pra fechar a chave do if
        %>

        <header class="container-fluid m-p" data-anime="100">
            <div class="container">
                <div class="logo" data-anime="200">Láurea<img src="./assets/img/logo/logo_menu.png"></div>
                <nav>
                    <ul data-anime="200">
                        <li><a href="#produtos">Produtos</a></li>
                        <li><a href="#materias">Matérias</a></li>
                        <li><a href="#sobre">Sobre</a></li>
                        <li><a href="#contato">Contato</a></li>
                        <li><a href="#depoimentos">Depoimentos</a></li>
                        <li><div onclick="toggleSidebar()"><h5>Entrar</h5></div></li>
                    </ul>
                </nav>
            </div>
        </header>
        <div id="sidebar">
            <button class="close" onclick="toggleSidebar()">
                <span aria-hidden="true">&times;</span>
            </button>
            <img src="assets/img/logo/logo_form.png" style="margin-top: 30px;">
            <form  action="gerenciar_login.do" method="POST" class="login">
                <div class="form-group">
                    <label for="login">Login:</label>
                    <input type="text" class="form-control" id="login" name="login" required="" maxlength="45" value="${login.login}" autofocus=""/>
                </div>
                <div class="form-group">
                    <label for="senha">Senha:</label>
                    <input type="password" class="form-control" id="senha" name="senha" required="" maxlength="45" value="${login.senha}"/>
                </div>
                <div class="form-group">
                    <button class="btn btn-primary">Entrar</button> 
                </div>
            </form>
        </div>
        <section id="inicio" class="container-fluid conteudo_inicio m-p" data-anime="300">
            <div class="row justify-content-center m-p">
                <img src="assets/img/logo/logo_inicio.png" style="padding: 30px;">
            </div>
            <h1>qualidade em ensinar</h1>

            <p>Muitas pessoas ainda associam alto desempenho nos estudos ao esforço contínuo 
                de longas horas de foco, acompanhado da pressão por notas altas. 
                Já a <span>Láurea</span> comprova que o caminho contrário pode 
                ser ainda mais eficiente.
            </p>

        </section>
        <section id="produtos" class="container-fluid m-p" data-anime="500">
            <div class="container">
                <div class="tag">PRODUTOS</div> 
            </div>
            <div>
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card_produto item1 ">
                                <h5>REFORÇO</h5>
                                <h2>ACOMPANHAMENTO  ESCOLAR</h2>
                                <p>Planejamento é tudo!
                                    Estude regularmente com quem entende, temos planos que cabe no seu bolso.
                                </p>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card_produto item2 ">
                                <h5>LIBERDADE</h5>
                                <h2>AGENDAMENTO DE AULA AVULSA</h2>
                                <p>Trazemos praticidade, faça seu horário já! 
                                    Aqui você pode estudar quando quizer sem perder a qualidade. 
                                    Estude no seu ritmo.
                                </p>
                            </div>
                        </div>
                        <div class="col">
                            <div class="card_produto item3 ">
                                <h5>ONLINE</h5>
                                <h2>MATERIAL DE ESTUDO ONLINE</h2>
                                <p>Evolua mais rápido, acesse de onde estiver.
                                    Pratique quando quiser, disponibilizamos atividades online.
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section id="materias" class="container-fluid m-p" data-anime="600">
            <div class="container">
                <div class="tag">MATÉRIAS</div> 
            </div>
            <div class="row container item">
                <div class="col">
                    <div class="widget">
                        <div class="widget_head">  
                            <img src="assets/img/materias/portugues.png"/> 
                        </div>
                        <div class="widget_body">
                            <h2>português</h2>
                            <hr>
                            <p>A língua portuguesa é muito mais do que gravar regras e macetes... 
                                Se o domínio da norma culta da Língua Portuguesa é importante para o sucesso pessoal e profissional.</p>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="widget">
                        <div class="widget_head"><img src="assets/img/materias/matematica.png"/></div>
                        <div class="widget_body">
                            <h2>MATEMÁTICA</h2>
                            <hr>
                            <p>Porque matemática prepara o homem para a vida como nenhuma outra disciplina pode fazer. Ela é a ciência que fornece o melhor instrumental para qualquer profissional ser bem sucedido.</p>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="widget">
                        <div class="widget_head"><img src="assets/img/materias/fisica.png"/></div>
                        <div class="widget_body">
                            <h2>FÍSICA</h2>
                            <hr>
                            <p>O objetivo da Física consiste em descobrir as leis gerais da Natureza e esclarecer, com base nelas, processos concretos.</p>
                        </div>
                    </div>
                </div>

            </div>
            <div class="row container item">
                <div class="col">
                    <div class="widget">
                        <div class="widget_head"><img src="assets/img/materias/quimica.png"/></div>
                        <div class="widget_body">
                            <h2>QUÍMICA</h2>
                            <hr>
                            <p>Química é a ciência que estuda a estrutura das substâncias, a composição e as propriedades das diferentes matérias, suas transformações e variações de energia.</p>
                        </div>
                    </div>
                </div>    
                <div class="col">
                    <div class="widget">
                        <div class="widget_head"><img src="assets/img/materias/idiomas.png"/></div>
                        <div class="widget_body">
                            <h2>idiomas</h2>
                            <hr>
                            <p>No mundo globalizado em que vivemos aprender outro idioma é algo essencial para nossa carreira profissional e para a comunicação com as demais pessoas, pois isso é um grande diferencial.</p>
                        </div>
                    </div>
                </div>
                <div class="col">
                    <div class="widget">
                        <div class="widget_head"><img src="assets/img/materias/rac_logico.png"/></div>
                        <div class="widget_body">
                            <h2>rac. lógico</h2>
                            <hr>
                            <p>É pelo processo de pensamento ou do raciocínio lógico que ocorre o desenvolvimento do método matemático, bem como, as ciências como um todo.</p>
                        </div>
                    </div>
                </div>
            </div>


        </section>
        <section id="sobre" class="container-fluid m-p" data-anime="600">
            <div class="container">
                <div class="tag">SOBRE</div> 
            </div>
            <div class="sobre_titulo">
                <h1>A Láurea</h1>
            </div>
            <div class="sobre_texto container">
                <p>Fundada em fevereiro de 2018, nossa instituição foi totalmente idealizada com o intuito de levar conhecimento para as pessoas e trabalhar cada vez mais buscando ensinar de uma maneira totalmente prazerosa para seus alunos. 
                    Seguimos atendendo os alunos com horários totalmente flexíveis e estamos localizados na Ceilândia-Sul. Entre em contato conosco, estamos te aguardando de braços abertos!
                </p>
            </div>
            <div class="container">
                <div class="row">
                    <div class="col"><img src="assets/img/sobre/criancas.png" alt="Criancas"></div>
                    <div class="col">
                        <h1>Atuação</h1>
                        <ul>
                            <li>&rarr; Já atendemos mais de mil alunos</li>
                            <li>&rarr; 10 anos de atuação</li>
                            <li>&rarr; Atendemos alunos de diversas escolas</li>
                        </ul>
                    </div>
                </div>
            </div>
        </section>
        <section id="contato" class="container-fluid m-p" data-anime="600">
            <div class="container">
                <div class="tag ">CONTATO</div> 
                <div class="row align-items-center">
                    <div class="col">
                        <h4>De segunda a sexta, das 08 as 20h</h4>
                        <ul>
                            <li><img src="assets/img/contato/telefone.png"/> (061) 3333-9999</li>
                            <li><a href="https://api.whatsapp.com/send?1=pt_BR&phone=5561993113336" target="_blank"><img src="assets/img/footer/whatsapp.png" alt="whatsapp"></a> (061) 99311-3336</li>
                            <li><img src="assets/img/contato/email.png"/> profpaulo@laurea.com</li>
                            <li><img src="assets/img/contato/localizacao.png"/> QNN 20 conjunto “C” casa 12 Ceilândia-Sul</li>
                        </ul>
                    </div>
                    <div class="col">
                        <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3838.522564656659!2d-48.115546249230306!3d-15.829109077973683!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x935bccfb7f941bab%3A0xd51b55e404de58af!2sSt.%20N%20QNN%2020%20-%20Ceil%C3%A2ndia%2C%20Bras%C3%ADlia%20-%20DF!5e0!3m2!1spt-BR!2sbr!4v1573387495813!5m2!1spt-BR!2sbr" width="600" height="450" frameborder="0" style="border:0;" allowfullscreen=""></iframe>
                    </div>
                </div>

            </div>

        </section>
        <section id="depoimentos" class="container-fluid m-p" data-anime="600">
            <div class="container">
                 <div class="tag">DEPOIMENTOS</div> 
                <div class="row">
                    <div class="col">
                        <div class="card_depoimento"> 
                                <img src="assets/img/depoimentos/julia.png" class="float-left">
                                <h4 class="float-left">Júlia Vaz</h4>
                                <div class="float-left card_depoimento_text">&ldquo;Totalmente satisfeita! Nunca pensei que pagando um valor tão acessível eu aprenderia tanto em um período de tempo tão curto.&rdquo;</div>
                        </div>
                    </div>
                    <div class="col">
                       <div class="card_depoimento">                         
                           <img src="assets/img/depoimentos/daniele.png" class="float-left">
                                <h4 class="float-left">Daniele Silva</h4>
                                <div class="float-left card_depoimento_text">&ldquo;Paulo Henrique sem dúvida é um professor prestativo muito atencioso suporte rápido.&rdquo;</div>
                        </div>
                    </div>
                    <div class="col">
                         <div class="card_depoimento"> 
                             <img src="assets/img/depoimentos/marcos.png" class="float-left">
                                <h4 class="float-left">Marcos Felipe</h4>
                                 <div class="float-left card_depoimento_text">&ldquo;Estou fazendo o curso e estou adorando a didática simples porém muito completa, é bem explicada passo a passo.&rdquo;</div>
                        </div>
                    </div>
                    
                    
                </div>
            </div>
        </section>
        <footer data-anime="600">
            <div class="footer">
                <div class="container">
                    <div class="logo float-left">Láurea <img src="assets/img/logo/logo_menu.png"></div>
                </div>
                <div class="redes_sociais  float-right">
                    <ul class="float-right">
                        <li><a href="https://www.facebook.com/" target="_blank"><img src="assets/img/footer/facebook.png" alt="Facebook"></a></li>
                        <li><a href="https://www.instagram.com/" target="_blank"><img src="assets/img/footer/instagram.png" alt="Instagram"></a></li>
                        <li><a href="https://twitter.com/" target="_blank"><img src="assets/img/footer/twitter.png" alt="twitter"></a></li>
                        <li><a href="https://api.whatsapp.com/send?1=pt_BR&phone=5561993113336" target="_blank"><img src="assets/img/footer/whatsapp.png" alt="whatsapp"></a></li>
                    </ul>
                </div>
            </div>
        </footer>
        <div class="copy" data-anime="600">
            <div class="container">
                © Copyright  2010-2019. Láurea. Todos os direitos reservados. 
            </div>
        </div>
        <a id="back-to-top" href="#" class="btn back-to-top" role="button"><img src="assets/img/arrow/arrow-up.gif"></a>




        <!-- animações de entrada na página -->
        <script type="text/javascript" src="assets/js/simple-anime.js"></script>

        <!-- Slide deve ser colado em toda pagina de HTML  -->
        <script type="text/javascript" src="assets/js/simple-slide.js"></script>
        

        <!-- Jquery 3.4.1 e bootstrap -->
        <script type="text/javascript" src="assets/js/jquery.js"></script>
        <script type="text/javascript" src="assets/js/bootstrap.bundle.min.js"></script>
        <script type="text/javascript" src="assets/js/script.js"></script>

        <!-- AÇÃO DO FORMULÁRIO DE LOGIN -->
        <script type="text/javascript">
                function toggleSidebar() {
                    document.getElementById("sidebar").classList.toggle('active');
                }
                $(document).ready(function () {
                    $(window).scroll(function () {
                        if ($(this).scrollTop() > 500) {
                            $('#back-to-top').fadeIn();
                        } else {
                            $('#back-to-top').fadeOut();
                        }
                    });
                    
                    // scroll body to 0px on click
                    $('#back-to-top').click(function () {
                        $('body,html').animate({
                            scrollTop: 0
                        }, 400);
                        return false;
                    });
                });
        </script>
    </body>
</html>
