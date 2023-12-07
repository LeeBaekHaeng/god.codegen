package god.core.cmm.service.impl;

import java.util.List;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.ui.ModelMap;

import god.core.cmm.service.GodCoreCmmAbstractService;
import lombok.RequiredArgsConstructor;

/**
 * data 처리관련(ServiceImpl 공통)
 * 
 * @author 이백행
 * @since 2023-12-06
 *
 * @param <T>
 * @param <R>
 */
@RequiredArgsConstructor
public class GodCoreCmmAbstractServiceImpl<T, R> extends EgovAbstractServiceImpl
		implements GodCoreCmmAbstractService<T, R> {

	/**
	 * data 처리관련(DAO 공통)
	 */
	private GodCoreCmmAbstractDAO<T, R> dao;

	/**
	 * dao 주입
	 * 
	 * @param service
	 */
	protected void postConstruct(final GodCoreCmmAbstractDAO<T, R> dao) {
		this.dao = dao;
	}

	@Override
	public int insert(final T vo) {
		return dao.insert(vo);
	}

	@Override
	public void insert(final T vo, final ModelMap model) {
		model.addAttribute("result", dao.insert(vo));
	}

	@Override
	public R select(final T vo) {
		return dao.select(vo);
	}

	@Override
	public void select(final T vo, final ModelMap model) {
		model.addAttribute("result", dao.select(vo));
	}

	@Override
	public List<R> selectList(final T vo) {
		return dao.selectList(vo);
	}

	@Override
	public void selectList(final T vo, final ModelMap model) {
		model.addAttribute("resultList", dao.selectList(vo));
		model.addAttribute("totCnt", dao.selectListTotCnt(vo));
	}

	@Override
	public int update(final T vo) {
		return dao.update(vo);
	}

	@Override
	public void update(final T vo, final ModelMap model) {
		model.addAttribute("result", dao.update(vo));
	}

	@Override
	public int delete(final T vo) {
		return dao.delete(vo);
	}

	@Override
	public void delete(final T vo, final ModelMap model) {
		model.addAttribute("result", dao.delete(vo));
	}

	@Override
	public int merge(final T vo) {
		return dao.merge(vo);
	}

	@Override
	public void merge(final T vo, final ModelMap model) {
		model.addAttribute("result", dao.merge(vo));
	}

	@Override
	public int multi(final T vo) {
		return dao.multi(vo);
	}

	@Override
	public void multi(final T vo, final ModelMap model) {
		model.addAttribute("result", dao.multi(vo));
	}

	/**
	 * 조회(단건) 전체 건수
	 * 
	 * @param vo
	 * @return
	 */
	public int selectListTotCnt(final T vo) {
		return dao.selectListTotCnt(vo);
	}

}
