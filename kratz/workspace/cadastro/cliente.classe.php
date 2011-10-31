<?php
class CLIENTE{
	//Atributos
	private $_nomeCliente;
	private $_emailCliente;
	private $_telefoneCliente;
	private $_sexoCliente;
	private $_idadeCliente;
	/**
	 * @return the $_nomeCliente
	 */
	public function getNomeCliente() {
		return $this->_nomeCliente;
	}

	/**
	 * @param field_type $_nomeCliente
	 */
	public function setNomeCliente($_nomeCliente) {
		$this->_nomeCliente = $_nomeCliente;
	}
	/**
	 * @return the $_emailCliente
	 */
	public function getEmailCliente() {
		return $this->_emailCliente;
	}

	/**
	 * @return the $_telefoneCliente
	 */
	public function getTelefoneCliente() {
		return $this->_telefoneCliente;
	}

	/**
	 * @return the $_sexoCliente
	 */
	public function getSexoCliente() {
		return $this->_sexoCliente;
	}

	/**
	 * @return the $_idadeCliente
	 */
	public function getIdadeCliente() {
		return $this->_idadeCliente;
	}

	/**
	 * @param field_type $_emailCliente
	 */
	public function setEmailCliente($_emailCliente) {
		$this->_emailCliente = $_emailCliente;
	}

	/**
	 * @param field_type $_telefoneCliente
	 */
	public function setTelefoneCliente($_telefoneCliente) {
		$this->_telefoneCliente = $_telefoneCliente;
	}

	/**
	 * @param field_type $_sexoCliente
	 */
	public function setSexoCliente($_sexoCliente) {
		$this->_sexoCliente = $_sexoCliente;
	}

	/**
	 * @param field_type $_idadeCliente
	 */
	public function setIdadeCliente($_idadeCliente) {
		$this->_idadeCliente = $_idadeCliente;
	}


	
	
}

?>