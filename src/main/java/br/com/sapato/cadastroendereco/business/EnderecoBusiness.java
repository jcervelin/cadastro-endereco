package br.com.sapato.cadastroendereco.business;

import br.com.sapato.cadastroendereco.dao.IEnderecoDAO;
import br.com.sapato.cadastroendereco.domain.Endereco;


public class EnderecoBusiness extends BaseBusiness<Endereco, Long> implements IEnderecoBusiness{

	public EnderecoBusiness(IEnderecoDAO dao) {
		super(dao);
	}

	
}
