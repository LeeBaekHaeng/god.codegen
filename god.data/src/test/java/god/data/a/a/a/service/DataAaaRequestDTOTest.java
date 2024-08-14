package god.data.a.a.a.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.Test;

import god.data.a.a.a.service.DataAaaRequestDTO.MsgBody;
import god.data.a.a.a.service.DataAaaRequestDTO.MsgHeader;
import god.data.cmm.service.DataCmmRequestDTO;
import god.data.cmm.service.DataCmmRequestDTO.ComMsgHeader;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author 이백행
 * @since 2024-08-14
 *
 */
@Slf4j
public class DataAaaRequestDTOTest {

	/**
	 * 
	 */
	@Test
	public void test() {
		final DataCmmRequestDTO<MsgHeader, MsgBody> requestDTO = DataAaaRequestDTO.<MsgHeader, MsgBody>builder()

				.comMsgHeader(ComMsgHeader.builder()

						.serviceKey("서비스 사용자별 서비스통합인증키").requestTime(LocalDateTime.now().toString())
						.callBackURI("CallBack서비스URI").requestMsgID(UUID.randomUUID().toString())

						.build())

				.msgHeader(MsgHeader.builder()

						.header("test 이백행 2024-08-14 헤더")

						.build())

				.msgBody(MsgBody.builder()

						.codeId("COM001").code("REGC01")

						.build())

				.build();

		if (log.isDebugEnabled()) {
			log.debug("requestDTO={}", requestDTO);

			log.debug("getComMsgHeader={}", requestDTO.getComMsgHeader());
			log.debug("getServiceKey={}", requestDTO.getComMsgHeader().getServiceKey());
			log.debug("getRequestTime={}", requestDTO.getComMsgHeader().getRequestTime());
			log.debug("getCallBackURI={}", requestDTO.getComMsgHeader().getCallBackURI());
			log.debug("getRequestMsgID={}", requestDTO.getComMsgHeader().getRequestMsgID());

			log.debug("getMsgHeader={}", requestDTO.getMsgHeader());
			log.debug("getHeader={}", requestDTO.getMsgHeader().getHeader());

			log.debug("getMsgBody={}", requestDTO.getMsgBody());
			log.debug("getCodeId={}", requestDTO.getMsgBody().getCodeId());
			log.debug("getCode={}", requestDTO.getMsgBody().getCode());
		}

		assertEquals("", "", "");
	}

}
