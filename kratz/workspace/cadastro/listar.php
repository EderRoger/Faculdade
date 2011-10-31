<?php
/* Arquivo: index.php
 * Descrição: Página principal de uma sistema de cadastro de cliente usando arquivo e classes
 * Versão: 1.0
 * Autor: Ricardo de Andrade Kratz
 */
?>
<!doctype html> 
<html> 
  <head> 
    <meta charset="ISO-8859-1">
    <title>Sistema de Cadastro de Client</title>
  </head> 
  <body> 
	<h1>Lista de Clientes</h1>
	
	

	<table border="1">
<?php 
		/*include 'XML.classe.php';

		$XMLLocal = new XMLArquivo("cliente.xml");
		
		echo "<p>Lista dos Cliente arquivo XML</p>";
		
		$XMLLocal->buscaXML();
	*/
		include 'arquivo.class.php';
		
		$arquivoCliente = new ARQUIVO();
	
		$arquivoCliente->setArquivo("cliente.txt");
		$arquivoCliente->setOperacao("r");
		
		$arrayCliente = $arquivoCliente->listarTodos();
		
		for ($i=0;$i<sizeof($arrayCliente);$i++) {
			$dados[] =  explode(";",$arrayCliente[$i]);
		}
		
		//var_dump($dados);
		echo "<p>Lista dos Cliente arquivo TXT</p>";
 
		
		for ($i=0;$i<sizeof($dados);$i++) {
	?>		
	<tr>
	 <td>
		<?php   echo $dados[$i][0]; ?>
	 </td>
	 <td><a href="index.php?nome=<?=$dados[$i][0]; ?>&idade=<?=$dados[$i][4]; ?>&email=<?=$dados[$i][1]; ?>&telefone=<?=$dados[$i][2]; ?>&linha=<?=$i ?>>&tipo=alterar"> editar</a></td>
	 <td><a href="excluir.php?nome=<?=$dados[$i][0]; ?>">excluir</a></td>
	</tr>
	<?php 
		}	
	?>
	
	</table>
	<p>:: <a href="index.php"> Voltar</a></p>
  </body> 
</html> 