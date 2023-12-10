package god.test.a.a.a.service;

import egovframework.com.cmm.ComDefaultVO;

public class GodTestAaa003VO extends ComDefaultVO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2041387983328171537L;

	private String administZoneSe;

	private String administZoneCode;

	private String useAt;

	/**
	 * 작업일련번호
	 * 
	 * <pre>
	 * comtcadministcoderecptnlog 행정코드수신로그
	 * `OPERT_SN` decimal(10,0) NOT NULL COMMENT '작업일련번호',
	 * </pre>
	 */
	private long opertSn;

	public String getAdministZoneSe() {
		return administZoneSe;
	}

	public void setAdministZoneSe(String administZoneSe) {
		this.administZoneSe = administZoneSe;
	}

	public String getAdministZoneCode() {
		return administZoneCode;
	}

	public void setAdministZoneCode(String administZoneCode) {
		this.administZoneCode = administZoneCode;
	}

	public String getUseAt() {
		return useAt;
	}

	public void setUseAt(String useAt) {
		this.useAt = useAt;
	}

	public long getOpertSn() {
		return opertSn;
	}

	public void setOpertSn(long opertSn) {
		this.opertSn = opertSn;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
