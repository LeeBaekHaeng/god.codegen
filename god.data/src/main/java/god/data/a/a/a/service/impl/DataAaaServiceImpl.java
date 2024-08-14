package god.data.a.a.a.service.impl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import god.data.a.a.a.service.DataAaaRequestDTO;
import god.data.a.a.a.service.DataAaaResponseMsgBodyDTO;
import god.data.a.a.a.service.DataAaaResponseMsgHeaderDTO;
import god.data.a.a.a.service.DataAaaService;
import god.data.a.a.a.service.DataAaaVO;
import god.data.cmm.service.DataCmmResponseDTO;
import god.data.cmm.service.DataCmmResponseDTO.ComMsgHeader;
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
	public DataCmmResponseDTO<DataAaaResponseMsgHeaderDTO, DataAaaResponseMsgBodyDTO> selectDataAaa(
			final DataAaaRequestDTO requestDTO) {
		if (log.isDebugEnabled()) {
			log.debug("requestDTO={}", requestDTO);
		}

		final DataAaaVO dataAaaVO = DataAaaVO.builder()
//				.codeId(requestDTO.getMsgBody().getCodeId())
//				.code(requestDTO.getMsgBody().getCode())
				.build();

		final DataAaaVO result = dataAaaDAO.selectDataAaa(dataAaaVO);

		return DataCmmResponseDTO.<DataAaaResponseMsgHeaderDTO, DataAaaResponseMsgBodyDTO>builder()
				.comMsgHeader(ComMsgHeader.builder().requestMsgID(requestDTO.getComMsgHeader().getRequestMsgID())
						.responseTime(LocalDateTime.now().toString()).responseMsgID(UUID.randomUUID().toString())
						.successYN(result != null ? "Y" : "N").returnCode("00").build())
				.msgHeader(DataAaaResponseMsgHeaderDTO.builder().header("test 이백행 헤더").build())
				.msgBody(DataAaaResponseMsgBodyDTO.builder().codeId(result.getCodeId()).code(result.getCode())
						.codeNm(result.getCodeNm()).codeDc(result.getCodeDc()).useAt(result.getUseAt())
						.frstRegistPnttm(result.getFrstRegistPnttm()).frstRegisterId(result.getFrstRegisterId())
						.lastUpdtPnttm(result.getLastUpdtPnttm()).lastUpdusrId(result.getLastUpdusrId()).build())
				.build();
	}

}
