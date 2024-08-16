package god.data.a.a.a.service;

import god.data.a.a.a.service.DataAaaRequestDTO.MsgBody;
import god.data.a.a.a.service.DataAaaRequestDTO.MsgHeader;
import god.data.cmm.service.DataCmmRequestDTO;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 공통상세코드 요청 메시지
 * 
 * @author 이백행
 * @since 2024-08-14
 *
 */
public class DataAaaRequestDTO extends DataCmmRequestDTO<MsgHeader, MsgBody> {

	/**
	 * 
	 * @param comMsgHeader
	 * @param msgHeader
	 * @param msgBody
	 */
	@Builder
	public DataAaaRequestDTO(final ComMsgHeader comMsgHeader, final MsgHeader msgHeader, final MsgBody msgBody) {
		super();
		this.comMsgHeader = comMsgHeader;
		this.msgHeader = msgHeader;
		this.msgBody = msgBody;
	}

	/**
	 * 공통상세코드 요청 제공 기관별 공통 메시지헤더
	 * 
	 * @author 이백행
	 * @since 2024-08-14
	 *
	 */
	@Getter
	@Setter
	@ToString
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class MsgHeader {

		/**
		 * 
		 */
		private String header;

		/**
		 * 
		 * @param header
		 */
		@Builder
		public MsgHeader(final String header) {
			super();
			this.header = header;
		}

	}

	/**
	 * 공통상세코드 요청 서비스별 개별 메시지바디
	 * 
	 * @author 이백행
	 * @since 2024-08-14
	 *
	 */
	@Getter
	@Setter
	@ToString
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class MsgBody {

		/**
		 * 코드ID
		 * 
		 * @컬럼 `CODE_ID` varchar(6) NOT NULL COMMENT '코드ID',
		 */
		private String codeId;

		/**
		 * 코드
		 * 
		 * @컬럼 `CODE` varchar(15) NOT NULL COMMENT '코드',
		 */
		private String code;

		/**
		 * 
		 * @param codeId
		 * @param code
		 */
		@Builder
		public MsgBody(final String codeId, final String code) {
			super();
			this.codeId = codeId;
			this.code = code;
		}

	}

}
