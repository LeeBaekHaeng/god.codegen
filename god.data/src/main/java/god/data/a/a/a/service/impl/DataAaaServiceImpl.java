package god.data.a.a.a.service.impl;

import java.util.List;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import god.data.a.a.a.service.DataAaaRequestVO;
import god.data.a.a.a.service.DataAaaResponseVO;
import god.data.a.a.a.service.DataAaaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 공통상세코드 ServiceImpl
 * 
 * @author 이백행
 * @since 2024-07-26
 *
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class DataAaaServiceImpl extends EgovAbstractServiceImpl implements DataAaaService {

	/**
	 * 공통상세코드 DAO
	 */
	private final DataAaaDAO dataAaaDAO;

	@Override
	public List<DataAaaResponseVO> selectList(final DataAaaRequestVO dataAaaRequestVO) {
		if (log.isDebugEnabled()) {
			log.debug("dataAaaRequestVO={}", dataAaaRequestVO);
		}
		return dataAaaDAO.selectList(dataAaaRequestVO);
	}

}
