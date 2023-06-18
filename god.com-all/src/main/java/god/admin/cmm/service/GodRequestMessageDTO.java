package god.admin.cmm.service;

import org.apache.poi.ss.formula.functions.T;

import lombok.ToString;

/**
 * 요청 메시지
 * 
 * 
 * @author 이백행
 *
 */
@ToString
public class GodRequestMessageDTO {

    /**
     * 공유서비스 공통 메시지헤더
     */
    private ComMsgHeader comMsgHeader = new ComMsgHeader();

    /**
     * 제공 기관별 공통 메시지헤더
     */
    private MsgHeader msgHeader = new MsgHeader();

    /**
     * 서비스별 개별 메시지바디
     */
    private T msgBody;

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
    public void setComMsgHeader(ComMsgHeader comMsgHeader) {
        this.comMsgHeader = comMsgHeader;
    }

    /**
     * 제공 기관별 공통 메시지헤더 값읽기
     * 
     * @return
     */
    public MsgHeader getMsgHeader() {
        return msgHeader;
    }

    /**
     * 제공 기관별 공통 메시지헤더 값설정
     * 
     * @param msgHeader
     */
    public void setMsgHeader(MsgHeader msgHeader) {
        this.msgHeader = msgHeader;
    }

    /**
     * 서비스별 개별 메시지바디 값읽기
     * 
     * @return
     */
    public T getMsgBody() {
        return msgBody;
    }

    /**
     * 서비스별 개별 메시지바디 값설정
     * 
     * @param msgBody
     */
    public void setMsgBody(T msgBody) {
        this.msgBody = msgBody;
    }

    /**
     * 공유서비스 공통 메시지헤더
     * 
     * @author 이백행
     *
     */
    @ToString
    public class ComMsgHeader {

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
         * 서비스 사용자별 서비스통합인증키 값읽기
         * 
         * @return
         */
        public String getServiceKey() {
            return serviceKey;
        }

        /**
         * 서비스 사용자별 서비스통합인증키 값설정
         * 
         * @param serviceKey
         */
        public void setServiceKey(String serviceKey) {
            this.serviceKey = serviceKey;
        }

        /**
         * 메시지요청일시 값읽기
         * 
         * @return
         */
        public String getRequestTime() {
            return requestTime;
        }

        /**
         * 메시지요청일시 값설정
         * 
         * @param requestTime
         */
        public void setRequestTime(String requestTime) {
            this.requestTime = requestTime;
        }

        /**
         * CallBack서비스URI 값읽기
         * 
         * @return
         */
        public String getCallBackURI() {
            return callBackURI;
        }

        /**
         * CallBack서비스URI 값설정
         * 
         * @param callBackURI
         */
        public void setCallBackURI(String callBackURI) {
            this.callBackURI = callBackURI;
        }

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

    }

    /**
     * 제공 기관별 공통 메시지헤더
     * 
     * @author 이백행
     *
     */
    static class MsgHeader {

    }

}
