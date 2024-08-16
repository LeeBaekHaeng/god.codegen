package god.data.b.a.a.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import egovframework.com.cmm.web.EgovComAbstractController;
import god.data.a.a.a.service.DataAaaRequestDTO;
import god.data.cmm.service.DataCmmRequestDTO.ComMsgHeader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 공통상세코드 RestController
 * 
 * @author 이백행
 * @since 2024-08-16
 *
 */
@RestController
@RequestMapping("/api/v1/data/baa")
@RequiredArgsConstructor
@Slf4j
public class DataBaaRestController extends EgovComAbstractController {

	/**
	 * 공통상세코드항목조회
	 */
	@GetMapping("/{codeId}/{code}")
	public String getDataBaaItem(@PathVariable final String codeId, @PathVariable final String code,
			final DataAaaRequestDTO requestDTO) {
		if (log.isDebugEnabled()) {
			log.debug("getDataBaaItem");
		}

		log(requestDTO);

		final DataAaaRequestDTO dataAaaRequestDTO = DataAaaRequestDTO.builder().build();
		log2(dataAaaRequestDTO);

		return null;
	}

	private void log(final DataAaaRequestDTO requestDTO) {
		if (log.isDebugEnabled()) {
			log.debug("requestDTO={}", requestDTO);

			log(requestDTO.getComMsgHeader());

			log.debug("getComMsgHeaderServiceKey()={}", requestDTO.getComMsgHeaderServiceKey());
		}
	}

	private void log(final ComMsgHeader comMsgHeader) {
		if (log.isDebugEnabled()) {
			log.debug("comMsgHeader={}", comMsgHeader);
			if (comMsgHeader != null && log.isDebugEnabled()) {
				log.debug("getServiceKey()={}", comMsgHeader.getServiceKey());
			}
		}
	}

	private void log2(final DataAaaRequestDTO dataAaaRequestDTO) {
		if (log.isDebugEnabled()) {
			log.debug("dataAaaRequestDTO={}", dataAaaRequestDTO);

//			log.debug("dataAaaRequestDTO.getComMsgHeader().getServiceKey()={}",
//					dataAaaRequestDTO.getComMsgHeader().getServiceKey());
//
//			final ComMsgHeader comMsgHeader = dataAaaRequestDTO.getComMsgHeader();
//			comMsgHeader.getServiceKey();
//
//			log.debug("comMsgHeader.getServiceKey()={}", comMsgHeader.getServiceKey());
//
//			dataAaaRequestDTO.getComMsgHeaderServiceKey();
//
//			log.debug("dataAaaRequestDTO.getComMsgHeaderServiceKey()={}",
//					dataAaaRequestDTO.getComMsgHeaderServiceKey());
		}
	}

}
