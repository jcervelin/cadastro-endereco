package br.com.sapato.cadastroendereco.dao;

import br.com.sapato.cadastroendereco.domain.Endereco;

public class EnderecoDAO extends BaseDAO<Endereco, Long> implements IEnderecoDAO{
	
	public EnderecoDAO(){
		oClass = Endereco.class;
	}
}
