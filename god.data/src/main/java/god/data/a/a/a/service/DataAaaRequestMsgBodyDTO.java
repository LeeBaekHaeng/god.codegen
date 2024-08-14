package god.data.a.a.a.service;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * 공통상세코드 요청 서비스별 개별 메시지바디
 * 
 * @author 이백행
 * @since 2024-08-02
 *
 */
@Builder
@Getter
@ToString
public class DataAaaRequestMsgBodyDTO {

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
	 * 코드명
	 * 
	 * @컬럼 `CODE_NM` varchar(60) DEFAULT NULL COMMENT '코드명',
	 */
	private String codeNm;

	/**
	 * 코드설명
	 * 
	 * @컬럼 `CODE_DC` varchar(200) DEFAULT NULL COMMENT '코드설명',
	 */
	private String codeDc;

	/**
	 * 사용여부
	 * 
	 * @컬럼 `USE_AT` char(1) DEFAULT NULL COMMENT '사용여부',
	 */
	private String useAt;

	/**
	 * 최초등록시점
	 * 
	 * @컬럼 `FRST_REGIST_PNTTM` datetime DEFAULT NULL COMMENT '최초등록시점',
	 */
	private LocalDateTime frstRegistPnttm;

	/**
	 * 최초등록자ID
	 * 
	 * @컬럼 `FRST_REGISTER_ID` varchar(20) DEFAULT NULL COMMENT '최초등록자ID',
	 */
	private String frstRegisterId;

	/**
	 * 최종수정시점
	 * 
	 * @컬럼 `LAST_UPDT_PNTTM` datetime DEFAULT NULL COMMENT '최종수정시점',
	 */
	private LocalDateTime lastUpdtPnttm;

	/**
	 * 최종수정자ID
	 * 
	 * @컬럼 `LAST_UPDUSR_ID` varchar(20) DEFAULT NULL COMMENT '최종수정자ID',
	 */
	private String lastUpdusrId;

	/**
	 * 코드ID명
	 * 
	 * @컬럼 `CODE_ID` varchar(6) NOT NULL COMMENT '코드ID',
	 */
	private String codeIdNm;

}
