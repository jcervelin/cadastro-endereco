package br.com.sapato.cadastroendereco.dao;

public interface IBaseDAO<E, PK> {

	public abstract E create(E entity);

	public abstract E update(E entity);

	public abstract E findById(PK pk);

	public abstract void delete(PK pk);

}