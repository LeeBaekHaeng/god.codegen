package god.test.a.a.a.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import god.core.cmm.service.impl.GodCoreCmmAbstractServiceImpl;
import god.test.a.a.a.service.TestAaa002Service;
import god.test.a.a.a.service.TestAaa002VO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 행정코드 ServiceImpl
 * 
 * @author 이백행
 * @since 2023-12-06
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class TestAaa002ServiceImpl extends GodCoreCmmAbstractServiceImpl<TestAaa002VO, TestAaa002VO>
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
		log.debug("vo={}", vo);
		return super.insert(vo);
	}

	@Override
	public TestAaa002VO select(final TestAaa002VO vo) {
		log.debug("vo={}", vo);
		return super.select(vo);
	}

	@Override
	public List<TestAaa002VO> selectList(final TestAaa002VO vo) {
		log.debug("vo={}", vo);
		return super.selectList(vo);
	}

	@Override
	public int update(final TestAaa002VO vo) {
		log.debug("vo={}", vo);
		return super.update(vo);
	}

	@Override
	public int delete(final TestAaa002VO vo) {
		log.debug("vo={}", vo);
		return super.delete(vo);
	}

	@Override
	public int merge(final TestAaa002VO vo) {
		log.debug("vo={}", vo);
		return super.merge(vo);
	}

	@Override
	public int multi(final TestAaa002VO vo) {
		log.debug("vo={}", vo);
		return super.multi(vo);
	}

	@Override
	public int selectListTotCnt(final TestAaa002VO vo) {
		log.debug("vo={}", vo);
		return super.selectListTotCnt(vo);
	}

	@Override
	public void insert(final TestAaa002VO vo, final ModelMap model) {
		log.debug("vo={}", vo);
		super.insert(vo, model);
	}

	@Override
	public void select(final TestAaa002VO vo, final ModelMap model) {
		log.debug("vo={}", vo);
		super.select(vo, model);
	}

	@Override
	public void selectList(final TestAaa002VO vo, final ModelMap model) {
		log.debug("vo={}", vo);
		super.selectList(vo, model);
	}

	@Override
	public void update(final TestAaa002VO vo, final ModelMap model) {
		log.debug("vo={}", vo);
		super.update(vo, model);
	}

	@Override
	public void delete(final TestAaa002VO vo, final ModelMap model) {
		log.debug("vo={}", vo);
		super.delete(vo, model);
	}

	@Override
	public void merge(final TestAaa002VO vo, final ModelMap model) {
		log.debug("vo={}", vo);
		super.merge(vo, model);
	}

	@Override
	public void multi(final TestAaa002VO vo, final ModelMap model) {
		log.debug("vo={}", vo);
		super.multi(vo, model);
	}

	@Override
	public int insert2(final TestAaa002VO vo) {
		return dao.insert2(vo);
	}

	@Override
	public TestAaa002VO select2(final TestAaa002VO vo) {
		return dao.select2(vo);
	}

	@Override
	public List<TestAaa002VO> select2List(final TestAaa002VO vo) {
		return dao.select2List(vo);
	}

	@Override
	public int update2(final TestAaa002VO vo) {
		return dao.update2(vo);
	}

	@Override
	public int delete2(final TestAaa002VO vo) {
		return dao.delete2(vo);
	}

	@Override
	public int merge2(final TestAaa002VO vo) {
		return dao.merge2(vo);
	}

	@Override
	public int multi2(final TestAaa002VO vo) {
		return dao.multi2(vo);
	}

	@Override
	public int select2ListTotCnt(final TestAaa002VO vo) {
		return dao.select2ListTotCnt(vo);
	}

	@Override
	public void insert2(final TestAaa002VO vo, final ModelMap model) {
		model.addAttribute("result", dao.insert2(vo));
	}

	@Override
	public void select2(final TestAaa002VO vo, final ModelMap model) {
		model.addAttribute("result", dao.select2(vo));
	}

	@Override
	public void select2List(final TestAaa002VO vo, final ModelMap model) {
		model.addAttribute("resultList", dao.select2List(vo));
	}

	@Override
	public void update2(final TestAaa002VO vo, final ModelMap model) {
		model.addAttribute("result", dao.update2(vo));
	}

	@Override
	public void delete2(final TestAaa002VO vo, final ModelMap model) {
		model.addAttribute("result", dao.delete2(vo));
	}

	@Override
	public void merge2(final TestAaa002VO vo, final ModelMap model) {
		model.addAttribute("result", dao.merge2(vo));
	}

	@Override
	public void multi2(final TestAaa002VO vo, final ModelMap model) {
		model.addAttribute("result", dao.multi2(vo));
	}

}
