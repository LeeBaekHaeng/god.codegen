package egovframework.com.cop.bbs.repositories;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 게시판
 * 
 * @author 이백행
 * @since 2024-02-09
 *
 */
@Entity
@Table(name = "comtnbbs")
@Getter
@NoArgsConstructor
public class ComTnBbs {

	/**
	 * `NTT_ID` decimal(20,0) NOT NULL COMMENT '게시물ID',
	 */
	@Id
	@Column(name = "NTT_ID")
	private long nttId;

	/**
	 * `BBS_ID` char(30) NOT NULL COMMENT '게시판ID',
	 */
	@Column(name = "BBS_ID")
	private String bbsId;

	/**
	 * `NTT_NO` decimal(20,0) DEFAULT NULL COMMENT '게시물번호',
	 */
	@Column(name = "NTT_NO")
	private Long nttNo;

	/**
	 * `NTT_SJ` varchar(2000) DEFAULT NULL COMMENT '게시물제목',
	 */
	@Column(name = "NTT_SJ")
	private String nttSj;

	/**
	 * `NTT_CN` mediumtext DEFAULT NULL COMMENT '게시물내용',
	 */
	@Column(name = "NTT_CN")
	private String nttCn;

	/**
	 * `FRST_REGIST_PNTTM` datetime NOT NULL COMMENT '최초등록시점',
	 */
	@Column(name = "FRST_REGIST_PNTTM")
	private LocalDateTime frstRegistPnttm;

	/**
	 * 
	 * @param nttId
	 * @param bbsId
	 * @param nttNo
	 * @param nttSj
	 * @param nttCn
	 * @param frstRegistPnttm
	 */
	@Builder
	public ComTnBbs(final long nttId, final String bbsId, final Long nttNo, final String nttSj, final String nttCn,
			LocalDateTime frstRegistPnttm) {
		super();
		this.nttId = nttId;
		this.bbsId = bbsId;
		this.nttNo = nttNo;
		this.nttSj = nttSj;
		this.nttCn = nttCn;
		this.frstRegistPnttm = frstRegistPnttm;
	}

}
