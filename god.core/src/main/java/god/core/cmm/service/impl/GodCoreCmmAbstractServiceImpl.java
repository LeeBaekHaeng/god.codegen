package god.core.cmm.service.impl;

import java.util.List;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.ui.ModelMap;

import god.core.cmm.service.GodCoreCmmAbstractService;

/**
 * data 처리관련(ServiceImpl 공통)
 * 
 * @author 이백행
 * @since 2023-12-06
 *
 * @param <T>
 * @param <R>
 */
public class GodCoreCmmAbstractServiceImpl<T, R> extends EgovAbstractServiceImpl
		implements GodCoreCmmAbstractService<T, R> {

	/**
	 * data 처리관련(DAO 공통)
	 */
	private GodCoreCmmAbstractDAOImpl<T, R> dao;

	/**
	 * dao 주입
	 * 
	 * @param service
	 */
	protected void postConstruct(final GodCoreCmmAbstractDAOImpl<T, R> dao) {
		this.dao = dao;
	}

	@Override
	public int insert(final T vo) {
		return dao.insert(vo);
	}

	@Override
	public void insert(T vo, ModelMap model) {
		// TODO Auto-generated method stub

	}

	@Override
	public R select(T vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void select(T vo, ModelMap model) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<R> selectList(T vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void selectList(T vo, ModelMap model) {
		// TODO Auto-generated method stub

	}

	@Override
	public int update(T vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update(T vo, ModelMap model) {
		// TODO Auto-generated method stub

	}

	@Override
	public int delete(T vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(T vo, ModelMap model) {
		// TODO Auto-generated method stub

	}

	@Override
	public int merge(T vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void merge(T vo, ModelMap model) {
		// TODO Auto-generated method stub

	}

	@Override
	public int multi(T vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void multi(T vo, ModelMap model) {
		// TODO Auto-generated method stub

	}

}
