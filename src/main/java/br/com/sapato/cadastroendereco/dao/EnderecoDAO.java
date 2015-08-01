package br.com.sapato.cadastroendereco.dao;

import br.com.sapato.cadastroendereco.domain.Endereco;

public class EnderecoDAO extends BaseDAO<Endereco, Long> implements IEnderecoDAO{
	//Todos os métodos CRUD estao na BaseDAO para facilitar reuso caso outras entidades sejam criadas.
	//No caso de métodos mais específicos que soh fariam sentido na classe Endereco, poderiam ser colocados aqui.
	//Atualmente esta classe só está sendo usada para implementar os Generics
	public EnderecoDAO(){
		oClass = Endereco.class;
	}
}
