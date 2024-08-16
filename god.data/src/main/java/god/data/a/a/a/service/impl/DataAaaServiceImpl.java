package god.data.a.a.a.service.impl;

import java.time.LocalDateTime;
import java.util.UUID;

import org.egovframe.rte.fdl.cmmn.EgovAbstractServiceImpl;
import org.springframework.stereotype.Service;

import god.data.a.a.a.service.DataAaaRequestDTO;
import god.data.a.a.a.service.DataAaaResponseDTO;
import god.data.a.a.a.service.DataAaaService;
import god.data.a.a.a.service.DataAaaVO;
import god.data.cmm.service.DataCmmRequestDTO;
import god.data.cmm.service.DataCmmResponseDTO;
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
	public DataAaaResponseDTO selectDataAaa(final DataAaaRequestDTO requestDTO) {
		if (log.isDebugEnabled()) {
			log.debug("requestDTO={}", requestDTO);
		}

//		final DataAaaVO dataAaaVO = DataAaaVO.builder()
//
//				.codeId(msgBody(requestDTO).getCodeId())
//
//				.code(msgBody(requestDTO).getCode())
//
//				.build();

		final DataAaaVO dataAaaVO = new DataAaaVO();
		dataAaaVO.setCodeId(msgBody(requestDTO).getCodeId());
		dataAaaVO.setCode(msgBody(requestDTO).getCode());

		final DataAaaVO result = dataAaaDAO.selectDataAaa(dataAaaVO);

		return DataAaaResponseDTO.builder()

				.comMsgHeader(comMsgHeader(requestDTO.getComMsgHeader(), result))

				.msgHeader(DataAaaResponseDTO.MsgHeader.builder().header("test 이백행 헤더").build())

				.msgBody(DataAaaResponseDTO.MsgBody.builder()

						.codeId(result.getCodeId())

						.code(result.getCode())

						.codeNm(result.getCodeNm())

						.codeDc(result.getCodeDc())

						.useAt(result.getUseAt())

						.frstRegistPnttm(result.getFrstRegistPnttm())

						.frstRegisterId(result.getFrstRegisterId())

						.lastUpdtPnttm(result.getLastUpdtPnttm()).lastUpdusrId(result.getLastUpdusrId())

						.codeIdNm(result.getCodeIdNm())

						.build())

				.build();
	}

	private DataAaaRequestDTO.MsgBody msgBody(final DataAaaRequestDTO requestDTO) {
		return requestDTO.getMsgBody();
	}

	private DataCmmResponseDTO.ComMsgHeader comMsgHeader(final DataCmmRequestDTO.ComMsgHeader comMsgHeader,
			final DataAaaVO result) {
		return DataCmmResponseDTO.ComMsgHeader.builder()

				.requestMsgID(comMsgHeader.getRequestMsgID())

				.responseTime(LocalDateTime.now().toString())

				.responseMsgID(UUID.randomUUID().toString())

				.successYN(result != null ? "Y" : "N")

				.returnCode("00")

				.build();
	}

}
