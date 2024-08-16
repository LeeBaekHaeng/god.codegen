package god.data.a.a.a.service;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

/**
 * 공통상세코드 응답 DefaultVO
 * 
 * @author 이백행
 * @since 2024-07-26
 *
 * @테이블 COMTCCMMNDETAILCODE 공통상세코드
 *
 */
@Getter
//@Setter
public class DataAaaVO extends DataAaaDefaultVO {

	/**
	 * 직렬 버전 UID
	 */
	private static final long serialVersionUID = -5245682430813025082L;

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
	 * 
	 * @param codeId
	 * @param code
	 * @param codeNm
	 * @param codeDc
	 * @param useAt
	 * @param frstRegistPnttm
	 * @param frstRegisterId
	 * @param lastUpdtPnttm
	 * @param lastUpdusrId
	 * 
	 * @param codeIdNm
	 */
	@Builder
	public DataAaaVO(final String codeId, final String code, final String codeNm, final String codeDc,
			final String useAt, final LocalDateTime frstRegistPnttm, final String frstRegisterId,
			final LocalDateTime lastUpdtPnttm, final String lastUpdusrId, final String codeIdNm) {
		super(codeIdNm);
		this.codeId = codeId;
		this.code = code;
		this.codeNm = codeNm;
		this.codeDc = codeDc;
		this.useAt = useAt;
		this.frstRegistPnttm = frstRegistPnttm;
		this.frstRegisterId = frstRegisterId;
		this.lastUpdtPnttm = lastUpdtPnttm;
		this.lastUpdusrId = lastUpdusrId;
	}

	public DataAaaVO(final String codeId, final String code, final String codeNm, final String codeDc,
			final String useAt, final LocalDateTime frstRegistPnttm, final String frstRegisterId,
			final LocalDateTime lastUpdtPnttm, final String lastUpdusrId) {
		super(null);
		this.codeId = codeId;
		this.code = code;
		this.codeNm = codeNm;
		this.codeDc = codeDc;
		this.useAt = useAt;
		this.frstRegistPnttm = frstRegistPnttm;
		this.frstRegisterId = frstRegisterId;
		this.lastUpdtPnttm = lastUpdtPnttm;
		this.lastUpdusrId = lastUpdusrId;
	}

}
