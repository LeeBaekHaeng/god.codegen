package god.sample.b.a.service;

import egovframework.com.cmm.ComDefaultVO;
import lombok.NoArgsConstructor;

/**
 * 게시판 DefaultVO
 * 
 * @author 이백행
 * @since 2023-12-21
 *
 */
@NoArgsConstructor
public class SampleBa02 extends ComDefaultVO {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = -567613828606683830L;

	/**
	 * `NTT_ID` decimal(20,0) NOT NULL COMMENT '게시물ID',
	 */
	private long nttId;

	/**
	 * `BBS_ID` char(30) NOT NULL COMMENT '게시판ID',
	 */
	private String bbsId;

	/**
	 * `USE_AT` char(1) NOT NULL COMMENT '사용여부',
	 */
	private String useAt;

	/**
	 * getSerialversionuid
	 * 
	 * @return
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * `NTT_ID` decimal(20,0) NOT NULL COMMENT '게시물ID',
	 * 
	 * @return
	 */
	public long getNttId() {
		return nttId;
	}

	/**
	 * `NTT_ID` decimal(20,0) NOT NULL COMMENT '게시물ID',
	 * 
	 * @param nttId
	 */
	public void setNttId(long nttId) {
		this.nttId = nttId;
	}

	/**
	 * `BBS_ID` char(30) NOT NULL COMMENT '게시판ID',
	 * 
	 * @return
	 */
	public String getBbsId() {
		return bbsId;
	}

	/**
	 * `BBS_ID` char(30) NOT NULL COMMENT '게시판ID',
	 * 
	 * @param bbsId
	 */
	public void setBbsId(String bbsId) {
		this.bbsId = bbsId;
	}

	/**
	 * `USE_AT` char(1) NOT NULL COMMENT '사용여부',
	 * 
	 * @return
	 */
	public String getUseAt() {
		return useAt;
	}

	/**
	 * `USE_AT` char(1) NOT NULL COMMENT '사용여부',
	 * 
	 * @param useAt
	 */
	public void setUseAt(String useAt) {
		this.useAt = useAt;
	}

}
