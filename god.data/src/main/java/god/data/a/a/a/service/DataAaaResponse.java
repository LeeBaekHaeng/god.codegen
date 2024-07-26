package god.data.a.a.a.service;

import java.time.LocalDateTime;

import egovframework.com.cmm.ComDefaultVO;
import lombok.NoArgsConstructor;

/**
 * 공통상세코드 응답 DefaultVO
 * 
 * @author 이백행
 * @since 2024-07-26
 *
 * @테이블 COMTCCMMNDETAILCODE 공통상세코드
 *
 */
@NoArgsConstructor
public class DataAaaResponse extends ComDefaultVO {

	/**
	 * 직렬 버전 UID
	 */
	private static final long serialVersionUID = -6587051588018637029L;

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
	 * 직렬 버전 UID 값읽기
	 * 
	 * @return
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 코드ID 값읽기
	 * 
	 * @return
	 * 
	 * @컬럼 `CODE_ID` varchar(6) NOT NULL COMMENT '코드ID',
	 */
	public String getCodeId() {
		return codeId;
	}

	/**
	 * 코드ID 값설정
	 * 
	 * @param codeId
	 * 
	 * @컬럼 `CODE_ID` varchar(6) NOT NULL COMMENT '코드ID',
	 */
	public void setCodeId(final String codeId) {
		this.codeId = codeId;
	}

	/**
	 * 코드 값읽기
	 * 
	 * @return
	 * 
	 * @컬럼 `CODE` varchar(15) NOT NULL COMMENT '코드',
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 코드 값설정
	 * 
	 * @param code
	 * 
	 * @컬럼 `CODE` varchar(15) NOT NULL COMMENT '코드',
	 */
	public void setCode(final String code) {
		this.code = code;
	}

	/**
	 * 코드명 값읽기
	 * 
	 * @return
	 * 
	 * @컬럼 `CODE_NM` varchar(60) DEFAULT NULL COMMENT '코드명',
	 */
	public String getCodeNm() {
		return codeNm;
	}

	/**
	 * 코드명 값설정
	 * 
	 * @param codeNm
	 * 
	 * @컬럼 `CODE_NM` varchar(60) DEFAULT NULL COMMENT '코드명',
	 */
	public void setCodeNm(final String codeNm) {
		this.codeNm = codeNm;
	}

	/**
	 * 코드설명 값읽기
	 * 
	 * @return
	 * 
	 * @컬럼 `CODE_DC` varchar(200) DEFAULT NULL COMMENT '코드설명',
	 */
	public String getCodeDc() {
		return codeDc;
	}

	/**
	 * 코드설명 값설정
	 * 
	 * @param codeDc
	 * 
	 * @컬럼 `CODE_DC` varchar(200) DEFAULT NULL COMMENT '코드설명',
	 */
	public void setCodeDc(final String codeDc) {
		this.codeDc = codeDc;
	}

	/**
	 * 사용여부 값읽기
	 * 
	 * @return
	 * 
	 * @컬럼 `USE_AT` char(1) DEFAULT NULL COMMENT '사용여부',
	 */
	public String getUseAt() {
		return useAt;
	}

	/**
	 * 사용여부 값설정
	 * 
	 * @param useAt
	 * 
	 * @컬럼 `USE_AT` char(1) DEFAULT NULL COMMENT '사용여부',
	 */
	public void setUseAt(final String useAt) {
		this.useAt = useAt;
	}

	/**
	 * 최초등록시점 값읽기
	 * 
	 * @return
	 * 
	 * @컬럼 `FRST_REGIST_PNTTM` datetime DEFAULT NULL COMMENT '최초등록시점',
	 */
	public LocalDateTime getFrstRegistPnttm() {
		return frstRegistPnttm;
	}

	/**
	 * 최초등록시점 값설정
	 * 
	 * @param frstRegistPnttm
	 * 
	 * @컬럼 `FRST_REGIST_PNTTM` datetime DEFAULT NULL COMMENT '최초등록시점',
	 */
	public void setFrstRegistPnttm(final LocalDateTime frstRegistPnttm) {
		this.frstRegistPnttm = frstRegistPnttm;
	}

	/**
	 * 최초등록자ID 값읽기
	 * 
	 * @return
	 * 
	 * @컬럼 `FRST_REGISTER_ID` varchar(20) DEFAULT NULL COMMENT '최초등록자ID',
	 */
	public String getFrstRegisterId() {
		return frstRegisterId;
	}

	/**
	 * 최초등록자ID 값설정
	 * 
	 * @param frstRegisterId
	 * 
	 * @컬럼 `FRST_REGISTER_ID` varchar(20) DEFAULT NULL COMMENT '최초등록자ID',
	 */
	public void setFrstRegisterId(final String frstRegisterId) {
		this.frstRegisterId = frstRegisterId;
	}

	/**
	 * 최종수정시점 값읽기
	 * 
	 * @return
	 * 
	 * @컬럼 `LAST_UPDT_PNTTM` datetime DEFAULT NULL COMMENT '최종수정시점',
	 */
	public LocalDateTime getLastUpdtPnttm() {
		return lastUpdtPnttm;
	}

	/**
	 * 최종수정시점 값설정
	 * 
	 * @param lastUpdtPnttm
	 * 
	 * @컬럼 `LAST_UPDT_PNTTM` datetime DEFAULT NULL COMMENT '최종수정시점',
	 */
	public void setLastUpdtPnttm(final LocalDateTime lastUpdtPnttm) {
		this.lastUpdtPnttm = lastUpdtPnttm;
	}

	/**
	 * 최종수정자ID 값읽기
	 * 
	 * @return
	 * 
	 * @컬럼 `LAST_UPDUSR_ID` varchar(20) DEFAULT NULL COMMENT '최종수정자ID',
	 */
	public String getLastUpdusrId() {
		return lastUpdusrId;
	}

	/**
	 * 최종수정자ID 값설정
	 * 
	 * @param lastUpdusrId
	 * 
	 * @컬럼 `LAST_UPDUSR_ID` varchar(20) DEFAULT NULL COMMENT '최종수정자ID',
	 */
	public void setLastUpdusrId(final String lastUpdusrId) {
		this.lastUpdusrId = lastUpdusrId;
	}

}
