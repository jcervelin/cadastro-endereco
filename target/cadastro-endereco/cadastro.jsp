<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta http-equiv="Access-Control-Allow-Origin" content="*">
		
		<title>Insert title here</title>
		<script type="text/javascript"
			src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script type="text/javascript">
			$(document).ready(function() {
		
				$.fn.serializeObject = function() {
					var o = {};
					var a = this.serializeArray();
					$.each(a, function() {
						if (o[this.name]) {
							if (!o[this.name].push) {
								o[this.name] = [ o[this.name] ];
							}
							o[this.name].push(this.value || '');
						} else {
							o[this.name] = this.value || '';
						}
					});
					return o;
				};
				
				$('#createBtn').click(function() {
					callAjax('POST', false);
				});
				$('#readBtn').click(function() {
					callAjax('GET', true);
				});
				$('#updateBtn').click(function() {
					callAjax('PUT', false);
				});
				$('#deleteBtn').click(function() {
					callAjax('DELETE', true);
				});
				
				function callAjax(method, isFindDelete){
					var getParam="";
					var objEndereco = JSON.stringify($('#frmCadastro').serializeObject());
					if (isFindDelete){
						getParam = "/"+$('#id').val();
						objEndereco = "";
					}
				
					$.ajax({
						url : 'http://'+location.host+'<c:out value="${pageContext.request.contextPath}"/>/rest/cep'+getParam,
						headers: { 
		        			'Accept': 'application/json',
		        			'Content-Type': 'application/json' 
		    			},
						dataType : 'json',
						method : method,
						type : method,
						data : objEndereco,
						success : function(result) {
							alert(result.responseText);
							if (result != null){
								$('#cidade').val(result.cidade);
								$('#estado').val(result.estado);
								$('#logradouro').val(result.logradouro);
								$('#cep').val(result.cep);
								$('#bairro').val(result.bairro);
								$('#numero').val(result.numero);
								$('#complemento').val(result.complemento);
								$('#id').val(result.id);
							}
						},
						error : function(error) {
							alert(error.responseText);
						}
					});
				}
								
				$('#buscaEnderecoPorCep').click(function() {
					$.ajax({
						url : 'http://'+location.host+'/BuscaEndereco/rest/cep/'+$('#cep').val(),
						headers: { 
		        			'Accept': 'application/json',
		        			'Content-Type': 'application/json' 
		    			},
						dataType : 'json',
						type : 'GET',
						success : function(result) {
							$('#cidade').val(result.cidade);
							$('#estado').val(result.estado);
							$('#logradouro').val(result.logradouro);
						},
						error : function(error) {
							alert(error);
						}
					});
				});
				
			});
		</script>
	</head>
	<body>
		<h1>Cadastro de Endereços</h1>
		<form id="frmCadastro" name="frmCadastro">
			<table>
				<tr>
					<td colspan="2">
						<label for="id">ID: </label>
						<input id="id" name="id" value="" type="text" />
					</td>
				</tr>
				<tr>
					<td colspan="4">
						<label for="cep">Cep: </label>
						<input id="cep" name="cep" value="" type="text" />
					</td>
					<td colspan="2">
						<input id="buscaEnderecoPorCep" name="buscaEnderecoPorCep" value="Busca Endereço" type="button" />
					</td>					
				</tr>
				<tr>
					<td colspan="2">
						<label for="logradouro">Rua: </label>
						<input id="logradouro" name="logradouro" value="" type="text" /></td>
					<td colspan="2">
						<label for="numero">Numero: </label>
						<input id="numero" name="numero" value="" type="text" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<label for="bairro">Bairro: </label>
						<input id="bairro" name="bairro" value="" type="text" />
					</td>
					<td colspan="2">
						<label for="complemento">Complemento: </label>
						<input id="complemento" name="complemento" value="" type="text" />
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<label for="cidade">Cidade: </label>
						<input id="cidade" name="cidade" value="" type="text" />
					</td>
					<td colspan="2">
						<label for="estado">Estado: </label>
						<input id="estado" name="estado" value="" type="text" />
					</td>
				</tr>
				<tr>
					<td>
						<input id="createBtn" name="createBtn" value="Create" type="button" />
					</td>
					<td>
						<input id="readBtn" name="readBtn" value="Read" type="button" />
					</td>
					<td>
						<input id="updateBtn" name="updateBtn" value="Update" type="button" />
					</td>
					<td>
						<input id="deleteBtn" name="deleteBtn" value="Delete" type="button" />
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>