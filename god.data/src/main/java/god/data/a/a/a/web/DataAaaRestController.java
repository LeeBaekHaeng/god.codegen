package god.data.a.a.a.web;

import java.time.LocalDateTime;
import java.util.UUID;

import org.egovframe.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.com.cmm.web.EgovComAbstractController;
import god.data.a.a.a.service.DataAaaRequestVO;
import god.data.a.a.a.service.DataAaaService;
import god.data.cmm.service.DataCmmResponseVO;
import god.data.cmm.service.DataCmmResponseVO.ComMsgHeader;
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
	public DataCmmResponseVO<DataAaaResponseMsgHeader, DataAaaResponseMsgBody> selectList(
			final DataAaaRequestVO dataAaaRequestVO) {
		if (log.isDebugEnabled()) {
			log.debug("dataAaaRequestVO={}", dataAaaRequestVO);
		}

		final DataCmmResponseVO<DataAaaResponseMsgHeader, DataAaaResponseMsgBody> dataCmmResponseVO = new DataCmmResponseVO<>();

		// ComMsgHeader 공유서비스 공통 메시지헤더
		final ComMsgHeader comMsgHeader = new ComMsgHeader();
		comMsgHeader.setResponseTime(LocalDateTime.now().toString());
		comMsgHeader.setResponseMsgID(UUID.randomUUID().toString());
		comMsgHeader.setSuccessYN("Y");
		comMsgHeader.setReturnCode("00");
		dataCmmResponseVO.setComMsgHeader(comMsgHeader);

		final PaginationInfo paginationInfo = builderPaginationInfo(dataAaaRequestVO);
		if (log.isDebugEnabled()) {
			log.debug("paginationInfo={}", paginationInfo);
		}

		// MsgBody 서비스별 개별 메시지바디
		final DataAaaResponseMsgBody msgBody = new DataAaaResponseMsgBody();
		msgBody.setResults(dataAaaService.selectList(dataAaaRequestVO));
		msgBody.setPaginationInfo(paginationInfo);
		dataCmmResponseVO.setMsgBody(msgBody);

		return dataCmmResponseVO;
	}

}
