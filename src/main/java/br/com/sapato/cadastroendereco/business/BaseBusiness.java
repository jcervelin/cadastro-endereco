package br.com.sapato.cadastroendereco.business;

import br.com.sapato.cadastroendereco.dao.IBaseDAO;

public class BaseBusiness<E, PK> implements IBaseBusiness<E, PK> {
	
	private IBaseDAO<E, PK> dao;
	
	public BaseBusiness(IBaseDAO<E, PK> dao){
		this.dao = dao;
	}
	
	/* (non-Javadoc)
	 * @see br.com.sapato.cadastroendereco.business.IBaseBusiness#create(E)
	 */
	@Override
	public E create(E entity){
		return dao.create(entity);
	};

	/* (non-Javadoc)
	 * @see br.com.sapato.cadastroendereco.business.IBaseBusiness#update(E)
	 */
	@Override
	public E update(E entity){
		return dao.update(entity);
	};
	
	/* (non-Javadoc)
	 * @see br.com.sapato.cadastroendereco.business.IBaseBusiness#read(PK)
	 */
	@Override
	public E read(PK pk){
		return dao.findById(pk);
	};

	/* (non-Javadoc)
	 * @see br.com.sapato.cadastroendereco.business.IBaseBusiness#delete(PK)
	 */
	@Override
	public void delete(PK pk){
		dao.delete(pk);
	};
}
