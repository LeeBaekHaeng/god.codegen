package god.data.cmm.service;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * 요청 메시지
 * 
 * @author 이백행
 * @since 2024-08-02
 *
 */
@Builder
@Getter
@ToString
public class DataCmmRequestDTO<H, B> {

	/**
	 * 공유서비스 공통 메시지헤더
	 */
	private ComMsgHeader comMsgHeader;

	/**
	 * 제공 기관별 공통 메시지헤더
	 */
	private H msgHeader;

	/**
	 * 서비스별 개별 메시지바디
	 */
	private B msgBody;

//	/**
//	 * 공유서비스 공통 메시지헤더 값읽기
//	 * 
//	 * @return
//	 */
//	public ComMsgHeader getComMsgHeader() {
//		return comMsgHeader;
//	}
//
//	/**
//	 * 공유서비스 공통 메시지헤더 값설정
//	 * 
//	 * @param comMsgHeader
//	 */
//	public void setComMsgHeader(final ComMsgHeader comMsgHeader) {
//		this.comMsgHeader = comMsgHeader;
//	}
//
//	/**
//	 * 제공 기관별 공통 메시지헤더 값읽기
//	 * 
//	 * @return
//	 */
//	public T1 getMsgHeader() {
//		return msgHeader;
//	}
//
//	/**
//	 * 제공 기관별 공통 메시지헤더 값설정
//	 * 
//	 * @param msgHeader
//	 */
//	public void setMsgHeader(final T1 msgHeader) {
//		this.msgHeader = msgHeader;
//	}
//
//	/**
//	 * 서비스별 개별 메시지바디 값읽기
//	 * 
//	 * @return
//	 */
//	public T2 getMsgBody() {
//		return msgBody;
//	}
//
//	/**
//	 * 서비스별 개별 메시지바디 값설정
//	 * 
//	 * @param msgBody
//	 */
//	public void setMsgBody(final T2 msgBody) {
//		this.msgBody = msgBody;
//	}

	/**
	 * 공유서비스 공통 메시지헤더
	 * 
	 * @author 이백행
	 * @since 2024-08-02
	 *
	 */
	@Builder
	@Getter
	@ToString
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

//		/**
//		 * 서비스 사용자별 서비스통합인증키 값읽기
//		 */
//		public String getServiceKey() {
//			return serviceKey;
//		}
//
//		/**
//		 * 서비스 사용자별 서비스통합인증키 값설정
//		 * 
//		 * @param serviceKey
//		 */
//		public void setServiceKey(final String serviceKey) {
//			this.serviceKey = serviceKey;
//		}
//
//		/**
//		 * 메시지요청일시 값읽기
//		 * 
//		 * @return
//		 */
//		public String getRequestTime() {
//			return requestTime;
//		}
//
//		/**
//		 * 메시지요청일시 값설정
//		 * 
//		 * @param requestTime
//		 */
//		public void setRequestTime(final String requestTime) {
//			this.requestTime = requestTime;
//		}
//
//		/**
//		 * CallBack서비스URI 값읽기
//		 * 
//		 * @return
//		 */
//		public String getCallBackURI() {
//			return callBackURI;
//		}
//
//		/**
//		 * CallBack서비스URI 값설정
//		 * 
//		 * @param callBackURI
//		 */
//		public void setCallBackURI(final String callBackURI) {
//			this.callBackURI = callBackURI;
//		}
//
//		/**
//		 * 요청 메시지 ID 값읽기
//		 * 
//		 * @return
//		 */
//		public String getRequestMsgID() {
//			return requestMsgID;
//		}
//
//		/**
//		 * 요청 메시지 ID 값설정
//		 * 
//		 * @param requestMsgID
//		 */
//		public void setRequestMsgID(final String requestMsgID) {
//			this.requestMsgID = requestMsgID;
//		}

	}

}
