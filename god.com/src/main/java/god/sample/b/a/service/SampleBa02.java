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
	 * `NTT_NO` decimal(20,0) DEFAULT NULL COMMENT '게시물번호',
	 */
	private Long nttNo;

	/**
	 * `USE_AT` char(1) NOT NULL COMMENT '사용여부',
	 */
	private String useAt;

	/**
	 * 게시물제목
	 * 
	 * @TABLE_NAME COMTNBBS 게시판
	 * @COLUMN_NAME `NTT_SJ` varchar(2000) DEFAULT NULL COMMENT '게시물제목',
	 */
	private String nttSj;

	/**
	 * 게시물내용
	 * 
	 * @TABLE_NAME COMTNBBS 게시판
	 * @COLUMN_NAME `NTT_CN` mediumtext DEFAULT NULL COMMENT '게시물내용',
	 */
	private String nttCn;

	/**
	 * 댓글여부
	 * 
	 * @TABLE_NAME COMTNBBS 게시판
	 * @COLUMN_NAME `ANSWER_AT` char(1) DEFAULT NULL COMMENT '댓글여부',
	 */
	private String answerAt;

	/**
	 * 부모글번호
	 * 
	 * @TABLE_NAME COMTNBBS 게시판
	 * @COLUMN_NAME `PARNTSCTT_NO` decimal(10,0) DEFAULT NULL COMMENT '부모글번호',
	 */
	private Long parntscttNo;

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
	public void setNttId(final long nttId) {
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
	public void setBbsId(final String bbsId) {
		this.bbsId = bbsId;
	}

	/**
	 * `NTT_NO` decimal(20,0) DEFAULT NULL COMMENT '게시물번호',
	 * 
	 * @return
	 */
	public Long getNttNo() {
		return nttNo;
	}

	/**
	 * `NTT_NO` decimal(20,0) DEFAULT NULL COMMENT '게시물번호',
	 * 
	 * @param nttNo
	 */
	public void setNttNo(final Long nttNo) {
		this.nttNo = nttNo;
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
	public void setUseAt(final String useAt) {
		this.useAt = useAt;
	}

	/**
	 * 게시물제목 값읽기
	 * 
	 * @return
	 * @TABLE_NAME COMTNBBS 게시판
	 * @COLUMN_NAME `NTT_SJ` varchar(2000) DEFAULT NULL COMMENT '게시물제목',
	 */
	public String getNttSj() {
		return nttSj;
	}

	/**
	 * 게시물제목 값설정
	 * 
	 * @param nttSj
	 * @TABLE_NAME COMTNBBS 게시판
	 * @COLUMN_NAME `NTT_SJ` varchar(2000) DEFAULT NULL COMMENT '게시물제목',
	 */
	public void setNttSj(final String nttSj) {
		this.nttSj = nttSj;
	}

	/**
	 * 게시물내용 값읽기
	 * 
	 * @TABLE_NAME COMTNBBS 게시판
	 * @COLUMN_NAME `NTT_CN` mediumtext DEFAULT NULL COMMENT '게시물내용',
	 * @return
	 */
	public String getNttCn() {
		return nttCn;
	}

	/**
	 * 게시물내용 값설정
	 * 
	 * @TABLE_NAME COMTNBBS 게시판
	 * @COLUMN_NAME `NTT_CN` mediumtext DEFAULT NULL COMMENT '게시물내용',
	 * @param nttCn
	 */
	public void setNttCn(final String nttCn) {
		this.nttCn = nttCn;
	}

	/**
	 * 댓글여부 값읽기
	 * 
	 * @TABLE_NAME COMTNBBS 게시판
	 * @COLUMN_NAME `ANSWER_AT` char(1) DEFAULT NULL COMMENT '댓글여부',
	 * @return
	 */
	public String getAnswerAt() {
		return answerAt;
	}

	/**
	 * 댓글여부 값설정
	 * 
	 * @TABLE_NAME COMTNBBS 게시판
	 * @COLUMN_NAME `ANSWER_AT` char(1) DEFAULT NULL COMMENT '댓글여부',
	 * @param answerAt
	 */
	public void setAnswerAt(final String answerAt) {
		this.answerAt = answerAt;
	}

	/**
	 * 부모글번호 값읽기
	 * 
	 * @TABLE_NAME COMTNBBS 게시판
	 * @COLUMN_NAME `PARNTSCTT_NO` decimal(10,0) DEFAULT NULL COMMENT '부모글번호',
	 * @return
	 */
	public Long getParntscttNo() {
		return parntscttNo;
	}

	/**
	 * 부모글번호 값설정
	 * 
	 * @TABLE_NAME COMTNBBS 게시판
	 * @COLUMN_NAME `PARNTSCTT_NO` decimal(10,0) DEFAULT NULL COMMENT '부모글번호',
	 * @param parntscttNo
	 */
	public void setParntscttNo(final Long parntscttNo) {
		this.parntscttNo = parntscttNo;
	}

}
