package egovframework.com.cmm;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @Class Name : ComDefaultVO.java
 * @Description : ComDefaultVO class
 * @Modification Information
 * @ @ 수정일 수정자 수정내용 @ ------- -------- --------------------------- @ 2009.02.01
 *   조재영 최초 생성
 *
 * @author 공통서비스 개발팀 조재영
 * @since 2009.02.01
 * @version 1.0
 * @see
 * 
 */
@SuppressWarnings("serial")
public class ComDefaultVO implements Serializable {

	/** 검색조건 */
	private String searchCondition = "";

	/** 검색Keyword */
	private String searchKeyword = "";

	/** 검색사용여부 */
	private String searchUseYn = "";

	/** 현재페이지 */
	private int pageIndex = 1;

	/** 페이지개수 */
	private int pageUnit = 10;

	/** 페이지사이즈 */
	private int pageSize = 10;

	/** firstIndex */
	private int firstIndex = 1;

	/** lastIndex */
	private int lastIndex = 1;

	/** recordCountPerPage */
	private int recordCountPerPage = 10;

	/** 검색KeywordFrom */
	private String searchKeywordFrom = "";

	/** 검색KeywordTo */
	private String searchKeywordTo = "";

	/**
	 * 최초등록시점
	 * 
	 * <p>
	 * `FRST_REGIST_PNTTM` datetime DEFAULT NULL COMMENT '최초등록시점',
	 * </p>
	 */
	private LocalDateTime frstRegistPnttm;

	/**
	 * 최초등록자ID
	 * 
	 * <p>
	 * `FRST_REGISTER_ID` varchar(20) DEFAULT NULL COMMENT '최초등록자ID',
	 * </p>
	 */
	private String frstRegisterId;

	/**
	 * 최종수정시점
	 * 
	 * <p>
	 * `LAST_UPDT_PNTTM` datetime DEFAULT NULL COMMENT '최종수정시점',
	 * </p>
	 */
	private LocalDateTime lastUpdtPnttm;

	/**
	 * 최종수정자ID
	 * 
	 * <p>
	 * `LAST_UPDUSR_ID` varchar(20) DEFAULT NULL COMMENT '최종수정자ID',
	 * </p>
	 */
	private String lastUpdusrId;

	public int getFirstIndex() {
		return firstIndex;
	}

	public void setFirstIndex(int firstIndex) {
		this.firstIndex = firstIndex;
	}

	public int getLastIndex() {
		return lastIndex;
	}

	public void setLastIndex(int lastIndex) {
		this.lastIndex = lastIndex;
	}

	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}

	public String getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(String searchCondition) {
		this.searchCondition = searchCondition;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getSearchUseYn() {
		return searchUseYn;
	}

	public void setSearchUseYn(String searchUseYn) {
		this.searchUseYn = searchUseYn;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageUnit() {
		return pageUnit;
	}

	public void setPageUnit(int pageUnit) {
		this.pageUnit = pageUnit;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	/**
	 * searchKeywordFrom attribute를 리턴한다.
	 * 
	 * @return String
	 */
	public String getSearchKeywordFrom() {
		return searchKeywordFrom;
	}

	/**
	 * searchKeywordFrom attribute 값을 설정한다.
	 * 
	 * @param searchKeywordFrom String
	 */
	public void setSearchKeywordFrom(String searchKeywordFrom) {
		this.searchKeywordFrom = searchKeywordFrom;
	}

	/**
	 * searchKeywordTo attribute를 리턴한다.
	 * 
	 * @return String
	 */
	public String getSearchKeywordTo() {
		return searchKeywordTo;
	}

	/**
	 * searchKeywordTo attribute 값을 설정한다.
	 * 
	 * @param searchKeywordTo String
	 */
	public void setSearchKeywordTo(String searchKeywordTo) {
		this.searchKeywordTo = searchKeywordTo;
	}

	/**
	 * 최초등록시점 값읽기
	 * 
	 * <p>
	 * `FRST_REGIST_PNTTM` datetime DEFAULT NULL COMMENT '최초등록시점',
	 * </p>
	 * 
	 * @return
	 */
	public LocalDateTime getFrstRegistPnttm() {
		return frstRegistPnttm;
	}

	/**
	 * 최초등록시점 값설정
	 * 
	 * <p>
	 * `FRST_REGIST_PNTTM` datetime DEFAULT NULL COMMENT '최초등록시점',
	 * </p>
	 * 
	 * @param frstRegistPnttm
	 */
	public void setFrstRegistPnttm(LocalDateTime frstRegistPnttm) {
		this.frstRegistPnttm = frstRegistPnttm;
	}

	/**
	 * 최초등록자ID 값읽기
	 * 
	 * <p>
	 * `FRST_REGISTER_ID` varchar(20) DEFAULT NULL COMMENT '최초등록자ID',
	 * </p>
	 * 
	 * @return
	 */
	public String getFrstRegisterId() {
		return frstRegisterId;
	}

	/**
	 * 최초등록자ID 값설정
	 * 
	 * <p>
	 * `FRST_REGISTER_ID` varchar(20) DEFAULT NULL COMMENT '최초등록자ID',
	 * </p>
	 * 
	 * @param frstRegisterId
	 */
	public void setFrstRegisterId(String frstRegisterId) {
		this.frstRegisterId = frstRegisterId;
	}

	/**
	 * 최종수정시점 값읽기
	 * 
	 * <p>
	 * `LAST_UPDT_PNTTM` datetime DEFAULT NULL COMMENT '최종수정시점',
	 * </p>
	 * 
	 * @return
	 */
	public LocalDateTime getLastUpdtPnttm() {
		return lastUpdtPnttm;
	}

	/**
	 * 최종수정시점 값설정
	 * 
	 * <p>
	 * `LAST_UPDT_PNTTM` datetime DEFAULT NULL COMMENT '최종수정시점',
	 * </p>
	 * 
	 * @param lastUpdtPnttm
	 */
	public void setLastUpdtPnttm(LocalDateTime lastUpdtPnttm) {
		this.lastUpdtPnttm = lastUpdtPnttm;
	}

	/**
	 * 최종수정자ID 값읽기
	 * 
	 * <p>
	 * `LAST_UPDUSR_ID` varchar(20) DEFAULT NULL COMMENT '최종수정자ID',
	 * </p>
	 * 
	 * @return
	 */
	public String getLastUpdusrId() {
		return lastUpdusrId;
	}

	/**
	 * 최종수정자ID 값설정
	 * 
	 * <p>
	 * `LAST_UPDUSR_ID` varchar(20) DEFAULT NULL COMMENT '최종수정자ID',
	 * </p>
	 * 
	 * @param lastUpdusrId
	 */
	public void setLastUpdusrId(String lastUpdusrId) {
		this.lastUpdusrId = lastUpdusrId;
	}

}
