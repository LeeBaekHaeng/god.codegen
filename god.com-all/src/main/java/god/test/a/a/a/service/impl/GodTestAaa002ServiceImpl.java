package god.test.a.a.a.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import egovframework.com.cmm.ComDefaultCodeVO;
import egovframework.com.cmm.service.CmmnDetailCode;
import god.core.cmm.service.impl.GodCoreCmmAbstractServiceImpl;
import god.test.a.a.a.service.TestAaa002Service;
import god.test.a.a.a.service.TestAaa002VO;
import lombok.RequiredArgsConstructor;

/**
 * 행정코드 ServiceImpl
 * 
 * @author 이백행
 * @since 2023-12-06
 */
@Service
@RequiredArgsConstructor
public class GodTestAaa002ServiceImpl extends GodCoreCmmAbstractServiceImpl<TestAaa002VO, TestAaa002VO>
		implements TestAaa002Service {

	/**
	 * 행정코드 DAO
	 */
	private final GodTestAaa002DAO dao;

	/**
	 * 포스트 구성
	 */
	@PostConstruct
	protected void postConstruct() {
		super.postConstruct(dao);
	}

	@Override
	public int insert(final TestAaa002VO vo) {
		debugVO(vo);
//		return super.insert(vo);

		setFrstRegisterId(vo);

		return dao.insert(vo);
	}

	@Override
	public void insert(final TestAaa002VO vo, final ModelMap model) {
		// selectCmmCodeDetail
		final Map<String, List<CmmnDetailCode>> cmmCodeDetailMap = new HashMap<>();
		ComDefaultCodeVO comDefaultCodeVO = new ComDefaultCodeVO();
		comDefaultCodeVO.setCodeId("COM001");
		List<CmmnDetailCode> cmmCodeDetail = egovCmmUseService.selectCmmCodeDetail(comDefaultCodeVO);
		cmmCodeDetailMap.put(comDefaultCodeVO.getCodeId(), cmmCodeDetail);

		comDefaultCodeVO = new ComDefaultCodeVO();
		comDefaultCodeVO.setCodeId("COM002");
		cmmCodeDetail = egovCmmUseService.selectCmmCodeDetail(comDefaultCodeVO);
		cmmCodeDetailMap.put(comDefaultCodeVO.getCodeId(), cmmCodeDetail);

		model.addAttribute("cmmCodeDetail", cmmCodeDetailMap);

		// selectCmmCodeDetails
		final List<ComDefaultCodeVO> voList = new ArrayList<>();
		comDefaultCodeVO = new ComDefaultCodeVO();
		comDefaultCodeVO.setCodeId("COM003");
		voList.add(comDefaultCodeVO);

		comDefaultCodeVO = new ComDefaultCodeVO();
		comDefaultCodeVO.setCodeId("COM005");
		voList.add(comDefaultCodeVO);

		comDefaultCodeVO = new ComDefaultCodeVO();
		comDefaultCodeVO.setCodeId("COM006");
		voList.add(comDefaultCodeVO);

		final Map<String, List<CmmnDetailCode>> cmmCodeDetails = egovCmmUseService.selectCmmCodeDetails(voList);

		model.addAttribute("cmmCodeDetails", cmmCodeDetails);
	}

	@Override
	public void insert(final TestAaa002VO vo, final BindingResult bindingResult,
			final MultipartHttpServletRequest multiRequest, final ModelMap model) {
		setFrstRegisterId(vo);

		model.addAttribute(MODEL_RESULT, dao.insert(vo));
	}

	@Override
	public TestAaa002VO select(final TestAaa002VO vo) {
		debugVO(vo);
		return super.select(vo);
	}

	@Override
	public void select(final TestAaa002VO vo, final ModelMap model) {
		debugVO(vo);
		super.select(vo, model);
	}

	@Override
	public List<TestAaa002VO> selectList(final TestAaa002VO vo) {
		debugVO(vo);
		return super.selectList(vo);
	}

	@Override
	public void selectList(final TestAaa002VO vo, final ModelMap model) {
		debugVO(vo);
		super.selectList(vo, model);
	}

	@Override
	public int update(final TestAaa002VO vo) {
		debugVO(vo);
		return super.update(vo);
	}

	@Override
	public void update(final TestAaa002VO vo, final ModelMap model) {
		debugVO(vo);
		super.update(vo, model);
	}

	@Override
	public int delete(final TestAaa002VO vo) {
		debugVO(vo);
		return super.delete(vo);
	}

	@Override
	public void delete(final TestAaa002VO vo, final ModelMap model) {
		debugVO(vo);
		super.delete(vo, model);
	}

	@Override
	public int merge(final TestAaa002VO vo) {
		debugVO(vo);
		return super.merge(vo);
	}

	@Override
	public void merge(final TestAaa002VO vo, final ModelMap model) {
		debugVO(vo);
		super.merge(vo, model);
	}

	@Override
	public int multi(final TestAaa002VO vo) {
		debugVO(vo);
		return super.multi(vo);
	}

	@Override
	public void multi(final TestAaa002VO vo, final ModelMap model) {
		debugVO(vo);
		super.multi(vo, model);
	}

	@Override
	public int selectListTotCnt(final TestAaa002VO vo) {
		debugVO(vo);
		return super.selectListTotCnt(vo);
	}

	@Override
	public int insert2(final TestAaa002VO vo) {
		return dao.insert2(vo);
	}

	@Override
	public void insert2(final TestAaa002VO vo, final ModelMap model) {
		model.addAttribute(MODEL_RESULT, dao.insert2(vo));
	}

	@Override
	public TestAaa002VO select2(final TestAaa002VO vo) {
		return dao.select2(vo);
	}

	@Override
	public void select2(final TestAaa002VO vo, final ModelMap model) {
		model.addAttribute(MODEL_RESULT, dao.select2(vo));
	}

	@Override
	public List<TestAaa002VO> select2List(final TestAaa002VO vo) {
		return dao.select2List(vo);
	}

	@Override
	public void select2List(final TestAaa002VO vo, final ModelMap model) {
		model.addAttribute("resultList", dao.select2List(vo));
	}

	@Override
	public int update2(final TestAaa002VO vo) {
		return dao.update2(vo);
	}

	@Override
	public void update2(final TestAaa002VO vo, final ModelMap model) {
		model.addAttribute(MODEL_RESULT, dao.update2(vo));
	}

	@Override
	public int delete2(final TestAaa002VO vo) {
		return dao.delete2(vo);
	}

	@Override
	public void delete2(final TestAaa002VO vo, final ModelMap model) {
		model.addAttribute(MODEL_RESULT, dao.delete2(vo));
	}

	@Override
	public int merge2(final TestAaa002VO vo) {
		return dao.merge2(vo);
	}

	@Override
	public void merge2(final TestAaa002VO vo, final ModelMap model) {
		model.addAttribute(MODEL_RESULT, dao.merge2(vo));
	}

	@Override
	public int multi2(final TestAaa002VO vo) {
		return dao.multi2(vo);
	}

	@Override
	public void multi2(final TestAaa002VO vo, final ModelMap model) {
		model.addAttribute(MODEL_RESULT, dao.multi2(vo));
	}

	@Override
	public int select2ListTotCnt(final TestAaa002VO vo) {
		return dao.select2ListTotCnt(vo);
	}

}
