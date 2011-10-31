<?php
class ARQUIVO {
	private $_arquivo;
	private $_operacao;
	private $_linha;
	private $_conteudo;
	private $lines;
	/**
	 * @return the $_arquivo
	 */
	public function getArquivo() {
		return $this->_arquivo;
	}
	
	/**
	 * @return the $_operacao
	 */
	public function getOperacao() {
		return $this->_operacao;
	}
	
	/**
	 * @param field_type $_arquivo
	 */
	public function setArquivo($_arquivo) {
		$this->_arquivo = $_arquivo;
	}
	
	/**
	 * @param field_type $_operacao
	 */
	public function setOperacao($_operacao) {
		$this->_operacao = $_operacao;
	}
	
	public function gravar($conteudo) {
		//TENTA ABRIR O ARQUIVO TXT
		$abrir = fopen ( $this->_arquivo, "$this->_operacao" );
		fwrite ( $abrir, $conteudo );
		fclose ( $abrir );
		return "Arquivo gravado com Sucesso !!";
	}
	
	public function alterar($conteudo) {
		$arquivo = fopen ( $this->_arquivo, "$this->_operacao" );
		rewind ( $arquivo );
		ftruncate ( $arquivo, 0 );
		// reescreve o conteudo dentro do arquivo
		if (! fwrite ( $arquivo, $conteudo ))
			die ( 'N�o foi poss�vel atualizar o arquivo.' );
		fclose ( $arquivo );
		return 'Arquivo atualizado com sucesso';
	}
	public function excluir($conteudo) {
		$arquivo = fopen ( $this->_arquivo, "$this->_operacao" );
		
		rewind ( $arquivo );
		ftruncate ( $arquivo, 0 );
		// reescreve o conteudo dentro do arquivo
		if (! fwrite ( $arquivo, $conteudo ))
			die ( 'N�o foi poss�vel excluir o registro.' );
		fclose ( $arquivo );
		return 'Registro deletado com sucesso';
	}
	
	public function listarTodos() {
		
		$ponteiro = fopen ( $this->_arquivo, "$this->_operacao" );
		while ( ! feof ( $ponteiro ) ) {
			//L� UMA LINHA DO ARQUIVO
			$this->_linha = fgets ( $ponteiro, 4096 );
			//IMPRIME NA TELA O RESULTADO
			$this->lines [] = $this->_linha;
		
		//$this->_conteudo .= $this->_linha."<br>";
		} //FECHA WHILE
		fclose ( $ponteiro );
		return $this->lines;
	
		//return $this->_conteudo;
	//FECHA O PONTEIRO DO ARQUIVO
	}
	public function buscarConteudoQueNaoSeraAlterado($expressao) {
		
		$ponteiro = fopen ( $this->_arquivo, "$this->_operacao" );
		while ( ! feof ( $ponteiro ) ) {
			$this->_linha = fgets ( $ponteiro, 4096 );
			//buscando as linhas diferentes da expressao passada como parametro
			if (!preg_match ( "/".$expressao."/", $this->_linha )) {
			    $this->_conteudo .= $this->_linha;
			} 
			//echo $this->_conteudo;
		} //FECHA WHILE
		fclose ( $ponteiro );
		
		return $this->_conteudo;
	//FECHA O PONTEIRO DO ARQUIVO
	}
	

}
?>