package god.test.a.a.a.service.impl;

import javax.annotation.PostConstruct;

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

	/**
	 * 행정코드 등록
	 */
	@Override
	public int insert(final GodTestAaa002VO vo) {
		log.debug("vo={}", vo);
		return super.insert(vo);
	}

}
