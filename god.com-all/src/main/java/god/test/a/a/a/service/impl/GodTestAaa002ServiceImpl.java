package god.test.a.a.a.service.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.ui.ModelMap;

import god.core.cmm.service.impl.GodCoreCmmAbstractServiceImpl;
import god.test.a.a.a.service.GodTestAaa002Service;
import god.test.a.a.a.service.GodTestAaa002VO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 행정코드 ServiceImpl
 * 
 * @author 이백행
 * @since 2023-12-06
 */
@RequiredArgsConstructor
@Slf4j
public class GodTestAaa002ServiceImpl extends GodCoreCmmAbstractServiceImpl<GodTestAaa002VO, GodTestAaa002VO>
		implements GodTestAaa002Service {

	/**
	 * 행정코드 DAO
	 */
	private final GodTestAaa002DAO dao;

	/**
	 * 포스트 구성
	 */
	@PostConstruct
	public void postConstruct() {
		super.postConstruct(dao);
	}

	@Override
	public int insert(final GodTestAaa002VO vo) {
		log.debug("vo={}", vo);
		return super.insert(vo);
	}

	@Override
	public void insert(final GodTestAaa002VO vo, final ModelMap model) {
		log.debug("vo={}", vo);
		super.insert(vo, model);
	}

	@Override
	public GodTestAaa002VO select(final GodTestAaa002VO vo) {
		log.debug("vo={}", vo);
		return super.select(vo);
	}

	@Override
	public void select(final GodTestAaa002VO vo, final ModelMap model) {
		log.debug("vo={}", vo);
		super.select(vo, model);
	}

	@Override
	public List<GodTestAaa002VO> selectList(final GodTestAaa002VO vo) {
		log.debug("vo={}", vo);
		return super.selectList(vo);
	}

	@Override
	public void selectList(final GodTestAaa002VO vo, final ModelMap model) {
		log.debug("vo={}", vo);
		super.selectList(vo, model);
	}

	@Override
	public int update(final GodTestAaa002VO vo) {
		log.debug("vo={}", vo);
		return super.update(vo);
	}

	@Override
	public void update(final GodTestAaa002VO vo, final ModelMap model) {
		log.debug("vo={}", vo);
		super.update(vo, model);
	}

	@Override
	public int delete(final GodTestAaa002VO vo) {
		log.debug("vo={}", vo);
		return super.delete(vo);
	}

	@Override
	public void delete(final GodTestAaa002VO vo, final ModelMap model) {
		log.debug("vo={}", vo);
		super.delete(vo, model);
	}

	@Override
	public int merge(final GodTestAaa002VO vo) {
		log.debug("vo={}", vo);
		return super.merge(vo);
	}

	@Override
	public void merge(final GodTestAaa002VO vo, final ModelMap model) {
		log.debug("vo={}", vo);
		super.merge(vo, model);
	}

	@Override
	public int multi(final GodTestAaa002VO vo) {
		log.debug("vo={}", vo);
		return super.multi(vo);
	}

	@Override
	public void multi(final GodTestAaa002VO vo, final ModelMap model) {
		log.debug("vo={}", vo);
		super.multi(vo, model);
	}

	@Override
	public int selectListTotCnt(final GodTestAaa002VO vo) {
		log.debug("vo={}", vo);
		return super.selectListTotCnt(vo);
	}

	@Override
	public int insert2(final GodTestAaa002VO vo) {
		return dao.insert2(vo);
	}

	@Override
	public void insert2(final GodTestAaa002VO vo, final ModelMap model) {
		model.addAttribute("result", dao.insert2(vo));
	}

	@Override
	public GodTestAaa002VO select2(final GodTestAaa002VO vo) {
		return dao.select2(vo);
	}

	@Override
	public void select2(final GodTestAaa002VO vo, final ModelMap model) {
		model.addAttribute("result", dao.select2(vo));
	}

	@Override
	public List<GodTestAaa002VO> select2List(final GodTestAaa002VO vo) {
		return dao.select2List(vo);
	}

	@Override
	public void select2List(final GodTestAaa002VO vo, final ModelMap model) {
		model.addAttribute("resultList", dao.select2List(vo));
	}

	@Override
	public int update2(final GodTestAaa002VO vo) {
		return dao.update2(vo);
	}

	@Override
	public void update2(final GodTestAaa002VO vo, final ModelMap model) {
		model.addAttribute("result", dao.update2(vo));
	}

	@Override
	public int delete2(final GodTestAaa002VO vo) {
		return dao.delete2(vo);
	}

	@Override
	public void delete2(final GodTestAaa002VO vo, final ModelMap model) {
		model.addAttribute("result", dao.delete2(vo));
	}

	@Override
	public int merge2(final GodTestAaa002VO vo) {
		return dao.merge2(vo);
	}

	@Override
	public void merge2(final GodTestAaa002VO vo, final ModelMap model) {
		model.addAttribute("result", dao.merge2(vo));
	}

	@Override
	public int multi2(final GodTestAaa002VO vo) {
		return dao.multi2(vo);
	}

	@Override
	public void multi2(final GodTestAaa002VO vo, final ModelMap model) {
		model.addAttribute("result", dao.multi2(vo));
	}

	@Override
	public int select2ListTotCnt(final GodTestAaa002VO vo) {
		return dao.select2ListTotCnt(vo);
	}

}
