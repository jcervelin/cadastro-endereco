package br.com.sapato.cadastroendereco.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.sapato.cadastroendereco.business.EnderecoBusiness;
import br.com.sapato.cadastroendereco.business.IEnderecoBusiness;
import br.com.sapato.cadastroendereco.dao.EnderecoDAO;
import br.com.sapato.cadastroendereco.domain.Endereco;

@Path("/cep")
public class EnderecoService {
	
	private IEnderecoBusiness business;
	
	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsg(@PathParam("param") String id) {
		try {
			business = new EnderecoBusiness(new EnderecoDAO());
			Endereco endereco = business.read(Long.parseLong(id));
			return Response.status(200).entity(endereco).build();
		} catch (Exception e){
			return Response.status(200).entity("Ocorreu um erro t�cnico: "+e.getLocalizedMessage()).build();
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsgPost(Endereco endereco) {
		try {
			business = new EnderecoBusiness(new EnderecoDAO());
			if (validate(endereco))
				endereco = business.create(endereco);
			else
				return Response.status(200).entity("Campos inv�lidos ou incompletos").build();
			return Response.status(200).entity(endereco).build();
		} catch (Exception e){
			return Response.status(200).entity("Ocorreu um erro t�cnico: "+e.getLocalizedMessage()).build();
		}
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsgPut(Endereco endereco) {
		try {
			business = new EnderecoBusiness(new EnderecoDAO());
			//Se valida��o falhar uma mensagem de erro ser� exibida no lugar do JSON
			if (validate(endereco))
				endereco = business.update(endereco);
			else
				return Response.status(200).entity("Campos inv�lidos ou incompletos").build();
			return Response.status(200).entity(endereco).build();
		} catch (Exception e){
			return Response.status(200).entity("Ocorreu um erro t�cnico: "+e.getLocalizedMessage()).build();
		}
	}	
	
	@DELETE
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsgDelete(@PathParam("param") String id) {
		try {
			business = new EnderecoBusiness(new EnderecoDAO());
			business.delete(Long.parseLong(id));
			return Response.status(200).entity("Exclu�do com sucesso").build();
		} catch (Exception e){
			return Response.status(200).entity("Ocorreu um erro t�cnico: "+e.getLocalizedMessage()).build();
		}
	}
	
	//Valida os campos obrigat�rios
	private boolean validate(Endereco endereco){
		if (	endereco.getLogradouro() == null ||
				endereco.getNumero() == null ||
				endereco.getCep() == null ||
				endereco.getCidade() == null ||
				endereco.getEstado() == null ||
				endereco.getLogradouro().isEmpty() ||
				endereco.getNumero().isEmpty() ||
				endereco.getCep() <= 0 ||
				endereco.getCidade().isEmpty() ||
				endereco.getEstado().isEmpty()
			)
			return false;
		return true;
	}
}