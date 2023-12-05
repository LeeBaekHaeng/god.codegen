package god.test.a.a.a.service.impl;

import god.core.cmm.service.impl.GodCoreCmmAbstractServiceImpl;
import god.test.a.a.a.service.GodTestAaa002Service;
import god.test.a.a.a.service.GodTestAaa002VO;
import lombok.RequiredArgsConstructor;

/**
 * 행정코드 ServiceImpl
 * 
 * @author 이백행
 * @since 2023-12-06
 */
@RequiredArgsConstructor
public class GodTestAaa002ServiceImpl extends GodCoreCmmAbstractServiceImpl<GodTestAaa002VO, GodTestAaa002VO>
		implements GodTestAaa002Service {

	/**
	 * 행정코드 등록
	 */
	@Override
	public int insert(GodTestAaa002VO vo) {
		return super.insert(vo);
	}

}
