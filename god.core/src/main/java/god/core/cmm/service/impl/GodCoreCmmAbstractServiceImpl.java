package god.core.cmm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.ui.ModelMap;

import egovframework.com.cmm.ComDefaultVO;
import god.core.cmm.service.GodCoreCmmService;
import lombok.NoArgsConstructor;

/**
 * data 처리관련(ServiceImpl 공통)
 * 
 * @author 이백행
 * @since 2023-12-06
 *
 * @param <T>
 * @param <R>
 */
@NoArgsConstructor
public class GodCoreCmmAbstractServiceImpl<T, R> extends EgovAbstractServiceImpl implements GodCoreCmmService<T, R> {

	/**
	 * Model Result
	 */
	public static final String MODEL_RESULT = "result";

	/**
	 * Property 서비스의 인터페이스 클래스
	 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertyService;

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
		model.addAttribute(MODEL_RESULT, dao.insert(vo));
	}

	@Override
	public R select(final T vo) {
		return dao.select(vo);
	}

	@Override
	public void select(final T vo, final ModelMap model) {
		model.addAttribute(MODEL_RESULT, dao.select(vo));
	}

	@Override
	public List<R> selectList(final T vo) {
		return dao.selectList(vo);
	}

	@Override
	public void selectList(final T vo, final ModelMap model) {
		final PaginationInfo paginationInfo = new PaginationInfo();
		prePaginationInfo((ComDefaultVO) vo, paginationInfo);

		model.addAttribute("resultList", dao.selectList(vo));
		model.addAttribute("resultListTotCnt", dao.selectListTotCnt(vo));

		postPaginationInfo(model, paginationInfo);
	}

	/**
	 * 페이징 전처리
	 * 
	 * @param comDefaultVO
	 */
	protected void prePaginationInfo(final ComDefaultVO comDefaultVO, final PaginationInfo paginationInfo) {
		comDefaultVO.setPageUnit(propertyService.getInt("pageUnit"));
		comDefaultVO.setPageSize(propertyService.getInt("pageSize"));

		paginationInfo.setCurrentPageNo(comDefaultVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(comDefaultVO.getPageUnit());
		paginationInfo.setPageSize(comDefaultVO.getPageSize());

		comDefaultVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		comDefaultVO.setLastIndex(paginationInfo.getLastRecordIndex());
		comDefaultVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
	}

	/**
	 * 페이징 후처리
	 * 
	 * @param model
	 * @param paginationInfo
	 */
	protected void postPaginationInfo(final ModelMap model, final PaginationInfo paginationInfo) {
		paginationInfo.setTotalRecordCount((int) model.get("resultListTotCnt"));
		model.addAttribute("paginationInfo", paginationInfo);
	}

	@Override
	public int update(final T vo) {
		return dao.update(vo);
	}

	@Override
	public void update(final T vo, final ModelMap model) {
		model.addAttribute(MODEL_RESULT, dao.update(vo));
	}

	@Override
	public int delete(final T vo) {
		return dao.delete(vo);
	}

	@Override
	public void delete(final T vo, final ModelMap model) {
		model.addAttribute(MODEL_RESULT, dao.delete(vo));
	}

	@Override
	public int merge(final T vo) {
		return dao.merge(vo);
	}

	@Override
	public void merge(final T vo, final ModelMap model) {
		model.addAttribute(MODEL_RESULT, dao.merge(vo));
	}

	@Override
	public int multi(final T vo) {
		return dao.multi(vo);
	}

	@Override
	public void multi(final T vo, final ModelMap model) {
		model.addAttribute(MODEL_RESULT, dao.multi(vo));
	}

	@Override
	public int selectListTotCnt(final T vo) {
		return dao.selectListTotCnt(vo);
	}

}
