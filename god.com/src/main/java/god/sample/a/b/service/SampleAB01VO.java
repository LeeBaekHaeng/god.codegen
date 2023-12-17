package god.sample.a.b.service;

import lombok.NoArgsConstructor;

/**
 * 행정코드 VO
 * 
 * @author 이백행
 * @since 2023-12-18
 *
 */
@NoArgsConstructor
public class SampleAB01VO extends SampleAB01 {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6474357937307577610L;

	/**
	 * 행정구역구분명
	 * 
	 * <p>
	 * `ADMINIST_ZONE_SE` char(1) NOT NULL COMMENT '행정구역구분',
	 * </p>
	 */
	private String administZoneSeNm;

	/**
	 * 작업일련번호
	 * 
	 * <pre>
	 * comtcadministcoderecptnlog 행정코드수신로그
	 * `OPERT_SN` decimal(10,0) NOT NULL COMMENT '작업일련번호',
	 * </pre>
	 */
	private long opertSn;

	public String getAdministZoneSeNm() {
		return administZoneSeNm;
	}

	public void setAdministZoneSeNm(final String administZoneSeNm) {
		this.administZoneSeNm = administZoneSeNm;
	}

	public long getOpertSn() {
		return opertSn;
	}

	public void setOpertSn(final long opertSn) {
		this.opertSn = opertSn;
	}

	/**
	 * serialVersionUID 값읽기
	 * 
	 * @return
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
