package br.com.sapato.cadastroendereco.dao;

import br.com.sapato.cadastroendereco.domain.Endereco;

public class EnderecoDAO extends BaseDAO<Endereco, Long> implements IEnderecoDAO{
	//Todos os m�todos CRUD estao na BaseDAO para facilitar reuso caso outras entidades sejam criadas.
	//No caso de m�todos mais espec�ficos que soh fariam sentido na classe Endereco, poderiam ser colocados aqui.
	//Atualmente esta classe s� est� sendo usada para implementar os Generics
	public EnderecoDAO(){
		oClass = Endereco.class;
	}
}
