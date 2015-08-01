# cadastro-endereco

Código com comentarios explicativos
Testes unitários da classe de negócio feita pelo JUNIT e mockadas utilizando framework Mockito, para que as regras todas sejam validadas nos testes sem que seja feito qualquer acesso a banco.

Testes dos Servicos REST serviços feitos com SOAPUI.

Ao gerar build o Maven executa testes com JUNIT usando Mockito, executa TestCases com SOAPUI para cada método do REST (POST, GET, PUT e DELETE - CRUD), gera WAR e faz deploy no Weblogic, automaticamente.

O projeto do SOAPUI com o TestCase está dentro deste projeto e também está referenciado no pom.xml


#Arquitetura

Para criar este projeto foi utilizado:
* Java, como linguagem de programação;
* Tomcat para chamar o serviço mockado do CEP, feito no exercício 1;
* Weblogic 10.3.6 com DataSource configurado com um pool de conexões do Oracle;
* Oracle XE 11G;
* JPA com implementação de Hibernate, para persistir o endereço no Banco;
* Dentro do serviço ainda há uma JSP com um formulário simples para testes 
  e com botões que executam eventos ajax para cada método http que o serviço utiliza:
  GET para ler endereco
  POST para criar endereco
  PUT para atualizar endereco
  DELETE para deletar endereco
* Seguindo o padrão do REST, a mesma url faz todas as chamadas. O que muda é apenas o método http;
* Maven para controlar as dependências, executar testes e deploy.

