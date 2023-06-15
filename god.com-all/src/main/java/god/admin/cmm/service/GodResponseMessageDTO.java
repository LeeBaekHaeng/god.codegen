package god.admin.cmm.service;

import org.springframework.ui.ModelMap;

/**
 * 응답 메시지
 * 
 * 
 * @author 이백행
 *
 */
//@ToString
public class GodResponseMessageDTO {

    /**
     * 공유서비스 공통 메시지헤더
     */
    private ComMsgHeader comMsgHeader = new ComMsgHeader();

    /**
     * 제공 기관별 자체 공통 메시지헤더
     */
    private MsgHeader msgHeader = new MsgHeader();

    /**
     * 서비스별 개별 메시지바디
     */
    private ModelMap msgBody = new ModelMap();

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
     * 제공 기관별 자체 공통 메시지헤더 값읽기
     * 
     * @return
     */
    public MsgHeader getMsgHeader() {
        return msgHeader;
    }

    /**
     * 제공 기관별 자체 공통 메시지헤더 값설정
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
    public ModelMap getMsgBody() {
        return msgBody;
    }

    /**
     * 서비스별 개별 메시지바디 값설정
     * 
     * @param msgBody
     */
    public void setMsgBody(ModelMap msgBody) {
        this.msgBody = msgBody;
    }

    /**
     * 공유서비스 공통 메시지헤더
     * 
     * @author 이백행
     *
     */
//    @ToString
    static public class ComMsgHeader {

        /**
         * 요청 메시지 ID
         */
        private String requestMsgID;

        /**
         * 메시지 응답 일시
         */
//    private LocalDateTime responseTime;
        private String responseTime;

        /**
         * 응답 메시지 ID
         */
        private String responseMsgID;

        /**
         * 처리 성공 여부
         */
        private SuccessYN successYN;

        /**
         * 처리 성공 여부명
         */
        private String successYNName;

        /**
         * 리턴 코드
         */
        private ReturnCode returnCode;

        /**
         * 리턴 코드명
         */
        private String returnCodeName;

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
        public void setRequestMsgID(final String requestMsgID) {
            this.requestMsgID = requestMsgID;
        }

        /**
         * 메시지 응답 일시 값읽기
         * 
         * @return
         */
//    public LocalDateTime getResponseTime() {
        public String getResponseTime() {
            return responseTime;
        }

