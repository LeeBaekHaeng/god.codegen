package egovframework.com.repositories;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.hibernate.annotations.Comment;

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
@IdClass(ComTnBbsId.class)

@org.hibernate.annotations.Table(appliesTo = "comtnbbs", comment = "게시판")

@Getter
@NoArgsConstructor
public class ComTnBbs {

	/**
	 * `NTT_ID` decimal(20,0) NOT NULL COMMENT '게시물ID',
	 */
	@Id
	@Column(name = "NTT_ID", unique = true, nullable = false, precision = 20, scale = 0)
	@Comment("게시물ID")
	private long nttId;

	/**
	 * `BBS_ID` char(30) NOT NULL COMMENT '게시판ID',
	 */
	@Id
	@Column(name = "BBS_ID", unique = true, nullable = false, length = 30)
	@Comment("게시판ID")
	private String bbsId;

	/**
	 * `NTT_NO` decimal(20,0) DEFAULT NULL COMMENT '게시물번호',
	 */
	@Column(name = "NTT_NO", precision = 20, scale = 0)
	@Comment("게시물번호")
	private Long nttNo;

	/**
	 * `NTT_SJ` varchar(2000) DEFAULT NULL COMMENT '게시물제목',
	 */
	@Column(name = "NTT_SJ", length = 2000)
	@Comment("게시물제목")
	private String nttSj;

	/**
	 * `NTT_CN` mediumtext DEFAULT NULL COMMENT '게시물내용',
	 */
	@Column(name = "NTT_CN")
	@Comment("게시물내용")
	private String nttCn;

	/**
	 * `FRST_REGIST_PNTTM` datetime NOT NULL COMMENT '최초등록시점',
	 */
	@Column(name = "FRST_REGIST_PNTTM", nullable = false)
	@Comment("최초등록시점")
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
			final LocalDateTime frstRegistPnttm) {
		super();
		this.nttId = nttId;
		this.bbsId = bbsId;
		this.nttNo = nttNo;
		this.nttSj = nttSj;
		this.nttCn = nttCn;
		this.frstRegistPnttm = frstRegistPnttm;
	}

}
