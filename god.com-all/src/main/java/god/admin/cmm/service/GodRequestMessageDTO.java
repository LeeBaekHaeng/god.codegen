package god.admin.cmm.service;

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
     * 공유서비스 공통 메시지헤더
     * 
     * @author 이백행
     *
     */
    @ToString
    public class ComMsgHeader {

        /**
         * 요청 메시지 ID
         */
        private String requestMsgID;

//        /**
//         * 메시지 응답 일시
//         */
////    private LocalDateTime responseTime;
//        private String responseTime;
//
//        /**
//         * 응답 메시지 ID
//         */
//        private String responseMsgID;
//
//        /**
//         * 처리 성공 여부
//         */
//        private SuccessYN successYN;
//
//        private String successYNName;

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

//        /**
//         * 메시지 응답 일시 값읽기
//         * 
//         * @return
//         */
////    public LocalDateTime getResponseTime() {
//        public String getResponseTime() {
//            return responseTime;
//        }
//
//        /**
//         * 메시지 응답 일시 값설정
//         * 
//         * @param responseTime
//         */
////    public void setResponseTime(LocalDateTime responseTime) {
//        public void setResponseTime(String responseTime) {
//            this.responseTime = responseTime;
//        }
//
//        /**
//         * 응답 메시지 ID 값읽기
//         * 
//         * @return
//         */
//        public String getResponseMsgID() {
//            return responseMsgID;
//        }
//
//        /**
//         * 응답 메시지 ID 값설정
//         * 
//         * @param responseMsgID
//         */
//        public void setResponseMsgID(String responseMsgID) {
//            this.responseMsgID = responseMsgID;
//        }
//
//        public SuccessYN getSuccessYN() {
//            return successYN;
//        }
//
//        public void setSuccessYN(SuccessYN successYN) {
//            this.successYN = successYN;
//            this.successYNName = successYN.getString();
//        }
//
//        public String getSuccessYNName() {
//            return successYNName;
//        }

    }

//    public enum SuccessYN {
//
//        Y("Sucess"), N("Fail");
//
//        private String name;
//
//        SuccessYN(String name) {
//            this.name = name;
//        }
//
//        public String getString() {
//            return name;
//        }
//
//    }

}
