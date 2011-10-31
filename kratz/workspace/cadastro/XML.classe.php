<?php
// Criar minha classe XML com SimpleXML
// Criar ou abrir um arquivo XML
// Buascar dados de um arquivo XML
// Gravar dados em um arquivo XML

class XMLArquivo{
	   private $_xml; // Ponteiro ou objeto para o arquivo físico já existente
   	   private $_xmlNovo; // Ponteiro para o arquivo lógico (objeto XML) novo
       private $_arquivo;	// Caminho ou path com o arquivo para ser aberto
       
       //Construtor e vamos abrir o arquivo XML
       public function __construct($arq){
       	// recebi o arquivo que será aberto       	
       	$this->_arquivo = $arq;
       	if( file_exists($arq) ) {
	      $this->_xml = simplexml_load_file($arq);
	   } else {
	   	// Criar uma novo arquivo com o nome vindo de $arq
	   	$this->_xmlNovo = new SimpleXMLElement('<?xml version="1.0" ?><cadastro />');
			// Criando um arquivo XML
			file_put_contents($arq, $this->_xmlNovo->asXML());
			// Ponteiro para o arquivo físico já existente
			$this->_xml = simplexml_load_file($arq);
	   }
   } 
   public function adicionaCliente($nome, $email, $telefone, $sexo, $idade){
   	$cliente = $this->_xml->addChild('cliente');
   	$cliente->addChild('nome', $nome);
   	$cliente->addChild('email', $email);
   	$cliente->addChild('telefone', $telefone);
    $cliente->addChild('sexo', $sexo);
    $cliente->addChild('idade', $idade);
    file_put_contents($this->_arquivo , $this->_xml->asXML());
   } 
   
    function buscaXML()
    {
		foreach($this->_xml->cliente as $cliente) // $cliente = $this->_xml->cliente;
		{
 			echo "Nome: ".$cliente->nome;
 			echo " Email: ".$cliente->email;
 			echo " Telefone: ".$cliente->telefone;
 			if ($cliente->sexo == "1")
 				echo " Sexo: Masculino";
 			if ($cliente->sexo == "2")
 				echo " Sexo: Feminino";	
 			echo " Idade: ".$cliente->idade;
 			echo "<br>";
		}
    }
}

?>




















