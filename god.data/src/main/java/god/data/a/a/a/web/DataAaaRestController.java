package god.data.a.a.a.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.com.cmm.web.EgovComAbstractController;
import god.data.a.a.a.service.DataAaaRequestMsgBodyDTO;
import god.data.a.a.a.service.DataAaaRequestMsgHeaderDTO;
import god.data.a.a.a.service.DataAaaResponseMsgBodyDTO;
import god.data.a.a.a.service.DataAaaResponseMsgHeaderDTO;
import god.data.a.a.a.service.DataAaaService;
import god.data.cmm.service.DataCmmRequestDTO;
import god.data.cmm.service.DataCmmResponseDTO;
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

	/**
	 * 공통상세코드 Service
	 */
	private final DataAaaService dataAaaService;

	/**
	 * 공통상세코드항목조회
	 * 
	 * @param codeId
	 * @param code
	 * @param requestDTO
	 * @return
	 */
	@GetMapping("/{codeId}/{code}")
	public DataCmmResponseDTO<DataAaaResponseMsgHeaderDTO, DataAaaResponseMsgBodyDTO> getDataAaaItem(
			@PathVariable final String codeId, @PathVariable final String code,
			final DataCmmRequestDTO<DataAaaRequestMsgHeaderDTO, DataAaaRequestMsgBodyDTO> requestDTO) {
		log(codeId, code, requestDTO);
		logComMsgHeader(requestDTO);
		logMsgHeader(requestDTO);
		logMsgBody(requestDTO);

		final DataCmmResponseDTO<DataAaaResponseMsgHeaderDTO, DataAaaResponseMsgBodyDTO> responseDTO = dataAaaService
				.selectDataAaa(requestDTO);

		log(responseDTO);
		logComMsgHeader(responseDTO);
		logMsgHeader(responseDTO);
		logMsgBody(responseDTO);

		return responseDTO;
	}

	private void log(final String codeId, final String code,
			final DataCmmRequestDTO<DataAaaRequestMsgHeaderDTO, DataAaaRequestMsgBodyDTO> requestDTO) {
		if (log.isDebugEnabled()) {
			log.debug("codeId={}", codeId);
			log.debug("code={}", code);

			log.debug("requestDTO={}", requestDTO);
		}
	}

	private void logComMsgHeader(
			final DataCmmRequestDTO<DataAaaRequestMsgHeaderDTO, DataAaaRequestMsgBodyDTO> requestDTO) {
		if (log.isDebugEnabled()) {
			log.debug("getComMsgHeader={}", requestDTO.getComMsgHeader());
		}
		if (requestDTO.getComMsgHeader() != null && log.isDebugEnabled()) {
			log.debug("getServiceKey={}", requestDTO.getComMsgHeader().getServiceKey());
			log.debug("getRequestTime={}", requestDTO.getComMsgHeader().getRequestTime());
			log.debug("getCallBackURI={}", requestDTO.getComMsgHeader().getCallBackURI());
			log.debug("getRequestMsgID={}", requestDTO.getComMsgHeader().getRequestMsgID());
		}
	}

	private void logMsgHeader(
			final DataCmmRequestDTO<DataAaaRequestMsgHeaderDTO, DataAaaRequestMsgBodyDTO> requestDTO) {
		if (log.isDebugEnabled()) {
			log.debug("getMsgHeader={}", requestDTO.getMsgHeader());
		}
		if (requestDTO.getMsgHeader() != null && log.isDebugEnabled()) {
			log.debug("getHeader={}", requestDTO.getMsgHeader().getHeader());
		}
	}

	private void logMsgBody(final DataCmmRequestDTO<DataAaaRequestMsgHeaderDTO, DataAaaRequestMsgBodyDTO> requestDTO) {
		if (log.isDebugEnabled()) {
			log.debug("getMsgBody={}", requestDTO.getMsgBody());
		}
		if (requestDTO.getMsgBody() != null && log.isDebugEnabled()) {
			log.debug("getCodeId={}", requestDTO.getMsgBody().getCodeId());
			log.debug("getCode={}", requestDTO.getMsgBody().getCode());
		}
	}

	private void log(final DataCmmResponseDTO<DataAaaResponseMsgHeaderDTO, DataAaaResponseMsgBodyDTO> responseDTO) {
		if (log.isDebugEnabled()) {
			log.debug("responseDTO={}", responseDTO);
		}
	}

	private void logComMsgHeader(
			final DataCmmResponseDTO<DataAaaResponseMsgHeaderDTO, DataAaaResponseMsgBodyDTO> responseDTO) {
		if (log.isDebugEnabled()) {
			log.debug("getComMsgHeader={}", responseDTO.getComMsgHeader());
		}

		if (responseDTO.getComMsgHeader() != null && log.isDebugEnabled()) {
			log.debug("getRequestMsgID={}", responseDTO.getComMsgHeader().getRequestMsgID());
			log.debug("getResponseTime={}", responseDTO.getComMsgHeader().getResponseTime());
			log.debug("getResponseMsgID={}", responseDTO.getComMsgHeader().getResponseMsgID());
			log.debug("getSuccessYN={}", responseDTO.getComMsgHeader().getSuccessYN());
			log.debug("getReturnCode={}", responseDTO.getComMsgHeader().getReturnCode());
		}
	}

	private void logMsgHeader(
			final DataCmmResponseDTO<DataAaaResponseMsgHeaderDTO, DataAaaResponseMsgBodyDTO> responseDTO) {
		if (log.isDebugEnabled()) {
			log.debug("getMsgHeader={}", responseDTO.getMsgHeader());
		}
		if (responseDTO.getMsgHeader() != null && log.isDebugEnabled()) {
			log.debug("getHeader={}", responseDTO.getMsgHeader().getHeader());
		}
	}

	private void logMsgBody(
			final DataCmmResponseDTO<DataAaaResponseMsgHeaderDTO, DataAaaResponseMsgBodyDTO> responseDTO) {
		if (log.isDebugEnabled()) {
			log.debug("getMsgBody={}", responseDTO.getMsgBody());
		}
		if (responseDTO.getMsgBody() != null && log.isDebugEnabled()) {
			log.debug("getCodeId={}", responseDTO.getMsgBody().getCodeId());
			log.debug("getCode={}", responseDTO.getMsgBody().getCode());
			log.debug("getCodeNm={}", responseDTO.getMsgBody().getCodeNm());
			log.debug("getCodeDc={}", responseDTO.getMsgBody().getCodeDc());
			log.debug("getUseAt={}", responseDTO.getMsgBody().getUseAt());
			log.debug("getFrstRegistPnttm={}", responseDTO.getMsgBody().getFrstRegistPnttm());
			log.debug("getFrstRegisterId={}", responseDTO.getMsgBody().getFrstRegisterId());
			log.debug("getLastUpdtPnttm={}", responseDTO.getMsgBody().getLastUpdtPnttm());
			log.debug("getLastUpdusrId={}", responseDTO.getMsgBody().getLastUpdusrId());
		}
	}

}
