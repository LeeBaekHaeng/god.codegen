package god.data.a.a.a.web;

import java.util.List;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.com.cmm.web.EgovComAbstractController;
import god.data.a.a.a.service.DataAaaRequestVO;
import god.data.a.a.a.service.DataAaaResponseVO;
import god.data.a.a.a.service.DataAaaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 공통상세코드 RestController
 * 
 * @author 이백행
 * @since 2024-07-26
 *
 */
@RestController
@RequiredArgsConstructor
@Slf4j
public class DataAaaRestController extends EgovComAbstractController {

	/**
	 * 공통상세코드 Service
	 */
	private final DataAaaService dataAaaService;

	/**
	 * 공통상세코드 조회(멀티건)
	 * 
	 * @param dataAaaRequestVO
	 * @return
	 */
	@GetMapping("/api/v1/data/aaa")
	public ResponseEntity<List<DataAaaResponseVO>> selectList(final DataAaaRequestVO dataAaaRequestVO) {
		if (log.isDebugEnabled()) {
			log.debug("dataAaaRequestVO={}", dataAaaRequestVO);
		}
		final PaginationInfo paginationInfo = builderPaginationInfo(dataAaaRequestVO);
		if (log.isDebugEnabled()) {
			log.debug("paginationInfo={}", paginationInfo);
		}
		return ResponseEntity.ok(dataAaaService.selectList(dataAaaRequestVO));
	}

}
