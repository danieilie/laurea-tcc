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
    <header class="container-fluid m-p" data-anime="100">
            <div class="container ">
                <div class="logo " data-anime="200"> <a href="#inicio">Láurea <img src="assets/img/logo/logo_menu.png"></a></div>
                <nav>
                    <ul data-anime="200">
                        <li><a href="#inicio">Inicio</a></li>
                        <li><a href="#produtos">Produtos </a></li>
                        <li><a href="#materias">Matérias</a></li>
                        <li><a href="#sobre">Sobre </a></li>
                        <li><a href="#contato">Contato </a></li>
                        <li><a href="#depoimentos">Depoimentos </a></li>
                        <li ><div onclick="toggleSidebar()"><h5>Entrar</h5></div></li>
                    </ul>
                </nav>
            </div>
        </header>
        <div id="sidebar">
                <button class="close" onclick="toggleSidebar()">
                        <span aria-hidden="true">&times;</span>
                </button>
                <img src="assets/img/logo/logo_form.png" style="margin-top: 30px;">
        
                <form method="POST" action="" class="login">
                    <div class="form-group">
                        <label for="login">Login:</label>
                        <input type="text" class="form-control" id="login">
                    </div>
                    <div class="form-group">
                        <label for="senha">Senha:</label>
                        <input type="password" class="form-control" id="senha">
                    </div>
                    <div class="form-group">
                        <input type="submit" value="ENTRAR" class="btn btn-primary"/>
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
                                    <div class="widget_head">  <img src="assets/img/materias/matematica.png"/> </div>
                                    <div class="widget_body">
                                        <h2>MATEMÁTICA</h2>
                                        <hr>
                                        <p>Porque matemática prepara o homem para a vida como nenhuma outra disciplina pode fazer. Ela é a ciência que fornece o melhor instrumental para qualquer profissional ser bem sucedido.</p>
                                    </div>
                            </div>
                    </div>
                    <div class="col">
                            <div class="widget">
                                    <div class="widget_head">  <img src="assets/img/materias/fisica.png"/> </div>
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
                                        <div class="widget_head">  <img src="assets/img/materias/quimica.png"/> </div>
                                        <div class="widget_body">
                                            <h2>QUÍMICA</h2>
                                            <hr>
                                            <p>Química é a ciência que estuda a estrutura das substâncias, a composição e as propriedades das diferentes matérias, suas transformações e variações de energia.</p>
                                        </div>
                                </div>
                        </div>    
                        <div class="col">
                            <div class="widget">
                                    <div class="widget_head">  <img src="assets/img/materias/idiomas.png"/> </div>
                                    <div class="widget_body">
                                        <h2>idiomas</h2>
                                        <hr>
                                        <p>No mundo globalizado em que vivemos aprender outro idioma é algo essencial para nossa carreira profissional e para a comunicação com as demais pessoas, pois isso é um grande diferencial.</p>
                                    </div>
                                </div>
                        </div>
                        <div class="col">
                            <div class="widget">
                                    <div class="widget_head">  <img src="assets/img/materias/rac_logico.png"/> </div>
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
                          <div class="tag ">SOBRE</div> 
                    </div>
                    <div class="sobre_titulo">
                        <h1>A Láurea</h1>
                    </div>
                    <div class="sobre_texto container">
                        <p>O Lorem Ipsum é um texto modelo da indústria tipográfica e de impressão. 
                            O Lorem Ipsum tem vindo a ser o texto padrão usado por estas indústrias desde o ano de 1500,
                             quando uma misturou os caracteres de um texto para criar um espécime de livro. 
                             Este texto não só sobreviveu 5 séculos, mas também o salto para a tipografia electrónica, 
                             mantendo-se essencialmente inalterada. Foi popularizada nos anos 60 com a disponibilização 
                             das folhas de Letraset, que continham passagens com Lorem Ipsum, e mais recentemente com os 
                             programas de publicação como o Aldus PageMaker que incluem versões do Lorem Ipsum.
                        </p>
                    </div>
                    <div class="container">
                        <div class="row ">
                            <div class="col"><img src="assets/img/sobre/criancas.png" alt="Criancas"></div>
                            <div class="col">
                                <h1>Não Cansamos De Ensinar</h1>
                                <ul>
                                    <li>-150 Alunos </li>
                                    <li>-3 Anos atuando com maestria</li>
                                    <li>-Alunos de diversas escolas do DF</li>
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
                            <li> <img src="assets/img/contato/telefone.png"/> 61-333-9999 </li>
                            <li> <img src="assets/img/contato/whatsapp.png"/> 61-99999-9999</li>
                            <li> <img src="assets/img/contato/email.png"/> qualquer@qualquer.com </li>
                            <li> <img src="assets/img/contato/localizacao.png"/> Praça do Relógio - Taguatinga - Distrito Federal </li>
                                  
                        </ul>
                    </div>
                    <div class="col">
                         <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3838.444316797588!2d-48.05893754928808!3d-15.833228078076216!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x935a32e923032cbf%3A0x55322540ab25f7c6!2zUHJhw6dhIGRvIFJlbMOzZ2lv!5e0!3m2!1spt-BR!2sbr!4v1571793044900!5m2!1spt-BR!2sbr" width="580" height="380" frameborder="0" style="border:0;" allowfullscreen=""></iframe>
                    </div>
                </div>
               
            </div>
            
            </section>
            <footer data-anime="600">
                <div class="footer">
                    <div class="container">
                         <div class="logo float-left"> <a href="#inicio">Láurea <img src="assets/img/logo/logo_menu.png"></a></div>
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
                Láurea 2010 - 2019. Todos os direitos reservados.
               </div>
            </div>



            
	<!-- animações de entrada na página -->
	<script type="text/javascript" src="assets/js/simple-anime.js"></script>

	<!-- Slide deve ser colado em toda pagina de HTML  -->
	<script type="text/javascript" src="assets/js/simple-slide.js"></script>
	<script type="text/javascript" src="assets/js/script.js"></script>

	<!-- Jquery 3.4.1 e bootstrap -->
	<script type="text/javascript" src="assets/js/jquery.js"></script>
	<script type="text/javascript" src="assets/js/bootstrap.bundle.min.js"></script>

	<!-- AÇÃO DO FORMULÁRIO DE LOGIN -->
	<script type="text/javascript">
		function toggleSidebar(){
			document.getElementById("sidebar").classList.toggle('active');
		}
	</script>
</body>
</html>
