package god.core.cmm.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.egovframe.rte.fdl.property.EgovPropertyService;
import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.ComDefaultVO;
import egovframework.com.cmm.LoginVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import egovframework.com.cmm.service.EgovCmmUseService;
import egovframework.com.cmm.util.EgovUserDetailsHelper;
import god.core.cmm.service.GodCoreCmmService;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
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
	 * 공통코드등 전체 업무에서 공용해서 사용해야 하는 서비스를 정의하기 위한 서비스 인터페이스
	 */
	@Resource
	protected EgovCmmUseService egovCmmUseService;

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
		setFrstRegisterId((ComDefaultVO) vo);
		return dao.insert(vo);
	}

	/**
	 * 최초등록시점, 최초등록자ID, 최종수정시점, 최종수정자ID 값설정
	 * 
	 * @param vo
	 */
	protected void setFrstRegisterId(final ComDefaultVO vo) {
		final LoginVO loginVO = (LoginVO) EgovUserDetailsHelper.getAuthenticatedUser();
		if (loginVO != null) {
			vo.setFrstRegisterId(loginVO.getUniqId());
			vo.setFrstRegistPnttm(LocalDateTime.now());
			vo.setLastUpdusrId(loginVO.getUniqId());
			vo.setLastUpdtPnttm(vo.getFrstRegistPnttm());
		}
	}

	@Override
	public void insert(final T vo, final ModelMap model) {
		log.debug("vo={}", vo);
	}

	/**
	 * 공통코드를 조회한다.
	 * 
	 * @param codeIds
	 * @param model
	 */
	protected void selectCmmCodeDetail(final List<String> codeIds, final ModelMap model) {
		final Map<String, List<CmmnDetailCode>> cmmCodeDetailMap = new HashMap<>();

		for (final String codeId : codeIds) {
			final ComDefaultCodeVO comDefaultCodeVO = new ComDefaultCodeVO();
			comDefaultCodeVO.setCodeId(codeId);
			final List<CmmnDetailCode> cmmCodeDetail = egovCmmUseService.selectCmmCodeDetail(comDefaultCodeVO);
			cmmCodeDetailMap.put(comDefaultCodeVO.getCodeId(), cmmCodeDetail);
		}

		model.addAttribute("cmmCodeDetail", cmmCodeDetailMap);
	}

	/**
	 * ComDefaultCodeVO의 리스트를 받아서 여러개의 코드 리스트를 맵에 담아서 리턴한다.
	 * 
	 * @param codeIds
	 * @param model
	 */
	protected void selectCmmCodeDetails(final List<String> codeIds, final ModelMap model) {
		final List<ComDefaultCodeVO> voList = new ArrayList<>();

		for (final String codeId : codeIds) {
			ComDefaultCodeVO comDefaultCodeVO = new ComDefaultCodeVO();
			comDefaultCodeVO.setCodeId(codeId);
			voList.add(comDefaultCodeVO);
		}

		final Map<String, List<CmmnDetailCode>> cmmCodeDetails = egovCmmUseService.selectCmmCodeDetails(voList);

		model.addAttribute("cmmCodeDetails", cmmCodeDetails);
	}

	@Override
	public void insert(final T vo, final BindingResult bindingResult, final MultipartHttpServletRequest multiRequest,
			final ModelMap model) {
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
	 * @param vo
	 */
	protected void prePaginationInfo(final ComDefaultVO vo, final PaginationInfo paginationInfo) {
		vo.setPageUnit(propertyService.getInt("pageUnit"));
		vo.setPageSize(propertyService.getInt("pageSize"));

		paginationInfo.setCurrentPageNo(vo.getPageIndex());
		paginationInfo.setRecordCountPerPage(vo.getPageUnit());
		paginationInfo.setPageSize(vo.getPageSize());

		vo.setFirstIndex(paginationInfo.getFirstRecordIndex());
		vo.setLastIndex(paginationInfo.getLastRecordIndex());
		vo.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());
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

	/**
	 * Debug VO
	 * 
	 * @param vo
	 */
	protected void debugVO(final T vo) {
		log.debug("vo={}", vo);
	}

}
