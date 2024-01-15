package god.com.cmm.enums;

/**
 * 날짜 패턴
 * 
 * @author 이백행
 * @since 2024-01-16
 *
 */
public enum DatePattern {

	/**
	 * yyyy-MM-dd HH:mm:ss
	 */
	YYYY_MM_DD_HH_MM_SS("yyyy-MM-dd HH:mm:ss", ""),

	/**
	 * yyyy-MM-dd
	 */
	YYYY_MM_DD("yyyy-MM-dd", ""),

	/**
	 * HH:mm:ss
	 */
	HH_MM_SS("HH:mm:ss", ""),

	;

	/**
	 * 
	 */
	private final String code;

	/**
	 * 
	 */
	private final String codeNm;

	DatePattern(final String code, final String codeNm) {
		this.code = code;
		this.codeNm = codeNm;
	}

	/**
	 * 코드 값읽기
	 * 
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 코드명 값읽기
	 * 
	 * @return
	 */
	public String getCodeNm() {
		return codeNm;
	}

}
