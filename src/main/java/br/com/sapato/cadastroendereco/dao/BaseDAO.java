package br.com.sapato.cadastroendereco.dao;

import javax.persistence.EntityManager;

import br.com.sapato.cadastroendereco.domain.Endereco;

public class BaseDAO<E, PK> implements IBaseDAO<E, PK> {
	
	public EntityManager em;
	public Class<E> oClass;
	
	public BaseDAO () {
		em = JPAUtil.getEntityManagerSapato();
	}
	
	public void closeEntityManager() {
		JPAUtil.closeEntityManagerSapato();
	}
	
	/* (non-Javadoc)
	 * @see br.com.sapato.cadastroendereco.dao.IBaseDAO#create(E)
	 */
	@Override
	public E create(E entity){
		try {
			if (!em.getTransaction().isActive())
				em.getTransaction().begin();
				entity = em.merge(entity);
				em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
		return entity;
	}
	
	/* (non-Javadoc)
	 * @see br.com.sapato.cadastroendereco.dao.IBaseDAO#update(E)
	 */
	@Override
	public E update(E entity){
		try {
			if (!em.getTransaction().isActive())
				em.getTransaction().begin();
				entity = em.merge(entity);
				em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
		return entity;
	}
	
	/* (non-Javadoc)
	 * @see br.com.sapato.cadastroendereco.dao.IBaseDAO#findById(PK)
	 */
	@Override
	public E findById(PK pk){
		return em.find(oClass, pk);
	}
	
	/* (non-Javadoc)
	 * @see br.com.sapato.cadastroendereco.dao.IBaseDAO#delete(PK)
	 */
	@Override
	public void delete (PK pk){
		try {
			if (!em.getTransaction().isActive()){
				E obj = em.getReference(oClass, pk);
				em.getTransaction().begin();
				em.remove(obj);
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			em.getTransaction().rollback();
		} finally {
			closeEntityManager();
		}
		
	}	
}