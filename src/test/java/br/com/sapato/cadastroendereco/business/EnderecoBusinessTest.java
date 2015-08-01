package br.com.sapato.cadastroendereco.business;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.sapato.cadastroendereco.dao.IEnderecoDAO;
import br.com.sapato.cadastroendereco.domain.Endereco;

public class EnderecoBusinessTest {

	private Endereco endereco;
	private IEnderecoBusiness business;

	@Mock
	private IEnderecoDAO dao;

	@Before
	public void init() {
		// Dados para serem comparados com os trazidos pela lógica do business
		endereco = new Endereco();
		endereco.setId(10L);
		endereco.setCidade("Sao Paulo");
		endereco.setEstado("SP");
		endereco.setLogradouro("Av. Lins de Vasconcelos");
		endereco.setCep(04112111L);
		endereco.setBairro("Vila Mariana");
		endereco.setNumero("S/N");
		endereco.setComplemento("Fundos");

		//mocka métodos do DAO para evitar que o teste execute queries no banco
		MockitoAnnotations.initMocks(this);
		business = spy(new EnderecoBusiness(dao));
		doReturn(endereco).when(business).create(endereco);		
		doReturn(endereco).when(business).read(10L);		
	}

	// Testa busca por um cep correto
	@Test
	public void buscaEndecoPorCep() {
		Endereco end2 = business.read(10L);
		Assert.assertEquals(endereco, end2);
	}
	
	// Testa criar endereco
	@Test
	public void criaAtualizaEndereco() {
		Endereco end2 = business.create(endereco);
		Assert.assertEquals(endereco, end2);
	}
}