        /**
         * 메시지 응답 일시 값설정
         * 
         * @param responseTime
         */
//    public void setResponseTime(LocalDateTime responseTime) {
        public void setResponseTime(final String responseTime) {
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
        public void setResponseMsgID(final String responseMsgID) {
            this.responseMsgID = responseMsgID;
        }

        /**
         * 처리 성공 여부 값읽기
         * 
         * @return
         */
        public SuccessYN getSuccessYN() {
            return successYN;
        }

        /**
         * 처리 성공 여부 값설정
         * 
         * @param successYN
         */
        public void setSuccessYN(final SuccessYN successYN) {
            this.successYN = successYN;
            this.successYNName = successYN.getName();
        }

        /**
         * 처리 성공 여부명 값읽기
         * 
         * @return
         */
        public String getSuccessYNName() {
            return successYNName;
        }

        /**
         * 처리 성공 여부 값설정
         * 
         * @param successYNName
         */
        public void setSuccessYNName(final String successYNName) {
            this.successYNName = successYNName;
        }

        /**
         * 리턴 코드 값읽기
         * 
         * @return
         */
        public ReturnCode getReturnCode() {
            return returnCode;
        }

        /**
         * 리턴 코드 값설정
         * 
         * @param returnCode
         */
        public void setReturnCode(final ReturnCode returnCode) {
            this.returnCode = returnCode;
            this.returnCodeName = returnCode.getName();
        }

        /**
         * 리턴 코드명 값읽기
         * 
         * @return
         */
        public String getReturnCodeName() {
            return returnCodeName;
        }

        /**
         * 리턴 코드명 값설정
         * 
         * @param returnCodeName
         */
        public void setReturnCodeName(final String returnCodeName) {
            this.returnCodeName = returnCodeName;
        }

        /**
         * 에러 메시지 값읽기
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
     * 처리 성공 여부 enum
     * 
     * @author 이백행
     */
//    @ToString
    public enum SuccessYN {

        /**
         * 'Y' : Sucess
         */
        Y("Sucess"),

        /**
         * 'N' : Fail
         */
        N("Fail"),

        ;

        /**
         * 처리 성공 여부명
         */
        private String name;

        /**
         * 처리 성공 여부명 생성자
         * 
         * @param name
         */
        SuccessYN(final String name) {
            this.name = name;
        }

        /**
         * 처리 성공 여부명 값읽기
         * 
         * @return
         */
        public String getName() {
            return name;
        }

    }

    /**
     * 리턴 코드 enum
     * 
     * @author 이백행
     */
//    @ToString
    public enum ReturnCode {

        /**
         * ‘00’ : 정상
         */
        A00("정상"),

        // ‘01’~‘09’ 제공자 시스템 에러
        /**
         * ‘01’ : Application Error
         */
        A01("Application Error"),
        /**
         * '02' : DB Error
         */
        A02("DB Error"),
        /**
         * '03' : No Data
         */
        A03("No Data"),
        /**
         * '04' : HTTP Error
         */
        A04("HTTP Error"),
        /**
         * ‘05’ : service time out : 서비스 연결 실패. 서비스 시스템 과부하 또는 이상으로 인한 서비스 연결 실패.
         */
        A05("service time out  : 서비스 연결 실패. 서비스 시스템 과부하 또는 이상으로 인한 서비스 연결 실패."),

        // 10~19 요청 메시지 에러
        /**
         * ‘10’ : 잘못된 요청 파라미터 에러
         */
        A10("잘못된 요청 파라미터 에러"),
        /**
         * ‘11’ : 필수 요청 파라미터가 없음
         */
        A11("필수 요청 파라미터가 없음"),
        /**
         * ‘12’ : 해당 오픈 API 서비스가 없거나 폐기됨
         */
        A12("해당 오픈 API 서비스가 없거나 폐기됨"),

        // 20~29 서비스 정책 위반 (공통 모듈)
        /**
         * ‘20’ : 서비스 접근 거부
         */
        A20("서비스 접근 거부"),
        /**
         * ‘21’ : 일시적으로 사용할 수 없는 서비스 키 (운영 정책에 따른 일시적 사용 중지)
         */
        A21("일시적으로 사용할 수 없는 서비스 키 (운영 정책에 따른 일시적 사용 중지)"),
        /**
         * ‘22’ : 서비스 요청 제한 횟수 초과 에러 (일별 요청 한도 등)
         */
        A22("서비스 요청 제한 횟수 초과 에러 (일별 요청 한도 등)"),

        // 30~39 유효하지 않은 서비스 키 (공통 모듈)
        /**
         * ‘30’ : 등록되지 않은 서비스 키
         */
        A30("등록되지 않은 서비스 키"),
        /**
         * ‘31’ : 기한 만료된 서비스 키
         */
        A31("기한 만료된 서비스 키"),
        /**
         * ‘32’ : 등록되지 않은 도메인명 또는 IP 주소
         */
        A32("등록되지 않은 도메인명 또는 IP 주소"),
        /**
         * ‘33’ : 서명되지 않은 호출
         */
        A33("서명되지 않은 호출"),

        /**
         * ‘99’ : Unknown Error 기본으로 제공하는 범위를 벗어나는 리턴코드는 제공 기관별/API별로 추가로 확장/정의하여 사용할 수 있음.
         */
        A99("Unknown Error"),

        ;

        /**
         * 리턴 코드명
         */
        private String name;

        /**
         * 리턴 코드명 생성자
         * 
         * @param name
         */
        ReturnCode(final String name) {
            this.name = name;
        }

        /**
         * 리턴 코드명 값읽기
         * 
         * @return
         */
        public String getName() {
            return name;
        }

    }

    /**
     * 제공 기관별 자체 공통 메시지헤더
     * 
     * @author 이백행
     *
     */
//    @ToString
    static public class MsgHeader {
        private String string;

        public String getString() {
            return string;
        }

        public void setString(String string) {
            this.string = string;
        }

    }

}
