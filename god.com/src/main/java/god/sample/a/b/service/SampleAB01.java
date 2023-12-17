package god.sample.a.b.service;

import egovframework.com.cmm.ComDefaultVO;
import lombok.NoArgsConstructor;

/**
 * 행정코드 DefaultVO
 * 
 * @author 이백행
 * @since 2023-12-18
 *
 */
@NoArgsConstructor
public class SampleAB01 extends ComDefaultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6845645940488070952L;

	/**
	 * `ADMINIST_ZONE_SE` char(1) NOT NULL COMMENT '행정구역구분',
	 */
	private String administZoneSe;

	/**
	 * `ADMINIST_ZONE_CODE` varchar(10) NOT NULL COMMENT '행정구역코드',
	 */
	private String administZoneCode;

	/**
	 * `USE_AT` char(1) NOT NULL COMMENT '사용여부',
	 */
	private String useAt;

	public String getAdministZoneSe() {
		return administZoneSe;
	}

	public void setAdministZoneSe(final String administZoneSe) {
		this.administZoneSe = administZoneSe;
	}

	public String getAdministZoneCode() {
		return administZoneCode;
	}

	public void setAdministZoneCode(final String administZoneCode) {
		this.administZoneCode = administZoneCode;
	}

	public String getUseAt() {
		return useAt;
	}

	public void setUseAt(final String useAt) {
		this.useAt = useAt;
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
