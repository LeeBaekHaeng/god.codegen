package god.data.a.a.a.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import egovframework.com.cmm.service.impl.EgovComAbstractDAO;
import god.data.a.a.a.service.DataAaaRequestVO;
import god.data.a.a.a.service.DataAaaResponseVO;
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
	 * 공통상세코드 조회(멀티건)
	 * 
	 * @param dataAaaRequestVO
	 * @return
	 */
	public List<DataAaaResponseVO> selectList(final DataAaaRequestVO dataAaaRequestVO) {
		if (log.isDebugEnabled()) {
			log.debug("dataAaaRequestVO={}", dataAaaRequestVO);
		}
		return selectList("DataAaaDAO.selectList", dataAaaRequestVO);
	}

}
