package god.data.a.a.a.service;

import java.util.List;

/**
 * 공통상세코드 Service
 * 
 * @author 이백행
 * @since 2024-07-26
 *
 */
public interface DataAaaService {

	/**
	 * 공통상세코드 조회(멀티건)
	 * 
	 * @param dataAaaRequestVO
	 * @return
	 */
	List<DataAaaResponseVO> selectList(DataAaaRequestVO dataAaaRequestVO);

}
