package god.data.a.a.a.service.impl;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import god.data.a.a.a.service.DataAaaVO;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 공통상세코드 DAO
 * 
 * @author 이백행
 * @since 2024-07-26
 *
 */
@Repository
@NoArgsConstructor
@Slf4j
public class DataAaaDAO extends EgovComAbstractDAO {

	/**
	 * 공통상세코드 조회(단건)
	 * 
	 * @param dataAaaVO
	 * @return
	 */
	public DataAaaVO selectDataAaa(final DataAaaVO dataAaaVO) {
		if (log.isDebugEnabled()) {
			log.debug("dataAaaVO={}", dataAaaVO);
			log.debug("getCodeId={}", dataAaaVO.getCodeId());
			log.debug("getCode={}", dataAaaVO.getCode());
		}
		return selectOne("DataAaaDAO.select", dataAaaVO);
	}

}
