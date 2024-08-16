package god.data.cmm.service;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 응답 메시지
 * 
 * @author 이백행
 * @since 2024-08-02
 *
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class DataCmmResponseDTO<H, B> {

	/**
	 * 공유서비스 공통 메시지헤더
	 */
	protected ComMsgHeader comMsgHeader;

	/**
	 * 제공 기관별 공통 메시지헤더
	 */
	protected H msgHeader;

	/**
	 * 서비스별 개별 메시지바디
	 */
	protected B msgBody;

	/**
	 * 공유서비스 공통 메시지헤더
	 * 
	 * @author 이백행
	 * @since 2024-08-02
	 *
	 */
	@Getter
	@Setter
	@ToString
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	public static class ComMsgHeader {

		/**
		 * 요청 메시지 ID
		 */
		private String requestMsgID;

		/**
		 * 메시지 응답 일시
		 */
		private String responseTime;

		/**
		 * 응답 메시지 ID
		 */
		private String responseMsgID;

		/**
		 * 처리 성공 여부
		 */
		private String successYN;

		/**
		 * 리턴 코드
		 */
		private String returnCode;

		/**
		 * 에러 메시지
		 */
		private String errMsg;

		/**
		 * 
		 * @param requestMsgID
		 * @param responseTime
		 * @param responseMsgID
		 * @param successYN
		 * @param returnCode
		 * @param errMsg
		 */
		@Builder
		public ComMsgHeader(final String requestMsgID, final String responseTime, final String responseMsgID,
				final String successYN, final String returnCode, final String errMsg) {
			super();
			this.requestMsgID = requestMsgID;
			this.responseTime = responseTime;
			this.responseMsgID = responseMsgID;
			this.successYN = successYN;
			this.returnCode = returnCode;
			this.errMsg = errMsg;
		}

	}

}
