package god.data.cmm.service;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 요청 메시지
 * 
 * @author 이백행
 * @since 2024-08-02
 *
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class DataCmmRequestDTO<H, B> {

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
	 * 공유서비스 공통 메시지헤더.서비스 사용자별 서비스통합인증키 값읽기
	 * 
	 * @return
	 */
	public String getComMsgHeaderServiceKey() {
		return this.comMsgHeader.getServiceKey();
	}

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
		 * 서비스 사용자별 서비스통합인증키
		 */
		private String serviceKey;

		/**
		 * 메시지요청일시
		 */
		private String requestTime;

		/**
		 * CallBack서비스URI
		 */
		private String callBackURI;

		/**
		 * 요청 메시지 ID
		 */
		private String requestMsgID;

		/**
		 * 
		 * @param serviceKey
		 * @param requestTime
		 * @param callBackURI
		 * @param requestMsgID
		 */
		@Builder
		public ComMsgHeader(final String serviceKey, final String requestTime, final String callBackURI,
				final String requestMsgID) {
			super();
			this.serviceKey = serviceKey;
			this.requestTime = requestTime;
			this.callBackURI = callBackURI;
			this.requestMsgID = requestMsgID;
		}

	}

}
