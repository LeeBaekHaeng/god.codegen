package god.data.a.a.a.service;

import egovframework.com.cmm.ComDefaultVO;
import lombok.Getter;
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
@Getter
@NoArgsConstructor
public class DataAaaDefaultVO extends ComDefaultVO {

	/**
	 * 직렬 버전 UID
	 */
	private static final long serialVersionUID = -6587051588018637029L;

	/**
	 * 코드ID명
	 * 
	 * @컬럼 `CODE_ID` varchar(6) NOT NULL COMMENT '코드ID',
	 */
	private String codeIdNm;

}
