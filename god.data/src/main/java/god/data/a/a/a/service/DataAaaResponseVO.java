package god.data.a.a.a.service;

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
public class DataAaaResponseVO extends DataAaaResponse {

	/**
	 * 직렬 버전 UID
	 */
	private static final long serialVersionUID = -5245682430813025082L;

	/**
	 * 코드ID명
	 * 
	 * @컬럼 `CODE_ID` varchar(6) NOT NULL COMMENT '코드ID',
	 */
	private String codeIdNm;

	/**
	 * 직렬 버전 UID 값읽기
	 * 
	 * @return
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 코드ID명 값읽기
	 * 
	 * @return
	 * 
	 * @컬럼 `CODE_ID` varchar(6) NOT NULL COMMENT '코드ID',
	 */
	public String getCodeIdNm() {
		return codeIdNm;
	}

	/**
	 * 코드ID명 값설정
	 * 
	 * @param codeIdNm
	 * 
	 * @컬럼 `CODE_ID` varchar(6) NOT NULL COMMENT '코드ID',
	 */
	public void setCodeIdNm(final String codeIdNm) {
		this.codeIdNm = codeIdNm;
	}

}
