package god.data.cmm.service;

import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * 응답 메시지
 * 
 * @author 이백행
 * @since 2024-08-02
 *
 */
@NoArgsConstructor
@ToString
public class DataResponseVO<T1, T2> {

	/**
	 * 공유서비스 공통 메시지헤더
	 */
	private ComMsgHeader comMsgHeader;

	/**
	 * 제공 기관별 공통 메시지헤더
	 */
	private T1 msgHeader;

	/**
	 * 서비스별 개별 메시지바디
	 */
	private T2 msgBody;

	/**
	 * 공유서비스 공통 메시지헤더
	 * 
	 * @author 이백행
	 * @since 2024-08-02
	 *
	 */
	@ToString
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
		 * 요청 메시지 ID 값읽기
		 * 
		 * @return
		 */
		public String getRequestMsgID() {
			return requestMsgID;
		}

		/**
		 * 요청 메시지 ID 값설정
		 * 
		 * @param requestMsgID
		 */
		public void setRequestMsgID(String requestMsgID) {
			this.requestMsgID = requestMsgID;
		}

		/**
		 * 메시지 응답 일시 값읽기
		 * 
		 * @return
		 */
		public String getResponseTime() {
			return responseTime;
		}

		/**
		 * 메시지 응답 일시 값설정
		 * 
		 * @param responseTime
		 */
		public void setResponseTime(String responseTime) {
			this.responseTime = responseTime;
		}

		/**
		 * 응답 메시지 ID 값읽기
		 * 
		 * @return
		 */
		public String getResponseMsgID() {
			return responseMsgID;
		}

		/**
		 * 응답 메시지 ID 값설정
		 * 
		 * @param responseMsgID
		 */
		public void setResponseMsgID(String responseMsgID) {
			this.responseMsgID = responseMsgID;
		}

		/**
		 * 처리 성공 여부 값읽기
		 * 
		 * @return
		 */
		public String getSuccessYN() {
			return successYN;
		}

		/**
		 * 처리 성공 여부 값설정
		 * 
		 * @param successYN
		 */
		public void setSuccessYN(String successYN) {
			this.successYN = successYN;
		}

		/**
		 * 리턴 코드 값읽기
		 * 
		 * @return
		 */
		public String getReturnCode() {
			return returnCode;
		}

		/**
		 * 리턴 코드 값설정
		 * 
		 * @param returnCode
		 */
		public void setReturnCode(String returnCode) {
			this.returnCode = returnCode;
		}

		/**
		 * 값읽기
		 * 
		 * @return
		 */
		public String getErrMsg() {
			return errMsg;
		}

		/**
		 * 에러 메시지 값설정
		 * 
		 * @param errMsg
		 */
		public void setErrMsg(String errMsg) {
			this.errMsg = errMsg;
		}

	}

	/**
	 * 공유서비스 공통 메시지헤더 값읽기
	 * 
	 * @return
	 */
	public ComMsgHeader getComMsgHeader() {
		return comMsgHeader;
	}

	/**
	 * 공유서비스 공통 메시지헤더 값설정
	 * 
	 * @param comMsgHeader
	 */
	public void setComMsgHeader(final ComMsgHeader comMsgHeader) {
		this.comMsgHeader = comMsgHeader;
	}

	/**
	 * 제공 기관별 공통 메시지헤더 값읽기
	 * 
	 * @return
	 */
	public T1 getMsgHeader() {
		return msgHeader;
	}

	/**
	 * 제공 기관별 공통 메시지헤더 값설정
	 * 
	 * @param msgHeader
	 */
	public void setMsgHeader(final T1 msgHeader) {
		this.msgHeader = msgHeader;
	}

	/**
	 * 서비스별 개별 메시지바디 값읽기
	 * 
	 * @return
	 */
	public T2 getMsgBody() {
		return msgBody;
	}

	/**
	 * 서비스별 개별 메시지바디 값설정
	 * 
	 * @param msgBody
	 */
	public void setMsgBody(final T2 msgBody) {
		this.msgBody = msgBody;
	}

}
