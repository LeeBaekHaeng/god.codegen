package god.sample.b.a.service;

import egovframework.com.cmm.ComDefaultVO;
import lombok.NoArgsConstructor;

/**
 * 게시판 DefaultVO
 * 
 * @author 이백행
 * @since 2023-12-21
 *
 * @TABLE_NAME COMTNBBS 게시판
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
	 * 댓글위치
	 * 
	 * @TABLE_NAME COMTNBBS 게시판
	 * @COLUMN_NAME `ANSWER_LC` decimal(8,0) DEFAULT NULL COMMENT '댓글위치',
	 */
	private Long answerLc;

	/**
	 * 정렬순서
	 * 
	 * @TABLE_NAME COMTNBBS 게시판
	 * @COLUMN_NAME `SORT_ORDR` decimal(8,0) DEFAULT NULL COMMENT '정렬순서',
	 */
	private Long sortOrdr;

	/**
	 * 조회수
	 * 
	 * @TABLE_NAME COMTNBBS 게시판
	 * @COLUMN_NAME `RDCNT` decimal(10,0) DEFAULT NULL COMMENT '조회수',
	 */
	private Long rdcnt;

	/**
	 * 게시시작일
	 * 
	 * @TABLE_NAME COMTNBBS 게시판
	 * @COLUMN_NAME `NTCE_BGNDE` char(20) DEFAULT NULL COMMENT '게시시작일',
	 */
	private String ntceBgnde;

	/**
	 * 게시종료일
	 * 
	 * @COLUMN_NAME `NTCE_ENDDE` char(20) DEFAULT NULL COMMENT '게시종료일',
	 */
	private String ntceEndde;

	/**
	 * 게시자ID
	 * 
	 * @COLUMN_NAME `NTCR_ID` varchar(20) DEFAULT NULL COMMENT '게시자ID',
	 */
	private String ntcrId;

	/**
	 * 게시자명
	 * 
	 * @COLUMN_NAME `NTCR_NM` varchar(20) DEFAULT NULL COMMENT '게시자명',
	 */
	private String ntcrNm;

	/**
	 * 첨부파일ID
	 * 
	 * @COLUMN_NAME `ATCH_FILE_ID` char(20) DEFAULT NULL COMMENT '첨부파일ID',
	 */
	private String password;

	/**
	 * 비밀번호
	 * 
	 * @COLUMN_NAME `PASSWORD` varchar(200) DEFAULT NULL COMMENT '비밀번호',
	 */
	private String atchFileId;

	/**
	 * 공지사항여부
	 * 
	 * @COLUMN_NAME `NOTICE_AT` char(1) DEFAULT NULL COMMENT '공지사항여부',
	 */
	private String noticeAt;

	/**
	 * 제목볼드여부
	 * 
	 * @COLUMN_NAME `SJ_BOLD_AT` char(1) DEFAULT NULL COMMENT '제목볼드여부',
	 */
	private String sjBoldAt;

	/**
	 * 비밀글여부
	 * 
	 * @COLUMN_NAME `SECRET_AT` char(1) DEFAULT NULL COMMENT '비밀글여부',
	 */
	private String secretAt;

	/**
	 * 블로그 ID
	 * 
	 * @COLUMN_NAME `BLOG_ID` char(20) DEFAULT NULL COMMENT '블로그 ID',
	 */
	private String blogId;

	/**
	 * 게시판명
	 * 
	 * @테이블 COMTNBBSMASTER 게시판마스터
	 * @컬럼 `BBS_NM` varchar(255) NOT NULL COMMENT '게시판명',
	 */
	private String bbsNm;

	/**
	 * getSerialversionuid
	 * 
	 * @return
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	/**
	 * 게시물ID 값읽기
	 * 
	 * @return
	 * 
	 * @컬럼 `NTT_ID` decimal(20,0) NOT NULL COMMENT '게시물ID',
	 */
	public long getNttId() {
		return nttId;
	}

	/**
	 * 게시물ID 값설정
	 * 
	 * @param nttId
	 * 
	 * @컬럼 `NTT_ID` decimal(20,0) NOT NULL COMMENT '게시물ID',
	 */
	public void setNttId(final long nttId) {
		this.nttId = nttId;
	}

	/**
	 * 게시판ID 값읽기
	 * 
	 * @return
	 * 
	 * @컬럼 `BBS_ID` char(30) NOT NULL COMMENT '게시판ID',
	 */
	public String getBbsId() {
		return bbsId;
	}

	/**
	 * 게시판ID 값설정
	 * 
	 * @param bbsId
	 * 
	 * @컬럼 `BBS_ID` char(30) NOT NULL COMMENT '게시판ID',
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

	/**
	 * 댓글위치 값읽기
	 * 
	 * @TABLE_NAME COMTNBBS 게시판
	 * @COLUMN_NAME `ANSWER_LC` decimal(8,0) DEFAULT NULL COMMENT '댓글위치',
	 * @return
	 */
	public Long getAnswerLc() {
		return answerLc;
	}

	/**
	 * 댓글위치 값설정
	 * 
	 * @TABLE_NAME COMTNBBS 게시판
	 * @COLUMN_NAME `ANSWER_LC` decimal(8,0) DEFAULT NULL COMMENT '댓글위치',
	 * @param answerLc
	 */
	public void setAnswerLc(final Long answerLc) {
		this.answerLc = answerLc;
	}

	/**
	 * 정렬순서 값읽기
	 * 
	 * @TABLE_NAME COMTNBBS 게시판
	 * @COLUMN_NAME `SORT_ORDR` decimal(8,0) DEFAULT NULL COMMENT '정렬순서',
	 * @return
	 */
	public Long getSortOrdr() {
		return sortOrdr;
	}

	/**
	 * 정렬순서 값설정
	 * 
	 * @TABLE_NAME COMTNBBS 게시판
	 * @COLUMN_NAME `SORT_ORDR` decimal(8,0) DEFAULT NULL COMMENT '정렬순서',
	 * @param sortOrdr
	 */
	public void setSortOrdr(final Long sortOrdr) {
		this.sortOrdr = sortOrdr;
	}

	/**
	 * 조회수 값읽기
	 * 
	 * @TABLE_NAME COMTNBBS 게시판
	 * @COLUMN_NAME `RDCNT` decimal(10,0) DEFAULT NULL COMMENT '조회수',
	 * @return
	 */
	public Long getRdcnt() {
		return rdcnt;
	}

	/**
	 * 조회수 값설정
	 * 
	 * @TABLE_NAME COMTNBBS 게시판
	 * @COLUMN_NAME `RDCNT` decimal(10,0) DEFAULT NULL COMMENT '조회수',
	 * @param rdcnt
	 */
	public void setRdcnt(final Long rdcnt) {
		this.rdcnt = rdcnt;
	}

	/**
	 * 게시시작일 값읽기
	 * 
	 * @return
	 * 
	 * @TABLE_NAME COMTNBBS 게시판
	 * @COLUMN_NAME `NTCE_BGNDE` char(20) DEFAULT NULL COMMENT '게시시작일',
	 */
	public String getNtceBgnde() {
		return ntceBgnde;
	}

	/**
	 * 게시시작일 값설정
	 * 
	 * @param ntceBgnde
	 * 
	 * @TABLE_NAME COMTNBBS 게시판
	 * @COLUMN_NAME `NTCE_BGNDE` char(20) DEFAULT NULL COMMENT '게시시작일',
	 */
	public void setNtceBgnde(final String ntceBgnde) {
		this.ntceBgnde = ntceBgnde;
	}

	/**
	 * 게시종료일 값읽기
	 * 
	 * @COLUMN_NAME `NTCE_ENDDE` char(20) DEFAULT NULL COMMENT '게시종료일',
	 * @return
	 */
	public String getNtceEndde() {
		return ntceEndde;
	}

	/**
	 * 게시종료일 값설정
	 * 
	 * @COLUMN_NAME `NTCE_ENDDE` char(20) DEFAULT NULL COMMENT '게시종료일',
	 * @param ntceEndde
	 */
	public void setNtceEndde(final String ntceEndde) {
		this.ntceEndde = ntceEndde;
	}

	/**
	 * 게시자ID 값읽기
	 * 
	 * @COLUMN_NAME `NTCR_ID` varchar(20) DEFAULT NULL COMMENT '게시자ID',
	 * @return
	 */
	public String getNtcrId() {
		return ntcrId;
	}

	/**
	 * 게시자ID 값설정
	 * 
	 * @COLUMN_NAME `NTCR_ID` varchar(20) DEFAULT NULL COMMENT '게시자ID',
	 * @param ntcrId
	 */
	public void setNtcrId(final String ntcrId) {
		this.ntcrId = ntcrId;
	}

	/**
	 * 게시자명 값읽기
	 * 
	 * @return
	 * 
	 * @COLUMN_NAME `NTCR_NM` varchar(20) DEFAULT NULL COMMENT '게시자명',
	 */
	public String getNtcrNm() {
		return ntcrNm;
	}

	/**
	 * 게시자명 값설정
	 * 
	 * @param ntcrNm
	 * 
	 * @COLUMN_NAME `NTCR_NM` varchar(20) DEFAULT NULL COMMENT '게시자명',
	 */
	public void setNtcrNm(final String ntcrNm) {
		this.ntcrNm = ntcrNm;
	}

	/**
	 * 비밀번호 값읽기
	 * 
	 * @return
	 * 
	 * @COLUMN_NAME `PASSWORD` varchar(200) DEFAULT NULL COMMENT '비밀번호',
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 비밀번호 값설정
	 * 
	 * @param password
	 * 
	 * @COLUMN_NAME `PASSWORD` varchar(200) DEFAULT NULL COMMENT '비밀번호',
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * 첨부파일ID 값읽기
	 * 
	 * @return
	 * @COLUMN_NAME `ATCH_FILE_ID` char(20) DEFAULT NULL COMMENT '첨부파일ID',
	 */
	public String getAtchFileId() {
		return atchFileId;
	}

	/**
	 * 첨부파일ID 값설정
	 * 
	 * @param atchFileId
	 * @COLUMN_NAME `ATCH_FILE_ID` char(20) DEFAULT NULL COMMENT '첨부파일ID',
	 */
	public void setAtchFileId(final String atchFileId) {
		this.atchFileId = atchFileId;
	}

	/**
	 * 공지사항여부 값읽기
	 * 
	 * @return
	 * @COLUMN_NAME `NOTICE_AT` char(1) DEFAULT NULL COMMENT '공지사항여부',
	 */
	public String getNoticeAt() {
		return noticeAt;
	}

	/**
	 * 공지사항여부 값설정
	 * 
	 * @param noticeAt
	 * @COLUMN_NAME `NOTICE_AT` char(1) DEFAULT NULL COMMENT '공지사항여부',
	 */
	public void setNoticeAt(final String noticeAt) {
		this.noticeAt = noticeAt;
	}

	/**
	 * 제목볼드여부 값읽기
	 * 
	 * @return
	 * @COLUMN_NAME `SJ_BOLD_AT` char(1) DEFAULT NULL COMMENT '제목볼드여부',
	 */
	public String getSjBoldAt() {
		return sjBoldAt;
	}

	/**
	 * 제목볼드여부 값설정
	 * 
	 * @param sjBoldAt
	 * @COLUMN_NAME `SJ_BOLD_AT` char(1) DEFAULT NULL COMMENT '제목볼드여부',
	 */
	public void setSjBoldAt(final String sjBoldAt) {
		this.sjBoldAt = sjBoldAt;
	}

	/**
	 * 비밀글여부 값읽기
	 * 
	 * @return
	 * @COLUMN_NAME `SECRET_AT` char(1) DEFAULT NULL COMMENT '비밀글여부',
	 */
	public String getSecretAt() {
		return secretAt;
	}

	/**
	 * 비밀글여부 값설정
	 * 
	 * @param secretAt
	 * @COLUMN_NAME `SECRET_AT` char(1) DEFAULT NULL COMMENT '비밀글여부',
	 */
	public void setSecretAt(final String secretAt) {
		this.secretAt = secretAt;
	}

	/**
	 * 블로그 ID 값읽기
	 * 
	 * @return
	 * @COLUMN_NAME `BLOG_ID` char(20) DEFAULT NULL COMMENT '블로그 ID',
	 */
	public String getBlogId() {
		return blogId;
	}

	/**
	 * 블로그 ID 값설정
	 * 
	 * @param blogId
	 * @COLUMN_NAME `BLOG_ID` char(20) DEFAULT NULL COMMENT '블로그 ID',
	 */
	public void setBlogId(final String blogId) {
		this.blogId = blogId;
	}

	/**
	 * 게시판명 값읽기
	 * 
	 * @return
	 * 
	 * @테이블 COMTNBBSMASTER 게시판마스터
	 * @컬럼 `BBS_NM` varchar(255) NOT NULL COMMENT '게시판명',
	 */
	public String getBbsNm() {
		return bbsNm;
	}

	/**
	 * 게시판명 값설정
	 * 
	 * @param bbsNm
	 * 
	 * @테이블 COMTNBBSMASTER 게시판마스터
	 * @컬럼 `BBS_NM` varchar(255) NOT NULL COMMENT '게시판명',
	 */
	public void setBbsNm(final String bbsNm) {
		this.bbsNm = bbsNm;
	}

}
