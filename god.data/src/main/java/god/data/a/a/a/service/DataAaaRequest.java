package god.data.a.a.a.service;

import egovframework.com.cmm.ComDefaultVO;
import lombok.NoArgsConstructor;

/**
 * 공통상세코드 요청 DefaultVO
 * 
 * @author 이백행
 * @since 2024-07-26
 *
 * @테이블 COMTCCMMNDETAILCODE 공통상세코드
 *
 */
@NoArgsConstructor
public class DataAaaRequest extends ComDefaultVO {

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

}
