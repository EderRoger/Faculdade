<?php
echo '<!doctype html>'; 
	echo '<html>';  
	echo '  <head>';  
	echo '    <meta charset="ISO-8859-1">'; 
	echo '    <title>Sistema de Cadastro de Cliente</title>'; 
	echo '  </head>';  
	echo '  <body>'; 
	

	$nome = $_GET['nome'];
	
	echo "O Cliente ".$nome." ser� foi excluido do arquivo.";
	
	include 'arquivo.class.php';
	
	$arquivo = new ARQUIVO();
	
	$arquivo->setArquivo("cliente.txt");
	$arquivo->setOperacao("r");
	$conteudoNaoAlterado = $arquivo->buscarConteudoQueNaoSeraAlterado($nome);			   

	echo $conteudoNaoAlterado;

	$arquivo = new ARQUIVO();
	$arquivo->setArquivo("cliente.txt");
	$arquivo->setOperacao("r+");
	echo "<p>".$arquivo->excluir($conteudoNaoAlterado)."</p>";
	
	echo '<p>:: <a href="index.php"> Cadastrar novo Cliente</a><br>';
	echo ':: <a href="listar.php"> Listar todos os Clientes</a></p>';

	
	
	echo '  </body>';
	echo '</html>';		