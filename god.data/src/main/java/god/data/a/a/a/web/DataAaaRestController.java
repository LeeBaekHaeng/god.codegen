package god.data.a.a.a.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.com.cmm.web.EgovComAbstractController;
import god.data.a.a.a.service.DataAaaRequestDTO;
import god.data.a.a.a.service.DataAaaRequestDTO.MsgBody;
import god.data.a.a.a.service.DataAaaRequestDTO.MsgHeader;
import god.data.a.a.a.service.DataAaaResponseDTO;
import god.data.cmm.service.DataCmmRequestDTO.ComMsgHeader;
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
@RequestMapping("/api/v1/data/aaa")
@RequiredArgsConstructor
@Slf4j
public class DataAaaRestController extends EgovComAbstractController {

//	/**
//	 * 공통상세코드 Service
//	 */
//	private final DataAaaService dataAaaService;

	/**
	 * 공통상세코드항목조회
	 * 
	 * @param codeId
	 * @param code
	 * @param requestDTO
	 * @return
	 */
	@GetMapping("/{codeId}/{code}")
	public DataAaaResponseDTO getDataAaaItem(@PathVariable final String codeId, @PathVariable final String code,
			final DataAaaRequestDTO requestDTO) {
		log(codeId, code, requestDTO);
		logComMsgHeader(requestDTO.getComMsgHeader());
		logMsgHeader(requestDTO.getMsgHeader());
		logMsgBody(requestDTO.getMsgBody());

//		final DataCmmResponseDTO<DataAaaResponseMsgHeaderDTO, DataAaaResponseMsgBodyDTO> responseDTO = dataAaaService
//				.selectDataAaa(requestDTO);
//
//		log(responseDTO);
//		logComMsgHeader(responseDTO);
//		logMsgHeader(responseDTO);
//		logMsgBody(responseDTO);
//
//		return responseDTO;

		return null;
	}

	private void log(final String codeId, final String code, final DataAaaRequestDTO requestDTO) {
		if (log.isDebugEnabled()) {
			log.debug("codeId={}", codeId);
			log.debug("code={}", code);

			log.debug("requestDTO={}", requestDTO);
		}
	}

	private void logComMsgHeader(final ComMsgHeader comMsgHeader) {
		if (log.isDebugEnabled()) {
			log.debug("comMsgHeader={}", comMsgHeader);
			if (comMsgHeader != null && log.isDebugEnabled()) {
				log.debug("getServiceKey={}", comMsgHeader.getServiceKey());
				log.debug("getRequestTime={}", comMsgHeader.getRequestTime());
				log.debug("getCallBackURI={}", comMsgHeader.getCallBackURI());
				log.debug("getRequestMsgID={}", comMsgHeader.getRequestMsgID());
			}
		}
	}

	private void logMsgHeader(final MsgHeader msgHeader) {
		if (log.isDebugEnabled()) {
			log.debug("msgHeader={}", msgHeader);
			if (msgHeader != null && log.isDebugEnabled()) {
				log.debug("getHeader={}", msgHeader.getHeader());
			}
		}
	}

	private void logMsgBody(final MsgBody msgBody) {
		if (log.isDebugEnabled()) {
			log.debug("msgBody={}", msgBody);
			if (msgBody != null && log.isDebugEnabled()) {
				log.debug("getCodeId={}", msgBody.getCodeId());
				log.debug("getCode={}", msgBody.getCode());
			}
		}
	}

//	private void log(final DataCmmResponseDTO<DataAaaResponseMsgHeaderDTO, DataAaaResponseMsgBodyDTO> responseDTO) {
//		if (log.isDebugEnabled()) {
//			log.debug("responseDTO={}", responseDTO);
//		}
//	}
//
//	private void logComMsgHeader(
//			final DataCmmResponseDTO<DataAaaResponseMsgHeaderDTO, DataAaaResponseMsgBodyDTO> responseDTO) {
//		if (log.isDebugEnabled()) {
//			log.debug("getComMsgHeader={}", responseDTO.getComMsgHeader());
//		}
//
//		if (responseDTO.getComMsgHeader() != null && log.isDebugEnabled()) {
//			log.debug("getRequestMsgID={}", responseDTO.getComMsgHeader().getRequestMsgID());
//			log.debug("getResponseTime={}", responseDTO.getComMsgHeader().getResponseTime());
//			log.debug("getResponseMsgID={}", responseDTO.getComMsgHeader().getResponseMsgID());
//			log.debug("getSuccessYN={}", responseDTO.getComMsgHeader().getSuccessYN());
//			log.debug("getReturnCode={}", responseDTO.getComMsgHeader().getReturnCode());
//		}
//	}
//
//	private void logMsgHeader(
//			final DataCmmResponseDTO<DataAaaResponseMsgHeaderDTO, DataAaaResponseMsgBodyDTO> responseDTO) {
//		if (log.isDebugEnabled()) {
//			log.debug("getMsgHeader={}", responseDTO.getMsgHeader());
//		}
//		if (responseDTO.getMsgHeader() != null && log.isDebugEnabled()) {
//			log.debug("getHeader={}", responseDTO.getMsgHeader().getHeader());
//		}
//	}
//
//	private void logMsgBody(
//			final DataCmmResponseDTO<DataAaaResponseMsgHeaderDTO, DataAaaResponseMsgBodyDTO> responseDTO) {
//		if (log.isDebugEnabled()) {
//			log.debug("getMsgBody={}", responseDTO.getMsgBody());
//		}
//		if (responseDTO.getMsgBody() != null && log.isDebugEnabled()) {
//			log.debug("getCodeId={}", responseDTO.getMsgBody().getCodeId());
//			log.debug("getCode={}", responseDTO.getMsgBody().getCode());
//			log.debug("getCodeNm={}", responseDTO.getMsgBody().getCodeNm());
//			log.debug("getCodeDc={}", responseDTO.getMsgBody().getCodeDc());
//			log.debug("getUseAt={}", responseDTO.getMsgBody().getUseAt());
//			log.debug("getFrstRegistPnttm={}", responseDTO.getMsgBody().getFrstRegistPnttm());
//			log.debug("getFrstRegisterId={}", responseDTO.getMsgBody().getFrstRegisterId());
//			log.debug("getLastUpdtPnttm={}", responseDTO.getMsgBody().getLastUpdtPnttm());
//			log.debug("getLastUpdusrId={}", responseDTO.getMsgBody().getLastUpdusrId());
//		}
//	}

}
