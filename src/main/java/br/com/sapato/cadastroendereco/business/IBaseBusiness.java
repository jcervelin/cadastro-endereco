package br.com.sapato.cadastroendereco.business;

public interface IBaseBusiness<E, PK> {

	public abstract E create(E entity);

	public abstract E update(E entity);

	public abstract E read(PK pk);

	public abstract void delete(PK pk);

}